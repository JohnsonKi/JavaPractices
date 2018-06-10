package com.designPattern.abstractFactory.test2;

public abstract class AbstractYellowHuman implements Human {
	public void cry() {
		System.out.println("黄色人种会哭");
	}
	public void laugh() {
		System.out.println("黄色人种会大笑，幸福呀！");
	}
	public void talk() {
		System.out.println("黄色人种会说话，一般说的都是双字节");
	}
}
