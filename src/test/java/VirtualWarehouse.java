import org.openqa.selenium.*;
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
import java.util.Random;



public class VirtualWarehouse {

    public class XpathConstants
    {
        public static final By DRAWER= By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex");
        public static final By DRAWER_OPTIONS= By.xpath("//button[@class='md-raised md-primary side-menu-link md-button ng-scope md-ofb-brown-theme md-ink-ripple']");
        public static final By BULK_ORDER_ENTITY= By.xpath("//ul[@class='drop-down-list ng-scope']//li");
        public static final By ENTITIES= By.xpath("//div[@class='listItemRow']");
        public static final By ACTION_WRAPPER= By.xpath("//div[@class='actionsWrapper']");
        public static final By PO_BTN= By.xpath(".//div[@class='actionItem']");
        public static final By OPTIONS= By.xpath("//div[@class=' css-17vhrl4']");
        public static final By SUPPLIER_NAME_HINT= By.xpath("//input[@id='selectSupplier-input-tfid-0-0']");
        public static final By SUPPLIER_NAME_VALUE= By.xpath("//div[@id='react-select-selectSupplier-option-0']");
        public static final By BILLING_ADDRESS= By.xpath("//div[@class=' css-1m5nn3x']//div");
        public static final By PICKUP_ADDRESS= By.xpath("//div[@class=' css-1ul4jvx-option']");
        public static final By RADIO_GRP= By.xpath("//div[@class='radio-group']");
        public static final By RADIO_VALUE= By.xpath(".//label");
        public static final By ADVANCE= By.xpath("//input[@id='tfid-0-6']");
        public static final By ON_DISPATCH= By.xpath("//input[@id='tfid-0-7']");
        public static final By ON_DELIVERY= By.xpath("//input[@id='tfid-0-8']");
        public static final By CREDIT= By.xpath("//input[@id='tfid-0-9']");
        public static final By SCROLL_TO= By.xpath("//div[text()='Other Configurations']");
        public static final By OFB_ADDRESS= By.xpath("//div[@id='react-select-ofbEntityAddressId-option-0']");
        public static final By ADD_ITEMS= By.xpath("//button[@class='btn btn-primary addContactPersonBtn']");
        public static final By ITEMS_SECTION= By.xpath("//div[@class='baseCatWrapper']");
        public static final By ITEMS= By.xpath("//div[@class='catItem']");
        public static final By ITEM_CART= By.xpath(".//button[@class='btn btn-default']");
        public static final By VARIETY_SECTION= By.xpath("//div[@class='leafCatWrapper']");
        public static final By CART_BTN= By.xpath("//div[@class='cartBtn']");
        public static final By SUBCATEGORY_FORM= By.className("subCategoryForm");
        public static final By QTY_BASERATE= By.xpath(".//input[@class='form-control']");
        public static final By UNITS= By.xpath(".//div[@class='reactSelectContainer']");
        public static final By UNIT_VALUE= By.xpath(".//div[@id='react-select-Unit-option-0']");
        public static final By GST_DROPDOWN= By.xpath(".//div[@class='form-group form-group-depth-1 form-group-GST']//div[@class=' css-2b097c-container']");
        public static final By GST_VAL= By.xpath(".//div[@id='react-select-GST-option-0']");
        public static final By SUBMIT_BTN= By.xpath("//button[@class='btn btn-primary']");
        public static final By VERIFIER= By.xpath("//input[@id='verifierName-input-tfid-0-0']");
        public static final By VERIFIER_NAME= By.xpath("//div[@id='react-select-verifierName-option-0']");
        public static final By SEND_FOR_VERIFICATION_BTN= By.xpath("//button[text()='Send for Verification ']");
        public static final By LOADING_ICON= By.xpath("//span[@class='loading-icon m-r-10']");
        public static final By PO_ELEMENT= By.xpath("//span[@class='backTxt']//span") ;
        public static final By NAV_ITEMS= By.xpath("//ul[@class='nav-list']");
        public static final By SUPPLIER_PO= By.xpath(".//ul[@class='inner-nav-list']//li");
        public static final By SEARCH_FIELD= By.xpath("//input[@class='form-control searchTxtField']") ;
        public static final By REQUESTED_PO= By.xpath("//div[@class='supplierWrapper']");
        public static final By APPROVEBTN= By.xpath(".//button[@class='btn btn-primary approveBtn']");
        public static final By SUBMIT_BTN2= By.xpath("//div[@class='actionWrapper']//button[@class='btn btn-primary']");
        public static final By LOADING= By.xpath("//span[@class='loading-icon m-r-10 hide']");
        public static final By PURCHASE_ORDER= By.xpath(".//ul[@class='inner-nav-list']//li[2]");
        public static final By PO_SEARCH=  By.xpath("//input[@id='tfid-0-0']");
        public static final By LIST_SECTION= By.xpath("//div[@class='cardItemWrapper wareHousePOItemList']");
        public static final By LIST_ITEMS= By.xpath(".//div[@class='listItemRow']");
        public static final By CREATE_BATCH= By.xpath(".//div//span[text()='Create Batch']");
        public static final By TABLE= By.xpath("//table[@class='customTable']//tbody");
        public static final By PRODUCTS= By.xpath(".//tr");
        public static final By GO_TO_BATCH= By.xpath("//div[@class='modalWrapper']//button[@class='btn btn-primary']");
        public static final By UPLOAD_STI= By.xpath("//label[@class='uploadButton undefined']");
        public static final By INVOICE= By.xpath("//input[@id='tfid-0-2']");
        public static final By DATEPICKER= By.className("react-datepicker__input-container");
        public static final By MONTH_YEAR_BTN= By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown");
        public static final By CURRDATE= By.xpath("//div[contains(@class, 'react-datepicker__day--today')]");
        public static final By INVOICE_DATE= By.xpath("//input[@placeholder='Select invoice date']");
        public static final By REDIRECT_BLOCK= By.xpath("//button[@class='redirectBlock']");
        public static final By ITEMLIST= By.xpath("//div[@class='lineItemCard']");
        public static final By CHECKBOX= By.xpath(".//label//input");
        public static final By QTY_REMAINING= By.xpath(".//div[@class='qtyChip'][2]//span[@class='chip-value']");
        public static final By QTY_INPUT= By.xpath(".//input[@name='otherCharges']");
        public static final By RADIO_BTN= By.xpath(".//div[@class='radio-group']");
        public static final By MOVE_TO_WAREHOUSE= By.xpath("//button[@class='btn btn-primary' and contains(text(),'Move Items to Warehouse ')]");
        public static final By ADDRESS_VALUE= By.xpath("//div[@id='react-select-ofbEntityAddress-option-0']");
        public static final By FULFILLMENT_SPOC= By.xpath("//input[@id='ofbFulfillmentSpoc-input-tfid-0-2']");
        public static final By FULFILLMENT_SPOC_VALUE= By.xpath("//div[@id='react-select-ofbFulfillmentSpoc-option-0']");
        public static final By VEHICLE= By.xpath("//input[@id='tfid-0-3']");
        public static final By COMPLETE_DELIVERY_IN= By.xpath("//span[@class='value txt-blue']");
        public static final By LSPNAME_HINT= By.xpath("//input[@id='selectLsp-input-tfid-0-1']");
        public static final By LSPNAME_VALUE= By.xpath("//div[@id='react-select-selectLsp-option-0']");
        public static final By GST_VALUE= By.xpath("//div[@id='react-select-lspGst-option-0']");
        public static final By OFB_ENTITY= By.xpath("//input[@id='ofbEntity-input-tfid-0-14']");
        public static final By OFB_ENTITY_VALUE= By.xpath("//div[@id='react-select-ofbEntity-option-0']");
        public static final By PRICE_PER_UNIT= By.xpath("//input[@id='tfid-0-1']");
        public static final By DATE_INPUT= By.xpath("//input[@placeholder='Select Date']");
        public static final By WAREHOUSE_SPOC_HINT= By.xpath("//input[@id='ofbWarehouseSpoc-input-tfid-0-1']");
        public static final By WAREHOUSE_SPOC_VALUE= By.xpath("//div[@id='react-select-ofbWarehouseSpoc-option-0']");
        public static final By TRACKING_SECTION= By.xpath("//div[@class='shipmentStatusJourney']");
        public static final By NEW_STATUS= By.xpath("//div[@id='react-select-shipmentStatus-option-0']");
        public static final By UPLOAD_DOC= By.xpath("//span[@class='documentUploadBtn']");
        public static final By FORM= By.xpath("//div[@class='formItems']");
        public static final By FORM_DROPDOWN= By.xpath(".//div[@class=' css-1i8o47w']");
        public static final By ISSUINGPARTY_VALUE= By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-1']");
        public static final By RECEIVINGPARTY_VALUE= By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-0']");
        public static final By UPDATE_STATUS= By.xpath("//button[text()='Update Status']");
        public static final By AGREEMENT_CHECKBOX= By.xpath("//input[@id='agreementCheckbox']");
        public static final By SHIPMENT_AMT= By.xpath("//div[@class='amt']");
        public static final By CAPTCHA= By.xpath("//input[@class='inputCaptcha']");
        public static final By LOT_CONTAINER= By.xpath("//div[@class='lotDetailContainer']");
        public static final By ISSUINGPARTY= By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-0']");
        public static final By RECEIVING_PARTY= By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-1']");
        public static final By ACTION_ITEM= By.xpath("//div[@class='actionItem']");
        public static final By SHARE_BTN= By.xpath("//button[text()='Share with 1 person(s)']");
        public static final By SAVE_BTN= By.xpath("//button[text()='Save']");
        public static final By LOADINGICON= By.xpath("//div[@class='modalFooter']//span[@class='loading-icon m-r-10 hide']");
        public static final By NEXT_BTN= By.xpath("//button[@class='btn btn-primary' and contains(text(),'Next')]");
        public static final By SHAREGRN= By.xpath("//button[text()='Share GRN']");
        public static final By DATEINPUT= By.xpath("//input[@placeholder='Start Date']");
        public static final By MULTIPLE_USED_XPATH= By.xpath("//div[@class=' css-1i8o47w']");
        public static final By PERSON_HINT= By.xpath("//input[@id='assignedTo-input-tfid-0-0']");
        public static final By PERSON_VALUE= By.xpath("//div[@id='react-select-assignedTo-option-0']");
    }
    static String mainWindow;
    WebDriver driver;
    static Properties prop;
    static String poNumber;

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

