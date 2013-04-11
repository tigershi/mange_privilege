package com.tarena.elts.net;

import java.util.List;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;
import com.tarena.util.Config;
/** 考试服务代理客户端 */
public class ExamServiceAgent implements ExamService{
  private Config config;
  private String host;
  private int port;
  private String sid;
  public void setConfig(Config config) {
    this.config = config;
    this.host = config.getString("ServerIP");
    this.port = config.getInt("ServerPort");
  }
  
  public User login(int id, String pwd) throws IdOrPwdException {
    Request req = new Request("login", 
        new Class[]{int.class, String.class}, 
        new Object[]{id, pwd});
    req.setSessionID(sid);
    Response res = Utils.remoteCall(host, port, req);
    sid = res.getSessionID();
    if(res.isSuccess()){
      return (User)res.getValue();
    }else{
      Exception e = res.getException();
      if(e instanceof IdOrPwdException){
        throw (IdOrPwdException)e;
      }else{
        throw new RuntimeException(e);
      }
    }
  }
  public QuestionInfo getQuestion(int index) {
    Request req = new Request("getQuestion", 
        new Class[]{int.class}, 
        new Object[]{index});
    req.setSessionID(sid);
    Response res = Utils.remoteCall(host, port, req);
    sid = res.getSessionID();
    if(res.isSuccess()){
      return (QuestionInfo)res.getValue();
    }else{
      Exception e = res.getException();
      throw new RuntimeException(e);
    }
  }

  public int getScore() {
    Request req = new Request("getScore", 
        new Class[]{}, 
        new Object[]{});
    req.setSessionID(sid);
    Response res = Utils.remoteCall(host, port, req);
    sid = res.getSessionID();
    if(res.isSuccess()){
      return (Integer)res.getValue();
    }else{
      Exception e = res.getException();
      throw new RuntimeException(e);
    }
  }



  public void saveUserAnswers(
        List<Integer> userAnswers, int index) {
    Request req = new Request("saveUserAnswers", 
        new Class[]{List.class, int.class}, 
        new Object[]{userAnswers, index});
    req.setSessionID(sid);
    Response res = Utils.remoteCall(host, port, req);
    sid = res.getSessionID();
    if(res.isSuccess()){
      //return (Integer)res.getValue();
    }else{
      Exception e = res.getException();
      throw new RuntimeException(e);
    }
  }

  public int send() {
    Request req = new Request("send", 
        new Class[]{}, 
        new Object[]{});
    req.setSessionID(sid);
    Response res = Utils.remoteCall(host, port, req);
    sid = res.getSessionID();
    if(res.isSuccess()){
      return (Integer)res.getValue();
    }else{
      Exception e = res.getException();
      throw new RuntimeException(e);
    }
  }

  public ExamInfo start() {
    Request req = new Request("start", 
        new Class[]{}, 
        new Object[]{});
    req.setSessionID(sid);
    Response res = Utils.remoteCall(host, port, req);
    sid = res.getSessionID();
    if(res.isSuccess()){
      return (ExamInfo)res.getValue();
    }else{
      Exception e = res.getException();
      throw new RuntimeException(e);
    }
  }

}
