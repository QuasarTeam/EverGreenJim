package com.quasar.EvergreenJim;

import Fruits.Lemon;
import Regions.Region;
import Regions.TreeRegion;

import com.badlogic.gdx.Gdx;

public class Monkey {

	static int position = 3; // Posición inicial
	static TreeRegion tr;

	public static void init() {
		tr = new TreeRegion();
	}

	// Con Region tr se toma ventaja del principio de diseño sobre programar
	// para la interface.
	public static void move(Region tr) {

		// Ejemplo: Si tr pertenece a la Region1 entonces ...
		if (tr instanceof TreeRegion.Region1) {
			if ((Assets.asm.monkey.y < Gdx.graphics.getHeight()
					+ (Gdx.graphics.getHeight() / 3) - 64)) {
				Assets.asm.monkey.y += Constants.MID_SPEED
						* Gdx.graphics.getDeltaTime();
			}
			position = 1;
		}

		if (tr instanceof TreeRegion.Region2) {
			if ((Assets.asm.monkey.y < Gdx.graphics.getHeight()
					- Gdx.graphics.getHeight() / 3)) {
				Assets.asm.monkey.y += Constants.MID_SPEED
						* Gdx.graphics.getDeltaTime();
			}

			if ((Assets.asm.monkey.y > (Gdx.graphics.getHeight() / 2 + 64))) {
				Assets.asm.monkey.y -= Constants.MID_SPEED
						* Gdx.graphics.getDeltaTime();
			}
			position = 2;
		}

		if (tr instanceof TreeRegion.Region3) {
			if ((Assets.asm.monkey.y > Gdx.graphics.getHeight() / 3 - 64)) {
				Assets.asm.monkey.y -= Constants.MID_SPEED
						* Gdx.graphics.getDeltaTime();
			}
			position = 3;
		}
	}

	public static void shoot() {
		Lemon.render();
	}

	public static float getCurrentPosition() {

		switch (position) {
		case 1:
			return (tr.r3.ymax);
		case 2:
			return (tr.r2.ymax);
		case 3:
			return (tr.r1.ymax);
		default:
			return 0;
		}
	}

}
