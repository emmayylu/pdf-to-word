package pdf.to.word.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    /**
     * Load a configuration value.
     * @param name Configuration name
     * @return String Configuration value
     * @throws IOException
     */
    public static String loadConfig(String name) throws IOException {
        InputStream input = new FileInputStream("config.properties");
        Properties prop = new Properties();
        prop.load(input);
        return prop.getProperty(name);
    }
}
