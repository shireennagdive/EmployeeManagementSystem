 import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.IService;
import com.cg.MyServiceImpl;

public class Application {
public static void main(String[] args) {
	ApplicationContext appContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
	System.out.println(appContext1);
	
	ApplicationContext appContext2 = new ClassPathXmlApplicationContext("applicationContext.xml");
	System.out.println(appContext2);
	
	System.out.println("length : "+((String)appContext1.getBean("message")).length());
	System.out.println();
	
	IService service = (MyServiceImpl) appContext1.getBean("myService");
	System.out.println(service.getMessages());
}
}