    public static void setCurrDate(WebDriver driver)
    {

        WebElement datePicker= driver.findElement(XpathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XpathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XpathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XpathConstants.DATEINPUT);
        dateInput.sendKeys(date);
    }


    public static int generateInvoiceNumber()
    {
        Random random = new Random();

        // Generate a random number between 100000 (inclusive) and 1000000 (exclusive)
        int randomNumber = 100000 + random.nextInt(900000);
        return randomNumber;
    }

    @Test(testName = "set up")
    public void setUp() throws IOException {
        loadPropFile();
        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile5");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("stg5-cms-url"));
        mainWindow = driver.getWindowHandle();
    }

//    @Test(dependsOnMethods = "setUp")
//    public void loginTest() throws InterruptedException {
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));
//
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("iframe")));
//        WebElement frame = driver.findElements(By.tagName("iframe")).get(0); // Change the index as per your requirement
//        frame.click();
//        driver.switchTo().frame(frame);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("container")));
//        WebElement signIn = driver.findElement(By.id("container"));
//        signIn.click();
//
//        Thread.sleep(2000);
//        for (String winHandle : driver.getWindowHandles())
//            driver.switchTo().window(winHandle);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
//        WebElement emailInput = driver.findElement(By.id("identifierId"));
//        emailInput.sendKeys(prop.getProperty("email"));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierNext")));
//        WebElement nextBtn = driver.findElement(By.id("identifierNext"));
//        nextBtn.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
//        WebElement passwordInput = driver.findElement(By.name("Passwd"));
//        passwordInput.sendKeys(prop.getProperty("psvd"));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordNext")));
//        WebElement passNextBtn = driver.findElement(By.id("passwordNext"));
//        passNextBtn.click();
//    }

    @Test(dependsOnMethods = "setUp")
    public void handleBulkOrder() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(80));
        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.DRAWER));

        WebElement drawer= driver.findElement(XpathConstants.DRAWER);
        highlightElement(driver,drawer);

        List<WebElement> options= driver.findElements(XpathConstants.DRAWER_OPTIONS);
        WebElement bulkOrderSection= options.get(3);
        wait.until(ExpectedConditions.elementToBeClickable(bulkOrderSection));
        highlightElement(driver,bulkOrderSection);
        bulkOrderSection.click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.BULK_ORDER_ENTITY));
        WebElement bulkOrderEntity= driver.findElement(XpathConstants.BULK_ORDER_ENTITY);
        wait.until(ExpectedConditions.elementToBeClickable(bulkOrderEntity));
        highlightElement(driver,bulkOrderEntity);
        bulkOrderEntity.click();


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.ENTITIES));
        List<WebElement> entities= driver.findElements(XpathConstants.ENTITIES);

        WebElement entity= entities.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(entity));
        highlightElement(driver,entity);
        entity.click();
    }

    @Test(dependsOnMethods = "handleBulkOrder")
    public void issuePO() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ACTION_WRAPPER));
        WebElement issuePoSection= driver.findElement(XpathConstants.ACTION_WRAPPER);
        wait.until(ExpectedConditions.elementToBeClickable(issuePoSection));
        highlightElement(driver,issuePoSection);

        WebElement issuePoBtn= issuePoSection.findElement(XpathConstants.PO_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(issuePoBtn));
        highlightElement(driver,issuePoBtn);
        issuePoBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.OPTIONS));
        WebElement supplierName= driver.findElement(XpathConstants.OPTIONS);
        wait.until(ExpectedConditions.elementToBeClickable(supplierName));
        highlightElement(driver,supplierName);
        supplierName.click();

        WebElement supplierName_hint= driver.findElement(XpathConstants.SUPPLIER_NAME_HINT);
        supplierName_hint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUPPLIER_NAME_VALUE));
        WebElement supplierValue= driver.findElement(XpathConstants.SUPPLIER_NAME_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(supplierValue));
        highlightElement(driver,supplierValue);
        supplierValue.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.OPTIONS));
        List<WebElement> supplierOptions= driver.findElements(XpathConstants.OPTIONS);

        WebElement billingAddress= supplierOptions.get(1);
        highlightElement(driver,billingAddress);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.BILLING_ADDRESS));
        WebElement billingAddressValue= driver.findElement(XpathConstants.BILLING_ADDRESS);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        WebElement pickupAddress= supplierOptions.get(2);
        highlightElement(driver,pickupAddress);
        pickupAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.PICKUP_ADDRESS));
        WebElement pickupAddressValue= driver.findElement(XpathConstants.PICKUP_ADDRESS);
        highlightElement(driver,pickupAddressValue);
        pickupAddressValue.click();

        List<WebElement> radioGroups= driver.findElements(XpathConstants.RADIO_GRP);

        WebElement radiogroup= radioGroups.get(2);
        highlightElement(driver,radiogroup);

        WebElement radioGrpValue= radiogroup.findElement(XpathConstants.RADIO_VALUE);
        radioGrpValue.click();

