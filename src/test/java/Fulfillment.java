import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class Fulfillment {

    private String supplierNameValue;
    private String lspName;

    class XPathConstaints
    {
        public static final By DRAWER= By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex");
        public static final By DRAWER_OPTIONS= By.xpath("//button[@class='md-raised md-primary side-menu-link md-button ng-scope md-ofb-brown-theme md-ink-ripple']");

        public static final By FULFILLMENT_OPTIONS= By.xpath("//ul[@class='drop-down-list ng-scope']//li[@class='ng-scope']");
        public static final By SHIPMENT_BTN=By.xpath(".//span[text()='Shipment']");
        public static final By BUYOUT_SHIPMENTS= By.xpath(".//ul[@class='inner-nav-list']//li");
        public static final By DROPDOWN= By.xpath("//md-select-value[@id='select_value_label_1']");
        public static final By DROPDOWN_OPTION= By.xpath("//md-option[@id='select_option_9']");
        public static final By SHIPMENTS_LIST= By.xpath("//tbody//tr");
        public static final By SHIPMENT_ID= By.xpath(".//td[2]");
        public static final By SEARCH_FIELD= By.xpath("//input[@class='ng-pristine ng-untouched ng-valid ng-empty']");

        public static final By FILTER_BTN= By.xpath("//i[@class='filterTasks zmdi zmdi-filter-list']");
        public static final By LSP_MODE= By.xpath("//md-checkbox[@class='ng-pristine ng-untouched ng-valid md-ofb-green-theme ng-empty']");
        public static final By SUPPLIER_NAME= By.xpath("//input[@class='ng-pristine ng-untouched ng-scope ng-empty ng-valid ng-valid-required flex md-input']");
        public static final By SUPPLIER_VALUE= By.xpath("//ul[@class='md-autocomplete-suggestions autocomplete-account-template']//li");

        public static final By DATE_OPTIONS= By.xpath("//span[@class='quickdate-button ng-binding']");
        public static final By CALENDAR= By.xpath("//div[@class='quickdate-content']");
        public static final By CREATE_DATE_FROM= By.xpath(".//tr[3]//td[2]");
        public static final By CREATE_DATE_TO= By.xpath(".//tr[3]//td[6]");
        public static final By DONE_BTN= By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']");

    }

    WebDriver driver;
    static Properties prop;


    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid red'", element);
        try {
            Thread.sleep(1000); // Highlight for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].style.border=''", element); // Remove the border
    }

    public static void loadPropFile() throws IOException {
        prop = new Properties();
        FileInputStream fs = new FileInputStream("/home/yash/IdeaProjects/OasysUi/config.properties");
        prop.load(fs);
    }

    @Test(testName = "set up")
    public void setUp() throws IOException {
        loadPropFile();
        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile4");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("stg5-cms-url"));
    }

    @Test(dependsOnMethods = "setUp")
    public void handleFulfillment()
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DRAWER));

        WebElement drawer= driver.findElement(XPathConstaints.DRAWER);
        highlightElement(driver,drawer);

        List<WebElement> options= driver.findElements(XPathConstaints.DRAWER_OPTIONS);
        WebElement fulfillmentSection= options.get(9);
        wait.until(ExpectedConditions.elementToBeClickable(fulfillmentSection));
        highlightElement(driver, fulfillmentSection);
        fulfillmentSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Shipment']")));
        WebElement shipmentBtn= driver.findElement(By.xpath("//button[@aria-label='Shipment']"));
        wait.until(ExpectedConditions.elementToBeClickable(shipmentBtn));
        highlightElement(driver,shipmentBtn);
        shipmentBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='MarketPlace Shipments']")));
        WebElement marketPlaceShipmentBtn= driver.findElement(By.xpath("//button[@aria-label='MarketPlace Shipments']"));
        wait.until(ExpectedConditions.elementToBeClickable(marketPlaceShipmentBtn));
        highlightElement(driver,marketPlaceShipmentBtn);
        marketPlaceShipmentBtn.click();
    }

    @Test(dependsOnMethods = "handleFulfillment")
    public void handleBuyoutShipments() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DROPDOWN));
//        WebElement dropDown= driver.findElement(XPathConstaints.DROPDOWN);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropDown);
//        Thread.sleep(3000);
//        dropDown.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DROPDOWN_OPTION));
//        WebElement dropDown_option= driver.findElement(XPathConstaints.DROPDOWN_OPTION);
//        wait.until(ExpectedConditions.elementToBeClickable(dropDown_option));
//        highlightElement(driver,dropDown_option);
//        dropDown_option.click();
//
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.SHIPMENTS_LIST));
//        List<WebElement> shipmentsList= driver.findElements(XPathConstaints.SHIPMENTS_LIST);
//        int size= shipmentsList.size();
//
//        Random random= new Random();
//        int randomShipment= random.nextInt(size/2);
//        WebElement shipment= shipmentsList.get(randomShipment);
//        highlightElement(driver,shipment);
//        System.out.println("Random shipment No. is "+ randomShipment);
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shipment);
//
//        Thread.sleep(6000);
//        String shipmentID= shipment.findElement(XPathConstaints.SHIPMENT_ID).getText();
//        System.out.println("Shipment ID is "+ shipmentID);
//
//        driver.navigate().refresh();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SEARCH_FIELD));
//        WebElement searchField= driver.findElement(XPathConstaints.SEARCH_FIELD);
//        wait.until(ExpectedConditions.elementToBeClickable(searchField));
//        searchField.sendKeys(shipmentID);
//        Thread.sleep(3000);
//        searchField.sendKeys(Keys.ENTER);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SHIPMENTS_LIST));
//        WebElement requiredShipment= driver.findElement(XPathConstaints.SHIPMENTS_LIST);
//        highlightElement(driver,requiredShipment);
//
//        WebElement required_shipmentID= requiredShipment.findElement(By.xpath(".//td[2]"));
//        wait.until(ExpectedConditions.elementToBeClickable(required_shipmentID));
//        highlightElement(driver,required_shipmentID);
//        String req_ID= required_shipmentID.getText();
//
//        Assert.assertEquals(shipmentID,req_ID);
//        supplierNameValue= requiredShipment.findElement(By.xpath(".//td[7]")).getText();
//        lspName= requiredShipment.findElement(By.xpath(".//td[9]")).getText();
    }

    @Test(dependsOnMethods = "handleBuyoutShipments")
    public void handleFilter() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.FILTER_BTN));
        WebElement filterBtn= driver.findElement(XPathConstaints.FILTER_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(filterBtn));
        highlightElement(driver,filterBtn);
        filterBtn.click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.LSP_MODE));
