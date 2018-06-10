package com.designPattern.abstractFactory.test2;

public enum HumanEnum {
	//把世界上所有人类型都定义出来
	YelloMaleHuman("com.designPattern.abstractFactory.test2.YellowMaleHuman"),
	YelloFemaleHuman("com.designPattern.abstractFactory.test2.YellowFemaleHuman"),
	WhiteFemaleHuman("com.designPattern.abstractFactory.test2.WhiteFemaleHuman"),
	WhiteMaleHuman("com.designPattern.abstractFactory.test2.WhiteMaleHuman"),
	BlackFemaleHuman("com.designPattern.abstractFactory.test2.BlackFemaleHuman"),
	BlackMaleHuman("com.designPattern.abstractFactory.test2.BlackMaleHuman");

	private String value = "";

	//定义构造函数，目的是Data(value)类型的相匹配
	private HumanEnum(String value){
		this.value = value;
	}

	public String getValue(){
		return this.value;
	}

}
