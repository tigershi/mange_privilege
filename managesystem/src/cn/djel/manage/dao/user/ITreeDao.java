package cn.djel.manage.dao.user;
import java.util.List;

import cn.djel.manage.dao.IBaseDao;
import cn.djel.manage.domain.user.TreeNode;
public interface ITreeDao extends IBaseDao<TreeNode>{
  public List<TreeNode> getTreeByParent(String pid);
}
