package com.d954mas.game.shaderdemo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.d954mas.game.shaderdemo.ShaderDemo;
import com.d954mas.game.shaderdemo.utils.Assets;
import com.d954mas.game.shaderdemo.utils.ShaderPair;
import com.d954mas.game.shaderdemo.utils.UIUtils;

public class BlinkShaderScreen extends AbstractScreen {
    @Override
    public void show() {
        super.show();
        shaderPair=new ShaderPair(null,"blink");
        ShaderDemo.stage.getBatch().setShader(shaderPair.getShaderProgram());
        Image badlogic=new Image(Assets.badlogic);
        UIUtils.setSizeByWidth(badlogic, 400);
        UIUtils.setToCenter(badlogic, group);
        group.addActor(badlogic);
    }

    private float time;
    @Override
    public void render(float delta) {
        super.render(delta);
        time+=delta;
        shaderPair.getShaderProgram().begin();
        shaderPair.getShaderProgram().setUniformf("u_time", time);
        shaderPair.getShaderProgram().end();
    }
}
