package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.elts.entity.User;
 
/** ���˵����� */
public class MenuFrame extends JFrame{
  private static final long serialVersionUID = 
    -1796834130339697339L;
  
  public MenuFrame() {
    init();
  }
 
  private void init(){
    setTitle("���߿���ϵͳ");
    setSize(600,400);
    setContentPane(createContentPane());
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter(){
      @Override
      public void windowClosing(WindowEvent e) {
        clientContext.exit(MenuFrame.this);
      }
    });
  }

  private JPanel createContentPane(){
    JPanel pane = new JPanel(new BorderLayout());
    
    ImageIcon icon = new ImageIcon(
        getClass().getResource("title.png"));      
    pane.add(BorderLayout.NORTH,new JLabel(icon));
    
    pane.add(BorderLayout.CENTER,createMenuPane());
    
    pane.add(BorderLayout.SOUTH, 
        new JLabel("����:����--��Ȩ���� ����ؾ�",
            JLabel.RIGHT ));
       
    return pane;
  }
  private JPanel  createMenuPane(){
    JPanel pane = new JPanel(new BorderLayout());
    //��ؽ�info ���õ�����ؼ�����
    JLabel info = 
      new JLabel("XXX ͬѧ����!", JLabel.CENTER);
 
    userInfo = info;
    
    pane.add(BorderLayout.NORTH, info);
    pane.add(BorderLayout.CENTER,createBtnPane());
       
    return pane;
  }
  private JPanel  createBtnPane(){
    JPanel pane = new JPanel(new FlowLayout());
    JButton start = createImgBtn("exam.png", "��ʼ");
    JButton result = createImgBtn("result.png", "����");
    JButton msg = createImgBtn("message.png", "���Թ���");
    JButton exit = createImgBtn("exit.png", "�뿪");
 
    pane.add(start);
    pane.add(result);
    pane.add(msg);
    pane.add(exit);
    result.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        clientContext.result();
      }
      
    });
    //Tracy
    msg.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
          clientContext.msg();
        }
        
      });
    exit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        clientContext.exit(MenuFrame.this);
      }
    });
    
    start.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        clientContext.start();
      }
    });
    return pane;
  }
  // ����ͼƬ��ť�ķ���
  private JButton createImgBtn(
      String img, String txt) {
    ImageIcon ico = new ImageIcon(
        getClass().getResource(img));
    
    JButton button = new JButton(txt, ico);
    //button.setIcon(ico);
    //��ֱ�ı�����λ��
    button.setVerticalTextPosition(
        JButton.BOTTOM);
//  ˮƽ�ı�����λ��
    button.setHorizontalTextPosition(
        JButton.CENTER);

    return button;
  }

  private JLabel userInfo;
  private ClientContext clientContext;
  
  public void setClientContext(ClientContext clientContext) {
    this.clientContext = clientContext;
  }
  public void updateView(User user) {
    String str = "��ӭ:"+user +" �μӱ���ʢ��Ŀ���!";
    userInfo.setText(str);
  }
  
  
 
}
