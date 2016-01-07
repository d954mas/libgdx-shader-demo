package com.d954mas.game.shaderdemo.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.d954mas.game.shaderdemo.ShaderDemo;
import com.d954mas.game.shaderdemo.utils.Assets;
import com.d954mas.game.shaderdemo.utils.ShaderPair;
import com.d954mas.game.shaderdemo.utils.UIUtils;

public class BlackAndWhiteScreen extends ScreenWithImage {
    @Override
    protected ShaderPair getShaderPair() {
        return new ShaderPair(null,"blackAndWhite");
    }
}
