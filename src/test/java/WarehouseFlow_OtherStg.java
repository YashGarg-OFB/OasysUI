import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WarehouseFlow_OtherStg {

    static String mainWindow;
    WebDriver driver;
    static Properties prop;
    static String ofbEntity_Value;
    static String organizationID;

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

    public static void setCurrDate(WebDriver driver)
    {

        WebElement datePicker= driver.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(By.xpath("//input[@placeholder='Start Date']"));
        dateInput.sendKeys(date);
    }

    public void addCookie(WebDriver driver, String authToken) throws IOException {
        loadPropFile();
        Cookie cookie= driver.manage().getCookieNamed("admin-auth-token");
        driver.manage().deleteCookie(cookie);
        System.out.println(cookie.getName());

        System.out.println(cookie.getExpiry());
        System.out.println(cookie.getPath());

        System.out.println(prop.getProperty("supplier-auth-token"));

        driver.manage().addCookie(
                new Cookie.Builder(cookie.getName(), authToken)
                        .domain(cookie.getDomain())
                        .expiresOn(cookie.getExpiry())
                        .path(cookie.getPath())
                        .isSecure(cookie.isSecure())
                        .build()
        );
        driver.navigate().refresh();
    }

    public static int generateInvoiceNumber()
    {
        Random random = new Random();

        // Generate a random number between 100000 (inclusive) and 1000000 (exclusive)
        int randomNumber = 100000 + random.nextInt(900000);
        return randomNumber;
    }

    public void getOrganizationID(WebDriver driver) throws InterruptedException {

        String mainWindow= driver.getWindowHandle();

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

//        for(String handle:driver.getWindowHandles())
//            driver.switchTo().window(handle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='pointerCursor']")));
        WebElement link_Element= driver.findElement(By.xpath("//span[@class='pointerCursor']"));
        wait.until(ExpectedConditions.elementToBeClickable(link_Element));
        highlightElement(driver,link_Element);
        link_Element.click();

        for(String handle:driver.getWindowHandles())
            driver.switchTo().window(handle);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        Thread.sleep(4000);
        String url= driver.getCurrentUrl();
        organizationID= url.split("/")[5];
        System.out.println("Url is--->" + url);
        System.out.println("Organization id is-->" + organizationID);
    }


    @Test(testName = "set up")
    public void setUp() throws IOException {
        loadPropFile();
        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("stg5-cms-url"));
        mainWindow = driver.getWindowHandle();
    }

    @Test(dependsOnMethods = "setUp")
    public void loginTest() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("iframe")));
        WebElement frame = driver.findElements(By.tagName("iframe")).get(0); // Change the index as per your requirement
        frame.click();
        driver.switchTo().frame(frame);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("container")));
        WebElement signIn = driver.findElement(By.id("container"));
        signIn.click();

        Thread.sleep(2000);
        for (String winHandle : driver.getWindowHandles())
            driver.switchTo().window(winHandle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        WebElement emailInput = driver.findElement(By.id("identifierId"));
        emailInput.sendKeys(prop.getProperty("email"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierNext")));
        WebElement nextBtn = driver.findElement(By.id("identifierNext"));
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
        WebElement passwordInput = driver.findElement(By.name("Passwd"));
        passwordInput.sendKeys(prop.getProperty("psvd"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordNext")));
        WebElement passNextBtn = driver.findElement(By.id("passwordNext"));
        passNextBtn.click();

    }

    @Test(dependsOnMethods = "loginTest")
    public void  handleWareHouseTest() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(80));
        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex")));

        WebElement drawer= driver.findElement(By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex"));
        highlightElement(driver,drawer);

        List<WebElement> options= driver.findElements(By.cssSelector("button.md-raised.md-primary.side-menu-link.md-button.ng-scope.md-ofb-brown-theme.md-ink-ripple"));
        WebElement warehouseSection= options.get(13);
        System.out.println(warehouseSection.isDisplayed());
        System.out.println(warehouseSection.isEnabled());
        wait.until(ExpectedConditions.elementToBeClickable(warehouseSection));
        highlightElement(driver,warehouseSection);
        warehouseSection.click();

        List<WebElement> rfqOptions= warehouseSection.findElements(By.className("ng-scope"));
        highlightElement(driver,options.get(14));
        options.get(14).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary addNewWarehouseBtn']")));

        WebElement addNewWarehouseBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary addNewWarehouseBtn']"));
        wait.until(ExpectedConditions.elementToBeClickable(addNewWarehouseBtn));
        highlightElement(driver,addNewWarehouseBtn);
        addNewWarehouseBtn.click();

    }

    @Test(dependsOnMethods = "handleWareHouseTest")
    public void addnewWarehouseTest() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ofbEntityId-tfid-0-1']")));
        WebElement ofbEntity= driver.findElement(By.xpath("//div[@id='ofbEntityId-tfid-0-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntity));
        highlightElement(driver,ofbEntity);
        ofbEntity.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-ofbEntityId-option-0']")));
        WebElement ofbEntityValue= ofbEntity.findElement(By.xpath(".//div[@id='react-select-ofbEntityId-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntityValue));
        ofbEntity_Value= ofbEntityValue.getText();
        highlightElement(driver,ofbEntityValue);
        ofbEntityValue.click();

        WebElement billingAddress= driver.findElements(By.xpath("//div[@class=' css-17vhrl4']")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddress));
        highlightElement(driver,billingAddress);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-ofbEntityBillingAddressId-option-0']")));
        WebElement billingAddressValue= driver.findElement(By.xpath("//div[@id='react-select-ofbEntityBillingAddressId-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        WebElement warehouseNickName= driver.findElement(By.xpath("//input[@id='tfid-0-3']"));
        warehouseNickName.sendKeys(prop.getProperty("warehouse-nick-name"));

        WebElement warehouseAddress= driver.findElements(By.xpath("//div[@class=' css-17vhrl4']")).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(warehouseAddress));
        highlightElement(driver,warehouseAddress);
        warehouseAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-warehouseAddress-option-0']")));
        WebElement warehouseAddressValue= driver.findElement(By.xpath("//div[@id='react-select-warehouseAddress-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(warehouseAddressValue));
        highlightElement(driver,warehouseAddressValue);
        warehouseAddressValue.click();

        WebElement contactType= driver.findElements(By.xpath("//div[@class=' css-17vhrl4']")).get(3);
        wait.until(ExpectedConditions.elementToBeClickable(contactType));
        highlightElement(driver,contactType);
        contactType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-contactPersonList[0][contactPersonType]-option-0']")));
        WebElement contactTypeValue= driver.findElement(By.xpath("//div[@id='react-select-contactPersonList[0][contactPersonType]-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(contactTypeValue));
        highlightElement(driver,contactTypeValue);
        contactTypeValue.click();

        WebElement personName= driver.findElement(By.xpath("//input[@id='tfid-0-7']"));
        personName.sendKeys(prop.getProperty("person-name"));

        WebElement phoneInput= driver.findElement(By.xpath("//input[@id='tfid-0-8']"));
        phoneInput.sendKeys(prop.getProperty("phone"));

        WebElement rentInput= driver.findElement(By.xpath("//input[@id='tfid-0-10']"));
        rentInput.sendKeys("10");

        WebElement securityAmount= driver.findElement(By.xpath("//input[@id='tfid-0-11']"));
        securityAmount.sendKeys("10");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='radio-group']")));
        List<WebElement> radioGroups= driver.findElements(By.xpath("//div[@class='radio-group']"));
        WebElement rentFreqRadioGrp= radioGroups.get(1);
        highlightElement(driver,rentFreqRadioGrp);

        WebElement rentFreqValue= rentFreqRadioGrp.findElement(By.xpath(".//label[@class='radioLabel']"));
        rentFreqValue.click();

        WebElement paidDuration= driver.findElement(By.xpath("//div[@class='actionBlockTop']"));
        wait.until(ExpectedConditions.elementToBeClickable(paidDuration));
        highlightElement(driver,paidDuration);
        paidDuration.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-17vhrl4']")));
        driver.findElements(By.xpath("//div[@class=' css-17vhrl4']")).get(4).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-toBePaidOnDay-option-0']")));
        WebElement payDurationType= driver.findElement(By.xpath("//div[@id='react-select-toBePaidOnDay-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(payDurationType));
        highlightElement(driver,payDurationType);
        payDurationType.click();

        Actions actions= new Actions(driver);
        Thread.sleep(5000);
        actions.scrollByAmount(0,15000).perform();


        Thread.sleep(8000);

        WebElement uploadAggreement= driver.findElement(By.xpath("//input[@id='upload-agreement']"));
        uploadAggreement.sendKeys("/home/yash/Pictures/Screenshots/screenshot.png");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
        WebElement datePicker= driver.findElement(By.className("react-datepicker__input-container"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", datePicker);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(datePicker));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(By.xpath("//input[@placeholder='Start Date']"));
        dateInput.sendKeys(date);

        Thread.sleep(2000);

        WebElement endDatePicker= driver.findElements(By.className("react-datepicker__input-container")).get(1);
        endDatePicker.click();

        monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(By.xpath("//input[@placeholder='End Date']"));
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement submitWarehouse= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitWarehouse));
        highlightElement(driver,submitWarehouse);
        submitWarehouse.click();

    }

    @Test(dependsOnMethods = "addnewWarehouseTest")
    public void handleCreatedWarehouse() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cardItemWrapper wareHouseItemList']")));

        driver.navigate().refresh();
        Thread.sleep(8000);

        WebElement warehouseList= driver.findElement(By.xpath("//div[@class='cardItemWrapper wareHouseItemList']"));
        highlightElement(driver,warehouseList);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[@class='listItemRow']")));
        List<WebElement> warehouseItems= warehouseList.findElements(By.xpath(".//div[@class='listItemRow']"));
        System.out.println(warehouseItems.size()+" lengthed list");

        Thread.sleep(3000);


        for(WebElement item:warehouseItems)
        {
            highlightElement(driver,item);
            WebElement ofbEntity= item.findElements(By.xpath(".//span")).get(1);
            highlightElement(driver,ofbEntity);
            if(ofbEntity.getText().equalsIgnoreCase(ofbEntity_Value))
            {
                WebElement detailsBtn= item.findElement(By.xpath(".//span[@class='detailTabIndicator']"));
                wait.until(ExpectedConditions.elementToBeClickable(detailsBtn));
                detailsBtn.click();
                break;
            }
        }
    }

    @Test(dependsOnMethods = "handleCreatedWarehouse")
    public void issuePO() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='actionsListBlock']")));
        WebElement actionsBlock= driver.findElements(By.xpath("//div[@class='actionsListBlock']")).get(1);
        highlightElement(driver,actionsBlock);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='actionItem']")));
        WebElement issuePOBtn= actionsBlock.findElement(By.xpath(".//div[@class='actionItem']"));
        highlightElement(driver,issuePOBtn);
        issuePOBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-17vhrl4']")));
        WebElement supplierName= driver.findElement(By.xpath("//div[@class=' css-17vhrl4']"));
        wait.until(ExpectedConditions.elementToBeClickable(supplierName));
        highlightElement(driver,supplierName);
        supplierName.click();

        WebElement supplierName_hint= driver.findElement(By.xpath("//input[@id='selectSupplier-input-tfid-0-1']"));
        supplierName_hint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-selectSupplier-option-0']")));
        WebElement supplierValue= driver.findElement(By.xpath("//div[@id='react-select-selectSupplier-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(supplierValue));
        highlightElement(driver,supplierValue);
        supplierValue.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-17vhrl4']")));
        List<WebElement> supplierOptions= driver.findElements(By.xpath("//div[@class=' css-17vhrl4']"));

        WebElement billingAddress= supplierOptions.get(1);
        highlightElement(driver,billingAddress);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1m5nn3x']//div")));
        WebElement billingAddressValue= driver.findElement(By.xpath("//div[@class=' css-1m5nn3x']//div"));
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        WebElement pickupAddress= supplierOptions.get(2);
        highlightElement(driver,pickupAddress);
        pickupAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1ul4jvx-option']")));
        WebElement pickupAddressValue= driver.findElement(By.xpath("//div[@class=' css-1ul4jvx-option']"));
        highlightElement(driver,pickupAddressValue);
        pickupAddressValue.click();

        List<WebElement> radioGroups= driver.findElements(By.xpath("//div[@class='radio-group']"));

        WebElement radiogroup= radioGroups.get(3);
        highlightElement(driver,radiogroup);

        WebElement radioGrpValue= radiogroup.findElement(By.xpath(".//label"));
        radioGrpValue.click();

        WebElement incentiveReason= driver.findElement(By.id("reason-tfid-0-0"));
        wait.until(ExpectedConditions.visibilityOf(incentiveReason));
        highlightElement(driver,incentiveReason);
        incentiveReason.click();

        WebElement incentiveReasonValue= driver.findElement(By.id("react-select-reason-option-0"));
        wait.until(ExpectedConditions.elementToBeClickable(incentiveReasonValue));
        highlightElement(driver,incentiveReasonValue);
        incentiveReasonValue.click();

        driver.findElement(By.xpath("//span[text()='Incoming']")).click();

        driver.findElement(By.xpath("//span[text()='Without Tax']")).click();

        WebElement incentiveLevel= driver.findElements(By.xpath("//span[text()='Item Level']")).get(1);
        incentiveLevel.click();

        WebElement advanceAmount= driver.findElement(By.xpath("//input[@id='tfid-0-7']"));
        advanceAmount.sendKeys("100");

        WebElement onDispatchAmount= driver.findElement(By.xpath("//input[@id='tfid-0-8']"));
        advanceAmount.sendKeys("0");

        WebElement onDelivery= driver.findElement(By.xpath("//input[@id='tfid-0-9']"));
        advanceAmount.sendKeys("0");

        WebElement credit= driver.findElement(By.xpath("//input[@id='tfid-0-10']"));
        advanceAmount.sendKeys("0");


//        Thread.sleep(7000);
//
//        Actions actions= new Actions(driver);
//        actions.scrollByAmount(0,10000).perform();
//
//        Thread.sleep(5000);

        WebElement scrollToElement= driver.findElement(By.xpath("//div[text()='Other Configurations']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToElement);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement ofbEntityAddress= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntityAddress));


        Thread.sleep(2000);
        highlightElement(driver,ofbEntityAddress);
        ofbEntityAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-ofbEntityAddressId-option-0']")));
        WebElement ofbAddressvalue= driver.findElement(By.xpath("//div[@id='react-select-ofbEntityAddressId-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(ofbAddressvalue));
        highlightElement(driver,ofbAddressvalue);
        ofbAddressvalue.click();

        Thread.sleep(5000);
        setCurrDate(driver);

        WebElement addItemsBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary addContactPersonBtn']"));
        wait.until(ExpectedConditions.elementToBeClickable(addItemsBtn));
        highlightElement(driver,addItemsBtn);
        addItemsBtn.click();

    }

    @Test(dependsOnMethods = "issuePO")
    public void addItems() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='baseCatWrapper']")));
        WebElement itemsSection= driver.findElement(By.xpath("//div[@class='baseCatWrapper']"));
        List<WebElement> items= driver.findElements(By.xpath("//div[@class='catItem']"));
        highlightElement(driver,items.get(2));

        WebElement item1= items.get(2).findElement(By.xpath(".//button[@class='btn btn-default']"));
        wait.until(ExpectedConditions.elementToBeClickable(item1));
        highlightElement(driver,item1);
        item1.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='leafCatWrapper']")));
        WebElement varietySection= driver.findElement(By.xpath("//div[@class='leafCatWrapper']"));
        highlightElement(driver,varietySection);

        List<WebElement> varieties= driver.findElements(By.xpath("//div[@class='catItem']"));
        for(int i=1;i<=2;i++)
        {
            WebElement variety1= varieties.get(i);
            highlightElement(driver,variety1);
            WebElement addToCartBtn= variety1.findElement(By.xpath(".//button[@class='btn btn-default']"));
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
            highlightElement(driver,addToCartBtn);
            addToCartBtn.click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartBtn']")));
        WebElement cartBtn= driver.findElement(By.xpath("//div[@class='cartBtn']"));
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
        highlightElement(driver,cartBtn);
        cartBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("subCategoryForm")));

        List<WebElement> subcategoryForms= driver.findElements(By.className("subCategoryForm"));

        Thread.sleep(4000);
        for(WebElement subcategoryForm:subcategoryForms)
        {
            WebElement itemQty= subcategoryForm.findElements(By.xpath(".//input[@class='form-control']")).get(0);
            itemQty.clear();
            itemQty.sendKeys("100");

            WebElement units= subcategoryForm.findElements(By.xpath(".//div[@class='reactSelectContainer']")).get(0);
            highlightElement(driver,units);
            units.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-Unit-option-0']")));
            WebElement unitValue= subcategoryForm.findElement(By.xpath(".//div[@id='react-select-Unit-option-0']"));
            wait.until(ExpectedConditions.elementToBeClickable(unitValue));
            highlightElement(driver,unitValue);
            unitValue.click();

            WebElement baserate= subcategoryForm.findElements(By.xpath(".//input[@class='form-control']")).get(1);
            baserate.sendKeys("100");

            WebElement gstDropDown= subcategoryForm.findElement(By.xpath(".//div[@class='form-group form-group-depth-1 form-group-GST']//div[@class=' css-2b097c-container']"));
            highlightElement(driver,gstDropDown);
            gstDropDown.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='react-select-GST-option-0']")));
            WebElement gstValue= subcategoryForm.findElement(By.xpath(".//div[@id='react-select-GST-option-0']"));
            wait.until(ExpectedConditions.elementToBeClickable(gstValue));
            highlightElement(driver,gstValue);
            gstValue.click();

            WebElement editBtn= subcategoryForm.findElement(By.xpath(".//div[@class='button-edit material-icons']"));
            wait.until(ExpectedConditions.elementToBeClickable(editBtn));
            editBtn.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='radio-group']")));
            WebElement radioGrp= driver.findElement(By.xpath("//div[@class='radio-group']"));
            highlightElement(driver,radioGrp);
            radioGrp.findElement(By.xpath(".//label")).click();

            WebElement actualIncentive= driver.findElement(By.xpath("//input[@name='actualAmount']"));
            actualIncentive.sendKeys("100");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
            WebElement saveBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
            wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
            highlightElement(driver,saveBtn);
            saveBtn.click();
        }

        Thread.sleep(3000);
        WebElement submitBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();


        Thread.sleep(3000);
        submitBtn= driver.findElements(By.xpath("//button[@class='btn btn-primary']")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement verifierOption= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(verifierOption));
        highlightElement(driver,verifierOption);
        verifierOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='verifierName-input-tfid-0-0']")));
        WebElement verifier_hint= driver.findElement(By.xpath("//input[@id='verifierName-input-tfid-0-0']"));
        verifier_hint.sendKeys("Anshul Jain");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-verifierName-option-0']")));
        WebElement verifier_name= driver.findElement(By.xpath("//div[@id='react-select-verifierName-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(verifier_name));
        highlightElement(driver,verifier_name);
        verifier_name.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Send for Verification ']")));
        WebElement sendForVerificationBtn= driver.findElement(By.xpath("//button[text()='Send for Verification ']"));
        wait.until(ExpectedConditions.elementToBeClickable(sendForVerificationBtn));
        highlightElement(driver,sendForVerificationBtn);
        sendForVerificationBtn.click();
        Thread.sleep(10000);
    }

    @Test(dependsOnMethods = "addItems")
    public void verifyPO() throws IOException, InterruptedException {
        addCookie(driver,prop.getProperty("supplier-auth-token"));

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='nav-list']")));
        WebElement verifySection= driver.findElements(By.xpath("//ul[@class='nav-list']")).get(6);
        highlightElement(driver,verifySection);
        verifySection.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='inner-nav-list']//li")));
        WebElement supplierPOBtn= verifySection.findElement(By.xpath(".//ul[@class='inner-nav-list']//li"));
        wait.until(ExpectedConditions.elementToBeClickable(supplierPOBtn));
        highlightElement(driver,supplierPOBtn);
        supplierPOBtn.click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='supplierWrapper']")));
        List<WebElement> supplierList= driver.findElements(By.xpath("//div[@class='supplierWrapper']"));
        for(WebElement supplier:supplierList)
        {
            highlightElement(driver,supplier);
            Thread.sleep(1000);
            WebElement requestor= supplier.findElement(By.xpath(".//span[3]"));
            highlightElement(driver,requestor);
            Thread.sleep(1000);
            String text= requestor.getText();
            System.out.println("Requestor is "+ text);
            if(text.equalsIgnoreCase("Requestor: Yash Garg"))
            {
                Thread.sleep(1000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='btn btn-primary approveBtn']")));
                WebElement approveBtn = supplier.findElement(By.xpath(".//button[@class='btn btn-primary approveBtn']"));
                wait.until(ExpectedConditions.elementToBeClickable(approveBtn));
                highlightElement(driver,approveBtn);
                approveBtn.click();
                System.out.println("This is the one");
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
        WebElement submitBtn= driver.findElement(By.xpath("//button[text()='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        Thread.sleep(4000);

        addCookie(driver, prop.getProperty("my-auth-token-stg1"));
    }

    @Test(dependsOnMethods ="verifyPO")
    public void createDeliveryIn() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));

        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='nav-list']")));
        WebElement warehouseSection= driver.findElements(By.xpath("//ul[@class='nav-list']")).get(4);
        highlightElement(driver,warehouseSection);
        warehouseSection.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='inner-nav-list']//li")));
        WebElement purchaseOrderBtn= warehouseSection.findElements(By.xpath(".//ul[@class='inner-nav-list']//li")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(purchaseOrderBtn));
        highlightElement(driver,purchaseOrderBtn);
        purchaseOrderBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cardItemWrapper wareHousePOItemList']")));
        WebElement cardWrapper= driver.findElement(By.xpath("//div[@class='cardItemWrapper wareHousePOItemList']"));
        highlightElement(driver,cardWrapper);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='listItemRow']")));
        List<WebElement> items= driver.findElements(By.xpath("//div[@class='listItemRow']"));

        for(WebElement item:items)
        {
            highlightElement(driver,item);
            WebElement nameSection= item.findElement(By.xpath(".//div[@class='keyValueBlock'][2]//span[2]"));
            highlightElement(driver,nameSection);

            if(nameSection.getText().equalsIgnoreCase("Yash Garg"))
            {
                item.click();
                break;
            }
        }


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='actionItem']")));
        WebElement createDeliveryBtn= driver.findElements(By.xpath("//div[@class='actionItem']")).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(createDeliveryBtn));
        highlightElement(driver,createDeliveryBtn);
        createDeliveryBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='lotDetailContainer']")));
        List<WebElement> itemsList= driver.findElements(By.xpath("//div[@class='lotDetailContainer']"));

        for(WebElement item:itemsList)
        {
            highlightElement(driver,item);
            WebElement stockPendingDelivery= item.findElement(By.xpath(".//div[@class='col s12 m3']"));
            highlightElement(driver,stockPendingDelivery);
            String stockPending= stockPendingDelivery.getText();

            WebElement incomingQty= item.findElement(By.xpath(".//input[@id='tfid-0-0']"));
            incomingQty.sendKeys(stockPending);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement nextBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
        WebElement datePicker= driver.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(By.xpath("//input[@placeholder='Select Date']"));
        dateInput.sendKeys(date);

        List<WebElement> dropdownOptions= driver.findElements(By.xpath("//div[@class=' css-1i8o47w']"));

        WebElement assignToBtn= dropdownOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(assignToBtn));
        highlightElement(driver,assignToBtn);
        assignToBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='assignedTo-input-tfid-0-1']")));
        WebElement assignTo_hint= driver.findElement(By.xpath("//input[@id='assignedTo-input-tfid-0-1']"));
        assignTo_hint.sendKeys("a");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-assignedTo-option-1']")));
        WebElement assignTo_hint_value= driver.findElement(By.xpath("//div[@id='react-select-assignedTo-option-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(assignTo_hint_value));
        highlightElement(driver,assignTo_hint_value);
        assignTo_hint_value.click();

        WebElement fullfillmentSpoc= dropdownOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(fullfillmentSpoc));
        highlightElement(driver,fullfillmentSpoc);
        fullfillmentSpoc.click();

        WebElement fullfillmentSpoc_hint= driver.findElement(By.xpath("//input[@id='ofbFulfillmentSpoc-input-tfid-0-2']"));
        fullfillmentSpoc_hint.sendKeys("a");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-ofbFulfillmentSpoc-option-1']")));
        WebElement fullfillmentSpoc_value= driver.findElement(By.xpath("//div[@id='react-select-ofbFulfillmentSpoc-option-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(fullfillmentSpoc_value));
        fullfillmentSpoc_value.click();

        /*WebElement uploadInvoice= driver.findElement(By.xpath("//input[@id='deliveryInDocumentUpload-SUPPLIER_TAX_INVOICE']"));
        uploadInvoice.sendKeys("/home/yash/Pictures/Screenshots/screenshot.png");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='formItems']")));
        WebElement form= driver.findElement(By.xpath("//div[@class='formItems']"));
        highlightElement(driver,form);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id='tfid-0-3']")));
        WebElement invoiceNumberInput= form.findElement(By.xpath(".//input[@id='tfid-0-3']"));
        invoiceNumberInput.sendKeys(prop.getProperty("invoice-number"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
        datePicker= form.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        monthYearBtn= form.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--029.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= form.findElement(By.xpath("//input[@placeholder='Select end date']"));
        dateInput.sendKeys(date);

        WebElement invoiceAmt= form.findElement(By.xpath(".//input[@id='tfid-0-5']"));
        invoiceAmt.sendKeys("10000");

        List<WebElement> formDropdownOptions=  form.findElements(By.xpath(".//div[@class=' css-1i8o47w']"));

        WebElement issuingPartyDropdown= formDropdownOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyDropdown));
        highlightElement(driver,issuingPartyDropdown);
        issuingPartyDropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-1']")));
        WebElement issuingPartyValue= form.findElement(By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyValue));
        highlightElement(driver,issuingPartyValue);
        issuingPartyValue.click();

        WebElement receivingParty= formDropdownOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-0']")));
        WebElement receivingPartyValue= form.findElement(By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(receivingPartyValue));
        highlightElement(driver,receivingPartyValue);
        receivingPartyValue.click();

        WebElement saveBtn= driver.findElement(By.xpath("//button[text()='Save']"));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        Thread.sleep(2000);
*/

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='deliveryInDocumentUpload-E_WAY_BILL']")));
//        WebElement uploadEwayBill= driver.findElement(By.xpath("//input[@id='deliveryInDocumentUpload-E_WAY_BILL']"));
//        uploadEwayBill.sendKeys("/home/yash/Pictures/Screenshots/screenshot.png");
//
//        form= driver.findElement(By.xpath("//div[@class='formItems']"));
//        highlightElement(driver,form);
//
//        formDropdownOptions=  form.findElements(By.xpath(".//div[@class=' css-1i8o47w']"));
//
//        issuingPartyDropdown= formDropdownOptions.get(0);
//        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyDropdown));
//        highlightElement(driver,issuingPartyDropdown);
//        issuingPartyDropdown.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-0']")));
//        issuingPartyValue= form.findElement(By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-0']"));
//        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyValue));
//        highlightElement(driver,issuingPartyValue);
//        issuingPartyValue.click();
//
//        receivingParty= formDropdownOptions.get(1);
//        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
//        highlightElement(driver,receivingParty);
//        receivingParty.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-1']")));
//        receivingPartyValue= form.findElement(By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-1']"));
//        wait.until(ExpectedConditions.elementToBeClickable(receivingPartyValue));
//        highlightElement(driver,receivingPartyValue);
//        receivingPartyValue.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
//        saveBtn= driver.findElement(By.xpath("//button[text()='Save']"));
//        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
//        highlightElement(driver,saveBtn);
//        saveBtn.click();
//
//        Thread.sleep(2000);

        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement createDeliveryInBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(createDeliveryInBtn));
        highlightElement(driver,createDeliveryInBtn);
        createDeliveryInBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Cancel']")));
        WebElement cancelBtn= driver.findElement(By.xpath("//button[text()='Cancel']"));
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
        highlightElement(driver,cancelBtn);
        cancelBtn.click();
    }

    @Test(dependsOnMethods = "createDeliveryIn")
    public void updateTrackingDetails() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='shipmentStatusJourney']")));
        WebElement trackingSecion= driver.findElement(By.xpath("//div[@class='shipmentStatusJourney']"));
        highlightElement(driver,trackingSecion);

        WebElement updateStatusBtn= trackingSecion.findElement(By.xpath(".//span"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement newStatus= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(newStatus));
        highlightElement(driver,newStatus);
        newStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-shipmentStatus-option-0']")));
        WebElement newStatusValue= driver.findElement(By.xpath("//div[@id='react-select-shipmentStatus-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(newStatusValue));
        highlightElement(driver,newStatusValue);
        newStatusValue.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
        WebElement datePicker= driver.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(By.xpath("//input[@placeholder='Select Date']"));
        dateInput.sendKeys(date);

        Thread.sleep(5000);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='deliveryInDocumentUpload-SUPPLIER_WEIGHMENT_SLIP']")));
//        WebElement uploadDoc= driver.findElement(By.xpath("//input[@id='deliveryInDocumentUpload-SUPPLIER_WEIGHMENT_SLIP']"));
//        uploadDoc.sendKeys("/home/yash/IdeaProjects/untitled1/src/main/resources/config.properties");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='formItems']")));
        WebElement form= driver.findElement(By.xpath("//div[@class='formItems']"));
        highlightElement(driver,form);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-1i8o47w']")));
        List<WebElement> formDropdownOptions=  form.findElements(By.xpath(".//div[@class=' css-1i8o47w']"));


        WebElement issuingPartyDropdown= formDropdownOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyDropdown));
        highlightElement(driver,issuingPartyDropdown);
        issuingPartyDropdown.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-1']")));
        WebElement issuingPartyValue= form.findElement(By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyValue));
        highlightElement(driver,issuingPartyValue);
        issuingPartyValue.click();

        WebElement receivingParty= formDropdownOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-0']")));
        WebElement receivingPartyValue= form.findElement(By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(receivingPartyValue));
        highlightElement(driver,receivingPartyValue);
        receivingPartyValue.click();

        WebElement saveBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();




        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Update Status']")));
        WebElement updateBtn= driver.findElement(By.xpath("//button[text()='Update Status']"));
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='shipmentStatusJourney']")));
        trackingSecion= driver.findElement(By.xpath("//div[@class='shipmentStatusJourney']"));
        highlightElement(driver,trackingSecion);

        updateStatusBtn= trackingSecion.findElement(By.xpath(".//span"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
        datePicker= driver.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(By.xpath("//input[@placeholder='Select Date']"));
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        newStatus= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(newStatus));
        highlightElement(driver,newStatus);
        newStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-shipmentStatus-option-0']")));
        newStatusValue= driver.findElement(By.xpath("//div[@id='react-select-shipmentStatus-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(newStatusValue));
        highlightElement(driver,newStatusValue);
        newStatusValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Update Status']")));
        updateBtn= driver.findElement(By.xpath("//button[text()='Update Status']"));
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='shipmentStatusJourney']")));
        trackingSecion= driver.findElement(By.xpath("//div[@class='shipmentStatusJourney']"));
        highlightElement(driver,trackingSecion);

        updateStatusBtn= trackingSecion.findElement(By.xpath(".//span"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();

        Thread.sleep(3000);
        dateInput= driver.findElement(By.xpath("//input[@placeholder='Select Date']"));
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        newStatus= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(newStatus));
        highlightElement(driver,newStatus);
        newStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-shipmentStatus-option-0']")));
        newStatusValue= driver.findElement(By.xpath("//div[@id='react-select-shipmentStatus-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(newStatusValue));
        highlightElement(driver,newStatusValue);
        newStatusValue.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Update Status']")));
        updateBtn= driver.findElement(By.xpath("//button[text()='Update Status']"));
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        //from heare

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='actionItem']")));
        WebElement markDeliveredBtn= driver.findElements(By.xpath("//div[@class='actionItem']")).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(markDeliveredBtn));
        highlightElement(driver,markDeliveredBtn);
        markDeliveredBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='lotDetailContainer']")));
        List<WebElement> itemsList= driver.findElements(By.xpath("//div[@class='lotDetailContainer']"));

        for(WebElement item:itemsList)
        {
            highlightElement(driver,item);
            WebElement expectedQty= item.findElement(By.xpath(".//div[@class='col s12 m2']"));
            highlightElement(driver,expectedQty);
            String expectedQtyValue= expectedQty.getText();

            WebElement receivedQty= item.findElement(By.xpath(".//input[@id='tfid-0-0']"));
            receivedQty.sendKeys(expectedQtyValue);
        }

        Thread.sleep(4000);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='weighmentDocument']")));
//        WebElement uploadSlip= driver.findElement(By.xpath("//input[@name='weighmentDocument']"));
//        uploadSlip.sendKeys("/home/yash/IdeaProjects/untitled1/src/main/resources/config.properties");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='formItems']")));
        form= driver.findElement(By.xpath("//div[@class='formItems']"));
        highlightElement(driver,form);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-1i8o47w']")));
        formDropdownOptions=  form.findElements(By.xpath("//div[@class=' css-1i8o47w']"));


        issuingPartyDropdown= formDropdownOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyDropdown));
        highlightElement(driver,issuingPartyDropdown);
        issuingPartyDropdown.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-0']")));
        issuingPartyValue= form.findElement(By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyValue));
        highlightElement(driver,issuingPartyValue);
        issuingPartyValue.click();

        receivingParty= formDropdownOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-1']")));
        receivingPartyValue= form.findElement(By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(receivingPartyValue));
        highlightElement(driver,receivingPartyValue);
        receivingPartyValue.click();

        saveBtn= driver.findElement(By.xpath("//button[text()='Save']"));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modalFooter']//span[@class='loading-icon m-r-10 hide']")));

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
        saveBtn=driver.findElement(By.xpath("//button[text()='Save']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Share GRN']")));
        WebElement shareGRNBtn= driver.findElement(By.xpath("//button[text()='Share GRN']"));
        wait.until(ExpectedConditions.elementToBeClickable(shareGRNBtn));
        highlightElement(driver,shareGRNBtn);
        shareGRNBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement person_dropdown= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(person_dropdown));
        highlightElement(driver,person_dropdown);
        person_dropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='assignedTo-input-tfid-0-0']")));
        WebElement personName_hint= driver.findElement(By.xpath("//input[@id='assignedTo-input-tfid-0-0']"));
        personName_hint.sendKeys("a");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-assignedTo-option-0']")));
        WebElement person_value= driver.findElement(By.xpath("//div[@id='react-select-assignedTo-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(person_value));
        highlightElement(driver,person_value);
        person_value.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Share with 1 person(s)']")));
        WebElement shareBtn= driver.findElement(By.xpath("//button[text()='Share with 1 person(s)']"));
        wait.until(ExpectedConditions.elementToBeClickable(shareBtn));
        highlightElement(driver,shareBtn);
        shareBtn.click();

    }


    /*
    public void uploadDocs()
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='actionsWrapper']//input[@id='delivery-in-detail-upload-document']")));
        WebElement uploadDoc= driver.findElement(By.xpath("//div[@class='actionsWrapper']//input[@id='delivery-in-detail-upload-document']"));
        uploadDoc.sendKeys("/home/yash/IdeaProjects/untitled1/src/main/resources/config.properties");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement docType= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(docType));
        docType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-documentType-option-0']")));
        WebElement doctype_value= driver.findElement(By.xpath("//div[@id='react-select-documentType-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(doctype_value));
        highlightElement(driver,doctype_value);
        doctype_value.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-1i8o47w']")));
        List<WebElement> formDropdownOptions=  driver.findElements(By.xpath("//div[@class=' css-1i8o47w']"));


        WebElement issuingPartyDropdown= formDropdownOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyDropdown));
        highlightElement(driver,issuingPartyDropdown);
        issuingPartyDropdown.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-0']")));
        WebElement issuingPartyValue= driver.findElement(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyValue));
        highlightElement(driver,issuingPartyValue);
        issuingPartyValue.click();

        WebElement receivingParty= formDropdownOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-1']")));
        WebElement receivingPartyValue= driver.findElement(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(receivingPartyValue));
        highlightElement(driver,receivingPartyValue);
        receivingPartyValue.click();

        WebElement saveBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();
    }
    */
    @Test(dependsOnMethods = "updateTrackingDetails")
    public void uploadDocs() throws InterruptedException, IOException {

        String mainWindow= driver.getWindowHandle();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='delivery-in-detail-upload-document']")));
//        WebElement uploadDoc= driver.findElement(By.xpath("//input[@id='delivery-in-detail-upload-document']"));
//        uploadDoc.sendKeys("/home/yash/Pictures/Screenshots/screenshot.png");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement docType= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(docType));
        highlightElement(driver,docType);
        docType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-documentType-option-6']")));
        WebElement docType_value= driver.findElement(By.xpath("//div[@id='react-select-documentType-option-6']"));
        wait.until(ExpectedConditions.elementToBeClickable(docType_value));
        docType_value.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement issuingParty= driver.findElements(By.xpath("//div[@class=' css-1i8o47w']")).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingParty));
        highlightElement(driver,issuingParty);
        issuingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-issuingParty-option-1']")));
        WebElement issuingParty_value= driver.findElement(By.xpath("//div[@id='react-select-issuingParty-option-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(issuingParty_value));
        highlightElement(driver,issuingParty_value);
        issuingParty_value.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement receivingParty= driver.findElements(By.xpath("//div[@class=' css-1i8o47w']")).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-receivingParty-option-0']")));
        WebElement receivingParty_value= driver.findElement(By.xpath("//div[@id='react-select-receivingParty-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty_value));
        highlightElement(driver,receivingParty_value);
        receivingParty_value.click();

        WebElement invoiceInput= driver.findElement(By.id("tfid-0-3"));
        int invoiceNumber= generateInvoiceNumber();
        invoiceInput.sendKeys(String.valueOf(invoiceNumber));

        WebElement invoiceAmount= driver.findElement(By.id("tfid-0-5"));
        invoiceAmount.sendKeys(prop.getProperty("invoice-amount"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
        WebElement datePicker= driver.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(By.xpath("//input[@placeholder='Select end date']"));
        dateInput.sendKeys(date);


        WebElement saveBtn=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        Thread.sleep(10000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tableContainer']//tbody")));
        WebElement container= driver.findElement(By.xpath("//div[@class='tableContainer']//tbody"));
        highlightElement(driver,container);

        Thread.sleep(1500);
        WebElement currInvoice= container.findElements(By.xpath(".//td")).get(5);
        highlightElement(driver,currInvoice);

        WebElement redirectBtn= currInvoice.findElement(By.xpath(".//button"));
        wait.until(ExpectedConditions.elementToBeClickable(redirectBtn));
        highlightElement(driver,redirectBtn);
        redirectBtn.click();


        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='redirectBlock']")));
        WebElement redirectBlock= driver.findElement(By.xpath("//button[@class='redirectBlock']"));
        wait.until(ExpectedConditions.elementToBeClickable(redirectBlock));
        highlightElement(driver,redirectBlock);
        redirectBlock.click();



        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='lineItemCard']")));
        List<WebElement> itemList= driver.findElements(By.xpath("//div[@class='lineItemCard']"));
        for(WebElement item:itemList)
        {
            highlightElement(driver,item);
            WebElement quantityRemainingElement= item.findElements(By.xpath(".//span[@class='chip-value']")).get(1);
            highlightElement(driver,quantityRemainingElement);
            String qty= quantityRemainingElement.getText();

            WebElement quantityInput= item.findElement(By.xpath(".//input[@name='otherCharges']"));
            highlightElement(driver,quantityInput);
            quantityInput.sendKeys(qty);

            Thread.sleep(2000);

            WebElement radioGroup= item.findElement(By.xpath(".//div[@class='radio-group']"));
            highlightElement(driver,radioGroup);

            WebElement radioBtn= radioGroup.findElement(By.xpath(".//label"));
            radioBtn.click();
        }

        Thread.sleep(1000);
        WebElement selectAllItems= driver.findElement(By.xpath("//label[@class='checkboxLabel']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectAllItems));
        selectAllItems.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement doneBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
        highlightElement(driver,doneBtn);
        doneBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement submitBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement publishBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(publishBtn));
        highlightElement(driver,publishBtn);
        publishBtn.click();


        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default']")));
        WebElement lot_redirect= driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        wait.until(ExpectedConditions.elementToBeClickable(lot_redirect));
        highlightElement(driver,lot_redirect);
        lot_redirect.click();

        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='value ellipsisText linkTxt']")));
        driver.findElement(By.xpath("//span[@class='value ellipsisText linkTxt']")).click();


        Thread.sleep(5000);
        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);


        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='actionItem']")));
        WebElement viewInventoryBtn= driver.findElements(By.xpath("//div[@class='actionItem']")).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(viewInventoryBtn));
        highlightElement(driver,viewInventoryBtn);
        viewInventoryBtn.click();

        Thread.sleep(2000);
        for (String winHandle : driver.getWindowHandles())
            driver.switchTo().window(winHandle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tabContainer']")));
        WebElement tabContainer= driver.findElement(By.xpath("//div[@class='tabContainer']"));
        highlightElement(driver,tabContainer);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li")));
        WebElement docSection= tabContainer.findElement(By.xpath(".//li[4]//button"));
        wait.until(ExpectedConditions.elementToBeClickable(docSection));
        highlightElement(driver,docSection);
        docSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='actionBtns']")));
        WebElement actionBtns= driver.findElement(By.xpath("//div[@class='actionBtns']"));
        highlightElement(driver,actionBtns);

        WebElement publishIcon= actionBtns.findElements(By.xpath(".//span[@role='button']")).get(3);
        wait.until(ExpectedConditions.elementToBeClickable(publishIcon));
        highlightElement(driver,publishIcon);
        publishIcon.click();


        mainWindow= driver.getWindowHandle();

        Thread.sleep(4000);
        for (String winHandle : driver.getWindowHandles())
            driver.switchTo().window(winHandle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tfid-0-1")));
        invoiceInput= driver.findElement(By.id("tfid-0-1"));
        invoiceInput.clear();
        invoiceInput.sendKeys(prop.getProperty("invoice-number"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
        datePicker= driver.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--031 react-datepicker__day--selected react-datepicker__day--today']"));
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(By.xpath("//input[@placeholder='Select invoice date']"));
        dateInput.sendKeys(date);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
        datePicker= driver.findElements(By.className("react-datepicker__input-container")).get(1);
        datePicker.click();

        monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--031.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(By.xpath("//input[@placeholder='Select voucher date']"));
        dateInput.sendKeys(date);


        publishBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(publishBtn));
        highlightElement(driver,publishBtn);
        publishBtn.click();



        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='value ellipsisText linkTxt']")));
        driver.findElement(By.xpath("//span[@class='value ellipsisText linkTxt']")).click();
       */
    }


    @Test(dependsOnMethods = "uploadDocs")
    public void createRFQ() throws InterruptedException, IOException {

//        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.get("https://stg3-cms.ofbusiness.co.in/oasys-fe/warehouse/TIRUVALLUR_WH_024/details");
//        loadPropFile();

        //String mainWindow= driver.getWindowHandle();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(80));

        Thread.sleep(4000);
        for (String winHandle : driver.getWindowHandles())
            driver.switchTo().window(winHandle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='actionsListBlock']")));
        WebElement actionsBlock= driver.findElements(By.xpath("//div[@class='actionsListBlock']")).get(1);
        highlightElement(driver,actionsBlock);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='actionItem']")));
        WebElement createRFQBtn= actionsBlock.findElements(By.xpath(".//div[@class='actionItem']")).get(2);
        highlightElement(driver,createRFQBtn);
        createRFQBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement selectBuyer= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectBuyer));
        highlightElement(driver,selectBuyer);
        selectBuyer.click();

        WebElement buyerHint= driver.findElement(By.id("buyer-input-tfid-0-0"));
        buyerHint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-buyer-option-0']")));
        WebElement buyer_value= driver.findElement(By.xpath("//div[@id='react-select-buyer-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(buyer_value));
        highlightElement(driver,buyer_value);
        buyer_value.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='radioLabel']")));
        WebElement billingAddressValue= driver.findElement(By.xpath("//label[@class='radioLabel']"));
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='checkboxLabel']")));
        WebElement shippngAddressValue= driver.findElement(By.xpath("//label[@class='checkboxLabel']"));
        wait.until(ExpectedConditions.elementToBeClickable(shippngAddressValue));
        highlightElement(driver,shippngAddressValue);
        shippngAddressValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement nextBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='l2-category-group ']")));
        List<WebElement> products= driver.findElements(By.xpath("//div[@class='l2-category-group ']"));

        for(WebElement product:products)
        {
            highlightElement(driver,product);
            WebElement showMoreBtn= product.findElement(By.xpath(".//i[@class='material-icons']"));
            wait.until(ExpectedConditions.elementToBeClickable(showMoreBtn));
            highlightElement(driver,showMoreBtn);
            showMoreBtn.click();

            //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody//td")));
            List<WebElement> options= product.findElements(By.xpath(".//tbody//td"));
            WebElement selectItem= options.get(0).findElement(By.xpath(".//label"));
            highlightElement(driver,selectItem);
            selectItem.click();

            WebElement stockQty= options.get(4);
            String stock= stockQty.getText();

            WebElement qty_input= product.findElement(By.xpath(".//input[@id='tfid-0-0']"));
            qty_input.sendKeys(String.valueOf(stock));

        }

        Thread.sleep(6000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement addToCartBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        highlightElement(driver,addToCartBtn);
        addToCartBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartBtn ']")));
        WebElement viewCart= driver.findElement(By.xpath("//div[@class='cartBtn ']"));
        wait.until(ExpectedConditions.elementToBeClickable(viewCart));
        highlightElement(driver,viewCart);
        viewCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement createRfQBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(createRfQBtn));
        highlightElement(driver,createRfQBtn);
        createRfQBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary' and contains(text(),'OK')]")));
        WebElement okayBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'OK')]"));
        wait.until(ExpectedConditions.elementToBeClickable(okayBtn));
        highlightElement(driver,okayBtn);
        okayBtn.click();







        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkBoxContent")));
        WebElement checkBoxSection= driver.findElement(By.className("checkBoxContent"));
        highlightElement(driver,checkBoxSection);

        System.out.println("After check Box");

        WebElement checkoption= checkBoxSection.findElement(By.cssSelector("input[type='checkbox']"));
        highlightElement(driver,checkoption);
        checkoption.click();
        System.out.println("Check Box Clicked");

        List<WebElement> actionButtons= driver.findElements(By.cssSelector("button.btn.btn-default"));
        actionButtons.get(2).click();

        WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("subCategoryForm")));

        WebElement subcategoryForm= driver.findElement(By.className("subCategoryForm"));
        highlightElement(driver,subcategoryForm);

        List<WebElement> option= subcategoryForm.findElements(By.className("form-control"));
        WebElement baseRate= option.get(2);
        highlightElement(driver,baseRate);
        baseRate.sendKeys("100");

        WebElement freightRate= subcategoryForm.findElement(By.id("tfid-0-6"));
        highlightElement(driver,freightRate);
        freightRate.sendKeys("100");

        WebElement loadingCharges= subcategoryForm.findElement(By.id("tfid-0-7"));
        loadingCharges.sendKeys("50");

        List<WebElement> dropDownOptions= driver.findElements(By.className("reactSelectContainer"));
        dropDownOptions.get(2).click();

        WebElement gstOption= dropDownOptions.get(2).findElement(By.id("react-select-gst-option-2"));
        highlightElement(driver,gstOption);
        gstOption.click();
        Thread.sleep(3000);

        try
        {
            WebElement copyRatesToAll= subcategoryForm.findElement(By.className("copyBtn"));
            if(copyRatesToAll.isDisplayed())
                copyRatesToAll.click();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally
        {
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
            WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
            Thread.sleep(2000);
            highlightElement(driver,saveBtn);
            saveBtn.click();

        }

    }


    @Test(dependsOnMethods = "createRFQ")
    public void handleBuyerPrefs() throws InterruptedException, IOException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Buyer Preferences']")));

        WebElement buyerPrefs= driver.findElement(By.xpath("//span[text()='Buyer Preferences']"));
        highlightElement(driver,buyerPrefs);
        buyerPrefs.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("contentView")));
        List<WebElement> buyerPrefsOptions= driver.findElements(By.className("contentView"));

        System.out.println("Size:" + buyerPrefsOptions.size());

