package com.d954mas.game.shaderdemo.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.d954mas.game.shaderdemo.ShaderDemo;
import com.d954mas.game.shaderdemo.utils.Assets;
import com.d954mas.game.shaderdemo.utils.ShaderPair;
import com.d954mas.game.shaderdemo.utils.UIUtils;

public abstract class ScreenWithImage extends AbstractScreen {

    @Override
    public void show() {
        super.show();
        shaderPair=getShaderPair();
        ShaderDemo.stage.getBatch().setShader(shaderPair.getShaderProgram());
        Image badlogic=new Image(Assets.badlogic);
        UIUtils.setSizeByWidth(badlogic, 400);
        UIUtils.setToCenter(badlogic, group);
        group.addActor(badlogic);
    }

    protected  abstract ShaderPair getShaderPair();



}
