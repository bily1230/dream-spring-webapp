import com.dream.spring.controller.HelloWord;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import  org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


/**
 * Created by ning on 2017/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("com.dream.spring.controller")
//@ContextConfiguration({"classpath*:/applicationContext.xml" })
@ContextConfiguration(classes = {WebConfig.class,RootConfig.class})
public class ControllerTest {

    MockMvc mockMvc;
    @Autowired
    HelloWord helloWord;

    @Before
    public void setUp(){
        mockMvc = standaloneSetup(helloWord).build();
    }
    @Test
    public void testHomePage() throws Exception {

   mockMvc.perform(MockMvcRequestBuilders.get("/helloWord/521521/readWord?name=lihan")
                .param("age","14"))
           .andExpect(view().name("return"))
           .andExpect(model().attribute("name","小寒"));



    }
}
