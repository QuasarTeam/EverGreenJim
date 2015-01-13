package com.quasar.EvergreenJim;

import com.badlogic.gdx.Gdx;
import Regions.MonkeyRegion;
import Regions.Region;

public class Monkey {

	public Monkey() {
	}

	// Con Region mr se toma ventaja del principio de diseño sobre programar para la interface.
	public static void move(Region mr) {

		// Ejemplo: Si mr pertenece a la Region1 entonces ...
		if (mr instanceof MonkeyRegion.Region1) {
			if ((Assets.asm.monkey.y < Gdx.graphics.getHeight() + 50)) { // Modificar coordenada, 50??
				Assets.asm.monkey.y += Constants.MID_SPEED * Gdx.graphics.getDeltaTime();
			}
		}

		if (mr instanceof MonkeyRegion.Region2) {
			if ((Assets.asm.monkey.y < Gdx.graphics.getHeight()
					- Gdx.graphics.getHeight() / 3)) {
				Assets.asm.monkey.y += Constants.MID_SPEED * Gdx.graphics.getDeltaTime();
			}

			if ((Assets.asm.monkey.y > (Gdx.graphics.getHeight() / 2 + 50))) {
				Assets.asm.monkey.y -= Constants.MID_SPEED * Gdx.graphics.getDeltaTime();
			}

		}

		if (mr instanceof MonkeyRegion.Region3) {
			if ((Assets.asm.monkey.y > Gdx.graphics.getWidth() / 15)) {
				Assets.asm.monkey.y -= Constants.MID_SPEED * Gdx.graphics.getDeltaTime();
			}
		}
	}

}
