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
  /** 考卷 */
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
      throw new IdOrPwdException("用户名或密码不正确!");
    }
    if(u.getPasswd().equals(pwd)){
      //登录成功
      loginUser = u;
      return u;
    }
    throw new IdOrPwdException("用户名或密码不正确!");
  }

  public QuestionInfo getQuestion(int index) {
    return paper.get(index); 
  }

  public ExamInfo start() {
    if(finish)
      throw new RuntimeException("考试已经结束，不能再次参加!");
    if(started)
      throw new RuntimeException("考试已经开始了!");
    //创建考卷
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
   * 创建考卷
   * 规则: 每个难度级别两道题
   * */
  private void createPaper() {
    Random r = new Random();
    int index = 0;
    for(int level = Question.LEVEL1; 
      level<=Question.LEVEL10; level++){
      List<Question> list = 
        entityContext.findQuestions(level);
      //从list中取出(remove)一道题
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
      throw new RuntimeException("您还没有参加考试，不能查看分数!");
    }
    return score;
  }

}
