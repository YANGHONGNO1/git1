package com.JAVA.ch12;
import java.util.Scanner;

public class Tms{
	private Teacher [] tea=new Teacher[3];
	private int index;
	public void save(Teacher teacher){
		if(tea.length==index){
			Teacher[] demo=new Teacher[tea.length+3];
			System.arraycopy(tea,0,demo,0,index);
			tea=demo;
		}
		tea[index++]=teacher;
	}
	public Teacher[] queryall(){
		Teacher[] demo=new Teacher[index];
		System.arraycopy(tea,0,demo,0,index);
		return demo; 		
	}
	public Teacher querybyid(long id){
		int num=getindexbyid(id);
		return num==-1?null:tea[num];
	}
	private int getindexbyid(long id){
		int num =-1;
		for(int i=0;i<index;i++){
			if(tea[i].getid()==id){
			num=i;
			break;
			}
		}
		return num;
	}
	public void deletebyid(long id){
		int num=getindexbyid(id);
		for(int i=num;i<index-1;i++){
			tea[i]=tea[i+1];
		}
		tea[--index]=null;
	}
	public void update(Teacher teacher){
	for(int i=0;i<index;i++){
		if(tea[i].getid()==teacher.getid()){
			tea[i].setname(teacher.getname());
			tea[i].setage(teacher.getage());
		}
	}	
	}
	public void menu(){
		System.out.println("**********************教师管理系统**********************");
		System.out.println("**1查询老师信息");
		System.out.println("**2录入老师信息");
		System.out.println("**3按id查找老师信息");
		System.out.println("**4修改老师信息");
		System.out.println("**5删除老师信息");
		System.out.println("**exit退出");
		System.out.println("**help帮助");
		System.out.println("********************************************************");
	
	}
	public static void main(String[] args){
		Tms tms=new Tms();
		Scanner sc=new Scanner(System.in);
		tms.menu();
		while(true){
		System.out.print("请输入对应的指令：");
		String option=sc.nextLine();
		switch(option){
			case"1":
				System.out.println("以下是所有教师的信息");
				Teacher[] te=tms.queryall();
				for(Teacher tea:te)
					System.out.println(tea);
				System.out.println("总共查询到"+tms.index+"位教师");
				break;
			case"2":
				while(true){
				System.out.println("请按【id#name#age】格式录入教师的信息或输入【break】返回上一级");
				String tea=sc.nextLine();
				if(tea.equals("break")){
					break;
				}
				String [] arr=tea.split("#");
				long id=Long.parseLong(arr[0]);
				String name=arr[1];
				int age=Integer.parseInt(arr[2]);
				Teacher teas=new Teacher(id,name,age);
				tms.save(teas);
				System.out.println("录入成功！");
			}
				break;
			case"3":
				while(true){
				System.out.println("请输入要查找的教师的【id】或输入【break】返回上一级");
				String tea=sc.nextLine();
				if(tea.equals("break")){
					break;
				}
				long id=Long.parseLong(tea);
				Teacher teache=tms.querybyid(id);
				System.out.println(teache==null?"sorry, not found!":teache);
			}
				break;
			case"4":
				while(true){
				System.out.println("请输入要修改的教师的【id】或输入【break】返回上一级");
				String tea=sc.nextLine();
				if(tea.equals("break")){
					break;
				}
				long id=Long.parseLong(tea);
				Teacher teache=tms.querybyid(id);
				if(teache==null){
				System.out.println("对不起，您要修改的教师信息不存在！");
				continue;
				}
				System.out.println("原信息为："+teache);
				System.out.print("请输入新信息【name#age】");
				String teac=sc.nextLine();
				String[] tearry=teac.split("#");
				String name=tearry[0];
				int age =Integer.parseInt(tearry[1]);
				Teacher teacher=new Teacher(id,name,age);
				tms.update(teacher);
				System.out.println("修改成功！");
			}
				break;
			case"5":
				while(true){
				System.out.println("请输入要删除的教师的【id】或输入【break】返回上一级");
				String tea=sc.nextLine();
				if(tea.equals("break")){
					break;
				}
				long id=Long.parseLong(tea);
				Teacher teache=tms.querybyid(id);
				if(teache==null){
					System.out.println("对不起，您要删除的教师信息不存在！");
					continue;
				}
				tms.deletebyid(id);
				System.out.println("删除成功！");
			}
				break;
			case"exit":
				System.out.println("确定退出教师管理系统？输入【yes】 or 【no】");
				String answer=sc.nextLine();
				if(answer.equals("yes")){
					System.out.println("欢迎再次使用，byebye");
					System.exit(0);
				}
				else{
					tms.menu();
				}	
				break;
			case"help":
				tms.menu();
				break;
			default:
				System.out.println("输入错误，请重新输入");
				break;

		}


		
		}
		
		
	}

}

