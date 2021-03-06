package cn.djel.manage.domain.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeNode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2862333523482043502L;
	/**

	 */
	private String id;          //要显示的子节点的ID  
    private String text;        //要显示的子节点的 Text  
    private String iconCls;     //节点的图
    private String parentId;//父节点的ID  
    private String state;
    private String url;
    private Integer show;
    private Map<String,String> attributes =null;
    private Set<TreeNode>  children =null;
    public TreeNode(){
    	this.state="open";
    }
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Set<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		if(this.children == null){
			this.children = new HashSet<TreeNode>();
			this.state="closed";	
			//System.out.println("sssss");
		}
		for(TreeNode node: children){
			//System.out.print(node.id);
			this.children.add(node);
		}
	}
	public void addChild(TreeNode node){
		if(this.children ==null){
			this.children = new HashSet<TreeNode>();
			this.state="closed";
		}
		this.children.add(node);
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Map<String,String> getAttributes() {
		return attributes;
	}
	public void setAttributes(String key,String value) {
		if(this.attributes ==null){
		 this.attributes = new HashMap<String,String>();
		}
		this.attributes.put(key, value);
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
		setAttributes("url",url);
	}
	public Integer getShow() {
		return show;
	}
	public void setShow(Integer show) {
		this.show = show;
	}
	
}
