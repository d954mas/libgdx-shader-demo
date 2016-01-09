package com.d954mas.game.shaderdemo.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.d954mas.game.shaderdemo.ShaderDemo;
import com.d954mas.game.shaderdemo.utils.Assets;
import com.d954mas.game.shaderdemo.utils.ShaderPair;

public class MainScreen extends AbstractScreen{
    private Table table;

    @Override
    public void show() {
        super.show();
        backButton.remove();
        shaderPair=new ShaderPair(null);
        ShaderDemo.stage.getBatch().setShader(shaderPair.getShaderProgram());
        table=new Table(Assets.uiSkin);
        table.setFillParent(true);
        table.defaults().spaceBottom(10f);
        group.addActor(table);
        addShaderButton("blinkShader", BlinkShaderScreen.class);
        addShaderButton("blackAndWhite", BlackAndWhiteScreen.class);
        addShaderButton("grayscale", BlackAndWhiteScreen.class);
        addShaderButton("invertedColors", InvertedColorsScreen.class);
        addShaderButton("blackGradient", BlackGradient.class);
        addShaderButton("vignette", VignetteScreen.class);
        addShaderButton("stonesNormals", StonesNormalsScreen.class);
        addShaderButton("presentBox", PresentBoxScreen.class);
    }

    private void addShaderButton(String text,final Class<? extends Screen> clazz){
        TextButton shaderButton=new TextButton(text,Assets.uiSkin);

        shaderButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Screen screen;
                try {
                    screen= clazz.newInstance();
                    ShaderDemo.shaderDemo.setScreen(screen);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        table.add(shaderButton).row();
    }

}
