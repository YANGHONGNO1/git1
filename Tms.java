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
		System.out.println("**********************��ʦ����ϵͳ**********************");
		System.out.println("**1��ѯ��ʦ��Ϣ");
		System.out.println("**2¼����ʦ��Ϣ");
		System.out.println("**3��id������ʦ��Ϣ");
		System.out.println("**4�޸���ʦ��Ϣ");
		System.out.println("**5ɾ����ʦ��Ϣ");
		System.out.println("**exit�˳�");
		System.out.println("**help����");
		System.out.println("********************************************************");
	
	}
	public static void main(String[] args){
		Tms tms=new Tms();
		Scanner sc=new Scanner(System.in);
		tms.menu();
		while(true){
		System.out.print("�������Ӧ��ָ�");
		String option=sc.nextLine();
		switch(option){
			case"1":
				System.out.println("���������н�ʦ����Ϣ");
				Teacher[] te=tms.queryall();
				for(Teacher tea:te)
					System.out.println(tea);
				System.out.println("�ܹ���ѯ��"+tms.index+"λ��ʦ");
				break;
			case"2":
				while(true){
				System.out.println("�밴��id#name#age����ʽ¼���ʦ����Ϣ�����롾break��������һ��");
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
				System.out.println("¼��ɹ���");
			}
				break;
			case"3":
				while(true){
				System.out.println("������Ҫ���ҵĽ�ʦ�ġ�id�������롾break��������һ��");
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
				System.out.println("������Ҫ�޸ĵĽ�ʦ�ġ�id�������롾break��������һ��");
				String tea=sc.nextLine();
				if(tea.equals("break")){
					break;
				}
				long id=Long.parseLong(tea);
				Teacher teache=tms.querybyid(id);
				if(teache==null){
				System.out.println("�Բ�����Ҫ�޸ĵĽ�ʦ��Ϣ�����ڣ�");
				continue;
				}
				System.out.println("ԭ��ϢΪ��"+teache);
				System.out.print("����������Ϣ��name#age��");
				String teac=sc.nextLine();
				String[] tearry=teac.split("#");
				String name=tearry[0];
				int age =Integer.parseInt(tearry[1]);
				Teacher teacher=new Teacher(id,name,age);
				tms.update(teacher);
				System.out.println("�޸ĳɹ���");
			}
				break;
			case"5":
				while(true){
				System.out.println("������Ҫɾ���Ľ�ʦ�ġ�id�������롾break��������һ��");
				String tea=sc.nextLine();
				if(tea.equals("break")){
					break;
				}
				long id=Long.parseLong(tea);
				Teacher teache=tms.querybyid(id);
				if(teache==null){
					System.out.println("�Բ�����Ҫɾ���Ľ�ʦ��Ϣ�����ڣ�");
					continue;
				}
				tms.deletebyid(id);
				System.out.println("ɾ���ɹ���");
			}
				break;
			case"exit":
				System.out.println("ȷ���˳���ʦ����ϵͳ�����롾yes�� or ��no��");
				String answer=sc.nextLine();
				if(answer.equals("yes")){
					System.out.println("��ӭ�ٴ�ʹ�ã�byebye");
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
				System.out.println("�����������������");
				break;

		}


		
		}
		
		
	}

}

