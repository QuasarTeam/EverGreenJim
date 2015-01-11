package Regions;

import com.badlogic.gdx.Gdx;

public class MonkeyRegion implements Region {

	public Region1 r1 = new Region1();
	public Region2 r2 = new Region2();
	public Region3 r3 = new Region3();

	public class Region1 implements Region {

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
