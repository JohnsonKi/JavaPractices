package com.designPattern.multitionMethod;

import java.util.ArrayList;
import java.util.Random;

public class Emperor {
	private static int maxNumOfEmperor = 10; //最多只能有连个皇帝
	private static ArrayList emperorInfoList = new ArrayList(maxNumOfEmperor); //皇帝叫什么名字
	private static ArrayList emperorList = new ArrayList(maxNumOfEmperor); //装皇帝的列表；
	private static int countNumOfEmperor = 0; //正在被人尊称的是那个皇帝

	//先把2个皇帝产生出来
	static {
		//把所有的皇帝都产生出来
		for(int i=0; i<maxNumOfEmperor; i++) {
			emperorList.add(new Emperor("皇帝"+(i+1)));
		}
	}

	//就这么多皇帝了，不允许再推举一个皇帝(new 一个皇帝）
	private Emperor() {}

	private Emperor(String info) {
		emperorInfoList.add(info);
	}

	public static Emperor getInstance() {
		Random random = new Random();
		countNumOfEmperor = random.nextInt(maxNumOfEmperor);  //随机拉出一个皇帝，只要是个精神领袖就成
		System.out.println("皇帝数:" + emperorList.size() + " 当选皇帝号:" + countNumOfEmperor);
		return (Emperor)emperorList.get(countNumOfEmperor);
	}

	public static Emperor getInstance(int count) {
		if (count > countNumOfEmperor || count < 0) {
			System.out.println("没有你选的皇帝(" + count + ")。帮你随机选一个。");
			return getInstance();
		}

		System.out.println("皇帝数:" + emperorList.size() + " 当选皇帝号:" + count);
		return (Emperor)emperorList.get(count);
	}

	public static void emperorInfo() {
		System.out.println(emperorInfoList.get(countNumOfEmperor)); //皇帝叫什么名字呀
	}
}
