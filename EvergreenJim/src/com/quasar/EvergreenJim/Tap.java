package com.quasar.EvergreenJim;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import Regions.TreeRegion;
import Regions.Region;

public class Tap {

	
	public static void getInput(InputProcessor in) {	
	}
	
	public static boolean isInside(Region r) {
		
		if (r instanceof TreeRegion.Region1) {

			return monkeyR1(r);
		}
		
		if (r instanceof TreeRegion.Region2) {

			return monkeyR2(r);
		}
		
		if (r instanceof TreeRegion.Region3) {

			return monkeyR3(r);
		}
		
		
		return false;
		
	}
	
	// Los siguientes métodos identifican si se ha hecho click dentro de alguna de las regiones.
	private static boolean monkeyR3(Region r) {

			TreeRegion tr = new TreeRegion();

			if(Gdx.input.justTouched()) {
				if ((Gdx.input.getX() > tr.r3.xmin && Gdx.input.getX() < tr.r3.xmax)
						&& (Gdx.input.getY() > tr.r3.ymin && Gdx.input.getY() < tr.r3.ymax)) {
					return true;
				} else
					return false;
			}
			return false;
	}

	private static boolean monkeyR2(Region r) {
		
			TreeRegion tr = new TreeRegion();

			if(Gdx.input.justTouched()) {
				if ((Gdx.input.getX() > tr.r2.xmin && Gdx.input.getX() < tr.r2.xmax)
						&& (Gdx.input.getY() > tr.r2.ymin && Gdx.input.getY() < tr.r2.ymax)) {
					return true;
				} else
					return false;
			}
			return false;
	}

	private static boolean monkeyR1(Region r) {
	
		TreeRegion tr = new TreeRegion();

		if(Gdx.input.justTouched()) { 
			if ((Gdx.input.getX(0) > tr.r1.xmin && Gdx.input.getX(0) < tr.r1.xmax)
					&& (Gdx.input.getY(0) > tr.r1.ymin && Gdx.input.getY(0) < tr.r1.ymax)) {
				return true;
			} else
				return false;
		}
		return false;
	}

	
	
}
