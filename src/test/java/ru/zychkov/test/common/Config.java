package ru.zychkov.test.common;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.Classpath("test.properties")
public class Config {

    private static Config config;

    private Config(){
        PropertyLoader.populate(this);
    }

    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    @Property("hostName")
    private String hostName;

    @Property("portalUserLogin")
    private String userLogin;

    @Property("portalUserPassword")
    private String userPassword;

    @Property("portalUserName")
    private String userName;

    @Property("pathToTestFile")
    private String pathToTestFile;

    @Property("selenoidHost")
    private String selenoidHost;

    @Property("selenoidBrowser")
    private String selenoidBrowser;

    @Property("browser")
    private String browser;

    @Property("defaultSleep")
    private int defaultSleep;

    public String getHostName() {
        return hostName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getPathToTestFile() {
        return pathToTestFile;
    }

    public String getSelenoidHost() {
        return selenoidHost;
    }

    public String getSelenoidBrowser() {
        return selenoidBrowser;
    }

    public String getBrowser() {
        return browser;
    }

    public int getDefaultSleep() {
        return defaultSleep;
    }
}