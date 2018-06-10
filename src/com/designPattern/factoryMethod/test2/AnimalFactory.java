package com.designPattern.factoryMethod.test2;

public class AnimalFactory {

	public static Animal createAnimal(Class c) {

		Animal animal = null;

		try {
			animal = (Animal) Class.forName(c.getName()).newInstance();

		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return animal;
	}
}
