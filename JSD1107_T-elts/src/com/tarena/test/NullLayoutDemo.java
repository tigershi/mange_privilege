package com.tarena.test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** �ղ�����ʾ */
public class NullLayoutDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("�ղ�����ʾ");
    JPanel panel = new JPanel();
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");
    frame.setContentPane(panel);
    panel.add(ok);
    panel.add(cancel);
    panel.setLayout(null);//ȡ��Ĭ�ϲ���, ʹ���Զ��岼��
    //�Զ��岼��(��С��λ��), ����λ�ò���
    frame.setSize(495, 341);
    ok.setLocation(288,276);
    ok.setSize(90, 20);
    cancel.setLocation(386,276);
    cancel.setSize(90, 20);
    frame.setVisible(true);
  }

}
