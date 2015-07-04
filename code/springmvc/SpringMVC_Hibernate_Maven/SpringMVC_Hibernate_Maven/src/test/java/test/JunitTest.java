/**   
 * @Title: JunitTest.java 
 * @Package com.test 
 * @Description:
 * @author ¡ı∫∆
 * @date 2015-4-17 …œŒÁ10:22:03 
 * @version V1.0   
 */
package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lh.util.log.LHLog;
import com.mvc.domain.User;
import com.mvc.service.iface.LoginService;

/** 
 * @ClassName: JunitTest 
 * @Description: Junitµ•‘™≤‚ ‘
 * @author ¡ı∫∆
 * @date 2015-4-17 …œŒÁ10:22:03 
 *  
 */
//@ContextConfiguration(locations={"/spring/applicationContext.xml"})
@ContextConfiguration(locations={"/spring/*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class JunitTest {
	@Autowired
	private LoginService loginService;
	@Test
	public void testLogin(){
		LHLog.info("ccccc");
		User user=new User();
		user.setUserName("admin");
		user.setPassword("111111");
		user.setAge(11);
//		System.out.println(loginService.login(user));
		
		try {
			loginService.deleteUserByUserId(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
