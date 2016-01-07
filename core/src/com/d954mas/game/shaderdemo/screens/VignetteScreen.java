package com.d954mas.game.shaderdemo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.d954mas.game.shaderdemo.ShaderDemo;
import com.d954mas.game.shaderdemo.actors.ProgressBarWithText;
import com.d954mas.game.shaderdemo.utils.Assets;
import com.d954mas.game.shaderdemo.utils.ShaderPair;
import com.d954mas.game.shaderdemo.utils.UIUtils;

public class VignetteScreen extends AbstractScreen {
    private boolean shaderEnabled;
    private Table table;

    @Override
    public void show() {
        super.show();
        shaderPair=new ShaderPair(null,"vignette");
        ShaderDemo.stage.getBatch().setShader(shaderPair.getShaderProgram());
        Image image=new Image(Assets.scene);
        image.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //shaderEnabled = !shaderEnabled;
               // if (shaderEnabled) ShaderDemo.stage.getBatch().setShader(shaderPair.getShaderProgram());
                //else ShaderDemo.stage.getBatch().setShader(null);
            }
        });
        image.setFillParent(true);

        shaderPair.getShaderProgram().begin();
        shaderPair.getShaderProgram().setUniformf("radius", 0.75f);
        shaderPair.getShaderProgram().setUniformf("softness", 0.45f);
        shaderPair.getShaderProgram().setUniformf("sepia", 1.2f, 1f, 0.8f);
        shaderPair.getShaderProgram().setUniformf("mixStrength", 0.5f);
        shaderPair.getShaderProgram().end();

        table=new Table();
        table.setFillParent(true);
        table.defaults().right();

        addSlider("radius", 0, 2, 0.01f, 0.75f);
        addSlider("softness",0,1,0.01f,0.45f);
        addSlider("mixStrength",0,1,0.01f,0.5f);

        group.addActor(image);
        group.addActor(table);
        group.addActor(backButton);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        shaderPair.getShaderProgram().begin();
        shaderPair.getShaderProgram().setUniformf("resolution", width, height);
        shaderPair.getShaderProgram().end();
    }

    private ProgressBarWithText addSlider(final String name,float min,float max,float stepSize,float defValue){
        final ProgressBarWithText slider=new ProgressBarWithText(name,min,max,stepSize);
        slider.getSlider().setValue(defValue);
        slider.getSlider().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                shaderPair.getShaderProgram().begin();
                shaderPair.getShaderProgram().setUniformf(
                        name, slider.getSlider().getValue());
                shaderPair.getShaderProgram().end();
            }
        });
        table.add(slider).row();
        return slider;
    }
}
