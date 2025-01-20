package com.in28minutes.learn_spring_framework.game;

public class SuperContraGame implements GamingConsole {
	public void up() {
		System.out.println("up");
	}

	public void left() {
		System.out.println("back");
	}

	public void right() {
		System.out.println("shoot a bullet");
	}

	public void down() {
		System.out.println("Sit down");
	}
}