//        WebElement incentiveReason= driver.findElement(By.id("reason-tfid-0-0"));
//        wait.until(ExpectedConditions.visibilityOf(incentiveReason));
//        highlightElement(driver,incentiveReason);
//        incentiveReason.click();
//
//        WebElement incentiveReasonValue= driver.findElement(By.id("react-select-reason-option-0"));
//        wait.until(ExpectedConditions.elementToBeClickable(incentiveReasonValue));
//        highlightElement(driver,incentiveReasonValue);
//        incentiveReasonValue.click();

//        driver.findElement(By.xpath("//span[text()='Incoming']")).click();
//
//        driver.findElement(By.xpath("//span[text()='Without Tax']")).click();
//
//        WebElement incentiveLevel= driver.findElements(By.xpath("//span[text()='Item Level']")).get(1);
//        incentiveLevel.click();

        WebElement addItemsBtn= driver.findElement(XpathConstants.ADD_ITEMS);
        wait.until(ExpectedConditions.elementToBeClickable(addItemsBtn));
        highlightElement(driver,addItemsBtn);
        addItemsBtn.click();
    }

    @Test(dependsOnMethods = "issuePO")
    public void addItems() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ITEMS_SECTION));
        WebElement itemsSection= driver.findElement(XpathConstants.ITEMS_SECTION);
        List<WebElement> items= driver.findElements(XpathConstants.ITEMS);
        highlightElement(driver,items.get(2));

        WebElement item1= items.get(2).findElement(XpathConstants.ITEM_CART);
        wait.until(ExpectedConditions.elementToBeClickable(item1));
        highlightElement(driver,item1);
        item1.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.VARIETY_SECTION));
        WebElement varietySection= driver.findElement(XpathConstants.VARIETY_SECTION);
        highlightElement(driver,varietySection);

        List<WebElement> varieties= driver.findElements(XpathConstants.ITEMS);
        for(int i=1;i<=2;i++)
        {
            WebElement variety1= varieties.get(i);
            highlightElement(driver,variety1);
            WebElement addToCartBtn= variety1.findElement(XpathConstants.ITEM_CART);
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
            highlightElement(driver,addToCartBtn);
            addToCartBtn.click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.CART_BTN));
        WebElement cartBtn= driver.findElement(XpathConstants.CART_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
        highlightElement(driver,cartBtn);
        cartBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.SUBCATEGORY_FORM));

        List<WebElement> subcategoryForms= driver.findElements(XpathConstants.SUBCATEGORY_FORM);

        Thread.sleep(4000);
        for(WebElement subcategoryForm:subcategoryForms)
        {
            WebElement itemQty= subcategoryForm.findElements(XpathConstants.QTY_BASERATE).get(0);
            itemQty.clear();
            itemQty.sendKeys("100");

            WebElement units= subcategoryForm.findElements(XpathConstants.UNITS).get(0);
            highlightElement(driver,units);
            units.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.UNIT_VALUE));
            WebElement unitValue= subcategoryForm.findElement(XpathConstants.UNIT_VALUE);
            wait.until(ExpectedConditions.elementToBeClickable(unitValue));
            highlightElement(driver,unitValue);
            unitValue.click();

            WebElement baserate= subcategoryForm.findElements(XpathConstants.QTY_BASERATE).get(1);
            baserate.sendKeys("100");

            WebElement gstDropDown= subcategoryForm.findElement(XpathConstants.GST_DROPDOWN);
            highlightElement(driver,gstDropDown);
            gstDropDown.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.GST_VAL));
            WebElement gstValue= subcategoryForm.findElement(XpathConstants.GST_VAL);
            wait.until(ExpectedConditions.elementToBeClickable(gstValue));
            highlightElement(driver,gstValue);
            gstValue.click();

