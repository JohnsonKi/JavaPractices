package com.designPattern.strategyMethod;

public class Client {
	public static void main(String[] args) {
		Context co;
		co = new Context(new BackDoor());
		co.operate();

		System.out.println("--------------------");

		co = new Context(new BlockEnemy());
		co.operate();

		System.out.println("--------------------");

		co = new Context(new GivenGreenLight());
		co.operate();
	}
}
