package com.tarena.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** 相对位置布局管理 */
public class LayoutDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("相对位置布局管理");
    //整体内容面板
    JPanel content = new JPanel(new BorderLayout());
    //下部按钮面板
    JPanel btnPane = new JPanel(new BorderLayout());
    //右侧按钮面板
    JPanel right = new JPanel(new FlowLayout());
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");
    right.add(ok);
    right.add(cancel);
    btnPane.add(BorderLayout.EAST, right);
    content.add(BorderLayout.SOUTH, btnPane);
    frame.setContentPane(content);
    frame.setSize(500,400);
    frame.setVisible(true);
  }

}






