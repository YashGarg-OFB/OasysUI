import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class OfBusinessTest {
    class XPathConstaints
    {

        public static final By DRAWER= By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex");
        public static final By ORG_BTN= By.xpath("//span[@class='navItem']//span[text()='Organisation']");

        public static final By ADDCOMPANY= By.xpath("//button[text()='Add Company']");
        public static final By BUYER_OPTIONS= By.cssSelector(".orgTypeItem.navItem[role='button']");
        public static final By NEXT_BTN= By.xpath("//button[text()='Next']");
        public static final By CREATE_USING_ORG= By.className("createUsingNameBlock");
        public static final By COMPANY= By.id("Company");
        public static final By TURNOVER= By.id("tfid-0-3");
        public static final By INDUSTRY_TYPE= By.cssSelector("div.css-tlfecz-indicatorContainer");
        public static final By INDUSTRY_TYPE_VALUE= By.xpath("//div[@id='react-select-industry-option-0']");
        public static final By SUBINDUSTRY= By.xpath("//div[@id='industryType-tfid-0-2']");
        public static final By SUBINDUSTRY_VALUE= By.xpath("//div[@id='react-select-industryType-option-0']");

        public static final By PAYMENT_BUYERPO= By.className("heading");

        public static final By COMPANY_PROFILE= By.xpath("//button[text()='Company Profile']");
        public static final By TAX_SECTION= By.xpath("//button[text()='Tax/Compliances']");
        public static final By ADD_BTN= By.xpath("//button[text()='Add']");
        public static final By VERIFY_BTN= By.xpath("//button[text()='Verify']");
        public static final By GET_ADDRESS_BTN= By.xpath("//button[text()='Get Address ']");
        public static final By ADDRESSLINE_1= By.name("addressLine1");
        public static final By COUNTRY_NAME= By.xpath("//div[@id='countryCode-tfid-0-3']");
        public static final By COUNTRY_NAME_VALUE= By.xpath("//div[@class=' css-1ul4jvx-option']//div[text()='India']");

        public static final By DATEINPUT= By.className("react-datepicker-ignore-onclickoutside");
        public static final By ADDRESS_BTN= By.xpath("//button[text()='Addresses']");
        public static final By INNER_DETAILS= By.xpath("//div[@class='innerDetailsWrapper']");
        public static final By BILLING_ADDRESS_SPAN= By.xpath(".//div[contains(@class, 'action') and contains(@class, 'actionDrop')]");

        public static final By DROPDOWN= By.className("dropDownContent");
        public static final By BTN = By.tagName("button");
        public static final By UPLOAD_DOC= By.id("uploadAddrDoc");
        public static final By DOC_TYPE= By.id("documentType-tfid-0-1");
        public static final By DOCTYPE_OPTIONS= By.id("react-select-documentType-option-0");
        public static final By CONTACTS_BTN= By.xpath("//button[text()='Contacts']");
        public static final By DIV_ELEMENT= By.xpath("//div[contains(@class, 'action') and contains(@class, 'actionDrop')]");
        public static final By ROLE_VALUE= By.xpath("//div[@id='react-select-role-option-2']");
        public static final By RADIOGROUP= By.className("radio-group");
        public static final By OTP_RADIO_BTN= By.xpath(".//label[@class='radioLabel']");
        public static final By SEND_OTP_BTN= By.xpath("//button[text()='Send OTP']");
        public static final By OTP_INPUT= By.name("otp");


        public static final By LANDMARK_BASERATE= By.id("tfid-0-2");
        public static final By MULTIPLE_INPUT_XPATH= By.id("tfid-0-4");
        public static final By CHECKBOX_SECTION= By.className("checkBoxContent");
        public static final By CHECKBOX_OPTION= By.cssSelector("input[type='checkbox']");
        public static final By ACTION_BTNS= By.cssSelector("button.btn.btn-default");
        public static final By SUBCATEGORY= By.className("form-control");
        public static final By FREIGHT_RATE= By.id("tfid-0-6");
        public static final By LOADING_CHARGES= By.id("tfid-0-7");
        public static final By DROPDOWN_OPTIONS= By.className("reactSelectContainer");
        public static final By GST_OPTIONS= By.xpath("//div[@id='react-select-gst-option-2']");
        public static final By GST_OPTION= By.id("react-select-gst-option-2");
        public static final By COPY_BTN= By.className("copyBtn");
        public static final By SAVE_BTN= By.xpath("//button[@class='btn btn-primary' and contains(text(),'Save')]");

        public static final By SUBCATEGORY_FORM= By.className("subCategoryForm");
        public static final By BTN_XPATH= By.cssSelector("button.btn.btn-primary");
        public static final By BTNS_WRAP= By.className("btnsWrap");

        public static final By TOLERANCE_POSTALCODE = By.id("tfid-0-5");
        public static final By VIEW_DETAILS= By.xpath("//div[@class='optHeader']//span[@class='active']");
        public static final By APPROVAL_BTN = By.xpath("//button[@class='btn btn-default']");

        public static final By SUBMIT_BTN= By.xpath("//button[text()='Submit']");

        public static final By NAV_ITEMS= By.xpath("//ul[@class='nav-list']");
        public static final By SUPPLIERPO_BUYOUT= By.xpath("//ul[@class='inner-nav-list']//li");
        public static final By SUPPLIER_LIST = By.xpath("//div[@class='supplierWrapper']");
        public static final By APPROVEBTN= By.xpath(".//button[@class='btn btn-primary approveBtn']");
        public static final By LOADING= By.xpath("//span[@class='loading-icon m-r-10 hide']");

        public static final By DASHBOARD= By.xpath("//button[text()='Dashboard']");
        public static final By ACTION_WRAPPER= By.className("dashboardActionWrapper");
        public static final By ACTION_ITEM= By.className("actionItems");
        public static final By CATEGORYLIST= By.className("categoryList");
        public static final By CATEGORY_CARD= By.className("categoryCard");
        public static final By SUBCATEGORY_LIST=  By.xpath("//section[@class='subCategoriesWrapper']");
        public static final By ADD_TO_LIST= By.xpath("//button[text()='Add to List']");

        public static final By BUYER_PREFS= By.xpath("//span[text()='Buyer Preferences']");
        public static final By BUYER_PREFS_OPTIONS= By.className("contentView");
        public static final By ADDRESS_OPTIONS= By.xpath("//div[@class= ' css-1i8o47w']");
        public static final By SHIPPING_ADDRESS_OPTION= By.xpath("//div[@class=' css-yxf0z2']");
        public static final By BUYER_CONTAINER= By.className("buyerPoContainer");
        public static final By ADDRESS_PO_NUMBER = By.id("tfid-0-1");
        public static final By UPLOAD_FILE= By.id("upload-existing-quote");
        public static final By ACTION_BUTTONS= By.className("actionButtons");
        public static final By UPLOADDOCS= By.id("upload-document-undefined");
        public static final By SAVE= By.xpath("//button[text()='Save ']");
        public static final By EDIT_ENTITY= By.cssSelector("button.btnEdit.material-icons");
        public static final By ENTITY_NAME_SECTION= By.xpath("//div[@class='modalContent']//div[@id='ofbEntityName-tfid-0-0']");
        public static final By UPDATE_BTN= By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']");
        public static final By ITEM_SPECIFICATIONS= By.xpath("//div[@class='optHeader']//span");
        public static final By SUBMIT_QUOTE= By.xpath("//button[text()='Submit Buyer Quote ']");

        public static final By SUPPLIER_QUOTE= By.className("supplierQuote");
        public static final By MODAL_CONTENT= By.xpath("//div[@class='modalContent']");

        public static final By SAVEBTN= By.cssSelector("button.btn.btn-primary.saveBtn");
        public static final By SEND_FOR_APPROVAL= By.xpath("//button[text()='Send for Approval']");
        public static final By CHECK_BOX= By.xpath("//input[@class='enable']");
        public static final By EDITBTN= By.cssSelector("button.btn.btn-default.editBtn");

        public static final By SHOW_MORE_BTN= By.xpath(".//i[@class='material-icons']");
        public static final By CARTBTN= By.xpath("//div[@class='cartBtn ']");
        public static final By DATEPICKER= By.className("react-datepicker__input-container");
        public static final By MONTH_YEAR_BTN= By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown");
        public static final By CURRDATE= By.xpath("//div[contains(@class, 'react-datepicker__day--today')]");
        public static final By REDIRECT_BLOCK= By.xpath("//button[@class='redirectBlock']");
        public static final By ITEMLIST= By.xpath("//div[@class='lineItemCard']");
        public static final By CHECKBOX_LABEL= By.xpath("//label[@class='checkboxLabel']");
        public static final By RADIO_BTN= By.xpath(".//div[@class='radio-group']");
        public static final By BILLING_ADD_VALUE= By.xpath("//label[@class='radioLabel']");
        public static final By BILLINGADDRESS= By.id("react-select-billingAddress-option-0");
        public static final By ROLE_ADDRESS_OPTIONS= By.xpath("//div[@class=' css-17vhrl4']");
        public static final By PICKUP_ADDRESS_VALUE= By.xpath("//div[@class=' css-1m5nn3x']//div");
        public static final By ADDRESS_VALUE= By.xpath("//div[@class=' css-1ul4jvx-option']");
        public static final By ADDRESS_SECTION= By.xpath("//div[@class='modalContent']//div[@id='ofbEntityAddress-tfid-0-1']");
        public static final By INCENTIVE_REASON= By.id("reason-tfid-0-0");
        public static final By INCENTIVE_REASON_VALUE= By.id("react-select-reason-option-0");
        public static final By RADIO_GRP= By.xpath("//div[@class='radio-group']");
        public static final By INCENTIVE_LEVEL= By.xpath("//span[text()='Item Level']");
        public static final By PICKUPADDRESS= By.id("react-select-pickupAddress-option-0");

        public static final By DISPATCH_ACTION_BTN= By.cssSelector("button.btn.btn-primary.dispatchActionBtn");
        public static final By DISPATCH_SECTION= By.xpath("//div[@class='dispatchColumns']//tbody");
        public static final By DISPATCHQTY_INPUT= By.xpath("//input[@class='formControl Dispatch__formControl--les6J']");
        public static final By SHIPMENT_NEXT_BTN= By.cssSelector("button.Dispatch__btn--vR5sf.btn-primary");
        public static final By DISPATCH_CART= By.xpath("//div[@class='Dispatch__cartBtn--ABWNt']");

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
        public static final By ORDER_SECTION= By.cssSelector("button.md-raised.md-primary.side-menu-link.md-button.ng-scope.md-ofb-brown-theme.md-ink-ripple");
        public static final By RFQ_OPTIONS= By.xpath("//ul[@class='inner-nav-list']//li");
        public static final By BUYOUT_OPTION= By.xpath("//ul//ul//li//a[text()='Buyout ']");
        public static final By ORDER_LIST= By.xpath("//table[@class='customTable']");

        public static final By LINKS_LIST= By.className("links__list");
        public static final By ACTIONS= By.xpath("//div[@class='card linkGrid-2 spanChange1']//div[@class='links__list']");
        public static final By SUPPLIER= By.xpath("//div[@class='docTypeItem']");
        public static final By SELECT_SUPPLIER= By.cssSelector("button.btn.btn-default.extraBorder");
        public static final By SELECT_ITEM= By.xpath("//span[text()=' Item Name']");
        public static final By BUYER_ELEMENT= By.xpath(".//td[2]//span[@class='buyerName']");
        public static final By CHECKBOX= By.xpath("//div[@class='tableContainer']//span");
        public static final By ITEMS= By.xpath("//div[@class='input-group']");
        public static final By ITEMS_LIST= By.xpath("//tbody//tr");
        public static final By PENDING_QTY= By.xpath(".//div[@class='value pending']");
        public static final By MULTIPLE_USED_INPUT= By.id("tfid-0-0");
        public static final By ERROR_MSG= By.xpath("//div[@class='error-msg']");

        public static final By CREATE_SHIPMENT= By.xpath("//button[@class='Dispatch__actionBtn--q2vEq']");
        public static final By OPTIONS_SEARCHSUPPLIER= By.xpath("//div[@class=' css-1i8o47w']");
        public static final By SUPPLIER_HINT= By.xpath("//input[@id='selectSupplier-input-tfid-0-0']");
        public static final By SUPPLIER_OPTION= By.id("react-select-selectSupplier-option-0");
        public static final By ENTITY_ADDRESS= By.id("react-select-entityAddress-option-0");
        public static final By VERIFIER= By.xpath("//input[@id='poVerfier-input-tfid-0-6']");
        public static final By VERIFIER_VALUE= By.xpath("//div[@id='react-select-poVerfier-option-0']");
        public static final By CREATE_PO= By.xpath("//button[@class='btn btn-full btn-primary']");
        public static final By FULFILLMENTSPOC= By.xpath("//input[@id='fulfillmentSpoc-input-tfid-0-2']");
        public static final By LOGISTIC_MODE_HINT= By.xpath("//input[@id='logisticsMode-input-tfid-0-3']");
        public static final By TRUCK_TYPE_INPUT= By.xpath("//input[@id='truckType-input-tfid-0-4']");
        public static final By CREATE_SHIPMENT_BTN= By.xpath("//button[@class='Dispatch__btn--vR5sf btn-primary']");
        public static final By GO_TO_SHIPMENT_BTN= By.xpath("//button[text()='Go to Shipment']");



        public static final By INVOICES_SECTION= By.xpath("//md-tab-item//span[text()='Invoices']");
        public static final By INVOICE_DROPDOWN= By.xpath("//span[@class='labelPan ng-scope']");
        public static final By SALE_RETURN_BTN= By.xpath("//md-menu-content[@class='customMDMenuContent md-ofb-green-theme']//md-menu-item");
        public static final By RADIO_LABEL= By.xpath("//label[@class='radioLabel']");
        public static final By REASON_VALUE= By.xpath("//div[@id='react-select-reasonOfRejection-option-0']");
        public static final By TOGGLE_BTN= By.xpath("//label[@class='toggleSwitcherLabel']");
        public static final By PICKUPADDRESS_VALUE= By.xpath("//div[@id='react-select-pickupAddress-option-0']");
        public static final By NEXTBTN= By.xpath("//button[@class='btn btn-primary']");
        public static final By VIEW_DETAILS_BTN= By.xpath("//button[@class='btn btn-default']");
        public static final By TABLE_BODY= By.xpath("//table[@class='customTable']//tbody");
        public static final By SELECTITEM= By.xpath(".//span[@class='checkboxCustom']");
        public static final By CART_BTN= By.xpath("//div[@class='cartBtn']");
        public static final By VEHICLE_NUMBER= By.xpath("//input[@id='tfid-0-1']");
        public static final By DROP_BTN= By.xpath("//span[@class='material-icons-outlined']");
        public static final By DROPDOWN_BTN= By.xpath("//span[@class='buyerHeader']");
        public static final By VEHICLE_NO= By.xpath("//div[@class='purchaseReturnForm']//input[@id='tfid-0-1']");
        public static final By DATE_CONTAINER= By.xpath("//div[@class='purchaseReturnForm']//div[@class='react-datepicker__input-container']");
        public static final By EXPENSETYPE_VALUE= By.xpath("//div[contains(text(),'Courier Charges')]");
        public static final By SUB_EXPENSE= By.xpath("//div[@id='react-select-subExpenseType-option-0']");
        public static final By SAVEBUTTON= By.xpath("//button[@class='btn btn-default saveBtn']");
    }

    static WebDriver driver;
    static Properties prop;

    Faker faker = new Faker();
    String organisationName = faker.company().name() + " Test";
    String panNumber = "";
    static String RFQ_ID=null;
    String organizationID;
    static String mainWindow;

    public static void setCurrDate(WebDriver driver)
    {

        WebElement datePicker= driver.findElement(XPathConstaints.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
        dateInput.sendKeys(date);
    }

    public static void loadPropFile() throws IOException {
        prop = new Properties();
        FileInputStream fs = new FileInputStream("/home/yash/IdeaProjects/OasysUi/config.properties");
        prop.load(fs);

    }



    //@Test(testName = "set up")
    public void setUp() throws IOException {
        loadPropFile();
        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile5");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(prop.getProperty("stg5-url"));
        mainWindow = driver.getWindowHandle();
    }


//    @Test(dependsOnMethods = "setUp")
//    public void loginTest() throws InterruptedException {
//        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
//
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("iframe")));
//        WebElement frame = driver.findElements(By.tagName("iframe")).get(0); // Change the index as per your requirement
//        wait.until(ExpectedConditions.elementToBeClickable(frame));
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

    @Test
    public void handleOrganizationSection() throws InterruptedException, IOException {
        setUp();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(80));

        driver.switchTo().window(mainWindow);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.ORG_BTN));
        WebElement orgBtn = driver.findElement(XPathConstaints.ORG_BTN);
        highlightElement(driver, orgBtn);
        orgBtn.click();
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

    @Test(dependsOnMethods = "handleOrganizationSection")
    public void addCompany() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ADDCOMPANY));
        WebElement addCompany = driver.findElement(XPathConstaints.ADDCOMPANY);
        wait.until(ExpectedConditions.elementToBeClickable(addCompany));
        highlightElement(driver, addCompany);
        addCompany.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.BUYER_OPTIONS));
        List<WebElement> options = driver.findElements(XPathConstaints.BUYER_OPTIONS);
        WebElement buyerOption = options.get(0);
        System.out.println(buyerOption.getTagName());
        highlightElement(driver, buyerOption);
        buyerOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.NEXT_BTN));
        WebElement btnNext = driver.findElement(XPathConstaints.NEXT_BTN);
        btnNext.click();

        Thread.sleep(3000);
        WebElement mobileInput = driver.findElement(XPathConstaints.MULTIPLE_USED_INPUT);
        mobileInput.sendKeys(prop.getProperty("phone"));

        Thread.sleep(1000);
        WebElement btnNext2 = driver.findElement(XPathConstaints.NEXT_BTN);
        btnNext2.click();


        Thread.sleep(3000);
        WebElement createUsingOrgName = driver.findElement(XPathConstaints.CREATE_USING_ORG);
        highlightElement(driver, createUsingOrgName);
        createUsingOrgName.click();

        /*Thread.sleep(2000);
        WebElement individualBtn= driver.findElement(By.id("Individual"));
        highlightElement(driver,individualBtn);
        individualBtn.click();
        Thread.sleep(1000);
        WebElement btnNext3= driver.findElement(By.xpath("//button[text()='Next']"));
        btnNext3.click();


        Thread.sleep(3000);
        WebElement nameInput= driver.findElement(By.id("tfid-0-0"));
        highlightElement(driver,nameInput);
        nameInput.sendKeys(prop.getProperty("name"));

        Thread.sleep(1000);
        WebElement btnNext4= driver.findElement(By.xpath("//button[text()='Next']"));
        btnNext4.click();*/

    }

    @Test(dependsOnMethods = "addCompany")
    public void createUsingCompany() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.COMPANY));
        WebElement createByCompany = driver.findElement(XPathConstaints.COMPANY);
        wait.until(ExpectedConditions.elementToBeClickable(createByCompany));
        highlightElement(driver, createByCompany);
        createByCompany.click();

        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(XPathConstaints.NEXT_BTN));
        WebElement btnNext = driver.findElement(XPathConstaints.NEXT_BTN);
        btnNext.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOADING));

        //generate random name for organisation

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_INPUT));
        WebElement companyNameInput = driver.findElement(XPathConstaints.MULTIPLE_USED_INPUT);
        companyNameInput.sendKeys(organisationName);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.NEXT_BTN));
        WebElement btnNext2 = driver.findElement(XPathConstaints.NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(btnNext2));
        btnNext2.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOADING));




        wait.until(ExpectedConditions.elementToBeClickable(btnNext2));
        btnNext2.click();

        while (true)
        {
            try
            {
                wait.until(ExpectedConditions.presenceOfElementLocated(XPathConstaints.FREIGHT_RATE));
                WebElement contactName = driver.findElement(XPathConstaints.FREIGHT_RATE);
                if(contactName.isDisplayed())
                    break;
            }
            catch (Exception e)
            {
                System.out.println(e.getLocalizedMessage());
                wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.NEXT_BTN));
                btnNext2 = driver.findElement(XPathConstaints.NEXT_BTN);
                wait.until(ExpectedConditions.elementToBeClickable(btnNext2));
                btnNext2.click();

            }
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.FREIGHT_RATE));
        WebElement contactName = driver.findElement(XPathConstaints.FREIGHT_RATE);
        contactName.sendKeys(prop.getProperty("name"));

        WebElement postalCode = driver.findElement(XPathConstaints.TOLERANCE_POSTALCODE);
        postalCode.sendKeys(prop.getProperty("postalCode"));

        WebElement turnOver = driver.findElement(XPathConstaints.TURNOVER);
        turnOver.sendKeys(prop.getProperty("turnOver"));


        WebElement industryType = driver.findElement(XPathConstaints.INDUSTRY_TYPE);
        industryType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.INDUSTRY_TYPE_VALUE));
        WebElement industryTypeValue= driver.findElement(XPathConstaints.INDUSTRY_TYPE_VALUE);

        wait.until(ExpectedConditions.elementToBeClickable(industryTypeValue));
        highlightElement(driver,industryTypeValue);
        industryTypeValue.click();

        WebElement subIndustryType= driver.findElement(XPathConstaints.SUBINDUSTRY);
        wait.until(ExpectedConditions.elementToBeClickable(subIndustryType));
        highlightElement(driver,subIndustryType);
        subIndustryType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBINDUSTRY_VALUE));
        WebElement subIndustryValue= driver.findElement(XPathConstaints.SUBINDUSTRY_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(subIndustryValue));
        subIndustryValue.click();


