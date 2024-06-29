import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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

public class WarehouseFlow {
    class XPathConstants
    {
        public static final By LINKELEMENT= By.xpath("//span[@class='pointerCursor']");
        public static final By DRAWER= By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex");
        public static final By DRAWER_OPTIONS= By.xpath("//button[@class='md-raised md-primary side-menu-link md-button ng-scope md-ofb-brown-theme md-ink-ripple']");
        public static final By DRAWER_ACTIONS = By.xpath("//ul[@class='drop-down-list ng-scope']//li");
        public static final By ADD_NEW_WAREHOUSE= By.xpath("//button[@class='btn btn-primary addNewWarehouseBtn']");
        public static final By OFB_ENTITY= By.xpath("//div[@id='ofbEntityId-tfid-0-1']");
        public static final By OFB_ENTITY_VALUE= By.xpath(".//div[@id='react-select-ofbEntityId-option-0']");
        public static final By OPTIONS= By.xpath("//div[@class=' css-17vhrl4']");
        public static final By BILLING_ADDRESS= By.xpath("//div[@id='react-select-ofbEntityBillingAddressId-option-0']");
        public static final By WAREHOUSE_NICK_NAME= By.xpath("//input[@id='tfid-0-3']");
        public static final By WAREHOUSE_ADDRESS= By.xpath("//div[@id='react-select-warehouseAddress-option-0']");
        public static final By CONTACT_TYPE_VALUE= By.xpath("//div[@id='react-select-contactPersonList[0][contactPersonType]-option-0']");
        public static final By INPUT_FIELDS= By.xpath("//input[@id='tfid-0-7']");
        public static final By INPUT_FIELDS2 = By.xpath("//input[@id='tfid-0-8']");
        public static final By INPUT_FIELDS_RENT_CREDIT= By.xpath("//input[@id='tfid-0-10']");
        public static final By SECURITY_AMT= By.xpath("//input[@id='tfid-0-11']");
        public static final By RADIO_GRP= By.xpath("//div[@class='radio-group']");
        public static final By RADIO_LABEL= By.xpath(".//label[@class='radioLabel']");
        public static final By PAID_DURATION= By.xpath("//div[@class='actionBlockTop']");
        public static final By PAY_DURATION_TYPE= By.xpath("//div[@id='react-select-toBePaidOnDay-option-0']");
        public static final By SUBMIT_BTN= By.xpath("//button[@class='btn btn-primary']");
        public static final By UPLOAD_AGREEMENT= By.xpath("//input[@id='upload-agreement']");
        public static final By WAREHOUSELIST= By.xpath("//div[@class='cardItemWrapper wareHouseItemList']");
        public static final By LIST_ITEMS= By.xpath(".//div[@class='listItemRow']");
        public static final By DETAILS_BTN= By.xpath(".//span[@class='detailTabIndicator']");
        public static final By ACTION_BLOCKS= By.xpath("//div[@class='actionsListBlock']");
        public static final By ACTION_BTN= By.xpath(".//div[@class='actionItem']");
        public static final By SUPPLIER_NAME= By.xpath("//input[@id='selectSupplier-input-tfid-0-1']");
        public static final By SUPPLIER_NAME_VALUE= By.xpath("//div[@id='react-select-selectSupplier-option-0']");
        public static final By BILLING_ADDRESS_VALUE= By.xpath("//div[@class=' css-1m5nn3x']//div");
        public static final By ACTION_ITEM= By.xpath("//div[@class='actionItem']");
        public static final By PICKUPADDRESS_VALUE= By.xpath("//div[@class=' css-1ul4jvx-option']");
        public static final By INCENTIVE_REASON= By.id("reason-tfid-0-0");
        public static final By INCENTIVE_REASON_VALUE= By.id("react-select-reason-option-0");
        public static final By INCENTIVE_LEVEL=By.xpath("//span[text()='Item Level']");
        public static final By ONDELIVERY= By.xpath("//input[@id='tfid-0-9']");
        public static final By SCROLLTO= By.xpath("//div[text()='Other Configurations']");
        public static final By MULTIPLE_USED_XPATH= By.xpath("//div[@class=' css-1i8o47w']");
        public static final By OFB_ADDRESS_VALUE= By.xpath("//div[@id='react-select-ofbEntityAddressId-option-2']");
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
        public static final By ACTUAL_INCENTIVE= By.xpath("//input[@name='actualAmount']");
        public static final By VERIFIER= By.xpath("//input[@id='verifierName-input-tfid-0-0']");
        public static final By VERIFIER_NAME= By.xpath("//div[@id='react-select-verifierName-option-0']");
        public static final By SEND_FOR_VERIFICATION_BTN= By.xpath("//button[text()='Send for Verification ']");
        public static final By PO_ELEMENT= By.xpath("//span[@class='backTxt']");
        public static final By ELLIPSIS_TEXT= By.xpath("//span[@class='value ellipsisText linkTxt']");
        public static final By BTN_XPATH= By.cssSelector("button.btn.btn-primary");

        public static final By INVOICE_AMOUNT= By.id("tfid-0-5");
        public static final By MULTIPLE_USED_BTN= By.xpath("//button[@class='btn btn-default']");

        public static final By NAV_ITEMS= By.xpath("//ul[@class='nav-list']");
        public static final By SUPPLIER_PO= By.xpath(".//ul[@class='inner-nav-list']//li");
        public static final By SEARCH_FIELD= By.xpath("//input[@class='form-control searchTxtField']") ;
        public static final By REQUESTED_PO= By.xpath("//div[@class='supplierWrapper']");
        public static final By APPROVEBTN= By.xpath(".//button[@class='btn btn-primary approveBtn']");
        public static final By SUBMIT_BTN2= By.xpath("//div[@class='actionWrapper']//button[@class='btn btn-primary']");
        public static final By LOADING= By.xpath("//span[@class='loading-icon m-r-10 hide']");
        public static final By SHARE_GRN= By.xpath("//button[text()='Share GRN']");
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
        public static final By ADDRESS_VALUE= By.xpath("//div[@id='react-select-ofbEntityAddress-option-0']");
        public static final By UPDATE_SUBMIT_BTN= By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']");
        public static final By LOADING_ICON= By.xpath("//div[@class='modal']//span[@class='loading-icon m-r-10 hide']");
        public static final By ITEM_SPECIFICATIONS= By.xpath("//div[@class='optHeader']//span");
        public static final By SUBMIT_QUOTE= By.xpath("//button[text()='Submit Buyer Quote ']");

        public static final By SUPPLIER_QUOTE= By.className("supplierQuote");
        public static final By VIEW_SUPPLIER_DETAILS= By.xpath("//div[@class='optHeader']//span[text()='View Supplier Details ']");

        public static final By TOAST_ELEMENT= By.xpath("//div[@class='Toastify__toast-body']");
        public static final By MODAL_CONTENT= By.xpath("//div[@class='modalContent']");
        public static final By CHECKBOXES= By.xpath("//div[@class='checkbox-group']//span");

        public static final By PAYMENT_STATUS= By.xpath("//span[@class='dropTitle']");
        public static final By CHANGE_STATUS= By.xpath("//div[@class='name btn btn-default awaitingBtn']");
        public static final By NEW_STATUS_BTN= By.xpath("//div[@class='dropDownItem']");

        public static final By LOT_CONTAINER= By.xpath("//div[@class='lotDetailContainer']");
        public static final By INPUTS= By.xpath(".//input[@id='tfid-0-0']");
        public static final By ASSIGN_TO= By.xpath("//input[@id='assignedTo-input-tfid-0-1']");
        public static final By ASSIGN_TO_HINT= By.xpath("//div[@id='react-select-assignedTo-option-1']");
        public static final By FULFILLMENT_SPOC= By.xpath("//input[@id='ofbFulfillmentSpoc-input-tfid-0-2']");
        public static final By CANCEL_BTN= By.xpath("//button[text()='Cancel']");
        public static final By SAVE_BTN= By.xpath("//button[text()='Save']");
        public static final By SAVEBTN= By.cssSelector("button.btn.btn-primary.saveBtn");
        public static final By SEND_FOR_APPROVAL= By.xpath("//button[text()='Send for Approval']");
        public static final By CHECK_BOX= By.xpath("//input[@class='enable']");
        public static final By EDITBTN= By.cssSelector("button.btn.btn-default.editBtn");


