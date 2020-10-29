package com.test;

/**
 * .
 *
 * @Description TODO.
 * @Author ningbin
 * @Date 2020/9/8
 **/
public enum ProcessEnum {

	MAX("*****") {
		@Override
		public String sum(String name) {
			return "max" + name;
		}
	},
	MIN("----") {
		@Override
		public String sum(String name) {
			return "min" + name;
		}
	};

	ProcessEnum(String name) {
		this.name = name;
	}

	private String name;

	public abstract String sum(String name);

	public static void main(String[] args) {
		ProcessEnum processEnum = ProcessEnum.valueOf("MIN");
		System.out.println(16 >> 4);
	}
}
