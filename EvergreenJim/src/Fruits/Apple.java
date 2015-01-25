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

public class Apple implements Fruit {

	private static Texture appleImage;

	public static boolean canCreateMore;
	static double yVelocity;
	private static SpriteBatch batch;
	private static OrthographicCamera camera;
	private static Array<Rectangle> apples;
	public static boolean loaded;
	public static double gravity;
	public static double time;
	public static boolean tapEnabled;

	public static void load() {
		canCreateMore = true;
		appleImage = new Texture(Gdx.files.internal("apple.png"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		apples = new Array<Rectangle>();
		gravity = 1000.0f;
		yVelocity = 1;
		tapEnabled = true; // Al principio si se puede hacer tap para que se
							// lanze una fruta
	}

	public static void create(float yPos) {
		Rectangle apple = new Rectangle();
		apple.x = 64;
		apple.y = yPos - 80;
		apple.width = 64;
		apple.height = 64;
		apples.add(apple);
		time = Gdx.graphics.getDeltaTime();
	}

	public static void render() {

		// Render constante de todos los limones que estén en el array (array de
		// LibGDX)
		batch.begin();
		for (Rectangle apple : apples) {
			batch.draw(appleImage, apple.x, apple.y);

		}
		batch.end();

		// Para producir sólo un limón por cada tap.
		if (canCreateMore) {
			create(Monkey.getCurrentPosition());

			canCreateMore = false;
		}

		// Se recorre el array moviendo los limones (rectángulos) que tenga.
		Iterator<Rectangle> iter = apples.iterator();
		while (iter.hasNext()) {
			Rectangle apple = iter.next();

			// x1 = x0 + v*t
			apple.x += Constants.MID_SPEED * time;
			// y1 = y0 + v0 + g*t^2
			yVelocity += gravity * time; // La velocidad tiene que ir aumentando
											// para generar acceleracion.
			apple.y -= yVelocity * time; 

			tapEnabled = false; // Esto evita que se creen nuevas frutas
								// mientras alguna está en el aire.
			if (apple.y < 0) {
				yVelocity = 1.0;
				iter.remove();
				tapEnabled = true;

			}
		}
	}
}
