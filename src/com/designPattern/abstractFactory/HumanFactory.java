package com.designPattern.abstractFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class HumanFactory {

	private static HashMap<String, Human> humans = new HashMap<String, Human>();

	public static Human createHuman() {
		Human human = null;

		List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class); //定义了多少人种

		Random rd = new Random();
		int rand = rd.nextInt(concreteHumanList.size());

		human = createHuman(concreteHumanList.get(rand));

		return human;
	}

	public static Human createHuman(Class c) {
		Human human = null;

		try {

			if (humans.containsKey(c.getSimpleName())) {
				human = humans.get(c.getSimpleName());
			} else {
				human = (Human)Class.forName(c.getName()).newInstance();
				humans.put(c.getSimpleName(), human);
			}

		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("必须指定人种的颜色");

		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("人种定义错误！");

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("混蛋，你指定的人种找不到！");
		}

		return human;
	}
}
