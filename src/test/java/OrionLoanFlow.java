import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class OrionLoanFlow {
    class XPathConstants
    {
        public static final By BUTTONS= By.xpath("//span[@class='navItem']//span[text()='Organisation']");
        public static final By ADDCOMPANY_BTN= By.xpath("//button[text()='Add Company']");
        public static final By OPTIONS= By.cssSelector(".orgTypeItem.navItem[role='button']");
        public static final By NEXT_BTN= By.xpath("//button[text()='Next']");
        public static final By INPUT_FIELD = By.id("tfid-0-0");
        public static final By ORGNAME= By.className("createUsingNameBlock");
        public static final By CREATE_BY_COMPANY= By.id("Company");
        public static final By LOADING_ICON= By.xpath("//span[@class='loading-icon m-r-10 hide']");
        public static final By CONTACTNAME= By.id("tfid-0-6");
        public static final By POSTALCODE= By.id("tfid-0-5");
        public static final By TURNOVER= By.id("tfid-0-3");
        public static final By INDUSTRY_TYPE= By.cssSelector("div.css-tlfecz-indicatorContainer");
        public static final By INDUSTRY_TYPE_VALUE= By.xpath("//div[@id='react-select-industry-option-0']");
        public static final By SUBINDUSTRY_TYPE= By.xpath("//div[@id='industryType-tfid-0-2']");
        public static final By SUBINDUSTRY_TYPE_VALUE= By.xpath("//div[@id='react-select-industryType-option-0']");
        public static final By COMPANY_PROFILE= By.xpath("//button[text()='Company Profile']");
        public static final By TAX_SECTION= By.xpath("//button[text()='Tax/Compliances']");
        public static final By ADD_BTN= By.xpath("//button[text()='Add']");
        public static final By PAN_INPUT= By.id("tfid-0-0");
        public static final By VERIFY_BTN= By.xpath("//button[text()='Verify']");
        public static final By GET_ADDRESS_BTN= By.xpath("//button[text()='Get Address ']");
        public static final By ADDRESSLINE_1= By.name("addressLine1");
        public static final By ADDRESSLINE_2= By.id("tfid-0-1");
        public static final By LANDMARK= By.id("tfid-0-2");
        public static final By INPUT_FIELD2 = By.id("tfid-0-4");
        public static final By COUNTRY_NAME= By.xpath("//div[@id='countryCode-tfid-0-3']");
        public static final By COUNTRY_NAME_VALUE= By.xpath("//div[@class=' css-1ul4jvx-option']//div[text()='India']");
        public static final By DATEPICKER= By.className("react-datepicker__input-container");
        public static final By MONTH_YEAR= By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown");
        public static final By DATEBTN= By.xpath("//div[contains(@class, 'react-datepicker__day--today')]");
        public static final By DATEINPUT= By.className("react-datepicker-ignore-onclickoutside");
        public static final By SUBMIT_BTN= By.xpath("//button[text()='Submit']");
        public static final By ADDRESS_BTN= By.xpath("//button[text()='Addresses']");
        public static final By INNER_DETAILS= By.xpath("//div[@class='innerDetailsWrapper']");
        public static final By BILLING_ADDRESS_SPAN= By.xpath(".//div[contains(@class, 'action') and contains(@class, 'actionDrop')]");
        public static final By ACTION= By.xpath(".//i[@class='material-icons']");
        public static final By DROPDOWN= By.xpath("//ul[@class='dropDownContent']");
        public static final By BTN = By.tagName("button");
        public static final By UPLOAD_DOC= By.id("uploadAddrDoc");
        public static final By DOC_TYPE= By.id("documentType-tfid-0-1");
        public static final By DOCTYPE_OPTIONS= By.id("react-select-documentType-option-0");
        public static final By CONTACTS_BTN= By.xpath("//button[text()='Contacts']");
        public static final By DIV_ELEMENT= By.xpath("//div[contains(@class, 'action') and contains(@class, 'actionDrop')]");
        public static final By ROLE_DROPDOWN= By.xpath("//div[@class=' css-17vhrl4']");
        public static final By ROLE_VALUE= By.xpath("//div[@id='react-select-role-option-1']");
        public static final By RADIOGROUP= By.className("radio-group");
        public static final By OTP_RADIO_BTN= By.xpath(".//label[@class='radioLabel']");
        public static final By SEND_OTP_BTN= By.xpath("//button[text()='Send OTP']");
        public static final By OTP_INPUT= By.name("otp");

        public static final By SIDE_BAR= By.xpath("//ul[@class='nav sidebar-icons']");
        public static final By SIDE_OPTIONS= By.xpath(".//li");
        public static final By ALL_APPLICATIONS= By.xpath(".//a[text()='All']");
        public static final By CREATE_APPLICATION= By.xpath("//button[@class='btn btn-info m-r-10 m-b-10']");
        public static final By VARIOUS_OPTIONS = By.xpath("//div[@class=' css-1i8o47w']");
        public static final By CLIENT_HINT= By.xpath("//input[@id='clientId-input-tfid-0-0']");
        public static final By PARTNER_INPUT= By.xpath("//input[@id='partnerId-input-tfid-0-2']");
        public static final By LOANTYPE_INPUT= By.xpath("//input[@id='loanType-input-tfid-0-3']");
        public static final By LOAN_AMOUNT= By.xpath("//input[@id='tfid-0-1']");
        public static final By SUBMIT_APPLICTAION= By.xpath("//button[@class='btn btn-info m-r-10 pull-right' and contains(text(),'Submit')]");
        public static final By CREATED_APPLICATIONS= By.xpath("//div[@class='table-responsive']//tbody");
        public static final By APPLICATIONS= By.xpath(".//tr");
        public static final By SET_ORGANIZATION_DETAILS= By.xpath("//button[@class='btn btn-info']");
        //public static final By ORGANIZATION_OPTIONS= By.xpath("//div[@class=' css-1i8o47w']");
        public static final By ORGTYPE_INPUT= By.xpath("//input[@id='entityType-input-tfid-0-0']");
        public static final By RBI_INPUT= By.xpath("//input[@id='rbiClassification-input-tfid-0-3']");
        public static final By RBI_SUBCLASSIFICATION_INPUT= By.xpath("//input[@id='rbiSubClassification-input-tfid-0-4']");
        public static final By SME_CLASSIFICATION= By.xpath("//input[@id='smeClassification-input-tfid-0-5']");
        public static final By VERIFY= By.xpath("//button[@class='btn btn-info' and contains(text(),'SAVE AND VERIFY')]");
        public static final By SHOW_LOADING= By.xpath("//div[@class='loading-icon m-r-10 hide']");
        public static final By VERIFY_CLIENT= By.xpath("//a[@class='m-t-25 inline-block ofb-link']");
        public static final By CORPORATION_YEAR= By.xpath("//input[@name='incorporationDetail[yearOfIncorporation]']");
        public static final By CIN= By.xpath("//input[@name='incorporationDetail[cin]']");
        public static final By NO_OF_PROMOTERS= By.xpath("//input[@name='healthOfBusiness[numberOfPromoters]']");
        public static final By SAVE_BTN= By.xpath("//button[@class='btn btn-info']");
        public static final By UNDERWRITING_SECTION= By.xpath(".//li//a[text()='Underwriting']");
        public static final By CHECK_BOX= By.xpath("//input[@id='checkbox-loan-sheet-confirm']");

        public static final By EDIT_STATUS= By.xpath("//a[@class='cursor m-l-10 ']");
        public static final By EDITSTATUS_BOX= By.xpath("//div[@class=' css-17vhrl4']");
        public static final By EDIT_STATUS_HINT= By.xpath("//input[@id='loanApplicationStatus-input-tfid-0-0']");
        public static final By SUBMIT_STATUS=By.xpath("//button[@class='btn btn-info btn-panel']");
        public static final By TAB= By.xpath("//ul[@class='nav nav-tabs nav-tabs-simple']");
        public static final By CREATE_NEW_REQUEST= By.xpath("//button[@class='btn btn-info' and contains(text(),'New Request')]");
        public static final By CONFIRM_BTN= By.xpath("//button[@class='btn btn-info' and contains(text(),'Confirm')]");

        public static final By EDIT_BTN= By.xpath("//button[@class='btn btn-default']");
        public static final By STATUS_INPUT= By.xpath("//input[@id='status-input-tfid-0-0']");
        public static final By COMMENT_BOX= By.xpath("//input[@id='tfid-0-1']");
        public static final By OFFER_BTN= By.xpath("//button[@class='btn btn-info decision-summary-btn' and text()='Offer']");
        public static final By SECURITY_TYPE= By.xpath("//input[@id='loanSecurityType-input-tfid-0-3']");
        public static final By PENAL_FEE= By.xpath("//input[@id='tfid-0-6']");
        public static final By REPAYMENT_CYCLE= By.xpath("//input[@id='tfid-0-5']");
        public static final By TENURE= By.xpath("//input[@id='tfid-0-8']");
        public static final By INTEREST_RATE= By.xpath("//input[@id='tfid-0-9']");
        public static final By LOAN_SUBTYPE= By.xpath("//input[@id='loanSubType-input-tfid-0-12']");
        public static final By TRANSACTION_ALLOWED= By.xpath("//input[@id='transactionAllowed-input-tfid-0-11']");
        public static final By APPROVE_BTN= By.xpath("//button[@class='btn btn-info decision-summary-btn' and contains(text(),'Send for approval')]");
        public static final By LOADING= By.xpath("//div[@class='loading-icon m-l-10 hide']");

        public static final By NAV_ITEMS= By.xpath("//ul[@class='nav-list']");
        public static final By FINANCE_SECTION= By.xpath(".//a[text()='Other Invoices']");
        public static final By CREATEBTN= By.xpath("//div[@class='name btn btn-default awaitingBtn']");
        public static final By PROCESSING_FEE_INVOICE= By.xpath("//div[@class='dropDownItem' and text()='Processing Fee Invoice']");
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

        public static final By CLIENT= By.xpath("//input[@id='company-input-tfid-0-0']");
        public static final By CLIENT_OPTION= By.xpath("//div[@id='react-select-company-option-0']");
        public static final By BUYER_BILLING_ADDRESS= By.xpath("//div[@id='react-select-buyerBillingAddress-option-0']");
        public static final By OFB_ENTITY= By.xpath("//input[@id='ofbEntity-input-tfid-0-2']");
        public static final By BUTTON= By.xpath("//button[@class='btn btn-primary']");
        public static final By CHECKBOX= By.xpath("//label[@class='checkboxLabel']");
        public static final By DATE_INPUT= By.xpath("//input[@placeholder='Select date']");
        public static final By CREATE_BUTTON= By.xpath("//button[@class='btn btn-primary' and contains(text(),'Create')]");
        public static final By INVOICE_BTN= By.xpath(".//a[text()='Invoices']");
        public static final By INVOICE_TABLE= By.xpath("//table[@class='table table-bordered table-striped']//tbody");
        public static final By MOVE_TO_SIGN= By.xpath(".//button[@class='btn btn-primary m-l-5 m-r-5 m-b-5']");
        public static final By CLOSE_BTN= By.xpath("//button[@class='btn close']");
        public static final By EDITSTATUS= By.xpath("//i[@class='material-icons material-icon-size' and text()='mode_edit']");
        public static final By DOC_SECTION= By.xpath("//div[@class='position-relative']//div[text()='Documents']");
        public static final By UPLOAD_DOCS= By.xpath("//button[@class='btn btn-info-outline m-b-10 stickyCont']");
        public static final By UPLOAD_DOC_SECTION= By.xpath("//section[@class='dropzone']");
        public static final By DOC_INPUT= By.xpath(".//input[@id='LOAN_DOCUMENTS']");
        public static final By NEXTBTN= By.xpath("//button[@class='btn btn-default']");
        public static final By DOCTYPE_HINT= By.xpath("//input[@id='documentTypeId-input-tfid-0-0']");
        public static final By APPROVE_RADIO_BTN= By.xpath("//label[@class='radioLabel']");
        public static final By SAVEBTN= By.xpath("//button[@class='btn btn-oxy-blue pull-right m-l-10']");
        public static final By MOVE_TO_DOCSECTION= By.xpath("//a[@class='tooltipWrapper m-l-5']");
        public static final By SKIP_SURE_BTN= By.xpath("//button[@class='btn btn-danger']");
        public static final By COMMENTBOX= By.xpath("//textarea[@id='tfid-0-14']");


        public static final By DASHBOARD= By.xpath("//button[text()='Dashboard']");
        public static final By ACTION_WRAPPER= By.className("dashboardActionWrapper");
        public static final By ACTION_ITEM= By.className("actionItems");
        public static final By CATEGORYLIST= By.className("categoryList");
        public static final By CATEGORY_CARD= By.className("categoryCard");
        public static final By SUBCATEGORY_LIST=  By.xpath("//section[@class='subCategoriesWrapper']");
        public static final By ADD_TO_LIST= By.xpath("//button[text()='Add to List']");
        public static final By SUBCATEGORY_FORM= By.className("subCategoryForm");
        public static final By SUBCATEGORY= By.className("form-control");
        public static final By ADDRESS_PO_NUMBER = By.id("tfid-0-1");
        public static final By MONTH_YEAR_BTN= By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown");
        public static final By CURRDATE= By.xpath("//div[contains(@class, 'react-datepicker__day--today')]");
        public static final By DATE_INPUT1= By.className("react-datepicker-ignore-onclickoutside");
        public static final By ACTION_BUTTONS= By.className("actionButtons");
        public static final By BTN_XPATH= By.cssSelector("button.btn.btn-primary");
        public static final By BTNS_WRAP= By.className("btnsWrap");
        public static final By LOADING_HIDE= By.xpath("//i[@class='loadingBtn loading-icon hide']");
        public static final By ORGANIZATION_LIST= By.xpath("//div[@class='tableListView']");
        public static final By ORGANIZATIONS= By.xpath("//div[@class='row tableListDataRow cursor']");
        public static final By ORGANIZATION= By.xpath(".//span[@class='valueOpacity']");

        public static final By RFQ_SECTION= By.xpath("//span[text()='RFQs']");
        public static final By BUYOUT_BTN= By.xpath("//button[@aria-label='Buyout']");
        public static final By SEARCH_BTN= By.cssSelector("button.btn.search-btn");
        public static final By CHECKBOX_SECTION= By.className("checkBoxContent");
        public static final By CHECKBOX_OPTION= By.cssSelector("input[type='checkbox']");
        public static final By ACTION_BTNS= By.cssSelector("button.btn.btn-default");
        public static final By FREIGHT_RATE= By.id("tfid-0-6");
        public static final By LOADING_CHARGES= By.id("tfid-0-7");
        public static final By DROPDOWN_OPTIONS= By.className("reactSelectContainer");
        public static final By GST_OPTION= By.id("react-select-gst-option-2");
        public static final By COPY_BTN= By.className("copyBtn");
        public static final By SAVE= By.xpath("//button[@class='btn btn-primary' and contains(text(),'Save')]");


        public static final By BUYER_PREFS= By.xpath("//span[text()='Buyer Preferences']");
        public static final By BUYER_PREFS_OPTIONS= By.className("contentView");
        public static final By PAYMENT_BUYERPO= By.className("heading");
        public static final By MULTIPLE_USED_INPUT= By.id("tfid-0-0");
        public static final By SAVEBUTTON= By.cssSelector("button.btn.btn-primary.saveBtn");
        public static final By SEND_FOR_APPROVAL= By.xpath("//button[text()='Send for Approval']");
        public static final By CHECK__BOX= By.xpath("//input[@class='enable']");
        public static final By EDITBTN= By.cssSelector("button.btn.btn-default.editBtn");
        public static final By ADDRESS_OPTIONS= By.xpath("//div[@class= ' css-1i8o47w']");
        public static final By SHIPPING_ADDRESS_OPTION= By.xpath("//div[@class=' css-yxf0z2']");
        public static final By TOLERANCE_POSTALCODE = By.id("tfid-0-5");
        public static final By BUYER_CONTAINER= By.className("buyerPoContainer");
        public static final By UPLOADDOCS= By.id("upload-document-undefined");
        public static final By SAVE_BUTTON= By.xpath("//button[text()='Save ']");

        public static final By EDIT_ENTITY= By.cssSelector("button.btnEdit.material-icons");
        public static final By ENTITY_NAME_SECTION= By.xpath("//div[@class='modalContent']//div[@id='ofbEntityName-tfid-0-0']");
        public static final By UPDATE_BTN= By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']");
        public static final By ITEM_SPECIFICATIONS= By.xpath("//div[@class='optHeader']//span");
        public static final By SUBMIT_QUOTE= By.xpath("//button[text()='Submit Buyer Quote ']");
        public static final By ADDRESS_VALUE= By.xpath("//div[@class=' css-1ul4jvx-option']");
        public static final By ADDRESS_SECTION= By.xpath("//div[@class='modalContent']//div[@id='ofbEntityAddress-tfid-0-1']");
        public static final By CREDIT_INST_OPTION= By.xpath("//div[@id='react-select-creditInstrument-option-0']");


        public static final By SUPPLIER_QUOTE= By.className("supplierQuote");
        //public static final By ADDRESS_PO_NUMBER = By.id("tfid-0-1");


    }

    static WebDriver driver=null;
    static Properties prop;

    static Faker faker = new Faker();
    static String organisationName = faker.company().name() + " Test";
    String panNumber = "";
    String RFQ_ID=null;
    String organizationID;
    static String mainWindow;

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
        driver.get(prop.getProperty("stg5-url"));
        mainWindow = driver.getWindowHandle();
    }

    @Test(dependsOnMethods = "setUp")
    public void handleOrganizationSection() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(80));

        driver.switchTo().window(mainWindow);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BUTTONS));
        //List<WebElement> buttons = driver.findElements(XPathConstants.BUTTONS);
        WebElement orgBtn = driver.findElement(XPathConstants.BUTTONS);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ADDCOMPANY_BTN));
        WebElement addCompany = driver.findElement(XPathConstants.ADDCOMPANY_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addCompany));
        highlightElement(driver, addCompany);
        addCompany.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.OPTIONS));
        List<WebElement> options = driver.findElements(XPathConstants.OPTIONS);
        WebElement buyerOption = options.get(0);
        System.out.println(buyerOption.getTagName());
        highlightElement(driver, buyerOption);
        buyerOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.NEXT_BTN));
        WebElement btnNext = driver.findElement(XPathConstants.NEXT_BTN);
        btnNext.click();

        Thread.sleep(3000);
        WebElement mobileInput = driver.findElement(XPathConstants.INPUT_FIELD);
        mobileInput.sendKeys(prop.getProperty("phone"));

        Thread.sleep(1000);
        WebElement btnNext2 = driver.findElement(XPathConstants.NEXT_BTN);
        btnNext2.click();


        Thread.sleep(3000);
        WebElement createUsingOrgName = driver.findElement(XPathConstants.ORGNAME);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CREATE_BY_COMPANY));
        WebElement createByCompany = driver.findElement(XPathConstants.CREATE_BY_COMPANY);
        wait.until(ExpectedConditions.elementToBeClickable(createByCompany));
        highlightElement(driver, createByCompany);
        createByCompany.click();

        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(XPathConstants.NEXT_BTN));
        WebElement btnNext = driver.findElement(XPathConstants.NEXT_BTN);
        btnNext.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING_ICON));

        //generate random name for organisation

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.INPUT_FIELD));
        WebElement companyNameInput = driver.findElement(XPathConstants.INPUT_FIELD);
        companyNameInput.sendKeys(organisationName);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING_ICON));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.NEXT_BTN));
        WebElement btnNext2 = driver.findElement(XPathConstants.NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(btnNext2));
        btnNext2.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING_ICON));

        wait.until(ExpectedConditions.elementToBeClickable(btnNext2));
        btnNext2.click();
        while (true)
        {
            try
            {
                Thread.sleep(5000);
                //wait.until(ExpectedConditions.presenceOfElementLocated(XPathConstants.FREIGHT_RATE));
                WebElement contactName = driver.findElement(XPathConstants.FREIGHT_RATE);
                if(contactName.isDisplayed())
                    break;
            }
            catch (Exception e)
            {
                System.out.println(e.getLocalizedMessage());
                wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.NEXT_BTN));
                btnNext2 = driver.findElement(XPathConstants.NEXT_BTN);
                wait.until(ExpectedConditions.elementToBeClickable(btnNext2));
                btnNext2.click();

            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CONTACTNAME));
        WebElement contactName = driver.findElement(XPathConstants.CONTACTNAME);
        contactName.sendKeys(prop.getProperty("name"));

        WebElement postalCode = driver.findElement(XPathConstants.POSTALCODE);
        postalCode.sendKeys(prop.getProperty("postalCode"));

        WebElement turnOver = driver.findElement(XPathConstants.TURNOVER);
        turnOver.sendKeys(prop.getProperty("turnOver"));


        WebElement industryType = driver.findElement(XPathConstants.INDUSTRY_TYPE);
        industryType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.INDUSTRY_TYPE_VALUE));
        WebElement industryTypeValue= driver.findElement(XPathConstants.INDUSTRY_TYPE_VALUE);

        wait.until(ExpectedConditions.elementToBeClickable(industryTypeValue));
        highlightElement(driver,industryTypeValue);
        industryTypeValue.click();

        WebElement subIndustryType= driver.findElement(XPathConstants.SUBINDUSTRY_TYPE);
        wait.until(ExpectedConditions.elementToBeClickable(subIndustryType));
        highlightElement(driver,subIndustryType);
        subIndustryType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBINDUSTRY_TYPE_VALUE));
        WebElement subIndustryValue= driver.findElement(XPathConstants.SUBINDUSTRY_TYPE_VALUE);
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
        WebElement btnNext3 = driver.findElement(XPathConstants.NEXT_BTN);
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.COMPANY_PROFILE));
        WebElement companyProfile = driver.findElement(XPathConstants.COMPANY_PROFILE);
        wait.until(ExpectedConditions.elementToBeClickable(companyProfile));
        highlightElement(driver, companyProfile);
        companyProfile.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TAX_SECTION));
        WebElement tax = driver.findElement(XPathConstants.TAX_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(tax));
        highlightElement(driver, tax);
        tax.click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.ADD_BTN));
        List<WebElement> addBtnList = driver.findElements(XPathConstants.ADD_BTN);
        highlightElement(driver, addBtnList.get(0));
        Thread.sleep(1000);
        addBtnList.get(0).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PAN_INPUT));
        WebElement PANinput = driver.findElement(XPathConstants.PAN_INPUT);
        PANinput.sendKeys(panNumber);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.VERIFY_BTN));
        WebElement verifyBtn = driver.findElement(XPathConstants.VERIFY_BTN);
        highlightElement(driver, verifyBtn);
        verifyBtn.click();

        Thread.sleep(3500);
        WebElement addGstBtn = addBtnList.get(3);
        wait.until(ExpectedConditions.elementToBeClickable(addGstBtn));
        highlightElement(driver, addGstBtn);
        addGstBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.INPUT_FIELD));
        WebElement gstInput = driver.findElement(XPathConstants.INPUT_FIELD);
        gstInput.sendKeys("06" + panNumber + "1ZC");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.GET_ADDRESS_BTN));
        WebElement getAddress = driver.findElement(XPathConstants.GET_ADDRESS_BTN);
        highlightElement(driver, getAddress);
        getAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ADDRESSLINE_1));
        WebElement firstAddress = driver.findElement(XPathConstants.ADDRESSLINE_1);
        firstAddress.sendKeys("testLine1");
        WebElement secAddress = driver.findElement(XPathConstants.ADDRESSLINE_2);
        secAddress.sendKeys("testline2");
        WebElement landmark = driver.findElement(XPathConstants.LANDMARK);
        landmark.sendKeys("testmark");
        WebElement postalCode = driver.findElement(XPathConstants.INPUT_FIELD2);
        postalCode.sendKeys(prop.getProperty("postalCode"));

        WebElement countryInput= driver.findElement(XPathConstants.COUNTRY_NAME);
        countryInput.click();
        System.out.println(" Country Input Is Displayed :   "+countryInput.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.COUNTRY_NAME_VALUE));
        WebElement countryValue= driver.findElement(XPathConstants.COUNTRY_NAME_VALUE);
        System.out.println("The value of country is "+ countryValue.getText());
        wait.until(ExpectedConditions.elementToBeClickable(countryValue));
        highlightElement(driver,countryValue);
        countryValue.click();

        Thread.sleep(1500);
        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.DATEBTN);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATEINPUT);
        dateInput.sendKeys(date);

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        WebElement submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

    }

    @Test(dependsOnMethods = "doGstVerification")
    public void doAddressVerification() throws InterruptedException
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING_ICON));


        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ADDRESS_BTN));
        WebElement addressBtn = driver.findElement(XPathConstants.ADDRESS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addressBtn));
        highlightElement(driver,addressBtn);
        addressBtn.click();

        Thread.sleep(5000);
        Actions actions= new Actions(driver);
        List<WebElement> divs= driver.findElements(XPathConstants.INNER_DETAILS);
        for(WebElement div:divs)
        {
            highlightElement(driver,div);
            WebElement containsBillingAddress= div.findElement(By.xpath(".//span"));
            if(containsBillingAddress.getText().equalsIgnoreCase("Billing Address"))
            {
                highlightElement(driver,containsBillingAddress);
                WebElement div_element = div.findElement(XPathConstants.BILLING_ADDRESS_SPAN);
                WebElement span_element = div_element.findElement(By.xpath(".//span"));
                WebElement i_element = span_element.findElement(XPathConstants.ACTION);
                actions.moveToElement(i_element).build().perform();

                WebElement listOfOptions= div.findElement(XPathConstants.DROPDOWN);
                List<WebElement> items= listOfOptions.findElements(By.xpath(".//li"));
                WebElement verifyAddress= items.get(2).findElement(XPathConstants.BTN);
                wait.until(ExpectedConditions.elementToBeClickable(verifyAddress));
                verifyAddress.click();
                break;
            }
        }



        Thread.sleep(3000);
        WebElement uploadFile= driver.findElement(XPathConstants.UPLOAD_DOC);
        uploadFile.sendKeys(prop.getProperty("file-path"));

        Thread.sleep(3000);
        WebElement docType = driver.findElement(XPathConstants.DOC_TYPE);
        docType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DOCTYPE_OPTIONS));
        WebElement docTypeOptions= driver.findElement(XPathConstants.DOCTYPE_OPTIONS);
        docTypeOptions.click();

        Thread.sleep(2000);
        WebElement submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        highlightElement(driver,submitBtn);
        submitBtn.click();


    }

    public String getOtp() throws IOException {
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



        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING_ICON));


        Thread.sleep(20000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CONTACTS_BTN));
        WebElement contactsBtn = driver.findElement(XPathConstants.CONTACTS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(contactsBtn));
        highlightElement(driver,contactsBtn);
        contactsBtn.click();

        Actions actions= new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DIV_ELEMENT));
        WebElement div_element = driver.findElement(XPathConstants.DIV_ELEMENT);
        WebElement span_element = div_element.findElement(By.xpath(".//span"));
        WebElement i_element = span_element.findElement(XPathConstants.ACTION);
        actions.moveToElement(i_element).build().perform();

        WebElement listOfOptions= driver.findElement(XPathConstants.DROPDOWN);
        List<WebElement> items= listOfOptions.findElements(By.tagName("li"));

        WebElement editBtn= items.get(0).findElement(XPathConstants.BTN);
        editBtn.click();

        Thread.sleep(2000);
        WebElement emailInput= driver.findElement(XPathConstants.INPUT_FIELD2);
        emailInput.clear();
        emailInput.sendKeys(prop.getProperty("test-email"));

        WebElement roleDropDpown = driver.findElement(XPathConstants.ROLE_DROPDOWN);
        roleDropDpown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ROLE_VALUE));
        WebElement dropdown_option= driver.findElement(XPathConstants.ROLE_VALUE);
        dropdown_option.click();


        Thread.sleep(2000);
        WebElement submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        highlightElement(driver,submitBtn);
        submitBtn.click();

        Thread.sleep(1500);
        div_element = driver.findElement(XPathConstants.DIV_ELEMENT);
        span_element = div_element.findElement(By.xpath(".//span"));
        i_element = span_element.findElement(XPathConstants.ACTION);
        actions.moveToElement(i_element).build().perform();

        Thread.sleep(2000);

        WebElement verifyMobile= items.get(2).findElement(XPathConstants.BTN);
        System.out.println(items.toString());
        wait.until(ExpectedConditions.elementToBeClickable(verifyMobile));
        verifyMobile.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.RADIOGROUP));
        WebElement radioGroup= driver.findElement(XPathConstants.RADIOGROUP);
        highlightElement(driver,radioGroup);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.OTP_RADIO_BTN));
        WebElement otpOption= radioGroup.findElement(XPathConstants.OTP_RADIO_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(otpOption));
        otpOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SEND_OTP_BTN));
        WebElement sendOtp= driver.findElement(XPathConstants.SEND_OTP_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(sendOtp));
        sendOtp.click();

        Thread.sleep(3000);
        String otp= getOtp();
        Thread.sleep(2000);

        WebElement otpInput= driver.findElement(XPathConstants.OTP_INPUT);
        otpInput.sendKeys(otp);

        Thread.sleep(2000);
        WebElement submitBtn2= driver.findElement(XPathConstants.SUBMIT_BTN);
        highlightElement(driver,submitBtn2);
        submitBtn2.click();

        Thread.sleep(4000);

        String url= driver.getCurrentUrl();
        organizationID= url.split("/")[4];

        System.out.println("Organization id is "+organizationID);
        System.out.println("Organization Name is "+organisationName);
    }


    @Test(dependsOnMethods = "doMobileVerification")
    public void createLoanApplication() throws InterruptedException, IOException {

//        loadPropFile();
//        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//
//        ChromeOptions option = new ChromeOptions();
//        option.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile4");
//
//        driver = new ChromeDriver(option);
//        driver.manage().window().maximize();
//
//        mainWindow = driver.getWindowHandle();

        driver.get(prop.getProperty("stg5-oxyzoadmin-url"));
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SIDE_BAR));
        WebElement sideBar= driver.findElement(XPathConstants.SIDE_BAR);
        highlightElement(driver,sideBar);

        WebElement applicationOption= sideBar.findElements(XPathConstants.SIDE_OPTIONS).get(6);
        wait.until(ExpectedConditions.elementToBeClickable(applicationOption));
        highlightElement(driver,applicationOption);
        applicationOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ALL_APPLICATIONS));
        WebElement allApplicationsBtn= driver.findElement(XPathConstants.ALL_APPLICATIONS);
        wait.until(ExpectedConditions.elementToBeClickable(allApplicationsBtn));
        highlightElement(driver,allApplicationsBtn);
        allApplicationsBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CREATE_APPLICATION));
        WebElement createApplication= driver.findElement(XPathConstants.CREATE_APPLICATION);
        wait.until(ExpectedConditions.elementToBeClickable(createApplication));
        highlightElement(driver,createApplication);
        createApplication.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.VARIOUS_OPTIONS));
        List<WebElement> options= driver.findElements(XPathConstants.VARIOUS_OPTIONS);

        WebElement client= options.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(client));
        highlightElement(driver,client);
        client.click();

        WebElement clientInput= driver.findElement(XPathConstants.CLIENT_HINT);
        clientInput.sendKeys(organisationName);
        Thread.sleep(3000);
        clientInput.sendKeys(Keys.ENTER);

        WebElement partner= options.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(partner));
        highlightElement(driver,partner);
        partner.click();

        Thread.sleep(1500);
        WebElement partnerInput= driver.findElement(XPathConstants.PARTNER_INPUT);
        partnerInput.sendKeys(Keys.ENTER);

        WebElement loanType= options.get(2);
        wait.until(ExpectedConditions.elementToBeClickable(loanType));
        highlightElement(driver,loanType);
        loanType.click();

        WebElement loanInput= driver.findElement(XPathConstants.LOANTYPE_INPUT);
        loanInput.sendKeys("PURCHASE");

        Thread.sleep(2000);
        loanInput.sendKeys(Keys.ENTER);

        WebElement loanAmt= driver.findElement(XPathConstants.LOAN_AMOUNT);
        loanAmt.sendKeys("1000000");

        WebElement submitBtn= driver.findElement(XPathConstants.SUBMIT_APPLICTAION);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        Thread.sleep(5000);

        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CREATED_APPLICATIONS));
        WebElement table= driver.findElement(XPathConstants.CREATED_APPLICATIONS);
        highlightElement(driver,table);

        List<WebElement> applications= table.findElements(XPathConstants.APPLICATIONS);
        for(WebElement application:applications)
        {
            client= application.findElements(By.xpath(".//td")).get(1);
            highlightElement(driver,client);
            System.out.println("Client is "+ client.getText());
            if(client.getText().equalsIgnoreCase(organisationName))
            {
                client.click();
                break;
            }
        }

        for(String handle:driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
        }
        Thread.sleep(1500);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SET_ORGANIZATION_DETAILS));
        WebElement setDetails= driver.findElement(XPathConstants.SET_ORGANIZATION_DETAILS);
        wait.until(ExpectedConditions.elementToBeClickable(setDetails));
        highlightElement(driver,setDetails);
        setDetails.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.VARIOUS_OPTIONS));
        options= driver.findElements(XPathConstants.VARIOUS_OPTIONS);

        WebElement organizationType= options.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(organizationType));
        highlightElement(driver,organizationType);
        organizationType.click();

        WebElement orgType_Input= driver.findElement(XPathConstants.ORGTYPE_INPUT);
        orgType_Input.sendKeys("Public");
        Thread.sleep(2000);
        orgType_Input.sendKeys(Keys.ENTER);

        Thread.sleep(1400);
        WebElement rbi_classification= driver.findElement(XPathConstants.VARIOUS_OPTIONS);
        //wait.until(ExpectedConditions.elementToBeClickable(rbi_classification));
        highlightElement(driver,rbi_classification);
        rbi_classification.click();

        WebElement rbi_classification_input= driver.findElement(XPathConstants.RBI_INPUT);
        rbi_classification_input.sendKeys("Industry");
        Thread.sleep(2000);
        rbi_classification_input.sendKeys(Keys.ENTER);

        Thread.sleep(1400);
        WebElement rbi_subClassification= driver.findElement(XPathConstants.VARIOUS_OPTIONS);
        //wait.until(ExpectedConditions.elementToBeClickable(rbi_subClassification));
        highlightElement(driver,rbi_subClassification);
        rbi_subClassification.click();

        WebElement rbi_subClassification_input= driver.findElement(XPathConstants.RBI_SUBCLASSIFICATION_INPUT);
        rbi_subClassification_input.sendKeys("Infra");


        Thread.sleep(2000);
        rbi_subClassification_input.sendKeys(Keys.ENTER);

        Thread.sleep(1500);
        WebElement sme_classification= driver.findElement(XPathConstants.VARIOUS_OPTIONS);
        wait.until(ExpectedConditions.elementToBeClickable(sme_classification));
        highlightElement(driver,sme_classification);
        sme_classification.click();

        WebElement sme_input= driver.findElement(XPathConstants.SME_CLASSIFICATION);
        sme_input.sendKeys("MEDIUM");
        Thread.sleep(2000);
        sme_input.sendKeys(Keys.ENTER);


        Thread.sleep(8000);

        WebElement verifyBtn= driver.findElement(XPathConstants.VERIFY);
        wait.until(ExpectedConditions.elementToBeClickable(verifyBtn));
        highlightElement(driver,verifyBtn);
        verifyBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.SHOW_LOADING));
        Thread.sleep(3000);


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDIT_STATUS));
        WebElement editStatus= driver.findElement(XPathConstants.EDIT_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(editStatus));
        highlightElement(driver,editStatus);
        editStatus.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSTATUS_BOX));
        WebElement editStatusBox= driver.findElement(XPathConstants.EDITSTATUS_BOX);
        wait.until(ExpectedConditions.elementToBeClickable(editStatusBox));
        highlightElement(driver,editStatusBox);
        editStatusBox.click();

        WebElement editStatus_Input= driver.findElement(XPathConstants.EDIT_STATUS_HINT);
        editStatus_Input.sendKeys("Document collection");
        Thread.sleep(2000);
        editStatus_Input.sendKeys(Keys.ENTER);

        WebElement submitBtn2= driver.findElement(XPathConstants.SUBMIT_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn2));
        highlightElement(driver,submitBtn2);
        submitBtn2.click();

        mainWindow= driver.getWindowHandle();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.VERIFY_CLIENT));
        WebElement verifyClient= driver.findElement(XPathConstants.VERIFY_CLIENT);
        wait.until(ExpectedConditions.elementToBeClickable(verifyClient));
        highlightElement(driver,verifyClient);
        verifyClient.click();

        for(String handle:driver.getWindowHandles())
            driver.switchTo().window(handle);

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CORPORATION_YEAR));
        WebElement corporationYr= driver.findElement(XPathConstants.CORPORATION_YEAR);
        corporationYr.sendKeys("1990");

        WebElement CIN= driver.findElement(XPathConstants.CIN);
        CIN.sendKeys("123456");

        WebElement noOfPromoters= driver.findElement(XPathConstants.NO_OF_PROMOTERS);
        noOfPromoters.sendKeys("2");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SAVE_BTN));
        WebElement saveBtn= driver.findElement(XPathConstants.SAVE_BTN);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        driver.switchTo().window(mainWindow);






        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDIT_STATUS));
        editStatus= driver.findElement(XPathConstants.EDIT_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(editStatus));
        highlightElement(driver,editStatus);
        editStatus.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSTATUS_BOX));
        editStatusBox= driver.findElement(XPathConstants.EDITSTATUS_BOX);
        wait.until(ExpectedConditions.elementToBeClickable(editStatusBox));
        highlightElement(driver,editStatusBox);
        editStatusBox.click();

        editStatus_Input= driver.findElement(XPathConstants.EDIT_STATUS_HINT);
        editStatus_Input.sendKeys("Proces");
        Thread.sleep(2000);
        editStatus_Input.sendKeys(Keys.ENTER);

        submitBtn2= driver.findElement(XPathConstants.SUBMIT_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn2));
        highlightElement(driver,submitBtn2);
        submitBtn2.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-icon loader-blue']")));



        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDIT_STATUS));
        editStatus= driver.findElement(XPathConstants.EDIT_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(editStatus));
        highlightElement(driver,editStatus);
        editStatus.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSTATUS_BOX));
        editStatusBox= driver.findElement(XPathConstants.EDITSTATUS_BOX);
        wait.until(ExpectedConditions.elementToBeClickable(editStatusBox));
        highlightElement(driver,editStatusBox);
        editStatusBox.click();

        editStatus_Input= driver.findElement(XPathConstants.EDIT_STATUS_HINT);
        editStatus_Input.sendKeys("Underwriting");
        Thread.sleep(2000);
        editStatus_Input.sendKeys(Keys.ENTER);

        submitBtn2= driver.findElement(XPathConstants.SUBMIT_STATUS);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn2));
        highlightElement(driver,submitBtn2);
        submitBtn2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TAB));
        WebElement tab= driver.findElement(XPathConstants.TAB);
        highlightElement(driver,tab);

        WebElement underWritingSection= tab.findElement(XPathConstants.UNDERWRITING_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(underWritingSection));
        highlightElement(driver,underWritingSection);
        underWritingSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CREATE_NEW_REQUEST));
        WebElement newRequest_Btn= driver.findElement(XPathConstants.CREATE_NEW_REQUEST);
        wait.until(ExpectedConditions.elementToBeClickable(newRequest_Btn));
        highlightElement(driver,newRequest_Btn);
        newRequest_Btn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CHECK_BOX));
        WebElement checkBox= driver.findElement(XPathConstants.CHECK_BOX);
        checkBox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CONFIRM_BTN));
        WebElement confirmBtn= driver.findElement(XPathConstants.CONFIRM_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        highlightElement(driver,confirmBtn);
        confirmBtn.click();

    }

    @Test(dependsOnMethods = "createLoanApplication")
    public void createRequest() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDIT_BTN));
        WebElement editBtn= driver.findElement(XPathConstants.EDIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        highlightElement(driver,editBtn);
        editBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSTATUS_BOX));
        WebElement editStatus= driver.findElement(XPathConstants.EDITSTATUS_BOX);
        wait.until(ExpectedConditions.elementToBeClickable(editStatus));
        highlightElement(driver,editStatus);
        editStatus.click();

        WebElement statusInput= driver.findElement(XPathConstants.STATUS_INPUT);
        statusInput.sendKeys("Offered");
        Thread.sleep(2000);
        statusInput.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.VARIOUS_OPTIONS));
        List<WebElement> options= driver.findElements(XPathConstants.VARIOUS_OPTIONS);

        WebElement securityType= options.get(0);
        highlightElement(driver,securityType);
        securityType.click();

        WebElement commentBox= driver.findElement(XPathConstants.COMMENT_BOX);
        highlightElement(driver,commentBox);
        commentBox.sendKeys("Test-comment");

        WebElement securityTypeInput= driver.findElement(XPathConstants.SECURITY_TYPE);
        securityTypeInput.sendKeys("None");
        Thread.sleep(2000);
        securityTypeInput.sendKeys(Keys.ENTER);

        WebElement penalFee= driver.findElement(XPathConstants.PENAL_FEE);
        highlightElement(driver,penalFee);
        penalFee.sendKeys("0");

        WebElement repaymentCycle= driver.findElement(XPathConstants.REPAYMENT_CYCLE);
        highlightElement(driver,repaymentCycle);
        repaymentCycle.sendKeys("20");

        WebElement tenure= driver.findElement(XPathConstants.TENURE);
        highlightElement(driver,tenure);
        tenure.sendKeys("12");

        WebElement interestRate= driver.findElement(XPathConstants.INTEREST_RATE);
        highlightElement(driver,interestRate);
        interestRate.sendKeys("6");

        WebElement loanSubType= options.get(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loanSubType);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(loanSubType));
        highlightElement(driver,loanSubType);
        loanSubType.click();

        WebElement loanSubTypeInput= driver.findElement(XPathConstants.LOAN_SUBTYPE);

        loanSubTypeInput.sendKeys("Monthly");
        Thread.sleep(2000);
        loanSubTypeInput.sendKeys(Keys.ENTER);

        WebElement transactionAllowed= options.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(transactionAllowed));
        highlightElement(driver,transactionAllowed);
        transactionAllowed.click();

        WebElement transaction_input= driver.findElement(XPathConstants.TRANSACTION_ALLOWED);
        transaction_input.sendKeys("Both");
        Thread.sleep(2000);
        transaction_input.sendKeys(Keys.ENTER);

        WebElement sendForApproval= driver.findElement(XPathConstants.APPROVE_BTN);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sendForApproval);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(sendForApproval));
        highlightElement(driver,sendForApproval);
        sendForApproval.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDIT_BTN));
        editBtn= driver.findElement(XPathConstants.EDIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        highlightElement(driver,editBtn);
        editBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSTATUS_BOX));
        editStatus= driver.findElement(XPathConstants.EDITSTATUS_BOX);
        wait.until(ExpectedConditions.elementToBeClickable(editStatus));
        highlightElement(driver,editStatus);
        editStatus.click();

        statusInput= driver.findElement(XPathConstants.STATUS_INPUT);
        statusInput.sendKeys("Offered");
        Thread.sleep(4000);

        commentBox= driver.findElement(XPathConstants.COMMENT_BOX);
        highlightElement(driver,commentBox);
        commentBox.sendKeys("Test-comment");

        WebElement offerBtn= driver.findElement(XPathConstants.OFFER_BTN);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", offerBtn);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(offerBtn));
        highlightElement(driver,offerBtn);
        offerBtn.click();

    }


    /*@Test(dependsOnMethods = "createRequest")
    public void handleCreatedApplication() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SIDE_BAR));
        WebElement sideBar= driver.findElement(XPathConstants.SIDE_BAR);
        highlightElement(driver,sideBar);

        WebElement applicationOption= sideBar.findElements(XPathConstants.SIDE_OPTIONS).get(6);
        wait.until(ExpectedConditions.elementToBeClickable(applicationOption));
        highlightElement(driver,applicationOption);
        applicationOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ALL_APPLICATIONS));
        WebElement allApplicationsBtn= driver.findElement(XPathConstants.ALL_APPLICATIONS);
        wait.until(ExpectedConditions.elementToBeClickable(allApplicationsBtn));
        highlightElement(driver,allApplicationsBtn);
        allApplicationsBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CREATED_APPLICATIONS));
        WebElement table= driver.findElement(XPathConstants.CREATED_APPLICATIONS);
        highlightElement(driver,table);

        List<WebElement> applications= table.findElements(XPathConstants.APPLICATIONS);
        for(WebElement application:applications)
        {
            WebElement client= application.findElements(By.xpath(".//td")).get(1);
            highlightElement(driver,client);
            System.out.println("Client is "+ client.getText());
            if(client.getText().equalsIgnoreCase(organisationName))
            {
                client.click();
                break;
            }
        }

        for(String handle:driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
        }
        Thread.sleep(1500);


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TAB));
        WebElement tab= driver.findElement(XPathConstants.TAB);
        highlightElement(driver,tab);

        WebElement underWritingSection= tab.findElement(By.xpath(".//li//a[text()='Underwriting']"));
        wait.until(ExpectedConditions.elementToBeClickable(underWritingSection));
        highlightElement(driver,underWritingSection);
        underWritingSection.click();


    }*/

    @Test(dependsOnMethods = "createRequest")
    public void handleLoanSection() throws InterruptedException, IOException {

//        loadPropFile();
//        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile4");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.get("https://ofb.stg5-oxyzoadmin.ofbusiness.co.in/ofe/");
          mainWindow = driver.getWindowHandle();

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));
        Thread.sleep(7000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SIDE_BAR));
        WebElement sideBar= driver.findElement(XPathConstants.SIDE_BAR);

        wait.until(ExpectedConditions.elementToBeClickable(sideBar));
        highlightElement(driver,sideBar);

        WebElement loanOption= sideBar.findElements(XPathConstants.SIDE_OPTIONS).get(29);
        wait.until(ExpectedConditions.elementToBeClickable(loanOption));
        highlightElement(driver,loanOption);
        loanOption.click();

        WebElement allLoansBtn= loanOption.findElement(XPathConstants.ALL_APPLICATIONS);
        wait.until(ExpectedConditions.elementToBeClickable(allLoansBtn));
        highlightElement(driver,allLoansBtn);
        allLoansBtn.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CREATED_APPLICATIONS));
        WebElement table= driver.findElement(XPathConstants.CREATED_APPLICATIONS);
        highlightElement(driver,table);

        List<WebElement> loans= table.findElements(XPathConstants.APPLICATIONS);
        Thread.sleep(3000);
        for(WebElement loan:loans)
        {
            WebElement client= loan.findElements(By.xpath(".//td")).get(1);
            highlightElement(driver,client);
            System.out.println("Client is "+ client.getText());
            if(client.getText().equalsIgnoreCase(organisationName))
            {
                client.click();
                break;
            }
        }

        for(String handle:driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
        }
        Thread.sleep(1400);
    }

    @Test(dependsOnMethods = "handleLoanSection")
    public void handleFinanceSection() throws InterruptedException, IOException {

//        loadPropFile();
//
//        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile5");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-fe/invoices/other-invoices/all");

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.NAV_ITEMS));
        WebElement financeSection= driver.findElements(XPathConstants.NAV_ITEMS).get(10);
        wait.until(ExpectedConditions.elementToBeClickable(financeSection));
        highlightElement(driver,financeSection);
        financeSection.click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//ul")));
