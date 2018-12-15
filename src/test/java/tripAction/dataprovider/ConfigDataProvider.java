/*
This file includes all the configuration properties
 */

package tripAction.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

    private Properties prop;

    public ConfigDataProvider() {
        File src = new File("./configurations/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL() {
        return prop.getProperty("applicationURL");
    }

    public String getChromePath() {
        return prop.getProperty("chromeDriverPath");
    }

    public String getCityName() {
        return prop.getProperty("cityName");
    }

    public String getStartDate() {
        return prop.getProperty("startDate");
    }

    public String getEndDate() {
        return prop.getProperty("endDate");
    }
}
