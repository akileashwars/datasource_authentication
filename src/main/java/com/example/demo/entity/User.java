package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	@Column
	private String userName;
	@Column
	private String password;
	
	private int active;
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	private int blocked;
	
	private String roles;
	
	private String permissions;
	public User()
	{
		
	}
	public User(String userName,String password,String roles,String permissions )
	{
		this.userName=userName;
		this.password=password;
		this.permissions=permissions;
		this.roles=roles;
		this.active=1;
				
		
	}
	
	public int getBlocked() {
		return blocked;
	}

	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
public List<String>getRoleList()
{
	java.util.List<String> list=new ArrayList<String>();
	if(this.roles.contains(","))
	{
	list.addAll(Arrays.asList(this.roles.split(",")));
		
	}
	else
	{
		list.add(this.roles);
		
	}
	return list;
}

public List<String>getPermissionList()
{
	java.util.List<String> list=new ArrayList<String>();
	if(this.permissions.contains(","))
	{
	list.addAll(Arrays.asList(this.permissions.split(",")));
		
	}
	else
	{
		list.add(this.permissions);
		
	}
	return list;
}
	
}