//        WebElement option= driver.findElement(By.name("industry"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block'; arguments[0].style.visibility='visible';", option);
//
//        option.sendKeys("Distributor");
//
//        WebElement specificOption = driver.findElement(By.xpath("//div[contains(@class, 'div.css-tlfecz-indicatorContainer')]//input[@value='Manufacturing']"));
//        specificOption.click();

//        WebElement hiddenInput = driver.findElement(By.name("industry"));
//        String updatedValue = hiddenInput.getAttribute("value");
//        System.out.println("Updated Value: " + updatedValue);

//        Select select= new Select(industryType);
//
//        WebElement type= driver.findElement(By.name("industry"));


        //Actions builder = new Actions(driver);
        //WebElement hoverElement= driver.findElement(By.name("industry"));

//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].name='industry';",hoverElement);
//        hoverElement.click();
//        builder.moveToElement(hoverElement).build().perform();
//        builder.click();
        //By locator = By.id("clickElementID");
        //driver.click(locator);

        Thread.sleep(1000);
        WebElement btnNext3 = driver.findElement(XPathConstaints.NEXT_BTN);
        btnNext3.click();

        Thread.sleep(12000);
        String currUrl = driver.getCurrentUrl();
        System.out.println(currUrl);
        System.out.println(Arrays.toString(currUrl.split("/")));
        organizationID= currUrl.split("/")[4];
    }


    @Test(dependsOnMethods = "createUsingCompany")
    public void cachePanInRedis() throws InterruptedException {

        panNumber = new UtilityMethod().buildPan();

        String url = String.format("%s/api/v1/internal/pan/details/add?key=%s", prop.getProperty("stg5-be-url"), prop.getProperty("stg5-redis-key"));
        String jsonBody = String.format("{\"%s\": \"{\\\"vendor\\\": \\\"KARZA\\\",\\\"verified\\\":true,\\\"errorMessage\\\":null,\\\"details\\\":{\\\"title\\\":\\\"M/s\\\",\\\"firstName\\\":\\\"\\\",\\\"middleName\\\":\\\"\\\",\\\"lastName\\\":\\\"%s\\\",\\\"lastUpdated\\\":\\\"28/01/2024\\\"}}\"}", panNumber, organisationName);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        try {
            System.out.println(panNumber);
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            if (statusCode == 200) {
                System.out.println("API call successful. Status code: 200");
            } else {
                System.out.println("API call failed. Status code: " + statusCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "cachePanInRedis")
    public void doGstVerification() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.COMPANY_PROFILE));
        WebElement companyProfile = driver.findElement(XPathConstaints.COMPANY_PROFILE);
        wait.until(ExpectedConditions.elementToBeClickable(companyProfile));
        highlightElement(driver, companyProfile);
        companyProfile.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.TAX_SECTION));
        WebElement tax = driver.findElement(XPathConstaints.TAX_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(tax));
        highlightElement(driver, tax);
        tax.click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.ADD_BTN));
        List<WebElement> addBtnList = driver.findElements(XPathConstaints.ADD_BTN);
        highlightElement(driver, addBtnList.get(0));
        Thread.sleep(1000);
        addBtnList.get(0).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_INPUT));
        WebElement PANinput = driver.findElement(XPathConstaints.MULTIPLE_USED_INPUT);
        PANinput.sendKeys(panNumber);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.VERIFY_BTN));
        WebElement verifyBtn = driver.findElement(XPathConstaints.VERIFY_BTN);
        highlightElement(driver, verifyBtn);
        verifyBtn.click();

        Thread.sleep(3500);
        WebElement addGstBtn = addBtnList.get(3);
        wait.until(ExpectedConditions.elementToBeClickable(addGstBtn));
        highlightElement(driver, addGstBtn);
        addGstBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_INPUT));
        WebElement gstInput = driver.findElement(XPathConstaints.MULTIPLE_USED_INPUT);
        gstInput.sendKeys("06" + panNumber + "1ZC");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.GET_ADDRESS_BTN));
        WebElement getAddress = driver.findElement(XPathConstaints.GET_ADDRESS_BTN);
        highlightElement(driver, getAddress);
        getAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ADDRESSLINE_1));
        WebElement firstAddress = driver.findElement(XPathConstaints.ADDRESSLINE_1);
        firstAddress.sendKeys("testLine1");
        WebElement secAddress = driver.findElement(XPathConstaints.ADDRESS_PO_NUMBER);
        secAddress.sendKeys("testline2");
        WebElement landmark = driver.findElement(XPathConstaints.LANDMARK_BASERATE);
        landmark.sendKeys("testmark");
        WebElement postalCode = driver.findElement(XPathConstaints.MULTIPLE_INPUT_XPATH);
        postalCode.sendKeys(prop.getProperty("postalCode"));

        WebElement countryInput= driver.findElement(XPathConstaints.COUNTRY_NAME);
        countryInput.click();
        System.out.println("Is Displayed :   "+countryInput.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.COUNTRY_NAME_VALUE));
        WebElement countryValue= driver.findElement(XPathConstaints.COUNTRY_NAME_VALUE);
        System.out.println("The value of country is "+ countryValue.getText());
        wait.until(ExpectedConditions.elementToBeClickable(countryValue));
        highlightElement(driver,countryValue);
        countryValue.click();

        Thread.sleep(1500);
        WebElement datePicker= driver.findElement(XPathConstaints.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
        dateInput.sendKeys(date);

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement submitBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

    }

    @Test(dependsOnMethods = "doGstVerification")
    public void doAddressVerification() throws InterruptedException
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOADING));


        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ADDRESS_BTN));
        WebElement addressBtn = driver.findElement(XPathConstaints.ADDRESS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addressBtn));
        highlightElement(driver,addressBtn);
        addressBtn.click();

        Thread.sleep(5000);
        Actions actions= new Actions(driver);
        List<WebElement> divs= driver.findElements(XPathConstaints.INNER_DETAILS);
        for(WebElement div:divs)
        {
            highlightElement(driver,div);
            WebElement containsBillingAddress= div.findElement(By.xpath(".//span"));
            if(containsBillingAddress.getText().equalsIgnoreCase("Billing Address"))
            {
                highlightElement(driver,containsBillingAddress);
                WebElement div_element = div.findElement(XPathConstaints.BILLING_ADDRESS_SPAN);
                WebElement span_element = div_element.findElement(By.xpath(".//span"));
                WebElement i_element = span_element.findElement(XPathConstaints.SHOW_MORE_BTN);
                actions.moveToElement(i_element).build().perform();

                WebElement listOfOptions= div.findElement(XPathConstaints.DROPDOWN);
                List<WebElement> items= listOfOptions.findElements(By.tagName("li"));
                WebElement verifyAddress= items.get(2).findElement(XPathConstaints.BTN);
                verifyAddress.click();

                break;
            }
        }

        Thread.sleep(3000);
        WebElement uploadFile= driver.findElement(XPathConstaints.UPLOAD_DOC);
        uploadFile.sendKeys(prop.getProperty("file-path"));

        Thread.sleep(3000);
        WebElement docType = driver.findElement(XPathConstaints.DOC_TYPE);
        docType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DOCTYPE_OPTIONS));
        WebElement docTypeOptions= driver.findElement(XPathConstaints.DOCTYPE_OPTIONS);
        docTypeOptions.click();

        Thread.sleep(2000);
        WebElement submitBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        highlightElement(driver,submitBtn);
        submitBtn.click();


    }

    public String getOtp() throws IOException {
        //loadPropFile();
        String url = String.format("%s/api/v1/internal/otp?mobile=%s&key=%s", prop.getProperty("stg5-be-url"), prop.getProperty("phone"),prop.getProperty("stg5-redis-key"));

        System.out.println(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            int statusCode = response.statusCode();

            if (statusCode == 200) {
                JSONObject jsonObject = new JSONObject(response.body());

                // Get the value of "data" field
                Object dataValue = jsonObject.get("data");
                System.out.println("Current otp value: "+ dataValue);
                return dataValue.toString();
                //System.out.println("API call successful. Status code: 200");
            } else {
                System.out.println("API call failed. Status code: " + statusCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test(dependsOnMethods = "doAddressVerification")
    public void doMobileVerification() throws InterruptedException, IOException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));



        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOADING));


        Thread.sleep(20000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CONTACTS_BTN));
        WebElement contactsBtn = driver.findElement(XPathConstaints.CONTACTS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(contactsBtn));
        highlightElement(driver,contactsBtn);
        contactsBtn.click();

        Thread.sleep(4000);
        Actions actions= new Actions(driver);
        WebElement div_element = driver.findElement(XPathConstaints.DIV_ELEMENT);
        WebElement span_element = div_element.findElement(By.xpath(".//span"));
        WebElement i_element = span_element.findElement(XPathConstaints.SHOW_MORE_BTN);
        actions.moveToElement(i_element).build().perform();

        WebElement listOfOptions= driver.findElement(XPathConstaints.DROPDOWN);
        List<WebElement> items= listOfOptions.findElements(By.tagName("li"));

        WebElement editBtn= items.get(0).findElement(XPathConstaints.BTN);
        editBtn.click();

        Thread.sleep(2000);
        WebElement emailInput= driver.findElement(XPathConstaints.MULTIPLE_INPUT_XPATH);
        emailInput.clear();
        emailInput.sendKeys(prop.getProperty("test-email"));

        WebElement roleDropDpown = driver.findElement(XPathConstaints.ROLE_ADDRESS_OPTIONS);
        roleDropDpown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ROLE_VALUE));
        WebElement dropdown_option= driver.findElement(XPathConstaints.ROLE_VALUE);
        dropdown_option.click();


        Thread.sleep(2000);
        WebElement submitBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        highlightElement(driver,submitBtn);
        submitBtn.click();

        Thread.sleep(1500);
        div_element = driver.findElement(XPathConstaints.DIV_ELEMENT);
        span_element = div_element.findElement(By.xpath(".//span"));
        i_element = span_element.findElement(XPathConstaints.SHOW_MORE_BTN);
        actions.moveToElement(i_element).build().perform();

        Thread.sleep(2000);

        WebElement verifyMobile= items.get(2).findElement(XPathConstaints.BTN);
        System.out.println(items.toString());
        wait.until(ExpectedConditions.elementToBeClickable(verifyMobile));
        verifyMobile.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.RADIOGROUP));
        WebElement radioGroup= driver.findElement(XPathConstaints.RADIOGROUP);
        highlightElement(driver,radioGroup);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BILLING_ADD_VALUE));
        WebElement otpOption= radioGroup.findElement(XPathConstaints.OTP_RADIO_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(otpOption));
        otpOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SEND_OTP_BTN));
        WebElement sendOtp= driver.findElement(XPathConstaints.SEND_OTP_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(sendOtp));
        sendOtp.click();

        Thread.sleep(3000);
        String otp= getOtp();
        Thread.sleep(2000);

        WebElement otpInput= driver.findElement(XPathConstaints.OTP_INPUT);
        otpInput.sendKeys(otp);

        Thread.sleep(2000);
        WebElement submitBtn2= driver.findElement(XPathConstaints.SUBMIT_BTN);
        highlightElement(driver,submitBtn2);
        submitBtn2.click();
    }


    @Test(dependsOnMethods = "doMobileVerification")
    public static void createRFQ() throws InterruptedException
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DASHBOARD));
        WebElement dashBoardSection = driver.findElement(XPathConstaints.DASHBOARD);
        wait.until(ExpectedConditions.elementToBeClickable(dashBoardSection));
        highlightElement(driver, dashBoardSection);
        dashBoardSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ACTION_WRAPPER));
        WebElement dashBoard= driver.findElement(XPathConstaints.ACTION_WRAPPER);
        wait.until(ExpectedConditions.elementToBeClickable(dashBoard));
        highlightElement(driver,dashBoard);

        List<WebElement> blocks= dashBoard.findElements(XPathConstaints.ACTION_ITEM);
        WebElement currBlock = null;
        for(WebElement block:blocks)
            currBlock= block;
        highlightElement(driver,currBlock);

        List<WebElement> actionItems= currBlock.findElements(XPathConstaints.BTN);

        WebElement createRFQ=  actionItems.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(createRFQ));
        highlightElement(driver,createRFQ);
        createRFQ.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OFB Tech']")));
        driver.findElement(By.xpath("//button[text()='OFB Tech']")).click();

        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,600)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CATEGORYLIST));
        WebElement categoryList= driver.findElement(XPathConstaints.CATEGORYLIST);
        Thread.sleep(2000);
        WebElement category= categoryList.findElements(XPathConstaints.CATEGORY_CARD).get(17);
        WebElement viewProducts= category.findElement(XPathConstaints.BTN);
        viewProducts.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBCATEGORY_LIST));
        WebElement subCategoryList= driver.findElement(XPathConstaints.SUBCATEGORY_LIST);
        List<WebElement> subCategoryCards= subCategoryList.findElements(XPathConstaints.CATEGORY_CARD);

        subCategoryCards.get(0).findElement(XPathConstaints.ADD_TO_LIST).click();
        subCategoryCards.get(1).findElement(XPathConstaints.ADD_TO_LIST).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.NEXT_BTN));
        WebElement btnNext= driver.findElement(XPathConstaints.NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(btnNext));
        highlightElement(driver,btnNext);
        btnNext.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.SUBCATEGORY_FORM));
        List<WebElement> addedItemsList= driver.findElements(XPathConstaints.SUBCATEGORY_FORM);
        for(WebElement item: addedItemsList)
        {
            item.findElement(XPathConstaints.SUBCATEGORY).sendKeys("100");
        }
        Thread.sleep(1000);
        WebElement btnNext2= driver.findElement(XPathConstaints.NEXT_BTN);
        btnNext2.click();

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        WebElement pinCode= driver.findElement(XPathConstaints.ADDRESS_PO_NUMBER);
        pinCode.sendKeys(prop.getProperty("postalCode"));


        WebElement datePicker= driver.findElement(XPathConstaints.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
        dateInput.sendKeys(date);
        System.out.println(date);

        WebElement uploadFileType= driver.findElement(XPathConstaints.UPLOAD_FILE);
        uploadFileType.sendKeys(prop.getProperty("file-path"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ACTION_BUTTONS));
        WebElement actionButtons= driver.findElement(XPathConstaints.ACTION_BUTTONS);
        WebElement button= actionButtons.findElement(XPathConstaints.BTN_XPATH);
        highlightElement(driver,button);
        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ACTION_BUTTONS));
        WebElement actionButtons2= driver.findElement(XPathConstaints.ACTION_BUTTONS);
        WebElement submitBtn= actionButtons2.findElement(XPathConstaints.BTN_XPATH);
        highlightElement(driver,submitBtn);
        submitBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BTNS_WRAP));
        WebElement viewEnquirySection= driver.findElement(XPathConstaints.BTNS_WRAP);
        viewEnquirySection.findElement(XPathConstaints.BTN_XPATH).click();

        /*Thread.sleep(2000);
        WebElement uploadPO= driver.findElement(By.className("uploadButton"));
        uploadPO.click();

        //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        Thread.sleep(2000);
        WebElement POinput= driver.findElement(By.xpath("//div[@class='PONumber']//input[@type='text']"));
        POinput.sendKeys(prop.getProperty("PONumber"));

        WebElement footer= driver.findElement(By.className("modalFooter"));
        footer.findElement(By.cssSelector("button.btn.btn-primary")).click();


        uploadPO.sendKeys("/home/yash/Pictures/Screenshots/screenshot.png");*/

        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        RFQ_ID= url.split("/")[6];
        System.out.println(RFQ_ID);

        UtilityMethod.setRFQ_ID(RFQ_ID);
    }

    @Test( dependsOnMethods = "createRFQ")
    public void handleCMS() throws InterruptedException, IOException {
        //setUp();
        if(driver==null)
        {
            setUp();
        }
        driver.get(prop.getProperty("stg5-cms-url"));
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DRAWER));

        WebElement drawer= driver.findElement(XPathConstaints.DRAWER);
        highlightElement(driver,drawer);

        //List<WebElement> options= driver.findElements(XPathConstaints.ORDER_SECTION);
        WebElement orderSection= driver.findElement(By.xpath("//span[text()='RFQs']"));
        wait.until(ExpectedConditions.elementToBeClickable(orderSection));
        highlightElement(driver,orderSection);
        orderSection.click();
