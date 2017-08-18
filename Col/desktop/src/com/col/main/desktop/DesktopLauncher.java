package com.col.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.col.main.Index;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.width = 800;
		config.height = 600;
		config.foregroundFPS = 60;
		config.backgroundFPS = 60;
		new LwjglApplication(new Index(), config);
	}
}
