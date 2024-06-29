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

public class Warehouse_StockTransfer {

    class XPathConstants
    {
        public static final By LINKELEMENT= By.xpath("//span[@class='pointerCursor']");
        public static final By DRAWER= By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex");
        public static final By DRAWER_OPTIONS= By.xpath("//button[@class='md-raised md-primary side-menu-link md-button ng-scope md-ofb-brown-theme md-ink-ripple']");
        public static final By DRAWER_ACTIONS = By.xpath("//ul[@class='drop-down-list ng-scope']//li");
        public static final By ADD_NEW_WAREHOUSE= By.xpath("//button[@class='btn btn-primary addNewWarehouseBtn']");
        public static final By OFB_ENTITY= By.xpath("//div[@id='ofbEntityId-tfid-0-1']");

        public static final By EMPTY_OFB_ENTITY_VALUE= By.xpath(".//div[@id='react-select-ofbEntityId-option-1']");


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
        public static final By OFB_ADDRESS_VALUE= By.xpath("//div[@id='react-select-ofbEntityAddressId-option-0']");
        public static final By ADD_ITEMS_BTN= By.xpath("//button[@class='btn btn-primary addContactPersonBtn']");

        public static final By ITEMS_SECTION= By.xpath("//div[@class='baseCatWrapper']");
        public static final By ITEMS= By.xpath("//div[@class='catItem']");
        public static final By ITEM_CART= By.xpath(".//button[@class='btn btn-default']");
        public static final By VARIETY_SECTION= By.xpath("//div[@class='leafCatWrapper']");
        public static final By CART_BTN= By.xpath("//div[@class='cartBtn']");
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
        public static final By RECEIVING_PARTY= By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-0']");
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
        public static final By ISSUINGPARTY_VALUE= By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-issuingParty-option-0']");
        public static final By RECEIVINGPARTY_VALUE= By.xpath(".//div[@class='reactSelectContainer']//div[@id='react-select-receivingParty-option-0']");
        public static final By UPDATE_STATUS= By.xpath("//button[text()='Update Status']");

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
        public static final By CHECKBOX= By.xpath("//div[@class='tableContainer']//span");

        public static final By MULTIPLE_USED_INPUT= By.id("tfid-0-0");
        public static final By ITEMS_LIST= By.xpath("//div[@class='listItemRow']");
        public static final By ACTION_WRAPPER= By.xpath("//div[@class='actionsWrapper']");
        public static final By SEARCH_WAREHOUSE_FIELD= By.xpath("//input[@placeholder='Search By Warehouse nickname']");
        public static final By WAREHOUSE_OPTION= By.xpath("//div[@class='warehouseOption']");
        public static final By ITEM_TABLE= By.xpath("//tbody[@class='tableBody']");
        public static final By RADIO_XPATH= By.xpath("//label[@class='radioLabel']");
        public static final By FULFILLMENT_SPOCVALUE= By.xpath("//div[@id='react-select-ofbFulfillmentSpoc-option-0']");
        public static final By OFB_ENTITY_HINT= By.xpath("//input[@id='ofbEntity-input-tfid-0-14']");
        public static final By OFBENTITY_VALUE= By.xpath("//div[@id='react-select-ofbEntity-option-0']");
        public static final By DELIVERY_OUT_LINK= By.xpath("//span[@class='value txt-blue']");
        public static final By SUPPLIER_REF_NO= By.xpath("//input[@id='tfid-0-2']");
        public static final By UPDATESTATUS_BTN= By.xpath("//button[@class='btn btn-secondary']");
        public static final By TIME_INPUT= By.xpath("//input[@name='time']");
        public static final By EDIT_WRAPPER= By.xpath("//div[@class='editWrapper']");
        public static final By TABLE_ROW= By.xpath("//div[@class='row tableDataRow']");
        public static final By UPLOADSLIP_INPUT= By.xpath(".//input[@id='deliveryInDocumentUpload-WEIGHMENT_SLIP']");
        public static final By PARTY_VALUE= By.xpath("//div[text()='OFB']");
        public static final By TABLE_CONTAINER= By.xpath("//div[@class='tableContainer']");
        public static final By TRANSFER_INVOICE_ROW= By.xpath(".//tbody//tr");
        public static final By PUBLISHBTN= By.xpath(".//span[@title='Publish']");
        public static final By ACCEPT_TERMS= By.xpath("//input[@id='has-agreed-to-terms']");

