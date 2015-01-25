package Fruits;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.quasar.EvergreenJim.Constants;
import com.quasar.EvergreenJim.Monkey;

public class Banana implements Fruit {

	
	private static Texture lemonImage; // Variable textura de la fruta

	public static boolean canCreateMore; 
	static double yVelocity;
	private static SpriteBatch batch;
	private static OrthographicCamera camera;
	private static Array<Rectangle> lemons;
	public static boolean loaded;
	public static double time;
	public static boolean tapEnabled = true;

	public static void load() {
		canCreateMore = true;
		lemonImage = new Texture(Gdx.files.internal("banana.png"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		lemons = new Array<Rectangle>();
	}

	public static void create(float yPos) {
		Rectangle lemon = new Rectangle();
		lemon.x = 64;
		lemon.y = yPos - 80;
		lemon.width = 64;
		lemon.height = 64;
		lemons.add(lemon);
		time = Gdx.graphics.getDeltaTime();
	}

	public static void render() {

		// Render constante de todos los limones que estén en el array (array de
		// LibGDX)
		batch.begin();
		for (Rectangle lemon : lemons) {
			batch.draw(lemonImage, lemon.x, lemon.y);

		}
		batch.end();

		// Para producir sólo un limón por cada tap
		if (canCreateMore) {
			create(Monkey.getCurrentPosition());

			canCreateMore = false;
		}
		

		// Se recorre el array moviendo los limones (rectángulos) que tenga
		Iterator<Rectangle> iter = lemons.iterator();
		while (iter.hasNext()) {
			Rectangle lemon = iter.next();

			lemon.x += Constants.MAX_SPEED * time;
			tapEnabled = false; // Esto evita que se creen nuevas frutas
								// mientras alguna está en el aire.

			if (lemon.x + 64 > Gdx.graphics.getWidth()){
				yVelocity = 1.0;
				iter.remove();
				tapEnabled = true;
				
			}
		}
	}
	
}
