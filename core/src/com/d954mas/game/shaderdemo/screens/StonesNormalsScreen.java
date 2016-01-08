package com.d954mas.game.shaderdemo.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.d954mas.game.shaderdemo.Constants;
import com.d954mas.game.shaderdemo.ShaderDemo;
import com.d954mas.game.shaderdemo.utils.Assets;
import com.d954mas.game.shaderdemo.utils.ShaderPair;

public class StonesNormalsScreen extends AbstractScreen {
    // position of our light
    final Vector3 DEFAULT_LIGHT_POS = new Vector3(0f, 0f, 0.07f);
    // the color of our light
    final Vector3 DEFAULT_LIGHT_COLOR = new Vector3(1f, 0.7f, 0.6f);
    // the ambient color (color to use when unlit)
    final Vector3 DEFAULT_AMBIENT_COLOR = new Vector3(0.3f, 0.3f, 1f);
    // the attenuation factor: x=constant, y=linear, z=quadratic
    final Vector3 DEFAULT_ATTENUATION = new Vector3(0.4f, 3f, 20f);
    // the ambient intensity (brightness to use when unlit)
    final float DEFAULT_AMBIENT_INTENSITY = 0.2f;
    final float DEFAULT_STRENGTH = 1f;

    final Color NORMAL_VCOLOR = new Color(1f,1f,1f,DEFAULT_STRENGTH);

    // the position of our light in 3D space
    Vector3 lightPos = new Vector3(DEFAULT_LIGHT_POS);
    // the resolution of our game/graphics
    Vector2 resolution = new Vector2();
    // the current attenuation
    Vector3 attenuation = new Vector3(DEFAULT_ATTENUATION);
    // the current ambient intensity
    float ambientIntensity = DEFAULT_AMBIENT_INTENSITY;
    float strength = DEFAULT_STRENGTH;

    private OrthographicCamera camera;

    @Override
    public void show() {
        super.show();
        camera=new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        shaderPair=new ShaderPair(null,"stonesNormals");
        ShaderDemo.stage.getBatch().setShader(shaderPair.getShaderProgram());

        shaderPair.getShaderProgram().begin();
        //our normal map
        shaderPair.getShaderProgram().setUniformi("u_normals", 1); //GL_TEXTURE1
        //light/ambient colors
        //LibGDX doesn't have Vector4 class at the moment, so we pass them individually...
        // set resolution vector
        resolution.set(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // we are only using this many uniforms for testing purposes...!!
        shaderPair.getShaderProgram().begin();
        shaderPair.getShaderProgram().setUniformi("u_texture", 0);
        shaderPair.getShaderProgram().setUniformi("u_normals", 1);
        shaderPair.getShaderProgram().setUniformf("light", lightPos);
        shaderPair.getShaderProgram().setUniformf("strength", strength);
        shaderPair.getShaderProgram().setUniformf("ambientIntensity", ambientIntensity);
        shaderPair.getShaderProgram().setUniformf("ambientColor", DEFAULT_AMBIENT_COLOR);
        shaderPair.getShaderProgram().setUniformf("resolution", resolution);
        shaderPair.getShaderProgram().setUniformf("lightColor", DEFAULT_LIGHT_COLOR);
        shaderPair.getShaderProgram().setUniformf("attenuation", attenuation);
        shaderPair.getShaderProgram().end();


    }

    @Override
    public void resize(int width, int height) {
        Gdx.gl.glViewport(0,0,width,height);
        camera.setToOrtho(false, width, height);
        shaderPair.getShaderProgram().begin();
        shaderPair.getShaderProgram().setUniformf("resolution", width, height);
        shaderPair.getShaderProgram().end();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        ShaderDemo.stage.getBatch().begin();
        lightPos.x = Gdx.input.getX();
        lightPos.y = Gdx.graphics.getHeight() - Gdx.input.getY();
        // update our uniforms
        shaderPair.getShaderProgram().setUniformf("ambientIntensity", ambientIntensity);
        shaderPair.getShaderProgram().setUniformf("attenuation", attenuation);
        shaderPair.getShaderProgram().setUniformf("light", lightPos);
        shaderPair.getShaderProgram().setUniformf("strength", strength);


        //bind normal map to texture unit 1
        Assets.stonesNormalMap.bind(1);

        //bind diffuse color to texture unit 0
        //important that we specify 0 otherwise we'll still be bound to glActiveTexture(GL_TEXTURE1)
        Assets.stones.bind(0);

        //draw the texture unit 0 with our shader effect applied
        ShaderDemo.stage.getBatch().draw(Assets.stones, 0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        ShaderDemo.stage.getBatch().end();

        ShaderDemo.stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        Gdx.input.setInputProcessor(ShaderDemo.stage);
        ShaderDemo.stage.getViewport().apply();
    }
}