//        WebElement rfqBtn= options.get(21);
//        highlightElement(driver,rfqBtn);
//        rfqBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Buyout']")));
        WebElement buyoutBtn= driver.findElement(By.xpath("//button[@aria-label='Buyout']"));
        wait.until(ExpectedConditions.elementToBeClickable(buyoutBtn));
        highlightElement(driver,buyoutBtn);
        buyoutBtn.click();
//        List<WebElement> rfqOptions= driver.findElements(XPathConstaints.RFQ_OPTIONS);
//        highlightElement(driver,rfqOptions.get(1));
//        rfqOptions.get(1).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_INPUT));
        WebElement searchRFQ= driver.findElement(XPathConstaints.MULTIPLE_USED_INPUT);

        System.out.println("Utility RFQ_ID "+ UtilityMethod.getRFQ_ID());

        searchRFQ.sendKeys(UtilityMethod.getRFQ_ID());

        driver.findElement(By.cssSelector("button.btn.search-btn")).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath("//div[@class='rfqListTable']//tbody//tr")).click();

        System.out.println("Before Check Box");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.COPY_BTN));
            WebElement copyRatesToAll= subcategoryForm.findElement(XPathConstaints.COPY_BTN);
            if(copyRatesToAll.isDisplayed())
                copyRatesToAll.click();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SAVE_BTN));
            WebElement saveBtn = driver.findElement(XPathConstaints.SAVE_BTN);
            wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
            highlightElement(driver,saveBtn);
            saveBtn.click();

        }
    }

    @Test(dependsOnMethods = "handleCMS")
    public void handleBuyerPrefs() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BUYER_PREFS));

        WebElement buyerPrefs= driver.findElement(XPathConstaints.BUYER_PREFS);
        highlightElement(driver,buyerPrefs);
        buyerPrefs.click();

        List<WebElement> buyerPrefsOptions= driver.findElements(XPathConstaints.BUYER_PREFS_OPTIONS);

        WebElement preferences= buyerPrefsOptions.get(0).findElement(XPathConstaints.PAYMENT_BUYERPO);
        preferences.click();

        WebElement editBtn=  buyerPrefsOptions.get(0).findElement(XPathConstaints.ACTION_BTNS);
        highlightElement(driver,editBtn);
        editBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("address")));
