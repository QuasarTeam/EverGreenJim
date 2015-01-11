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
import com.badlogic.gdx.math.Rectangle;
import com.quasar.EvergreenJim.Constants;

public class MyGdxGame implements ApplicationListener{
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private MonkeyRegion mr;
	private Rectangle monkey;
	
	@Override
	public void create() {		

		texture = new Texture(Gdx.files.internal("test.png"));
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);
	    batch = new SpriteBatch();
	    
	    mr = new MonkeyRegion();
	    
//	    
//	   
	    monkey = new Rectangle();
	    monkey.x = (mr.r3.xmax + mr.r3.xmin)/2; // 64?
	    monkey.y = (mr.r3.ymax + mr.r3.ymin)/2; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
	    monkey.width = 64;
	    monkey.height = 64;

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
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		Region mr1 = (Region) new MonkeyRegion().r1;
		Region mr2 = (Region) new MonkeyRegion().r2;
		Region mr3 = (Region) new MonkeyRegion().r3;
		

		
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
			
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
	    batch.draw(texture, monkey.x, monkey.y);
		batch.end();
		
		
		
		
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
