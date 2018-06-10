package com.designPattern.factoryMethod;

public class AnimalFactory {
	public static Animal createAnimal(String animalType) {
		if ("Dog".equals(animalType)) {
			return new Dog();
		} else if ("Cat".equals(animalType)) {
			return new Cat();
		} else {
			return null;
		}
	}
}
