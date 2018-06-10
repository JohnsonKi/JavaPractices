package com.designPattern.multitionMethod;

public class Minister {
	public static void main(String[] args) {
		int ministerNum =10; //10个大臣
		for(int i=0;i<ministerNum;i++){
			Emperor emperor = Emperor.getInstance(i);
			System.out.println("第"+(i+1)+"个大臣参拜的是：");
			emperor.emperorInfo();
		}
	}
}
