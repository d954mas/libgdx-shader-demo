package com.d954mas.game.shaderdemo.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Disposable;

public class ShaderPair{
    private ShaderProgram shaderProgram;
    public ShaderPair(String vertexKey,String fragmentKey){
        if(vertexKey==null)vertexKey="default";
        if(fragmentKey==null)fragmentKey="default";
        vertexKey="shaders/"+vertexKey+".vert";
        fragmentKey="shaders/"+fragmentKey+".frag";
        shaderProgram=new ShaderProgram(Gdx.files.internal(vertexKey),Gdx.files.internal(fragmentKey));
        if(!shaderProgram.isCompiled()) throw new RuntimeException("Shader is not compile "+shaderProgram.getLog());
    }
    public ShaderPair(String key){
        this(key,key);
    }

    public ShaderProgram getShaderProgram() {
        return shaderProgram;
    }

    public void dispose() {
        shaderProgram.dispose();
    }
}
