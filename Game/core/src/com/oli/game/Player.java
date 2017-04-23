package com.oli.game;

import java.awt.Rectangle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class Player  {
	
	int x;
	int y;
	Texture one;
	Texture two;
	Texture[] frames;
	Animation<Texture> animation;
	float elapsedtime;
	Timer t;
	boolean CanShoot = true;
	public Rectangle r;
	int health = 5;
	
	public Player() {
		
		one = new Texture("ship.png");
		two = new Texture("ship2.png");
		frames = new Texture[2];
		frames[0] = one;
		frames[1] = two;
		animation = new Animation<Texture>(0.2f, frames);
		animation.setPlayMode(PlayMode.LOOP);
		r = new Rectangle(x, y, one.getWidth(), one.getHeight());
		CanShoot = true;
		
		t = new Timer();
		
		x = 32;
		y = 32;
		
		elapsedtime = 0;
		
		t.scheduleTask(new Task() {

			@Override
			public void run() {

				CanShoot = true;
				
			}
			
		}, 0.5f, 0.5f);
		
	}
	
	public void draw(SpriteBatch batch, float delta) {
		
		elapsedtime += delta;
		batch.draw(animation.getKeyFrame(elapsedtime), x, y);
		
		r.x = x;
		r.y = y;
		r.width = animation.getKeyFrame(elapsedtime).getWidth();
		r.height = animation.getKeyFrame(elapsedtime).getHeight();
		
		if (Gdx.input.isKeyPressed(Keys.W)) {
			
			
			if (y + 4 < 700 - one.getHeight()) {
				
				y += 4;
			
			}
			
		}
		
		if (Gdx.input.isKeyPressed(Keys.S)) {
			
			if (y - 4 > 0) {
				
				y -= 4;
				
			}
			
		}
		
		if (Gdx.input.isKeyPressed(Keys.D)) {
			
			if (x + 4 < 500 - one.getWidth()) {
				
				x += 4;
			
			}
			
		}
		
		if (Gdx.input.isKeyPressed(Keys.A)) {
			
			if (x - 4 > 0) {
				
				x -= 4;
				
			}
			
		} 
		
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			
			if (CanShoot) {
			
				MGame.bullets.add(new Bullet(x + one.getWidth(), y + 70));
				MGame.music.PlayShoot();
				CanShoot = false;
				
			}
			
		}
		
	}

}