//        List<WebElement> lspModes= driver.findElements(XPathConstaints.LSP_MODE);
//        Set<String> lspModeValues= new HashSet<>();
//        for(int i=1;i<=2;i++)
//        {
//            WebElement lspMode= lspModes.get(i-1);
//            wait.until(ExpectedConditions.elementToBeClickable(lspMode));
//            highlightElement(driver,lspMode);
//            String lspModeValue= lspMode.findElement(By.xpath(".//div[@class='_md-label']//span")).getText();
//            lspModeValues.add(lspModeValue);
//            lspMode.click();
//        }

//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUPPLIER_NAME));
//        WebElement supplier= driver.findElement(XPathConstaints.SUPPLIER_NAME);
//        supplier.sendKeys("OFLNONGFS SFNP");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUPPLIER_VALUE));
//        WebElement supplierValue= driver.findElement(XPathConstaints.SUPPLIER_VALUE);
//        supplierNameValue= supplierValue.getText();
//        wait.until(ExpectedConditions.elementToBeClickable(supplierValue));
//        highlightElement(driver,supplierValue);
//        supplierValue.click();

        List<WebElement> dateOptions= driver.findElements(XPathConstaints.DATE_OPTIONS);
        WebElement creation_date_from= dateOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(creation_date_from));
        highlightElement(driver,creation_date_from);
        creation_date_from.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CALENDAR));
        List<WebElement> calendars= driver.findElements(XPathConstaints.CALENDAR);
        WebElement startDate=calendars.get(0).findElement(XPathConstaints.CREATE_DATE_FROM);
        startDate.click();

        String startDateText= creation_date_from.getText();

        Thread.sleep(2000);

//        WebElement bodyElement = driver.findElement(By.tagName("body"));
//        bodyElement.click();
        //startDate.sendKeys(Keys.ENTER);

        WebElement creation_date_to= dateOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(creation_date_to));
        highlightElement(driver,creation_date_to);
        creation_date_to.click();
        WebElement date= calendars.get(1).findElement(XPathConstaints.CREATE_DATE_TO);
        date.click();

        String To_DateText= creation_date_to.getText();
        System.out.println("Start Date To: "+ To_DateText);

        Thread.sleep(3000);
        WebElement bodyElement = driver.findElement(By.xpath("//md-dialog[@class='_md md-ofb-green-theme _md-transition-in']"));
        highlightElement(driver,bodyElement);
        bodyElement.click();
        Thread.sleep(300);



        WebElement statusSection= driver.findElements(By.xpath("//span[@class='listValue']")).get(10);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", statusSection);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-binding ng-scope']")));
        List<WebElement> statusCheckBoxes= statusSection.findElements(By.xpath(".//span[@class='ng-binding ng-scope']"));

        WebElement statusBox1= statusCheckBoxes.get(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", statusBox1);
        Thread.sleep(2000);
        statusBox1.click();
        WebElement statusBox2= statusCheckBoxes.get(3);
        statusBox2.click();
        WebElement statusBox3= statusCheckBoxes.get(6);
        statusBox2.click();
        WebElement statusBox4= statusCheckBoxes.get(7);
        statusBox2.click();

        Set<String> statusSet= new HashSet<>();
        statusSet.add("Delivered");
        statusSet.add("Reached");
        statusSet.add("Closed");
        statusSet.add("Pickup Delayed");

        WebElement doneBtn= driver.findElement(XPathConstaints.DONE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
        highlightElement(driver,doneBtn);
        doneBtn.click();

        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SHIPMENTS_LIST));
            List<WebElement> shipments= driver.findElements(XPathConstaints.SHIPMENTS_LIST);

            for(int i=0;i<shipments.size()/2;i++)
            {
                WebElement shipment=shipments.get(i);
                List<WebElement> options= shipment.findElements(By.xpath(".//td"));
                WebElement createDate= options.get(0);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'center'});", createDate);
                Thread.sleep(1000);
                //shipment.findElement(By.xpath(".//td[1]"));

                highlightElement(driver,createDate);
                String reqDate= createDate.getText().substring(0,2);

                //WebElement supplierName= options.get(6);

                //highlightElement(driver,supplierName);
                //String name= supplierName.getText();

                System.out.println(reqDate);

                WebElement statusElement= options.get(12);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'center'});", statusElement);
                Thread.sleep(2000);
                highlightElement(driver,statusElement);
                String currStatus= statusElement.getText();



                int d1=Integer.parseInt(reqDate);
                int d2= Integer.parseInt(startDateText.substring(0,2));
                int d3= Integer.parseInt(To_DateText.substring(0,2));
                System.out.println(d1+"   "+ d2+"   "+ d3);

                //Assert.assertEquals(name,supplierNameValue+",");
                Assert.assertTrue(d1>=d2 && d1<=d3);
                Assert.assertTrue(statusSet.contains(currStatus),currStatus);

            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
