import com.ybzn.dao.DepartmentMapper;
import com.ybzn.dao.EmployeeMapper;
import com.ybzn.pojo.Department;
import com.ybzn.pojo.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

//使用Spring单元测试,SptringTest
//2.@ContextConfiguration指定Spring配置文件中的位置
//3.直接autowide了
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
//    @Autowired
//    DepartmentMapper departmentMapper;
        SqlSessionTemplate sqlSessionTemplate;
//        @Autowired
        SqlSession sqlSession;
//        SqlSessionFactory
//    调试Depatment
    @Test
    public void testCRUD(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapper bean = context.getBean(DepartmentMapper.class);
        System.out.println("asd");
        Department department =new Department(null,"李梦杰");
        System.out.println(bean.insert(department));
        Department department1 = bean.selectByPrimaryKey(2);
        System.out.println(bean.insert(new Department(null,"开发")));
        System.out.println(department1.getDeptId()+":李"+department1.getDeptName());
    }

    @Test
    public void addList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapper bean = context.getBean(DepartmentMapper.class);
//        SqlSession sqlSession = SqlSessionFactoryBean
        EmployeeMapper mapper = context.getBean(EmployeeMapper.class);
//        mapper.
        for (int i = 0; i <1000; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 5)+""+i;
            mapper.insertSelective(new Employee(null,uuid,"M","@kuang",3));
        }
    }
}
