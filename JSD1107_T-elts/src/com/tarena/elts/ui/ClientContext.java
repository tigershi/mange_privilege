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
  //����ǰ���ڻش����Ŀ
  private QuestionInfo questionInfo;
  private ExamInfo examInfo;
  
  //����ע��,��������ע��: IOC 
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
      //�ҵ��û�ID������
      int id = loginFrame.getUserId();
      String pwd = loginFrame.getPwd();
      //����ID�������¼
      User user = examService.login(id, pwd);
      //�����¼�ɹ�, ��loginFrame, ��menuFrame
      loginFrame.setVisible(false); 
      //���½�������, ��ʾ��¼�û���Ϣ
      menuFrame.updateView(user);
      center(menuFrame);
      menuFrame.setVisible(true);
    }catch(IdOrPwdException e){
      e.printStackTrace();
      //���ʧ��: �ڵ�¼��������ʾʧ��ԭ��
      JOptionPane.showMessageDialog(
          loginFrame, e.getMessage());
    }catch (NumberFormatException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          loginFrame, "�û�������������");
    }catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          loginFrame, "������!"+e);
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
   * �˳�ϵͳ
   * @param from ���Ǹ�������õ��˳�
   */
  public void exit(JFrame from) {
    int val= JOptionPane.showConfirmDialog(
        from, "ȷ���˳���?");
    if(val==JOptionPane.YES_OPTION){
      from.setVisible(false);
      System.exit(0);
    }
  }
  public void start() {
    try {
      //����ҵ��㿪ʼ����
      examInfo = examService.start();
      //ȡ�õ�һ����, ������ʾ����
      questionInfo = examService.getQuestion(0);
      //���¿��Խ���
      examFrame.updateView(examInfo, questionInfo);
      //�رղ˵�,
      menuFrame.setVisible(false);
      //�򿪿��Խ���
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
      //�ڿ��Խ�����,��ȡ��ǰ�û�ѡ��Ĵ�
      List<Integer> userAnswers = 
        examFrame.getUserAnswers();
      //index ��ǰ������
      int index = questionInfo.getQuestionIndex();
      //���𰸷��͵�ҵ���洢
      examService.saveUserAnswers(userAnswers, index);
      //���ݵ�ǰ���ȡ����һ��Ŀ
      questionInfo = examService.getQuestion(index+1);
      //���¿��Խ���Ϊ��һ��      
      examFrame.updateView(examInfo, questionInfo);
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
  /** ���� */
  public void send() { 
    int val = JOptionPane.showConfirmDialog(
        examFrame, "��ľ�д��㽻��?");
    if(val!=JOptionPane.YES_OPTION){
      return;
    }
    gameOver();
  }
  
  public void gameOver() { 
    try {
      
      int index = questionInfo.getQuestionIndex();
      //��ȡ�����û���
      List<Integer> userAnswers = 
        examFrame.getUserAnswers();
      //�����û���
      examService.saveUserAnswers(userAnswers, index);
      //������
      int score = examService.send();
      //��ʾ����
      JOptionPane.showMessageDialog(
          examFrame, "����:"+score);
      //�رտ��Խ���
      examFrame.setVisible(false);
      //���ز˵�����
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
      //�ڿ��Խ�����,��ȡ��ǰ�û�ѡ��Ĵ�
      List<Integer> userAnswers = 
        examFrame.getUserAnswers();
      //index ��ǰ������
      int index = questionInfo.getQuestionIndex();
      //���𰸷��͵�ҵ���洢
      examService.saveUserAnswers(userAnswers, index);
      //���ݵ�ǰ���ȡ����һ��Ŀ, �滻��ǰ��Ŀ
      questionInfo = examService.getQuestion(index-1);
      //���¿��Խ���Ϊ��һ��      
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
          menuFrame, "����:"+score);
      
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
          menuFrame, "���Թ��򣺢����Ǻ�ѧ�����������ף�");	      
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
    //toolkit ����ǰ��ͼϵͳ�Ĺ��߷�������
    Dimension screen = toolkit.getScreenSize();
    int w = win.getWidth();
    int h = win.getHeight();
    int x = (screen.width - w)/2;
    int y = (screen.height- h)/2;
    win.setLocation(x, y);   
  }
  
}







