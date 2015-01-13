package com.quasar.EvergreenJim;

import com.badlogic.gdx.Gdx;

import Regions.MonkeyRegion;
import Regions.Region;

public class Monkey {

	public Monkey() {
	}

	public static void move(Region mr) {

		if (mr instanceof MonkeyRegion.Region1) {
			if ((Assets.asm.monkey.y < Gdx.graphics.getHeight() + 50)) {

				Assets.asm.monkey.y += 500 * Gdx.graphics.getDeltaTime();
			}

		}

		if (mr instanceof MonkeyRegion.Region2) {
			if ((Assets.asm.monkey.y < Gdx.graphics.getHeight()
					- Gdx.graphics.getHeight() / 3)) {
				Assets.asm.monkey.y += 500 * Gdx.graphics.getDeltaTime();
			}

			if ((Assets.asm.monkey.y > (Gdx.graphics.getHeight() / 2 + 50))) {
				Assets.asm.monkey.y -= 500 * Gdx.graphics.getDeltaTime();
			}

		}

		if (mr instanceof MonkeyRegion.Region3) {
			if ((Assets.asm.monkey.y > Gdx.graphics.getWidth() / 15)) {
				Assets.asm.monkey.y -= 500 * Gdx.graphics.getDeltaTime();
			}
		}
	}

}
