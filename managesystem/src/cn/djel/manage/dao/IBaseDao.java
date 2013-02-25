package cn.djel.manage.dao;

import java.io.Serializable;
import java.util.List;
	    public interface IBaseDao<T> {
		  public List<T> getAllEntity();
		  public T getEntityById(Serializable id);
		  public void insertEntity(T t);
		  public void updateEntity(T t);
		  public void deleteEntity(Serializable id);
		}

