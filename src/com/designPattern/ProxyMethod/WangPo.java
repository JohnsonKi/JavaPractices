package com.designPattern.ProxyMethod;

public class WangPo implements KindWomen {
	private KindWomen kw;

	public WangPo() { //默认的话，是潘金莲的代理
		this.kw = new PanJinLian();
	}

	//她可以是KindWomen的任何一个女人的代理，只要你是这一类型
	public WangPo(KindWomen kindw) {
		this.kw = kindw;
	}

	@Override
	public void makeEyesWithMan() {
		this.kw.makeEyesWithMan(); //王婆这么大年龄了，谁看她抛媚眼？！
	}

	@Override
	public void happyWithman() {
		this.kw.happyWithman(); //自己老了，干不了，可以让年轻的代替
	}

}
