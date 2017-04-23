package com.oli.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.oli.main.GameScreen;
import com.oli.main.Main;
import com.oli.menu.Ded;

public class MGame extends GameScreen {
	
	SpriteBatch batch;
	Texture background;
	Texture copper;
	OrthographicCamera camera;
	ShapeRenderer DebugRenderer;
	//TrackGenerator _TrackGenerator;
	Parts parts;
	/*Array<Array<int[]>> AllTracks;
	Array<int[]> Track1;
	Array<int[]> Track2;
	Array<int[]> Track3;*/
	public static Player player;
	int scrollX = 0;
	public static int score = 0;
	public static Array<Bullet> bullets;
	public static Array<Spider> spiders;
	public static Array<Monster1> monster1s;
	UI ui;
	public static MusicController music;
	Ded ded;
	Spawner spawner;

	public MGame(Main game) {
		super(game);
	}
	
	@Override
	public void show() {
		
		batch = new SpriteBatch();
		camera = new OrthographicCamera(1280, 700);
		background = new Texture("background.png");
		copper = new Texture("copper.png");
		
		background.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		//_TrackGenerator = new TrackGenerator();
		bullets = new Array<Bullet>();
		spiders = new Array<Spider>();
		monster1s = new Array<Monster1>();
		parts = new Parts();
		player = new Player();
		ui = new UI();
		music = new MusicController();
		spawner = new Spawner(1, 10);
		
		camera.position.x = 640;
		camera.position.y = 350;
		
		/*AllTracks = _TrackGenerator.GenerateTracks();
		Track1 = AllTracks.get(0);
		Track2 = AllTracks.get(1);*/
		
		
		//TODO re-enable music
		//music.play();
		
	}
	
	@Override
	public void render(float delta) {
		
		scrollX += 2;
		
		batch.setProjectionMatrix(camera.combined);
		//camera.position.x += 20;
		camera.update();
		
		batch.begin();
		
		batch.draw(background, 0, 0, scrollX, 0, 1280, 700);
		//batch.draw(parts.parts.get(0), 50, 50);
		player.draw(batch, delta);
		
		/*for (int[] i : Track1) {
			
			batch.draw(copper, i[0], i[1]);
		
		}
		
		
		for (int[] i : Track2) {
			
			batch.draw(copper, i[0], i[1]);
		
		}*/
		
		for (Bullet b : bullets) {
			
			b.render(batch);
			
		}
		
		for (Spider e : spiders) {
			
			e.draw(batch);
			
			if (e.r.intersects(player.r)) {
				
				e.x += 100;
				player.health -= 1;
				
			}
			
		}
		
		for (Monster1 m : monster1s) {
			
			m.draw(batch);
			
			if (m.r.intersects(player.r)) {
				
				m.x += 100;
				player.health -= 1;
				
			}
			
		}
		
		ui.draw(batch);
		
		batch.end();
		
		if (player.health <= 0) {
			
			game._ScreenManager.SetScreen(ded = new Ded(game, score));
			
			
		}
		
	}
	
}
