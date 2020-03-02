package kr.domi.udonsari.controller;

import kr.domi.udonsari.dto.MemberDto;
import kr.domi.udonsari.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping(value="udon")
public class UdonController {

    @Autowired
    RestTemplate restTemplate;

    @Value("#{restConfig['openapi.key']}")
    private String apiKey;


    @GetMapping(value="/")
    public String CheckRegion(@RequestBody final HashMap<String, Object> map) {
        
        StringBuffer url = new StringBuffer("http://api.vworld.kr/req/data?service=data" +
                "&request=GetFeature" +
                "&data=LT_C_ADSIGG_INFO" +
                "&key="+ apiKey +
                "&domain=");

        //User 위치 정보 받아서 -> api 호출, 지역 코드
        url.append("http://localhost:7979");
        url.append("&geomFilter="+map.get("addr"));
//        url.append("&attrFilter=sig_kor_nm:like:구");
        url.append("&crs=EPSG:4326");

        System.out.println(url);

        String obj = restTemplate.getForObject(url.toString(), String.class);

        System.out.println(obj);
        return obj;
    }
}