//        WebElement preferences= buyerPrefsOptions.get(0).findElement(By.className("heading"));
//        wait.until(ExpectedConditions.elementToBeClickable(preferences));
//        highlightElement(driver,preferences);
//        preferences.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-default")));
        WebElement editBtn=  buyerPrefsOptions.get(0).findElement(By.cssSelector("button.btn.btn-default"));
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        highlightElement(driver,editBtn);
        editBtn.click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("address")));
//        WebElement billingAddress= driver.findElement(By.xpath("//div[@class= ' css-1i8o47w']"));
//        highlightElement(driver,billingAddress);
//        billingAddress.click();
//
//        WebElement addressValue= driver.findElement(By.className("addressValue"));
//        highlightElement(driver,addressValue);
//        addressValue.click();

        List<WebElement> addressesOptions= driver.findElements(By.xpath("//div[@class= ' css-1i8o47w']"));
        WebElement shippingAddressBtn= addressesOptions.get(3);
        highlightElement(driver,shippingAddressBtn);
        shippingAddressBtn.click();

        List<WebElement> shippingAddressOptions= driver.findElements(By.xpath("//div[@class=' css-yxf0z2']"));
        if(!shippingAddressOptions.isEmpty())
            shippingAddressOptions.get(0).click();

        WebElement billingAddressBtn= addressesOptions.get(1);
        highlightElement(driver,billingAddressBtn);
        billingAddressBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-billingAddress-option-0']")));
        WebElement billingAddressValue= driver.findElement(By.xpath("//div[@id='react-select-billingAddress-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        WebElement toleranceInput= buyerPrefsOptions.get(0).findElement(By.id("tfid-0-5"));
        toleranceInput.sendKeys("0");

        WebElement saveAddressBtn= buyerPrefsOptions.get(0).findElement(By.cssSelector("button.btn.btn-primary"));
        saveAddressBtn.click();

        Thread.sleep(5000);

        WebElement paymentTerms=  buyerPrefsOptions.get(1);
        WebElement paymentTermsSection= paymentTerms.findElement(By.className("heading"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentTermsSection);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(paymentTermsSection));
        highlightElement(driver,paymentTermsSection);
        paymentTermsSection.click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default']")));
        WebElement editBtn2= paymentTerms.findElement(By.xpath(".//button[@class='btn btn-default']"));
        wait.until(ExpectedConditions.elementToBeClickable(editBtn2));
        highlightElement(driver,editBtn2);
        editBtn2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tfid-0-0")));
        WebElement advanceInput= paymentTerms.findElement(By.id("tfid-0-0"));
        advanceInput.clear();
        advanceInput.sendKeys("100");

        WebElement saveBtn= paymentTerms.findElement(By.cssSelector("button.btn.btn-primary.saveBtn"));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        Thread.sleep(2000);
        paymentTermsSection.click();
        WebElement sendForApproval= paymentTerms.findElement(By.xpath("//button[text()='Send for Approval']"));
        wait.until(ExpectedConditions.elementToBeClickable(sendForApproval));

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();

        WebElement uploadPO=  buyerPrefsOptions.get(2);
        WebElement uploadBuyerPoSection= uploadPO.findElement(By.className("heading"));
        highlightElement(driver,uploadBuyerPoSection);
        uploadBuyerPoSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='enable']")));
        WebElement checkBox= driver.findElement(By.xpath("//input[@class='enable']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();
        System.out.println("Check Box Clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-default.editBtn")));
        WebElement editBtn3= uploadPO.findElement(By.cssSelector("button.btn.btn-default.editBtn"));
        wait.until(ExpectedConditions.elementToBeClickable(editBtn3));
        highlightElement(driver,editBtn3);
        editBtn3.click();

        WebElement buyerContainer= uploadPO.findElement(By.className("buyerPoContainer"));
        WebElement PO_No= buyerContainer.findElement(By.id("tfid-0-1"));
        highlightElement(driver,PO_No);
        PO_No.sendKeys("12232");

        WebElement datePicker= driver.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(By.className("react-datepicker-ignore-onclickoutside"));
        dateInput.sendKeys(date);

        WebElement uploadDoc= uploadPO.findElement(By.id("upload-document-undefined"));
        uploadDoc.sendKeys("/home/yash/Pictures/Screenshots/screenshot.png");

        Thread.sleep(6000);

        WebElement saveBtn2= uploadPO.findElement(By.xpath("//button[text()='Save ']"));
        Thread.sleep(1500);
        highlightElement(driver,saveBtn2);
        saveBtn2.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btnEdit.material-icons")));
        WebElement editEntity= driver.findElement(By.cssSelector("button.btnEdit.material-icons"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", editEntity);


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
//        WebElement entityNameSection= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
//        wait.until(ExpectedConditions.elementToBeClickable(entityNameSection));
//        highlightElement(driver,entityNameSection);
//        entityNameSection.click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-ofbEntityName-option-0']")));
//        WebElement entityName= driver.findElement(By.xpath("//div[@id='react-select-ofbEntityName-option-0']"));
//        wait.until(ExpectedConditions.elementToBeClickable(entityName));
//        highlightElement(driver,entityName);
//        entityName.click();

        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-17vhrl4']")));
        WebElement addressSection= driver.findElements(By.xpath("//div[@class=' css-17vhrl4']")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(addressSection));
        highlightElement(driver,addressSection);
        addressSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-ofbEntityAddress-option-0']")));
        WebElement addressValue= addressSection.findElement(By.xpath("//div[@id='react-select-ofbEntityAddress-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(addressValue));
        highlightElement(driver,addressValue);
        addressValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']")));
        WebElement updateBtn= driver.findElement(By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal']//span[@class='loading-icon m-r-10 hide']")));

        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='optHeader']//span")));
        WebElement itemSpecifications= driver.findElement(By.xpath("//div[@class='optHeader']//span"));
        itemSpecifications.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit Buyer Quote ']")));
        WebElement submitBuyerQuote= driver.findElement(By.xpath("//button[text()='Submit Buyer Quote ']"));

        wait.until(ExpectedConditions.elementToBeClickable(submitBuyerQuote));
        highlightElement(driver,submitBuyerQuote);
        submitBuyerQuote.click();

        Thread.sleep(3000);

    }

    @Test(dependsOnMethods = "handleBuyerPrefs")
    public void handleSupplierQuotation() throws InterruptedException, IOException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("supplierQuote")));
        WebElement supplierQuote= driver.findElement(By.className("supplierQuote"));
        highlightElement(driver,supplierQuote);
        supplierQuote.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='optHeader']//span[text()='View Supplier Details ']")));
        WebElement viewSupplierDetails= driver.findElement(By.xpath("//div[@class='optHeader']//span[text()='View Supplier Details ']"));
        wait.until(ExpectedConditions.elementToBeClickable(viewSupplierDetails));
        highlightElement(driver,viewSupplierDetails);
        viewSupplierDetails.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default']")));
        WebElement sendForApproval= driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        wait.until(ExpectedConditions.elementToBeClickable(sendForApproval));
        highlightElement(driver,sendForApproval);
        sendForApproval.click();

/*
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        WebElement checkBoxSection= driver.findElement(By.className("checkBoxContent"));
        highlightElement(driver,checkBoxSection);

        System.out.println("After check Box");

        WebElement checkoption= checkBoxSection.findElement(By.cssSelector("input[type='checkbox']"));
        highlightElement(driver,checkoption);
        checkoption.click();
        System.out.println("Check Box Clicked");

        WebElement addSupplier= driver.findElements(By.cssSelector("button.btn.btn-primary")).get(1);
        highlightElement(driver,addSupplier);
        addSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement searchSupplier= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        searchSupplier.click();

        WebElement supplier_hint= driver.findElement(By.xpath("//input[@id='selectSupplier-input-tfid-0-0']"));
        supplier_hint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-selectSupplier-option-0")));
        WebElement supplierOptions= driver.findElement(By.id("react-select-selectSupplier-option-0"));
        wait.until(ExpectedConditions.elementToBeClickable(supplierOptions));
        highlightElement(driver,supplierOptions);
        supplierOptions.click();

//        Thread.sleep(3000);
//        List<WebElement> addressOptions= driver.findElements(By.xpath("//div[@class=' css-1i8o47w']"));
//        WebElement billingAddress= addressOptions.get(1);
//        highlightElement(driver,billingAddress);
//        billingAddress.click();
//
//        WebElement billingAddressValue= driver.findElement(By.xpath("//div[@id='react-select-billingAddress-option-0']"));
//        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
//        billingAddressValue.click();

//        WebElement pickUpAddress= addressOptions.get(4);
//        highlightElement(driver,pickUpAddress);
//        pickUpAddress.click();
//
//        WebElement pickUpAddressValue= driver.findElement(By.xpath("//div[@id='react-select-pickupAddress-option-0']"));
//        wait.until(ExpectedConditions.elementToBeClickable(pickUpAddressValue));
//        pickUpAddressValue.click();

        Thread.sleep(4000);

        List<WebElement> addressOptions= driver.findElements(By.xpath("//div[@class=' css-17vhrl4']"));
        System.out.println(addressOptions.size());
        WebElement pickupAddress= addressOptions.get(4);
        pickupAddress.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1m5nn3x']//div")));
        WebElement pickupAddressValue= driver.findElement(By.xpath("//div[@class=' css-1m5nn3x']//div"));
        pickupAddressValue.click();

        WebElement billingAddress= addressOptions.get(2);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1ul4jvx-option']")));
        WebElement billingAddressvalue= driver.findElement(By.xpath("//div[@class=' css-1ul4jvx-option']"));
        billingAddressvalue.click();

        System.out.println("Done till here");
        WebElement incentiveReason= driver.findElement(By.id("reason-tfid-0-0"));
        wait.until(ExpectedConditions.visibilityOf(incentiveReason));
        highlightElement(driver,incentiveReason);
        incentiveReason.click();

        WebElement incentiveReasonValue= driver.findElement(By.id("react-select-reason-option-0"));
        wait.until(ExpectedConditions.elementToBeClickable(incentiveReasonValue));
        highlightElement(driver,incentiveReasonValue);
        incentiveReasonValue.click();

        System.out.println("Done");

        List<WebElement> radioGroups= driver.findElements(By.xpath("//div[@class='radio-group']"));

        WebElement incentiveTypes= radioGroups.get(2);
        incentiveTypes.findElement(By.xpath("//span[text()='Incoming']")).click();

        WebElement taxTypes= radioGroups.get(3);
        taxTypes.findElement(By.xpath("//span[text()='Without Tax']")).click();

//        WebElement incentiveLevel= radioGroups.get(4);
//        incentiveLevel.findElement(By.xpath("//span[text()='Item Level']")).click();

        WebElement incentiveLevel= driver.findElements(By.xpath("//span[text()='Item Level']")).get(1);
        incentiveLevel.click();

        Thread.sleep(2500);
        WebElement nextBtn= driver.findElement(By.cssSelector("button.btn.btn-primary"));
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        List<WebElement> subcategoryForms= driver.findElements(By.className("subCategoryForm"));
        for(WebElement subcategoryForm:subcategoryForms)
        {
            WebElement itemQty= subcategoryForm.findElement(By.id("tfid-0-0"));
            itemQty.clear();
            itemQty.sendKeys("100");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tfid-0-0")));
        WebElement itemQty= driver.findElement(By.id("tfid-0-0"));
        itemQty.clear();
        itemQty.sendKeys("100");

        WebElement baseRate= driver.findElement(By.id("tfid-0-2"));
        baseRate.sendKeys("100");

        WebElement freightRate= driver.findElement(By.id("tfid-0-4"));
        freightRate.sendKeys("10");


        Thread.sleep(3000);
        WebElement dropDownOptions= driver.findElement(By.className("reactSelectContainer"));
        dropDownOptions.click();

//        WebElement element = dropDownOptions.get(1);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-gst-option-2']")));
        //dropDownOptions.get(1).click();

        WebElement gstOption= driver.findElement(By.xpath("//div[@id='react-select-gst-option-2']"));
        highlightElement(driver,gstOption);
        gstOption.click();

        WebElement copyRatesToAll= driver.findElement(By.className("copyBtn"));
        if(copyRatesToAll.isDisplayed())
            copyRatesToAll.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-primary")));
        WebElement saveBtn= driver.findElement(By.cssSelector("button.btn.btn-primary"));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='optHeader']//span[@class='active']")));
        WebElement viewDetails= driver.findElement(By.xpath("//div[@class='optHeader']//span[@class='active']"));
        highlightElement(driver,viewDetails);
        viewDetails.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-default']")));
        WebElement sendForApproval= driver.findElement(By.xpath("//button[@class='btn btn-default']"));

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();


*/
        List<WebElement> toasts= driver.findElements(By.xpath("//div[@class='Toastify__toast-body']"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(toasts));

        Thread.sleep(8000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-primary")));
        WebElement createOrder= driver.findElement(By.cssSelector("button.btn.btn-primary"));
        wait.until(ExpectedConditions.elementToBeClickable(createOrder));
        highlightElement(driver,createOrder);
        createOrder.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modalContent']")));

        WebElement checkBox= driver.findElement(By.xpath("//div[@class='checkbox-group']//span"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        highlightElement(driver,checkBox);
        checkBox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']")));
        WebElement submitBtn= driver.findElement(By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        //Thread.sleep(10000);
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tfid-0-0_0-alerts")));
        WebElement checkBox1= driver.findElement(By.id("tfid-0-0_0-alerts"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox1));
        checkBox1.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tfid-0-0_1-alerts")));
        WebElement checkBox2= driver.findElement(By.id("tfid-0-0_0-alerts"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox1));
        checkBox2.click();

        WebElement submitBtn= driver.findElement(By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();*/

    }


    @Test(dependsOnMethods = "handleSupplierQuotation")
    public void createDispatch() throws IOException, InterruptedException {

//        loadPropFile();
//        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//        WebDriver driver;
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.get("https://stg3-cms.ofbusiness.co.in/oasys-fe/order/OFB117172430426161");

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(80));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modalFooter']//span[@class='loading-icon m-r-10 hide']")));

        Thread.sleep(5000);

        for(String handle:driver.getWindowHandles())
            driver.switchTo().window(handle);

        Thread.sleep(55000);
        mainWindow= driver.getWindowHandle();

        getOrganizationID(driver);

        Thread.sleep(3000);
        driver.switchTo().window(mainWindow);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("links__list")));
        WebElement linksLst= driver.findElement(By.className("links__list"));
        highlightElement(driver,linksLst);

        List<WebElement> actionButtons= linksLst.findElements(By.tagName("button"));
        WebElement createDispatchBtn= actionButtons.get(4);
        wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
        highlightElement(driver,createDispatchBtn);
        createDispatchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default']")));
        WebElement selectSupplier= driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectSupplier));
        highlightElement(driver,selectSupplier);
        selectSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tableContainer']//span")));
        WebElement checkBox= driver.findElement(By.xpath("//div[@class='tableContainer']//span"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        List<WebElement> items= driver.findElements(By.xpath("//tbody//tr"));
        for(WebElement item:items)
        {
            highlightElement(driver,item);
            List<WebElement> options= item.findElements(By.xpath(".//td"));

//            checkBox= options.get(0).findElement(By.xpath(".//label"));
//            wait.until(ExpectedConditions.elementToBeClickable(checkBox));
//            highlightElement(driver,checkBox);
//            checkBox.click();

            WebElement pendingAmt= options.get(4).findElement(By.xpath(".//div[@class='value pending']"));
            String qty= pendingAmt.getText();

            WebElement value= item.findElement(By.id("tfid-0-0"));
            value.sendKeys(qty);
        }

        try{
            if(driver.findElement(By.xpath("//div[@class='error-msg']")).isDisplayed())
                handleFinance(driver);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
            WebElement addToDispatchBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
            wait.until(ExpectedConditions.elementToBeClickable(addToDispatchBtn));
            highlightElement(driver,addToDispatchBtn);
            addToDispatchBtn.click();

            Thread.sleep(5000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartBtn ']")));
            WebElement viewDispatch= driver.findElement(By.xpath("//div[@class='cartBtn ']"));
            wait.until(ExpectedConditions.elementToBeClickable(viewDispatch));
            highlightElement(driver,viewDispatch);
            viewDispatch.click();

        /*
        // This is additional

        Thread.sleep(5000);
        Thread.sleep(5000);
        orderSection= driver.findElements(By.xpath("//button[@class='md-raised md-primary side-menu-link md-button ng-scope md-ofb-brown-theme md-ink-ripple']")).get(6);
        wait.until(ExpectedConditions.elementToBeClickable(orderSection));

        Thread.sleep(4000);

        highlightElement(driver,orderSection);
        orderSection.click();


        Thread.sleep(4000);
//        buyoutBtn= orderSection.findElements(By.xpath(".//button[@class='md-primary md-raised side-menu-link md-button ng-scope md-ofb-brown-theme md-ink-ripple']")).get(1);
//        wait.until(ExpectedConditions.elementToBeClickable(buyoutBtn));
//        highlightElement(driver,buyoutBtn);
//        buyoutBtn.click();

        buyoutBtn= driver.findElements(By.xpath("//ul[@class='drop-down-list ng-scope']//li")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(buyoutBtn));
        highlightElement(driver,buyoutBtn);
        buyoutBtn.click();

        //buyerName= organisationName;

        buyerName="Wiegand Inc Test";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='customTable']")));
        orderList= driver.findElement(By.xpath("//table[@class='customTable']"));
        highlightElement(driver,orderList);

        buyers= driver.findElements(By.xpath("//tbody//tr"));
        for(WebElement buyer:buyers)
        {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement buyerElement= buyer.findElement(By.xpath(".//td[2]//span[@class='buyerName']"));
            highlightElement(driver,buyerElement);
            if(buyerElement.getText().equalsIgnoreCase(buyerName))
            {
                highlightElement(driver,buyer);
                buyer.click();
                break;
            }
        }

        // This is additional

*/

            //handlingCreatedDispatch(driver,wait);


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-primary")));
            WebElement nextBtn= driver.findElement(By.cssSelector("button.btn.btn-primary"));
            wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
            highlightElement(driver,nextBtn);
            nextBtn.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-17vhrl4']")));

            List<WebElement> addressOptions= driver.findElements(By.xpath("//div[@class=' css-17vhrl4']"));

            WebElement billingAddress= addressOptions.get(0);
            wait.until(ExpectedConditions.elementToBeClickable(billingAddress));
            highlightElement(driver,billingAddress);
            billingAddress.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-billingAddress-option-0")));
            WebElement billingAddressValue= driver.findElement(By.id("react-select-billingAddress-option-0"));
            wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
            highlightElement(driver,billingAddressValue);
            billingAddressValue.click();

            WebElement pickupAddress= addressOptions.get(1);
            wait.until(ExpectedConditions.elementToBeClickable(pickupAddress));
            highlightElement(driver,pickupAddress);
            pickupAddress.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-pickupAddress-option-0")));
            WebElement pickupAddressValue= driver.findElement(By.id("react-select-pickupAddress-option-0"));
            wait.until(ExpectedConditions.elementToBeClickable(pickupAddressValue));
            highlightElement(driver,pickupAddressValue);
            pickupAddressValue.click();

            WebElement datePicker= driver.findElements(By.className("react-datepicker__input-container")).get(0);
            datePicker.click();

            WebElement monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
            String month= monthYearBtn.getText().split(" ")[0];
            String year= monthYearBtn.getText().split(" ")[1];
            WebElement dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
            String date= dateBtn.getText()+" "+ month+" "+year;

            WebElement dateInput= driver.findElement(By.className("react-datepicker-ignore-onclickoutside"));
            dateInput.sendKeys(date);


            datePicker= driver.findElements(By.className("react-datepicker__input-container")).get(1);
            datePicker.click();

            monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
            month= monthYearBtn.getText().split(" ")[0];
            year= monthYearBtn.getText().split(" ")[1];
            dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
            date= dateBtn.getText()+" "+ month+" "+year;

            dateInput= driver.findElement(By.className("react-datepicker-ignore-onclickoutside"));
            dateInput.sendKeys(date);

            createDispatchBtn= driver.findElement(By.cssSelector("button.btn.btn-primary"));
            wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
            highlightElement(driver,createDispatchBtn);
            createDispatchBtn.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        }

        //createShipment();

    }


    public void handleFinance(WebDriver driver) throws IOException, InterruptedException {
//        loadPropFile();
//
//        WebDriver driver= new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-fe/order/OFB117169593766597/create-dispatch/6748485310855781189");

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Thread.sleep(38000);

        WebElement financeSection= driver.findElements(By.xpath("//ul[@class='nav-list']")).get(8);
        wait.until(ExpectedConditions.elementToBeClickable(financeSection));
        highlightElement(driver,financeSection);
        financeSection.click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li")));
        WebElement receiptsBtn= financeSection.findElement(By.xpath(".//ul//li"));
        wait.until(ExpectedConditions.elementToBeClickable(receiptsBtn));
        highlightElement(driver,receiptsBtn);
        receiptsBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Add receipt']")));
        WebElement addReceiptBtn= driver.findElement(By.xpath("//button[@aria-label='Add receipt']"));
        wait.until(ExpectedConditions.elementToBeClickable(addReceiptBtn));
        highlightElement(driver,addReceiptBtn);
        addReceiptBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='listValue']//input")));
        WebElement amount= driver.findElement(By.xpath("//span[@class='listValue']//input"));
        amount.sendKeys(prop.getProperty("receipt-amount"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='paymentUtr']")));
        WebElement utrValue= driver.findElement(By.xpath("//input[@name='paymentUtr']"));
        utrValue.sendKeys(prop.getProperty("utr-value"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='paymentFrom']")));
        WebElement party= driver.findElement(By.xpath("//input[@name='paymentFrom']"));
        party.sendKeys(prop.getProperty("party-value"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-select[@name='paymentType']")));
        WebElement transactionType= driver.findElement(By.xpath("//md-select[@name='paymentType']"));
        wait.until(ExpectedConditions.elementToBeClickable(transactionType));
        transactionType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@value='NEFT']")));
        WebElement transactionValue= driver.findElement(By.xpath("//md-option[@value='NEFT']"));
        wait.until(ExpectedConditions.elementToBeClickable(transactionValue));
        transactionValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-select[@name='ofbAccount']")));
        WebElement bankAccount= driver.findElement(By.xpath("//md-select[@name='ofbAccount']"));
        bankAccount.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@ng-value='ofbAccount']")));
        WebElement bankAccountValue= driver.findElement(By.xpath("//md-option[@ng-value='ofbAccount']"));
        wait.until(ExpectedConditions.elementToBeClickable(bankAccountValue));
        highlightElement(driver,bankAccountValue);
        bankAccountValue.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='customButtonFill right md-button ng-scope md-ofb-green-theme md-ink-ripple']")));
        WebElement createBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='responsiveTable']")));
        WebElement financeTable= driver.findElement(By.xpath("//div[@class='responsiveTable']"));
        highlightElement(driver,financeTable);

        driver.navigate().refresh();

        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody")));
        Thread.sleep(20000);
        List<WebElement> financesList= driver.findElements(By.xpath("//div[@class='responsiveTable']//tbody[@class='ng-scope']"));

        System.out.println("Sizex of list==> "+ financesList.size());

        Thread.sleep(2000);

        for(WebElement finance:financesList)
        {
            WebElement check1_amount= finance.findElement(By.xpath(".//td[@class='alignRight ng-binding']"));
            highlightElement(driver,check1_amount);
//            WebElement check2_utr= finance.findElement(By.xpath(".//td[@ng-class='receipt.isSplitting?'borderBottomNone':''']"));
//            highlightElement(driver,check2_utr);
            String amt= check1_amount.getText();
            String AmtArr[]= amt.split(",");
            amt="";
            for(String x:AmtArr)
                amt+=x;
            System.out.println("Amount is " + amt);
            if(amt.equalsIgnoreCase(prop.getProperty("receipt-amount")))
            {
                WebElement btnSection= finance.findElement(By.xpath(".//td[@class='suggestedAmmountWrap customCheckbox']"));
                WebElement mapBtn= btnSection.findElement(By.xpath(".//span"));
                wait.until(ExpectedConditions.elementToBeClickable(mapBtn));
                highlightElement(driver,mapBtn);
                mapBtn.click();



                WebElement organizationInput= btnSection.findElement(By.xpath(".//input[@type='search']"));
                organizationInput.sendKeys(organizationID);



                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='md-virtual-repeat-offsetter']//li")));
                WebElement organizationOption= driver.findElement(By.xpath("//div[@class='md-virtual-repeat-offsetter']//li"));
                wait.until(ExpectedConditions.elementToBeClickable(organizationOption));
                highlightElement(driver,organizationOption);
                organizationOption.click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='customButtonFill md-button md-ofb-green-theme md-ink-ripple']")));
        WebElement saveBtn= driver.findElement(By.xpath("//button[@class='customButtonFill md-button md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();



        /*
                    Here, I need to handle the order-> buyout section
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath("//div[@class='ng-scope']"))));
                    WebElement orderSec= driver.findElements(By.xpath("//div[@class='ng-scope']")).get(29);
                    wait.until(ExpectedConditions.elementToBeClickable(orderSec));
                    highlightElement(driver,orderSec);
                    orderSec.click();

                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath("//div[@class='ng-scope']"))));
                    WebElement buyoutOption= driver.findElements(By.xpath("//div[@class='ng-scope']")).get(31);
                    wait.until(ExpectedConditions.elementToBeClickable(buyoutOption));
                    highlightElement(driver,buyoutOption);
                    buyoutOption.click();

         */

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex")));

        WebElement drawer= driver.findElement(By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex"));
        highlightElement(driver,drawer);

        List<WebElement> options= driver.findElements(By.cssSelector("button.md-raised.md-primary.side-menu-link.md-button.ng-scope.md-ofb-brown-theme.md-ink-ripple"));
        WebElement orderSection= options.get(29);
        highlightElement(driver,orderSection);
        orderSection.click();

//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button.md-raised.md-primary.side-menu-link.md-button.ng-scope.md-ofb-brown-theme.md-ink-ripple")));
//        WebElement buyoutBtn= driver.findElements(By.cssSelector("button.md-raised.md-primary.side-menu-link.md-button.ng-scope.md-ofb-brown-theme.md-ink-ripple")).get(31);
//        wait.until(ExpectedConditions.elementToBeClickable(buyoutBtn));
//        highlightElement(driver,buyoutBtn);
//        buyoutBtn.click();



        //Thread.sleep(8000);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul")));
        WebElement sideSection= driver.findElement(By.xpath("//ul"));
        highlightElement(driver,sideSection);
        WebElement orderSec= sideSection.findElements(By.xpath(".//ul")).get(5);
        wait.until(ExpectedConditions.elementToBeClickable(orderSec));
        highlightElement(driver,orderSec);
        orderSec.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//ul//li//a[text()='Buyout ']")));
        WebElement buyoutOption= driver.findElement(By.xpath("//ul//ul//li//a[text()='Buyout ']"));
        wait.until(ExpectedConditions.elementToBeClickable(buyoutOption));
        highlightElement(driver,buyoutOption);
        buyoutOption.click();

        String buyerName=ofbEntity_Value;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='customTable']")));
        WebElement orderList= driver.findElement(By.xpath("//table[@class='customTable']"));
        highlightElement(driver,orderList);

        List<WebElement> buyers= driver.findElements(By.xpath("//tbody//tr"));
        for(WebElement buyer:buyers)
        {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement buyerElement= buyer.findElement(By.xpath(".//td[6]//span[@class='rowName nowrap']"));
            highlightElement(driver,buyerElement);
            if(buyerElement.getText().equalsIgnoreCase(buyerName))
            {
                highlightElement(driver,buyer);
                buyer.click();
                break;
            }
        }

        handlingCreatedDispatch(driver,wait);


    }


    public static void handlingCreatedDispatch(WebDriver driver,WebDriverWait wait)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("links__list")));
        WebElement linksLst= driver.findElement(By.className("links__list"));
        highlightElement(driver,linksLst);

        List<WebElement> actionButtons= linksLst.findElements(By.tagName("button"));
        WebElement createDispatchBtn= actionButtons.get(4);
        wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
        highlightElement(driver,createDispatchBtn);
        createDispatchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default']")));
        WebElement selectSupplier= driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectSupplier));
        highlightElement(driver,selectSupplier);
        selectSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tableContainer']//span")));
        WebElement checkBox= driver.findElement(By.xpath("//div[@class='tableContainer']//span"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        List<WebElement> items= driver.findElements(By.xpath("//tbody//tr"));
        for(WebElement item:items)
        {
            highlightElement(driver,item);
            List<WebElement> options= item.findElements(By.xpath(".//td"));

//            checkBox= options.get(0).findElement(By.xpath(".//label"));
//            wait.until(ExpectedConditions.elementToBeClickable(checkBox));
//            highlightElement(driver,checkBox);
//            checkBox.click();

            WebElement pendingAmt= options.get(4).findElement(By.xpath(".//div[@class='value pending']"));
            String qty= pendingAmt.getText();

            WebElement value= item.findElement(By.id("tfid-0-0"));
            value.sendKeys(qty);
        }

    }


    //@Test
    public void  createShipment() throws IOException, InterruptedException {
        loadPropFile();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stg3-cms.ofbusiness.co.in/oasys-ts/dispatch/buyout/open/OFB117172260618249-D-1/details");

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(80));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='Dispatch__actionBtn--q2vEq']")));
        WebElement createShipment= driver.findElements(By.xpath("//button[@class='Dispatch__actionBtn--q2vEq']")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(createShipment));
        highlightElement(driver,createShipment);
        createShipment.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='checkboxLabel']")));
        WebElement checkBox= driver.findElement(By.xpath("//label[@class='checkboxLabel']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        WebElement createBtn= driver.findElement(By.cssSelector("button.btn.btn-primary.dispatchActionBtn"));
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dispatchColumns']//tbody")));
        WebElement dispatchItemsSection= driver.findElement(By.xpath("//div[@class='dispatchColumns']//tbody"));

        List<WebElement> dispatchItems= dispatchItemsSection.findElements(By.xpath(".//tr"));

        for(int i=0;i<dispatchItems.size();i++)
        {
            WebElement item= dispatchItems.get(i);
            highlightElement(driver,item);

            WebElement dispatchQty= item.findElement(By.xpath(".//td[4]"));
            String qty=dispatchQty.getText();

            List<WebElement> qtyInput= driver.findElements(By.xpath("//input[@class='formControl Dispatch__formControl--les6J']"));
            qtyInput.get(i).sendKeys(qty);
        }



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.Dispatch__btn--vR5sf.btn-primary")));
        WebElement addToShipmentBtn= driver.findElement(By.cssSelector("button.Dispatch__btn--vR5sf.btn-primary"));
        wait.until(ExpectedConditions.elementToBeClickable(addToShipmentBtn));
        highlightElement(driver,addToShipmentBtn);
        addToShipmentBtn.click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Dispatch__cartBtn--ABWNt']")));
        WebElement viewAddedItems= driver.findElement(By.xpath("//div[@class='Dispatch__cartBtn--ABWNt']"));
        wait.until(ExpectedConditions.elementToBeClickable(viewAddedItems));
        highlightElement(driver,viewAddedItems);
        viewAddedItems.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.Dispatch__btn--vR5sf.btn-primary")));
        WebElement nextBtn= driver.findElement(By.cssSelector("button.Dispatch__btn--vR5sf.btn-primary"));
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("react-datepicker__input-container")));
        WebElement datePicker= driver.findElements(By.className("react-datepicker__input-container")).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(datePicker));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(By.className("react-datepicker-ignore-onclickoutside"));
        dateInput.sendKeys(date);


        datePicker= driver.findElements(By.className("react-datepicker__input-container")).get(1);
        datePicker.click();

        monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(By.className("react-datepicker-ignore-onclickoutside"));
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement fulfillmentSpoc= driver.findElements(By.xpath("//div[@class=' css-1i8o47w']")).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(fulfillmentSpoc));
        highlightElement(driver,fulfillmentSpoc);
        fulfillmentSpoc.click();

        WebElement fulfillmentSpoc_hint= driver.findElement(By.xpath("//input[@id='fulfillmentSpoc-input-tfid-0-2']"));
        fulfillmentSpoc_hint.sendKeys("Ayush Chaudhary");
        Thread.sleep(4000);
        fulfillmentSpoc_hint.sendKeys(Keys.ENTER);



