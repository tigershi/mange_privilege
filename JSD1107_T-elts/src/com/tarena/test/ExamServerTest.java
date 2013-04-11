package com.tarena.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.tarena.elts.net.Request;
import com.tarena.elts.net.Response;
import com.tarena.elts.net.Utils;

public class ExamServerTest {
  public static void main(String[] args) 
    throws Exception {
    //建立连接
    Socket socket = new Socket("localhost", 9091);
    //建立建立-发送请求-接收响应-断开连接
    ObjectOutputStream out = 
       new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream in = 
      new ObjectInputStream(socket.getInputStream());
    
    Request request = new Request("login", 
        new Class[]{int.class, String.class},
        new Object[]{1001, "12345"});
    out.writeObject(request);//发送请求
    Response r = (Response)in.readObject(); //接收响应
    socket.close();// 断开连接;
    System.out.println(request);
    System.out.println(r);//人名
  }

}
