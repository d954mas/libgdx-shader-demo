package com.d954mas.game.shaderdemo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.d954mas.game.shaderdemo.ShaderDemo;
import com.d954mas.game.shaderdemo.utils.Assets;
import com.d954mas.game.shaderdemo.utils.ShaderPair;
import com.d954mas.game.shaderdemo.utils.UIUtils;

public class OutlineScreen extends AbstractScreen {
    float x=0, y=0,height = 640, width = 960, outlineSize = 3f;
    @Override
    public void show() {
        super.show();
        shaderPair = new ShaderPair("outline", "outline");
        ShaderDemo.stage.getBatch().setShader(shaderPair.getShaderProgram());
    }

    @Override
    public void render(float delta) {
        shaderPair.getShaderProgram().begin();
        shaderPair.getShaderProgram().setUniformf("u_viewportInverse", new Vector2(1f / width, 1f / height));
        shaderPair.getShaderProgram().setUniformf("u_offset", outlineSize);
        shaderPair.getShaderProgram().setUniformf("u_step", Math.min(1f, width / 70f));
        shaderPair.getShaderProgram().setUniformf("u_color", new Vector3(1, 0, 1f));
        shaderPair.getShaderProgram().end();
        Batch batch=ShaderDemo.stage.getBatch();
        batch.setShader(shaderPair.getShaderProgram());
        batch.begin();
        batch.draw(Assets.ship, x, y, width, height);
        batch.end();
        batch.setShader(null);
        ShaderDemo.stage.draw();

    }

}
