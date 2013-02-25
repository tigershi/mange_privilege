package cn.djel.manage.service.user.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.djel.manage.dao.user.ITreeDao;
import cn.djel.manage.domain.user.TreeNode;
import cn.djel.manage.service.user.IInitService;
@Service("initService")
public class InitServiceImpl implements IInitService{
    private ITreeDao treeDao;
	@Resource(name="treeDao")
	public void setTreeDao(ITreeDao treeDao) {
		this.treeDao = treeDao;
	}
	@Override
	public List<TreeNode> getTreesByParent(String pid) {
		// TODO Auto-generated method stub
		return this.treeDao.getTreeByParent(pid);
	}

}
