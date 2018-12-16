/*
This file includes all the configuration properties
 */

package tripAction.dataprovider;

import tripAction.utility.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

    private Properties prop;
    Utility ul;

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

    String firstPart = null;
    String lastPart = null;
    StringBuffer sb = null;

    public String getCheckinDate() {
        return prop.getProperty("checkIn");
    }

    public String getCheckoutDate() {
        return prop.getProperty("checkOut");
    }

    public String calculateXpathSelRooms(int position) {
        firstPart = "//*[@id='hprt-form']/table/tbody/tr[";
        lastPart = "]/td/div/label/select";
        return firstPart + Integer.toString(position) + lastPart;
    }


}
