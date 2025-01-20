package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacManGame;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		//var game = new PacManGame();
		var game = new MarioGame();
		return game;
	}

	@Bean
	public GameRunner gameRunner(GamingConsole game) { //we can also pass the method
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
}