//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Gross Value']")));
//            WebElement grossValueElement= subcategoryForm.findElement(By.xpath(".//input[@name='Gross Value']"));

//            int grossValue= Integer.parseInt(grossValueElement.getAttribute("value"));
//            int totalVal= Integer.parseInt(baserate.getText())*Integer.parseInt(itemQty.getAttribute("value"));
//            int actualGrossValue= totalVal+ totalVal*(Integer.parseInt(gstValue.getAttribute("value").substring(0,gstValue.getAttribute("value").length()-1)));
//            System.out.println("GrossValue element text "+ grossValue);
//            System.out.println("Actual Computed "+ actualGrossValue);
//            Assert.assertEquals(grossValue,actualGrossValue);

        }

        Thread.sleep(3000);
        WebElement submitBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SCROLL_TO));
        WebElement scrollToElement = driver.findElement(XpathConstants.SCROLL_TO);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToElement);

        WebElement advanceAmount= driver.findElement(XpathConstants.ADVANCE);
        advanceAmount.sendKeys("100");

        WebElement onDispatchAmount= driver.findElement(XpathConstants.ON_DISPATCH);
        onDispatchAmount.sendKeys("0");

        WebElement onDelivery= driver.findElement(XpathConstants.ON_DELIVERY);
        onDelivery.sendKeys("0");

        WebElement credit= driver.findElement(XpathConstants.CREDIT);
        credit.sendKeys("0");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToElement);



        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_XPATH));
        WebElement ofbEntityAddress= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntityAddress));
        highlightElement(driver,ofbEntityAddress);
        ofbEntityAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.OFB_ADDRESS));
        WebElement ofbAddressvalue= driver.findElement(XpathConstants.OFB_ADDRESS);
        wait.until(ExpectedConditions.elementToBeClickable(ofbAddressvalue));
        highlightElement(driver,ofbAddressvalue);
        ofbAddressvalue.click();

        Thread.sleep(2000);
        setCurrDate(driver);


        Thread.sleep(3000);
        submitBtn= driver.findElements(XpathConstants.SUBMIT_BTN).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_XPATH));
        WebElement verifierOption= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(verifierOption));
        highlightElement(driver,verifierOption);
        verifierOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.VERIFIER));
        WebElement verifier_hint= driver.findElement(XpathConstants.VERIFIER);
        verifier_hint.sendKeys("Anshul Jain");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.VERIFIER_NAME));
        WebElement verifier_name= driver.findElement(XpathConstants.VERIFIER_NAME);
        wait.until(ExpectedConditions.elementToBeClickable(verifier_name));
        highlightElement(driver,verifier_name);
        verifier_name.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.SEND_FOR_VERIFICATION_BTN));
        WebElement sendForVerificationBtn= driver.findElement(XpathConstants.SEND_FOR_VERIFICATION_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(sendForVerificationBtn));
        highlightElement(driver,sendForVerificationBtn);
        sendForVerificationBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING_ICON));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.PO_ELEMENT));
        WebElement poNumberElement= driver.findElement(XpathConstants.PO_ELEMENT);
        poNumber= poNumberElement.getText();

    }

    @Test(dependsOnMethods = "addItems")
    public void verifyPO() throws IOException, InterruptedException {
        addCookie(driver,prop.getProperty("supplier-auth-token"));

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.NAV_ITEMS));
        WebElement verifySection= driver.findElements(XpathConstants.NAV_ITEMS).get(8);
        highlightElement(driver,verifySection);
        verifySection.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.SUPPLIER_PO));
        WebElement supplierPOBtn= verifySection.findElement(XpathConstants.SUPPLIER_PO);
        wait.until(ExpectedConditions.elementToBeClickable(supplierPOBtn));
        highlightElement(driver,supplierPOBtn);
        supplierPOBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SEARCH_FIELD));
        WebElement searchField= driver.findElement(XpathConstants.SEARCH_FIELD);
        searchField.sendKeys(poNumber);

        Thread.sleep(3000);
        searchField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.REQUESTED_PO));
        WebElement requestedPO= driver.findElement(XpathConstants.REQUESTED_PO);
        highlightElement(driver,requestedPO);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.APPROVEBTN));
        WebElement approveBtn= requestedPO.findElement(XpathConstants.APPROVEBTN);
        wait.until(ExpectedConditions.elementToBeClickable(approveBtn));
        highlightElement(driver,approveBtn);
        approveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_BTN2));
        WebElement submitBtn= driver.findElement(XpathConstants.SUBMIT_BTN2);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));

        Thread.sleep(2000);

        addCookie(driver, prop.getProperty("my-auth-token"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='supplierWrapper']")));
//        List<WebElement> supplierList= driver.findElements(By.xpath("//div[@class='supplierWrapper']"));
//        for(WebElement supplier:supplierList)
//        {
//            highlightElement(driver,supplier);
//            Thread.sleep(1000);
//            WebElement requestor= supplier.findElement(By.xpath(".//span[3]"));
//            highlightElement(driver,requestor);
//            Thread.sleep(1000);
//            String text= requestor.getText();
//            System.out.println("Requestor is "+ text);
//            if(text.equalsIgnoreCase("Requestor: Yash Garg"))
//            {
//                Thread.sleep(1000);
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='btn btn-primary approveBtn']")));
//                WebElement approveBtn = supplier.findElement(By.xpath(".//button[@class='btn btn-primary approveBtn']"));
//                wait.until(ExpectedConditions.elementToBeClickable(approveBtn));
//                highlightElement(driver,approveBtn);
//                approveBtn.click();
//                System.out.println("This is the one");
//                break;
//            }
//        }
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
//        WebElement submitBtn= driver.findElement(By.xpath("//button[text()='Submit']"));
//        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
//        highlightElement(driver,submitBtn);
//        submitBtn.click();
    }


    @Test(dependsOnMethods = "verifyPO")
    public void createBatch() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.NAV_ITEMS));
        List<WebElement> sidemenu= driver.findElements(XpathConstants.NAV_ITEMS);

        WebElement bulkOrder= sidemenu.get(3);
        wait.until(ExpectedConditions.elementToBeClickable(bulkOrder));
        highlightElement(driver,bulkOrder);
        bulkOrder.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.PURCHASE_ORDER));
        WebElement purchaseOrders= bulkOrder.findElement(XpathConstants.PURCHASE_ORDER);
        wait.until(ExpectedConditions.elementToBeClickable(purchaseOrders));
        highlightElement(driver,purchaseOrders);
        purchaseOrders.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.PO_SEARCH));
        WebElement searchByPO= driver.findElement(XpathConstants.PO_SEARCH);
        searchByPO.sendKeys(poNumber);

        Thread.sleep(2000);
        searchByPO.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.LIST_SECTION));
        WebElement listSection= driver.findElement(XpathConstants.LIST_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(listSection));
        highlightElement(driver,listSection);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.LIST_ITEMS));
        List<WebElement> items= listSection.findElements(XpathConstants.LIST_ITEMS);
        highlightElement(driver,items.get(0));
        items.get(0).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ACTION_WRAPPER));
        WebElement actionWrapper= driver.findElement(XpathConstants.ACTION_WRAPPER);
        highlightElement(driver,actionWrapper);

        //List<WebElement> actionButtons= actionWrapper.findElements(By.xpath(".//div[@class='actionItem']"));
        WebElement createBatch= actionWrapper.findElement(XpathConstants.CREATE_BATCH);
        wait.until(ExpectedConditions.elementToBeClickable(createBatch));
        highlightElement(driver,createBatch);
        createBatch.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.TABLE));
        WebElement table= driver.findElement(XpathConstants.TABLE);
        highlightElement(driver,table);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.PRODUCTS));
        List<WebElement> products= table.findElements(XpathConstants.PRODUCTS);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='customTable']//thead//th//label//input")));