//        WebElement logisticsMode= driver.findElements(By.xpath("//div[@class=' css-1i8o47w']")).get(1);
//        wait.until(ExpectedConditions.elementToBeClickable(logisticsMode));
//        highlightElement(driver,logisticsMode);
//        logisticsMode.click();
//
//        WebElement logisticMode_hint= driver.findElement(By.xpath("//input[@id='logisticsMode-input-tfid-0-3']"));
//        logisticMode_hint.sendKeys("FTL");
//        Thread.sleep(4000);
//        logisticMode_hint.sendKeys(Keys.ENTER);
//
//        WebElement truckType= driver.findElements(By.xpath("//div[@class=' css-1i8o47w']")).get(2);
//        wait.until(ExpectedConditions.elementToBeClickable(truckType));
//        highlightElement(driver,truckType);
//        truckType.click();
//
//        WebElement truckType_input= driver.findElement(By.xpath("//input[@id='truckType-input-tfid-0-4']"));
//        truckType_input.sendKeys("Trailer");
//        Thread.sleep(4000);
//        truckType_input.sendKeys(Keys.ENTER);


        String mainWindow=driver.getWindowHandle();
        Thread.sleep(3000);


        WebElement createShipmentBtn= driver.findElement(By.xpath("//button[@class='Dispatch__btn--vR5sf btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(createShipmentBtn));
        highlightElement(driver,createShipmentBtn);
        createShipmentBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Go to Shipment']")));
        WebElement goToShipmentBtn= driver.findElement(By.xpath("//button[text()='Go to Shipment']"));
        wait.until(ExpectedConditions.elementToBeClickable(goToShipmentBtn));
        highlightElement(driver,goToShipmentBtn);
        goToShipmentBtn.click();

        //verifyShipment(driver);

    }


    //@Test
    public void verifyShipment() throws InterruptedException, IOException {

        loadPropFile();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stg3-cms.ofbusiness.co.in/#/home/shipment/OFB117172260618249-S-1/summary");
        String mainWindow= driver.getWindowHandle();

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(80));

        //switch to new window
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(mainWindow);
        // change focus to new tab

        //driver.switchTo().window(newTab.get(0));

        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);

        mainWindow= driver.getWindowHandle();
        System.out.println("Done");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-pagination-wrapper")));
        WebElement sections= driver.findElement(By.xpath("//md-pagination-wrapper"));
        wait.until(ExpectedConditions.elementToBeClickable(sections));
        highlightElement(driver,sections);


