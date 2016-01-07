package com.d954mas.game.shaderdemo.screens;

import com.d954mas.game.shaderdemo.utils.ShaderPair;

public class GrayScaleScreen extends ScreenWithImage {
    @Override
    protected ShaderPair getShaderPair() {
        return new ShaderPair(null,"grayscale");
    }
}
