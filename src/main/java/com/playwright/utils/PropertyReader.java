package com.playwright.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertyReader {
	private PropertyReader() {
	}

	private static final String CONFIG_PATH = "./src/test/resources/config.properties";

	public static String readProperty(String key) {
		String value = "";
		Properties property = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(CONFIG_PATH);
			property.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		value = property.getProperty(key);

		try {
			if (Objects.isNull(value)) {
				throw new Exception("Property Name " + value + " not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
