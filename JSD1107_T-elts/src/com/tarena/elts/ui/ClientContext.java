package com.tarena.elts.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;

public class ClientContext implements Serializable {
  private static final long serialVersionUID = -7727538801413395438L;
  
  private LoginFrame loginFrame;
  private MenuFrame menuFrame;
  private ExamFrame examFrame;
  private WelcomeWindow welcomeWindow;
  private ExamService examService;
  //代表当前正在回答的题目
  private QuestionInfo questionInfo;
  private ExamInfo examInfo;
  
  //对象注入,就是依赖注入: IOC 
  public void setLoginFrame(LoginFrame loginFrame) {
    this.loginFrame = loginFrame;
  }
  
  public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
    this.welcomeWindow = welcomeWindow;
  }
  public void setExamService(ExamService examService) {
    this.examService = examService;
  }
  public void setMenuFrame(MenuFrame menuFrame) {
    this.menuFrame = menuFrame;
  }
  public void setExamFrame(ExamFrame examFrame){
    this.examFrame = examFrame;
  }
  
  public void login(){
    try{
      //找到用户ID和密码
      int id = loginFrame.getUserId();
      String pwd = loginFrame.getPwd();
      //利用ID和密码登录
      User user = examService.login(id, pwd);
      //如果登录成功, 关loginFrame, 开menuFrame
      loginFrame.setVisible(false); 
      //更新界面内容, 显示登录用户信息
      menuFrame.updateView(user);
      center(menuFrame);
      menuFrame.setVisible(true);
    }catch(IdOrPwdException e){
      e.printStackTrace();
      //如果失败: 在登录界面上提示失败原因
      JOptionPane.showMessageDialog(
          loginFrame, e.getMessage());
    }catch (NumberFormatException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          loginFrame, "用户名必须是整数");
    }catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          loginFrame, "其他错啊!"+e);
    }
  }
  public void show() { 
    center(welcomeWindow);
    welcomeWindow.setVisible(true);
    Timer timer = new Timer();
    timer.schedule(new TimerTask(){
      public void run() {
        welcomeWindow.setVisible(false);
        center(loginFrame);
        loginFrame.setVisible(true);
      }
    }, 2000);
    
  }
  /**    
   * 退出系统
   * @param from 从那个界面调用的退出
   */
  public void exit(JFrame from) {
    int val= JOptionPane.showConfirmDialog(
        from, "确定退出吗?");
    if(val==JOptionPane.YES_OPTION){
      from.setVisible(false);
      System.exit(0);
    }
  }
  public void start() {
    try {
      //访问业务层开始考试
      examInfo = examService.start();
      //取得第一道题, 用于显示考题
      questionInfo = examService.getQuestion(0);
      //更新考试界面
      examFrame.updateView(examInfo, questionInfo);
      //关闭菜单,
      menuFrame.setVisible(false);
      //打开考试界面
      center(examFrame);
      examFrame.setVisible(true);
      startTimer();
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          menuFrame, e.getMessage());
    }
  }
  
  public void next() {
    try {
      //在考试界面上,获取当前用户选择的答案
      List<Integer> userAnswers = 
        examFrame.getUserAnswers();
      //index 当前题的题号
      int index = questionInfo.getQuestionIndex();
      //将答案发送到业务层存储
      examService.saveUserAnswers(userAnswers, index);
      //根据当前题号取得下一题目
      questionInfo = examService.getQuestion(index+1);
      //更新考试界面为下一题      
      examFrame.updateView(examInfo, questionInfo);
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
  /** 交卷 */
  public void send() { 
    int val = JOptionPane.showConfirmDialog(
        examFrame, "有木有打算交卷?");
    if(val!=JOptionPane.YES_OPTION){
      return;
    }
    gameOver();
  }
  
  public void gameOver() { 
    try {
      
      int index = questionInfo.getQuestionIndex();
      //获取最后的用户答案
      List<Integer> userAnswers = 
        examFrame.getUserAnswers();
      //保存用户答案
      examService.saveUserAnswers(userAnswers, index);
      //交卷处理
      int score = examService.send();
      //显示分数
      JOptionPane.showMessageDialog(
          examFrame, "分数:"+score);
      //关闭考试界面
      examFrame.setVisible(false);
      //返回菜单界面
      center(menuFrame);
      menuFrame.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }

  public void prev() {
    try {
      //在考试界面上,获取当前用户选择的答案
      List<Integer> userAnswers = 
        examFrame.getUserAnswers();
      //index 当前题的题号
      int index = questionInfo.getQuestionIndex();
      //将答案发送到业务层存储
      examService.saveUserAnswers(userAnswers, index);
      //根据当前题号取得上一题目, 替换当前题目
      questionInfo = examService.getQuestion(index-1);
      //更新考试界面为上一题      
      examFrame.updateView(examInfo, questionInfo);
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }

  }
  public void result() {
    try{
      
      int score = examService.getScore();
      JOptionPane.showMessageDialog(
          menuFrame, "分数:"+score);
      
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          menuFrame, e.getMessage());
    }
  }
  
  //Tracy
  public void msg() {
    try{	      
      JOptionPane.showMessageDialog(
          menuFrame, "考试规则：①咱是好学生，不能作弊！");	      
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          menuFrame, e.getMessage());
    }
  }
  private Timer timer;
  private void startTimer(){
    timer = new Timer();
    long start = System.currentTimeMillis();
    final long end = examInfo.getTimeLimit()*60*1000+start;
    timer.schedule(new TimerTask(){
      @Override
      public void run() {
        long show = end - System.currentTimeMillis();
        long h = show/1000/60/60;
        long m = show/1000/60%60;
        long s = show/1000%60;
        examFrame.updateTime(h, m, s);
      }
    }, 0, 1000);
    timer.schedule(new TimerTask(){
      @Override
      public void run() {
        timer.cancel();
        gameOver();
      }
    }, new Date(end));
  }
  
  private void center(Window win){
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    //toolkit 代表当前绘图系统的工具方法集合
    Dimension screen = toolkit.getScreenSize();
    int w = win.getWidth();
    int h = win.getHeight();
    int x = (screen.width - w)/2;
    int y = (screen.height- h)/2;
    win.setLocation(x, y);   
  }
  
}