//        WebElement billingAddress= driver.findElement(By.className("address"));
//        highlightElement(driver,billingAddress);
//        billingAddress.click();
//
//        WebElement addressValue= driver.findElement(By.className("addressValue"));
//        highlightElement(driver,addressValue);
//        addressValue.click();

        List<WebElement> addressesOptions= driver.findElements(XPathConstaints.ADDRESS_OPTIONS);
        WebElement shippingAddressBtn= addressesOptions.get(2);
        highlightElement(driver,shippingAddressBtn);
        shippingAddressBtn.click();

        List<WebElement> shippingAddressOptions= driver.findElements(XPathConstaints.SHIPPING_ADDRESS_OPTION);
        if(!shippingAddressOptions.isEmpty())
            shippingAddressOptions.get(0).click();

        WebElement toleranceInput= buyerPrefsOptions.get(0).findElement(XPathConstaints.TOLERANCE_POSTALCODE);
        toleranceInput.sendKeys("0");

        WebElement saveAddressBtn= buyerPrefsOptions.get(0).findElement(XPathConstaints.BTN_XPATH);
        saveAddressBtn.click();



        WebElement paymentTerms=  buyerPrefsOptions.get(1);
        WebElement paymentTermsSection= paymentTerms.findElement(XPathConstaints.PAYMENT_BUYERPO);
        highlightElement(driver,paymentTermsSection);
        paymentTermsSection.click();
        WebElement editBtn2= paymentTerms.findElement(XPathConstaints.ACTION_BTNS);
        highlightElement(driver,editBtn2);
        editBtn2.click();

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
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
        highlightElement(driver,uploadBuyerPoSection);
        uploadBuyerPoSection.click();

        WebElement checkBox= driver.findElement(XPathConstaints.CHECK_BOX);
        checkBox.click();
        System.out.println("Check Box Clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.EDITBTN));
        WebElement editBtn3= uploadPO.findElement(XPathConstaints.EDITBTN);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn3));
        highlightElement(driver,editBtn3);
        editBtn3.click();

        WebElement buyerContainer= uploadPO.findElement(XPathConstaints.BUYER_CONTAINER);
        WebElement PO_No= buyerContainer.findElement(XPathConstaints.ADDRESS_PO_NUMBER);
        highlightElement(driver,PO_No);
        PO_No.sendKeys("12232");

        WebElement datePicker= driver.findElement(XPathConstaints.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
        dateInput.sendKeys(date);

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ENTITY_NAME_SECTION));
        WebElement entityNameSection= driver.findElement(XPathConstaints.ENTITY_NAME_SECTION);
        highlightElement(driver,entityNameSection);
        entityNameSection.click();

        WebElement entityName= entityNameSection.findElement(XPathConstaints.ADDRESS_VALUE);
        entityName.click();

        WebElement addressSection= driver.findElement(XPathConstaints.ADDRESS_SECTION);
        highlightElement(driver,addressSection);
        addressSection.click();

        WebElement addressValue= addressSection.findElement(XPathConstaints.ADDRESS_VALUE);
        highlightElement(driver,addressValue);
        addressValue.click();

        WebElement updateBtn= driver.findElement(XPathConstaints.UPDATE_BTN);
        updateBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ITEM_SPECIFICATIONS));
        WebElement itemSpecifications= driver.findElement(XPathConstaints.ITEM_SPECIFICATIONS);
        itemSpecifications.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_QUOTE));
        WebElement submitBuyerQuote= driver.findElement(XPathConstaints.SUBMIT_QUOTE);

        wait.until(ExpectedConditions.elementToBeClickable(submitBuyerQuote));
        highlightElement(driver,submitBuyerQuote);
        submitBuyerQuote.click();
    }

    @Test(dependsOnMethods = "handleBuyerPrefs")
    public void handleSupplierQuotation() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUPPLIER_QUOTE));
        WebElement supplierQuote= driver.findElement(XPathConstaints.SUPPLIER_QUOTE);
        highlightElement(driver,supplierQuote);
        supplierQuote.click();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        WebElement checkBoxSection= driver.findElement(XPathConstaints.CHECKBOX_SECTION);
        highlightElement(driver,checkBoxSection);

        System.out.println("After check Box");

        WebElement checkoption= checkBoxSection.findElement(XPathConstaints.CHECKBOX_OPTION);
        highlightElement(driver,checkoption);
        checkoption.click();
        System.out.println("Check Box Clicked");

        WebElement addSupplier= driver.findElements(XPathConstaints.BTN_XPATH).get(1);
        highlightElement(driver,addSupplier);
        addSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.OPTIONS_SEARCHSUPPLIER));
        WebElement searchSupplier= driver.findElement(XPathConstaints.OPTIONS_SEARCHSUPPLIER);
        searchSupplier.click();

        WebElement supplier_hint= driver.findElement(XPathConstaints.SUPPLIER_HINT);
        supplier_hint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUPPLIER_OPTION));
        WebElement supplierOptions= driver.findElement(XPathConstaints.SUPPLIER_OPTION);
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

        List<WebElement> addressOptions= driver.findElements(XPathConstaints.ROLE_ADDRESS_OPTIONS);
        System.out.println(addressOptions.size());
        WebElement pickupAddress= addressOptions.get(4);
        pickupAddress.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.PICKUP_ADDRESS_VALUE));
        WebElement pickupAddressValue= driver.findElement(XPathConstaints.PICKUP_ADDRESS_VALUE);
        pickupAddressValue.click();

        WebElement billingAddress= addressOptions.get(2);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ADDRESS_VALUE));
        WebElement billingAddressvalue= driver.findElement(XPathConstaints.ADDRESS_VALUE);
        billingAddressvalue.click();

        System.out.println("Done till here");
        WebElement incentiveReason= driver.findElement(XPathConstaints.INCENTIVE_REASON);
        wait.until(ExpectedConditions.visibilityOf(incentiveReason));
        highlightElement(driver,incentiveReason);
        incentiveReason.click();

        WebElement incentiveReasonValue= driver.findElement(XPathConstaints.INCENTIVE_REASON_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(incentiveReasonValue));
        highlightElement(driver,incentiveReasonValue);
        incentiveReasonValue.click();

        System.out.println("Done");

        List<WebElement> radioGroups= driver.findElements(XPathConstaints.RADIO_GRP);

        WebElement incentiveTypes= radioGroups.get(2);
        incentiveTypes.findElement(By.xpath("//span[text()='Incoming']")).click();

        WebElement taxTypes= radioGroups.get(3);
        taxTypes.findElement(By.xpath("//span[text()='Without Tax']")).click();

