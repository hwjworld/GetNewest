package com.founder.enp.config;

import java.util.ResourceBundle;

import com.founder.enp.util.XMLProperties;

public class ConfigManager {
	private static XMLProperties properties = null;
	private static String configFilePath = null;
	private static String home = null;
	private static String configFileName = "config.xml";

	public static String getConfigFileName() {
		return configFileName;
	}

	public static String getConfigFilePath() {
		if (properties == null)
			loadProperties();
		return configFilePath;
	}

	private synchronized static void loadProperties() {
		home = ResourceBundle.getBundle("config").getString("configHome");
		configFilePath = home + "/" + configFileName;
		properties = new XMLProperties(configFilePath);
	}

	public static String getConfigProperty(String name) {
		if (properties == null)
			loadProperties();
		return properties.getProperty(name);
	}

	public static String getHome() {
		if (properties == null)
			loadProperties();
		return home;
	}
}
