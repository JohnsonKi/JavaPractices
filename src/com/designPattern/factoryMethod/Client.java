package com.designPattern.factoryMethod;

public class Client {

	public static void main(String[] args) {
		Dog d = (Dog) AnimalFactory.createAnimal("Dog");
		d.eat();

		Cat c = (Cat) AnimalFactory.createAnimal("Cat");
		c.eat();

		Human h = (Human) AnimalFactory.createAnimal("Human");
		h.eat();
	}

}
