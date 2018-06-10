package com.designPattern.abstractFactory.test2;

public abstract class AbstractHumanFactory implements HumanFactory {
	protected Human createHuman(HumanEnum humanEnum) {
		Human human = null;

		if (!humanEnum.getValue().equals("")) {
			try {
				human = (Human)Class.forName(humanEnum.getValue()).newInstance();
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
		}

		return human;
	}
}
