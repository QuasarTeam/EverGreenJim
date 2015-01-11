package com.quasar.EvergreenJim;

import Regions.MonkeyRegion;
import Regions.Region;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.quasar.EvergreenJim.Constants;

public class MyGdxGame implements ApplicationListener{
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	//private Monkey m;
	AssetManager manager = new AssetManager();
	
	@Override
	public void create() {		

		//new Monkey();
		//-----------
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
	//	Gdx.app.log("AssetPath", Gdx.files.internal("assets/square.png").file().getAbsolutePath());
		manager.load("square.png", Texture.class);
////		
//		texture = new Texture(Gdx.files.internal("square.png"));
//		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
//		
//		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
//		
//		sprite = new Sprite(region);
//		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
//		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
//		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		Region mr1 = (Region) new MonkeyRegion().r1;
		Region mr2 = (Region) new MonkeyRegion().r2;
		Region mr3 = (Region) new MonkeyRegion().r3;
		
		if(manager.update()) {}
		
			
		System.out.println(manager.getProgress());
		
		
			if(Tap.isInside(mr1)) {
				System.out.println("Region 1");
			}
			else if (Tap.isInside(mr2))
				System.out.println("Region 2");
			else if (Tap.isInside(mr3))
				System.out.println("Region 3");
			else {
				if(Gdx.input.justTouched()) {
					System.out.println("None");
				}
			}
			
			
			
		
//		batch.setProjectionMatrix(camera.combined);
//		batch.begin();
//		//sprite.draw(batch);
//		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
