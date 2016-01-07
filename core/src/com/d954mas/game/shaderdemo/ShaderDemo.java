package com.d954mas.game.shaderdemo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.d954mas.game.shaderdemo.screens.MainScreen;
import com.d954mas.game.shaderdemo.utils.Assets;

public class ShaderDemo extends Game {
	public static Stage stage;
	private AssetManager assetManager;
	public static ShaderDemo shaderDemo; // need to changing screen

	@Override
	public void create () {
		shaderDemo=this;
		ShaderProgram.pedantic=false;
		stage=new Stage(new FitViewport(Constants.WIDTH,Constants.HEIGHT));
		Gdx.input.setInputProcessor(stage);
		assetManager=new AssetManager();
		Assets.load(assetManager);
		setScreen(new MainScreen());
		Gdx.input.setCatchBackKey(true);
	}

	@Override
	public void render () {
		if (Gdx.input.isKeyJustPressed(Input.Keys.BACK) || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			if(!(screen instanceof MainScreen)){
				setScreen(new MainScreen());
			}
		}
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
		super.render();
	}

	@Override
	public void pause() {
		if(screen!=null)screen.pause();
	}

	@Override
	public void dispose() {
		super.dispose();
		shaderDemo=null;
		stage.dispose();
		assetManager.dispose();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width,height);
		super.resize(width, height);
	}
}
