package com.tarena.elts.entity;

import java.util.ArrayList;
import java.util.List;
/**
 * Question�������һ�����⡣
 * ������ɺ��ĸ�ѡ���Լ���ȷ��
 * @author new
 *
 */
public class Question implements java.io.Serializable{
	public static final int LEVEL1=1;
	public static final int LEVEL2=2;
	public static final int LEVEL3=3;
	public static final int LEVEL4=4;
	public static final int LEVEL5=5;
	public static final int LEVEL6=6;
	public static final int LEVEL7=7;
	public static final int LEVEL8=8;
	public static final int LEVEL9=9;
	public static final int LEVEL10=10;
	
	public static final int SINGLE_SELECTION=0;
	public static final int MULTI_SELECTION=1;
	
	private int id;
	private String title;//���
	private List<String> options = 
      new ArrayList<String>();//����ѡ��
	private List<Integer> answer = 
      new ArrayList<Integer>();//��ȷ��
	private int score;
	private int level;
	private int type; //����: ��ѡ SINGLE_SELECTION /��ѡ MULTI_SELECTION
	 	
	public static final long serialVersionUID=9080302019871213L;
	
	public Question(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getAnswer() {
		return answer;
	}

	public List<String> getOptions() {
		return options;
	}


	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getTitle() {
		return title;
	}
	
	public void setAnswer(List<Integer> answer) {
		this.answer = answer;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
 
	public String toString(){
		StringBuffer sb=new StringBuffer(title+"\n");
		for(int i=0;i<options.size();i++){
			sb.append((char)(i+'A')+"."+options.get(i)+"\n");
		}
//		sb.append("��ȷ�𰸣�");
//		for(int i=0;i<answer.size();i++){
//			sb.append((char)(answer.get(i)+'A')+",");
//		}
		sb.append("\n");
		return sb.toString();
	}
  @Override
  public boolean equals(Object obj) {
    if(obj==null)
      return false;
    if(this==obj)
      return true;
    if (obj instanceof Question) {
      Question other = (Question) obj;
      return this.id == other.id;
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    return id;
  }
}