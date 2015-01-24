package com.quasar.EvergreenJim;
import com.badlogic.gdx.Gdx;
import com.quasar.EvergreenJim.Monkey;
import com.quasar.EvergreenJim.Tap;
import com.quasar.EvergreenJim.WorldRenderer;

import Fruits.Apple;
import Fruits.Fruit;
import Fruits.Lemon;
import Regions.Region;
import Regions.TreeRegion;

public class WorldController {

	static boolean monkeyCanMoveToR1;
	static boolean monkeyCanMoveToR2;
	static boolean monkeyCanMoveToR3;
	static boolean canShoot;
	static Fruit selectedFruit;
	static Fruit apple = new Apple();
	static Fruit lemon = new Lemon();

	public static void create() {
		// DEBUG
		selectedFruit = lemon;

		WorldRenderer.loadAssets();
		Monkey.init();
		Lemon.load();
		Apple.load();

	}

	public static void monkeyMovement() {
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
		
	}

	public static void shootingControl() {
		if (canShoot) {
			Monkey.shoot(selectedFruit);
		}

	}

	public void dispose() {

	}

	public void checkCollisions() {

	}

	public void fruitContol() {

	}

	public void livesControl() {

	}

	public void currentLevel() {

	}

}
