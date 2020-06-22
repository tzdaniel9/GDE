package resources;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;
import java.util.function.Function;

import static java.lang.String.format;

public class ElementUtils {

    WebDriver driver;
    JavaScriptUtil jsUtil;
    Properties prop; //ToDO

    public static final int POLLING_TIME_PERIOD = 3;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
        jsUtil = new JavaScriptUtil(this.driver);
    }

    public List<WebElement> getElements(By locator) {
        List<WebElement> elementsList = driver.findElements(locator);
        return elementsList;
    }

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            System.out.println("locator is : " + locator);
            element = driver.findElement(locator);
            if (prop.getProperty("highlight").equalsIgnoreCase("yes")) {
                jsUtil.flash(element);
            }
            System.out.println("WebElement is created successfully : " + locator);

        } catch (Exception e) {
            System.out.println("some exception got occurred with this locator: " + locator);
        }
        return element;

    }

    public void doSendKeys(By locator, String value) {
        waitForElementPresent(locator, 10);
        getElement(locator).sendKeys(value);
    }

    public void doClick(By locator) {
        waitForElementPresent(locator, 10);
        getElement(locator).click();
    }

    public String doGetText(By locator) {
        waitForElementPresent(locator, 10);
        return getElement(locator).getText();
    }

    public boolean doIsDisplayed(By locator) {
        waitForElementPresent(locator, 10);
        return getElement(locator).isDisplayed();
    }

    // **********************************Drop Down Utils
    // *********************************

    public void doSelectByVisibleText(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(value);
    }

    public void doSelectByIndex(By locator, int index) {
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }

    public void doSelectByValue(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }

    public int doDropDownOptionsCount(By locator) {
        return doGetDropDownOptions(locator).size();
    }

    public ArrayList<String> doGetDropDownOptions(By locator) {
        ArrayList<String> ar = new ArrayList<String>();
        Select select = new Select(getElement(locator));
        List<WebElement> OptionsList = select.getOptions();

        for (int i = 0; i < OptionsList.size(); i++) {
            String text = OptionsList.get(i).getText();
            ar.add(text);
        }
        return ar;
    }

    public void doSelectDropDownValue(By locator, String value) {
        Select selectday = new Select(getElement(locator));
        List<WebElement> OptionsList = selectday.getOptions();

        for (int i = 0; i < OptionsList.size(); i++) {
            String text = OptionsList.get(i).getText();
            if (text.equals(value)) {
                OptionsList.get(i).click();
                break;
            }
        }
    }

    public void doSelectDropDownValueWithoutSelect(By locator, String value) {
        List<WebElement> optionsList = getElements(locator);

        for (int i = 0; i < optionsList.size(); i++) {
            String text = optionsList.get(i).getText();
            if (text.equals(value)) {
                optionsList.get(i).click();
                break;
            }
        }
    }

    public void selectChoiceValues(By locator, String... value) {
        // List<WebElement> choiceList =
        // driver.findElements(By.cssSelector("span.comboTreeItemTitle"));
        List<WebElement> choiceList = getElements(locator);

        if (!value[0].equalsIgnoreCase("ALL")) {

            for (int i = 0; i < choiceList.size(); i++) {
                String text = choiceList.get(i).getText();
                System.out.println(text);

                for (int k = 0; k < value.length; k++) {
                    if (text.equals(value[k])) {
                        choiceList.get(i).click();
                        break;
                    }
                }

            }
        }
        // select all the values:
        else {
            try {
                for (int all = 0; all < choiceList.size(); all++) {
                    choiceList.get(all).click();
                }
            } catch (Exception e) {

            }
        }
    }

    // **********************************Actions class Utils
    // *********************************

    public void doDragAndDrop(By source, By target) {
        Actions action = new Actions(driver);
        WebElement sourceEle = getElement(source);
        WebElement targetEle = getElement(target);
        action.dragAndDrop(sourceEle, targetEle).build().perform();
    }

    public void doActionsSendKeys(By locator, String value) {
        Actions action = new Actions(driver);
        action.sendKeys(getElement(locator), value).build().perform();
    }

    public void doActionsClick(By locator) {
        waitForElementPresent(locator, 10);
        Actions action = new Actions(driver);
        action.click(getElement(locator)).build().perform();
    }

    // ***************************** Wait Utils
    // *******************************************

    public List<WebElement> visibilityofAllElements(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForElementPresent(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    public WebElement waitForElementToBeVisible(By locator, int timeout) {
        WebElement element = getElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitForElementToBeClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public boolean waitForUrl(String url, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.urlContains(url));
    }

    public Alert waitForAlertToBePresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    // clickWhenReady:
    public void clickWhenReady(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public String waitForTitleToBePresent(String title, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }

    public WebElement waitForElementFluentWait(By locator, int timeout) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(POLLING_TIME_PERIOD))
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }


    public WebElement waitForElementWithFluentWait(By locator, int timeout) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(POLLING_TIME_PERIOD))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return getElement(locator);
            }
        });

        return element;
    }

    public static String generateSpecificDOB(int year, int months, String datePattern) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -year);
        cal.add(Calendar.MONTH, -months);
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        return dateFormatter.format(cal.getTime());
    }

    public static String getSpecificDate(int month, String format) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, month);
        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
        return dateFormatter.format(cal.getTime());
    }

    public void switchToFrame() {
        driver.switchTo().frame("");
    }

    public String getCurrentWindowHandle() {
        try {
            String windowHandle = driver.getWindowHandle();
//            log.info("Current window handle - " + windowHandle);
            return windowHandle;
        } catch (Exception e) {
//            log.error("Something went wrong while getting window " + e.getMessage());
            return null;
        }
    }

    public void switchToWindow(String windowHandle) {
        try {
            driver.switchTo().window(windowHandle);
//            log.info("Switched to window - " + windowHandle);
        } catch (Exception e) {
//            log.error("Something went wrong while switching to window " + e.getMessage());
        }
    }

    public String switchToNewWindow() {
        try {
            String firstWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
//            log.info("Number of windows: " + windowHandles.size());
            for (String windowHandle : windowHandles) {
//                log.info("Handle: " + windowHandle);
                if (!windowHandle.equalsIgnoreCase(firstWindow)) {
                    driver.switchTo().window(windowHandle);
//                    log.info("Switched to window - " + windowHandle);
                    return windowHandle;
                }
            }
        } catch (Exception e) {
//            log.error("Something went wrong while switching to new window " + e.getMessage());
        }
        return null;
    }

    public List<WebElement> getElementss(By locator) {
        List<WebElement> elementsList = driver.findElements(locator);
        return elementsList;
    }

    public void selectChoiceValuess(By locator, String... value) {
        // List<WebElement> choiceList =
        // driver.findElements(By.cssSelector("span.comboTreeItemTitle"));
        List<WebElement> choiceList = getElements(locator);

        if (!value[0].equalsIgnoreCase("ALL")) {

            for (int i = 0; i < choiceList.size(); i++) {
                String text = choiceList.get(i).getText();
                System.out.println(text);

                for (int k = 0; k < value.length; k++) {
                    if (text.equals(value[k])) {
                        choiceList.get(i).click();
                        break;
                    }
                }

            }
        }


//
//        public static String generateDateAfter2013(String datePattern) {
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.YEAR, getRandomIntegerNumber((Calendar.YEAR - 2013), 0));
//            SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
//            return dateFormat.format(cal.getTime());
//        }


    }

    public static class UploadFileRobot {

        String URL = "application URL";
//        @Test
//        public void testUpload() throws InterruptedException
//        {
//            WebDriver  driver = new FirefoxDriver();
//            driver.get(URL);
//            WebElement element = driver.findElement(By.name("uploadfile"));
//            element.click();
//            uploadFile("path to the file");
//            Thread.sleep(2000);
//        }

        /**
         * This method will set any parameter string to the system's clipboard.
         */
        public static void setClipboardData(String string) {
            //StringSelection is a class that can be used for copy and paste operations.
            StringSelection stringSelection = new StringSelection(string);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        }

        public static void uploadFile(String fileLocation) {
            try {
                //Setting clipboard with file location
                setClipboardData(fileLocation);
                //native key strokes for CTRL, V and ENTER keys
                Robot robot = new Robot();

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
    }


/*            Properties prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("C:\\Users\\dany1\\Documents\\applitools-\\MockGDE\\src\\main\\java\\QA\\config\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

    public void TypeInField(String xpath, String value){
        String val = value;
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();

        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }

    div[4]//div[2]/div[2]/table/tbody/tr[1]/td[1]
        String date = "2012-01-01";
        String dateArr[] = date.split("-");
        String year = dateArr[0];
        String  month = dateArr[1];
        String day = dateArr[2];

        Select chooseYear = new Select(driver.findElement(By.xpath("//a[@title='Choose a year']")));
        chooseYear.selectByVisibleText(year);


        Select previousMonth = new Select(driver.findElement(By.xpath("//a[@title='Previous month (PageUp)']")));
        previousMonth.selectByVisibleText(month);

        String beforeXpath = "//div[4]//div[2]/div[2]/table/tbody/tr[";
        String afterXpath = "]/td[";

        final int totalWeekDays = 7;
        boolean flag=false;
        for (int rowNum = 2;rowNum <= 7;rowNum++){
            for (int colNum = 1;colNum<=totalWeekDays;colNum++){
                String dayVal = driver.findElement(By.xpath("beforeXpath+rowNum,+afterXpath,colNum+)")).getText();
                if (dayVal.equals(day)){
                    driver.findElement(By.cssSelector(beforeXpath+rowNum+afterXpath+colNum+")")).click();
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        String dob = "2012-01-01";

         driver.findElement(By.xpath("//input[@placeholder='YYYY-MM-DD']")).click();

        WebElement date =driver.findElement(By.cssSelector(".ant-calendar-tbody"));

        List<WebElement>columns = dob.findElements(By.tagName("td"));

        for(WebElement cell: columns){
            if (cell.getText().equals(dob)){
                cell.click();
                break;
            }
        }
        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){
            e.printStackTrace();


        package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import static java.lang.String.format;
*/
    public class DatePicker {

        private WebDriver driver;

        private By openCalendarButton = By.cssSelector("#datepicker ~ span button");
        private By calendar = By.cssSelector("div[role='calendar']");
        private By period = By.cssSelector("div[role='period']");
        private By leftArrow = By.cssSelector("div[role='navigator'] i.chevron-left");
        private By rightArrow = By.cssSelector("div[role='navigator'] i.chevron-right");
        private String day_FORMAT = "//td[@day='%d' and contains(@class, 'current-month')]";

        public DatePicker(WebDriver driver) {
            this.driver = driver;
        }

        public LocalDate chooseDate(LocalDate date) {
            open();
            chooseMonth(date);
            chooseDay(date.getDayOfMonth());
            return getSelectedDate();
        }

        public LocalDate getSelectedDate() {
            String[] fields = driver.findElement(calendar).getAttribute("selectedday").split("-");
            return LocalDate.of(
                    Integer.parseInt(fields[0]),
                    Integer.parseInt(fields[1]) + 1,
                    Integer.parseInt(fields[2]));
        }

        public void chooseDay(int dayOfMonth) {
            By locator = By.xpath(format(day_FORMAT, dayOfMonth));
            driver.findElement(locator).click();
        }

        public void chooseMonth(LocalDate date) {
            LocalDate currentPeriod = getCurrentPeriod();
            long monthsAway = ChronoUnit.MONTHS.between(currentPeriod, date.withDayOfMonth(1));

            By arrow = monthsAway < 0 ? leftArrow : rightArrow;

            for (int i = 0; i < Math.abs(monthsAway); i++) {
                driver.findElement(arrow).click();
            }
        }

        public LocalDate getCurrentPeriod() {
            String[] currentPeriod = driver.findElement(period).getText().split(" ");
            return LocalDate.of(
                    Integer.parseInt(currentPeriod[1]),
                    Month.valueOf(currentPeriod[0].toUpperCase()),
                    1);
        }

        public void open() {
            if (!isCalendarOpen()) {
                driver.findElement(openCalendarButton).click();
            }
        }

        public boolean isCalendarOpen() {
            return driver.findElement(calendar).isDisplayed();
        }
    }



}
