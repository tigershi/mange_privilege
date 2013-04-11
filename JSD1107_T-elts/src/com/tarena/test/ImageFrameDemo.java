package com.tarena.test;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageFrameDemo {
  public static void main(String[] args) {
    //JFrame 是窗口框
    JFrame frame = new JFrame("Image Frame");
    //JPanel 是放在界面控件的容器面板
    JPanel pane = new JPanel();
    //JLabel 用于显示图片/文字的界面控件
    JLabel label = new JLabel();
    //Class 对象有方法getResource() 这个方法可以获得相对于
    //当前类的资源(如: 图片), 这里img.png与ImageFrameDemo.class
    //在同一包里, 使用的是相对路径, 也可以使用绝对路径:
    //绝对路径从包的跟开始,如: /com/tarena/test/img.png
    //统一资源定位(资源的位置)
    URL url=ImageFrameDemo.class.getResource("img.png");
    //ImageIcon 图片类型
    ImageIcon img = new ImageIcon(url);
    label.setIcon(img);
    pane.add(label);
    frame.setContentPane(pane);
    frame.setSize(384,175+30);
    frame.setVisible(true);
    
  }

}




