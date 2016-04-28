package com.JAVA.ch09;

public class Flower{
	public static void main(String[] args){
		Flower flower=new Flower();
		flower.test();
	}
	public void test(){
		for(int i=100;i<=999;i++){
			int a=i/100;
			int b=(i-100*a)/10;
			int c=i-100*a-10*b;
			if(i==a*a*a+b*b*b+c*c*c)
				System.out.println(i+"是水仙花数");
		}
	}
}