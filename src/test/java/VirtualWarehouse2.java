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
import java.util.concurrent.TimeUnit;

public class VirtualWarehouse2 {

    class XPathConstaints
    {

        public static final By ACTION_WRAPPER= By.xpath("//div[@class='actionsWrapper']");
        public static final By SUPPLIER_HINT= By.xpath("//input[@id='selectSupplier-input-tfid-0-0']");
        public static final By LOAD_ICON= By.xpath("//span[@class='loading-icon m-r-10 hide']");
        public static final By CREATE_BATCH= By.xpath(".//div[@class='actionItem']//span[text()='Create Batch']");
        public static final By TABLE= By.xpath("//table[@class='customTable']//tbody");
        public static final By INPUT_QTY= By.xpath(".//input[@id='indSelect-batchLineItems']");
        public static final By GO_TO_BATCH= By.xpath("//div[@class='modalWrapper']//button[@class='btn btn-primary']");
        public static final By INPUT_QUANTITY= By.xpath(".//input[@name='requiredQuantity']");
        public static final By ORDER_ID_ELEMENT= By.xpath("//span[@class='ellipsisText']");
        public static final By PAYMENT_BUYERPO= By.className("heading");

        public static final By LINKELEMENT= By.xpath("//span[@class='pointerCursor']");
        public static final By DRAWER= By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex");
        public static final By DRAWER_OPTIONS= By.xpath("//button[@class='md-raised md-primary side-menu-link md-button ng-scope md-ofb-brown-theme md-ink-ripple']");
        public static final By DRAWER_ACTIONS = By.xpath("//ul[@class='drop-down-list ng-scope']//li");
        public static final By OPTIONS= By.xpath("//div[@class=' css-17vhrl4']");
        public static final By ADVANCE= By.xpath("//input[@id='tfid-0-6']");
        public static final By INPUT_FIELDS= By.xpath("//input[@id='tfid-0-7']");
        public static final By INPUT_FIELDS2 = By.xpath("//input[@id='tfid-0-8']");
        public static final By RADIO_GRP= By.xpath("//div[@class='radio-group']");
        public static final By SUBMIT_BTN= By.xpath("//button[@class='btn btn-primary']");
        public static final By LIST_ITEMS= By.xpath(".//div[@class='listItemRow']");
        public static final By ACTION_BTN= By.xpath(".//div[@class='actionItem']");
        public static final By SUPPLIER_NAME_VALUE= By.xpath("//div[@id='react-select-selectSupplier-option-0']");
        public static final By BILLING_ADDRESS_VALUE= By.xpath("//div[@class=' css-1m5nn3x']//div");
        public static final By PICKUPADDRESS_VALUE= By.xpath("//div[@class=' css-1ul4jvx-option']");
        public static final By ONDELIVERY= By.xpath("//input[@id='tfid-0-9']");
        public static final By SCROLLTO= By.xpath("//div[text()='Other Configurations']");
        public static final By MULTIPLE_USED_XPATH= By.xpath("//div[@class=' css-1i8o47w']");
        public static final By OFB_ADDRESS= By.xpath("//div[@id='react-select-ofbEntityAddressId-option-0']");
        public static final By ADD_ITEMS_BTN= By.xpath("//button[@class='btn btn-primary addContactPersonBtn']");


        public static final By ITEMS_SECTION= By.xpath("//div[@class='baseCatWrapper']");
        public static final By ITEMS= By.xpath("//div[@class='catItem']");
        public static final By ITEM_CART= By.xpath(".//button[@class='btn btn-default']");
        public static final By VARIETY_SECTION= By.xpath("//div[@class='leafCatWrapper']");
        public static final By CART_BTN= By.xpath("//div[@class='cartBtn']");
        public static final By OKAY_BTN= By.xpath("//button[@class='btn btn-primary' and contains(text(),'OK')]");
        public static final By CHECKBOX_SECTION= By.className("checkBoxContent");
        public static final By CHECKBOX_OPTION= By.cssSelector("input[type='checkbox']");
        public static final By ACTION_BTNS= By.cssSelector("button.btn.btn-default");
        public static final By SUBCATEGORY= By.className("form-control");
        public static final By FREIGHT_RATE= By.id("tfid-0-6");
        public static final By LOADING_CHARGES= By.id("tfid-0-7");
        public static final By DROPDOWN_OPTIONS= By.className("reactSelectContainer");
        public static final By GST_OPTION= By.id("react-select-gst-option-2");
        public static final By COPY_BTN= By.className("copyBtn");

        public static final By SUBCATEGORY_FORM= By.className("subCategoryForm");
        public static final By QTY_BASERATE= By.xpath(".//input[@class='form-control']");
        public static final By UNITS= By.xpath(".//div[@class='reactSelectContainer']");
        public static final By UNIT_VALUE= By.xpath(".//div[@id='react-select-Unit-option-0']");
        public static final By GST_DROPDOWN= By.xpath(".//div[@class='form-group form-group-depth-1 form-group-GST']//div[@class=' css-2b097c-container']");
        public static final By GST_VAL= By.xpath(".//div[@id='react-select-GST-option-0']");
        public static final By VERIFIER= By.xpath("//input[@id='verifierName-input-tfid-0-0']");
        public static final By VERIFIER_NAME= By.xpath("//div[@id='react-select-verifierName-option-0']");
        public static final By SEND_FOR_VERIFICATION_BTN= By.xpath("//button[text()='Send for Verification ']");
        public static final By LOADING_ICONS= By.xpath("//span[@class='loading-icon m-r-10']");
        public static final By PO_NUMBER_ELEMENT= By.xpath("//span[@class='backTxt']//span");
        public static final By ELLIPSIS_TEXT= By.xpath("//span[@class='value ellipsisText linkTxt']");
        public static final By BTN_XPATH= By.cssSelector("button.btn.btn-primary");


        public static final By INVOICE_AMOUNT= By.id("tfid-0-5");
        public static final By MULTIPLE_USED_BTN= By.xpath("//button[@class='btn btn-default']");


        public static final By NAV_ITEMS= By.xpath("//ul[@class='nav-list']");
        public static final By PURCHASE_ORDERS= By.xpath(".//ul[@class='inner-nav-list']//li[2]");
        public static final By SUPPLIER_PO= By.xpath(".//ul[@class='inner-nav-list']//li");
        public static final By SEARCH_FIELD= By.xpath("//input[@class='form-control searchTxtField']") ;
        public static final By REQUESTED_PO= By.xpath("//div[@class='supplierWrapper']");
        public static final By APPROVEBTN= By.xpath(".//button[@class='btn btn-primary approveBtn']");
        public static final By SUBMIT_BTN2= By.xpath("//div[@class='actionWrapper']//button[@class='btn btn-primary']");
        public static final By LOADING= By.xpath("//span[@class='loading-icon m-r-10 hide']");
        public static final By PO_SEARCH=  By.xpath("//input[@id='tfid-0-0']");
        public static final By LIST_SECTION= By.xpath("//div[@class='cardItemWrapper wareHousePOItemList']");
        public static final By PO_ITEMS= By.xpath("//div[@class='listItemRow']");
        public static final By BUYER_HINT= By.id("buyer-input-tfid-0-0");
        public static final By BUYER_VALUE= By.xpath("//div[@id='react-select-buyer-option-0']");



        public static final By BUYER_PREFS= By.xpath("//span[text()='Buyer Preferences']");
        public static final By BUYER_PREFS_OPTIONS= By.className("contentView");
        public static final By ADDRESS_OPTIONS= By.xpath("//div[@class= ' css-1i8o47w']");
        public static final By SHIPPING_ADDRESS_OPTION= By.xpath("//div[@class=' css-yxf0z2']");
        public static final By BILLING_ADDRESS_OPTION= By.xpath("//div[@id='react-select-billingAddress-option-0']");
        public static final By BUYER_CONTAINER= By.className("buyerPoContainer");
        public static final By PO_NUMBER= By.id("tfid-0-1");
        public static final By UPLOADDOCS= By.id("upload-document-undefined");
        public static final By SAVE= By.xpath("//button[text()='Save ']");
        public static final By EDIT_ENTITY= By.cssSelector("button.btnEdit.material-icons");
        public static final By ADDRESS_VALUE= By.xpath("//div[@id='react-select-ofbEntityAddress-option-1']");
        public static final By UPDATE_SUBMIT_BTN= By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']");
        public static final By LOADING_ICON= By.xpath("//div[@class='modal']//span[@class='loading-icon m-r-10 hide']");
        public static final By ITEM_SPECIFICATIONS= By.xpath("//div[@class='optHeader']//span");
        public static final By SUBMIT_QUOTE= By.xpath("//button[text()='Submit Buyer Quote ']");


        public static final By SUPPLIER_QUOTE= By.className("supplierQuote");
        public static final By VIEW_SUPPLIER_DETAILS= By.xpath("//div[@class='optHeader']//span[text()='View Supplier Details ']");

        public static final By TOAST_ELEMENT= By.xpath("//div[@class='Toastify__toast-body']");
        public static final By MODAL_CONTENT= By.xpath("//div[@class='modalContent']");
        public static final By CHECKBOXES= By.xpath("//div[@class='checkbox-group']//span");

        public static final By SAVEBTN= By.cssSelector("button.btn.btn-primary.saveBtn");
        public static final By SEND_FOR_APPROVAL= By.xpath("//button[text()='Send for Approval']");
        public static final By CHECK_BOX= By.xpath("//input[@class='enable']");
        public static final By EDITBTN= By.cssSelector("button.btn.btn-default.editBtn");