//        WebElement invoiceSection= financeSection.findElement(By.xpath(".//ul"));
//        wait.until(ExpectedConditions.elementToBeClickable(invoiceSection));
//        highlightElement(driver,invoiceSection);
//        invoiceSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.FINANCE_SECTION));
        WebElement otherInvoicesBtn= financeSection.findElement(XPathConstants.FINANCE_SECTION);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", otherInvoicesBtn);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(otherInvoicesBtn));
        highlightElement(driver,otherInvoicesBtn);
        otherInvoicesBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CREATEBTN));
        WebElement createBtn= driver.findElement(XPathConstants.CREATEBTN);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PROCESSING_FEE_INVOICE));
        WebElement processingFeeInvoice= driver.findElement(XPathConstants.PROCESSING_FEE_INVOICE);
        wait.until(ExpectedConditions.elementToBeClickable(processingFeeInvoice));
        highlightElement(driver,processingFeeInvoice);
        processingFeeInvoice.click();

        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.VARIOUS_OPTIONS));
        List<WebElement> invoiceOptions= driver.findElements(XPathConstants.VARIOUS_OPTIONS);

        WebElement clientName= invoiceOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(clientName));
        highlightElement(driver,clientName);
        clientName.click();




        //organisationName="Predovic, Predovic And Predovic Test";




        WebElement client_hint= driver.findElement(XPathConstants.CLIENT);
        client_hint.sendKeys(organisationName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CLIENT_OPTION));
        WebElement client_option= driver.findElement(XPathConstants.CLIENT_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(client_option));
        highlightElement(driver,client_option);
        client_option.click();

        WebElement billingAddress= invoiceOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddress));
        highlightElement(driver,billingAddress);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BUYER_BILLING_ADDRESS));
        WebElement billingAddress_value= driver.findElement(XPathConstants.BUYER_BILLING_ADDRESS);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddress_value));
        highlightElement(driver,billingAddress_value);
        billingAddress_value.click();

        WebElement ofbEntity= invoiceOptions.get(2);
        wait.until(ExpectedConditions.elementToBeClickable(ofbEntity));
        highlightElement(driver,ofbEntity);
        ofbEntity.click();

        WebElement ofbEntity_hint= driver.findElement(XPathConstants.OFB_ENTITY);
        ofbEntity_hint.sendKeys(Keys.ENTER);

        WebElement proceedBtn= driver.findElement(XPathConstants.BUTTON);
        wait.until(ExpectedConditions.elementToBeClickable(proceedBtn));
        highlightElement(driver,proceedBtn);
        proceedBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CHECKBOX));
        WebElement loan_checkbox= driver.findElement(XPathConstants.CHECKBOX);
        loan_checkbox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));
        WebElement invoiceDate= driver.findElement(XPathConstants.DATEPICKER);
        invoiceDate.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.DATEBTN);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATEINPUT);
        dateInput.sendKeys(date);
        Thread.sleep(1400);
        dateInput.sendKeys(Keys.ENTER);


        invoiceDate= driver.findElement(XPathConstants.DATEPICKER);
        invoiceDate.click();

        monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR);
        month= monthYearBtn.getText().split(" ")[0];
        year= monthYearBtn.getText().split(" ")[1];
        dateBtn = driver.findElement(XPathConstants.DATEBTN);
        date= dateBtn.getText()+" "+ month+" "+year;

        dateInput= driver.findElements(XPathConstants.DATE_INPUT).get(1);
        dateInput.sendKeys(date);
        Thread.sleep(1400);
        dateInput.sendKeys(Keys.ENTER);

        WebElement computeBtn= driver.findElement(XPathConstants.BUTTON);
        wait.until(ExpectedConditions.elementToBeClickable(computeBtn));
        highlightElement(driver,computeBtn);
        computeBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CREATE_BUTTON));
        createBtn= driver.findElement(XPathConstants.CREATE_BUTTON);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();

        financeSection= driver.findElements(XPathConstants.NAV_ITEMS).get(10);
        wait.until(ExpectedConditions.elementToBeClickable(financeSection));
        highlightElement(driver,financeSection);
        financeSection.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        createBtn= driver.findElement(XPathConstants.CREATE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.FINANCE_TABLE));
        WebElement financeTable= driver.findElement(XPathConstants.FINANCE_TABLE);
        highlightElement(driver,financeTable);

        driver.navigate().refresh();

        Thread.sleep(10000);
        List<WebElement> financesList= driver.findElements(XPathConstants.FINANCE_LIST);

        System.out.println("Size of list==> "+ financesList.size());


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


                System.out.println("Organization ID is "+ organizationID);
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
    }

    @Test(dependsOnMethods = "handleFinanceSection")
    public void handleLoan() throws InterruptedException, IOException {
//        loadPropFile();
//        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile4");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//
        Thread.sleep(2000);
        driver.get("https://ofb.stg5-oxyzoadmin.ofbusiness.co.in/ofe/");
        Thread.sleep(3000);

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SIDE_BAR));
        WebElement sideBar= driver.findElement(XPathConstants.SIDE_BAR);
        highlightElement(driver,sideBar);


        WebElement financeSection= sideBar.findElements(By.xpath(".//li")).get(60);
        wait.until(ExpectedConditions.elementToBeClickable(financeSection));
        highlightElement(driver,financeSection);
        financeSection.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.INVOICE_BTN));
        WebElement invoicesBtn= financeSection.findElement(XPathConstants.INVOICE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(invoicesBtn));
        highlightElement(driver,invoicesBtn);
        invoicesBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.INVOICE_TABLE));
        WebElement table= driver.findElement(XPathConstants.INVOICE_TABLE);
        highlightElement(driver,table);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr")));
        List<WebElement> invoiceList= table.findElements(By.xpath(".//tr"));

        for(WebElement invoice:invoiceList)
        {
            highlightElement(driver,invoice);
            WebElement clientName= invoice.findElements(By.xpath(".//td")).get(2).findElement(By.xpath(".//a"));
            String client=clientName.getText();
            if(client.equalsIgnoreCase(organisationName))
            {
                highlightElement(driver,clientName);
                //WebElement moveToSign= invoice.findElements(By.xpath(".//td")).get(9);

                WebElement moveToSignedBtn= invoice.findElement(XPathConstants.MOVE_TO_SIGN);
                wait.until(ExpectedConditions.elementToBeClickable(moveToSignedBtn));
                highlightElement(driver,moveToSignedBtn);
                moveToSignedBtn.click();
                Thread.sleep(5000);

                wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BUTTON));
                WebElement confirmBtn= driver.findElement(XPathConstants.BUTTON);
                wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
                highlightElement(driver,confirmBtn);
                confirmBtn.click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CLOSE_BTN));
                WebElement closeBtn=driver.findElement(XPathConstants.CLOSE_BTN);
                wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
                highlightElement(driver,closeBtn);
                closeBtn.click();
                Thread.sleep(3000);

                WebElement loanLink= invoice.findElements(By.xpath(".//td")).get(3).findElement(By.xpath(".//a"));
                wait.until(ExpectedConditions.elementToBeClickable(loanLink));
                highlightElement(driver,loanLink);
                loanLink.click();
                break;
            }
        }



        Thread.sleep(5000);

        for(String handle: driver.getWindowHandles())
            driver.switchTo().window(handle);
        Thread.sleep(2000);





        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSTATUS));
        WebElement editStatus= driver.findElement(XPathConstants.EDITSTATUS);
        highlightElement(driver,editStatus);
        editStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSTATUS_BOX));
        WebElement editStatusBox= driver.findElement(XPathConstants.EDITSTATUS_BOX);
        wait.until(ExpectedConditions.elementToBeClickable(editStatusBox));
        editStatusBox.click();

        WebElement editStatus_hint= driver.findElement(XPathConstants.STATUS_INPUT);
        editStatus_hint.sendKeys("Negotiation");
        Thread.sleep(2000);
        editStatus_hint.sendKeys(Keys.ENTER);

        WebElement saveBtn= driver.findElement(XPathConstants.SAVE_BTN);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DOC_SECTION));
        WebElement documentSection= driver.findElement(XPathConstants.DOC_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(documentSection));
        highlightElement(driver,documentSection);
        documentSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPLOAD_DOCS));
        WebElement uploadDocs= driver.findElement(XPathConstants.UPLOAD_DOCS);
        wait.until(ExpectedConditions.elementToBeClickable(uploadDocs));
        highlightElement(driver,uploadDocs);
        uploadDocs.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.UPLOAD_DOC_SECTION));
        WebElement uploadDoc= driver.findElement(XPathConstants.UPLOAD_DOC_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(uploadDoc));
        highlightElement(driver,uploadDoc);
        WebElement uploadDoc_input= uploadDoc.findElement(XPathConstants.DOC_INPUT);
        uploadDoc_input.sendKeys(prop.getProperty("file-path"));

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.NEXTBTN));
        WebElement nextBtn= driver.findElement(XPathConstants.NEXTBTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSTATUS_BOX));
        WebElement docType= driver.findElements(XPathConstants.EDITSTATUS_BOX).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(docType));
        highlightElement(driver,docType);
        docType.click();

        WebElement doctype_hint= driver.findElement(XPathConstants.DOCTYPE_HINT);
        doctype_hint.sendKeys("Debt");
        Thread.sleep(2000);
        doctype_hint.sendKeys(Keys.ENTER);

        WebElement approveRadioBtn= driver.findElement(XPathConstants.APPROVE_RADIO_BTN);
        approveRadioBtn.click();

        saveBtn= driver.findElement(XPathConstants.SAVEBTN);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MOVE_TO_DOCSECTION));
        WebElement moveToDocSection= driver.findElement(XPathConstants.MOVE_TO_DOCSECTION);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moveToDocSection);
        Thread.sleep(2000);
        moveToDocSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SKIP_SURE_BTN));
        WebElement skipBtn= driver.findElement(XPathConstants.SKIP_SURE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(skipBtn));
        highlightElement(driver,skipBtn);
        skipBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SKIP_SURE_BTN));
        WebElement sureBtn= driver.findElements(XPathConstants.SKIP_SURE_BTN).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(sureBtn));
        highlightElement(driver,sureBtn);
        sureBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));
        Thread.sleep(3000);

        for(String handle: driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
        }
        Thread.sleep(3000);



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSTATUS));
        editStatus= driver.findElement(XPathConstants.EDITSTATUS);
        highlightElement(driver,editStatus);
        editStatus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITSTATUS_BOX));
        editStatusBox= driver.findElement(XPathConstants.EDITSTATUS_BOX);
        wait.until(ExpectedConditions.elementToBeClickable(editStatusBox));
        editStatusBox.click();

        editStatus_hint= driver.findElement(XPathConstants.STATUS_INPUT);
        editStatus_hint.sendKeys("Ready For Dis");
        Thread.sleep(2000);
        editStatus_hint.sendKeys(Keys.ENTER);

        WebElement commentBox= driver.findElement(XPathConstants.COMMENTBOX);
        commentBox.sendKeys("Test-Comment");

        saveBtn= driver.findElement(XPathConstants.SAVE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();
    }

    @Test(dependsOnMethods = "handleLoan")
    public void createRFQ() throws InterruptedException, IOException {


//       loadPropFile();
//       System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile5");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();

       driver.get(prop.getProperty("stg5-url"));

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BUTTONS));
        WebElement orgBtn = driver.findElement(XPathConstants.BUTTONS);
        highlightElement(driver, orgBtn);
        orgBtn.click();

        //organisationName="Predovic, Predovic And Predovic Test";

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ORGANIZATION_LIST));
        WebElement organizationSection= driver.findElement(XPathConstants.ORGANIZATION_LIST);

        List<WebElement> organizations= driver.findElements(XPathConstants.ORGANIZATIONS);
        for(WebElement organization:organizations)
        {
            highlightElement(driver,organization);
            WebElement organizationName= organization.findElement(XPathConstants.ORGANIZATION);

            if(organizationName.getText().equalsIgnoreCase(organisationName))
            {
                highlightElement(driver,organizationName);
                organizationName.click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DASHBOARD));
        WebElement dashBoardSection = driver.findElement(XPathConstants.DASHBOARD);
        wait.until(ExpectedConditions.elementToBeClickable(dashBoardSection));
        highlightElement(driver, dashBoardSection);
        dashBoardSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_WRAPPER));
        WebElement dashBoard= driver.findElement(XPathConstants.ACTION_WRAPPER);
        wait.until(ExpectedConditions.elementToBeClickable(dashBoard));
        highlightElement(driver,dashBoard);

        List<WebElement> blocks= dashBoard.findElements(XPathConstants.ACTION_ITEM);
        WebElement currBlock = null;
        for(WebElement block:blocks)
            currBlock= block;
        highlightElement(driver,currBlock);

        List<WebElement> actionItems= currBlock.findElements(XPathConstants.BTN);

        WebElement createRFQ=  actionItems.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(createRFQ));
        highlightElement(driver,createRFQ);
        createRFQ.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OFB Tech']")));
        driver.findElement(By.xpath("//button[text()='OFB Tech']")).click();

        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,600)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CATEGORYLIST));
        WebElement categoryList= driver.findElement(XPathConstants.CATEGORYLIST);
        Thread.sleep(2000);
        WebElement category= categoryList.findElements(XPathConstants.CATEGORY_CARD).get(17);
        WebElement viewProducts= category.findElement(XPathConstants.BTN);
        viewProducts.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBCATEGORY_LIST));
        WebElement subCategoryList= driver.findElement(XPathConstants.SUBCATEGORY_LIST);
        List<WebElement> subCategoryCards= subCategoryList.findElements(OfBusinessTest.XPathConstaints.CATEGORY_CARD);

        subCategoryCards.get(0).findElement(XPathConstants.ADD_TO_LIST).click();
        subCategoryCards.get(1).findElement(XPathConstants.ADD_TO_LIST).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.NEXT_BTN));
        WebElement btnNext= driver.findElement(XPathConstants.NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(btnNext));
        highlightElement(driver,btnNext);
        btnNext.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.SUBCATEGORY_FORM));
        List<WebElement> addedItemsList= driver.findElements(XPathConstants.SUBCATEGORY_FORM);
        for(WebElement item: addedItemsList)
        {
            item.findElement(XPathConstants.SUBCATEGORY).sendKeys("100");
        }
        Thread.sleep(1000);
        WebElement btnNext2= driver.findElement(XPathConstants.NEXT_BTN);
        btnNext2.click();

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        WebElement pinCode= driver.findElement(XPathConstants.ADDRESS_PO_NUMBER);
        pinCode.sendKeys(prop.getProperty("postalCode"));


        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT1);
        dateInput.sendKeys(date);
        System.out.println(date);

        WebElement uploadFileType= driver.findElement(OfBusinessTest.XPathConstaints.UPLOAD_FILE);
        uploadFileType.sendKeys(prop.getProperty("file-path"));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING_HIDE));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_BUTTONS));
        WebElement actionButtons= driver.findElement(XPathConstants.ACTION_BUTTONS);
        WebElement button= actionButtons.findElement(XPathConstants.BTN_XPATH);
        highlightElement(driver,button);
        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTION_BUTTONS));
        WebElement actionButtons2= driver.findElement(XPathConstants.ACTION_BUTTONS);
        WebElement submitBtn= actionButtons2.findElement(XPathConstants.BTN_XPATH);
        highlightElement(driver,submitBtn);
        submitBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BTNS_WRAP));
        WebElement viewEnquirySection= driver.findElement(XPathConstants.BTNS_WRAP);
        viewEnquirySection.findElement(XPathConstants.BTN_XPATH).click();

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

