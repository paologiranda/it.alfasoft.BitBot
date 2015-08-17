package it.alfasoft.ecommerce.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public abstract class SpringTest<TIPO> {
	protected ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "FactoryBO.xml" });
	
	protected TIPO getBean(String nomeBean){
		return (TIPO) ctx.getBean(nomeBean);
	}
	
}
