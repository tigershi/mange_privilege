package com.tarena.test;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.net.Request;
import com.tarena.elts.net.Response;
import com.tarena.elts.net.Utils;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.util.Config;

public class MethodCallTest {
  public static void main(String[] args) {
    String str = "ABCD";
    Request req = new Request();
    req.setMethod("length");
    req.setParamTypes(new Class[]{});
    req.setParams(new Object[]{});
    
    Response res = Utils.call(str, req);
    System.out.println(res); 
    
    ExamServiceImpl service = new ExamServiceImpl();
    Config config = new Config("client.properties");
    EntityContext entityContext = new EntityContext(config);
    service.setEntityContext(entityContext);
    //����������� service ������κη���
    req = new Request("login", 
        new Class[]{int.class, String.class},
        new Object[]{1001, "1234"});
    Response r = Utils.call(service, req);
    System.out.println(r);
  }

}