        public static final By PRODUCTS= By.xpath("//div[@class='l2-category-group ']");
        public static final By SHOW_MORE_BTN= By.xpath(".//i[@class='material-icons']");
        public static final By CARTBTN= By.xpath("//div[@class='cartBtn ']");
        public static final By UPLOAD_STI= By.xpath("//label[@class='uploadButton undefined']");
        public static final By DATEPICKER= By.className("react-datepicker__input-container");
        public static final By MONTH_YEAR_BTN= By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown");
        public static final By CURRDATE= By.xpath("//div[contains(@class, 'react-datepicker__day--today')]");
        public static final By INVOICE_DATE= By.xpath("//input[@placeholder='Select invoice date']");
        public static final By REDIRECT_BLOCK= By.xpath("//button[@class='redirectBlock']");
        public static final By ITEMLIST= By.xpath("//div[@class='lineItemCard']");
        public static final By CHECKBOX_LABEL= By.xpath("//label[@class='checkboxLabel']");
        public static final By QTY_INPUT= By.xpath(".//input[@name='otherCharges']");
        public static final By RADIO_BTN= By.xpath(".//div[@class='radio-group']");
        public static final By BILLING_ADD_VALUE= By.xpath("//label[@class='radioLabel']");
        public static final By BILLINGADDRESS= By.id("react-select-billingAddress-option-0");
        public static final By PICKUPADDRESS= By.id("react-select-pickupAddress-option-0");

        public static final By DISPATCH_ACTION_BTN= By.cssSelector("button.btn.btn-primary.dispatchActionBtn");
        public static final By DISPATCH_SECTION= By.xpath("//div[@class='dispatchColumns']//tbody");
        public static final By DISPATCHQTY_INPUT= By.xpath("//input[@class='formControl Dispatch__formControl--les6J']");
        public static final By SHIPMENT_NEXT_BTN= By.cssSelector("button.Dispatch__btn--vR5sf.btn-primary");
        public static final By DISPATCH_CART= By.xpath("//div[@class='Dispatch__cartBtn--ABWNt']");

        public static final By ORG_NAME_ELEMENT= By.xpath("//span[@class='mainTitle linkAble']");

        public static final By LOADINGICON= By.xpath("//div[@class='modalFooter']//span[@class='loading-icon m-r-10 hide']");
        public static final By DATEINPUT= By.xpath("//input[@placeholder='Start Date']");
        public static final By DATE_INPUT1= By.className("react-datepicker-ignore-onclickoutside");

        public static final By ADD_RECEIPT_BTN= By.xpath("//button[@aria-label='Add receipt']");
        public static final By AMOUNT_INPUT= By.xpath("//span[@class='listValue']//input");
        public static final By UTR_VALUE= By.xpath("//input[@name='paymentUtr']");
        public static final By PARTY_NAME= By.xpath("//input[@name='paymentFrom']");
        public static final By TRANSACTION_TYPE= By.xpath("//md-select[@name='paymentType']");
        public static final By TRANSACTION_VALUE= By.xpath("//md-option[@value='NEFT']");
        public static final By BANK_ACCOUNT= By.xpath("//md-select[@name='ofbAccount']");
        public static final By ACCOUNT_VALUE= By.xpath("//md-option[@ng-value='ofbAccount']");
        public static final By CREATE_BTN= By.xpath("//button[@class='customButtonFill right md-button ng-scope md-ofb-green-theme md-ink-ripple']");
        public static final By FINANCE_TABLE= By.xpath("//div[@class='responsiveTable']");
        public static final By FINANCE_LIST= By.xpath("//div[@class='responsiveTable']//tbody[@class='ng-scope']");
        public static final By AMOUNT_CHECK= By.xpath(".//td[@class='alignRight ng-binding']");
        public static final By BTN_SECTION= By.xpath(".//td[@class='suggestedAmmountWrap customCheckbox']");
        public static final By SEARCH_ORGANIZATION= By.xpath(".//input[@type='search']");
        public static final By ORGANIZATION_OPTION= By.xpath("//div[@class='md-virtual-repeat-offsetter']//li");
        public static final By OPTIONS_SAVEBTN= By.xpath("//button[@class='customButtonFill md-button md-ofb-green-theme md-ink-ripple']");
        public static final By ORDER_SECTION= By.xpath("//button[@class='md-raised md-primary side-menu-link md-button ng-scope md-ofb-brown-theme md-ink-ripple'][8]");
        public static final By BUYOUT_BTN= By.xpath("//ul[@class='drop-down-list ng-scope']//li[2]");
        public static final By BUYOUT_OPTION= By.xpath("//ul//ul//li//a[text()='Buyout ']");
        public static final By ORDER_LIST= By.xpath("//table[@class='customTable']");
        public static final By BUYER_ELEMENT= By.xpath(".//td[2]//span[@class='buyerName']");

        public static final By LINKS_LIST= By.className("links__list");
        public static final By CHECKBOX= By.xpath("//div[@class='tableContainer']//span");
        public static final By ITEMS_LIST= By.xpath("//tbody//tr");
        public static final By PENDING_QTY= By.xpath(".//div[@class='value pending']");
        public static final By MULTIPLE_USED_INPUT= By.id("tfid-0-0");
        public static final By ERROR_MSG= By.xpath("//div[@class='error-msg']");


        public static final By CREATE_SHIPMENT= By.xpath("//button[@class='Dispatch__actionBtn--q2vEq']");
        public static final By FULFILLMENTSPOC= By.xpath("//input[@id='fulfillmentSpoc-input-tfid-0-2']");
        public static final By LOGISTIC_MODE_HINT= By.xpath("//input[@id='logisticsMode-input-tfid-0-3']");
        public static final By TRUCK_TYPE_INPUT= By.xpath("//input[@id='truckType-input-tfid-0-4']");
        public static final By CREATE_SHIPMENT_BTN= By.xpath("//button[@class='Dispatch__btn--vR5sf btn-primary']");
        public static final By GO_TO_SHIPMENT_BTN= By.xpath("//button[text()='Go to Shipment']");
    }

    static String mainWindow;
    WebDriver driver;
    static Properties prop;
    static String ofbEntity_Value;
    static String organizationID;
    static String poNumber;
    static String currDate;

    static String orgName;

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
        Cookie cookie = driver.manage().getCookieNamed("admin-auth-token");
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

    public static void setCurrDate(WebDriver driver) {

        WebElement datePicker = driver.findElement(XPathConstaints.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn = driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        String month = monthYearBtn.getText().split(" ")[0];
        String year = monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        currDate = dateBtn.getText() + " " + month + " " + year;

        WebElement dateInput = driver.findElement(XPathConstaints.DATEINPUT);
        dateInput.sendKeys(currDate);
    }


    public static int generateInvoiceNumber() {
        Random random = new Random();
        int randomNumber = 100000 + random.nextInt(900000);
        return randomNumber;
    }

    @Test(testName = "set up")
    public void setUp() throws IOException, InterruptedException {
        loadPropFile();
        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile5");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("stg5-cms-url"));
        mainWindow = driver.getWindowHandle();

        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.CONTROL + "l");  // Shortcut to focus the address bar
        Thread.sleep(2000);
        body.sendKeys(Keys.ENTER);  // Simulate the Enter key press

    }

//    @Test(dependsOnMethods = "setUp")
//    public void loginTest() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DRAWER));

        WebElement drawer = driver.findElement(XPathConstaints.DRAWER);
        highlightElement(driver, drawer);

