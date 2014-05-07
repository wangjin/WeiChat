package tk.jimmywang.weichat.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/WEB-INF/spring/root-context.xml"})
public class ServiceTest {
	
	@Test  
    public void testSpring() {  
		System.out.println("");
    } 
}