//        WebElement selectAllItems= driver.findElement(By.xpath("//table[@class='customTable']//thead//th//label//input"));
//        wait.until(ExpectedConditions.elementToBeClickable(selectAllItems));
//        //selectAllItems.click();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectAllItems);

        Thread.sleep(2000);

        for(WebElement product:products)
        {
            List<WebElement> productOptions= product.findElements(By.xpath(".//td"));
            highlightElement(driver,productOptions.get(0));
            WebElement checkBox= productOptions.get(0).findElement(XpathConstants.CHECKBOX);
            //checkBox.click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);


            String pendingQty= productOptions.get(2).getText();

            WebElement qty_input= productOptions.get(4).findElement(By.xpath(".//input[@id='indSelect-batchLineItems']"));
            qty_input.sendKeys(pendingQty);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_BTN));
        WebElement addToBatchButton= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addToBatchButton));
        highlightElement(driver,addToBatchButton);
        addToBatchButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.CART_BTN));
        WebElement viewAddedItems= driver.findElement(XpathConstants.CART_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(viewAddedItems));
        highlightElement(driver,viewAddedItems);
        viewAddedItems.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_BTN));
        WebElement createBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.GO_TO_BATCH));
        WebElement goToBatch= driver.findElement(XpathConstants.GO_TO_BATCH);
        wait.until(ExpectedConditions.elementToBeClickable(goToBatch));
        highlightElement(driver,goToBatch);
        goToBatch.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.UPLOAD_STI));
        WebElement uploadSti= driver.findElement(XpathConstants.UPLOAD_STI);

        WebElement uploadStiFile= uploadSti.findElement(By.xpath(".//input"));
        uploadStiFile.sendKeys(prop.getProperty("file-path"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.INVOICE));
        WebElement invoiceInput= driver.findElement(XpathConstants.INVOICE);
        invoiceInput.sendKeys(String.valueOf(generateInvoiceNumber()));

        WebElement datePicker= driver.findElement(XpathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XpathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XpathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XpathConstants.INVOICE_DATE);
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.REDIRECT_BLOCK));
        WebElement redirectBlock= driver.findElement(XpathConstants.REDIRECT_BLOCK);
        wait.until(ExpectedConditions.elementToBeClickable(redirectBlock));
        highlightElement(driver,redirectBlock);
        redirectBlock.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.ITEMLIST));
        List<WebElement> itemList= driver.findElements(XpathConstants.ITEMLIST);
        for(WebElement item:itemList)
        {
            highlightElement(driver,item);

            WebElement checkBox= item.findElement(XpathConstants.CHECKBOX);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);

            WebElement quantityRemainingElement= item.findElement(XpathConstants.QTY_REMAINING);
            highlightElement(driver,quantityRemainingElement);
            String qty= quantityRemainingElement.getText();

            WebElement quantityInput= item.findElement(XpathConstants.QTY_INPUT);
            highlightElement(driver,quantityInput);
            quantityInput.sendKeys(qty);

            Thread.sleep(2000);

            WebElement radioGroup= item.findElement(XpathConstants.RADIO_BTN);
            highlightElement(driver,radioGroup);

            WebElement radioBtn= radioGroup.findElement(By.xpath(".//label"));
            radioBtn.click();
        }



        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_BTN));
        WebElement doneBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
        highlightElement(driver, doneBtn);
        doneBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));
        Thread.sleep(1500);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_BTN));
        WebElement nextBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MOVE_TO_WAREHOUSE));
        WebElement moveItemsToWarehouse= driver.findElement(XpathConstants.MOVE_TO_WAREHOUSE);
        wait.until(ExpectedConditions.elementToBeClickable(moveItemsToWarehouse));
        highlightElement(driver,moveItemsToWarehouse);
        moveItemsToWarehouse.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_XPATH));
        WebElement ofbEntityAddress= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntityAddress));
        highlightElement(driver,ofbEntityAddress);
        ofbEntityAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ADDRESS_VALUE));
        WebElement addressValue= driver.findElement(XpathConstants.ADDRESS_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(addressValue));
        highlightElement(driver,addressValue);
        addressValue.click();

        WebElement fulfillmentSpoc= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(fulfillmentSpoc));
        highlightElement(driver,fulfillmentSpoc);
        fulfillmentSpoc.click();

        WebElement fulfillmentSpoc_hint= driver.findElement(XpathConstants.FULFILLMENT_SPOC);
        fulfillmentSpoc_hint.sendKeys("Ayush Chaudhary");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.FULFILLMENT_SPOC_VALUE));
        WebElement fulfillmentSpoc_value= driver.findElement(XpathConstants.FULFILLMENT_SPOC_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(fulfillmentSpoc_value));
        fulfillmentSpoc_value.click();

        WebElement vehicleNumber= driver.findElement(XpathConstants.VEHICLE);
        vehicleNumber.sendKeys(prop.getProperty("test-vehicle"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_BTN));
        nextBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_BTN));
        WebElement submitBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.COMPLETE_DELIVERY_IN));
        WebElement completeDeliveryIn= driver.findElement(XpathConstants.COMPLETE_DELIVERY_IN);
        wait.until(ExpectedConditions.elementToBeClickable(completeDeliveryIn));
        highlightElement(driver,completeDeliveryIn);
        completeDeliveryIn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_BTN));
        doneBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
        doneBtn.click();

        for(String handle: driver.getWindowHandles())
                driver.switchTo().window(handle);

    }

    @Test(dependsOnMethods = "createBatch")
    public void createDeliveryIn()
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_BTN));
        WebElement nextBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_XPATH));
        WebElement lspName= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(lspName));
        highlightElement(driver,lspName);
        lspName.click();

        WebElement lspName_hint= driver.findElement(XpathConstants.LSPNAME_HINT);
        lspName_hint.sendKeys("l");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.LSPNAME_VALUE));
        WebElement lspName_value= driver.findElement(XpathConstants.LSPNAME_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(lspName_value));
        highlightElement(driver,lspName_value);
        lspName_value.click();


        WebElement gstIN= driver.findElements(XpathConstants.OPTIONS).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(gstIN));
        highlightElement(driver,gstIN);
        gstIN.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.GST_VALUE));
        WebElement gstValue= driver.findElement(XpathConstants.GST_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(gstValue));
        highlightElement(driver,gstValue);
        gstValue.click();

        WebElement ofbEntity= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntity));
        highlightElement(driver,ofbEntity);
        ofbEntity.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.OFB_ENTITY));
        WebElement entity_hint= driver.findElement(XpathConstants.OFB_ENTITY);
        entity_hint.sendKeys("TK");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.OFB_ENTITY_VALUE));
        WebElement ofbEntity_value= driver.findElement(XpathConstants.OFB_ENTITY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntity_value));
        highlightElement(driver,ofbEntity_value);
        ofbEntity_value.click();

        nextBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.PRICE_PER_UNIT));
        WebElement pricePerUnit= driver.findElement(XpathConstants.PRICE_PER_UNIT);
        pricePerUnit.sendKeys("100");

        nextBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.DATEPICKER));
        WebElement datePicker= driver.findElement(XpathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XpathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XpathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XpathConstants.DATE_INPUT);
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_XPATH));
        WebElement warehouseSpoc= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(warehouseSpoc));
        highlightElement(driver,warehouseSpoc);
        warehouseSpoc.click();

        WebElement warehouseSpoc_hint= driver.findElement(XpathConstants.WAREHOUSE_SPOC_HINT);
        warehouseSpoc_hint.sendKeys("anas A");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.WAREHOUSE_SPOC_VALUE));
        WebElement warehouseSpoc_value= driver.findElement(XpathConstants.WAREHOUSE_SPOC_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(warehouseSpoc_value));
        highlightElement(driver,warehouseSpoc_value);
        warehouseSpoc_value.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_BTN));
        WebElement createDeliveryInBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createDeliveryInBtn));
        highlightElement(driver,createDeliveryInBtn);
        createDeliveryInBtn.click();

    }


    @Test(dependsOnMethods = "createDeliveryIn")
    public void updateTrackingDetails() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.TRACKING_SECTION));
        WebElement trackingSecion= driver.findElement(XpathConstants.TRACKING_SECTION);
        highlightElement(driver,trackingSecion);

        WebElement updateStatusBtn= trackingSecion.findElement(By.xpath(".//span"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_XPATH));
        WebElement newStatus= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(newStatus));
        highlightElement(driver,newStatus);
        newStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.NEW_STATUS));
        WebElement newStatusValue= driver.findElement(XpathConstants.NEW_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(newStatusValue));
        highlightElement(driver,newStatusValue);
        newStatusValue.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.DATEPICKER));
        WebElement datePicker= driver.findElement(XpathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XpathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XpathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XpathConstants.DATE_INPUT);
        dateInput.sendKeys(date);

        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.UPLOAD_DOC));
        WebElement uploadDoc= driver.findElement(XpathConstants.UPLOAD_DOC);
        wait.until(ExpectedConditions.elementToBeClickable(uploadDoc));
        highlightElement(driver,uploadDoc);

        WebElement uploadDocInput= uploadDoc.findElement(By.xpath(".//input"));
        uploadDocInput.sendKeys(prop.getProperty("file-path"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.FORM));
        WebElement form= driver.findElement(XpathConstants.FORM);
        highlightElement(driver,form);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.FORM_DROPDOWN));
        List<WebElement> formDropdownOptions=  form.findElements(XpathConstants.FORM_DROPDOWN);


        WebElement issuingPartyDropdown= formDropdownOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyDropdown));
        highlightElement(driver,issuingPartyDropdown);
        issuingPartyDropdown.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ISSUINGPARTY_VALUE));
        WebElement issuingPartyValue= form.findElement(XpathConstants.ISSUINGPARTY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyValue));
        highlightElement(driver,issuingPartyValue);
        issuingPartyValue.click();

        WebElement receivingParty= formDropdownOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.RECEIVINGPARTY_VALUE));
        WebElement receivingPartyValue= form.findElement(XpathConstants.RECEIVINGPARTY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(receivingPartyValue));
        highlightElement(driver,receivingPartyValue);
        receivingPartyValue.click();

        WebElement saveBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();


        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.UPDATE_STATUS));
        WebElement updateBtn= driver.findElement(XpathConstants.UPDATE_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.TRACKING_SECTION));
        trackingSecion= driver.findElement(XpathConstants.TRACKING_SECTION);
        highlightElement(driver,trackingSecion);

        updateStatusBtn= trackingSecion.findElement(By.xpath(".//span"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.DATEPICKER));
        datePicker= driver.findElement(XpathConstants.DATEPICKER);
        datePicker.click();

        monthYearBtn= driver.findElement(XpathConstants.MONTH_YEAR_BTN);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XpathConstants.CURRDATE);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XpathConstants.DATE_INPUT);
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_XPATH));
        newStatus= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(newStatus));
        highlightElement(driver,newStatus);
        newStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.NEW_STATUS));
        newStatusValue= driver.findElement(XpathConstants.NEW_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(newStatusValue));
        highlightElement(driver,newStatusValue);
        newStatusValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.UPDATE_STATUS));
        updateBtn= driver.findElement(XpathConstants.UPDATE_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.TRACKING_SECTION));
        trackingSecion= driver.findElement(XpathConstants.TRACKING_SECTION);
        highlightElement(driver,trackingSecion);

        updateStatusBtn= trackingSecion.findElement(By.xpath(".//span"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();

        Thread.sleep(3000);
        dateInput= driver.findElement(XpathConstants.DATE_INPUT);
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_XPATH));
        newStatus= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(newStatus));
        highlightElement(driver,newStatus);
        newStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.NEW_STATUS));
        newStatusValue= driver.findElement(XpathConstants.NEW_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(newStatusValue));
        highlightElement(driver,newStatusValue);
        newStatusValue.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.UPDATE_STATUS));
        updateBtn= driver.findElement(XpathConstants.UPDATE_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.ACTION_ITEM));
        WebElement markDeliveredBtn= driver.findElements(XpathConstants.ACTION_ITEM).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(markDeliveredBtn));
        highlightElement(driver,markDeliveredBtn);
        markDeliveredBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.AGREEMENT_CHECKBOX));
        WebElement checkBox= driver.findElement(XpathConstants.AGREEMENT_CHECKBOX);
        checkBox.click();

        String shipmentAmt= driver.findElement(XpathConstants.SHIPMENT_AMT).getText();

        WebElement captchaInput= driver.findElement(XpathConstants.CAPTCHA);
        captchaInput.sendKeys(shipmentAmt);

        WebElement submitBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();




        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.LOT_CONTAINER));
        List<WebElement> itemsList= driver.findElements(XpathConstants.LOT_CONTAINER);

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.UPLOAD_DOC));
        WebElement uploadSlip= driver.findElement(XpathConstants.UPLOAD_DOC);
        highlightElement(driver,uploadSlip);
        //uploadSlip.click();

        WebElement uploadSlipInput= uploadSlip.findElement(By.xpath(".//input"));
        uploadSlipInput.sendKeys(prop.getProperty("file-path"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.FORM));
        form= driver.findElement(XpathConstants.FORM);
        highlightElement(driver,form);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.MULTIPLE_USED_XPATH));
        formDropdownOptions=  form.findElements(XpathConstants.MULTIPLE_USED_XPATH);


        issuingPartyDropdown= formDropdownOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyDropdown));
        highlightElement(driver,issuingPartyDropdown);
        issuingPartyDropdown.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ISSUINGPARTY));
        issuingPartyValue= form.findElement(XpathConstants.ISSUINGPARTY);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyValue));
        highlightElement(driver,issuingPartyValue);
        issuingPartyValue.click();

        receivingParty= formDropdownOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-1']")));
        receivingPartyValue= form.findElement(XpathConstants.RECEIVING_PARTY);
        wait.until(ExpectedConditions.elementToBeClickable(receivingPartyValue));
        highlightElement(driver,receivingPartyValue);
        receivingPartyValue.click();

        saveBtn= driver.findElement(XpathConstants.SAVE_BTN);
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADINGICON));

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.NEXT_BTN));
        saveBtn=driver.findElement(XpathConstants.NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.DATEPICKER));
        datePicker= driver.findElement(XpathConstants.DATEPICKER);
        datePicker.click();

        monthYearBtn= driver.findElement(XpathConstants.MONTH_YEAR_BTN);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XpathConstants.CURRDATE);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XpathConstants.DATE_INPUT);
        dateInput.sendKeys(date);


        saveBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SHAREGRN));
        WebElement shareGRNBtn= driver.findElement(XpathConstants.SHAREGRN);
        wait.until(ExpectedConditions.elementToBeClickable(shareGRNBtn));
        highlightElement(driver,shareGRNBtn);
        shareGRNBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_XPATH));
        WebElement person_dropdown= driver.findElement(XpathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(person_dropdown));
        highlightElement(driver,person_dropdown);
        person_dropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.PERSON_HINT));
        WebElement personName_hint= driver.findElement(XpathConstants.PERSON_HINT);
        personName_hint.sendKeys("a");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.PERSON_VALUE));
        WebElement person_value= driver.findElement(XpathConstants.PERSON_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(person_value));
        highlightElement(driver,person_value);
        person_value.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SHARE_BTN));
        WebElement shareBtn= driver.findElement(XpathConstants.SHARE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(shareBtn));
        highlightElement(driver,shareBtn);
        shareBtn.click();
    }

    @Test(dependsOnMethods = "updateTrackingDetails")
    public void viewInventory() throws InterruptedException, IOException {

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(80));

        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.ACTION_ITEM));
        WebElement viewInventoryBtn= driver.findElements(XpathConstants.ACTION_ITEM).get(3);
        wait.until(ExpectedConditions.elementToBeClickable(viewInventoryBtn));
        highlightElement(driver,viewInventoryBtn);
        viewInventoryBtn.click();

        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);
    }



}