//        WebElement incentiveLevel= radioGroups.get(4);
//        incentiveLevel.findElement(By.xpath("//span[text()='Item Level']")).click();

        WebElement incentiveLevel= driver.findElements(XPathConstaints.INCENTIVE_LEVEL).get(1);
        incentiveLevel.click();

        Thread.sleep(2500);
        WebElement nextBtn= driver.findElement(XPathConstaints.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        List<WebElement> subcategoryForms= driver.findElements(XPathConstaints.SUBCATEGORY_FORM);
        for(WebElement subcategoryForm:subcategoryForms)
        {
            WebElement itemQty= subcategoryForm.findElement(XPathConstaints.MULTIPLE_USED_INPUT);
            itemQty.clear();
            itemQty.sendKeys("100");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MULTIPLE_USED_INPUT));
        WebElement itemQty= driver.findElement(XPathConstaints.MULTIPLE_USED_INPUT);
        itemQty.clear();
        itemQty.sendKeys("100");

        WebElement baseRate= driver.findElement(XPathConstaints.LANDMARK_BASERATE);
        baseRate.sendKeys("100");

        WebElement freightRate= driver.findElement(XPathConstaints.MULTIPLE_INPUT_XPATH);
        freightRate.sendKeys("10");


        Thread.sleep(3000);
        WebElement dropDownOptions= driver.findElement(XPathConstaints.DROPDOWN_OPTIONS);
        dropDownOptions.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.GST_OPTIONS));

        WebElement gstOption= driver.findElement(XPathConstaints.GST_OPTIONS);
        highlightElement(driver,gstOption);
        gstOption.click();

        WebElement copyRatesToAll= driver.findElement(XPathConstaints.COPY_BTN);
        if(copyRatesToAll.isDisplayed())
            copyRatesToAll.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BTN_XPATH));
        WebElement saveBtn= driver.findElement(XPathConstaints.BTN_XPATH);
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.VIEW_DETAILS));
        WebElement viewDetails= driver.findElement(XPathConstaints.VIEW_DETAILS);
        highlightElement(driver,viewDetails);
        viewDetails.click();

        wait.until(ExpectedConditions.elementToBeClickable(XPathConstaints.APPROVAL_BTN));
        WebElement sendForApproval= driver.findElement(XPathConstaints.APPROVAL_BTN);

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();


        //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BTN_XPATH));
        WebElement createOrder= driver.findElement(XPathConstaints.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(createOrder));
        highlightElement(driver,createOrder);
        createOrder.click();

        Thread.sleep(10000);
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
    public void  createPO() throws InterruptedException, IOException {

        //driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));

        Thread.sleep(60000);

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(mainWindow);
        // change focus to new tab
        driver.switchTo().window(newTab.get(0));


//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-fe/order/OFB117165393314709");

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));



        /*WebElement orderSection= driver.findElements(By.xpath("//ul[@class='nav-list']")).get(5);
        wait.until(ExpectedConditions.elementToBeClickable(orderSection));
        highlightElement(driver,orderSection);
        orderSection.click();

        WebElement buyoutBtn= orderSection.findElements(By.xpath("//ul[@class='inner-nav-list']//li")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(buyoutBtn));
        highlightElement(driver,buyoutBtn);
        buyoutBtn.click();

        String buyerName= organisationName;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='customTable']")));
        WebElement orderList= driver.findElement(By.xpath("//table[@class='customTable']"));
        highlightElement(driver,orderList);

        List<WebElement> buyers= orderList.findElements(By.xpath(".//tbody//tr"));
        for(WebElement buyer:buyers)
        {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement buyerElement= buyer.findElement(By.xpath(".//td[2]//span[@class='buyerName']"));
            if(buyerElement.getText().equalsIgnoreCase(buyerName))
            {
                highlightElement(driver,buyer);
                buyer.click();
                break;
            }
        }
        */



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ACTIONS));
        WebElement actions= driver.findElement(XPathConstaints.ACTIONS);

        List<WebElement> actionButtons= actions.findElements(XPathConstaints.BTN);
        actionButtons.get(5).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUPPLIER));
        WebElement supplier= driver.findElement(XPathConstaints.SUPPLIER);
        highlightElement(driver,supplier);
        supplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SELECT_SUPPLIER));
        WebElement selectSupplier= driver.findElement(XPathConstaints.SELECT_SUPPLIER);
        highlightElement(driver,selectSupplier);
        selectSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SELECT_ITEM));
        WebElement checbox= driver.findElement(XPathConstaints.SELECT_ITEM);
        wait.until(ExpectedConditions.elementToBeClickable(checbox));
        checbox.click();

        WebElement nextBtn= driver.findElement(XPathConstaints.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DATEPICKER));
        WebElement datePicker= driver.findElement(XPathConstaints.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
        dateInput.sendKeys(date);

        WebElement ofbAddress= driver.findElement(XPathConstaints.OPTIONS_SEARCHSUPPLIER);
        highlightElement(driver,ofbAddress);
        ofbAddress.click();

        Thread.sleep(1400);
        WebElement addressValue= driver.findElement(XPathConstaints.ENTITY_ADDRESS);
        highlightElement(driver,addressValue);
        addressValue.click();

        WebElement PO_Verifier= driver.findElement(XPathConstaints.OPTIONS_SEARCHSUPPLIER);
        highlightElement(driver,PO_Verifier);
        PO_Verifier.click();

        WebElement verifierName_input= driver.findElement(XPathConstaints.VERIFIER);
        verifierName_input.sendKeys("Anshul Jain");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.VERIFIER_VALUE));
        WebElement verifierValue= driver.findElement(XPathConstaints.VERIFIER_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(verifierValue));
        verifierValue.click();


        WebElement createPO_Btn= driver.findElement(XPathConstaints.CREATE_PO);
        wait.until(ExpectedConditions.elementToBeClickable(createPO_Btn));
        highlightElement(driver,createPO_Btn);
        createPO_Btn.click();

        Thread.sleep(4000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstaints.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.MODAL_CONTENT));
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

    @Test(dependsOnMethods = "createPO")
    public void verifyPO() throws IOException, InterruptedException {
        loadPropFile();
        Thread.sleep(2000);
        addCookie(driver,prop.getProperty("supplier-auth-token"));

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='nav-item L1 makeActive']")));

        Thread.sleep(3000);
        WebElement verifySection= driver.findElements(XPathConstaints.NAV_ITEMS).get(7);
        highlightElement(driver,verifySection);
        verifySection.click();

        WebElement supplierPOBtn= verifySection.findElement(XPathConstaints.SUPPLIERPO_BUYOUT);
        wait.until(ExpectedConditions.elementToBeClickable(supplierPOBtn));
        highlightElement(driver,supplierPOBtn);
        supplierPOBtn.click();

        Thread.sleep(8000);

        List<WebElement> supplierList= driver.findElements(XPathConstaints.SUPPLIER_LIST);
        for(WebElement supplier:supplierList)
        {
            highlightElement(driver,supplier);
            Thread.sleep(1000);
            WebElement requestor= supplier.findElement(By.xpath(".//span[3]"));
            highlightElement(driver,requestor);
            Thread.sleep(1000);
            String text= requestor.getText();
            if(text.equalsIgnoreCase("Requestor: Yash Garg"))
            {
                Thread.sleep(1000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.APPROVEBTN));
                WebElement approveBtn = supplier.findElement(XPathConstaints.APPROVEBTN);
                wait.until(ExpectedConditions.elementToBeClickable(approveBtn));
                highlightElement(driver,approveBtn);
                approveBtn.click();
                System.out.println("This is the one");
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUBMIT_BTN));
        WebElement submitBtn= driver.findElement(XPathConstaints.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        addCookie(driver, prop.getProperty("my-auth-token"));

    }

    @Test(dependsOnMethods = "verifyPO")
    public void createDispatch() throws IOException, InterruptedException {

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));

        Thread.sleep(5000);
        WebElement orderSection= driver.findElements(XPathConstaints.NAV_ITEMS).get(5);
        wait.until(ExpectedConditions.elementToBeClickable(orderSection));
        highlightElement(driver,orderSection);
        orderSection.click();

        WebElement buyoutBtn= orderSection.findElements(XPathConstaints.SUPPLIERPO_BUYOUT).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(buyoutBtn));
        highlightElement(driver,buyoutBtn);
        buyoutBtn.click();

        String buyerName= organisationName;

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ORDER_LIST));
        WebElement orderList= driver.findElement(XPathConstaints.ORDER_LIST);
        highlightElement(driver,orderList);

        List<WebElement> buyers= orderList.findElements(By.xpath(".//tbody//tr"));
        for(WebElement buyer:buyers)
        {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement buyerElement= buyer.findElement(XPathConstaints.BUYER_ELEMENT);
            if(buyerElement.getText().equalsIgnoreCase(buyerName))
            {
                highlightElement(driver,buyer);
                buyer.click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.LINKS_LIST));
        WebElement linksLst= driver.findElement(XPathConstaints.LINKS_LIST);
        highlightElement(driver,linksLst);

        List<WebElement> actionButtons= linksLst.findElements(XPathConstaints.BTN);
        WebElement createDispatchBtn= actionButtons.get(4);
        wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
        highlightElement(driver,createDispatchBtn);
        createDispatchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SELECT_SUPPLIER));
        WebElement selectSupplier= driver.findElement(XPathConstaints.SELECT_SUPPLIER);
        wait.until(ExpectedConditions.elementToBeClickable(selectSupplier));
        highlightElement(driver,selectSupplier);
        selectSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CHECKBOX));
        WebElement checkBox= driver.findElement(XPathConstaints.CHECKBOX);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();

        List<WebElement> items= driver.findElements(XPathConstaints.ITEMS);
        for(WebElement item:items)
        {
            WebElement value= item.findElement(XPathConstaints.MULTIPLE_USED_INPUT);
            value.sendKeys(prop.getProperty("dispatch-qty"));
        }

        if(driver.findElement(XPathConstaints.ERROR_MSG).isDisplayed())
            handleFinance(driver);

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
        WebElement addToDispatchBtn= driver.findElement(XPathConstaints.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(addToDispatchBtn));
        highlightElement(driver,addToDispatchBtn);
        addToDispatchBtn.click();

        Thread.sleep(8000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.CARTBTN));
        WebElement viewDispatchBtn= driver.findElement(XPathConstaints.CARTBTN);
        wait.until(ExpectedConditions.elementToBeClickable(viewDispatchBtn));
        highlightElement(driver,viewDispatchBtn);
        viewDispatchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BTN_XPATH));
        WebElement nextBtn= driver.findElement(XPathConstaints.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.ROLE_ADDRESS_OPTIONS));
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        List<WebElement> addressOptions= driver.findElements(XPathConstaints.ROLE_ADDRESS_OPTIONS);

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

        WebElement submit= driver.findElement(XPathConstaints.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        highlightElement(driver,submit);
        submit.click();

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

        WebElement financeSection= driver.findElements(XPathConstaints.NAV_ITEMS).get(9);
        wait.until(ExpectedConditions.elementToBeClickable(financeSection));
        highlightElement(driver,financeSection);
        financeSection.click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li")));
        WebElement receiptsBtn= financeSection.findElement(By.xpath(".//ul//li"));
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
        Thread.sleep(20000);
        List<WebElement> financesList= driver.findElements(XPathConstaints.FINANCE_LIST);

        System.out.println("Sizex of list==> "+ financesList.size());

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

                WebElement organizationInput= btnSection.findElement(XPathConstaints.SEARCH_ORGANIZATION);
                organizationInput.sendKeys(organizationID);

                wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ORGANIZATION_OPTION));
                WebElement organizationOption= driver.findElement(XPathConstaints.ORGANIZATION_OPTION);
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

        List<WebElement> options= driver.findElements(XPathConstaints.ORDER_SECTION);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.BUYOUT_OPTION));
        WebElement buyoutOption= driver.findElement(XPathConstaints.BUYOUT_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(buyoutOption));
        highlightElement(driver,buyoutOption);
        buyoutOption.click();

        String buyerName=organisationName;

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.ORDER_LIST));
        WebElement orderList= driver.findElement(XPathConstaints.ORDER_LIST);
        highlightElement(driver,orderList);

        List<WebElement> buyers= driver.findElements(XPathConstaints.ITEMS_LIST);
        for(WebElement buyer:buyers)
        {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement buyerElement= buyer.findElement(XPathConstaints.BUYER_ELEMENT);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.LINKS_LIST));
        WebElement linksLst= driver.findElement(XPathConstaints.LINKS_LIST);
        highlightElement(driver,linksLst);

        List<WebElement> actionButtons= linksLst.findElements(XPathConstaints.BTN);
        WebElement createDispatchBtn= actionButtons.get(4);
        wait.until(ExpectedConditions.elementToBeClickable(createDispatchBtn));
        highlightElement(driver,createDispatchBtn);
        createDispatchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SELECT_SUPPLIER));
        WebElement selectSupplier= driver.findElement(XPathConstaints.SELECT_SUPPLIER);
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
        // loadPropFile();

