package com.tarena.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.tarena.elts.net.Request;
import com.tarena.elts.net.Response;

public class ClientDemo {
  public static void main(String[] args) {
    try {
//    ��������
      Socket s = new Socket("localhost", 9091);
      //��������-������Ӧ-�Ͽ�����
      ObjectOutputStream out = 
        new ObjectOutputStream(s.getOutputStream());
      Request req = new Request("login", 
          new Class[]{int.class, String.class}, 
          new Object[]{1001, "1234"});
      out.writeObject(req);
      //������Ӧ
      ObjectInputStream in = 
        new ObjectInputStream(s.getInputStream());
      Response res=(Response)in.readObject();
      //�Ͽ�����
      s.close();
      System.out.println(res);
    } catch ( Exception e) {
      e.printStackTrace();
    }
    
  }
}
