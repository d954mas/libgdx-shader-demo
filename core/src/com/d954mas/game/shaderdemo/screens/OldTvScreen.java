package com.d954mas.game.shaderdemo.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.d954mas.game.shaderdemo.utils.ShaderPair;

public class OldTvScreen extends ScreenWithImage {
    private boolean useImg=true;
    @Override
    public void show() {
        super.show();
        shaderPair.getShaderProgram().begin();
        shaderPair.getShaderProgram().setUniformi("use_img",1);
        shaderPair.getShaderProgram().end();
        badlogic.setFillParent(true);
        badlogic.setPosition(0, 0);
        badlogic.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                useImg=!useImg;
                shaderPair.getShaderProgram().begin();
                shaderPair.getShaderProgram().setUniformi("use_img",useImg ? 1:0);
                shaderPair.getShaderProgram().end();
            }
        });
    }

    @Override
    protected ShaderPair getShaderPair() {
        return new ShaderPair(null,"oldTv");
    }
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        shaderPair.getShaderProgram().begin();
        shaderPair.getShaderProgram().setUniformf("iResolution", width, height);
        shaderPair.getShaderProgram().end();

    }

    float time;
    @Override
    public void render(float delta) {
        super.render(delta);
        time+=delta;
        shaderPair.getShaderProgram().begin();
        shaderPair.getShaderProgram().setUniformf("iGlobalTime", time);
        shaderPair.getShaderProgram().end();

    }
}
