import com.dream.spring.controller.HelloJava;
import com.dream.spring.controller.HelloWord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ning on 2017/8/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class HelloWordTest {

    /**
     * @Autowired 在自动注入时，若一个类注入两次，就要匹配名称才能实现注入
     */
    @Autowired
    private HelloWord hello;



    @Test
    public void helloWord(){
        hello.readWord();
    }

}
