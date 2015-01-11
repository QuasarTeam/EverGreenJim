package com.quasar.EvergreenJim;
import com.badlogic.gdx.Gdx;

import Regions.MonkeyRegion;
import Regions.MonkeyRegion.Region1;
import Regions.Region;

public class Tap {
	
	public static boolean isInside(Region r) {
		
		if (r instanceof MonkeyRegion.Region1) {

			MonkeyRegion mr = new MonkeyRegion();

			if ((Gdx.input.getX() > mr.r1.xmin && Gdx.input.getX() < mr.r1.xmax)
					&& (Gdx.input.getY() > mr.r1.ymin && Gdx.input.getY() < mr.r1.ymax)) {
				return true;
			} else
				return false;
		}
		return false;
		
	}
	
	private static boolean insideMonkey(Region r) {
	

//		if (r instanceof MonkeyRegion.Region2) {
//
//			MonkeyRegion mr = new MonkeyRegion();
//
//			if ((Gdx.input.getX() > mr.r2.xmin && Gdx.input.getX() < mr.r2.xmax)
//					&& (Gdx.input.getY() > mr.r2.ymin && Gdx.input.getY() < mr.r2.ymax)) {
//				return true;
//			} else
//				return false;
//		}
		return false;

	}
	
	
}
