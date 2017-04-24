package com.oli.game;

import java.util.Random;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class Spawner {
	
	public Timer SpawnSpider;
	public Timer SpawnMonster1;
	Random r;
	
	public Spawner(int InitialDelaySpider, int InitialDelayMonster1) {
		
		r = new Random();
		SpawnSpider = new Timer();
		SpawnMonster1 = new Timer();
		
		SpawnSpider.scheduleTask(new Task() {

			@Override
			public void run() {
				
				int StartingY = r.nextInt(482) + 64;
				int StartingSpeed = 2;
				
				MGame.spiders.add(new Spider(1300, StartingY, StartingSpeed, "spider"));
				
			}
			
		}, InitialDelaySpider, 2);
		
		SpawnMonster1.scheduleTask(new Task() {

			@Override
			public void run() {
				
				int StartingY = r.nextInt(482) + 64;
				int StartingSpeed = 2;
				
				MGame.monster1s.add(new Monster1(1300, StartingY, StartingSpeed, "monster1"));
				
			}
			
		}, InitialDelayMonster1, 5);
		
	}
	

}
