import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/resources/spring/applicationContext.xml"})
public class MysqlConnectionTest {

    @Inject
    private DataSource ds;
    @Inject
    private SqlSessionFactory ssf;

    @Test
    public void testConnection() throws Exception {
        try(Connection conn = ds.getConnection()) {
            System.out.println("DB Connection Success : " + conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFactory() throws Exception{
        try(SqlSession session = ssf.openSession()) {
            System.out.println("Create factory : " + session);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
