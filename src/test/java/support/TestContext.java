package support;

import cucumber.api.java.it.Ma;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TestContext {

    private static WebDriver driver;
    private static String timestamp;
    private static Map<String, Object> testData = new HashMap<>();

    public static Map<String, Object> getTestDataMap(String key) {
        return (Map<String, Object>) testData.get(key);
    }

    public  static Integer getTestDataInteger(String key) {
        return (Integer) testData.get(key);
    }

    public  static String getTestDataString(String key) {
        return (String) testData.get(key);
    }


    public static void setTestData(String key, Object value) {
        testData.put(key, value);
    }

    public static String getTimestamp() {
        return timestamp;
    }

    public static void setTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("+yyyy-MM-dd-h-mm-sss");
        timestamp = dateFormat.format(new Date());
    }


    public static WebDriver getDriver() {
        return driver;
    }



    public static Map<String, String> getPosition(String title) {
        Map<String, String>  position = getData(title);
        String timestampedTitle = position.get("title");
        if (timestampedTitle != null) {
            position.put("title", timestampedTitle + getTimestamp());
        }
        String dateOpen = position.get("dateOpen");
        if (dateOpen != null) {
            String isoDateOpen = new SimpleDateFormat("yyyy-MM-dd").format(new Date(dateOpen));
            position.put("dateOpen", isoDateOpen);
        }
        return position;
    }

    public static File getFile(String fileName, String extension) {
        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + "." + extension;
        return new File(path);
    }

    public static void saveFile(String fileName, String extension, byte[] byteArray) {
        try(FileOutputStream stream = new FileOutputStream(getFile(fileName, extension))) {
            stream.write(byteArray);
            stream.flush();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static FileInputStream getStream(String fileName, String extension) {
        try {
            return new FileInputStream(getFile(fileName, extension));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static Map<String, String> getCandidate(String title){
        Map<String, String> candidate = getCandidateData(title);
        String email = candidate.get("email");
        if (email != null) {
            String[] emailPart = email.split("@");
            email = emailPart[0] + getTimestamp() + "@" + emailPart[1];
            candidate.put("email", email);
        }
        return candidate;
    }

    public static Map<String, String> getCandidateData(String title) {
        Map<String, Map<String, String>> list = new Yaml().load(getStream("candidates", "yml"));
        return list.get(title);
    }


    public static Config getConfig() {
        return new Yaml().loadAs(getStream("config", "yml"), Config.class);
//        try {
//            String configPath = System.getProperty("user.dir") + "/src/test/resources/data/config.yml";
//            return new Yaml().loadAs(new FileInputStream(new File(configPath)), Config.class);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }


    public static Map<String, String> getCandidateA(String role) {
        Map<String, String>  candidate = getData(role);
        String timestampedEmail = candidate.get("email");
        String[] emailComp = timestampedEmail.split("@");
        candidate.put("email", emailComp[0] + getTimestamp() + "@" + emailComp[1]);
        return candidate;
    }
    /////////////////////////////////////////////////////////////////////////


    public static Map<String, String> getData(String fileName) {//throws FileNotFoundException {
        return new Yaml().load(getStream(fileName, "yml"));
//        try {
//            String path = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + ".yml";
//            File file = new File(path);
//            InputStream stream = new FileInputStream(file);
//            Yaml yaml = new Yaml();
//            return yaml.load(stream);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

    /////////////////////////////////////////////////////////////////////////
    public static Actions getActions() {
        return new Actions(driver);
    }

    public static WebDriverWait getWait() {
        return getWait(getConfig().explicitTimeout);
    }

    public static WebDriverWait getWait(int timeout) {
        return new WebDriverWait(driver, timeout);
    }

    public static JavascriptExecutor getExecutor(){
        return (JavascriptExecutor) driver;
    }
    /////////////////////////////////////////////////////////////////////////

    public static void initialize() {
        initialize(getConfig().browser, getConfig().testEnv, getConfig().isHeadless);
    }

    public static void teardown() {
        driver.quit();
    }

    public static void initialize(String browser, String testEnv, boolean isHeadless) {
        String osName = System.getProperty("os.name");
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();

                Map<String, Object> chromePreferences = new HashMap<>();
                chromePreferences.put("profile.default_content_settings.geolocation", 2);
                chromePreferences.put("download.prompt_for_download", false);
                chromePreferences.put("download.directory_upgrade", true);
                chromePreferences.put("download.default_directory", getDownloadsPath());
                chromePreferences.put("credentials_enable_service", false);
                chromePreferences.put("password_manager_enabled", false);
                chromePreferences.put("safebrowsing.enabled", "true");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setExperimentalOption("prefs", chromePreferences);
                if (isHeadless) {
                    chromeOptions.setHeadless(true);
                    chromeOptions.addArguments("--window-size=1920,1080");
                    chromeOptions.addArguments("--disable-gpu");
                }

                driver = new ChromeDriver(chromeOptions);
                //driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("xpinstall.signatures.required", false);
                firefoxProfile.setPreference("app.update.enabled", false);
                firefoxProfile.setPreference("browser.download.folderList", 2);
                firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
                firefoxProfile.setPreference("browser.download.dir", getDownloadsPath());
                firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip;application/octet-stream;application/x-zip;application/x-zip-compressed;text/css;text/html;text/plain;text/xml;text/comma-separated-values");
                firefoxProfile.setPreference("browser.helperApps.neverAsk.openFile", "application/zip;application/octet-stream;application/x-zip;application/x-zip-compressed;text/css;text/html;text/plain;text/xml;text/comma-separated-values");
                firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
                firefoxProfile.setPreference("plugin.disable_full_page_plugi‌​n_for_types", "application/pdf,application/vnd.adobe.xfdf,application/vnd.‌​fdf,application/vnd.‌​adobe.xdp+xml");
                firefoxProfile.setPreference("webdriver.log.driver", "OFF");
                FirefoxOptions firefoxOptions = new FirefoxOptions().setProfile(firefoxProfile).setLogLevel(FirefoxDriverLogLevel.INFO);
                if (isHeadless) {
                    FirefoxBinary firefoxBinary = new FirefoxBinary();
                    firefoxBinary.addCommandLineOptions("--headless");
                    firefoxOptions.setBinary(firefoxBinary);
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                ieCapabilities.setCapability("requireWindowFocus", true);
                InternetExplorerOptions ieOptions = new InternetExplorerOptions(ieCapabilities);
                driver = new InternetExplorerDriver(ieOptions);
                break;
            case "grid":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.CHROME);
                capabilities.setPlatform(Platform.ANY);
                URL hubUrl = null;
                try {
                    hubUrl = new URL("http://localhost:4444/wd/hub");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(hubUrl, capabilities);
                break;
            default:
                throw new RuntimeException("Driver is not implemented for: " + browser);
        }
    }

    private static String getDriversDirPath() {
        return System.getProperty("user.dir") + String.format("%1$ssrc%1$stest%1$sresources%1$sdrivers%1$s", File.separator);
    }

    private static String getDownloadsPath() {
        return System.getProperty("user.dir") + String.format("%1$ssrc%1$stest%1$sresources%1$sdownloads%1$s", File.separator);
    }

}
