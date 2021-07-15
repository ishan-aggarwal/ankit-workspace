package kwic2;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	Properties config = new Properties();

	public ReadProperties(String path) {

		try {
			config.load(ReadProperties.class.getClassLoader().getResourceAsStream(path));
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public Properties getProperties() {
		return config;
	}

	public String[] getProperty() {
		String[] stopWords = config.getProperty("stopwords").split(",");
		return stopWords;
	}
}