//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-ts/dispatch/buyout/open/OFB117165393314709-D-1/details");

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(80));

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
        WebElement submitBtn= driver.findElement(XPathConstaints.SHIPMENT_NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

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

        Thread.sleep(3000);
        WebElement datePicker= driver.findElements(XPathConstaints.DATEPICKER).get(0);
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

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.OPTIONS_SEARCHSUPPLIER));
        List<WebElement> options= driver.findElements(XPathConstaints.OPTIONS_SEARCHSUPPLIER);
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

        WebElement createShipmentBtn= driver.findElement(XPathConstaints.CREATE_SHIPMENT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createShipmentBtn));
        highlightElement(driver,createShipmentBtn);
        createShipmentBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.GO_TO_SHIPMENT_BTN));
        WebElement goToShipmentBtn= driver.findElement(XPathConstaints.GO_TO_SHIPMENT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(goToShipmentBtn));
        highlightElement(driver,goToShipmentBtn);
        goToShipmentBtn.click();
    }


    //@Test(dependsOnMethods = "createShipment")
    public void verifyShipment() throws InterruptedException, IOException {

//        loadPropFile();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://stg5-cms.ofbusiness.co.in/#/home/shipment/OFB117177369265298-S-1/summary");
        String mainWindow= driver.getWindowHandle();
//
          WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));