        public static final By EDIT_BTN= By.xpath(".//div[@class='button-edit material-icons']");
        public static final By STOCKDELIVERY_PENDING= By.xpath(".//div[@class='col s12 m3']");
        public static final By CONTAINER= By.xpath("//div[@class='tableContainer']//tbody");
        public static final By PRODUCTS= By.xpath("//div[@class='l2-category-group ']");
        public static final By SHOW_MORE_BTN= By.xpath(".//i[@class='material-icons']");
        public static final By CARTBTN= By.xpath("//div[@class='cartBtn ']");
        public static final By UPLOAD_STI= By.xpath("//label[@class='uploadButton undefined']");
        public static final By INVOICE_INPUT= By.id("tfid-0-3");
        public static final By DATEPICKER= By.className("react-datepicker__input-container");
        public static final By MONTH_YEAR_BTN= By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown");
        public static final By CURRDATE= By.xpath("//div[contains(@class, 'react-datepicker__day--today')]");
        public static final By INVOICE_DATE= By.xpath("//input[@placeholder='Select invoice date']");
        public static final By REDIRECT_BLOCK= By.xpath("//button[@class='redirectBlock']");
        public static final By ITEMLIST= By.xpath("//div[@class='lineItemCard']");
        public static final By CHECKBOX_LABEL= By.xpath("//label[@class='checkboxLabel']");
        public static final By REMAINING_QTY= By.xpath(".//span[@class='chip-value']");
        public static final By QTY_INPUT= By.xpath(".//input[@name='otherCharges']");
        public static final By RADIO_BTN= By.xpath(".//div[@class='radio-group']");
        public static final By ISSUING_PARTY= By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-0']");
        public static final By RECEIVING_PARTY= By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-1']");
        public static final By FULFILLMENT_SPOC_VALUE= By.xpath("//div[@id='react-select-ofbFulfillmentSpoc-option-1']");
        public static final By UPLOADDOC= By.xpath("//label[@class='uploadButton actionItem ']");
        public static final By DOCTYPE_VALUE= By.xpath("//div[@id='react-select-documentType-option-6']");
        public static final By ISSUING_PARTY_VALUE= By.xpath("//div[@id='react-select-issuingParty-option-1']");
        public static final By RECEIVING_PARTY_VALUE= By.xpath("//div[@id='react-select-receivingParty-option-0']");
        public static final By BILLING_ADD_VALUE= By.xpath("//label[@class='radioLabel']");
        public static final By BILLINGADDRESS= By.id("react-select-billingAddress-option-0");
        public static final By PICKUPADDRESS= By.id("react-select-pickupAddress-option-0");
        public static final By COMPLETE_DELIVERY_IN= By.xpath("//span[@class='value txt-blue']");
        public static final By LSPNAME_HINT= By.xpath("//input[@id='selectLsp-input-tfid-0-1']");
        public static final By LSPNAME_VALUE= By.xpath("//div[@id='react-select-selectLsp-option-0']");
        public static final By GST_VALUE= By.xpath("//div[@id='react-select-lspGst-option-0']");

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
        public static final By DISPATCH_ACTION_BTN= By.cssSelector("button.btn.btn-primary.dispatchActionBtn");
        public static final By DISPATCH_SECTION= By.xpath("//div[@class='dispatchColumns']//tbody");
        public static final By DISPATCHQTY_INPUT= By.xpath("//input[@class='formControl Dispatch__formControl--les6J']");
        public static final By SHIPMENT_NEXT_BTN= By.cssSelector("button.Dispatch__btn--vR5sf.btn-primary");
        public static final By DISPATCH_CART= By.xpath("//div[@class='Dispatch__cartBtn--ABWNt']");
        public static final By UPDATE_STATUS= By.xpath("//button[text()='Update Status']");
        public static final By AGREEMENT_CHECKBOX= By.xpath("//input[@id='agreementCheckbox']");
        public static final By SHIPMENT_AMT= By.xpath("//div[@class='amt']");
        public static final By CAPTCHA= By.xpath("//input[@class='inputCaptcha']");

        public static final By LOADINGICON= By.xpath("//div[@class='modalFooter']//span[@class='loading-icon m-r-10 hide']");
        public static final By NEXT_BTN= By.xpath("//button[@class='btn btn-primary' and contains(text(),'Next')]");
        public static final By EXPECTED_QTY= By.xpath(".//div[@class='col s12 m2']");
        public static final By DATEINPUT= By.xpath("//input[@placeholder='Start Date']");
        public static final By DATE_INPUT1= By.className("react-datepicker-ignore-onclickoutside");
        public static final By DATEINPUT2= By.xpath("//input[@placeholder='End Date']");
        public static final By DATEINPUT3= By.xpath("//input[@placeholder='Select end date']");

        public static final By PERSON_HINT= By.xpath("//input[@id='assignedTo-input-tfid-0-0']");
        public static final By PERSON_VALUE= By.xpath("//div[@id='react-select-assignedTo-option-0']");
        public static final By SHARE_BTN= By.xpath("//button[text()='Share with 1 person(s)']");

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
        public static final By ORDER_SECTION= By.cssSelector("button.md-raised.md-primary.side-menu-link.md-button.ng-scope.md-ofb-brown-theme.md-ink-ripple");
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
    private static String poNumber;

    public static void loadPropFile() throws IOException {
        prop = new Properties();
        FileInputStream fs = new FileInputStream("/home/yash/IdeaProjects/OasysUi/config.properties");
        prop.load(fs);

    }

    public static void highlightTab(WebDriver driver)
    {
        try {
            // JavaScript to highlight the body of the page
            String highlightScript = "document.body.style.border = '5px solid red';";

            // Execute the JavaScript to highlight the current tab
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(highlightScript);

            // Wait to visually confirm the highlighting
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATEINPUT);
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

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

//        for(String handle:driver.getWindowHandles())
//            driver.switchTo().window(handle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.LINKELEMENT));
        WebElement link_Element= driver.findElement(XPathConstants.LINKELEMENT);
        wait.until(ExpectedConditions.elementToBeClickable(link_Element));
        highlightElement(driver,link_Element);
        link_Element.click();

        for(String handle:driver.getWindowHandles())
                driver.switchTo().window(handle);

        highlightTab(driver);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        Thread.sleep(4000);
        String url= driver.getCurrentUrl();
        organizationID= url.split("/")[4];
        System.out.println("Url is--->" + url);
        System.out.println("Organization id is-->" + organizationID);
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


    @Test(dependsOnMethods = "setUp")
    public void  handleWareHouseTest() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(80));
        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DRAWER));

        WebElement drawer= driver.findElement(XPathConstants.DRAWER);
        highlightElement(driver,drawer);

        List<WebElement> options= driver.findElements(XPathConstants.DRAWER_OPTIONS);
        WebElement warehouseSection= options.get(4);
        wait.until(ExpectedConditions.elementToBeClickable(warehouseSection));
        highlightElement(driver,warehouseSection);
        warehouseSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DRAWER_ACTIONS));
        WebElement warehouseEntity= driver.findElement(XPathConstants.DRAWER_ACTIONS);
        wait.until(ExpectedConditions.elementToBeClickable(warehouseEntity));
        highlightElement(driver,warehouseEntity);
        warehouseEntity.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ADD_NEW_WAREHOUSE));

        WebElement addNewWarehouseBtn= driver.findElement(XPathConstants.ADD_NEW_WAREHOUSE);
        wait.until(ExpectedConditions.elementToBeClickable(addNewWarehouseBtn));
        highlightElement(driver,addNewWarehouseBtn);
        addNewWarehouseBtn.click();

    }

    @Test(dependsOnMethods = "handleWareHouseTest")
    public void addnewWarehouseTest() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.OFB_ENTITY));
        WebElement ofbEntity= driver.findElement(XPathConstants.OFB_ENTITY);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntity));
        highlightElement(driver,ofbEntity);
        ofbEntity.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.OFB_ENTITY_VALUE));
        WebElement ofbEntityValue= ofbEntity.findElement(XPathConstants.OFB_ENTITY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntityValue));
        ofbEntity_Value= ofbEntityValue.getText();
        System.out.println("OfbEntityValue is "+ ofbEntity_Value);
        highlightElement(driver,ofbEntityValue);
        ofbEntityValue.click();

        WebElement billingAddress= driver.findElements(XPathConstants.OPTIONS).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddress));
        highlightElement(driver,billingAddress);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BILLING_ADDRESS));
        WebElement billingAddressValue= driver.findElement(XPathConstants.BILLING_ADDRESS);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        WebElement warehouseNickName= driver.findElement(XPathConstants.WAREHOUSE_NICK_NAME);
        warehouseNickName.sendKeys(prop.getProperty("warehouse-nick-name"));

        WebElement warehouseAddress= driver.findElements(XPathConstants.OPTIONS).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(warehouseAddress));
        highlightElement(driver,warehouseAddress);
        warehouseAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.WAREHOUSE_ADDRESS));
        WebElement warehouseAddressValue= driver.findElement(XPathConstants.WAREHOUSE_ADDRESS);
        wait.until(ExpectedConditions.elementToBeClickable(warehouseAddressValue));
        highlightElement(driver,warehouseAddressValue);
        warehouseAddressValue.click();

        WebElement contactType= driver.findElements(XPathConstants.OPTIONS).get(3);
        wait.until(ExpectedConditions.elementToBeClickable(contactType));
        highlightElement(driver,contactType);
        contactType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CONTACT_TYPE_VALUE));
        WebElement contactTypeValue= driver.findElement(XPathConstants.CONTACT_TYPE_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(contactTypeValue));
        highlightElement(driver,contactTypeValue);
        contactTypeValue.click();

        WebElement personName= driver.findElement(XPathConstants.INPUT_FIELDS);
        personName.sendKeys(prop.getProperty("person-name"));

        WebElement phoneInput= driver.findElement(XPathConstants.INPUT_FIELDS2);
        phoneInput.sendKeys(prop.getProperty("phone"));

        WebElement rentInput= driver.findElement(XPathConstants.INPUT_FIELDS_RENT_CREDIT);
        rentInput.sendKeys("10");

        WebElement securityAmount= driver.findElement(XPathConstants.SECURITY_AMT);
        securityAmount.sendKeys("10");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.RADIO_GRP));
        List<WebElement> radioGroups= driver.findElements(XPathConstants.RADIO_GRP);
        WebElement rentFreqRadioGrp= radioGroups.get(1);
        highlightElement(driver,rentFreqRadioGrp);

        WebElement rentFreqValue= rentFreqRadioGrp.findElement(XPathConstants.RADIO_LABEL);
        rentFreqValue.click();

        WebElement paidDuration= driver.findElement(XPathConstants.PAID_DURATION);
        wait.until(ExpectedConditions.elementToBeClickable(paidDuration));
        highlightElement(driver,paidDuration);
        paidDuration.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.OPTIONS));
        driver.findElements(XPathConstants.OPTIONS).get(4).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PAY_DURATION_TYPE));
        WebElement payDurationType= driver.findElement(XPathConstants.PAY_DURATION_TYPE);
        wait.until(ExpectedConditions.elementToBeClickable(payDurationType));
        highlightElement(driver,payDurationType);
        payDurationType.click();

        Actions actions= new Actions(driver);
        Thread.sleep(3000);
        actions.scrollByAmount(0,15000).perform();


        Thread.sleep(4000);

        WebElement uploadAggreement= driver.findElement(XPathConstants.UPLOAD_AGREEMENT);
        uploadAggreement.sendKeys(prop.getProperty("file-path"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", datePicker);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(datePicker));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATEINPUT);
        dateInput.sendKeys(date);

        Thread.sleep(2000);

        WebElement endDatePicker= driver.findElements(XPathConstants.DATEPICKER).get(1);
        endDatePicker.click();

        monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XPathConstants.CURRDATE);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XPathConstants.DATEINPUT2);
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement submitWarehouse= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitWarehouse));
        highlightElement(driver,submitWarehouse);
        submitWarehouse.click();

    }

    @Test(dependsOnMethods = "addnewWarehouseTest")
    public void handleCreatedWarehouse() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.WAREHOUSELIST));

        driver.navigate().refresh();
        Thread.sleep(5000);

        WebElement warehouseList= driver.findElement(XPathConstants.WAREHOUSELIST);
        highlightElement(driver,warehouseList);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.LIST_ITEMS));
        List<WebElement> warehouseItems= warehouseList.findElements(VirtualWarehouse.XpathConstants.LIST_ITEMS);
        System.out.println(warehouseItems.size()+" lengthed list");

        Thread.sleep(1500);


        for(WebElement item:warehouseItems)
        {
            highlightElement(driver,item);
            WebElement ofbEntity= item.findElements(By.xpath(".//span")).get(1);
            highlightElement(driver,ofbEntity);
            if(ofbEntity.getText().equalsIgnoreCase(ofbEntity_Value))
            {
                WebElement detailsBtn= item.findElement(XPathConstants.DETAILS_BTN);
                wait.until(ExpectedConditions.elementToBeClickable(detailsBtn));
                detailsBtn.click();
                break;
            }
        }
    }

    @Test(dependsOnMethods = "handleCreatedWarehouse")
    public void issuePO() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_BLOCKS));
        WebElement actionsBlock= driver.findElements(XPathConstants.ACTION_BLOCKS).get(1);
        highlightElement(driver,actionsBlock);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_BTN));
        WebElement issuePOBtn= actionsBlock.findElement(XPathConstants.ACTION_BTN);
        highlightElement(driver,issuePOBtn);
        issuePOBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.OPTIONS));
        WebElement supplierName= driver.findElement(XPathConstants.OPTIONS);
        wait.until(ExpectedConditions.elementToBeClickable(supplierName));
        highlightElement(driver,supplierName);
        supplierName.click();

        WebElement supplierName_hint= driver.findElement(XPathConstants.SUPPLIER_NAME);
        supplierName_hint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUPPLIER_NAME_VALUE));
        WebElement supplierValue= driver.findElement(XPathConstants.SUPPLIER_NAME_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(supplierValue));
        highlightElement(driver,supplierValue);
        supplierValue.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.OPTIONS));
        List<WebElement> supplierOptions= driver.findElements(XPathConstants.OPTIONS);

        WebElement billingAddress= supplierOptions.get(1);
        highlightElement(driver,billingAddress);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BILLING_ADDRESS_VALUE));
        WebElement billingAddressValue= driver.findElement(XPathConstants.BILLING_ADDRESS_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        WebElement pickupAddress= supplierOptions.get(2);
        highlightElement(driver,pickupAddress);
        pickupAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PICKUPADDRESS_VALUE));
        WebElement pickupAddressValue= driver.findElement(XPathConstants.PICKUPADDRESS_VALUE);
        highlightElement(driver,pickupAddressValue);
        pickupAddressValue.click();

        List<WebElement> radioGroups= driver.findElements(XPathConstants.RADIO_GRP);

        WebElement radiogroup= radioGroups.get(3);
        highlightElement(driver,radiogroup);

        WebElement radioGrpValue= radiogroup.findElement(By.xpath(".//label"));
        radioGrpValue.click();

        WebElement incentiveReason= driver.findElement(XPathConstants.INCENTIVE_REASON);
        wait.until(ExpectedConditions.visibilityOf(incentiveReason));
        highlightElement(driver,incentiveReason);
        incentiveReason.click();

        WebElement incentiveReasonValue= driver.findElement(XPathConstants.INCENTIVE_REASON_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(incentiveReasonValue));
        highlightElement(driver,incentiveReasonValue);
        incentiveReasonValue.click();

        driver.findElement(By.xpath("//span[text()='Incoming']")).click();

        driver.findElement(By.xpath("//span[text()='Without Tax']")).click();

        WebElement incentiveLevel= driver.findElements(XPathConstants.INCENTIVE_LEVEL).get(1);
        incentiveLevel.click();