//        WebElement uploadDocs=sections.findElements(By.xpath(".//md-tab-item")).get(5);
//        wait.until(ExpectedConditions.elementToBeClickable(uploadDocs));
//        highlightElement(driver,uploadDocs);
//        uploadDocs.click();
//
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='anchorBtn ng-scope md-ofb-green-theme']")));
//        WebElement uploadSTIBtn= driver.findElements(By.xpath("//a[@class='anchorBtn ng-scope md-ofb-green-theme']")).get(1);
//        highlightElement(driver,uploadSTIBtn);
//        uploadSTIBtn.click();

        //switch to new window
//        newTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(mainWindow);
//        // change focus to new tab
//
//        driver.switchTo().window(newTab.get(0));
//        mainWindow=driver.getWindowHandle();

//        for(String handle: driver.getWindowHandles())
//            driver.switchTo().window(handle);
//
//        System.out.println("Done");

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Click to Upload Supplier Tax Invoice']")));
//        WebElement btn= driver.findElement(By.xpath("//span[text()='Click to Upload Supplier Tax Invoice']"));
//        wait.until(ExpectedConditions.elementToBeClickable(btn));
//        highlightElement(driver,btn);
//        btn.click();

        // Thread.sleep(8000);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inventoryDocumentUpload']")));