//
//        Thread.sleep(90000);


        //switch to new window
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(mainWindow);
//        // change focus to new tab
//
//        driver.switchTo().window(newTab.get(0));

        for(String handle:driver.getWindowHandles())
            driver.switchTo().window(handle);

        mainWindow= driver.getWindowHandle();
        System.out.println("Done");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-pagination-wrapper")));
        WebElement sections= driver.findElement(By.xpath("//md-pagination-wrapper"));
        wait.until(ExpectedConditions.elementToBeClickable(sections));
        highlightElement(driver,sections);


        WebElement uploadDocs=sections.findElements(By.xpath(".//md-tab-item")).get(5);
        wait.until(ExpectedConditions.elementToBeClickable(uploadDocs));
        highlightElement(driver,uploadDocs);
        uploadDocs.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='anchorBtn ng-scope md-ofb-green-theme']")));
        WebElement uploadSTIBtn= driver.findElements(By.xpath("//a[@class='anchorBtn ng-scope md-ofb-green-theme']")).get(1);
        highlightElement(driver,uploadSTIBtn);
        uploadSTIBtn.click();

        //switch to new window
//        newTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(mainWindow);
//        // change focus to new tab
//
//        driver.switchTo().window(newTab.get(0));
//        mainWindow=driver.getWindowHandle();

        System.out.println("Done");

        Thread.sleep(2000);

        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Click to Upload Supplier Tax Invoice']")));
        WebElement btn= driver.findElement(By.xpath("//span[text()='Click to Upload Supplier Tax Invoice']"));
        wait.until(ExpectedConditions.elementToBeClickable(btn));
        highlightElement(driver,btn);

        WebElement sti_input= driver.findElement(By.xpath("//label[@class='uploadButton undefined']//input"));
        sti_input.sendKeys(prop.getProperty("file-path"));

        Thread.sleep(8000);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inventoryDocumentUpload']")));
//        WebElement uploadFileBtn= driver.findElement(By.xpath("//input[@id='inventoryDocumentUpload']"));
//        uploadFileBtn.sendKeys("/home/yash/Pictures/Screenshots/screenshot.png");

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        setCurrDate(driver);

        WebElement inVoiceNumber= driver.findElement(By.xpath("//input[@name='invoiceId']"));
        highlightElement(driver,inVoiceNumber);
        inVoiceNumber.sendKeys(prop.getProperty("invoice-number"));

        WebElement redirectBlock= driver.findElement(XPathConstaints.REDIRECT_BLOCK);
        wait.until(ExpectedConditions.elementToBeClickable(redirectBlock));
        redirectBlock.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.ITEMLIST));
        List<WebElement> itemList= driver.findElements(XPathConstaints.ITEMLIST);
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

            WebElement radioGroup= item.findElement(XPathConstaints.RADIO_BTN);
            highlightElement(driver,radioGroup);

            WebElement radioBtn= radioGroup.findElement(By.xpath(".//label"));
            radioBtn.click();
        }

        Thread.sleep(2000);
        WebElement selectAllItems= driver.findElement(XPathConstaints.CHECKBOX_LABEL);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-tab-item")));
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

        List<WebElement> subSections= inputSection.findElements(By.xpath(".//li"));

        WebElement lspName= subSections.get(0).findElement(By.xpath(".//input"));
        lspName.sendKeys("a");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='md-autocomplete-suggestions autocomplete-account-template']//li[@class='ng-scope']")));
        WebElement lspNameOption= driver.findElement(By.xpath("//ul[@class='md-autocomplete-suggestions autocomplete-account-template']//li[@class='ng-scope']"));
        wait.until(ExpectedConditions.elementToBeClickable(lspNameOption));
        highlightElement(driver,lspNameOption);
        lspNameOption.click();

        Thread.sleep(2000);
        WebElement gstOption= subSections.get(2).findElements(By.xpath(".//span")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(gstOption));
        highlightElement(driver,gstOption);
        gstOption.click();





//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lspAutocomplete']")));
//        WebElement lspName= driver.findElement(By.xpath("//input[@id='lspAutocomplete']"));
//        lspName.sendKeys("a");