//        Thread.sleep(7000);
//
//        Actions actions= new Actions(driver);
//        actions.scrollByAmount(0,10000).perform();
//
//        Thread.sleep(5000);

        WebElement scrollToElement= driver.findElement(XPathConstants.SCROLLTO);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToElement);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement ofbEntityAddress= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntityAddress));


        Thread.sleep(2000);
        highlightElement(driver,ofbEntityAddress);
        ofbEntityAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.OFB_ADDRESS_VALUE));
        WebElement ofbAddressvalue= driver.findElement(XPathConstants.OFB_ADDRESS_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(ofbAddressvalue));
        highlightElement(driver,ofbAddressvalue);
        ofbAddressvalue.click();

        Thread.sleep(5000);
        setCurrDate(driver);

        WebElement addItemsBtn= driver.findElement(XPathConstants.ADD_ITEMS_BTN);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", incentiveLevel);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(addItemsBtn));
        highlightElement(driver,addItemsBtn);
        addItemsBtn.click();


    }

    @Test(dependsOnMethods = "issuePO")
    public void addItems() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ITEMS_SECTION));
        WebElement itemsSection= driver.findElement(XPathConstants.ITEMS_SECTION);
        List<WebElement> items= driver.findElements(XPathConstants.ITEMS);
        highlightElement(driver,items.get(2));

        WebElement item1= items.get(2).findElement(XPathConstants.ITEM_CART);
        wait.until(ExpectedConditions.elementToBeClickable(item1));
        highlightElement(driver,item1);
        item1.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.VARIETY_SECTION));
        WebElement varietySection= driver.findElement(XPathConstants.VARIETY_SECTION);
        highlightElement(driver,varietySection);

        List<WebElement> varieties= driver.findElements(XPathConstants.ITEMS);
        for(int i=1;i<=2;i++)
        {
            WebElement variety1= varieties.get(i);
            highlightElement(driver,variety1);
            WebElement addToCartBtn= variety1.findElement(XPathConstants.ITEM_CART);
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
            highlightElement(driver,addToCartBtn);
            addToCartBtn.click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CART_BTN));
        WebElement cartBtn= driver.findElement(XPathConstants.CART_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
        highlightElement(driver,cartBtn);
        cartBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.SUBCATEGORY_FORM));

        List<WebElement> subcategoryForms= driver.findElements(XPathConstants.SUBCATEGORY_FORM);

        Thread.sleep(4000);
        for(WebElement subcategoryForm:subcategoryForms)
        {
            WebElement itemQty= subcategoryForm.findElements(XPathConstants.QTY_BASERATE).get(0);
            itemQty.clear();
            itemQty.sendKeys("100");

            WebElement units= subcategoryForm.findElements(XPathConstants.UNITS).get(0);
            highlightElement(driver,units);
            units.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UNIT_VALUE));
            WebElement unitValue= subcategoryForm.findElement(XPathConstants.UNIT_VALUE);
            wait.until(ExpectedConditions.elementToBeClickable(unitValue));
            highlightElement(driver,unitValue);
            unitValue.click();

            WebElement baserate= subcategoryForm.findElements(XPathConstants.QTY_BASERATE).get(1);
            baserate.sendKeys("100");

            WebElement gstDropDown= subcategoryForm.findElement(XPathConstants.GST_DROPDOWN);
            highlightElement(driver,gstDropDown);
            gstDropDown.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.GST_VAL));
            WebElement gstValue= subcategoryForm.findElement(XPathConstants.GST_VAL);
            wait.until(ExpectedConditions.elementToBeClickable(gstValue));
            highlightElement(driver,gstValue);
            gstValue.click();

            WebElement editBtn= subcategoryForm.findElement(XPathConstants.EDIT_BTN);
            wait.until(ExpectedConditions.elementToBeClickable(editBtn));
            editBtn.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.RADIO_GRP));
            WebElement radioGrp= driver.findElement(XPathConstants.RADIO_GRP);
            highlightElement(driver,radioGrp);
            radioGrp.findElement(By.xpath(".//label")).click();

            WebElement actualIncentive= driver.findElement(XPathConstants.ACTUAL_INCENTIVE);
            actualIncentive.sendKeys("100");

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
            WebElement saveBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
            wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
            highlightElement(driver,saveBtn);
            saveBtn.click();
        }

        Thread.sleep(3000);
        WebElement submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SCROLLTO));
        WebElement scrollTo= driver.findElement(XPathConstants.SCROLLTO);


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollTo);
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.INPUT_FIELDS));
        WebElement advanceAmount= driver.findElement(XPathConstants.INPUT_FIELDS);
        advanceAmount.sendKeys("100");

        WebElement onDispatchAmount= driver.findElement(XPathConstants.INPUT_FIELDS2);
        advanceAmount.sendKeys("0");

        WebElement onDelivery= driver.findElement(XPathConstants.ONDELIVERY);
        advanceAmount.sendKeys("0");

        WebElement credit= driver.findElement(XPathConstants.INPUT_FIELDS_RENT_CREDIT);
        advanceAmount.sendKeys("0");


        Thread.sleep(3000);
        submitBtn= driver.findElements(XPathConstants.SUBMIT_BTN).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement verifierOption= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(verifierOption));
        highlightElement(driver,verifierOption);
        verifierOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.VERIFIER));
        WebElement verifier_hint= driver.findElement(XPathConstants.VERIFIER);
        verifier_hint.sendKeys("Anshul Jain");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.VERIFIER_NAME));
        WebElement verifier_name= driver.findElement(XPathConstants.VERIFIER_NAME);
        wait.until(ExpectedConditions.elementToBeClickable(verifier_name));
        highlightElement(driver,verifier_name);
        verifier_name.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.SEND_FOR_VERIFICATION_BTN));
        WebElement sendForVerificationBtn= driver.findElement(XPathConstants.SEND_FOR_VERIFICATION_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(sendForVerificationBtn));
        highlightElement(driver,sendForVerificationBtn);
        sendForVerificationBtn.click();
        Thread.sleep(10000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PO_ELEMENT));
        WebElement poNumberElement= driver.findElement(XPathConstants.PO_ELEMENT);
        poNumber = poNumberElement.getText();
    }

    @Test(dependsOnMethods = "addItems")
    public void verifyPO() throws IOException, InterruptedException {
        addCookie(driver,prop.getProperty("supplier-auth-token"));

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.NAV_ITEMS));
        WebElement verifySection= driver.findElements(XPathConstants.NAV_ITEMS).get(8);
        highlightElement(driver,verifySection);
        verifySection.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.SUPPLIER_PO));
        WebElement supplierPOBtn= verifySection.findElement(XPathConstants.SUPPLIER_PO);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", supplierPOBtn);
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(supplierPOBtn));
        highlightElement(driver,supplierPOBtn);
        supplierPOBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SEARCH_FIELD));
        WebElement searchField= driver.findElement(XPathConstants.SEARCH_FIELD);
        searchField.sendKeys(poNumber);

        Thread.sleep(3000);
        searchField.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='supplierWrapper']")));
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
        }*/

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.REQUESTED_PO));
        WebElement requestedPO= driver.findElement(XPathConstants.REQUESTED_PO);
        highlightElement(driver,requestedPO);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.APPROVEBTN));
        WebElement approveBtn= requestedPO.findElement(XPathConstants.APPROVEBTN);
        wait.until(ExpectedConditions.elementToBeClickable(approveBtn));
        highlightElement(driver,approveBtn);
        approveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN2));
        WebElement submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN2);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        Thread.sleep(4000);

        addCookie(driver, prop.getProperty("my-auth-token"));
    }

    @Test(dependsOnMethods ="verifyPO")
    public void createDeliveryIn() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.NAV_ITEMS));
        WebElement warehouseSection= driver.findElements(XPathConstants.NAV_ITEMS).get(4);
        highlightElement(driver,warehouseSection);
        warehouseSection.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.SUPPLIER_PO));
        WebElement purchaseOrderBtn= warehouseSection.findElements(XPathConstants.SUPPLIER_PO).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(purchaseOrderBtn));
        highlightElement(driver,purchaseOrderBtn);
        purchaseOrderBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PO_SEARCH));
        WebElement searchByPO= driver.findElement(XPathConstants.PO_SEARCH);
        searchByPO.sendKeys(poNumber);

        System.out.println("PO NUmber is"+poNumber);

        Thread.sleep(3000);
        searchByPO.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.LIST_SECTION));
        WebElement cardWrapper= driver.findElement(XPathConstants.LIST_SECTION);
        highlightElement(driver,cardWrapper);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.PO_ITEMS));
        List<WebElement> items= cardWrapper.findElements(XPathConstants.LIST_ITEMS);
        highlightElement(driver,items.get(0));
        items.get(0).click();

