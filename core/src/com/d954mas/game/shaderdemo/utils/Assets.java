package com.d954mas.game.shaderdemo.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets{
    public static Texture badlogic;
    public static Texture scene;
    public static Skin uiSkin;

    public static void load(AssetManager assetManager){
        assetManager.setErrorListener(new AssetErrorListener() {
            @Override
            public void error(AssetDescriptor asset, Throwable throwable) {
                Gdx.app.error("Assets", "Could not load asset " + asset.fileName + " ", throwable);
            }
        });
        assetManager.load("badlogic.jpg", Texture.class);
        assetManager.load("scene.png", Texture.class);
        assetManager.load("uiskin.json", Skin.class);
        assetManager.finishLoading();

        badlogic=assetManager.get("badlogic.jpg");
        scene=assetManager.get("scene.png");
        uiSkin=assetManager.get("uiskin.json");
    }

}