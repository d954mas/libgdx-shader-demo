package com.d954mas.game.shaderdemo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.d954mas.game.shaderdemo.ShaderDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=960;
		config.height=640;
		new LwjglApplication(new ShaderDemo(), config);
	}
}
