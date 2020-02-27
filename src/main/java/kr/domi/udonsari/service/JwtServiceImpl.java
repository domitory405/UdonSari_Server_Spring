package kr.domi.udonsari.service;

import io.jsonwebtoken.*;
import kr.domi.udonsari.dto.MemberDto;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService{

    @Value("#{jwtConfig['jwt.secret']}")
    private String key;

    /*
    * token 생성
    * @param MemberDto
    * @return token
    * */
    @Override
    public String createToken(MemberDto member) {
        Map<String, Object> map = new HashMap<>();
        map.put("userIdx", member.getUserIdx());
        map.put("uid", member.getUid());

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signInKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
        
        try {
            System.out.println("외않되");
            String token = Jwts.builder()
                    .setHeaderParam("typ", "JWT")
                    .setHeaderParam("alg", "HS256")
                    .setExpiration(getExpireDate())
                    .setClaims(map)
                    .signWith(SignatureAlgorithm.HS256, signInKey)
                    .compact();
            System.out.println(token);
            return token;
        } catch (Exception e) {
            System.out.println("혹시..");
            e.printStackTrace();
            return null;
        }
    }

    private Date getExpireDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        //한달 24*31
        cal.add(Calendar.HOUR, 744);
        return cal.getTime();
    }

    /*
    * token 해독
    * @param token
    * @return idx
    * */
    @Override
    public boolean checkToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key))
                    .parseClaimsJws(token).getBody();
            System.out.println("expireDate : " + claims.getExpiration());
            System.out.println("id, idx : " + claims.get("uid") + ", " + claims.get("userIdx"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

//        catch (ExpiredJwtException e) {
//            e.printStackTrace();
//            System.out.println("토큰 만료");
//            return false;
//        } catch (JwtException e) {
//            e.printStackTrace();
//            System.out.println("토큰 변조");
//            return false;
//        }
    }

    @ToString
    public static class TokenRes {
        private String token;
        private int userIdx;

        public TokenRes(String token, int userIdx) {
            this.token = token;
            this.userIdx = userIdx;
        }
    }
}
