import com.dream.spring.controller.HelloWord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


/**
 * Created by ning on 2017/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ControllerTest {

	
    @Test
    public void testHomePage(){
        HelloWord helloWord = new HelloWord();
        MockMvc mockMvc = standaloneSetup(helloWord).build();
        mockMvc.perform(get("/helloWord/readWord"))
                .andExpect(view().name("return"));
    }
}
