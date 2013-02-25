package cn.djel.manage.domain.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5290280716492023769L;
	  private int id;
	  private String username;
	  private String neckname;
	  private String password;
	  private int    rightbit;
	  private long   rightcode;
	  private boolean  admin;
	  private String mail;
	  private String phone;
	  private Integer post;
	  private Set<Right> rights =null;
	  private Set<Role> roles = null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNeckname() {
		return neckname;
	}
	public void setNeckname(String neckname) {
		this.neckname = neckname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRightbit() {
		return rightbit;
	}
	public void setRightbit(int rightbit) {
		this.rightbit = rightbit;
	}
	public long getRightcode() {
		return rightcode;
	}
	public void setRightcode(long rightcode) {
		this.rightcode = rightcode;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	//添加权限码跟权限
	public void addRightNum(int rightBit,long rightCode){
		this.rightbit = this.rightbit | rightBit;
		this.rightcode =this.rightcode | rightCode;
	}
	public void addRightNums(Set<Right> rights){
		for(Right right: rights){
			addRightNum(right.getRightBit(),right.getRightCode());
		}
	}
	public Integer getPost() {
		return post;
	}
	public void setPost(Integer post) {
		this.post = post;
	}

	public Set<Right> getRights() {
		return rights;
	}
	public void setRights(Set<Right> rs) {
		if(this.rights == null){
			this.rights = new HashSet<Right>();
		}
		this.rights.addAll(rs);
	}
	public void addRight(Right right){
		if(this.rights == null){
			this.rights = new HashSet<Right>();
		}
		this.rights.add(right);
	}

	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> rs) {
		if(this.roles ==null){
			this.roles = new HashSet<Role>();
		}
		this.roles.addAll(rs);
	}
	public void addRole(Role role){
		if(this.roles ==null){
			this.roles = new HashSet<Role>();
		}
		this.roles.add(role);
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