//        prop.setProperty("rfq-id",RFQ_ID);
//
//        System.out.println("From prop file "+ prop.getProperty("rfq-id"));

        driver.quit();

        UtilityMethod.setRFQ_ID(RFQ_ID);

    }

    @Test(dependsOnMethods = "createRFQ")
    public void handleCMS() throws InterruptedException, IOException {
        //setUp();
        if(driver==null)
        {
            setUp();
        }
        driver.get(prop.getProperty("stg5-cms-url"));
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.DRAWER));

        WebElement drawer= driver.findElement(OfBusinessTest.XPathConstaints.DRAWER);
        highlightElement(driver,drawer);

        WebElement orderSection= driver.findElement(XPathConstants.RFQ_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(orderSection));
        highlightElement(driver,orderSection);
        orderSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BUYOUT_BTN));
        WebElement buyoutBtn= driver.findElement(XPathConstants.BUYOUT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(buyoutBtn));
        highlightElement(driver,buyoutBtn);
        buyoutBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.MULTIPLE_USED_INPUT));
        WebElement searchRFQ= driver.findElement(OfBusinessTest.XPathConstaints.MULTIPLE_USED_INPUT);

        System.out.println("Utility RFQ_ID "+ UtilityMethod.getRFQ_ID());

        searchRFQ.sendKeys(UtilityMethod.getRFQ_ID());

        driver.findElement(XPathConstants.SEARCH_BTN).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath("//div[@class='rfqListTable']//tbody//tr")).click();

        System.out.println("Before Check Box");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.COPY_BTN));
            WebElement copyRatesToAll= subcategoryForm.findElement(XPathConstants.COPY_BTN);
            if(copyRatesToAll.isDisplayed())
                copyRatesToAll.click();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SAVE));
            WebElement saveBtn = driver.findElement(XPathConstants.SAVE);
            wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
            highlightElement(driver,saveBtn);
            saveBtn.click();

        }
    }

    @Test(dependsOnMethods = "handleCMS")
    public void handleBuyerPrefs() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BUYER_PREFS));

        WebElement buyerPrefs= driver.findElement(XPathConstants.BUYER_PREFS);
        highlightElement(driver,buyerPrefs);
        buyerPrefs.click();

        List<WebElement> buyerPrefsOptions= driver.findElements(XPathConstants.BUYER_PREFS_OPTIONS);

        WebElement preferences= buyerPrefsOptions.get(0).findElement(XPathConstants.PAYMENT_BUYERPO);
        preferences.click();

        WebElement editBtn=  buyerPrefsOptions.get(0).findElement(XPathConstants.ACTION_BTNS);
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

        List<WebElement> addressesOptions= driver.findElements(XPathConstants.ADDRESS_OPTIONS);
        WebElement shippingAddressBtn= addressesOptions.get(2);
        highlightElement(driver,shippingAddressBtn);
        shippingAddressBtn.click();

        List<WebElement> shippingAddressOptions= driver.findElements(XPathConstants.SHIPPING_ADDRESS_OPTION);
        if(!shippingAddressOptions.isEmpty())
            shippingAddressOptions.get(0).click();

        WebElement toleranceInput= buyerPrefsOptions.get(0).findElement(XPathConstants.TOLERANCE_POSTALCODE);
        toleranceInput.sendKeys("0");

        WebElement saveAddressBtn= buyerPrefsOptions.get(0).findElement(XPathConstants.BTN_XPATH);
        saveAddressBtn.click();



        WebElement paymentTerms=  buyerPrefsOptions.get(1);
        WebElement paymentTermsSection= paymentTerms.findElement(XPathConstants.PAYMENT_BUYERPO);
        highlightElement(driver,paymentTermsSection);
        paymentTermsSection.click();
        WebElement editBtn2= paymentTerms.findElement(XPathConstants.ACTION_BTNS);
        highlightElement(driver,editBtn2);
        editBtn2.click();

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        WebElement advanceInput= paymentTerms.findElement(XPathConstants.MULTIPLE_USED_INPUT);
        advanceInput.clear();
        advanceInput.sendKeys("0");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.VARIOUS_OPTIONS));
        WebElement credit_instrument= driver.findElement(XPathConstants.VARIOUS_OPTIONS);
        wait.until(ExpectedConditions.elementToBeClickable(credit_instrument));
        highlightElement(driver,credit_instrument);
        credit_instrument.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CREDIT_INST_OPTION));
        WebElement credit_instrument_option= driver.findElement(XPathConstants.CREDIT_INST_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(credit_instrument_option));
        highlightElement(driver,credit_instrument_option);
        credit_instrument_option.click();

        WebElement selectLimitBtn= driver.findElement(By.xpath("//button[@class='btn btn-default selectLimitBtn']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectLimitBtn));
        highlightElement(driver,selectLimitBtn);
        selectLimitBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='loan']")));
        WebElement loanDialog= driver.findElement(By.xpath("//label[@class='loan']"));

        WebElement checkBox= loanDialog.findElement(By.xpath(".//input[@class='checkbox']"));
        checkBox.click();

        WebElement addInOrder= driver.findElement(By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(addInOrder));
        highlightElement(driver,addInOrder);
        addInOrder.click();

        Thread.sleep(500);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SAVEBUTTON));
        WebElement saveBtn= paymentTerms.findElement(XPathConstants.SAVEBUTTON);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();

        Thread.sleep(2000);
        paymentTermsSection.click();
        WebElement sendForApproval= paymentTerms.findElement(XPathConstants.SEND_FOR_APPROVAL);
        wait.until(ExpectedConditions.elementToBeClickable(sendForApproval));

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();

        WebElement uploadPO=  buyerPrefsOptions.get(2);
        WebElement uploadBuyerPoSection= uploadPO.findElement(XPathConstants.PAYMENT_BUYERPO);
        highlightElement(driver,uploadBuyerPoSection);
        uploadBuyerPoSection.click();

        checkBox= driver.findElement(XPathConstants.CHECK__BOX);
        checkBox.click();
        System.out.println("Check Box Clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDITBTN));
        WebElement editBtn3= uploadPO.findElement(XPathConstants.EDITBTN);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn3));
        highlightElement(driver,editBtn3);
        editBtn3.click();

        WebElement buyerContainer= uploadPO.findElement(XPathConstants.BUYER_CONTAINER);
        WebElement PO_No= buyerContainer.findElement(XPathConstants.ADDRESS_PO_NUMBER);
        highlightElement(driver,PO_No);
        PO_No.sendKeys("12232");

        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATEINPUT);
        dateInput.sendKeys(date);

        WebElement uploadDoc= uploadPO.findElement(XPathConstants.UPLOADDOCS);
        uploadDoc.sendKeys(prop.getProperty("file-path"));

        Thread.sleep(6000);

        WebElement saveBtn2= uploadPO.findElement(XPathConstants.SAVE_BUTTON);
        Thread.sleep(1500);
        highlightElement(driver,saveBtn2);
        saveBtn2.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.EDIT_ENTITY));
        WebElement editEntity= driver.findElement(XPathConstants.EDIT_ENTITY);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", editEntity);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ENTITY_NAME_SECTION));
        WebElement entityNameSection= driver.findElement(XPathConstants.ENTITY_NAME_SECTION);
        highlightElement(driver,entityNameSection);
        entityNameSection.click();

        WebElement entityName= entityNameSection.findElement(XPathConstants.ADDRESS_VALUE);
        entityName.click();

        WebElement addressSection= driver.findElement(XPathConstants.ADDRESS_SECTION);
        highlightElement(driver,addressSection);
        addressSection.click();

        WebElement addressValue= addressSection.findElement(XPathConstants.ADDRESS_VALUE);
        highlightElement(driver,addressValue);
        addressValue.click();

        WebElement updateBtn= driver.findElement(XPathConstants.UPDATE_BTN);
        updateBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ITEM_SPECIFICATIONS));
        WebElement itemSpecifications= driver.findElement(XPathConstants.ITEM_SPECIFICATIONS);
        itemSpecifications.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_QUOTE));
        WebElement submitBuyerQuote= driver.findElement(XPathConstants.SUBMIT_QUOTE);

        wait.until(ExpectedConditions.elementToBeClickable(submitBuyerQuote));
        highlightElement(driver,submitBuyerQuote);
        submitBuyerQuote.click();


    }

    @Test(dependsOnMethods = "handleBuyerPrefs")
    public void handleSupplierQuotation() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUPPLIER_QUOTE));
        WebElement supplierQuote= driver.findElement(XPathConstants.SUPPLIER_QUOTE);
        highlightElement(driver,supplierQuote);
        supplierQuote.click();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        WebElement checkBoxSection= driver.findElement(XPathConstants.CHECKBOX_SECTION);
        highlightElement(driver,checkBoxSection);

        System.out.println("After check Box");

        WebElement checkoption= checkBoxSection.findElement(OfBusinessTest.XPathConstaints.CHECKBOX_OPTION);
        highlightElement(driver,checkoption);
        checkoption.click();
        System.out.println("Check Box Clicked");

        WebElement addSupplier= driver.findElements(OfBusinessTest.XPathConstaints.BTN_XPATH).get(1);
        highlightElement(driver,addSupplier);
        addSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.OPTIONS_SEARCHSUPPLIER));
        WebElement searchSupplier= driver.findElement(OfBusinessTest.XPathConstaints.OPTIONS_SEARCHSUPPLIER);
        searchSupplier.click();

        WebElement supplier_hint= driver.findElement(OfBusinessTest.XPathConstaints.SUPPLIER_HINT);
        supplier_hint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.SUPPLIER_OPTION));
        WebElement supplierOptions= driver.findElement(OfBusinessTest.XPathConstaints.SUPPLIER_OPTION);
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

        List<WebElement> addressOptions= driver.findElements(OfBusinessTest.XPathConstaints.ROLE_ADDRESS_OPTIONS);
        System.out.println(addressOptions.size());
        WebElement pickupAddress= addressOptions.get(4);
        pickupAddress.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.PICKUP_ADDRESS_VALUE));
        WebElement pickupAddressValue= driver.findElement(OfBusinessTest.XPathConstaints.PICKUP_ADDRESS_VALUE);
        pickupAddressValue.click();

        WebElement billingAddress= addressOptions.get(2);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.ADDRESS_VALUE));
        WebElement billingAddressvalue= driver.findElement(OfBusinessTest.XPathConstaints.ADDRESS_VALUE);
        billingAddressvalue.click();

        System.out.println("Done till here");
        WebElement incentiveReason= driver.findElement(OfBusinessTest.XPathConstaints.INCENTIVE_REASON);
        wait.until(ExpectedConditions.visibilityOf(incentiveReason));
        highlightElement(driver,incentiveReason);
        incentiveReason.click();

        WebElement incentiveReasonValue= driver.findElement(OfBusinessTest.XPathConstaints.INCENTIVE_REASON_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(incentiveReasonValue));
        highlightElement(driver,incentiveReasonValue);
        incentiveReasonValue.click();

        System.out.println("Done");

        List<WebElement> radioGroups= driver.findElements(OfBusinessTest.XPathConstaints.RADIO_GRP);

        WebElement incentiveTypes= radioGroups.get(2);
        incentiveTypes.findElement(By.xpath("//span[text()='Incoming']")).click();

        WebElement taxTypes= radioGroups.get(3);
        taxTypes.findElement(By.xpath("//span[text()='Without Tax']")).click();

