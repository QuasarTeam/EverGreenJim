package com.quasar.EvergreenJim;

import Fruits.Apple;
import Fruits.Fruit;
import Fruits.Lemon;
import Regions.TreeRegion;
import Regions.Region;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class MyGdxGame implements ApplicationListener {

	// Variables que controlan que el mono no se pueda mover mientras está en
	// movimiento.
	boolean monkeyCanMoveToR1;
	boolean monkeyCanMoveToR2;
	boolean monkeyCanMoveToR3;
	boolean canShoot;
	Fruit selectedFruit;
	Fruit apple = new Apple();
	Fruit lemon = new Lemon();

	@Override
	public void create() {

		// DEBUG
		selectedFruit = apple;

		WorldRenderer.loadAssets();
		Monkey.init();
		Lemon.load();
		Apple.load();
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// Ejemplo: mr1 significia monkey region 1
		Region tr1 = (Region) new TreeRegion().r1;
		Region tr2 = (Region) new TreeRegion().r2;
		Region tr3 = (Region) new TreeRegion().r3;

		if (monkeyCanMoveToR1) {
			Monkey.move(tr1);
		}
		if (monkeyCanMoveToR2) {
			Monkey.move(tr2);
		}
		if (monkeyCanMoveToR3) {
			Monkey.move(tr3);
		}

		if (Tap.isInside(tr1)) {

			System.out.println("Region 1");
			monkeyCanMoveToR1 = true;
			monkeyCanMoveToR2 = false;
			monkeyCanMoveToR3 = false;

		} else if (Tap.isInside(tr2)) {

			System.out.println("Region 2");
			monkeyCanMoveToR2 = true;
			monkeyCanMoveToR1 = false;
			monkeyCanMoveToR3 = false;

		} else if (Tap.isInside(tr3)) {

			System.out.println("Region 3");
			monkeyCanMoveToR3 = true;
			monkeyCanMoveToR1 = false;
			monkeyCanMoveToR2 = false;

		} else if (Gdx.input.justTouched()
				&& !(Tap.isInside(tr1) || Tap.isInside(tr2) || Tap
						.isInside(tr3))
				&& (selectedFruit == apple ? Apple.tapEnabled
						: Lemon.tapEnabled)) { 

			System.out.println("Tap outside");
			
			if (selectedFruit == apple) {

				Apple.canCreateMore = true;
				
			} else if (selectedFruit == lemon) {

				Lemon.canCreateMore = true;
			}

			canShoot = true;
		}

		// Se debe de controlar si se puede disparar o no, si no se condiciona
		// lo hará por sí solo
		if (canShoot) {
			Monkey.shoot(selectedFruit);
		}

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
