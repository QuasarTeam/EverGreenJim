package com.quasar.EvergreenJim;

import Regions.MonkeyRegion;
import Regions.Region;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class MyGdxGame implements ApplicationListener{

	boolean monkeyCanMoveToR1;
	boolean monkeyCanMoveToR2;
	boolean monkeyCanMoveToR3;

	
	@Override
	public void create() {		

	    WorldRenderer.loadAssets();

	    monkeyCanMoveToR1 = false;
		monkeyCanMoveToR2 = false;
		monkeyCanMoveToR3 = false;
		
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		Region mr1 = (Region) new MonkeyRegion().r1;
		Region mr2 = (Region) new MonkeyRegion().r2;
		Region mr3 = (Region) new MonkeyRegion().r3;
		
		
			if(Tap.isInside(mr1)) {
				monkeyCanMoveToR1 = true;
				monkeyCanMoveToR2 = false;
				monkeyCanMoveToR3 = false;
		       
				System.out.println("Region 1");
					
			} else if (Tap.isInside(mr2)) {

				monkeyCanMoveToR2 = true;
				monkeyCanMoveToR1 = false;
				monkeyCanMoveToR3 = false;
				System.out.println("Region 2");
				
			} else if (Tap.isInside(mr3)) {

				monkeyCanMoveToR3 = true;
				monkeyCanMoveToR1 = false;
				monkeyCanMoveToR2 = false;
				System.out.println("Region 3");
			}
			
			if (monkeyCanMoveToR1 == true) Monkey.move(mr1);
			if (monkeyCanMoveToR2 == true) Monkey.move(mr2);
			if (monkeyCanMoveToR3 == true) Monkey.move(mr3);
			
			 WorldRenderer.update();

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
