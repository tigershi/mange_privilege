package com.tarena.elts.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

public class ExamServiceImpl
  implements ExamService, Serializable {
  
  private EntityContext entityContext;
  /** ���� */
  private List<QuestionInfo> paper = 
    new ArrayList<QuestionInfo>();
  
  private User loginUser;
  
  private int score;
  
  private boolean finish = false;
  private boolean started = false;
  
  public void setEntityContext(EntityContext entityContext) {
    this.entityContext = entityContext;
  }

  public User login(int id, String pwd) throws IdOrPwdException {
    User u = entityContext.getUser(id);
    if(u==null){
      throw new IdOrPwdException("�û��������벻��ȷ!");
    }
    if(u.getPasswd().equals(pwd)){
      //��¼�ɹ�
      loginUser = u;
      return u;
    }
    throw new IdOrPwdException("�û��������벻��ȷ!");
  }

  public QuestionInfo getQuestion(int index) {
    return paper.get(index); 
  }

  public ExamInfo start() {
    if(finish)
      throw new RuntimeException("�����Ѿ������������ٴβμ�!");
    if(started)
      throw new RuntimeException("�����Ѿ���ʼ��!");
    //��������
    createPaper();
    ExamInfo info = new ExamInfo();
    info.setQuestionCount(paper.size());
    info.setTimeLimit(entityContext.getTimeLimit());
    info.setTitle(entityContext.getTitle());
    info.setUser(loginUser);
    started = true;
    return info;
  }
  /** 
   * ��������
   * ����: ÿ���Ѷȼ���������
   * */
  private void createPaper() {
    Random r = new Random();
    int index = 0;
    for(int level = Question.LEVEL1; 
      level<=Question.LEVEL10; level++){
      List<Question> list = 
        entityContext.findQuestions(level);
      //��list��ȡ��(remove)һ����
      Question q1 = list.remove(r.nextInt(list.size()));
      Question q2 = list.remove(r.nextInt(list.size()));
      paper.add(new QuestionInfo(index++, q1));
      paper.add(new QuestionInfo(index++, q2));
    }
  }
  
  public void saveUserAnswers(
      List<Integer> userAnswers, int index) {
    QuestionInfo q = paper.get(index);
    q.getUserAnswers().clear();
    q.getUserAnswers().addAll(userAnswers);
  }
  
  public int send() {
    score = 0;
    for (QuestionInfo q : paper) {
      Question question = q.getQuestion();
      List<Integer> userAnswers = q.getUserAnswers();
      List<Integer> answers = question.getAnswer();
      //if(question.getType()==Question.SINGLE_SELECTION)
        
      if(answers.equals(userAnswers)){
        score += question.getScore();
      }
    }
    finish = true;
    return score;
  }
  
  public int getScore() {
    if(! finish ){
      throw new RuntimeException("����û�вμӿ��ԣ����ܲ鿴����!");
    }
    return score;
  }

}
