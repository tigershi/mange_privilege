package cn.djel.manage.service.user;

import java.util.List;

import cn.djel.manage.domain.user.TreeNode;

public interface IInitService {

public List<TreeNode> getTreesByParent(String pid);

}
