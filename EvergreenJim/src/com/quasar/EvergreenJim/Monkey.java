//package com.quasar.EvergreenJim;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.Texture.TextureFilter;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//
//import Regions.MonkeyRegion;
//import Regions.Region;
//
//
//public class Monkey {
//
//	private int speed = Constants.MID_SPEED;
//	private SpriteBatch batch;
//	private Texture texture;
//	private Sprite sprite;
//	private MonkeyRegion mr;
//	
//	public Monkey() {
//		create();
//	}
//	
//	
//	private void create() {
//		texture = new Texture(Gdx.files.internal("square.png"));
//		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
//		
//		TextureRegion region = new TextureRegion(texture, 0, 0, 32, 32);
//		
//		sprite = new Sprite(region);
//	//	sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
//	//	sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
//		
//		sprite.setPosition((mr.r3.xmax - mr.r3.xmin)/2, (mr.r3.ymax - mr.r3.ymin)/2);
//		render();
//	}
//	
//	public void render() {
//		batch.begin();
//		sprite.draw(batch);
//		batch.end();
//	}
//	
//	
//	public void move(Region r) {
//		
//	}
//	
//}
