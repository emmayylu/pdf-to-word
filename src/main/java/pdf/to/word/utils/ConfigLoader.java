package pdf.to.word.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    /**
     * Load a configuration value.
     * @param name Configuration name
     * @return String Configuration value
     */
    public static String loadConfig(String name) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("config.properties"));
        return prop.getProperty(name);
    }
}
