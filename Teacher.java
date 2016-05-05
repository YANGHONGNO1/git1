package com.JAVA.ch12;

public class Teacher{
	private long id;
	private String name;
	private int age;
	public Teacher(){
	
	}
	public Teacher(long id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;	
	}
	public void setid(long id){
		this.id=id;
	} 
	public long getid(){
		return this.id;
	}
	public void setname(String name){
		this.name=name;
	}
	public String getname(){
		return this.name;
	}
	public void setage(int age){
		this.age=age;
	}
	public int getage(){
		return this.age;
	}
	public String toString(){
		return "Teacher¡¾id:"+this.id+" name:"+this.name+" age:"+this.age+"¡¿";
	}
}

