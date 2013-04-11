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
    //��������
    Socket socket = new Socket("localhost", 9091);
    //��������-��������-������Ӧ-�Ͽ�����
    ObjectOutputStream out = 
       new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream in = 
      new ObjectInputStream(socket.getInputStream());
    
    Request request = new Request("login", 
        new Class[]{int.class, String.class},
        new Object[]{1001, "12345"});
    out.writeObject(request);//��������
    Response r = (Response)in.readObject(); //������Ӧ
    socket.close();// �Ͽ�����;
    System.out.println(request);
    System.out.println(r);//����
  }

}
