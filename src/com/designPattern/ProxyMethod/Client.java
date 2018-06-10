package com.designPattern.ProxyMethod;

public class Client {
	public static void main(String[] args) {

		WangPo forPJL = new WangPo();
		forPJL.makeEyesWithMan();
		forPJL.happyWithman();

		System.out.println("--------------------------");

		WangPo forLZL = new WangPo(new LinZhiLing());
		forLZL.makeEyesWithMan();
		forLZL.happyWithman();

	}
}
