import kr.domi.udonsari.utils.SHA256PasswordEncoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static kr.domi.udonsari.utils.SHA256PasswordEncoder.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/resources/spring/applicationContext.xml"})
public class EncryptTest {
    @Test
    public void EncryptionTest() {
        String salt = generateSalt();
        String pwd = encrypt("ook_sak", salt.getBytes());
        String pwd2 = encrypt("ook_sak", salt.getBytes());

        System.out.println("salt : " + salt + ", pwd : " + pwd);
        System.out.println("pwd2 : " + pwd2);
    }
}
