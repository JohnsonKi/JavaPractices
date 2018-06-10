package com.designPattern.factoryMethod.test2;

public class Client {

	public static void main(String[] args) {

		Dog d = (Dog)AnimalFactory.createAnimal(Dog.class);
		d.eat();

		Cat c = (Cat)AnimalFactory.createAnimal(Cat.class);
		c.eat();

		Human h = (Human)AnimalFactory.createAnimal(Human.class);
		h.eat();
	}

}
