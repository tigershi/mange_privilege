package com.tarena.elts.client;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.ui.ClientContext;
import com.tarena.elts.ui.ExamFrame;
import com.tarena.elts.ui.LoginFrame;
import com.tarena.elts.ui.MenuFrame;
import com.tarena.elts.ui.WelcomeWindow;
import com.tarena.util.Config;

/**
 * 软件的入口
 *  */
public class Main {
  public static void main(String[] args) {
    //配置文件
    Config config = new Config("client.properties");
    //界面层= 视图+控制器
    //视图
    LoginFrame loginFrame = new LoginFrame();
    MenuFrame menuFrame = new MenuFrame();
    ExamFrame examFrame = new ExamFrame();
    WelcomeWindow welcomeWindow = new WelcomeWindow();
    //控制器
    ClientContext clientContext = new ClientContext();
    
    //业务模型
    ExamServiceImpl examService = new ExamServiceImpl();
    
    //数据层
    EntityContext entityContext = 
      new EntityContext(config);
    //组装 界面层 业务层 和 数据层
    loginFrame.setClientContext(clientContext);
    menuFrame.setClientContext(clientContext);
    examFrame.setClientContext(clientContext);
    
    clientContext.setExamFrame(examFrame);
    clientContext.setLoginFrame(loginFrame);
    clientContext.setMenuFrame(menuFrame);
    clientContext.setWelcomeWindow(welcomeWindow);
//  插接 examService 到 表现层控制器
    clientContext.setExamService(examService);
    
    examService.setEntityContext(entityContext);
    //启动软件
    clientContext.show();
  }

}



