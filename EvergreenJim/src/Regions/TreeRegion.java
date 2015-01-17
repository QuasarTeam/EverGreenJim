package Regions;

import com.badlogic.gdx.Gdx;

public class TreeRegion implements Region {

	// Variables para acceder a las clases Resgion1, Region2 ... desde afuera
	// ¿Son necesarias o se puede acceder a tales clases directamente?
	public Region1 r1 = new Region1();
	public Region2 r2 = new Region2();
	public Region3 r3 = new Region3();

	// Forman regiones cuadradas igualmente distribuídas en la pantalla
	public class Region1 implements Region {
		// xmin: x mínima en la región
		// xmax: x máxima en la región
		public long xmin = Gdx.graphics.getWidth() / 15;
		public long xmax = xmin + Gdx.graphics.getWidth() / 10;

		public long ymax = Gdx.graphics.getHeight() / 3;
		public long ymin = 0;

	}

	public class Region2 implements Region {

		public long xmin = Gdx.graphics.getWidth() / 15;
		public long xmax = xmin + Gdx.graphics.getWidth() / 10;

		public long ymin = Gdx.graphics.getHeight() / 3;
		public long ymax = (Gdx.graphics.getHeight() / 3) * 2;

	}

	public class Region3 implements Region {

		public long xmin = Gdx.graphics.getWidth() / 15;
		public long xmax = xmin + Gdx.graphics.getWidth() / 10;

		public long ymin = (Gdx.graphics.getHeight() / 3) * 2;
		public long ymax = Gdx.graphics.getHeight();

	}

}
