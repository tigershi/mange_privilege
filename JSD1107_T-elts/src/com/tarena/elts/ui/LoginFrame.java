package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/** 登录界面 */
public class LoginFrame extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = -7993721800179709451L;
  
  public LoginFrame() {
    init();
  }
  /** 用于初始化全部的界面控件, 画出登录界面 */
  private void init(){
    setTitle("在线考试系统");
    setContentPane(createContentPane());
    setSize(300,200);
  }
  private JPanel createContentPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(new EmptyBorder(8,8,8,8));
    p.add(BorderLayout.NORTH, 
        new JLabel("登录系统", JLabel.CENTER));
    p.add(BorderLayout.CENTER, createCenterPane());
    p.add(BorderLayout.SOUTH, createBtnPane());
    return p;
  }
  private JPanel createCenterPane() {
    JPanel p = new JPanel(new BorderLayout());
    p.add(BorderLayout.NORTH, createIdPwdPane());
    return p;
  }
  private JPanel createIdPwdPane(){
    JPanel p = new JPanel(new GridLayout(2, 1, 0, 6));
    p.setBorder(new EmptyBorder(8,8,8,8));
    p.add(createIdPane());
    p.add(createPwdPane());
    return p;
  }
  private JPanel createIdPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.add(BorderLayout.WEST, new JLabel("编号:"));
    idField = new JTextField();
    p.add(BorderLayout.CENTER, idField);
    return p;
  }
  private JPanel createPwdPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.add(BorderLayout.WEST, new JLabel("密码:"));
    pwdField = new JPasswordField();
    pwdField.enableInputMethods(true);
    p.add(BorderLayout.CENTER, pwdField);
    return p;
  }
  
  private JPanel createBtnPane(){
    JPanel p = new JPanel(new FlowLayout());
    JButton login = new JButton("登录");
    JButton cancel = new JButton("取消");
    p.add(login);
    p.add(cancel);
    
    //默认按钮可以相应回车请求
    getRootPane().setDefaultButton(login);
    
    login.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        //这个方法在login按钮点击时候执行
        //System.out.println("哎呦!");
        //登录逻辑...
        //clientContext 客户端上下文对象的引用, 
        //是充当界面控制器角色, 控制器中提供"登录控制"方法
        clientContext.login();
      }
    });
    cancel.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        clientContext.exit(LoginFrame.this);
      }
    });
    return p;
  }
 
  private ClientContext clientContext;
  private JTextField idField;
  private JPasswordField pwdField;
  public void setClientContext(ClientContext c){
    clientContext = c;
  }
  public int getUserId() {
    String id=idField.getText();
//    if(id.matches(regex)){
//      throw ...
//    }
    return Integer.parseInt(id); 
  }
  public String getPwd() {
    char[] pwd = pwdField.getPassword();
    return new String(pwd); 
  }
}