        public static final By FREIGHTRATE= By.xpath("//input[@name='freightRate']");
        public static final By EDITSHIPMENT_COST= By.xpath("//button[@class='btn btn-secondary' and contains(text(),'Edit Shipment Costs')]");
        public static final By LSP_DETAILS= By.xpath(".//span[text()='LSP Details']");
        public static final By TAB_CONTAINER= By.xpath("//div[@class='tabContainer']");
        public static final By AGREE_CHECKBOX= By.xpath("//input[@id='agreementCheckbox']");
        public static final By AMOUNT_ELEMENT= By.xpath("//div[@class='amt']");
        public static final By INPUT_CAPTCHA= By.xpath("//input[@class='inputCaptcha']");
        public static final By VIEW_INVENTORY= By.xpath(".//span[text()='View Inventory']");

    }

    static String mainWindow;
    WebDriver driver;
    static Properties prop;
    static String emptyWarehouse_ofbEntity_Value;
    static String empty_warehouse_nickname;
    static String ofbEntity_Value;
    static String organizationID;
    private static String poNumber;

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
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));
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
    public void addEmptyWarehouse() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.OFB_ENTITY));
        WebElement ofbEntity= driver.findElement(XPathConstants.OFB_ENTITY);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntity));
        highlightElement(driver,ofbEntity);
        ofbEntity.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EMPTY_OFB_ENTITY_VALUE));
        WebElement ofbEntityValue= ofbEntity.findElement(XPathConstants.EMPTY_OFB_ENTITY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntityValue));
        emptyWarehouse_ofbEntity_Value= ofbEntityValue.getText();
        System.out.println("Empty Warehouse OfbEntityValue is "+ emptyWarehouse_ofbEntity_Value);
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
        warehouseNickName.sendKeys(prop.getProperty("empty-warehouse-nickname"));

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
        personName.sendKeys(prop.getProperty("empty-warehouse-personName"));

        WebElement phoneInput= driver.findElement(XPathConstants.INPUT_FIELDS2);
        phoneInput.sendKeys(prop.getProperty("empty-warehouse-personPhone"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement submitWarehouse= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitWarehouse));
        highlightElement(driver,submitWarehouse);
        submitWarehouse.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.WAREHOUSELIST));

        driver.navigate().refresh();
        Thread.sleep(5000);

        WebElement warehouseList= driver.findElement(XPathConstants.WAREHOUSELIST);
        highlightElement(driver,warehouseList);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.LIST_ITEMS));
        List<WebElement> warehouseItems= warehouseList.findElements(XPathConstants.LIST_ITEMS);
        System.out.println(warehouseItems.size()+" lengthed list");

        Thread.sleep(1500);


        for(WebElement item:warehouseItems)
        {
            highlightElement(driver,item);
            ofbEntity= item.findElements(By.xpath(".//span")).get(1);
            highlightElement(driver,ofbEntity);
            if(ofbEntity.getText().equalsIgnoreCase(emptyWarehouse_ofbEntity_Value))
            {
                WebElement warehouseName= driver.findElement(By.xpath("//span[@class='wh-nickName ellipsisText']"));
                highlightElement(driver,warehouseName);
                empty_warehouse_nickname= warehouseName.getText();
                System.out.println("Empty warehouse name is "+ empty_warehouse_nickname);
                break;
            }
        }

    }

    @Test(dependsOnMethods = "addEmptyWarehouse")
    public void addnewWarehouseTest() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ADD_NEW_WAREHOUSE));

        WebElement addNewWarehouseBtn= driver.findElement(XPathConstants.ADD_NEW_WAREHOUSE);
        wait.until(ExpectedConditions.elementToBeClickable(addNewWarehouseBtn));
        highlightElement(driver,addNewWarehouseBtn);
        addNewWarehouseBtn.click();

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
        List<WebElement> warehouseItems= warehouseList.findElements(XPathConstants.LIST_ITEMS);
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

    @Test(dependsOnMethods = "updateTrackingDetails")
    public void uploadDocs() throws InterruptedException, IOException {

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

        /*
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

         */

        WebElement invoiceInput= driver.findElement(By.xpath("//input[@id='tfid-0-1']"));
        int invoiceNumber= generateInvoiceNumber();
        invoiceInput.sendKeys(String.valueOf(invoiceNumber));

//        WebElement invoiceAmount= driver.findElement(XPathConstants.INVOICE_AMOUNT);
//        invoiceAmount.sendKeys(prop.getProperty("invoice-amount"));


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

        WebElement redirectBlock= driver.findElement(By.xpath("//button[@class='redirectBlock']"));
        wait.until(ExpectedConditions.elementToBeClickable(redirectBlock));
        highlightElement(driver,redirectBlock);
        redirectBlock.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lineItemCard']")));
        List<WebElement> items= driver.findElements(By.xpath("//div[@class='lineItemCard']"));

        WebElement selectAllItems= driver.findElement(By.xpath("//label[@class='checkboxLabel']"));
        selectAllItems.click();

        for(WebElement item:items)
        {
            highlightElement(driver,item);

            WebElement remainingQty= item.findElements(By.xpath(".//span[@class='badgeContainer ']")).get(1);
            highlightElement(driver,remainingQty);
            String remainedQty= remainingQty.getText();

            WebElement qty_input= item.findElement(By.xpath(".//input[@id='tfid-0-1']"));
            qty_input.sendKeys(remainedQty.substring(remainedQty.indexOf(':')+1,remainedQty.lastIndexOf(" ")));

            WebElement radioBtn= item.findElement(By.xpath(".//label[@class='radioLabel']"));
            radioBtn.click();
        }



        WebElement saveBtn=driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Save')]")));
        saveBtn= driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Save')]"));
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


//        Thread.sleep(4000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.REDIRECT_BLOCK));
//        redirectBlock= driver.findElement(XPathConstants.REDIRECT_BLOCK);
//        wait.until(ExpectedConditions.elementToBeClickable(redirectBlock));
//        highlightElement(driver,redirectBlock);
//        redirectBlock.click();
//
//
//
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.ITEMLIST));
//        List<WebElement> itemList= driver.findElements(XPathConstants.ITEMLIST);
//        for(WebElement item:itemList)
//        {
//            highlightElement(driver,item);
//            WebElement quantityRemainingElement= item.findElements(XPathConstants.REMAINING_QTY).get(1);
//            highlightElement(driver,quantityRemainingElement);
//            String qty= quantityRemainingElement.getText();
//
//            WebElement quantityInput= item.findElement(XPathConstants.QTY_INPUT);
//            highlightElement(driver,quantityInput);
//            quantityInput.sendKeys(qty);
//
//            Thread.sleep(2000);
//
//            WebElement radioGroup= item.findElement(XPathConstants.RADIO_BTN);
//            highlightElement(driver,radioGroup);
//
//            WebElement radioBtn= radioGroup.findElement(By.xpath(".//label"));
//            radioBtn.click();
//        }
//
//        Thread.sleep(1000);
//        selectAllItems= driver.findElement(XPathConstants.CHECKBOX_LABEL);
//        wait.until(ExpectedConditions.elementToBeClickable(selectAllItems));
//        selectAllItems.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
//        WebElement doneBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
//        wait.until(ExpectedConditions.elementToBeClickable(doneBtn));
//        highlightElement(driver,doneBtn);
//        doneBtn.click();
//
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));
//
//        Thread.sleep(3000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
//        WebElement submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
//        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
//        highlightElement(driver,submitBtn);
//        submitBtn.click();
//
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

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
    public void createStockTransfer() throws InterruptedException, IOException {

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_BLOCKS));
        WebElement actionsBlock= driver.findElement(XPathConstants.ACTION_BLOCKS);
        highlightElement(driver,actionsBlock);

        WebElement lotBtn= driver.findElements(XPathConstants.ACTION_ITEM).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(lotBtn));
        highlightElement(driver,lotBtn);
        lotBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ITEMS_LIST));
        WebElement listItem= driver.findElement(XPathConstants.ITEMS_LIST);
        wait.until(ExpectedConditions.elementToBeClickable(listItem));
        highlightElement(driver,listItem);
        listItem.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_WRAPPER));
        WebElement actionWrapper= driver.findElement(XPathConstants.ACTION_WRAPPER);
        highlightElement(driver,actionWrapper);

        WebElement createStockTransfer= actionWrapper.findElement(XPathConstants.ACTION_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createStockTransfer));
        highlightElement(driver,createStockTransfer);
        createStockTransfer.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SEARCH_WAREHOUSE_FIELD));
        WebElement searchInput= driver.findElement(XPathConstants.SEARCH_WAREHOUSE_FIELD);
        highlightElement(driver,searchInput);
        searchInput.sendKeys(empty_warehouse_nickname);

        Thread.sleep(7000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.WAREHOUSE_OPTION));
        List<WebElement> emptyWarehouses= driver.findElements(XPathConstants.WAREHOUSE_OPTION);

        WebElement requiredWarehouse= emptyWarehouses.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(requiredWarehouse));
        highlightElement(driver,requiredWarehouse);
        requiredWarehouse.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ITEMS_LIST));
        WebElement warehouseItem= driver.findElement(XPathConstants.ITEMS_LIST);
        highlightElement(driver,warehouseItem);

        WebElement radioLabel= warehouseItem.findElement(XPathConstants.RADIO_LABEL);
        wait.until(ExpectedConditions.elementToBeClickable(radioLabel));
        radioLabel.click();

        WebElement nextBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ITEM_TABLE));
        WebElement itemtable= driver.findElement(XPathConstants.ITEM_TABLE);
        highlightElement(driver,itemtable);

        List<WebElement> items= itemtable.findElements(By.xpath(".//tr"));

        for(WebElement item:items)
        {
            highlightElement(driver,item);

            List<WebElement> itemOptions= item.findElements(By.xpath(".//td"));

            WebElement transferrableQty= itemOptions.get(3);
            System.out.println(transferrableQty.getText());

            WebElement stockTransferInput= itemOptions.get(4);
            highlightElement(driver,stockTransferInput);

            WebElement inputField= stockTransferInput.findElement(By.xpath(".//input"));
            inputField.sendKeys(transferrableQty.getText().substring(0,2));
        }

        nextBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.RADIO_XPATH));
        WebElement isActualMovement= driver.findElement(XPathConstants.RADIO_XPATH);
        isActualMovement.click();

        WebElement consignee= driver.findElements(XPathConstants.RADIO_XPATH).get(2);
        consignee.click();

        WebElement fulfillmentSpoc= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(fulfillmentSpoc));
        highlightElement(driver,fulfillmentSpoc);
        fulfillmentSpoc.click();

        WebElement fulfillmentSpc_hint= driver.findElement(XPathConstants.FULFILLMENT_SPOC);
        fulfillmentSpc_hint.sendKeys("Anas");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.FULFILLMENT_SPOCVALUE));
        WebElement fullfillmentSpoc_value= driver.findElement(XPathConstants.FULFILLMENT_SPOCVALUE);
        wait.until(ExpectedConditions.elementToBeClickable(fullfillmentSpoc_value));
        highlightElement(driver, fullfillmentSpoc_value);
        fullfillmentSpoc_value.click();

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

        WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT);
        dateInput.sendKeys(date);


        nextBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement lspName= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(lspName));
        highlightElement(driver,lspName);
        lspName.click();

        WebElement lspName_hint= driver.findElement(XPathConstants.LSPNAME_HINT);
        lspName_hint.sendKeys("l");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.LSPNAME_VALUE));
        WebElement lsp_value= driver.findElement(XPathConstants.LSPNAME_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(lsp_value));
        highlightElement(driver,lsp_value);
        lsp_value.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement GST_dropdown= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(GST_dropdown));
        highlightElement(driver, GST_dropdown);
        GST_dropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.GST_VALUE));
        WebElement gstValue= driver.findElement(XPathConstants.GST_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(gstValue));
        highlightElement(driver,gstValue);
        gstValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_XPATH));
        WebElement ofbEntity_dropdown= driver.findElement(XPathConstants.MULTIPLE_USED_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntity_dropdown));
        highlightElement(driver, ofbEntity_dropdown);
        ofbEntity_dropdown.click();

        WebElement ofbEntity_hint= driver.findElement(XPathConstants.OFB_ENTITY_HINT);
        ofbEntity_hint.sendKeys("TKG");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.OFBENTITY_VALUE));
        WebElement ofbEntity_value= driver.findElement(XPathConstants.OFBENTITY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntity_value));
        highlightElement(driver, ofbEntity_value);
        ofbEntity_value.click();

        WebElement saveBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DELIVERY_OUT_LINK));
        WebElement deliveryOutLink= driver.findElement(XPathConstants.DELIVERY_OUT_LINK);
        wait.until(ExpectedConditions.elementToBeClickable(deliveryOutLink));
        highlightElement(driver,deliveryOutLink);
        deliveryOutLink.click();

        saveBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();
    }

    @Test(dependsOnMethods = "createStockTransfer")
    public void handleDeliveryOut() throws InterruptedException {

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_WRAPPER));
        WebElement actionWrapper= driver.findElement(XPathConstants.ACTION_WRAPPER);
        highlightElement(driver, actionWrapper);

        List<WebElement> actionBtns= actionWrapper.findElements(XPathConstants.ACTION_BTN);


        WebElement generateInvoiceBtn= actionBtns.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(generateInvoiceBtn));
        highlightElement(driver,generateInvoiceBtn);
        generateInvoiceBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUPPLIER_REF_NO));
        WebElement supplier_REF_No= driver.findElement(XPathConstants.SUPPLIER_REF_NO);
        supplier_REF_No.sendKeys("12345");

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

        WebElement dateInput= driver.findElement(XPathConstants.INVOICE_DATE);
        dateInput.sendKeys(date);

        WebElement generateBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(generateBtn));
        highlightElement(driver,generateBtn);
        generateBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPDATESTATUS_BTN));
        WebElement updateStatusBtn= driver.findElement(XPathConstants.UPDATESTATUS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver, updateStatusBtn);
        updateStatusBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TIME_INPUT));
        WebElement timeInput= driver.findElement(XPathConstants.TIME_INPUT);
        timeInput.sendKeys("11");
        Thread.sleep(400);
        timeInput.sendKeys("11");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
        datePicker= driver.findElement(XPathConstants.DATEPICKER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", datePicker);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(datePicker));
        datePicker.click();

        monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XPathConstants.CURRDATE);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XPathConstants.DATE_INPUT);
        dateInput.sendKeys(date);

        WebElement updateStatus= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(updateStatus));
        highlightElement(driver,updateStatus);
        updateStatus.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPDATESTATUS_BTN));
        updateStatusBtn= driver.findElement(XPathConstants.UPDATESTATUS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver, updateStatusBtn);
        updateStatusBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TIME_INPUT));
        timeInput= driver.findElement(XPathConstants.TIME_INPUT);
        timeInput.sendKeys("11");
        Thread.sleep(400);
        timeInput.sendKeys("11");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDIT_WRAPPER));
        WebElement editWrapper= driver.findElement(XPathConstants.EDIT_WRAPPER);

        List<WebElement> dataTableRows= editWrapper.findElements(XPathConstants.TABLE_ROW);
        for(WebElement dataRow: dataTableRows)
        {
            WebElement requestedQty= dataRow.findElement(XPathConstants.STOCKDELIVERY_PENDING);
            highlightElement(driver, requestedQty);

            WebElement qty_input= dataRow.findElement(XPathConstants.INPUTS);
            qty_input.sendKeys(requestedQty.getText());
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
        datePicker= driver.findElement(XPathConstants.DATEPICKER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", datePicker);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(datePicker));
        datePicker.click();

        monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XPathConstants.CURRDATE);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XPathConstants.DATE_INPUT);
        dateInput.sendKeys(date);

        WebElement uploadSlip= driver.findElement(XPathConstants.UPLOAD_STI);
        wait.until(ExpectedConditions.elementToBeClickable(uploadSlip));
        highlightElement(driver, uploadSlip);

        WebElement uploadSlip_input= uploadSlip.findElement(XPathConstants.UPLOADSLIP_INPUT);
        uploadSlip_input.sendKeys(prop.getProperty("file-path"));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.MULTIPLE_USED_XPATH));
        List<WebElement> partyOptions= driver.findElements(XPathConstants.MULTIPLE_USED_XPATH);

        WebElement issuingParty= partyOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(issuingParty));
        highlightElement(driver, issuingParty);
        issuingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PARTY_VALUE));
        WebElement issuingPartyValue= driver.findElement(XPathConstants.PARTY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(issuingPartyValue));
        highlightElement(driver, issuingPartyValue);
        issuingPartyValue.click();

        WebElement receivingParty= partyOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(receivingParty));
        highlightElement(driver, receivingParty);
        receivingParty.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PARTY_VALUE));
        WebElement receivingPartyValue= driver.findElement(XPathConstants.PARTY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(receivingPartyValue));
        highlightElement(driver,receivingPartyValue);
        receivingPartyValue.click();

        WebElement saveBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver, saveBtn);
        saveBtn.click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        updateStatus= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(updateStatus));
        highlightElement(driver,updateStatus);
        updateStatus.click();

        mainWindow= driver.getWindowHandle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TABLE_CONTAINER));
        WebElement tableContainer= driver.findElement(XPathConstants.TABLE_CONTAINER);
        highlightElement(driver, tableContainer);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TRANSFER_INVOICE_ROW));
        WebElement transferInvoiceRow= tableContainer.findElement(XPathConstants.TRANSFER_INVOICE_ROW);

        List<WebElement> variousOptions= transferInvoiceRow.findElements(By.xpath(".//td"));
        WebElement btn_options= variousOptions.get(5);
        highlightElement(driver, btn_options);

        WebElement publishTransferInvoiceBtn= btn_options.findElement(XPathConstants.PUBLISHBTN);
        wait.until(ExpectedConditions.elementToBeClickable(publishTransferInvoiceBtn));
        highlightElement(driver, publishTransferInvoiceBtn);
        publishTransferInvoiceBtn.click();

        for(String handle:driver.getWindowHandles())
            driver.switchTo().window(handle);

        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement verifyBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(verifyBtn));
        highlightElement(driver, verifyBtn);
        verifyBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACCEPT_TERMS));
        WebElement acceptTerms_checkBox= driver.findElement(XPathConstants.ACCEPT_TERMS);
        acceptTerms_checkBox.click();

        WebElement verifyInvoiceBtn= driver.findElements(XPathConstants.SUBMIT_BTN).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(verifyInvoiceBtn));
        highlightElement(driver, verifyInvoiceBtn);
        verifyInvoiceBtn.click();

        driver.switchTo().window(mainWindow);
        Thread.sleep(500);

        driver.navigate().refresh();
        Thread.sleep(1000);


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPDATESTATUS_BTN));
        updateStatusBtn= driver.findElement(XPathConstants.UPDATESTATUS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(updateStatusBtn));
        highlightElement(driver, updateStatusBtn);
        updateStatusBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TIME_INPUT));
        timeInput= driver.findElement(XPathConstants.TIME_INPUT);
        timeInput.sendKeys("11");
        Thread.sleep(400);
        timeInput.sendKeys("11");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
        datePicker= driver.findElement(XPathConstants.DATEPICKER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", datePicker);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(datePicker));
        datePicker.click();

        monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XPathConstants.CURRDATE);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XPathConstants.DATE_INPUT);
        dateInput.sendKeys(date);

        updateStatus= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(updateStatus));
        highlightElement(driver,updateStatus);
        updateStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ELLIPSIS_TEXT));
        WebElement deliveryInLink= driver.findElements(XPathConstants.ELLIPSIS_TEXT).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(deliveryInLink));
        highlightElement(driver, deliveryInLink);
        deliveryInLink.click();
    }

    @Test(dependsOnMethods = "handleDeliveryOut")
    public void updateTrackingDetails2() throws InterruptedException {

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



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TAB_CONTAINER));
        WebElement tabContainer= driver.findElement(XPathConstants.TAB_CONTAINER);
        highlightElement(driver, tabContainer);

        WebElement lspDetails= tabContainer.findElement(XPathConstants.LSP_DETAILS);
        wait.until(ExpectedConditions.elementToBeClickable(lspDetails));
        highlightElement(driver,lspDetails);
        lspDetails.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSHIPMENT_COST));
        WebElement editShipmentCost_btn= driver.findElement(XPathConstants.EDITSHIPMENT_COST);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editShipmentCost_btn);
        Thread.sleep(900);
        wait.until(ExpectedConditions.elementToBeClickable(editShipmentCost_btn));
        highlightElement(driver,editShipmentCost_btn);
        editShipmentCost_btn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.FREIGHTRATE));
        WebElement freightRate= driver.findElement(XPathConstants.FREIGHTRATE);
        freightRate.sendKeys("100");

        WebElement totalAmt= driver.findElement(By.xpath("//div[@class='taxTotalBlock']"));
        highlightElement(driver, totalAmt);
        System.out.println("For Assertion,total Amount is" + totalAmt.getText());

        WebElement qty= driver.findElement(By.xpath("//span[@class='quantityTxt']"));
        highlightElement(driver, qty);
        System.out.println("For assertion, total qty is "+ qty.getText());

        saveBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();


        //from heare

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.ACTION_ITEM));

        WebElement scrollTo= driver.findElement(By.xpath("//span[@class='supplierOrgName linkTxt']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollTo);
        Thread.sleep(2000);

        WebElement markDeliveredBtn= driver.findElements(XPathConstants.ACTION_ITEM).get(0);

        wait.until(ExpectedConditions.elementToBeClickable(markDeliveredBtn));
        highlightElement(driver,markDeliveredBtn);
        markDeliveredBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.AGREE_CHECKBOX));
        WebElement agree_checkBox= driver.findElement(XPathConstants.AGREE_CHECKBOX);
        agree_checkBox.click();

        WebElement amountElement= driver.findElement(XPathConstants.AMOUNT_ELEMENT);
        System.out.println("Amount To Use is "+ amountElement.getText());

        WebElement inputCaptcha= driver.findElement(XPathConstants.INPUT_CAPTCHA);
        inputCaptcha.sendKeys(amountElement.getText());

        WebElement agreeBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(agreeBtn));
        highlightElement(driver, agreeBtn);
        agreeBtn.click();



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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_WRAPPER));
        WebElement actionWrapper= driver.findElement(XPathConstants.ACTION_WRAPPER);
        highlightElement(driver,actionWrapper);

        WebElement viewInventory= actionWrapper.findElement(XPathConstants.VIEW_INVENTORY);
        wait.until(ExpectedConditions.elementToBeClickable(viewInventory));
        highlightElement(driver, viewInventory);
        viewInventory.click();

    }
}