        List<WebElement> options = driver.findElements(XPathConstaints.DRAWER_OPTIONS);
        WebElement bulkOrderSection = options.get(3);
        wait.until(ExpectedConditions.elementToBeClickable(bulkOrderSection));
        highlightElement(driver, bulkOrderSection);
        bulkOrderSection.click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DRAWER_ACTIONS));
        WebElement bulkOrderEntity = driver.findElement(XPathConstaints.DRAWER_ACTIONS);
        wait.until(ExpectedConditions.elementToBeClickable(bulkOrderEntity));
        highlightElement(driver, bulkOrderEntity);
        bulkOrderEntity.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.PO_ITEMS));
        List<WebElement> entities = driver.findElements(XPathConstaints.PO_ITEMS);

        WebElement entity = entities.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(entity));
        highlightElement(driver, entity);
        entity.click();
    }

    @Test(dependsOnMethods = "handleBulkOrder")
    public void issuePO() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ACTION_WRAPPER));
        WebElement issuePoSection = driver.findElement(XPathConstaints.ACTION_WRAPPER);
        wait.until(ExpectedConditions.elementToBeClickable(issuePoSection));
        highlightElement(driver, issuePoSection);

        WebElement issuePoBtn = issuePoSection.findElement(XPathConstaints.ACTION_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(issuePoBtn));
        highlightElement(driver, issuePoBtn);
        issuePoBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.OPTIONS));
        WebElement supplierName = driver.findElement(XPathConstaints.OPTIONS);
        wait.until(ExpectedConditions.elementToBeClickable(supplierName));
        highlightElement(driver, supplierName);
        supplierName.click();

        WebElement supplierName_hint = driver.findElement(XPathConstaints.SUPPLIER_HINT);
        supplierName_hint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUPPLIER_NAME_VALUE));
        WebElement supplierValue = driver.findElement(XPathConstaints.SUPPLIER_NAME_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(supplierValue));
        highlightElement(driver, supplierValue);
        supplierValue.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.OPTIONS));
        List<WebElement> supplierOptions = driver.findElements(XPathConstaints.OPTIONS);

        WebElement billingAddress = supplierOptions.get(1);
        highlightElement(driver, billingAddress);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BILLING_ADDRESS_VALUE));
        WebElement billingAddressValue = driver.findElement(XPathConstaints.BILLING_ADDRESS_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
        highlightElement(driver, billingAddressValue);
        billingAddressValue.click();

        WebElement pickupAddress = supplierOptions.get(2);
        highlightElement(driver, pickupAddress);
        pickupAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.PICKUPADDRESS_VALUE));
        WebElement pickupAddressValue = driver.findElement(XPathConstaints.PICKUPADDRESS_VALUE);
        highlightElement(driver, pickupAddressValue);
        pickupAddressValue.click();

        List<WebElement> radioGroups = driver.findElements(XPathConstaints.RADIO_GRP);

        WebElement radiogroup = radioGroups.get(2);
        highlightElement(driver, radiogroup);

        WebElement radioGrpValue = radiogroup.findElement(By.xpath(".//label"));
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



        WebElement addItemsBtn = driver.findElement(XPathConstaints.ADD_ITEMS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addItemsBtn));
        highlightElement(driver, addItemsBtn);
        addItemsBtn.click();
    }

    @Test(dependsOnMethods = "issuePO")
    public void addItems() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ITEMS_SECTION));
        WebElement itemsSection = driver.findElement(XPathConstaints.ITEMS_SECTION);
        List<WebElement> items = driver.findElements(XPathConstaints.ITEMS);
        highlightElement(driver, items.get(2));

        WebElement item1 = items.get(2).findElement(XPathConstaints.ITEM_CART);
        wait.until(ExpectedConditions.elementToBeClickable(item1));
        highlightElement(driver, item1);
        item1.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.VARIETY_SECTION));
        WebElement varietySection = driver.findElement(XPathConstaints.VARIETY_SECTION);
        highlightElement(driver, varietySection);

        List<WebElement> varieties = driver.findElements(XPathConstaints.ITEMS);
        for (int i = 1; i <= 2; i++) {
            WebElement variety1 = varieties.get(i);
            highlightElement(driver, variety1);
            WebElement addToCartBtn = variety1.findElement(XPathConstaints.ITEM_CART);
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
            highlightElement(driver, addToCartBtn);
            addToCartBtn.click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CART_BTN));
        WebElement cartBtn = driver.findElement(XPathConstaints.CART_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
        highlightElement(driver, cartBtn);
        cartBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.SUBCATEGORY_FORM));

        List<WebElement> subcategoryForms = driver.findElements(XPathConstaints.SUBCATEGORY_FORM);

        Thread.sleep(4000);
        for (WebElement subcategoryForm : subcategoryForms) {
            WebElement itemQty = subcategoryForm.findElements(XPathConstaints.QTY_BASERATE).get(0);
            itemQty.clear();
            itemQty.sendKeys("100");

            WebElement units = subcategoryForm.findElements(XPathConstaints.UNITS).get(0);
            highlightElement(driver, units);
            units.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.UNIT_VALUE));
            WebElement unitValue = subcategoryForm.findElement(XPathConstaints.UNIT_VALUE);
            wait.until(ExpectedConditions.elementToBeClickable(unitValue));
            highlightElement(driver, unitValue);
            unitValue.click();

            WebElement baserate = subcategoryForm.findElements(XPathConstaints.QTY_BASERATE).get(1);
            baserate.sendKeys("100");

            WebElement gstDropDown = subcategoryForm.findElement(XPathConstaints.GST_DROPDOWN);
            highlightElement(driver, gstDropDown);
            gstDropDown.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.GST_VAL));
            WebElement gstValue = subcategoryForm.findElement(XPathConstaints.GST_VAL);
            wait.until(ExpectedConditions.elementToBeClickable(gstValue));
            highlightElement(driver, gstValue);
            gstValue.click();

//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Gross Value']")));
//            WebElement grossValueElement = subcategoryForm.findElement(By.xpath(".//input[@name='Gross Value']"));

