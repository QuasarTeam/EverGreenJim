package com.quasar.EvergreenJim;

import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable {
static Assets.AssetMonkey asm;
static Assets.AssetTree ast;

	
	public static void loadAssets() {
		new Assets();
		
		asm = Assets.asm;
		ast = Assets.ast;
		
		ast.load();
		asm.load();
		
		
	}
	
	public static void update() {
		ast.render();
		asm.render();
		
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

}
