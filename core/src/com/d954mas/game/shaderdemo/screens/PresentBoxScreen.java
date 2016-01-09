package com.d954mas.game.shaderdemo.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.d954mas.game.shaderdemo.Constants;
import com.d954mas.game.shaderdemo.ShaderDemo;
import com.d954mas.game.shaderdemo.actors.ProgressBarWithText;
import com.d954mas.game.shaderdemo.utils.Assets;
import com.d954mas.game.shaderdemo.utils.ShaderPair;

public class PresentBoxScreen extends AbstractScreen  {
        @Override
    public void show() {
        super.show();
        shaderPair=new ShaderPair(null,"presentBox");
        ShaderDemo.stage.getBatch().setShader(shaderPair.getShaderProgram());
            Image image=new Image(Assets.badlogic);
            image.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //shaderEnabled = !shaderEnabled;
                    // if (shaderEnabled) ShaderDemo.stage.getBatch().setShader(shaderPair.getShaderProgram());
                    // else ShaderDemo.stage.getBatch().setShader(null);
                }
            });
            image.setFillParent(true);
            group.addActor(image);
       // group.addActor(backButton);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        shaderPair.getShaderProgram().begin();
        shaderPair.getShaderProgram().setUniformf("u_resolution", width, height);
        shaderPair.getShaderProgram().end();
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