//            int grossValue= Integer.parseInt(grossValueElement.getAttribute("value"));
//            int totalVal= Integer.parseInt(baserate.getText())*Integer.parseInt(itemQty.getAttribute("value"));
//            int actualGrossValue= totalVal+ totalVal*(Integer.parseInt(gstValue.getAttribute("value").substring(0,gstValue.getAttribute("value").length()-1)));
//            System.out.println("GrossValue element text "+ grossValue);
//            System.out.println("Actual Computed "+ actualGrossValue);
//            Assert.assertEquals(grossValue,actualGrossValue);

        }

        Thread.sleep(3000);
        WebElement submitBtn = driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver, submitBtn);
        submitBtn.click();







        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SCROLLTO));
        WebElement scrollToElement = driver.findElement(XPathConstaints.SCROLLTO);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToElement);

        WebElement advanceAmount = driver.findElement(XPathConstaints.ADVANCE);
        advanceAmount.sendKeys("100");

        WebElement onDispatchAmount = driver.findElement(XPathConstaints.INPUT_FIELDS);
        onDispatchAmount.sendKeys("0");

        WebElement onDelivery = driver.findElement(XPathConstaints.INPUT_FIELDS2);
        onDelivery.sendKeys("0");

        WebElement credit = driver.findElement(XPathConstaints.ONDELIVERY);
        credit.sendKeys("0");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToElement);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_XPATH));
        WebElement ofbEntityAddress = driver.findElement(XPathConstaints.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntityAddress));
        highlightElement(driver, ofbEntityAddress);
        ofbEntityAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.OFB_ADDRESS));
        WebElement ofbAddressvalue = driver.findElement(XPathConstaints.OFB_ADDRESS);
        wait.until(ExpectedConditions.elementToBeClickable(ofbAddressvalue));
        highlightElement(driver, ofbAddressvalue);
        ofbAddressvalue.click();

        Thread.sleep(2000);
        setCurrDate(driver);

        System.out.println("Current Date is "+ currDate);




        Thread.sleep(3000);
        submitBtn = driver.findElements(XPathConstaints.SUBMIT_BTN).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver, submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_XPATH));
        WebElement verifierOption = driver.findElement(XPathConstaints.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(verifierOption));
        highlightElement(driver, verifierOption);
        verifierOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.VERIFIER));
        WebElement verifier_hint = driver.findElement(XPathConstaints.VERIFIER);
        verifier_hint.sendKeys("Anshul Jain");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.VERIFIER_NAME));
        WebElement verifier_name = driver.findElement(XPathConstaints.VERIFIER_NAME);
        wait.until(ExpectedConditions.elementToBeClickable(verifier_name));
        highlightElement(driver, verifier_name);
        verifier_name.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.SEND_FOR_VERIFICATION_BTN));
        WebElement sendForVerificationBtn = driver.findElement(XPathConstaints.SEND_FOR_VERIFICATION_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(sendForVerificationBtn));
        highlightElement(driver, sendForVerificationBtn);
        sendForVerificationBtn.click();

        //Thread.sleep(10000);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOADING_ICONS));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.PO_NUMBER_ELEMENT));
        WebElement poNumberElement = driver.findElement(XPathConstaints.PO_NUMBER_ELEMENT);
        poNumber = poNumberElement.getText();

    }

    @Test(dependsOnMethods = "addItems")
    public void verifyPO() throws IOException, InterruptedException {
        addCookie(driver, prop.getProperty("supplier-auth-token"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.NAV_ITEMS));
        WebElement verifySection = driver.findElements(XPathConstaints.NAV_ITEMS).get(8);
        highlightElement(driver, verifySection);
        verifySection.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.SUPPLIER_PO));
        WebElement supplierPOBtn = verifySection.findElement(XPathConstaints.SUPPLIER_PO);
        wait.until(ExpectedConditions.elementToBeClickable(supplierPOBtn));
        highlightElement(driver, supplierPOBtn);
        supplierPOBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SEARCH_FIELD));
        WebElement searchField = driver.findElement(XPathConstaints.SEARCH_FIELD);
        searchField.sendKeys(poNumber);

        Thread.sleep(3000);
        searchField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.REQUESTED_PO));
        WebElement requestedPO = driver.findElement(XPathConstaints.REQUESTED_PO);
        highlightElement(driver, requestedPO);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.APPROVEBTN));
        WebElement approveBtn = requestedPO.findElement(XPathConstaints.APPROVEBTN);
        wait.until(ExpectedConditions.elementToBeClickable(approveBtn));
        highlightElement(driver, approveBtn);
        approveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN2));
        WebElement submitBtn = driver.findElement(XPathConstaints.SUBMIT_BTN2);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver, submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOAD_ICON));

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.NAV_ITEMS));
        List<WebElement> sidemenu = driver.findElements(XPathConstaints.NAV_ITEMS);

        WebElement bulkOrder = sidemenu.get(3);
        wait.until(ExpectedConditions.elementToBeClickable(bulkOrder));
        highlightElement(driver, bulkOrder);
        bulkOrder.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.PURCHASE_ORDERS));
        WebElement purchaseOrders = bulkOrder.findElement(XPathConstaints.PURCHASE_ORDERS);
        wait.until(ExpectedConditions.elementToBeClickable(purchaseOrders));
        highlightElement(driver, purchaseOrders);
        purchaseOrders.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.PO_SEARCH));
        WebElement searchByPO = driver.findElement(XPathConstaints.PO_SEARCH);
        searchByPO.sendKeys(poNumber);

        Thread.sleep(1500);
        searchByPO.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.LIST_SECTION));
        WebElement listSection = driver.findElement(XPathConstaints.LIST_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(listSection));
        highlightElement(driver, listSection);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.PO_ITEMS));
        List<WebElement> items = listSection.findElements(XPathConstaints.LIST_ITEMS);
        highlightElement(driver, items.get(0));
        items.get(0).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ACTION_WRAPPER));
        WebElement actionWrapper = driver.findElement(XPathConstaints.ACTION_WRAPPER);
        highlightElement(driver, actionWrapper);

        //List<WebElement> actionButtons = actionWrapper.findElements(By.xpath(".//div[@class='actionItem']"));
        WebElement createBatch = actionWrapper.findElement(XPathConstaints.CREATE_BATCH);
        wait.until(ExpectedConditions.elementToBeClickable(createBatch));
        highlightElement(driver, createBatch);
        createBatch.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.TABLE));
        WebElement table = driver.findElement(XPathConstaints.TABLE);
        highlightElement(driver, table);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr")));
        List<WebElement> products = table.findElements(By.xpath(".//tr"));

        Thread.sleep(2000);

        for (WebElement product : products) {
            List<WebElement> productOptions= product.findElements(By.xpath(".//td"));
            highlightElement(driver,productOptions.get(0));
            WebElement checkBox= productOptions.get(0).findElement(By.xpath(".//label//input"));
            //checkBox.click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);

            String pendingQty = productOptions.get(2).getText();

            WebElement qty_input = productOptions.get(4).findElement(XPathConstaints.INPUT_QTY);
            qty_input.sendKeys(pendingQty);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement addToBatchButton = driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addToBatchButton));
        highlightElement(driver, addToBatchButton);
        addToBatchButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CART_BTN));
        WebElement viewAddedItems = driver.findElement(XPathConstaints.CART_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(viewAddedItems));
        highlightElement(driver, viewAddedItems);
        viewAddedItems.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement createBtn = driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver, createBtn);
        createBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOAD_ICON));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.GO_TO_BATCH));
        WebElement goToBatch = driver.findElement(XPathConstaints.GO_TO_BATCH);
        wait.until(ExpectedConditions.elementToBeClickable(goToBatch));
        highlightElement(driver, goToBatch);
        goToBatch.click();

        //uploadSti(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ELLIPSIS_TEXT));
        WebElement bulkOrderID= driver.findElement(XPathConstaints.ELLIPSIS_TEXT);
        wait.until(ExpectedConditions.elementToBeClickable(bulkOrderID));
        highlightElement(driver,bulkOrderID);
        bulkOrderID.click();

        Thread.sleep(1500);
        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ACTION_WRAPPER));
        WebElement createRFQSection = driver.findElement(XPathConstaints.ACTION_WRAPPER);
        wait.until(ExpectedConditions.elementToBeClickable(createRFQSection));
        highlightElement(driver, createRFQSection);

        WebElement createRFQBtn = createRFQSection.findElements(XPathConstaints.ACTION_BTN).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(createRFQBtn));
        highlightElement(driver, createRFQBtn);
        createRFQBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_XPATH));
        WebElement selectBuyer= driver.findElement(XPathConstaints.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(selectBuyer));
        highlightElement(driver,selectBuyer);
        selectBuyer.click();

        WebElement buyerHint= driver.findElement(XPathConstaints.BUYER_HINT);
        buyerHint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BUYER_VALUE));
        WebElement buyer_value= driver.findElement(XPathConstaints.BUYER_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(buyer_value));
        highlightElement(driver,buyer_value);
        buyer_value.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BILLING_ADD_VALUE));
        WebElement billingAddressValue= driver.findElement(XPathConstaints.BILLING_ADD_VALUE);
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CHECKBOX_LABEL));
        WebElement shippngAddressValue= driver.findElement(XPathConstaints.CHECKBOX_LABEL);
        wait.until(ExpectedConditions.elementToBeClickable(shippngAddressValue));
        highlightElement(driver,shippngAddressValue);
        shippngAddressValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement nextBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.PRODUCTS));

        List<WebElement> productList= driver.findElements(XPathConstaints.PRODUCTS);

        for(WebElement product:productList)
        {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
            Thread.sleep(1000);
            highlightElement(driver,product);

            WebElement showMoreBtn= product.findElement(XPathConstaints.SHOW_MORE_BTN);
            wait.until(ExpectedConditions.elementToBeClickable(showMoreBtn));
            highlightElement(driver,showMoreBtn);
            showMoreBtn.click();

            //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody//tr")));
            Thread.sleep(2000);


            List<WebElement> inputQty= product.findElements(XPathConstaints.INPUT_QUANTITY);

            List<WebElement> lots= product.findElements(By.xpath(".//tbody//tr"));
            int counter=0;
            for(WebElement lot:lots)
            {

                Thread.sleep(1000);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lot);
                Thread.sleep(1000);
                List<WebElement> options= lot.findElements(By.xpath(".//td"));

                WebElement lot_create_date= options.get(3);
                highlightElement(driver,lot_create_date);
                System.out.println("Lot Created Date is "+ lot_create_date.getText()+" Current Date is "+ currDate);
                if(lot_create_date.getText().substring(0,2).equals(currDate.substring(0,2)))
                {
                    System.out.println("Your lot is found");

                    WebElement selectItem= options.get(0).findElement(By.xpath(".//label"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectItem);
                    Thread.sleep(1000);
                    highlightElement(driver,selectItem);
                    selectItem.click();

                    WebElement stockQty= options.get(2);
                    String stock= stockQty.getText();

                    Thread.sleep(1000);
                    //WebElement qty_input= lot.findElement(By.xpath(".//input[@name='requiredQuantity']"));
                    WebElement qty_input= inputQty.get(counter);
                    highlightElement(driver,qty_input);
                    qty_input.sendKeys(String.valueOf(stock));
                    break;
                }
                counter++;
            }

        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement addToCartBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        highlightElement(driver,addToCartBtn);
        addToCartBtn.click();


        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ block: 'start', inline: 'center' });", viewCart);
        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        WebElement scrollTo= driver.findElement(By.xpath("//span[text()='Add Items']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ block: 'start', inline: 'center' });", scrollTo);
        Thread.sleep(6000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CARTBTN));
        WebElement viewCart= driver.findElement(XPathConstaints.CARTBTN);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewCart);
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0]);", -1000);
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(viewCart));
        highlightElement(driver,viewCart);
        viewCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement createRfQBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createRfQBtn));
        highlightElement(driver,createRfQBtn);
        createRfQBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOAD_ICON));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.OKAY_BTN));
        WebElement okayBtn= driver.findElement(XPathConstaints.OKAY_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(okayBtn));
        highlightElement(driver,okayBtn);
        okayBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CHECKBOX_SECTION));
        WebElement checkBoxSection= driver.findElement(XPathConstaints.CHECKBOX_SECTION);
        highlightElement(driver,checkBoxSection);

        System.out.println("After check Box");

        WebElement checkoption= checkBoxSection.findElement(XPathConstaints.CHECKBOX_OPTION);
        highlightElement(driver,checkoption);
        checkoption.click();
        System.out.println("Check Box Clicked");

        List<WebElement> actionButtons= driver.findElements(XPathConstaints.ACTION_BTNS);
        actionButtons.get(2).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBCATEGORY_FORM));

        WebElement subcategoryForm= driver.findElement(XPathConstaints.SUBCATEGORY_FORM);
        highlightElement(driver,subcategoryForm);

        List<WebElement> option= subcategoryForm.findElements(XPathConstaints.SUBCATEGORY);
        WebElement baseRate= option.get(2);
        highlightElement(driver,baseRate);
        baseRate.sendKeys("100");

        WebElement freightRate= subcategoryForm.findElement(XPathConstaints.FREIGHT_RATE);
        highlightElement(driver,freightRate);
        freightRate.sendKeys("100");

        WebElement loadingCharges= subcategoryForm.findElement(XPathConstaints.LOADING_CHARGES);
        loadingCharges.sendKeys("50");

        List<WebElement> dropDownOptions= driver.findElements(XPathConstaints.DROPDOWN_OPTIONS);
        dropDownOptions.get(2).click();

        WebElement gstOption= dropDownOptions.get(2).findElement(XPathConstaints.GST_OPTION);
        highlightElement(driver,gstOption);
        gstOption.click();
        Thread.sleep(3000);

        try
        {
            WebElement copyRatesToAll= subcategoryForm.findElement(XPathConstaints.COPY_BTN);
            if(copyRatesToAll.isDisplayed())
                copyRatesToAll.click();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
            WebElement saveBtn = driver.findElement(XPathConstaints.SUBMIT_BTN);
            Thread.sleep(2000);
            highlightElement(driver,saveBtn);
            saveBtn.click();

        }
    }

    public void getOrganizationID(WebDriver driver)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ORDER_ID_ELEMENT));
        WebElement orderID= driver.findElement(XPathConstaints.ORDER_ID_ELEMENT);
        wait.until(ExpectedConditions.elementToBeClickable(orderID));
        highlightElement(driver,orderID);
        orderID.click();

        mainWindow= driver.getWindowHandle();

        for(String handle:driver.getWindowHandles())
            driver.switchTo().window(handle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.LINKELEMENT));
        WebElement organizationNameElement= driver.findElement(XPathConstaints.LINKELEMENT);
        wait.until(ExpectedConditions.elementToBeClickable(organizationNameElement));
        highlightElement(driver,organizationNameElement);

        orgName= organizationNameElement.getText();

        driver.switchTo().window(mainWindow);
    }



    @Test(dependsOnMethods = "createBatch")
    public void handleBuyerPrefs() throws InterruptedException, IOException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BUYER_PREFS));

        WebElement buyerPrefs= driver.findElement(XPathConstaints.BUYER_PREFS);
        highlightElement(driver,buyerPrefs);
        buyerPrefs.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.BUYER_PREFS_OPTIONS));
        List<WebElement> buyerPrefsOptions= driver.findElements(XPathConstaints.BUYER_PREFS_OPTIONS);

        System.out.println("Size:" + buyerPrefsOptions.size());

