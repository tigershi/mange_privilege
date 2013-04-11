package com.tarena.elts.entity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tarena.util.Config;
/** ʵ��������, ����������ݲ�, �������������ʵ������
 * ��: �û�����, ��������, ������Ϣ��
 *  */
public class EntityContext implements Serializable {
  private static final long serialVersionUID = 1115246858216870946L;
 
  private Map<Integer, User> users = 
    new HashMap<Integer, User>();
 
  private Config config;
  
  public EntityContext() {
  }
  
  public EntityContext(Config config) {
    this.config = config;
    try {
      loadUsers(config.getString("UserFile"));
      loadQuestions(config.getString("QuestionFile"));
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  private void loadUsers(String file) 
    throws IOException{
    BufferedReader in = new BufferedReader(
        new InputStreamReader(
            new FileInputStream(file), "GBK"));
    String str;
    while((str=in.readLine())!=null){
      if(str.trim().equals("") || str.startsWith("#")){
        continue;
      }
      //str=1003:����:1234:13810381038:lisi@tarena.com.cn
      User u = parseUser(str);
      users.put(u.getId(), u);
    }
    in.close();
  }
  //1003:����:1234:13810381038:lisi@tarena.com.cn
  private User parseUser(String str) {
    String[] data = str.split(":");
    User u = new User();
    u.setId(Integer.parseInt(data[0]));
    u.setName(data[1]);
    u.setPasswd(data[2]);
    u.setPhone(data[3]);
    u.setEmail(data[4]);
    return u;
  }
 
  public User getUser(int id) {
    return users.get(id);
  }
  
 
  
  /** ȫ������ļ���, key�Ǽ���(level), 
   * value�� ����level�µ��������� */
  private Map<Integer, List<Question>> questions = 
    new HashMap<Integer, List<Question>>();

  public List<Question> findQuestions(int level){
    return new ArrayList<Question>(questions.get(level));
  }
  
  /** ���������ļ�, ��questions������ */
  private void loadQuestions(String file){
    try {
      BufferedReader in = 
        new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(
                    new FileInputStream(file)), 
                    "gbk"));
      String str;
      while((str = in.readLine())!=null){
        str = str.trim();
        if(str.equals("") || str.startsWith("#")){
          continue;
        }
        //��������Ϣ�� Question ���� 
        Question q = parseQuestion(str, in);
        addQuestion(q); //��ӵ�����
      }
      in.close(); 
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void addQuestion(Question q) {
    if(questions.containsKey(q.getLevel())){
      questions.get(q.getLevel()).add(q);
    }else{
      List<Question> list = new ArrayList<Question>();
      list.add(q);
      questions.put(q.getLevel(), list);
    }
//    List<Question> list = 
//      questions.get(q.getLevel());
//    if(list==null){
//      list = new ArrayList<Question>();
//      questions.put(q.getLevel(), list);
//    }
//    list.add(q);
    //System.out.println("q:"+q);
    //System.out.println("list:"+list);
    //System.out.println("questions:"+questions);
  }
/*
@answer=2/3,score=5,level=5
ָ���������û�б���������:
long n = 999999999999;
int n = 999999999999L;
long n = 999999999999L; 
double n = 999999999999;
 */
  private Question parseQuestion(
      String str, BufferedReader in) 
    throws IOException{
    String[] data = str.split("[@,][a-z]+=");
    //str: @answer=2/3,score=5,level=5
    // �����ַ��� ��Ϊ: ���½��
    // data:{"","2/3","5","5"}
    Question q = new Question();
    q.setAnswer(parseAnswer(data[1]));
    q.setScore(Integer.parseInt(data[2]));   
    q.setLevel(Integer.parseInt(data[3]));
    q.setTitle(in.readLine());//��ȡ���
    List<String> options = new ArrayList<String>();
    options.add(in.readLine());//������ȡ4��ѡ��
    options.add(in.readLine());
    options.add(in.readLine());
    options.add(in.readLine());
    q.setOptions(options);
    q.setType(q.getAnswer().size()==1? 0 : 1);
    return q;
  }
  // answer: "2/3"
  private List<Integer> parseAnswer(
      String answer) {
    List<Integer> list = 
      new ArrayList<Integer>();
    String[] data = answer.split("/");
    for (String s : data) {
      list.add(Integer.parseInt(s));
    }
    return list;
  }

  
  public static void main(String[] args) {
    EntityContext ctx = new EntityContext(new Config("client.properties"));
    //ctx.loadUsers("user.txt");
    System.out.println(ctx.users); 
    System.out.println(ctx.questions); 
  }

  public int getTimeLimit() {
    return config.getInt("TimeLimit"); 
  } 

  public String getTitle() {
    return config.getString("PaperTitle"); 
  }
  
}






