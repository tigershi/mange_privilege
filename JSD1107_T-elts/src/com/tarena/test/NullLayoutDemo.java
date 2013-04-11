package com.tarena.test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** 空布局演示 */
public class NullLayoutDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("空布局演示");
    JPanel panel = new JPanel();
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");
    frame.setContentPane(panel);
    panel.add(ok);
    panel.add(cancel);
    panel.setLayout(null);//取消默认布局, 使用自定义布局
    //自定义布局(大小和位置), 绝对位置布局
    frame.setSize(495, 341);
    ok.setLocation(288,276);
    ok.setSize(90, 20);
    cancel.setLocation(386,276);
    cancel.setSize(90, 20);
    frame.setVisible(true);
  }

}