//        WebElement preferences= buyerPrefsOptions.get(0).findElement(By.className("heading"));
//        wait.until(ExpectedConditions.elementToBeClickable(preferences));
//        highlightElement(driver,preferences);
//        preferences.click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ACTION_BTNS));
        WebElement editBtn=  buyerPrefsOptions.get(0).findElement(XPathConstaints.ACTION_BTNS);
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

        List<WebElement> addressesOptions= driver.findElements(XPathConstaints.ADDRESS_OPTIONS);
        WebElement shippingAddressBtn= addressesOptions.get(3);
        highlightElement(driver,shippingAddressBtn);
        shippingAddressBtn.click();

        List<WebElement> shippingAddressOptions= driver.findElements(XPathConstaints.SHIPPING_ADDRESS_OPTION);
        if(!shippingAddressOptions.isEmpty())
            shippingAddressOptions.get(0).click();

        WebElement billingAddressBtn= addressesOptions.get(1);
        highlightElement(driver,billingAddressBtn);
        billingAddressBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BILLING_ADDRESS_OPTION));
        WebElement billingAddressValue= driver.findElement(XPathConstaints.BILLING_ADDRESS_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        WebElement toleranceInput= buyerPrefsOptions.get(0).findElement(XPathConstaints.INVOICE_AMOUNT);
        toleranceInput.sendKeys("0");

        WebElement saveAddressBtn= buyerPrefsOptions.get(0).findElement(XPathConstaints.BTN_XPATH);
        saveAddressBtn.click();

        Thread.sleep(5000);

        WebElement paymentTerms=  buyerPrefsOptions.get(1);
        WebElement paymentTermsSection= paymentTerms.findElement(XPathConstaints.PAYMENT_BUYERPO);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentTermsSection);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(paymentTermsSection));
        highlightElement(driver,paymentTermsSection);
        paymentTermsSection.click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_BTN));
        WebElement editBtn2= paymentTerms.findElement(XPathConstaints.ITEM_CART);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn2));
        highlightElement(driver,editBtn2);
        editBtn2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_INPUT));
        WebElement advanceInput= paymentTerms.findElement(XPathConstaints.MULTIPLE_USED_INPUT);
        advanceInput.clear();
        advanceInput.sendKeys("100");

        WebElement saveBtn= paymentTerms.findElement(XPathConstaints.SAVEBTN);
        highlightElement(driver,saveBtn);
        saveBtn.click();

        Thread.sleep(2000);
        paymentTermsSection.click();
        WebElement sendForApproval= paymentTerms.findElement(XPathConstaints.SEND_FOR_APPROVAL);
        wait.until(ExpectedConditions.elementToBeClickable(sendForApproval));

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();

        WebElement uploadPO=  buyerPrefsOptions.get(2);
        WebElement uploadBuyerPoSection= uploadPO.findElement(XPathConstaints.PAYMENT_BUYERPO);
        wait.until(ExpectedConditions.elementToBeClickable(uploadBuyerPoSection));
        highlightElement(driver,uploadBuyerPoSection);
        uploadBuyerPoSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CHECK_BOX));
        WebElement checkBox= driver.findElement(XPathConstaints.CHECK_BOX);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();
        System.out.println("Check Box Clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.EDITBTN));
        WebElement editBtn3= uploadPO.findElement(XPathConstaints.EDITBTN);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn3));
        highlightElement(driver,editBtn3);
        editBtn3.click();

        WebElement buyerContainer= uploadPO.findElement(XPathConstaints.BUYER_CONTAINER);
        WebElement PO_No= buyerContainer.findElement(XPathConstaints.PO_NUMBER);
        highlightElement(driver,PO_No);
        PO_No.sendKeys("12232");

        WebElement datePicker= driver.findElement(XPathConstaints.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        currDate= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
        dateInput.sendKeys(currDate);

        WebElement uploadDoc= uploadPO.findElement(XPathConstaints.UPLOADDOCS);
        uploadDoc.sendKeys(prop.getProperty("file-path"));

        Thread.sleep(6000);

        WebElement saveBtn2= uploadPO.findElement(XPathConstaints.SAVE);
        Thread.sleep(1500);
        highlightElement(driver,saveBtn2);
        saveBtn2.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.EDIT_ENTITY));
        WebElement editEntity= driver.findElement(XPathConstaints.EDIT_ENTITY);

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

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.OPTIONS));
        WebElement addressSection= driver.findElements(XPathConstaints.OPTIONS).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(addressSection));
        highlightElement(driver,addressSection);
        addressSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ADDRESS_VALUE));
        WebElement addressValue= addressSection.findElement(XPathConstaints.ADDRESS_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(addressValue));
        highlightElement(driver,addressValue);
        addressValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.UPDATE_SUBMIT_BTN));
        WebElement updateBtn= driver.findElement(XPathConstaints.UPDATE_SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOADING_ICON));

        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ITEM_SPECIFICATIONS));
        WebElement itemSpecifications= driver.findElement(XPathConstaints.ITEM_SPECIFICATIONS);
        itemSpecifications.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_QUOTE));
        WebElement submitBuyerQuote= driver.findElement(XPathConstaints.SUBMIT_QUOTE);

        wait.until(ExpectedConditions.elementToBeClickable(submitBuyerQuote));
        highlightElement(driver,submitBuyerQuote);
        submitBuyerQuote.click();

        Thread.sleep(3000);

    }

    @Test(dependsOnMethods = "handleBuyerPrefs")
    public void handleSupplierQuotation() throws InterruptedException, IOException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUPPLIER_QUOTE));
        WebElement supplierQuote= driver.findElement(XPathConstaints.SUPPLIER_QUOTE);
        highlightElement(driver,supplierQuote);
        supplierQuote.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.VIEW_SUPPLIER_DETAILS));
        WebElement viewSupplierDetails= driver.findElement(XPathConstaints.VIEW_SUPPLIER_DETAILS);
        wait.until(ExpectedConditions.elementToBeClickable(viewSupplierDetails));
        highlightElement(driver,viewSupplierDetails);
        viewSupplierDetails.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_BTN));
        WebElement sendForApproval= driver.findElement(XPathConstaints.MULTIPLE_USED_BTN);
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
        List<WebElement> toasts= driver.findElements(XPathConstaints.TOAST_ELEMENT);
        wait.until(ExpectedConditions.invisibilityOfAllElements(toasts));

        Thread.sleep(8000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BTN_XPATH));
        WebElement createOrder= driver.findElement(XPathConstaints.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(createOrder));
        highlightElement(driver,createOrder);
        createOrder.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOAD_ICON));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MODAL_CONTENT));


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.CHECKBOXES));
        List<WebElement> checkBoxes= driver.findElements(XPathConstaints.CHECKBOXES);

        for(WebElement checkBox:checkBoxes)
        {
            wait.until(ExpectedConditions.elementToBeClickable(checkBox));
            highlightElement(driver,checkBox);
            checkBox.click();
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.UPDATE_SUBMIT_BTN));
        WebElement submitBtn= driver.findElement(XPathConstaints.UPDATE_SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOADINGICON));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ORG_NAME_ELEMENT));
        WebElement organizationNameElement= driver.findElement(XPathConstaints.ORG_NAME_ELEMENT);
        wait.until(ExpectedConditions.elementToBeClickable(organizationNameElement));
        highlightElement(driver,organizationNameElement);

        orgName=organizationNameElement.getText();
        System.out.println("Organization Name is"+orgName);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button-link']")));
