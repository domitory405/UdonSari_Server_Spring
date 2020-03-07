package kr.domi.udonsari.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class UdonServiceImpl implements UdonService {

    @Autowired
    RestTemplate restTemplate;

    @Value("#{restConfig['openapi.key']}")
    private String apiKey;

    private StringBuffer url = new StringBuffer();
    private String code;

    public void urlInit(String gps) {
        url.setLength(0);
        url.append("http://api.vworld.kr/req/data?service=data" +
                "&request=GetFeature" +
                "&data=LT_C_ADSIGG_INFO" +
                "&key=" + apiKey +
                "&domain=http://localhost:7979");
        url.append("&geomFilter=" + gps);
        url.append("&crs=EPSG:4326");
        //        url.append("&attrFilter=sig_kor_nm:like:구");
    }

    @Override
    public String getRegCode(String gps) {
        //User 위치 정보 받아서 -> api 호출, 지역 코드
        urlInit(gps);

        System.out.println(url);

        try {
            //시군구 법정동 코드 API 호출
            String obj = restTemplate.getForObject(url.toString(), String.class);
            System.out.println(obj);

            //API 호출 결과값 parsing (다중 json이라 부득이하게.. 이모양 이꼴)
            JSONParser parser = new JSONParser();
            Object object = parser.parse(obj);
            JSONObject jsonObject = (JSONObject) object;
            JSONObject parse_response = (JSONObject) jsonObject.get("response");
            JSONObject parse_result = (JSONObject) parse_response.get("result");
            JSONObject parse_collection = (JSONObject) parse_result.get("featureCollection");
            JSONArray parse_features = (JSONArray) parse_collection.get("features");
            JSONObject parse_data = (JSONObject) parse_features.get(0);
            JSONObject parse_properties = (JSONObject) parse_data.get("properties");

            code = parse_properties.get("sig_cd").toString();
            return code;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
