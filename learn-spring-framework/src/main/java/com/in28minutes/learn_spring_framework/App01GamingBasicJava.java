package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacManGame;
import com.in28minutes.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {
	public static void main(String[] args) {
		System.out.println("Everything is working here :");

		// var game = new MarioGame();
		// var game = new SuperContraGame(); //01: Object Creation
		var game = new PacManGame();
		var gameRunner = new GameRunner(game);
		// 02: Object creation and wiring of dependency
		// game is dependency of gameRunner class

		gameRunner.run();
	}

}
