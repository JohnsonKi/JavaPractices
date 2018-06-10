package com.designPattern.strategyMethod;

public class Context {
	IStrategy is;
	public Context(IStrategy in) {
		is = in;
	}

	public void operate() {
		this.is.operate();
	}
}
