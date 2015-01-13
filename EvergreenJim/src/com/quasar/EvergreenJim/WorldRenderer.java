package com.quasar.EvergreenJim;

import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable {
static Assets.AssetMonkey asm;

	
	public static void loadAssets() {
		asm = new Assets().am;
		asm.load();
	}
	
	public static void update() {
		asm.render();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

}