//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='listItemRow']")));
//        List<WebElement> items= driver.findElements(By.xpath("//div[@class='listItemRow']"));
//
//        for(WebElement item:items)
//        {
//            highlightElement(driver,item);
//            WebElement nameSection= item.findElement(By.xpath(".//div[@class='keyValueBlock'][2]//span[2]"));
//            highlightElement(driver,nameSection);
//
//            if(nameSection.getText().equalsIgnoreCase("Yash Garg"))
//            {
//                item.click();
//                break;
//            }
//        }


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.ACTION_ITEM));
        WebElement createDeliveryBtn= driver.findElements(XPathConstants.ACTION_ITEM).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(createDeliveryBtn));
        highlightElement(driver,createDeliveryBtn);
        createDeliveryBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.LOT_CONTAINER));
        List<WebElement> itemsList= driver.findElements(XPathConstants.LOT_CONTAINER);

        for(WebElement item:itemsList)
        {
            highlightElement(driver,item);
            WebElement stockPendingDelivery= item.findElement(XPathConstants.STOCKDELIVERY_PENDING);
            highlightElement(driver,stockPendingDelivery);
            String stockPending= stockPendingDelivery.getText();

            WebElement incomingQty= item.findElement(XPathConstants.INPUTS);
            incomingQty.sendKeys(stockPending);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement nextBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
//        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
//        datePicker.click();
//
//        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
//        String month= monthYearBtn.getText().split(" ")[0];
//        String year= monthYearBtn.getText().split(" ")[1];
//        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
//        String date= dateBtn.getText()+" "+ month+" "+year;
//
//        WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT);
//        dateInput.sendKeys(date);

        List<WebElement> dropdownOptions= driver.findElements(XPathConstants.MULTIPLE_USED_XPATH);

        WebElement assignToBtn= dropdownOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(assignToBtn));
        highlightElement(driver,assignToBtn);
        assignToBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ASSIGN_TO));
        WebElement assignTo_hint= driver.findElement(XPathConstants.ASSIGN_TO);
        assignTo_hint.sendKeys("a");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ASSIGN_TO_HINT));
        WebElement assignTo_hint_value= driver.findElement(XPathConstants.ASSIGN_TO_HINT);
        wait.until(ExpectedConditions.elementToBeClickable(assignTo_hint_value));
        highlightElement(driver,assignTo_hint_value);
        assignTo_hint_value.click();

        WebElement fullfillmentSpoc= dropdownOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(fullfillmentSpoc));
        highlightElement(driver,fullfillmentSpoc);
        fullfillmentSpoc.click();

        WebElement fullfillmentSpoc_hint= driver.findElement(XPathConstants.FULFILLMENT_SPOC);
        fullfillmentSpoc_hint.sendKeys("a");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.FULFILLMENT_SPOC_VALUE));
        WebElement fullfillmentSpoc_value= driver.findElement(XPathConstants.FULFILLMENT_SPOC_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(fullfillmentSpoc_value));
        fullfillmentSpoc_value.click();

        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT1);
        dateInput.sendKeys(date);

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement supplierSpoc= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(supplierSpoc));
        highlightElement(driver,supplierSpoc);
        supplierSpoc.click();



        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement createDeliveryInBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createDeliveryInBtn));
        highlightElement(driver,createDeliveryInBtn);
        createDeliveryInBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CANCEL_BTN));
        WebElement cancelBtn= driver.findElement(XPathConstants.CANCEL_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
        highlightElement(driver,cancelBtn);
        cancelBtn.click();
    }

    @Test(dependsOnMethods = "createDeliveryIn")
    public void updateTrackingDetails() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TRACKING_SECTION));
        WebElement trackingSecion= driver.findElement(XPathConstants.TRACKING_SECTION);
        highlightElement(driver,trackingSecion);

        WebElement updateStatusBtn= trackingSecion.findElement(By.xpath(".//span"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement newStatus= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(newStatus));
        highlightElement(driver,newStatus);
        newStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.NEW_STATUS));
        WebElement newStatusValue= driver.findElement(XPathConstants.NEW_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(newStatusValue));
        highlightElement(driver,newStatusValue);
        newStatusValue.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT);
        dateInput.sendKeys(date);

        Thread.sleep(3000);


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPLOAD_DOC));
        WebElement uploadDoc= driver.findElement(XPathConstants.UPLOAD_DOC);
        wait.until(ExpectedConditions.elementToBeClickable(uploadDoc));
        highlightElement(driver,uploadDoc);
        //uploadDoc.click();

        WebElement uploadDocInput= uploadDoc.findElement(By.xpath(".//input"));
        uploadDocInput.sendKeys(prop.getProperty("file-path"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.FORM));
        WebElement form= driver.findElement(XPathConstants.FORM);
        highlightElement(driver,form);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.MULTIPLE_USED_XPATH));
        List<WebElement> formDropdownOptions=  form.findElements(XPathConstants.FORM_DROPDOWN);


        WebElement issuingPartyDropdown= formDropdownOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyDropdown));
        highlightElement(driver,issuingPartyDropdown);
        issuingPartyDropdown.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ISSUINGPARTY_VALUE));
        WebElement issuingPartyValue= form.findElement(XPathConstants.ISSUINGPARTY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyValue));
        highlightElement(driver,issuingPartyValue);
        issuingPartyValue.click();

        WebElement receivingParty= formDropdownOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.RECEIVINGPARTY_VALUE));
        WebElement receivingPartyValue= form.findElement(XPathConstants.RECEIVINGPARTY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(receivingPartyValue));
        highlightElement(driver,receivingPartyValue);
        receivingPartyValue.click();

        WebElement saveBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();




        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPDATE_STATUS));
        WebElement updateBtn= driver.findElement(XPathConstants.UPDATE_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TRACKING_SECTION));
        trackingSecion= driver.findElement(XPathConstants.TRACKING_SECTION);
        highlightElement(driver,trackingSecion);

        updateStatusBtn= trackingSecion.findElement(By.xpath(".//span"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
        datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XPathConstants.CURRDATE);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XPathConstants.DATE_INPUT);
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        newStatus= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(newStatus));
        highlightElement(driver,newStatus);
        newStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.NEW_STATUS));
        newStatusValue= driver.findElement(XPathConstants.NEW_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(newStatusValue));
        highlightElement(driver,newStatusValue);
        newStatusValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPDATE_STATUS));
        updateBtn= driver.findElement(XPathConstants.UPDATE_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TRACKING_SECTION));
        trackingSecion= driver.findElement(XPathConstants.TRACKING_SECTION);
        highlightElement(driver,trackingSecion);

        updateStatusBtn= trackingSecion.findElement(By.xpath(".//span"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();

        Thread.sleep(3000);
        dateInput= driver.findElement(XPathConstants.DATE_INPUT);
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        newStatus= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(newStatus));
        highlightElement(driver,newStatus);
        newStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.NEW_STATUS));
        newStatusValue= driver.findElement(XPathConstants.NEW_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(newStatusValue));
        highlightElement(driver,newStatusValue);
        newStatusValue.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPDATE_STATUS));
        updateBtn= driver.findElement(XPathConstants.UPDATE_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        //from heare

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.ACTION_ITEM));
        WebElement markDeliveredBtn= driver.findElements(XPathConstants.ACTION_ITEM).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(markDeliveredBtn));
        highlightElement(driver,markDeliveredBtn);
        markDeliveredBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.LOT_CONTAINER));
        List<WebElement> itemsList= driver.findElements(XPathConstants.LOT_CONTAINER);

        for(WebElement item:itemsList)
        {
            highlightElement(driver,item);
            WebElement expectedQty= item.findElement(XPathConstants.EXPECTED_QTY);
            highlightElement(driver,expectedQty);
            String expectedQtyValue= expectedQty.getText();

            WebElement receivedQty= item.findElement(XPathConstants.INPUTS);
            receivedQty.sendKeys(expectedQtyValue);
        }

        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPLOAD_DOC));
        WebElement uploadSlip= driver.findElement(XPathConstants.UPLOAD_DOC);
        highlightElement(driver,uploadSlip);
        //uploadSlip.click();

        WebElement uploadSlipInput= uploadSlip.findElement(By.xpath(".//input"));
        uploadSlipInput.sendKeys(prop.getProperty("file-path"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.FORM));
        form= driver.findElement(XPathConstants.FORM);
        highlightElement(driver,form);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.MULTIPLE_USED_XPATH));
        formDropdownOptions=  form.findElements(XPathConstants.MULTIPLE_USED_XPATH);


        issuingPartyDropdown= formDropdownOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyDropdown));
        highlightElement(driver,issuingPartyDropdown);
        issuingPartyDropdown.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ISSUING_PARTY));
        issuingPartyValue= form.findElement(XPathConstants.ISSUING_PARTY);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyValue));
        highlightElement(driver,issuingPartyValue);
        issuingPartyValue.click();

        receivingParty= formDropdownOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.RECEIVING_PARTY));
        receivingPartyValue= form.findElement(XPathConstants.RECEIVING_PARTY);
        wait.until(ExpectedConditions.elementToBeClickable(receivingPartyValue));
        highlightElement(driver,receivingPartyValue);
        receivingPartyValue.click();

        saveBtn= driver.findElement(XPathConstants.SAVE_BTN);
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADINGICON));

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SAVE_BTN));
        saveBtn=driver.findElement(XPathConstants.SAVE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SHARE_GRN));
        WebElement shareGRNBtn= driver.findElement(XPathConstants.SHARE_GRN);
        wait.until(ExpectedConditions.elementToBeClickable(shareGRNBtn));
        highlightElement(driver,shareGRNBtn);
        shareGRNBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement person_dropdown= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(person_dropdown));
        highlightElement(driver,person_dropdown);
        person_dropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PERSON_HINT));
        WebElement personName_hint= driver.findElement(XPathConstants.PERSON_HINT);
        personName_hint.sendKeys("a");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PERSON_VALUE));
        WebElement person_value= driver.findElement(XPathConstants.PERSON_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(person_value));
        highlightElement(driver,person_value);
        person_value.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SHARE_BTN));
        WebElement shareBtn= driver.findElement(XPathConstants.SHARE_BTN);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPLOADDOC));
        WebElement uploadDoc= driver.findElement(XPathConstants.UPLOADDOC);
        wait.until(ExpectedConditions.elementToBeClickable(uploadDoc));
        highlightElement(driver,uploadDoc);

        WebElement uploadDocInput= uploadDoc.findElement(By.xpath(".//input"));
        uploadDocInput.sendKeys(prop.getProperty("file-path"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement docType= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(docType));
        highlightElement(driver,docType);
        docType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DOCTYPE_VALUE));
        WebElement docType_value= driver.findElement(XPathConstants.DOCTYPE_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(docType_value));
        docType_value.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement issuingParty= driver.findElements(XPathConstants.MULTIPLE_USED_XPATH).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingParty));
        highlightElement(driver,issuingParty);
        issuingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ISSUING_PARTY_VALUE));
        WebElement issuingParty_value= driver.findElement(XPathConstants.ISSUING_PARTY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(issuingParty_value));
        highlightElement(driver,issuingParty_value);
        issuingParty_value.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement receivingParty= driver.findElements(XPathConstants.MULTIPLE_USED_XPATH).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver,receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.RECEIVING_PARTY_VALUE));
        WebElement receivingParty_value= driver.findElement(XPathConstants.RECEIVING_PARTY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty_value));
        highlightElement(driver,receivingParty_value);
        receivingParty_value.click();

        WebElement invoiceInput= driver.findElement(XPathConstants.INVOICE_INPUT);
        int invoiceNumber= generateInvoiceNumber();
        invoiceInput.sendKeys(String.valueOf(invoiceNumber));

        WebElement invoiceAmount= driver.findElement(XPathConstants.INVOICE_AMOUNT);
        invoiceAmount.sendKeys(prop.getProperty("invoice-amount"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATEINPUT3);
        dateInput.sendKeys(date);


        WebElement saveBtn=driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        Thread.sleep(10000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CONTAINER));
        WebElement container= driver.findElement(XPathConstants.CONTAINER);
        highlightElement(driver,container);

        Thread.sleep(1500);
        WebElement currInvoice= container.findElements(By.xpath(".//td")).get(5);
        highlightElement(driver,currInvoice);

        WebElement redirectBtn= currInvoice.findElement(By.xpath(".//button"));
        wait.until(ExpectedConditions.elementToBeClickable(redirectBtn));
        highlightElement(driver,redirectBtn);
        redirectBtn.click();


        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.REDIRECT_BLOCK));
        WebElement redirectBlock= driver.findElement(XPathConstants.REDIRECT_BLOCK);
        wait.until(ExpectedConditions.elementToBeClickable(redirectBlock));
        highlightElement(driver,redirectBlock);
        redirectBlock.click();



        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.ITEMLIST));
        List<WebElement> itemList= driver.findElements(XPathConstants.ITEMLIST);
        for(WebElement item:itemList)
        {
            highlightElement(driver,item);
            WebElement quantityRemainingElement= item.findElements(XPathConstants.REMAINING_QTY).get(1);
            highlightElement(driver,quantityRemainingElement);
            String qty= quantityRemainingElement.getText();

            WebElement quantityInput= item.findElement(XPathConstants.QTY_INPUT);
            highlightElement(driver,quantityInput);
            quantityInput.sendKeys(qty);

            Thread.sleep(2000);

            WebElement radioGroup= item.findElement(XPathConstants.RADIO_BTN);
            highlightElement(driver,radioGroup);

            WebElement radioBtn= radioGroup.findElement(By.xpath(".//label"));
            radioBtn.click();
        }

        Thread.sleep(1000);
        WebElement selectAllItems= driver.findElement(XPathConstants.CHECKBOX_LABEL);
        wait.until(ExpectedConditions.elementToBeClickable(selectAllItems));
        selectAllItems.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement doneBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
        highlightElement(driver,doneBtn);
        doneBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement publishBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(publishBtn));
        highlightElement(driver,publishBtn);
        publishBtn.click();


        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_BTN));
        WebElement lot_redirect= driver.findElement(XPathConstants.MULTIPLE_USED_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(lot_redirect));
        highlightElement(driver,lot_redirect);
        lot_redirect.click();

        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ELLIPSIS_TEXT));
        driver.findElement(XPathConstants.ELLIPSIS_TEXT).click();


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
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        Thread.sleep(4000);
        for (String winHandle : driver.getWindowHandles())
            driver.switchTo().window(winHandle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_BLOCKS));
        WebElement actionsBlock= driver.findElements(XPathConstants.ACTION_BLOCKS).get(1);
        highlightElement(driver,actionsBlock);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_ITEM));
        WebElement createRFQBtn= actionsBlock.findElements(XPathConstants.ACTION_BTN).get(2);
        highlightElement(driver,createRFQBtn);
        createRFQBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement selectBuyer= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(selectBuyer));
        highlightElement(driver,selectBuyer);
        selectBuyer.click();

        WebElement buyerHint= driver.findElement(XPathConstants.BUYER_HINT);
        buyerHint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BUYER_VALUE));
        WebElement buyer_value= driver.findElement(XPathConstants.BUYER_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(buyer_value));
        highlightElement(driver,buyer_value);
        buyer_value.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BILLING_ADD_VALUE));
        WebElement billingAddressValue= driver.findElement(XPathConstants.BILLING_ADD_VALUE);
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CHECKBOX_LABEL));
        WebElement shippngAddressValue= driver.findElement(XPathConstants.CHECKBOX_LABEL);
        wait.until(ExpectedConditions.elementToBeClickable(shippngAddressValue));
        highlightElement(driver,shippngAddressValue);
        shippngAddressValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement nextBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.PRODUCTS));
        List<WebElement> products= driver.findElements(XPathConstants.PRODUCTS);

        for(WebElement product:products)
        {
            highlightElement(driver,product);
            WebElement showMoreBtn= product.findElement(XPathConstants.SHOW_MORE_BTN);
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

            WebElement qty_input= product.findElement(XPathConstants.INPUTS);
            qty_input.sendKeys(String.valueOf(stock));

        }

        Thread.sleep(6000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement addToCartBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        highlightElement(driver,addToCartBtn);
        addToCartBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CARTBTN));
        WebElement viewCart= driver.findElement(XPathConstants.CARTBTN);
        wait.until(ExpectedConditions.elementToBeClickable(viewCart));
        highlightElement(driver,viewCart);
        viewCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement createRfQBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createRfQBtn));
        highlightElement(driver,createRfQBtn);
        createRfQBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.OKAY_BTN));
        WebElement okayBtn= driver.findElement(XPathConstants.OKAY_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(okayBtn));
        highlightElement(driver,okayBtn);
        okayBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CHECKBOX_SECTION));
        WebElement checkBoxSection= driver.findElement(XPathConstants.CHECKBOX_SECTION);
        highlightElement(driver,checkBoxSection);

        System.out.println("After check Box");

        WebElement checkoption= checkBoxSection.findElement(XPathConstants.CHECKBOX_OPTION);
        highlightElement(driver,checkoption);
        checkoption.click();
        System.out.println("Check Box Clicked");

        List<WebElement> actionButtons= driver.findElements(XPathConstants.ACTION_BTNS);
        actionButtons.get(2).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBCATEGORY_FORM));

        WebElement subcategoryForm= driver.findElement(XPathConstants.SUBCATEGORY_FORM);
        highlightElement(driver,subcategoryForm);

        List<WebElement> option= subcategoryForm.findElements(XPathConstants.SUBCATEGORY);
        WebElement baseRate= option.get(2);
        highlightElement(driver,baseRate);
        baseRate.sendKeys("100");

        WebElement freightRate= subcategoryForm.findElement(XPathConstants.FREIGHT_RATE);
        highlightElement(driver,freightRate);
        freightRate.sendKeys("100");

        WebElement loadingCharges= subcategoryForm.findElement(XPathConstants.LOADING_CHARGES);
        loadingCharges.sendKeys("50");

        List<WebElement> dropDownOptions= driver.findElements(XPathConstants.DROPDOWN_OPTIONS);
        dropDownOptions.get(2).click();

        WebElement gstOption= dropDownOptions.get(2).findElement(XPathConstants.GST_OPTION);
        highlightElement(driver,gstOption);
        gstOption.click();
        Thread.sleep(3000);

        try
        {
            WebElement copyRatesToAll= subcategoryForm.findElement(XPathConstants.COPY_BTN);
            if(copyRatesToAll.isDisplayed())
                copyRatesToAll.click();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
            WebElement saveBtn = driver.findElement(XPathConstants.SUBMIT_BTN);
            Thread.sleep(2000);
            highlightElement(driver,saveBtn);
            saveBtn.click();

        }

    }


    @Test(dependsOnMethods = "createRFQ")
    public void handleBuyerPrefs() throws InterruptedException, IOException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BUYER_PREFS));

        WebElement buyerPrefs= driver.findElement(XPathConstants.BUYER_PREFS);
        highlightElement(driver,buyerPrefs);
        buyerPrefs.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.BUYER_PREFS_OPTIONS));
        List<WebElement> buyerPrefsOptions= driver.findElements(XPathConstants.BUYER_PREFS_OPTIONS);

        System.out.println("Size:" + buyerPrefsOptions.size());