//        Thread.sleep(2000);
//        WebElement gstin= driver.findElements(By.xpath("//span[@class='listValue']")).get(3);
//        wait.until(ExpectedConditions.elementToBeClickable(gstin));
//        highlightElement(driver,gstin);
//        gstin.click();
//        gstin.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@ng-value='gst']")));
        WebElement gstValue= driver.findElement(By.xpath("//md-option[@ng-value='gst']"));
        wait.until(ExpectedConditions.elementToBeClickable(gstValue));
        highlightElement(driver,gstValue);
        gstValue.click();

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

        WebElement invoiceOptions= driver.findElements(XPathConstaints.OPTIONS_SAVEBTN).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(invoiceOptions));
        invoiceOptions.click();

        Thread.sleep(2000);
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



    @Test
    public void createSaleReturn() throws InterruptedException, IOException {


        loadPropFile();
        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile5");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://stg3-cms.ofbusiness.co.in/#/home/shipment/OFB117192257205634-S-35/summary");
        mainWindow = driver.getWindowHandle();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.INVOICES_SECTION));
        WebElement invoicesBtn= driver.findElement(XPathConstaints.INVOICES_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(invoicesBtn));
        highlightElement(driver,invoicesBtn);
        invoicesBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.INVOICE_DROPDOWN));
        WebElement invoicesDropdown= driver.findElements(XPathConstaints.INVOICE_DROPDOWN).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(invoicesDropdown));
        highlightElement(driver,invoicesDropdown);
        invoicesDropdown.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstaints.SALE_RETURN_BTN));
        WebElement saleReturnBtn= driver.findElements(XPathConstaints.SALE_RETURN_BTN).get(3);
        wait.until(ExpectedConditions.elementToBeClickable(saleReturnBtn));
        highlightElement(driver,saleReturnBtn);
        saleReturnBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.RADIO_LABEL));
        WebElement radioBtn= driver.findElement(XPathConstaints.RADIO_LABEL);
        wait.until(ExpectedConditions.elementToBeClickable(radioBtn));
        radioBtn.click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.OPTIONS_SEARCHSUPPLIER));
        WebElement rejectionReason= driver.findElement(XPathConstaints.OPTIONS_SEARCHSUPPLIER);
        wait.until(ExpectedConditions.elementToBeClickable(rejectionReason));
        highlightElement(driver,rejectionReason);
        rejectionReason.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.REASON_VALUE));
        WebElement reasonValue= driver.findElement(XPathConstaints.REASON_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(reasonValue));
        highlightElement(driver,reasonValue);
        reasonValue.click();

        WebElement isSaleInsured= driver.findElements(XPathConstaints.RADIO_LABEL).get(3);
        isSaleInsured.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.TOGGLE_BTN));
        WebElement toggleButton= driver.findElement(XPathConstaints.TOGGLE_BTN);
        toggleButton.click();

        /*WebElement pickUpAddress= driver.findElement(XPathConstaints.OPTIONS_SEARCHSUPPLIER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pickUpAddress);
        Thread.sleep(600);

        wait.until(ExpectedConditions.elementToBeClickable(pickUpAddress));
        highlightElement(driver, pickUpAddress);
        pickUpAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.PICKUPADDRESS_VALUE));
        WebElement pickUpAddressValue= driver.findElement(XPathConstaints.PICKUPADDRESS_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(pickUpAddressValue));
        highlightElement(driver, pickUpAddressValue);
        pickUpAddressValue.click();
        */

        radioBtn= driver.findElements(XPathConstaints.RADIO_LABEL).get(6);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioBtn);
        Thread.sleep(600);
        radioBtn.click();

        WebElement nextBtn= driver.findElement(XPathConstaints.NEXTBTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.VIEW_DETAILS_BTN));
        WebElement viewDetailsBtn= driver.findElement(XPathConstaints.VIEW_DETAILS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(viewDetailsBtn));
        highlightElement(driver,viewDetailsBtn);
        viewDetailsBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.TABLE_BODY));
        WebElement tableBody= driver.findElement(XPathConstaints.TABLE_BODY);
        highlightElement(driver,tableBody);

        Actions actions= new Actions(driver);

        List<WebElement> tableRows= tableBody.findElements(By.xpath(".//tr"));
        for(WebElement row: tableRows)
        {
            highlightElement(driver, row);

            List<WebElement> rowOptions= row.findElements(By.xpath(".//td"));

            WebElement checkBox= rowOptions.get(0).findElement(XPathConstaints.SELECTITEM);
            actions.moveToElement(checkBox).click().perform();

            WebElement requestedQty= rowOptions.get(4);
            highlightElement(driver, requestedQty);

            String qty= requestedQty.getText();

            System.out.println("requested Qty is "+ requestedQty.getText());

            WebElement inputItem= rowOptions.get(5);
            WebElement returnQty= inputItem.findElement(By.xpath(".//input"));
            returnQty.sendKeys(qty.substring(0,qty.length()-3));
        }

        WebElement addToPurchaseBtn= driver.findElement(XPathConstaints.NEXTBTN);
        wait.until(ExpectedConditions.elementToBeClickable(addToPurchaseBtn));
        highlightElement(driver,addToPurchaseBtn);
        addToPurchaseBtn.click();

        WebElement cartBtn= driver.findElement(XPathConstaints.CART_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
        highlightElement(driver,cartBtn);
        cartBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.NEXTBTN));
        nextBtn= driver.findElement(XPathConstaints.NEXTBTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DATEPICKER));
        WebElement datePicker= driver.findElement(XPathConstaints.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstaints.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
        dateInput.sendKeys(date);

        Thread.sleep(1200);
        dateInput.sendKeys(Keys.ENTER);

        WebElement body = driver.findElement(By.tagName("body"));

        // Click on the body element
        body.click();
        Thread.sleep(1000);


        WebElement vehicleNumberInput= driver.findElement(XPathConstaints.VEHICLE_NUMBER);
        vehicleNumberInput.sendKeys(prop.getProperty("test-vehicle"));

        body = driver.findElement(By.tagName("body"));

        // Click on the body element
        body.click();
        Thread.sleep(1000);

        List<WebElement> dropBtn= driver.findElements(XPathConstaints.DROP_BTN);

        WebElement dropDown1= dropBtn.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(dropDown1));
        highlightElement(driver, dropDown1);
        dropDown1.click();

        WebElement dropDown2= driver.findElements(XPathConstaints.DROPDOWN_BTN).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(dropDown2));
        highlightElement(driver, dropDown2);
        dropDown2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.DATE_CONTAINER));

        vehicleNumberInput= driver.findElement(XPathConstaints.VEHICLE_NO);
//        vehicleNumberInput.sendKeys(prop.getProperty("test-vehicle"));
//        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.evaluate(\"//div[@class='purchaseReturnForm']//input[@id='tfid-0-1']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='TST_1234';");


        body = driver.findElement(By.tagName("body"));

        // Click on the body element
        body.click();
        Thread.sleep(1000);


        datePicker= driver.findElement(XPathConstaints.DATE_CONTAINER);
        datePicker.click();

//        monthYearBtn= driver.findElement(XPathConstaints.MONTH_YEAR_BTN);
//        month= monthYearBtn.getText().split(" ")[0];
//        year= monthYearBtn.getText().split(" ")[1];
//        dateBtn = driver.findElement(XPathConstaints.CURRDATE);
//        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElement(XPathConstaints.DATE_INPUT1);
        dateInput.sendKeys(date);

        body = driver.findElement(By.tagName("body"));

        // Click on the body element
        body.click();
        Thread.sleep(8000);


        WebElement createBtn= driver.findElement(XPathConstaints.NEXTBTN);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver, createBtn);
        createBtn.click();

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.NEXTBTN));
        nextBtn= driver.findElement(XPathConstaints.NEXTBTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.OPTIONS_SEARCHSUPPLIER));
        WebElement expenseType= driver.findElement(XPathConstaints.OPTIONS_SEARCHSUPPLIER);
        wait.until(ExpectedConditions.elementToBeClickable(expenseType));
        highlightElement(driver,expenseType);
        expenseType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.EXPENSETYPE_VALUE));
        WebElement expenseTypeValue= driver.findElement(XPathConstaints.EXPENSETYPE_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(expenseTypeValue));
        expenseTypeValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.OPTIONS_SEARCHSUPPLIER));
        WebElement subExpenseType= driver.findElement(XPathConstaints.OPTIONS_SEARCHSUPPLIER);
        wait.until(ExpectedConditions.elementToBeClickable(subExpenseType));
        subExpenseType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstaints.SUB_EXPENSE));
        WebElement subExpenseValue= driver.findElement(XPathConstaints.SUB_EXPENSE);
        wait.until(ExpectedConditions.elementToBeClickable(subExpenseValue));
        highlightElement(driver,subExpenseValue);
        subExpenseValue.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-1i8o47w']")));
        WebElement vendor= dropDown1.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(vendor));
        highlightElement(driver,vendor);
        vendor.click();

        WebElement vendorInput= driver.findElement(By.xpath("//input[@id='vendorOrgType-input-tfid-0-2']"));
        vendorInput.sendKeys("Tk");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-vendorOrgType-option-0']")));
        WebElement vendor_option= driver.findElement(By.xpath("//div[@id='react-select-vendorOrgType-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(vendor_option));
        highlightElement(driver,vendor_option);
        vendor_option.click();

        WebElement saveBtn= driver.findElement(XPathConstaints.SAVEBUTTON);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();
    }

}

/*
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

        option1Value= driver.findElement(By.xpath("//md-option[@value='IN_TRANSIT']"));
        option1Value.click();

        calendarOption= driver.findElements(By.xpath("//span[@class='quickdate-button ng-binding']")).get(0);
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

        msgOption= driver.findElement(By.xpath("//md-radio-group//md-radio-button"));
        wait.until(ExpectedConditions.elementToBeClickable(msgOption));
        highlightElement(driver,msgOption);
        msgOption.click();

        calendarOption= driver.findElements(By.xpath("//span[@class='quickdate-button ng-binding']")).get(1);
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
 */