//        WebElement orderLink= driver.findElement(By.xpath("//a[@class='button-link']"));
//        wait.until(ExpectedConditions.elementToBeClickable(orderLink));
//        highlightElement(driver,orderLink);
//        orderLink.click();


        Thread.sleep(12000);

        for(String handle:driver.getWindowHandles())
            driver.switchTo().window(handle);
    }



    @Test(dependsOnMethods = "handleSupplierQuotation")
    public void createDispatch() throws IOException, InterruptedException {

//        loadPropFile();
//        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//        WebDriver driver;
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-fe/order/OFB117192210972175");

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
        // mainWindow= driver.getWindowHandle();

        //getOrganizationID(driver);

//        Thread.sleep(3000);
//        driver.switchTo().window(mainWindow);
        mainWindow= driver.getWindowHandle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='pointerCursor']")));
        WebElement buyerLink= driver.findElement(By.xpath("//span[@class='pointerCursor']"));
        wait.until(ExpectedConditions.elementToBeClickable(buyerLink));
        highlightElement(driver,buyerLink);
        buyerLink.click();

        for(String handle:driver.getWindowHandles())
            driver.switchTo().window(handle);
        Thread.sleep(2000);

        organizationID= driver.getCurrentUrl().split("/")[4];

        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.LINKS_LIST));
        WebElement linksLst= driver.findElement(XPathConstaints.LINKS_LIST);
        highlightElement(driver,linksLst);

        List<WebElement> actionButtons= linksLst.findElements(By.tagName("button"));
        WebElement createDispatchBtn= actionButtons.get(4);
        wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
        highlightElement(driver,createDispatchBtn);
        createDispatchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_BTN));
        WebElement selectSupplier= driver.findElement(XPathConstaints.MULTIPLE_USED_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(selectSupplier));
        highlightElement(driver,selectSupplier);
        selectSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CHECKBOX));
        WebElement checkBox= driver.findElement(XPathConstaints.CHECKBOX);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        List<WebElement> items= driver.findElements(XPathConstaints.ITEMS_LIST);
        for(WebElement item:items)
        {
            highlightElement(driver,item);
            List<WebElement> options= item.findElements(By.xpath(".//td"));

//            checkBox= options.get(0).findElement(By.xpath(".//label"));
//            wait.until(ExpectedConditions.elementToBeClickable(checkBox));
//            highlightElement(driver,checkBox);
//            checkBox.click();

            WebElement pendingAmt= options.get(4).findElement(XPathConstaints.PENDING_QTY);
            String qty= pendingAmt.getText();

            WebElement value= item.findElement(XPathConstaints.MULTIPLE_USED_INPUT);
            value.sendKeys(qty);
        }

        try{
            if(driver.findElement(XPathConstaints.ERROR_MSG).isDisplayed())
                handleFinance(driver);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {


            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
            WebElement addToDispatchBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
            wait.until(ExpectedConditions.elementToBeClickable(addToDispatchBtn));
            highlightElement(driver,addToDispatchBtn);
            addToDispatchBtn.click();

            Thread.sleep(5000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CARTBTN));
            WebElement viewDispatch= driver.findElement(XPathConstaints.CARTBTN);
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


            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BTN_XPATH));
            WebElement nextBtn= driver.findElement(XPathConstaints.BTN_XPATH);
            wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
            highlightElement(driver,nextBtn);
            nextBtn.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOAD_ICON));

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.OPTIONS));

            List<WebElement> addressOptions= driver.findElements(XPathConstaints.OPTIONS);

            WebElement billingAddress= addressOptions.get(0);
            wait.until(ExpectedConditions.elementToBeClickable(billingAddress));
            highlightElement(driver,billingAddress);
            billingAddress.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BILLINGADDRESS));
            WebElement billingAddressValue= driver.findElement(XPathConstaints.BILLINGADDRESS);
            wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
            highlightElement(driver,billingAddressValue);
            billingAddressValue.click();

            WebElement pickupAddress= addressOptions.get(1);
            wait.until(ExpectedConditions.elementToBeClickable(pickupAddress));
            highlightElement(driver,pickupAddress);
            pickupAddress.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.PICKUPADDRESS));
            WebElement pickupAddressValue= driver.findElement(XPathConstaints.PICKUPADDRESS);
            wait.until(ExpectedConditions.elementToBeClickable(pickupAddressValue));
            highlightElement(driver,pickupAddressValue);
            pickupAddressValue.click();

            WebElement datePicker= driver.findElements(XPathConstaints.DATEPICKER).get(0);
            datePicker.click();

            WebElement monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
            String month= monthYearBtn.getText().split(" ")[0];
            String year= monthYearBtn.getText().split(" ")[1];
            WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
            currDate= dateBtn.getText()+" "+ month+" "+year;

            WebElement dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
            dateInput.sendKeys(currDate);


            datePicker= driver.findElements(XPathConstaints.DATEPICKER).get(1);
            datePicker.click();

            monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
            month= monthYearBtn.getText().split(" ")[0];
            year= monthYearBtn.getText().split(" ")[1];
            dateBtn = driver.findElement(XPathConstaints.CURRDATE);
            currDate= dateBtn.getText()+" "+ month+" "+year;

            dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
            dateInput.sendKeys(currDate);

            createDispatchBtn= driver.findElement(XPathConstaints.BTN_XPATH);
            wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
            highlightElement(driver,createDispatchBtn);
            createDispatchBtn.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOAD_ICON));

        }
    }

    public void handleFinance(WebDriver driver) throws IOException, InterruptedException {
//        loadPropFile();
//
//        WebDriver driver= new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-fe/order/OFB117169593766597/create-dispatch/6748485310855781189");

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));

        WebElement financeSection= driver.findElements(XPathConstaints.NAV_ITEMS).get(10);
        wait.until(ExpectedConditions.elementToBeClickable(financeSection));
        highlightElement(driver,financeSection);
        financeSection.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li")));
        WebElement receiptsBtn= financeSection.findElement(By.xpath(".//ul//li[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(receiptsBtn));
        highlightElement(driver,receiptsBtn);
        receiptsBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ADD_RECEIPT_BTN));
        WebElement addReceiptBtn= driver.findElement(XPathConstaints.ADD_RECEIPT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addReceiptBtn));
        highlightElement(driver,addReceiptBtn);
        addReceiptBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.AMOUNT_INPUT));
        WebElement amount= driver.findElement(XPathConstaints.AMOUNT_INPUT);
        amount.sendKeys(prop.getProperty("receipt-amount"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.UTR_VALUE));
        WebElement utrValue= driver.findElement(XPathConstaints.UTR_VALUE);
        utrValue.sendKeys(prop.getProperty("utr-value"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.PARTY_NAME));
        WebElement party= driver.findElement(XPathConstaints.PARTY_NAME);
        party.sendKeys(prop.getProperty("party-value"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.TRANSACTION_TYPE));
        WebElement transactionType= driver.findElement(XPathConstaints.TRANSACTION_TYPE);
        wait.until(ExpectedConditions.elementToBeClickable(transactionType));
        transactionType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.TRANSACTION_VALUE));
        WebElement transactionValue= driver.findElement(XPathConstaints.TRANSACTION_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(transactionValue));
        transactionValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BANK_ACCOUNT));
        WebElement bankAccount= driver.findElement(XPathConstaints.BANK_ACCOUNT);
        bankAccount.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ACCOUNT_VALUE));
        WebElement bankAccountValue= driver.findElement(XPathConstaints.ACCOUNT_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(bankAccountValue));
        highlightElement(driver,bankAccountValue);
        bankAccountValue.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CREATE_BTN));
        WebElement createBtn= driver.findElement(XPathConstaints.CREATE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.FINANCE_TABLE));
        WebElement financeTable= driver.findElement(XPathConstaints.FINANCE_TABLE);
        highlightElement(driver,financeTable);

        driver.navigate().refresh();

        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody")));
        Thread.sleep(10000);
        List<WebElement> financesList= driver.findElements(XPathConstaints.FINANCE_LIST);

        System.out.println("Size of list==> "+ financesList.size());

        Thread.sleep(2000);

        for(WebElement finance:financesList)
        {
            WebElement check1_amount= finance.findElement(XPathConstaints.AMOUNT_CHECK);
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
                WebElement btnSection= finance.findElement(XPathConstaints.BTN_SECTION);
                WebElement mapBtn= btnSection.findElement(By.xpath(".//span"));
                wait.until(ExpectedConditions.elementToBeClickable(mapBtn));
                highlightElement(driver,mapBtn);
                mapBtn.click();


                System.out.println("Organization ID is "+ organizationID);
                WebElement organizationInput= btnSection.findElement(XPathConstaints.SEARCH_ORGANIZATION);
                organizationInput.sendKeys(organizationID);


                wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ORGANIZATION_OPTION));
                WebElement organizationOption= driver.findElement(WarehouseFlow.XPathConstants.ORGANIZATION_OPTION);
                wait.until(ExpectedConditions.elementToBeClickable(organizationOption));
                highlightElement(driver,organizationOption);
                organizationOption.click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.OPTIONS_SAVEBTN));
        WebElement saveBtn= driver.findElement(XPathConstaints.OPTIONS_SAVEBTN);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DRAWER));

        WebElement drawer= driver.findElement(XPathConstaints.DRAWER);
        highlightElement(driver,drawer);

        //List<WebElement> options= driver.findElements(XPathConstaints.ORDER_SECTION);
//        WebElement orderSection= driver.findElement(XPathConstaints.ORDER_SECTION);
//        highlightElement(driver,orderSection);
//        orderSection.click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='drop-down-list ng-scope']//li//span[text()='Buyout']")));
//        WebElement buyout=driver.findElement(By.xpath("//ul[@class='drop-down-list ng-scope']//li[2]"));
//        wait.until(ExpectedConditions.elementToBeClickable(buyout));
//        highlightElement(driver,buyout);
//        buyout.click();

        Thread.sleep(3000);

//        highlightElement(driver,options.get(33));
//        options.get(33).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='inner-nav-list']//li[2]")));
//        WebElement buyoutBtn= driver.findElement(By.xpath("//ul[@class='inner-nav-list']//li[2]"));
//        wait.until(ExpectedConditions.elementToBeClickable(buyoutBtn));
//        highlightElement(driver,buyoutBtn);
//        buyoutBtn.click();

