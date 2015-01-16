package com.quasar.EvergreenJim;

import Regions.TreeRegion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Assets {
	TreeRegion tr;
	public static final String TAG = Assets.class.getName();
	public static AssetTree ast;
	public static AssetMonkey asm;

	public Assets() {
		tr = new TreeRegion();
		ast = new AssetTree();
		asm = new AssetMonkey();
	}

	// Carga y dibuja la textura del mono.
	public class AssetMonkey {
		private OrthographicCamera camera;
		SpriteBatch batch;
		AssetManager am;
		Texture tex;
		Rectangle monkey; // El rectángulo es el que se va a mover, la textura
							// del mono va a estar dentro del rectángulo.
		private TreeRegion tr;

		public AssetMonkey() {

			camera = new OrthographicCamera();
			tr = new TreeRegion();
			am = new AssetManager();
			batch = new SpriteBatch();
			monkey = new Rectangle();
			// El mono aparece en el centro de la región 3.
			monkey.x = (tr.r3.xmax + tr.r3.xmin) / 2;
			monkey.y = (tr.r3.ymax + tr.r3.ymin) / 2 - 234; // Corregir esto
			monkey.width = 64;
			monkey.height = 64;
		}

		void load() {

			camera.setToOrtho(false, 800, 480);
			am.load("test.png", Texture.class);
			tex = new Texture(Gdx.files.internal("test.png"));
		}

		public void render() {
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			batch.draw(tex, monkey.x, monkey.y);
			batch.end();
		}
	}

	public class AssetTree {
		private OrthographicCamera camera;
		SpriteBatch batch;
		Texture tex;
		Rectangle tree; // Se mete la texture dentro de un rectángulo para
						// facilitar su manipulación

		public AssetTree() {
			camera = new OrthographicCamera();
			tr = new TreeRegion();
			batch = new SpriteBatch();
			tree = new Rectangle();
			tree.x = 32;
			tree.y = 0;

		}

		void load() {

			camera.setToOrtho(false, 800, 480);
			tex = new Texture(Gdx.files.internal("tree.png"));
		}

		public void render() {
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			batch.draw(tex, tree.x, tree.y);
			batch.end();
		}

	}

}