//        WebElement incentiveLevel= radioGroups.get(4);
//        incentiveLevel.findElement(By.xpath("//span[text()='Item Level']")).click();

        WebElement incentiveLevel= driver.findElements(OfBusinessTest.XPathConstaints.INCENTIVE_LEVEL).get(1);
        incentiveLevel.click();

        Thread.sleep(2500);
        WebElement nextBtn= driver.findElement(OfBusinessTest.XPathConstaints.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        List<WebElement> subcategoryForms= driver.findElements(OfBusinessTest.XPathConstaints.SUBCATEGORY_FORM);
        for(WebElement subcategoryForm:subcategoryForms)
        {
            WebElement itemQty= subcategoryForm.findElement(OfBusinessTest.XPathConstaints.MULTIPLE_USED_INPUT);
            itemQty.clear();
            itemQty.sendKeys("100");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.MULTIPLE_USED_INPUT));
        WebElement itemQty= driver.findElement(OfBusinessTest.XPathConstaints.MULTIPLE_USED_INPUT);
        itemQty.clear();
        itemQty.sendKeys("100");

        WebElement baseRate= driver.findElement(OfBusinessTest.XPathConstaints.LANDMARK_BASERATE);
        baseRate.sendKeys("100");

        WebElement freightRate= driver.findElement(OfBusinessTest.XPathConstaints.MULTIPLE_INPUT_XPATH);
        freightRate.sendKeys("10");


        Thread.sleep(3000);
        WebElement dropDownOptions= driver.findElement(OfBusinessTest.XPathConstaints.DROPDOWN_OPTIONS);
        dropDownOptions.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.GST_OPTIONS));

        WebElement gstOption= driver.findElement(OfBusinessTest.XPathConstaints.GST_OPTIONS);
        highlightElement(driver,gstOption);
        gstOption.click();

        WebElement copyRatesToAll= driver.findElement(OfBusinessTest.XPathConstaints.COPY_BTN);
        if(copyRatesToAll.isDisplayed())
            copyRatesToAll.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.BTN_XPATH));
        WebElement saveBtn= driver.findElement(OfBusinessTest.XPathConstaints.BTN_XPATH);
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.VIEW_DETAILS));
        WebElement viewDetails= driver.findElement(OfBusinessTest.XPathConstaints.VIEW_DETAILS);
        highlightElement(driver,viewDetails);
        viewDetails.click();

        wait.until(ExpectedConditions.elementToBeClickable(OfBusinessTest.XPathConstaints.APPROVAL_BTN));
        WebElement sendForApproval= driver.findElement(OfBusinessTest.XPathConstaints.APPROVAL_BTN);

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();


        //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(OfBusinessTest.XPathConstaints.BTN_XPATH));
        WebElement createOrder= driver.findElement(OfBusinessTest.XPathConstaints.BTN_XPATH);
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



/*
    @AfterClass
    public void afterClass() throws IOException {
        // Trigger the tests of Class B after all tests in Class A are done
//        loadPropFile();
//        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile4");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//
//        driver.get(prop.getProperty("stg5-cms-url"));

        org.testng.TestNG testng = new org.testng.TestNG();
        testng.setTestClasses(new Class[]{OfBusinessTest.class});
        testng.setGroups("selected");
        testng.run();


    }*/
}




