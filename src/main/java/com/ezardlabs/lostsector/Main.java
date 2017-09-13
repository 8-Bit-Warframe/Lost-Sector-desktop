package com.ezardlabs.lostsector;

import com.ezardlabs.dethsquare.util.DesktopLauncher;
import com.ezardlabs.lostsector.map.MapManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		File file = new File("map.tmx");
		System.out.println(file + ": " + file.exists());
		if (file.exists()) {
			MapManager.overrideMapName = file.getAbsolutePath();
		}
		if (args.length == 1 && args[0].equals("--version")) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(Thread
						.currentThread().getContextClassLoader().getResourceAsStream(
								"version.txt")));
				int version = Integer.parseInt(reader.readLine());
				reader.close();
				System.out.println(version);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			new DesktopLauncher().launch(new Game());
			System.exit(0);
		}
	}
}
