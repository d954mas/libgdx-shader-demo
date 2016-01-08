package com.d954mas.game.shaderdemo.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.d954mas.game.shaderdemo.utils.Assets;

public class ProgressBarWithText extends Table {
    private Slider progressBar;
    public ProgressBarWithText(String title,float min,float max,float stepSize){
        super(Assets.uiSkin);
        defaults().spaceLeft(10f);
        progressBar=new Slider(min,max,stepSize,false,Assets.uiSkin);
        add(title);
        add(String.valueOf(min));
        add(progressBar);
        add(String.valueOf(max));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        ShaderProgram shaderProgram=batch.getShader();
        batch.setShader(null);
        super.draw(batch, parentAlpha);
        batch.setShader(shaderProgram);
    }

    public Slider getSlider() {
        return progressBar;
    }
}