//        WebElement uploadFileBtn= driver.findElement(By.xpath("//input[@id='inventoryDocumentUpload']"));
//        uploadFileBtn.sendKeys("/home/yash/Pictures/Screenshots/screenshot.png");

        /*
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        setCurrDate(driver);

        WebElement inVoiceNumber= driver.findElement(By.xpath("//input[@name='invoiceId']"));
        highlightElement(driver,inVoiceNumber);
        inVoiceNumber.sendKeys(prop.getProperty("invoice-number"));

        WebElement redirectBlock= driver.findElement(By.xpath("//button[@class='redirectBlock']"));
        wait.until(ExpectedConditions.elementToBeClickable(redirectBlock));
        redirectBlock.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='lineItemCard']")));
        List<WebElement> itemList= driver.findElements(By.xpath("//div[@class='lineItemCard']"));
        for(WebElement item:itemList)
        {
            highlightElement(driver,item);
            WebElement quantityRemainingElement= item.findElements(By.xpath(".//span[@class='badgeContainer ']")).get(1);
            highlightElement(driver,quantityRemainingElement);
            String qty= quantityRemainingElement.getText();

            WebElement quantityInput= item.findElement(By.xpath(".//input[@id='tfid-0-1']"));
            highlightElement(driver,quantityInput);
            quantityInput.sendKeys(qty);

            Thread.sleep(2000);

            WebElement radioGroup= item.findElement(By.xpath(".//div[@class='radio-group']"));
            highlightElement(driver,radioGroup);

            WebElement radioBtn= radioGroup.findElement(By.xpath(".//label"));
            radioBtn.click();
        }

        Thread.sleep(2000);
        WebElement selectAllItems= driver.findElement(By.xpath("//label[@class='checkboxLabel']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectAllItems));
        selectAllItems.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement submitBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        System.out.println("Done");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        submitBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();
        */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item")));
        WebElement lspDetails=driver.findElements(By.xpath("//md-tab-item")).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(lspDetails));
        highlightElement(driver,lspDetails);
        lspDetails.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='customButtonFill right md-button ng-scope md-ofb-green-theme md-ink-ripple']")));
        WebElement editBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        highlightElement(driver,editBtn);
        editBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='detailListWrap customAutocomplete customSelectBox']")));
        WebElement inputSection= driver.findElement(By.xpath("//ul[@class='detailListWrap customAutocomplete customSelectBox']"));
        highlightElement(driver,inputSection);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-select[@id='select_15']")));
        WebElement logisticsHandler= driver.findElement(By.xpath("//md-select[@id='select_15']"));
        wait.until(ExpectedConditions.elementToBeClickable(logisticsHandler));
        highlightElement(driver,logisticsHandler);
        logisticsHandler.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select_option_31")));
        WebElement handler_value= driver.findElement(By.id("select_option_31"));
        wait.until(ExpectedConditions.elementToBeClickable(handler_value));
        highlightElement(driver,handler_value);
        handler_value.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-radio-button[@class='ng-scope md-ofb-green-theme flex']")));
        List<WebElement> radioGrps= driver.findElements(By.xpath("//md-radio-button[@class='ng-scope md-ofb-green-theme flex']"));

        WebElement transporterType= radioGrps.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(transporterType));
        transporterType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-radio-button[@value='BUYER']")));
        WebElement ebill_generator= driver.findElement(By.xpath("//md-radio-button[@value='BUYER']"));
        wait.until(ExpectedConditions.elementToBeClickable(ebill_generator));
        ebill_generator.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lspContactPerson']")));
        WebElement contactName= driver.findElement(By.xpath("//input[@name='lspContactPerson']"));
        contactName.sendKeys(prop.getProperty("name"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lspMobile']")));
        WebElement contactNumber =driver.findElement(By.xpath("//input[@name='lspMobile']"));
        contactNumber.sendKeys(prop.getProperty("phone"));


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='md-autocomplete-suggestions autocomplete-account-template']//li[@class='ng-scope']")));
//        WebElement lspNameOption= driver.findElement(By.xpath("//ul[@class='md-autocomplete-suggestions autocomplete-account-template']//li[@class='ng-scope']"));
//        wait.until(ExpectedConditions.elementToBeClickable(lspNameOption));
//        highlightElement(driver,lspNameOption);
//        lspNameOption.click();
//
//        Thread.sleep(2000);
//        WebElement gstOption= subSections.get(2).findElements(By.xpath(".//span")).get(1);
//        wait.until(ExpectedConditions.elementToBeClickable(gstOption));
//        highlightElement(driver,gstOption);
//        gstOption.click();





//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lspAutocomplete']")));
//        WebElement lspName= driver.findElement(By.xpath("//input[@id='lspAutocomplete']"));
//        lspName.sendKeys("a");



//        Thread.sleep(2000);
//        WebElement gstin= driver.findElements(By.xpath("//span[@class='listValue']")).get(3);
//        wait.until(ExpectedConditions.elementToBeClickable(gstin));
//        highlightElement(driver,gstin);
//        gstin.click();
//        gstin.click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@ng-value='gst']")));
//        WebElement gstValue= driver.findElement(By.xpath("//md-option[@ng-value='gst']"));
//        wait.until(ExpectedConditions.elementToBeClickable(gstValue));
//        highlightElement(driver,gstValue);
//        gstValue.click();

//        WebElement lspBilledEntity= driver.findElements(By.xpath("//span[@class='listValue']")).get(6);
//        wait.until(ExpectedConditions.elementToBeClickable(lspBilledEntity));
//        highlightElement(driver,lspBilledEntity);
//        lspBilledEntity.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@id='select_option_91']")));
//        WebElement lspBilledEntity_value= driver.findElement(By.xpath("//md-option[@id='select_option_91']"));
//        wait.until(ExpectedConditions.elementToBeClickable(lspBilledEntity_value));
//        highlightElement(driver,lspBilledEntity_value);
//        lspBilledEntity_value.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']")));
        WebElement saveBtn= driver.findElements(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog[@class='_md md-ofb-green-theme _md-transition-in']//button")));
        WebElement gotItBtn=driver.findElement(By.xpath("//md-dialog[@class='_md md-ofb-green-theme _md-transition-in']//button"));
        wait.until(ExpectedConditions.elementToBeClickable(gotItBtn));
        highlightElement(driver,gotItBtn);
        gotItBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item//span[text()='Tracking']")));
        WebElement trackingBtn= driver.findElement(By.xpath("//md-tab-item//span[text()='Tracking']"));
        wait.until(ExpectedConditions.elementToBeClickable(trackingBtn));
        highlightElement(driver,trackingBtn);
        trackingBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']")));
        WebElement addNewUpdateBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']"));
        highlightElement(driver,addNewUpdateBtn);
        addNewUpdateBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='listValue']")));
        List<WebElement> options= driver.findElements(By.xpath("//span[@class='listValue']"));

        WebElement option1= options.get(0).findElement(By.xpath(".//md-select"));
        option1.click();

        WebElement option1Value= driver.findElement(By.xpath("//md-option[@value='QUALITY_CHECK_SUBMITTED']"));
        option1Value.click();

        WebElement option3= options.get(2).findElement(By.xpath(".//md-select"));
        option3.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@value='false']")));
        WebElement option3Value= driver.findElement(By.xpath("//md-option[@value='false']"));
        wait.until(ExpectedConditions.elementToBeClickable(option3Value));
        highlightElement(driver,option3Value);
        option3Value.click();


        WebElement msgOption= driver.findElement(By.xpath("//input[@name='message']"));
        msgOption.sendKeys(prop.getProperty("test-msg"));

        WebElement calendarOption= driver.findElement(By.xpath("//span[@class='quickdate-button ng-binding']"));
        calendarOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding ng-scope is-today']")));
        WebElement dateValue= driver.findElement(By.xpath("//td[@class='ng-binding ng-scope is-today']"));
        wait.until(ExpectedConditions.elementToBeClickable(dateValue));
        dateValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Submit']")));
        WebElement submitDate= driver.findElement(By.xpath("//a[text()='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitDate));
        highlightElement(driver,submitDate);
        submitDate.click();

        Thread.sleep(1000);
        saveBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right borderRadius15 md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        Thread.sleep(1500);



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item//span[text()='Tracking']")));
        trackingBtn= driver.findElement(By.xpath("//md-tab-item//span[text()='Tracking']"));
        wait.until(ExpectedConditions.elementToBeClickable(trackingBtn));
        highlightElement(driver,trackingBtn);
        trackingBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']")));
        addNewUpdateBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']"));
        highlightElement(driver,addNewUpdateBtn);
        addNewUpdateBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='listValue']")));
        options= driver.findElements(By.xpath("//span[@class='listValue']"));

        option1= options.get(0).findElement(By.xpath(".//md-select"));
        option1.click();

        option1Value= driver.findElement(By.xpath("//md-option[@value='LOADING']"));
        option1Value.click();


        msgOption= driver.findElement(By.xpath("//input[@name='message']"));
        msgOption.sendKeys(prop.getProperty("test-msg"));

        calendarOption= driver.findElement(By.xpath("//span[@class='quickdate-button ng-binding']"));
        calendarOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding ng-scope is-today']")));
        dateValue= driver.findElement(By.xpath("//td[@class='ng-binding ng-scope is-today']"));
        wait.until(ExpectedConditions.elementToBeClickable(dateValue));
        dateValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Submit']")));
        submitDate= driver.findElement(By.xpath("//a[text()='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitDate));
        highlightElement(driver,submitDate);
        submitDate.click();


        option3= options.get(2).findElement(By.xpath(".//md-select"));
        option3.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@value='false']")));
        option3Value= driver.findElement(By.xpath("//md-option[@value='false']"));
        wait.until(ExpectedConditions.elementToBeClickable(option3Value));
        highlightElement(driver,option3Value);
        option3Value.click();

        Thread.sleep(1000);
        saveBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right borderRadius15 md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();









        Thread.sleep(1500);



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item//span[text()='Tracking']")));
        trackingBtn= driver.findElement(By.xpath("//md-tab-item//span[text()='Tracking']"));
        wait.until(ExpectedConditions.elementToBeClickable(trackingBtn));
        highlightElement(driver,trackingBtn);
        trackingBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']")));
        addNewUpdateBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']"));
        highlightElement(driver,addNewUpdateBtn);
        addNewUpdateBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='listValue']")));
        options= driver.findElements(By.xpath("//span[@class='listValue']"));

        option1= options.get(0).findElement(By.xpath(".//md-select"));
        option1.click();

        option1Value= driver.findElement(By.xpath("//md-option[@value='DOCUMENTATION_IN_PROGRESS']"));
        option1Value.click();


        msgOption= driver.findElement(By.xpath("//input[@name='message']"));
        msgOption.sendKeys(prop.getProperty("test-msg"));

        calendarOption= driver.findElement(By.xpath("//span[@class='quickdate-button ng-binding']"));
        calendarOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding ng-scope is-today']")));
        dateValue= driver.findElement(By.xpath("//td[@class='ng-binding ng-scope is-today']"));
        wait.until(ExpectedConditions.elementToBeClickable(dateValue));
        dateValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Submit']")));
        submitDate= driver.findElement(By.xpath("//a[text()='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitDate));
        highlightElement(driver,submitDate);
        submitDate.click();


        option3= options.get(2).findElement(By.xpath(".//md-select"));
        option3.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@value='false']")));
        option3Value= driver.findElement(By.xpath("//md-option[@value='false']"));
        wait.until(ExpectedConditions.elementToBeClickable(option3Value));
        highlightElement(driver,option3Value);
        option3Value.click();

        Thread.sleep(1000);
        saveBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right borderRadius15 md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();




















        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item//span[text()='Invoices']")));
        WebElement invoiceBtn= driver.findElement(By.xpath("//md-tab-item//span[text()='Invoices']"));
        wait.until(ExpectedConditions.elementToBeClickable(invoiceBtn));
        highlightElement(driver,invoiceBtn);
        invoiceBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='customButtonFill md-button md-ofb-green-theme md-ink-ripple']")));
        WebElement invoiceOptions= driver.findElements(By.xpath("//button[@class='customButtonFill md-button md-ofb-green-theme md-ink-ripple']")).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(invoiceOptions));
        invoiceOptions.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-menu-content[@class='customMDMenuContent md-ofb-green-theme']//md-menu-item")));
        WebElement invoiceValue= driver.findElements(By.xpath("//md-menu-content[@class='customMDMenuContent md-ofb-green-theme']//md-menu-item")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(invoiceValue));
        highlightElement(driver,invoiceValue);
        invoiceValue.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='btnsWrap btnSmall clearfix']//button[@class='customButtonFill left md-button md-ofb-green-theme md-ink-ripple']")));
        WebElement generateBtn=driver.findElement(By.xpath("//div[@class='btnsWrap btnSmall clearfix']//button[@class='customButtonFill left md-button md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(generateBtn));
        highlightElement(driver,generateBtn);
        generateBtn.click();


        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement digitalSignBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(digitalSignBtn));
        highlightElement(driver,digitalSignBtn);
        digitalSignBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='checkboxCustom']")));
        WebElement checkBox= driver.findElement(By.xpath("//span[@class='checkboxCustom']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='btn btn-primary']")));
        WebElement digitallySignBtn= driver.findElements(By.xpath("//button[@class='btn btn-primary']")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(digitallySignBtn));
        highlightElement(driver,digitallySignBtn);
        digitallySignBtn.click();

        Thread.sleep(6000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement verifyBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(verifyBtn));
        highlightElement(driver,verifyBtn);
        verifyBtn.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='checkboxCustom']")));
        checkBox= driver.findElement(By.xpath("//span[@class='checkboxCustom']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();


        Thread.sleep(6000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        verifyBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(verifyBtn));
        highlightElement(driver,verifyBtn);
        verifyBtn.click();


        /*wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='responsiveTable']//tbody//td")));
        WebElement invoiceActionButtons= driver.findElements(By.xpath("//div[@class='responsiveTable']//tbody//td")).get(7);
        highlightElement(driver,invoiceActionButtons);

        WebElement openNewWindowBtn= invoiceActionButtons.findElement(By.xpath("//button[@class='md-icon-button md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(openNewWindowBtn));
        openNewWindowBtn.click();*/

        Thread.sleep(8000);






        Thread.sleep(1500);



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item//span[text()='Tracking']")));
        trackingBtn= driver.findElement(By.xpath("//md-tab-item//span[text()='Tracking']"));
        wait.until(ExpectedConditions.elementToBeClickable(trackingBtn));
        highlightElement(driver,trackingBtn);
        trackingBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']")));
        addNewUpdateBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']"));
        highlightElement(driver,addNewUpdateBtn);
        addNewUpdateBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='listValue']")));
        options= driver.findElements(By.xpath("//span[@class='listValue']"));

        option1= options.get(0).findElement(By.xpath(".//md-select"));
        option1.click();

        option1Value= driver.findElement(By.xpath("//md-option[@value='REACHED']"));
        option1Value.click();


        calendarOption= driver.findElement(By.xpath("//span[@class='quickdate-button ng-binding']"));
        calendarOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding ng-scope is-today']")));
        dateValue= driver.findElement(By.xpath("//td[@class='ng-binding ng-scope is-today']"));
        wait.until(ExpectedConditions.elementToBeClickable(dateValue));
        dateValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Submit']")));
        submitDate= driver.findElement(By.xpath("//a[text()='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitDate));
        highlightElement(driver,submitDate);
        submitDate.click();


        option3= options.get(3).findElement(By.xpath(".//md-select"));
        option3.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@value='false']")));
        option3Value= driver.findElement(By.xpath("//md-option[@value='false']"));
        wait.until(ExpectedConditions.elementToBeClickable(option3Value));
        highlightElement(driver,option3Value);
        option3Value.click();

        Thread.sleep(1000);
        saveBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right borderRadius15 md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();





        Thread.sleep(2000);


        Thread.sleep(1500);



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item//span[text()='Tracking']")));
        trackingBtn= driver.findElement(By.xpath("//md-tab-item//span[text()='Tracking']"));
        wait.until(ExpectedConditions.elementToBeClickable(trackingBtn));
        highlightElement(driver,trackingBtn);
        trackingBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']")));
        addNewUpdateBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']"));
        highlightElement(driver,addNewUpdateBtn);
        addNewUpdateBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='listValue']")));
        options= driver.findElements(By.xpath("//span[@class='listValue']"));

        option1= options.get(0).findElement(By.xpath(".//md-select"));
        option1.click();

        option1Value= driver.findElement(By.xpath("//md-option[@value='DELIVERED']"));
        option1Value.click();


        calendarOption= driver.findElement(By.xpath("//span[@class='quickdate-button ng-binding']"));
        calendarOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding ng-scope is-today']")));
        dateValue= driver.findElement(By.xpath("//td[@class='ng-binding ng-scope is-today']"));
        wait.until(ExpectedConditions.elementToBeClickable(dateValue));
        dateValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Submit']")));
        submitDate= driver.findElement(By.xpath("//a[text()='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitDate));
        highlightElement(driver,submitDate);
        submitDate.click();



        Thread.sleep(5000);
        saveBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right borderRadius15 md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();









        //switch to new window
//        ArrayList<String> newTabs = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(mainWindow);
//        // change focus to new tab
//        mainWindow= newTabs.get(0);
//        driver.switchTo().window(newTabs.get(0));

        WebElement publishBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(publishBtn));
        highlightElement(driver,publishBtn);
        publishBtn.click();


    }
}