//        WebElement preferences= buyerPrefsOptions.get(0).findElement(By.className("heading"));
//        wait.until(ExpectedConditions.elementToBeClickable(preferences));
//        highlightElement(driver,preferences);
//        preferences.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_BTNS));
        WebElement editBtn=  buyerPrefsOptions.get(0).findElement(XPathConstants.ACTION_BTNS);
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

        List<WebElement> addressesOptions= driver.findElements(XPathConstants.ADDRESS_OPTIONS);
        WebElement shippingAddressBtn= addressesOptions.get(3);
        highlightElement(driver,shippingAddressBtn);
        shippingAddressBtn.click();

        List<WebElement> shippingAddressOptions= driver.findElements(XPathConstants.SHIPPING_ADDRESS_OPTION);
        if(!shippingAddressOptions.isEmpty())
            shippingAddressOptions.get(0).click();

        WebElement billingAddressBtn= addressesOptions.get(1);
        highlightElement(driver,billingAddressBtn);
        billingAddressBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BILLING_ADDRESS_OPTION));
        WebElement billingAddressValue= driver.findElement(XPathConstants.BILLING_ADDRESS_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();

        WebElement toleranceInput= buyerPrefsOptions.get(0).findElement(XPathConstants.INVOICE_AMOUNT);
        toleranceInput.sendKeys("0");

        WebElement saveAddressBtn= buyerPrefsOptions.get(0).findElement(XPathConstants.BTN_XPATH);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_BTN));
        WebElement editBtn2= paymentTerms.findElement(XPathConstants.ITEM_CART);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn2));
        highlightElement(driver,editBtn2);
        editBtn2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_INPUT));
        WebElement advanceInput= paymentTerms.findElement(XPathConstants.MULTIPLE_USED_INPUT);
        advanceInput.clear();
        advanceInput.sendKeys("100");

        WebElement saveBtn= paymentTerms.findElement(XPathConstants.SAVEBTN);
        highlightElement(driver,saveBtn);
        saveBtn.click();

        Thread.sleep(2000);
        highlightElement(driver, paymentTermsSection);
        paymentTermsSection.click();
        WebElement sendForApproval= paymentTerms.findElement(XPathConstants.SEND_FOR_APPROVAL);
        wait.until(ExpectedConditions.elementToBeClickable(sendForApproval));

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();

        WebElement uploadPO=  buyerPrefsOptions.get(2);
        WebElement uploadBuyerPoSection= uploadPO.findElement(By.className("heading"));
        wait.until(ExpectedConditions.elementToBeClickable(uploadBuyerPoSection));
        highlightElement(driver,uploadBuyerPoSection);
        uploadBuyerPoSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CHECK_BOX));
        WebElement checkBox= driver.findElement(XPathConstants.CHECK_BOX);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();
        System.out.println("Check Box Clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITBTN));
        WebElement editBtn3= uploadPO.findElement(XPathConstants.EDITBTN);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn3));
        highlightElement(driver,editBtn3);
        editBtn3.click();

        WebElement buyerContainer= uploadPO.findElement(XPathConstants.BUYER_CONTAINER);
        WebElement PO_No= buyerContainer.findElement(XPathConstants.PO_NUMBER);
        highlightElement(driver,PO_No);
        PO_No.sendKeys("12232");

        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT1);
        dateInput.sendKeys(date);

        WebElement uploadDoc= uploadPO.findElement(XPathConstants.UPLOADDOCS);
        uploadDoc.sendKeys(prop.getProperty("file-path"));

        Thread.sleep(6000);

        WebElement saveBtn2= uploadPO.findElement(XPathConstants.SAVE);
        Thread.sleep(1500);
        highlightElement(driver,saveBtn2);
        saveBtn2.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDIT_ENTITY));
        WebElement editEntity= driver.findElement(XPathConstants.EDIT_ENTITY);

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

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.OPTIONS));
        WebElement addressSection= driver.findElements(XPathConstants.OPTIONS).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(addressSection));
        highlightElement(driver,addressSection);
        addressSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ADDRESS_VALUE));
        WebElement addressValue= addressSection.findElement(XPathConstants.ADDRESS_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(addressValue));
        highlightElement(driver,addressValue);
        addressValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPDATE_SUBMIT_BTN));
        WebElement updateBtn= driver.findElement(XPathConstants.UPDATE_SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING_ICON));

        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ITEM_SPECIFICATIONS));
        WebElement itemSpecifications= driver.findElement(XPathConstants.ITEM_SPECIFICATIONS);
        itemSpecifications.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_QUOTE));
        WebElement submitBuyerQuote= driver.findElement(XPathConstants.SUBMIT_QUOTE);

        wait.until(ExpectedConditions.elementToBeClickable(submitBuyerQuote));
        highlightElement(driver,submitBuyerQuote);
        submitBuyerQuote.click();

        Thread.sleep(3000);

    }

    @Test(dependsOnMethods = "handleBuyerPrefs")
    public void handleSupplierQuotation() throws InterruptedException, IOException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUPPLIER_QUOTE));
        WebElement supplierQuote= driver.findElement(XPathConstants.SUPPLIER_QUOTE);
        highlightElement(driver,supplierQuote);
        supplierQuote.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.VIEW_SUPPLIER_DETAILS));
        WebElement viewSupplierDetails= driver.findElement(XPathConstants.VIEW_SUPPLIER_DETAILS);
        wait.until(ExpectedConditions.elementToBeClickable(viewSupplierDetails));
        highlightElement(driver,viewSupplierDetails);
        viewSupplierDetails.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_BTN));
        WebElement sendForApproval= driver.findElement(XPathConstants.MULTIPLE_USED_BTN);
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
        List<WebElement> toasts= driver.findElements(XPathConstants.TOAST_ELEMENT);
        wait.until(ExpectedConditions.invisibilityOfAllElements(toasts));

        Thread.sleep(8000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BTN_XPATH));
        WebElement createOrder= driver.findElement(XPathConstants.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(createOrder));
        highlightElement(driver,createOrder);
        createOrder.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MODAL_CONTENT));

        List<WebElement> checkBoxes= driver.findElements(XPathConstants.CHECKBOXES);
        for(WebElement checkBox:checkBoxes)
        {
            highlightElement(driver,checkBox);
            checkBox.click();
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPDATE_SUBMIT_BTN));
        WebElement submitBtn= driver.findElement(XPathConstants.UPDATE_SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();




//        Thread.sleep(5000);
//
//        for(String handle:driver.getWindowHandles())
//            driver.switchTo().window(handle);
//
//        Thread.sleep(4000);
//        mainWindow= driver.getWindowHandle();
//
//        getOrganizationID(driver);
//        driver.switchTo().window(mainWindow);





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
//        driver.get("https://stg3-cms.ofbusiness.co.in/oasys-fe/order/OFB117175679912114");

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(80));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADINGICON));

        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);

        highlightTab(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.LINKELEMENT));
        WebElement organizationNameElement= driver.findElement(XPathConstants.LINKELEMENT);
        wait.until(ExpectedConditions.elementToBeClickable(organizationNameElement));
        highlightElement(driver,organizationNameElement);

        //organizationID= organizationNameElement.getText();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PAYMENT_STATUS));
        WebElement paymentStatus= driver.findElement(XPathConstants.PAYMENT_STATUS);

        if(paymentStatus.getText().equalsIgnoreCase("Awaiting Payment"))
        {
           WebElement changeStatusBtn= driver.findElement(XPathConstants.CHANGE_STATUS);
           wait.until(ExpectedConditions.elementToBeClickable(changeStatusBtn));
           highlightElement(driver, changeStatusBtn);
           changeStatusBtn.click();

           wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.NEW_STATUS_BTN));
           WebElement newStatus= driver.findElements(XPathConstants.NEW_STATUS_BTN).get(1);
        }
      // mainWindow= driver.getWindowHandle();

        //getOrganizationID(driver);

