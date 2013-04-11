package com.tarena.elts.net;

import java.io.Serializable;

public class Response implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -1969565204594561165L;

  private String sessionID;
  
  private Object value;
  
  private Exception e;
  
  public Response() {
  }
  public Response(Object value) {
    this.value = value;
  }
  public Response(Exception e) {
    this.e = e;
  }
  public String getSessionID() {
    return sessionID;
  }
  
  public void setSessionID(String sessionID) {
    this.sessionID = sessionID;
  }
  
  
  public Exception getException() {
    return e;
  }
  public void setException(Exception e) {
    this.e = e;
  }
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }
  
  public boolean isSuccess(){
    return e==null;
  }
  
  @Override
  public String toString() {
    if(e==null){
      return sessionID + "," + value;
    }else{
      return sessionID + "," + e;
    }
  }

}
