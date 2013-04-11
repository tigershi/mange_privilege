package com.tarena.test;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageFrameDemo {
  public static void main(String[] args) {
    //JFrame �Ǵ��ڿ�
    JFrame frame = new JFrame("Image Frame");
    //JPanel �Ƿ��ڽ���ؼ����������
    JPanel pane = new JPanel();
    //JLabel ������ʾͼƬ/���ֵĽ���ؼ�
    JLabel label = new JLabel();
    //Class �����з���getResource() ����������Ի�������
    //��ǰ�����Դ(��: ͼƬ), ����img.png��ImageFrameDemo.class
    //��ͬһ����, ʹ�õ������·��, Ҳ����ʹ�þ���·��:
    //����·���Ӱ��ĸ���ʼ,��: /com/tarena/test/img.png
    //ͳһ��Դ��λ(��Դ��λ��)
    URL url=ImageFrameDemo.class.getResource("img.png");
    //ImageIcon ͼƬ����
    ImageIcon img = new ImageIcon(url);
    label.setIcon(img);
    pane.add(label);
    frame.setContentPane(pane);
    frame.setSize(384,175+30);
    frame.setVisible(true);
    
  }

}




