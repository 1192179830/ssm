//使用Spring测试模块中的MVC模式

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LimitPageTest {
    //传入SpringMVC的ioc
    @Autowired
    WebApplicationContext context;
    //虚拟MVC请求
    MockMvc mockMvc;

    @Before
    public void initMockMvc(){
     mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public void testPage(){
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn","1")).andReturn();
            System.out.println(mvcResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

