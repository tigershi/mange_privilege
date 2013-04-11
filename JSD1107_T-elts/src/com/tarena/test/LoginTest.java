package com.tarena.test;

import java.util.List;

import javax.swing.JLabel;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;
import com.tarena.elts.ui.ClientContext;
import com.tarena.elts.ui.LoginFrame;
import com.tarena.elts.ui.MenuFrame;

/** 登录实现测试 */
public class LoginTest {
  public static void main(String[] args) {
    LoginFrame loginFrame = new LoginFrame();
    MenuFrame menuFrame = new MenuFrame();
    ClientContext clientContext = new ClientContext();
    ExamService examService = new ExamServiceTest();
    
    loginFrame.setClientContext(clientContext);
    menuFrame.setClientContext(clientContext);
    clientContext.setExamService(examService);
    clientContext.setLoginFrame(loginFrame);
    clientContext.setMenuFrame(menuFrame);
    
    clientContext.show();
  }
  
  static class ExamServiceTest implements ExamService{
    public User login(int id, String pwd) 
      throws IdOrPwdException {
      if(id==7 && pwd.equals("1234")){
        User u = new User("邦德", 7, "1234");
        return u;
      }
      throw new IdOrPwdException("有木有!");
    }

    public QuestionInfo getQuestion(int index) {
      // TODO Auto-generated method stub
      return null;
    }
 
    public ExamInfo start() {
      
      return null;
    }

    public void saveUserAnswers(List<Integer> userAnswers, int index) {
      // TODO Auto-generated method stub
      
    }

    public int send() {
      // TODO Auto-generated method stub
      return 0;
    }
    
    public int getScore() {
      // TODO Auto-generated method stub
      return 0;
    }
  }

}
