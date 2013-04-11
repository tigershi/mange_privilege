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
//    建立连接
      Socket s = new Socket("localhost", 9091);
      //发送请求-接收响应-断开连接
      ObjectOutputStream out = 
        new ObjectOutputStream(s.getOutputStream());
      Request req = new Request("login", 
          new Class[]{int.class, String.class}, 
          new Object[]{1001, "1234"});
      out.writeObject(req);
      //接收响应
      ObjectInputStream in = 
        new ObjectInputStream(s.getInputStream());
      Response res=(Response)in.readObject();
      //断开连接
      s.close();
      System.out.println(res);
    } catch ( Exception e) {
      e.printStackTrace();
    }
    
  }
}
