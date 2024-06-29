import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class JIT_StockTransfer {

    static String mainWindow;
    WebDriver driver;
    static Properties prop;
    static String ofbEntity_Value;
    static String organizationID;
    private static String poNumber;

    class XPathConstants
    {

    }

    public static void loadPropFile() throws IOException {
        prop = new Properties();
        FileInputStream fs = new FileInputStream("/home/yash/IdeaProjects/OasysUi/config.properties");
        prop.load(fs);

    }

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

    @Test(testName = "set up")
    public void setUp() throws IOException {
        loadPropFile();
        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile4");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("stg5-cms-url"));
        mainWindow = driver.getWindowHandle();
    }

    @Test
    public void uploadDocsInShipment()
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-icon[@class='ng-scope md-ofb-green-theme md-font zmdi zmdi-edit material-icons']")));
        WebElement editOfbEntityAddress= driver.findElements(By.xpath("//md-icon[@class='ng-scope md-ofb-green-theme md-font zmdi zmdi-edit material-icons']")).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(editOfbEntityAddress));
        highlightElement(driver, editOfbEntityAddress);
        editOfbEntityAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='_md-select-icon']")));
        WebElement dropdown= driver.findElement(By.xpath("//span[@class='_md-select-icon']"));
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        highlightElement(driver,dropdown);
        dropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-binding']")));
        WebElement entityAddress= driver.findElement(By.xpath("//span[@class='ng-binding']"));
        wait.until(ExpectedConditions.elementToBeClickable(entityAddress));
        highlightElement(driver,entityAddress);
        entityAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info m-l-10 ng-binding']")));
        WebElement submitBtn= driver.findElement(By.xpath("//button[@class='btn btn-info m-l-10 ng-binding']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-toast[@class='md-toast-success _md _md-top _md-right\"]")));

        WebElement docSection= driver.findElement(By.xpath("//span[text()='Documents']"));
        wait.until(ExpectedConditions.elementToBeClickable(docSection));
        highlightElement(driver,docSection);
        docSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Upload STI']")));
        WebElement uploadSTI= driver.findElement(By.xpath("//a[text()='Upload STI']"));
        wait.until(ExpectedConditions.elementToBeClickable(uploadSTI));
        highlightElement(driver,uploadSTI);
        uploadSTI.click();

        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='uploadButton undefined']")));
        WebElement uploadBtn= driver.findElement(By.xpath("//label[@class='uploadButton undefined']"));
        wait.until(ExpectedConditions.elementToBeClickable(uploadBtn));
        highlightElement(driver,uploadBtn);

        WebElement inputField= uploadBtn.findElement(By.xpath(".//input"));
        inputField.sendKeys(prop.getProperty("file-path"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='radioLabel']")));
        WebElement radioBtn= driver.findElements(By.xpath("//label[@class='radioLabel']")).get(1);
        radioBtn.click();

        WebElement endDatePicker= driver.findElements(WarehouseFlow.XPathConstants.DATEPICKER).get(1);
        endDatePicker.click();

        WebElement monthYearBtn= driver.findElement(WarehouseFlow.XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(WarehouseFlow.XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(By.xpath("//input[@placeholder='Select invoice date']"));
        dateInput.sendKeys(date);

        WebElement invoiceNumInput= driver.findElement(By.xpath("//input[@name='invoiceId']"));
        invoiceNumInput.sendKeys("12345");

        WebElement itemDetails= driver.findElement(By.xpath("//button[@class='redirectBlock']"));
        wait.until(ExpectedConditions.elementToBeClickable(itemDetails));
        highlightElement(driver,itemDetails);
        itemDetails.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lineItemCard']")));
        List<WebElement> items= driver.findElements(By.xpath("//div[@class='lineItemCard']"));

        for(WebElement item:items)
        {
            highlightElement(driver,item);

            WebElement matchRadioBtn= item.findElement(By.xpath(".//label[@class='radioLabel']"));
            matchRadioBtn.click();
        }

        WebElement doneBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
        highlightElement(driver,doneBtn);
        doneBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Next')]")));
        WebElement nextBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Next')]"));
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-1i8o47w']")));
        List<WebElement> dropdowns= driver.findElements(By.xpath("//div[@class=' css-1i8o47w']"));

        WebElement supplierPickAddress= dropdowns.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(supplierPickAddress));
        highlightElement(driver,supplierPickAddress);
        supplierPickAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-supplierPickupAddress-option-0']")));
        WebElement addressValue= driver.findElement(By.xpath("//div[@id='react-select-supplierPickupAddress-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(addressValue));
        highlightElement(driver,addressValue);
        addressValue.click();

        WebElement intermediateOFB= dropdowns.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(intermediateOFB));
        highlightElement(driver,intermediateOFB);
        intermediateOFB.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-intermediateOfbEntity-option-2']")));
        WebElement intermediateOFB_value= driver.findElement(By.xpath("//div[@id='react-select-intermediateOfbEntity-option-2']"));
        wait.until(ExpectedConditions.elementToBeClickable(intermediateOFB_value));
        highlightElement(driver,intermediateOFB_value);
        intermediateOFB_value.click();

        WebElement intermediateOFB_Address= dropdowns.get(2);
        wait.until(ExpectedConditions.elementToBeClickable(intermediateOFB_Address));
        highlightElement(driver,intermediateOFB_Address);
        intermediateOFB_Address.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-intermediateOfbEntityBillingAddress-option-0']")));
        WebElement intermediateOFB_AddressValue= driver.findElement(By.xpath("//div[@id='react-select-intermediateOfbEntityBillingAddress-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(intermediateOFB_AddressValue));
        highlightElement(driver,intermediateOFB_AddressValue);
        intermediateOFB_AddressValue.click();

        nextBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Submit')]")));
        submitBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Submit')]"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        mainWindow= driver.getWindowHandle();

        int attempts=0;
        while(attempts++<=3) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='messageListWrap shipmentStockTransferRelatedInfoAlertBlock']")));
                WebElement banner = driver.findElement(By.xpath("//div[@class='messageListWrap shipmentStockTransferRelatedInfoAlertBlock']"));
                if (banner != null)
                    break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("This is the attempt number " + attempts);
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tabContainer']")));
        WebElement tabContainer= driver.findElement(By.xpath("//div[@class='tabContainer']"));
        highlightElement(driver,tabContainer);

        WebElement documentsSection= driver.findElement(By.xpath("//button[@class='btn btn-link' and contains(text(),'Documents')]"));
        wait.until(ExpectedConditions.elementToBeClickable(documentsSection));
        highlightElement(driver,documentsSection);
        documentsSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody")));
        WebElement table= driver.findElement(By.xpath("//tbody"));
        highlightElement(driver,table);

        WebElement publishBtn= table.findElement(By.xpath(".//button[@class='btn btn-icon']"));
        wait.until(ExpectedConditions.elementToBeClickable(publishBtn));
        highlightElement(driver,publishBtn);
        publishBtn.click();
    }





}
