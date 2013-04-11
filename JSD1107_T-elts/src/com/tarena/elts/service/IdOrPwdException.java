package com.tarena.elts.service;

public class IdOrPwdException extends Exception {

  public IdOrPwdException() {
  }

  public IdOrPwdException(String message) {
    super(message);
  }

  public IdOrPwdException(Throwable cause) {
    super(cause);
  }

  public IdOrPwdException(String message, Throwable cause) {
    super(message, cause);
  }

}
