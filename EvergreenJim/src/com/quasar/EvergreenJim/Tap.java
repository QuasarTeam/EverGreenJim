package com.quasar.EvergreenJim;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import Regions.MonkeyRegion;
import Regions.Region;

public class Tap {

	
	public static void getInput(InputProcessor in) {	
	}
	
	public static boolean isInside(Region r) {
		
		if (r instanceof MonkeyRegion.Region1) {

			return monkeyR1(r);
		}
		
		if (r instanceof MonkeyRegion.Region2) {

			return monkeyR2(r);
		}
		
		if (r instanceof MonkeyRegion.Region3) {

			return monkeyR3(r);
		}
		
		
		return false;
		
	}
	
	// Los siguientes métodos identifican si se ha hecho click dentro de alguna de las regiones.
	private static boolean monkeyR3(Region r) {

			MonkeyRegion mr = new MonkeyRegion();

			if(Gdx.input.justTouched()) {
				if ((Gdx.input.getX() > mr.r3.xmin && Gdx.input.getX() < mr.r3.xmax)
						&& (Gdx.input.getY() > mr.r3.ymin && Gdx.input.getY() < mr.r3.ymax)) {
					return true;
				} else
					return false;
			}
			return false;
	}

	private static boolean monkeyR2(Region r) {
		
			MonkeyRegion mr = new MonkeyRegion();

			if(Gdx.input.justTouched()) {
				if ((Gdx.input.getX() > mr.r2.xmin && Gdx.input.getX() < mr.r2.xmax)
						&& (Gdx.input.getY() > mr.r2.ymin && Gdx.input.getY() < mr.r2.ymax)) {
					return true;
				} else
					return false;
			}
			return false;
	}

	private static boolean monkeyR1(Region r) {
	
		MonkeyRegion mr = new MonkeyRegion();

		if(Gdx.input.justTouched()) { 
			if ((Gdx.input.getX(0) > mr.r1.xmin && Gdx.input.getX(0) < mr.r1.xmax)
					&& (Gdx.input.getY(0) > mr.r1.ymin && Gdx.input.getY(0) < mr.r1.ymax)) {
				return true;
			} else
				return false;
		}
		return false;
	}

	
	
}
