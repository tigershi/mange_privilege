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
 
/** 主菜单界面 */
public class MenuFrame extends JFrame{
  private static final long serialVersionUID = 
    -1796834130339697339L;
  
  public MenuFrame() {
    init();
  }
 
  private void init(){
    setTitle("在线考试系统");
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
        new JLabel("作者:刘旭--版权所有 盗版必究",
            JLabel.RIGHT ));
       
    return pane;
  }
  private JPanel  createMenuPane(){
    JPanel pane = new JPanel(new BorderLayout());
    //务必将info 引用到界面控件对象
    JLabel info = 
      new JLabel("XXX 同学您好!", JLabel.CENTER);
 
    userInfo = info;
    
    pane.add(BorderLayout.NORTH, info);
    pane.add(BorderLayout.CENTER,createBtnPane());
       
    return pane;
  }
  private JPanel  createBtnPane(){
    JPanel pane = new JPanel(new FlowLayout());
    JButton start = createImgBtn("exam.png", "开始");
    JButton result = createImgBtn("result.png", "分数");
    JButton msg = createImgBtn("message.png", "考试规则");
    JButton exit = createImgBtn("exit.png", "离开");
 
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
  // 创建图片按钮的方法
  private JButton createImgBtn(
      String img, String txt) {
    ImageIcon ico = new ImageIcon(
        getClass().getResource(img));
    
    JButton button = new JButton(txt, ico);
    //button.setIcon(ico);
    //垂直文本对齐位置
    button.setVerticalTextPosition(
        JButton.BOTTOM);
//  水平文本对齐位置
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
    String str = "欢迎:"+user +" 参加本次盛大的考试!";
    userInfo.setText(str);
  }
  
  
 
}
