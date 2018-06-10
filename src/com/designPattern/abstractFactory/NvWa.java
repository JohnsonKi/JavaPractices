package com.designPattern.abstractFactory;

public class NvWa {
	public static void main(String[] args) {
		WhiteHuman wh = (WhiteHuman) HumanFactory.createHuman(WhiteHuman.class);
		wh.laugh();

		Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
		blackHuman.laugh();

		Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
		yellowHuman.laugh();

		System.out.println("-----------------------------------");

		for (int i=0; i<10; i++) {

			Human human = HumanFactory.createHuman();
			System.out.println("=== " + i + "===");
			human.laugh();
		}

	}
}
