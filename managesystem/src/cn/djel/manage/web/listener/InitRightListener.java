package cn.djel.manage.web.listener;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
@Component
public class InitRightListener implements ServletContextAware, ApplicationListener<ContextRefreshedEvent>{
   Logger log = Logger.getLogger(InitRightListener.class);
	private ServletContext context;
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		log.info("begin load the all of rights");
		// TODO Auto-generated method stub
		context.setAttribute("rall_rights_map", "sss");
		log.info("end load the all of rights");
	}

	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.context = arg0;
	}
   
}