//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button.md-raised.md-primary.side-menu-link.md-button.ng-scope.md-ofb-brown-theme.md-ink-ripple")));
//        WebElement buyoutBtn= driver.findElements(By.cssSelector("button.md-raised.md-primary.side-menu-link.md-button.ng-scope.md-ofb-brown-theme.md-ink-ripple")).get(31);
//        wait.until(ExpectedConditions.elementToBeClickable(buyoutBtn));
//        highlightElement(driver,buyoutBtn);
//        buyoutBtn.click();



        //Thread.sleep(8000);


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul")));
//        WebElement sideSection= driver.findElement(By.xpath("//ul"));
//        highlightElement(driver,sideSection);
//        WebElement orderSec= sideSection.findElements(By.xpath(".//ul")).get(7);
//        wait.until(ExpectedConditions.elementToBeClickable(orderSec));
//        highlightElement(driver,orderSec);
//        orderSec.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BUYOUT_OPTION));
//        WebElement buyoutOption= driver.findElement(XPathConstaints.BUYOUT_OPTION);
//        wait.until(ExpectedConditions.elementToBeClickable(buyoutOption));
//        highlightElement(driver,buyoutOption);
//        buyoutOption.click();

        //String buyerName=orgName;

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ORDER_LIST));
        WebElement orderList= driver.findElement(XPathConstaints.ORDER_LIST);
        highlightElement(driver,orderList);

        System.out.println("OrganizationName is--> "+ orgName+"\n\n");
        List<WebElement> buyers= driver.findElements(XPathConstaints.ITEMS_LIST);
        for(WebElement buyer:buyers)
        {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement buyerElement= buyer.findElement(XPathConstaints.BUYER_ELEMENT);
            System.out.println(buyerElement.getText());
            highlightElement(driver,buyerElement);
            if(buyerElement.getText().equalsIgnoreCase(orgName))
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.LINKS_LIST));
        WebElement linksLst= driver.findElement(XPathConstaints.LINKS_LIST);
        highlightElement(driver,linksLst);

        List<WebElement> actionButtons= linksLst.findElements(By.tagName("button"));
        WebElement createDispatchBtn= actionButtons.get(4);
        wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
        highlightElement(driver,createDispatchBtn);
        createDispatchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_BTN));
        WebElement selectSupplier= driver.findElement(XPathConstaints.MULTIPLE_USED_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(selectSupplier));
        highlightElement(driver,selectSupplier);
        selectSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CHECKBOX));
        WebElement checkBox= driver.findElement(XPathConstaints.CHECKBOX);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        List<WebElement> items= driver.findElements(XPathConstaints.ITEMS_LIST);
        for(WebElement item:items)
        {
            highlightElement(driver,item);
            List<WebElement> options= item.findElements(By.xpath(".//td"));

//            checkBox= options.get(0).findElement(By.xpath(".//label"));
//            wait.until(ExpectedConditions.elementToBeClickable(checkBox));
//            highlightElement(driver,checkBox);
//            checkBox.click();

            WebElement pendingAmt= options.get(4).findElement(XPathConstaints.PENDING_QTY);
            String qty= pendingAmt.getText();

            WebElement value= item.findElement(XPathConstaints.MULTIPLE_USED_INPUT);
            value.sendKeys(qty);
        }

    }

    @Test(dependsOnMethods = "createDispatch")
    public void  createShipment() throws IOException, InterruptedException {
//        loadPropFile();
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-ts/dispatch/buyout/all-dispatches/OFB117192210972175-D-1/details");

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.CREATE_SHIPMENT));
        WebElement createShipment= driver.findElements(XPathConstaints.CREATE_SHIPMENT).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(createShipment));
        highlightElement(driver,createShipment);
        createShipment.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CHECKBOX_LABEL));
        WebElement checkBox= driver.findElement(XPathConstaints.CHECKBOX_LABEL);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        WebElement createBtn= driver.findElement(XPathConstaints.DISPATCH_ACTION_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DISPATCH_SECTION));
        WebElement dispatchItemsSection= driver.findElement(XPathConstaints.DISPATCH_SECTION);

        List<WebElement> dispatchItems= dispatchItemsSection.findElements(By.xpath(".//tr"));

        for(int i=0;i<dispatchItems.size();i++)
        {
            WebElement item= dispatchItems.get(i);
            highlightElement(driver,item);

            WebElement dispatchQty= item.findElement(By.xpath(".//td[4]"));
            String qty=dispatchQty.getText();

            List<WebElement> qtyInput= driver.findElements(XPathConstaints.DISPATCHQTY_INPUT);
            qtyInput.get(i).sendKeys(qty);
        }



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SHIPMENT_NEXT_BTN));
        WebElement addToShipmentBtn= driver.findElement(XPathConstaints.SHIPMENT_NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addToShipmentBtn));
        highlightElement(driver,addToShipmentBtn);
        addToShipmentBtn.click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DISPATCH_CART));
        WebElement viewAddedItems= driver.findElement(XPathConstaints.DISPATCH_CART);
        wait.until(ExpectedConditions.elementToBeClickable(viewAddedItems));
        highlightElement(driver,viewAddedItems);
        viewAddedItems.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SHIPMENT_NEXT_BTN));
        WebElement nextBtn= driver.findElement(XPathConstaints.SHIPMENT_NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.DATEPICKER));
        WebElement datePicker= driver.findElements(XPathConstaints.DATEPICKER).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(datePicker));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
        dateInput.sendKeys(date);


        datePicker= driver.findElements(XPathConstaints.DATEPICKER).get(1);
        datePicker.click();

        monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.MULTIPLE_USED_XPATH));
        List<WebElement> options= driver.findElements(XPathConstaints.MULTIPLE_USED_XPATH);
        WebElement fulfillmentSpoc= options.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(fulfillmentSpoc));
        highlightElement(driver,fulfillmentSpoc);
        fulfillmentSpoc.click();

        WebElement fulfillmentSpoc_hint= driver.findElement(XPathConstaints.FULFILLMENTSPOC);
        fulfillmentSpoc_hint.sendKeys("Ayush Chaudhary");
        Thread.sleep(4000);
        fulfillmentSpoc_hint.sendKeys(Keys.ENTER);


        WebElement logisticsMode= options.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(logisticsMode));
        highlightElement(driver,logisticsMode);
        logisticsMode.click();

        WebElement logisticMode_hint= driver.findElement(XPathConstaints.LOGISTIC_MODE_HINT);
        logisticMode_hint.sendKeys("FTL");
        Thread.sleep(4000);
        logisticMode_hint.sendKeys(Keys.ENTER);

        WebElement truckType= options.get(2);
        wait.until(ExpectedConditions.elementToBeClickable(truckType));
        highlightElement(driver,truckType);
        truckType.click();

        WebElement truckType_input= driver.findElement(XPathConstaints.TRUCK_TYPE_INPUT);
        truckType_input.sendKeys("Trailer");
        Thread.sleep(4000);
        truckType_input.sendKeys(Keys.ENTER);


        String mainWindow=driver.getWindowHandle();
        Thread.sleep(3000);


        WebElement createShipmentBtn= driver.findElement(XPathConstaints.CREATE_SHIPMENT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createShipmentBtn));
        highlightElement(driver,createShipmentBtn);
        createShipmentBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOAD_ICON));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.GO_TO_SHIPMENT_BTN));
        WebElement goToShipmentBtn= driver.findElement(XPathConstaints.GO_TO_SHIPMENT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(goToShipmentBtn));
        highlightElement(driver,goToShipmentBtn);
        goToShipmentBtn.click();
    }

    //@Test
    public void verifyShipment() throws InterruptedException, IOException {

        loadPropFile();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stg5-cms.ofbusiness.co.in/#/home/shipment/OFB11717754248507-S-1/summary");
        String mainWindow= driver.getWindowHandle();

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(80));

        //switch to new window
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(mainWindow);
        // change focus to new tab

        //driver.switchTo().window(newTab.get(0));

//        for(String handle: driver.getWindowHandles())
//            driver.switchTo().window(handle);

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



        WebElement itemDetails= driver.findElements(By.xpath("//md-tab-item")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(itemDetails));
        highlightElement(driver,itemDetails);
        itemDetails.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='source-link ng-binding ng-scope']")));
        WebElement redirectLink= driver.findElement(By.xpath("//span[@class='source-link ng-binding ng-scope']"));
        wait.until(ExpectedConditions.elementToBeClickable(redirectLink));
        highlightElement(driver,redirectLink);
        redirectLink.click();


        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);

        Thread.sleep(3000);
        uploadSti(driver);

        Thread.sleep(3000);
        driver.switchTo().window(mainWindow);











        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//md-tab-item")));
        WebElement lspDetails=driver.findElements(By.xpath("//md-tab-item")).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(lspDetails));
        highlightElement(driver,lspDetails);
        lspDetails.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CREATE_BTN));
        WebElement editBtn= driver.findElement(XPathConstaints.CREATE_BTN);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@value='BUYER']")));
        WebElement handler_value= driver.findElement(By.xpath("//md-option[@value='BUYER']"));
        wait.until(ExpectedConditions.elementToBeClickable(handler_value));
        highlightElement(driver,handler_value);
        handler_value.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-radio-button[@class='ng-scope md-ofb-green-theme flex']")));
        List<WebElement> radioGrps= driver.findElements(By.xpath("//md-radio-button[@class='ng-scope md-ofb-green-theme flex']"));

        WebElement transporterType= radioGrps.get(0);
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


        /*
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
        */

        Thread.sleep(1500);



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

        WebElement option1Value= driver.findElement(By.xpath("//md-option[@value='LOADING']"));
        option1Value.click();


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


        WebElement option3= options.get(2).findElement(By.xpath(".//md-select"));
        option3.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@value='false']")));
        WebElement option3Value= driver.findElement(By.xpath("//md-option[@value='false']"));
        wait.until(ExpectedConditions.elementToBeClickable(option3Value));
        highlightElement(driver,option3Value);
        option3Value.click();

        Thread.sleep(1000);
        saveBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right borderRadius15 md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();



        Thread.sleep(1500);



//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item//span[text()='Tracking']")));
//        trackingBtn= driver.findElement(By.xpath("//md-tab-item//span[text()='Tracking']"));
//        wait.until(ExpectedConditions.elementToBeClickable(trackingBtn));
//        highlightElement(driver,trackingBtn);
//        trackingBtn.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']")));
//        addNewUpdateBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']"));
//        highlightElement(driver,addNewUpdateBtn);
//        addNewUpdateBtn.click();
//
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='listValue']")));
//        options= driver.findElements(By.xpath("//span[@class='listValue']"));
//
//        option1= options.get(0).findElement(By.xpath(".//md-select"));
//        option1.click();
//
//        option1Value= driver.findElement(By.xpath("//md-option[@value='LOADING']"));
//        option1Value.click();
//
//
//        msgOption= driver.findElement(By.xpath("//input[@name='message']"));
//        msgOption.sendKeys(prop.getProperty("test-msg"));
//
//        calendarOption= driver.findElement(By.xpath("//span[@class='quickdate-button ng-binding']"));
//        calendarOption.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding ng-scope is-today']")));
//        dateValue= driver.findElement(By.xpath("//td[@class='ng-binding ng-scope is-today']"));
//        wait.until(ExpectedConditions.elementToBeClickable(dateValue));
//        dateValue.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Submit']")));
//        submitDate= driver.findElement(By.xpath("//a[text()='Submit']"));
//        wait.until(ExpectedConditions.elementToBeClickable(submitDate));
//        highlightElement(driver,submitDate);
//        submitDate.click();
//
//
//        option3= options.get(2).findElement(By.xpath(".//md-select"));
//        option3.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@value='false']")));
//        option3Value= driver.findElement(By.xpath("//md-option[@value='false']"));
//        wait.until(ExpectedConditions.elementToBeClickable(option3Value));
//        highlightElement(driver,option3Value);
//        option3Value.click();
//
//        Thread.sleep(1000);
//        saveBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right borderRadius15 md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
//        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
//        highlightElement(driver,saveBtn);
//        saveBtn.click();




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


        mainWindow= driver.getWindowHandle();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item//span[text()='Summary']")));
