package com.tarena.util;

import java.io.FileInputStream;
import java.util.Properties;
//TODO Day2 9 用来解析装载系统配置文件.
public class Config {
  //private String file; 
  private Properties cfg = new Properties();
  
  public Config(String file){
    try {
      cfg.load(new FileInputStream(file));
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  public String getString(String key){
    return cfg.getProperty(key);
  }
  
  public int getInt(String key){
    return Integer.parseInt(cfg.getProperty(key));
  }
  
  public double getDouble(String key){
    return Double.parseDouble(getString(key));
  }
  public static void main(String[] args) {
    Config config = 
      new Config("client.properties");
    String ip = config.getString("ServerIP");
    System.out.println(ip);//127.0.0.1
    System.out.println(config.getInt("TimeLimit"));//1
    
  }
}
