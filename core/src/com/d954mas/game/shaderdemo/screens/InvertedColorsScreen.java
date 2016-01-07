package com.d954mas.game.shaderdemo.screens;

import com.d954mas.game.shaderdemo.utils.ShaderPair;

public class InvertedColorsScreen extends ScreenWithImage {
    @Override
    protected ShaderPair getShaderPair() {
        return new ShaderPair(null,"invertColors");
    }
}