//        WebElement summaryBtn= driver.findElement(By.xpath("//md-tab-item//span[text()='Summary']"));
//        wait.until(ExpectedConditions.elementToBeClickable(summaryBtn));
//        highlightElement(driver,summaryBtn);
//        summaryBtn.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='listValue linkValue ng-binding']")));
//        WebElement deliveryOutLink= driver.findElement(By.xpath("//span[@class='listValue linkValue ng-binding']"));
//        wait.until(ExpectedConditions.elementToBeClickable(deliveryOutLink));
//        highlightElement(driver,deliveryOutLink);
//        deliveryOutLink.click();
//
//        Thread.sleep(3000);
//        for(String handle: driver.getWindowHandles())
//            driver.switchTo().window(handle);


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary']")));
//        WebElement updateStatusBtn= driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
//        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
//        highlightElement(driver,updateStatusBtn);
//        updateStatusBtn.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
//        WebElement datePicker= driver.findElement(By.className("react-datepicker__input-container"));
//        datePicker.click();
//
//        WebElement monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
//        String month= monthYearBtn.getText().split(" ")[0];
//        String year= monthYearBtn.getText().split(" ")[1];
//        WebElement dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--005.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
//        String date= dateBtn.getText()+" "+ month+" "+year;
//
//        WebElement dateInput= driver.findElement(By.xpath("//input[@placeholder='Select Date']"));
//        dateInput.sendKeys(date);
//
//
//        Thread.sleep(4000);
//
//        WebElement updateBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
//        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
//        highlightElement(driver,updateBtn);
//        updateBtn.click();

/*

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary']")));
        WebElement updateStatusBtn= driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
        WebElement checkBox= driver.findElement(By.xpath("//input[@type='checkbox']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
        WebElement datePicker= driver.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--007.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(By.xpath("//input[@placeholder='Select Date']"));
        dateInput.sendKeys(date);


//        List<WebElement> items= driver.findElements(By.xpath("//div[@class='row tableDataRow']"));
//        for(WebElement item:items)
//        {
//            highlightElement(driver,item);
//            WebElement qtyElement= item.findElement(By.xpath(".//div[@class='col s12 m3']"));
//            highlightElement(driver,qtyElement);
//
//            WebElement  pendingQtyInput= item.findElement(By.xpath(".//div[@class='col s12 m5 hideLabel']"));
//            pendingQtyInput.sendKeys(qtyElement.getText());
//        }

        Thread.sleep(10000);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=' css-1i8o47w']")));
        List<WebElement> parties= driver.findElements(By.xpath("//div[@class=' css-1i8o47w']"));

        WebElement issuingParty= parties.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingParty));
        highlightElement(driver,issuingParty);
        issuingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-issuingParty-option-0']")));
        WebElement issuingParty_value= driver.findElement(By.xpath("//div[@id='react-select-issuingParty-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(issuingParty_value));
        highlightElement(driver,issuingParty_value);
        issuingParty_value.click();

        WebElement receivingParty= parties.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-receivingParty-option-2']")));
        WebElement receivingParty_value= driver.findElement(By.xpath("//div[@id='react-select-receivingParty-option-2']"));
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty_value));
        highlightElement(driver,receivingParty_value);
        receivingParty_value.click();

        saveBtn=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();


        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
        WebElement updateBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();




        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary']")));
        updateStatusBtn= driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__input-container")));
        datePicker= driver.findElement(By.className("react-datepicker__input-container"));
        datePicker.click();

        monthYearBtn= driver.findElement(By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown"));
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--007.react-datepicker__day--keyboard-selected.react-datepicker__day--today"));
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(By.xpath("//input[@placeholder='Select Date']"));
        dateInput.sendKeys(date);


        Thread.sleep(4000);

        updateBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();


        driver.switchTo().window(mainWindow);


*/


        Thread.sleep(1500);

/*
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


*/








        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item//span[text()='Invoices']")));
        WebElement invoiceBtn= driver.findElement(By.xpath("//md-tab-item//span[text()='Invoices']"));
        wait.until(ExpectedConditions.elementToBeClickable(invoiceBtn));
        highlightElement(driver,invoiceBtn);
        invoiceBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.OPTIONS_SAVEBTN));
        WebElement invoiceOptions= driver.findElements(XPathConstaints.OPTIONS_SAVEBTN).get(2);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement digitalSignBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(digitalSignBtn));
        highlightElement(driver,digitalSignBtn);
        digitalSignBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='checkboxCustom']")));
        WebElement checkBox= driver.findElement(By.xpath("//span[@class='checkboxCustom']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.SUBMIT_BTN));
        WebElement digitallySignBtn= driver.findElements(XPathConstaints.SUBMIT_BTN).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(digitallySignBtn));
        highlightElement(driver,digitallySignBtn);
        digitallySignBtn.click();

        Thread.sleep(6000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement verifyBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(verifyBtn));
        highlightElement(driver,verifyBtn);
        verifyBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='checkboxCustom']")));
        checkBox= driver.findElement(By.xpath("//span[@class='checkboxCustom']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();


        Thread.sleep(6000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        verifyBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
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


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.MULTIPLE_USED_BTN));
        WebElement seeShipment= driver.findElements(XPathConstaints.MULTIPLE_USED_BTN).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(seeShipment));
        highlightElement(driver,seeShipment);
        seeShipment.click();

        for(String handle:driver.getWindowHandles())
            driver.switchTo().window(handle);





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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-radio-button[@value='WITHOUT_PROBLEM']")));
        WebElement shipmentDeliveredRadioBtn= driver.findElement(By.xpath("//md-radio-button[@value='WITHOUT_PROBLEM']"));
        wait.until(ExpectedConditions.elementToBeClickable(shipmentDeliveredRadioBtn));
        shipmentDeliveredRadioBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-radio-button[@value='UPLOAD']")));
        WebElement uploadPOD_radioBtn= driver.findElement(By.xpath("//md-radio-button[@value='UPLOAD']"));
        wait.until(ExpectedConditions.elementToBeClickable(uploadPOD_radioBtn));
        uploadPOD_radioBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default uploadBtn']")));
        WebElement uploadBtn= driver.findElement(By.xpath("//button[@class='btn btn-default uploadBtn']"));
        wait.until(ExpectedConditions.elementToBeClickable(uploadBtn));
        uploadBtn.click();

        uploadBtn.sendKeys(prop.getProperty("file-path"));



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

        WebElement publishBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(publishBtn));
        highlightElement(driver,publishBtn);
        publishBtn.click();
    }



    public void uploadSti(WebDriver driver) throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.UPLOAD_STI));
        WebElement uploadSti= driver.findElement(XPathConstaints.UPLOAD_STI);

        WebElement uploadStiFile= uploadSti.findElement(By.xpath(".//input"));
        uploadStiFile.sendKeys(prop.getProperty("file-path"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tfid-0-2']")));
        WebElement invoiceInput= driver.findElement(By.xpath("//input[@id='tfid-0-2']"));
        invoiceInput.sendKeys(String.valueOf(generateInvoiceNumber()));

        WebElement datePicker= driver.findElement(XPathConstaints.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstaints.INVOICE_DATE);
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.REDIRECT_BLOCK));
        WebElement redirectBlock= driver.findElement(XPathConstaints.REDIRECT_BLOCK);
        wait.until(ExpectedConditions.elementToBeClickable(redirectBlock));
        highlightElement(driver,redirectBlock);
        redirectBlock.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.ITEMLIST));
        List<WebElement> itemList= driver.findElements(XPathConstaints.ITEMLIST);
        for(WebElement item:itemList)
        {
            highlightElement(driver,item);

            WebElement checkBox= item.findElement(By.xpath(".//label//input"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);

            WebElement quantityRemainingElement= item.findElement(By.xpath(".//div[@class='qtyChip'][2]//span[@class='chip-value']"));
            highlightElement(driver,quantityRemainingElement);
            String qty= quantityRemainingElement.getText();

            WebElement quantityInput= item.findElement(XPathConstaints.QTY_INPUT);
            highlightElement(driver,quantityInput);
            quantityInput.sendKeys(qty);

            Thread.sleep(2000);

            WebElement radioGroup= item.findElement(XPathConstaints.RADIO_BTN);
            highlightElement(driver,radioGroup);

            WebElement radioBtn= radioGroup.findElement(By.xpath(".//label"));
            radioBtn.click();
        }



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement doneBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
        highlightElement(driver, doneBtn);
        doneBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOAD_ICON));
        Thread.sleep(1500);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement nextBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='heading']")));
        WebElement shipment= driver.findElement(By.xpath("//div[@class='heading']"));
        wait.until(ExpectedConditions.elementToBeClickable(shipment));
        highlightElement(driver,shipment);
        shipment.click();

        WebElement item= driver.findElement(By.xpath("//div[@class='stiGroupItemBlock-item']"));
        wait.until(ExpectedConditions.elementToBeClickable(item));
        highlightElement(driver,item);

        WebElement viewDetails= item.findElement(XPathConstaints.ITEM_CART);
        wait.until(ExpectedConditions.elementToBeClickable(viewDetails));
        highlightElement(driver,viewDetails);
        viewDetails.click();

        //You need to do here









        WebElement submitBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();
    }


}
