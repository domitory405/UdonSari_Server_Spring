package kr.domi.udonsari.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.domi.udonsari.dto.MemberDto;
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

    @Override
    public String createToken(MemberDto member) {
        Map<String, Object> map = new HashMap<>();
        map.put("userIdx", member.getUser_idx());
        map.put("uid", member.getUid());

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(member.getSalt());
        Key signInKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

        try {
            String token = Jwts.builder()
                    .setHeaderParam("typ", "JWT")
                    .setHeaderParam("alg", "...")
                    .setExpiration(getExpireDate())
                    .setClaims(map)
                    .signWith(SignatureAlgorithm.HS256, signInKey)
                    .compact();
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Date getExpireDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        //한달 24*31
        cal.add(Calendar.HOUR, 744);
        return cal.getTime();
    }
}