//        Thread.sleep(3000);
//        driver.switchTo().window(mainWindow);


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.LINKS_LIST));
        WebElement linksLst= driver.findElement(XPathConstants.LINKS_LIST);
        highlightElement(driver,linksLst);

        List<WebElement> actionButtons= linksLst.findElements(By.tagName("button"));
        WebElement createDispatchBtn= actionButtons.get(4);
        wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
        highlightElement(driver,createDispatchBtn);
        createDispatchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_BTN));
        WebElement selectSupplier= driver.findElement(XPathConstants.MULTIPLE_USED_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(selectSupplier));
        highlightElement(driver,selectSupplier);
        selectSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CHECKBOX));
        WebElement checkBox= driver.findElement(XPathConstants.CHECKBOX);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        List<WebElement> items= driver.findElements(XPathConstants.ITEMS_LIST);
        for(WebElement item:items)
        {
            highlightElement(driver,item);
            List<WebElement> options= item.findElements(By.xpath(".//td"));

//            checkBox= options.get(0).findElement(By.xpath(".//label"));
//            wait.until(ExpectedConditions.elementToBeClickable(checkBox));
//            highlightElement(driver,checkBox);
//            checkBox.click();

            WebElement pendingAmt= options.get(4).findElement(XPathConstants.PENDING_QTY);
            String qty= pendingAmt.getText();

            WebElement value= item.findElement(XPathConstants.MULTIPLE_USED_INPUT);
            value.sendKeys(qty);
        }

        try{
            if(driver.findElement(XPathConstants.ERROR_MSG).isDisplayed())
                handleFinance(driver);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {


            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
            WebElement addToDispatchBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
            wait.until(ExpectedConditions.elementToBeClickable(addToDispatchBtn));
            highlightElement(driver,addToDispatchBtn);
            addToDispatchBtn.click();

            Thread.sleep(5000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CARTBTN));
            WebElement viewDispatch= driver.findElement(XPathConstants.CARTBTN);
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


            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BTN_XPATH));
            WebElement nextBtn= driver.findElement(XPathConstants.BTN_XPATH);
            wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
            highlightElement(driver,nextBtn);
            nextBtn.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.OPTIONS));

            List<WebElement> addressOptions= driver.findElements(XPathConstants.OPTIONS);

            WebElement billingAddress= addressOptions.get(0);
            wait.until(ExpectedConditions.elementToBeClickable(billingAddress));
            highlightElement(driver,billingAddress);
            billingAddress.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BILLINGADDRESS));
            WebElement billingAddressValue= driver.findElement(XPathConstants.BILLINGADDRESS);
            wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
            highlightElement(driver,billingAddressValue);
            billingAddressValue.click();

            WebElement pickupAddress= addressOptions.get(1);
            wait.until(ExpectedConditions.elementToBeClickable(pickupAddress));
            highlightElement(driver,pickupAddress);
            pickupAddress.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PICKUPADDRESS));
            WebElement pickupAddressValue= driver.findElement(XPathConstants.PICKUPADDRESS);
            wait.until(ExpectedConditions.elementToBeClickable(pickupAddressValue));
            highlightElement(driver,pickupAddressValue);
            pickupAddressValue.click();

            WebElement datePicker= driver.findElements(XPathConstants.DATEPICKER).get(0);
            datePicker.click();

            WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
            String month= monthYearBtn.getText().split(" ")[0];
            String year= monthYearBtn.getText().split(" ")[1];
            WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
            String date= dateBtn.getText()+" "+ month+" "+year;

            WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT1);
            dateInput.sendKeys(date);


            datePicker= driver.findElements(XPathConstants.DATEPICKER).get(1);
            datePicker.click();

            monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
            month= monthYearBtn.getText().split(" ")[0];
            year= monthYearBtn.getText().split(" ")[1];
            dateBtn = driver.findElement(XPathConstants.CURRDATE);
            date= dateBtn.getText()+" "+ month+" "+year;

            dateInput= driver.findElement(XPathConstants.DATE_INPUT1);
            dateInput.sendKeys(date);

            createDispatchBtn= driver.findElement(XPathConstants.BTN_XPATH);
            wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
            highlightElement(driver,createDispatchBtn);
            createDispatchBtn.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        }

    }


    public void handleFinance(WebDriver driver) throws IOException, InterruptedException {

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));

        WebElement financeSection= driver.findElements(XPathConstants.NAV_ITEMS).get(10);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", financeSection);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(financeSection));
        highlightElement(driver,financeSection);
        financeSection.click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li")));
        WebElement receiptsBtn= financeSection.findElement(By.xpath(".//ul//li[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(receiptsBtn));
        highlightElement(driver,receiptsBtn);
        receiptsBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ADD_RECEIPT_BTN));
        WebElement addReceiptBtn= driver.findElement(XPathConstants.ADD_RECEIPT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addReceiptBtn));
        highlightElement(driver,addReceiptBtn);
        addReceiptBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.AMOUNT_INPUT));
        WebElement amount= driver.findElement(XPathConstants.AMOUNT_INPUT);
        amount.sendKeys(prop.getProperty("receipt-amount"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UTR_VALUE));
        WebElement utrValue= driver.findElement(XPathConstants.UTR_VALUE);
        utrValue.sendKeys(prop.getProperty("utr-value"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PARTY_NAME));
        WebElement party= driver.findElement(XPathConstants.PARTY_NAME);
        party.sendKeys(prop.getProperty("party-value"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TRANSACTION_TYPE));
        WebElement transactionType= driver.findElement(XPathConstants.TRANSACTION_TYPE);
        wait.until(ExpectedConditions.elementToBeClickable(transactionType));
        transactionType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TRANSACTION_VALUE));
        WebElement transactionValue= driver.findElement(XPathConstants.TRANSACTION_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(transactionValue));
        transactionValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BANK_ACCOUNT));
        WebElement bankAccount= driver.findElement(XPathConstants.BANK_ACCOUNT);
        bankAccount.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACCOUNT_VALUE));
        WebElement bankAccountValue= driver.findElement(XPathConstants.ACCOUNT_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(bankAccountValue));
        highlightElement(driver,bankAccountValue);
        bankAccountValue.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CREATE_BTN));
        WebElement createBtn= driver.findElement(XPathConstants.CREATE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.FINANCE_TABLE));
        WebElement financeTable= driver.findElement(XPathConstants.FINANCE_TABLE);
        highlightElement(driver,financeTable);

        driver.navigate().refresh();

        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody")));
        Thread.sleep(20000);
        List<WebElement> financesList= driver.findElements(XPathConstants.FINANCE_LIST);

        System.out.println("Sizex of list==> "+ financesList.size());

        Thread.sleep(2000);

        for(WebElement finance:financesList)
        {
            WebElement check1_amount= finance.findElement(XPathConstants.AMOUNT_CHECK);
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
                WebElement btnSection= finance.findElement(XPathConstants.BTN_SECTION);
                WebElement mapBtn= btnSection.findElement(By.xpath(".//span"));
                wait.until(ExpectedConditions.elementToBeClickable(mapBtn));
                highlightElement(driver,mapBtn);
                mapBtn.click();


                WebElement organizationInput= btnSection.findElement(XPathConstants.SEARCH_ORGANIZATION);
                organizationInput.sendKeys(organizationID);



                wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ORGANIZATION_OPTION));
                WebElement organizationOption= driver.findElement(XPathConstants.ORGANIZATION_OPTION);
                wait.until(ExpectedConditions.elementToBeClickable(organizationOption));
                highlightElement(driver,organizationOption);
                organizationOption.click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.OPTIONS_SAVEBTN));
        WebElement saveBtn= driver.findElement(XPathConstants.OPTIONS_SAVEBTN);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DRAWER));

        WebElement drawer= driver.findElement(XPathConstants.DRAWER);
        highlightElement(driver,drawer);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Buyout RFQs']")));
        WebElement rfqSection= driver.findElement(By.xpath("//span[text()='Buyout RFQs']"));
        wait.until(ExpectedConditions.elementToBeClickable(rfqSection));
        highlightElement(driver,rfqSection);
        rfqSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Inventory / Bulk Order']")));
        WebElement inventory= driver.findElement(By.xpath("//a[text()='Inventory / Bulk Order']"));
        wait.until(ExpectedConditions.elementToBeClickable(inventory));
        highlightElement(driver,inventory);
        inventory.click();








        String buyerName=ofbEntity_Value;

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ORDER_LIST));
        WebElement orderList= driver.findElement(XPathConstants.ORDER_LIST);
        highlightElement(driver,orderList);

        System.out.println("OrgName is "+ buyerName);

        List<WebElement> buyers= driver.findElements(XPathConstants.ITEMS_LIST);
        for(WebElement buyer:buyers)
        {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement buyerElement= buyer.findElement(XPathConstants.BUYER_ELEMENT);
            System.out.println("Buyer element is "+ buyerElement);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.LINKS_LIST));
        WebElement linksLst= driver.findElement(XPathConstants.LINKS_LIST);
        highlightElement(driver,linksLst);

        List<WebElement> actionButtons= linksLst.findElements(By.tagName("button"));
        WebElement createDispatchBtn= actionButtons.get(4);
        wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
        highlightElement(driver,createDispatchBtn);
        createDispatchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_BTN));
        WebElement selectSupplier= driver.findElement(XPathConstants.MULTIPLE_USED_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(selectSupplier));
        highlightElement(driver,selectSupplier);
        selectSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CHECKBOX));
        WebElement checkBox= driver.findElement(XPathConstants.CHECKBOX);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        List<WebElement> items= driver.findElements(XPathConstants.ITEMS_LIST);
        for(WebElement item:items)
        {
            highlightElement(driver,item);
            List<WebElement> options= item.findElements(By.xpath(".//td"));

//            checkBox= options.get(0).findElement(By.xpath(".//label"));
//            wait.until(ExpectedConditions.elementToBeClickable(checkBox));
//            highlightElement(driver,checkBox);
//            checkBox.click();

            WebElement pendingAmt= options.get(4).findElement(XPathConstants.PENDING_QTY);
            String qty= pendingAmt.getText();

            WebElement value= item.findElement(XPathConstants.MULTIPLE_USED_INPUT);
            value.sendKeys(qty);
        }

    }


    @Test(dependsOnMethods = "createDispatch")
    public void  createShipment() throws IOException, InterruptedException {
//         loadPropFile();
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-ts/dispatch/buyout/open/OFB117177353544117-D-1/details");

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.CREATE_SHIPMENT));
        WebElement createShipment= driver.findElements(XPathConstants.CREATE_SHIPMENT).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(createShipment));
        highlightElement(driver,createShipment);
        createShipment.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CHECKBOX_LABEL));
        WebElement checkBox= driver.findElement(XPathConstants.CHECKBOX_LABEL);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        WebElement createBtn= driver.findElement(XPathConstants.DISPATCH_ACTION_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DISPATCH_SECTION));
        WebElement dispatchItemsSection= driver.findElement(XPathConstants.DISPATCH_SECTION);

        List<WebElement> dispatchItems= dispatchItemsSection.findElements(By.xpath(".//tr"));

        for(int i=0;i<dispatchItems.size();i++)
        {
            WebElement item= dispatchItems.get(i);
            highlightElement(driver,item);

            WebElement dispatchQty= item.findElement(By.xpath(".//td[4]"));
            String qty=dispatchQty.getText();

            List<WebElement> qtyInput= driver.findElements(XPathConstants.DISPATCHQTY_INPUT);
            qtyInput.get(i).sendKeys(qty);
        }



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SHIPMENT_NEXT_BTN));
        WebElement addToShipmentBtn= driver.findElement(XPathConstants.SHIPMENT_NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addToShipmentBtn));
        highlightElement(driver,addToShipmentBtn);
        addToShipmentBtn.click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DISPATCH_CART));
        WebElement viewAddedItems= driver.findElement(XPathConstants.DISPATCH_CART);
        wait.until(ExpectedConditions.elementToBeClickable(viewAddedItems));
        highlightElement(driver,viewAddedItems);
        viewAddedItems.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SHIPMENT_NEXT_BTN));
        WebElement nextBtn= driver.findElement(XPathConstants.SHIPMENT_NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.DATEPICKER));
        WebElement datePicker= driver.findElements(XPathConstants.DATEPICKER).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(datePicker));
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT1);
        dateInput.sendKeys(date);


        datePicker= driver.findElements(XPathConstants.DATEPICKER).get(1);
        datePicker.click();

        monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XPathConstants.CURRDATE);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XPathConstants.DATE_INPUT1);
        dateInput.sendKeys(date);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.MULTIPLE_USED_XPATH));

        List<WebElement> options= driver.findElements(XPathConstants.MULTIPLE_USED_XPATH);
        WebElement fulfillmentSpoc= options.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(fulfillmentSpoc));
        highlightElement(driver,fulfillmentSpoc);
        fulfillmentSpoc.click();

        WebElement fulfillmentSpoc_hint= driver.findElement(XPathConstants.FULFILLMENTSPOC);
        fulfillmentSpoc_hint.sendKeys("Ayush Chaudhary");
        Thread.sleep(4000);
        fulfillmentSpoc_hint.sendKeys(Keys.ENTER);



        WebElement logisticsMode= options.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(logisticsMode));
        highlightElement(driver,logisticsMode);
        logisticsMode.click();

        WebElement logisticMode_hint= driver.findElement(XPathConstants.LOGISTIC_MODE_HINT);
        logisticMode_hint.sendKeys("FTL");
        Thread.sleep(4000);
        logisticMode_hint.sendKeys(Keys.ENTER);

        WebElement truckType= options.get(2);
        wait.until(ExpectedConditions.elementToBeClickable(truckType));
        highlightElement(driver,truckType);
        truckType.click();

        WebElement truckType_input= driver.findElement(XPathConstants.TRUCK_TYPE_INPUT);
        truckType_input.sendKeys("Trailer");
        Thread.sleep(4000);
        truckType_input.sendKeys(Keys.ENTER);


        String mainWindow=driver.getWindowHandle();
        Thread.sleep(3000);


        WebElement createShipmentBtn= driver.findElement(XPathConstants.CREATE_SHIPMENT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createShipmentBtn));
        highlightElement(driver,createShipmentBtn);
        createShipmentBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.GO_TO_SHIPMENT_BTN));
        WebElement goToShipmentBtn= driver.findElement(XPathConstants.GO_TO_SHIPMENT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(goToShipmentBtn));
        highlightElement(driver,goToShipmentBtn);
        goToShipmentBtn.click();
    }


    //@Test
    public void verifyShipment() throws InterruptedException, IOException {

        loadPropFile();
        WebDriver driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://stg5-cms.ofbusiness.co.in/#/home/shipment/OFB11718880899958-S-1/summary");
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


        /*
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

         */


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

       /* wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']")));
        WebElement saveBtn= driver.findElements(By.xpath("//button[@class='customButtonFill right md-button md-ofb-green-theme md-ink-ripple']")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog[@class='_md md-ofb-green-theme _md-transition-in']//button")));
        WebElement gotItBtn=driver.findElement(By.xpath("//md-dialog[@class='_md md-ofb-green-theme _md-transition-in']//button"));
        wait.until(ExpectedConditions.elementToBeClickable(gotItBtn));
        highlightElement(driver,gotItBtn);
        gotItBtn.click();
*/
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
        WebElement saveBtn= driver.findElement(By.xpath("//button[@class='customButtonFill right borderRadius15 md-button ng-scope md-ofb-green-theme md-ink-ripple']"));
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item//span[text()='Summary']")));
        WebElement summaryBtn= driver.findElement(By.xpath("//md-tab-item//span[text()='Summary']"));
        wait.until(ExpectedConditions.elementToBeClickable(summaryBtn));
        highlightElement(driver,summaryBtn);
        summaryBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='listValue linkValue ng-binding']")));
        WebElement deliveryOutLink= driver.findElement(By.xpath("//span[@class='listValue linkValue ng-binding']"));
        wait.until(ExpectedConditions.elementToBeClickable(deliveryOutLink));
        highlightElement(driver,deliveryOutLink);
        deliveryOutLink.click();

        Thread.sleep(3000);
        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);


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



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary']")));
        WebElement updateStatusBtn= driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
        WebElement checkBox= driver.findElement(By.xpath("//input[@type='checkbox']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT);
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

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.MULTIPLE_USED_XPATH));
        List<WebElement> parties= driver.findElements(XPathConstants.MULTIPLE_USED_XPATH);

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

        saveBtn=driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();


        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement updateBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();




        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary']")));
        updateStatusBtn= driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver,updateStatusBtn);
        updateStatusBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
        datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XPathConstants.CURRDATE);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XPathConstants.DATE_INPUT);
        dateInput.sendKeys(date);


        Thread.sleep(4000);

        updateBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
        highlightElement(driver,updateBtn);
        updateBtn.click();


        driver.switchTo().window(mainWindow);





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

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.OPTIONS_SAVEBTN));
        WebElement invoiceOptions= driver.findElements(XPathConstants.OPTIONS_SAVEBTN).get(2);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement digitalSignBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(digitalSignBtn));
        highlightElement(driver,digitalSignBtn);
        digitalSignBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='checkboxCustom']")));
        checkBox= driver.findElement(By.xpath("//span[@class='checkboxCustom']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.SUBMIT_BTN));
        WebElement digitallySignBtn= driver.findElements(XPathConstants.SUBMIT_BTN).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(digitallySignBtn));
        highlightElement(driver,digitallySignBtn);
        digitallySignBtn.click();

        Thread.sleep(6000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement verifyBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(verifyBtn));
        highlightElement(driver,verifyBtn);
        verifyBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='checkboxCustom']")));
        checkBox= driver.findElement(By.xpath("//span[@class='checkboxCustom']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();


        Thread.sleep(6000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        verifyBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
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


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.MULTIPLE_USED_BTN));
        WebElement seeShipment= driver.findElements(XPathConstants.MULTIPLE_USED_BTN).get(1);
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

        WebElement publishBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(publishBtn));
        highlightElement(driver,publishBtn);
        publishBtn.click();


    }
}
