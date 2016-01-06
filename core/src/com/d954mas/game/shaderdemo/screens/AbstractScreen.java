package com.d954mas.game.shaderdemo.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.d954mas.game.shaderdemo.Constants;
import com.d954mas.game.shaderdemo.ShaderDemo;
import com.d954mas.game.shaderdemo.utils.Assets;
import com.d954mas.game.shaderdemo.utils.ShaderPair;
import com.d954mas.game.shaderdemo.utils.UIUtils;

public class AbstractScreen implements Screen {
    protected Group group;
    protected Button backButton;
    protected ShaderPair shaderPair;

    @Override
    public void show() {
        ShaderDemo.stage.clear();
        group=new Group();
        group.setSize(Constants.WIDTH, Constants.HEIGHT);
        backButton=new Button(new TextureRegionDrawable(new TextureRegion(Assets.badlogic)));
        UIUtils.setSizeByWidth(backButton,40f);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ShaderDemo.shaderDemo.setScreen(new MainScreen());
            }
        });
        group.addActor(backButton);
        ShaderDemo.stage.addActor(group);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        shaderPair.dispose();
        ShaderDemo.stage.getBatch().setShader(null);
    }
}
