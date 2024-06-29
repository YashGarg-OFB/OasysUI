import org.checkerframework.checker.index.qual.UpperBoundUnknown;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class OFBMarketPlace {

    class XPathConstants
    {
        public static final By DATEPICKER= By.className("react-datepicker__input-container");
        public static final By MONTH_YEAR_BTN= By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown");
        public static final By CURRDATE= By.xpath("//div[contains(@class, 'react-datepicker__day--today')]");
        public static final By DATE_INPUT1= By.className("react-datepicker-ignore-onclickoutside");

        public static final By ORGANIZATION_SECTION= By.xpath("//span[text()='Organisation']");
        public static final By ORGANIZATIONS= By.xpath("//div[@class='row tableListDataRow cursor']");
        public static final By ORGANIZATION= By.xpath(".//span[@class='valueOpacity']");
        public static final By BANKACCOUNT_SECTION= By.xpath("//button[text()='Bank Accounts']");
        public static final By ADD_BANK= By.xpath("//button[@class='btn btn-default addCtaBtn']");
        public static final By ACCOUNT_HOLDER= By.xpath("//input[@id='tfid-0-1']");
        public static final By IFSC_CODE= By.xpath("//input[@id='tfid-0-2']");
        public static final By GET_DETAILS= By.xpath("//button[@class='btn btn-link' and contains(text(),'Get Details')]");
        public static final By ACC_NO= By.xpath("//input[@id='tfid-0-3']");
        public static final By RE_ACCNO= By.xpath("//input[@id='tfid-0-4']");
        public static final By VARIOUS_OPTIONS= By.xpath("//div[@class=' css-1i8o47w']");
        public static final By ACCTYPE_VALUE= By.xpath("//div[@id='react-select-bankAccountType-option-2']");
        public static final By ISPRIMARY= By.xpath("//div[@id='react-select-isPrimaryAccount-option-0']");
        public static final By SUBMIT_BTN= By.xpath("//button[@class='btn btn-primary']");
        public static final By CREATED_ACCOUNTS= By.xpath("//div[@class='innerDetailsWrapper']");
        public static final By ACC_NUMBER= By.xpath(".//div[@class='col s6 m4 valueOpacity']");
        public static final By SHOW_MORE= By.xpath(".//i[@class='material-icons']");
        public static final By ACTION_DROPDOWN= By.xpath(".//ul[@class='dropDownContent']");
        public static final By ACTION_VERIFY= By.xpath(".//button[contains(text(),'Verify')]");
        public static final By UPLOAD_DOC= By.xpath("//input[@id='uploadAddrDoc']");
        public static final By DOCTYPE_VALUE= By.xpath("//div[@id='react-select-documentType-option-0']");
        public static final By DASHBOARD= By.xpath("//button[text()='Dashboard']");
        public static final By ACTION_WRAPPER= By.className("dashboardActionWrapper");
        public static final By ACTION_ITEM= By.className("actionItems");
        public static final By BTN = By.tagName("button");

        public static final By MARKETPLACE_BTN= By.xpath("//button[@aria-label='Ofb Marketplace']");
        public static final By SEARCH_INPUT= By.xpath("//input[@id='tfid-0-0']");
        public static final By SEARCH_BTN= By.xpath("//button[@class='btn search-btn']");
        public static final By RFQ_TABLE= By.xpath("//div[@class='rfqListTable']");
        public static final By TABLE_CONTENT= By.xpath("//tbody//tr");
        public static final By BUYER_NAME= By.xpath(".//span[@class='buyerName']");
        public static final By RFQ_ID_ELEMENT= By.xpath(".//span[@class='rowName nowrap']//span");
        public static final By MARKETPLACE_WRAPPER= By.xpath("//div[@class='marketPlaceWrapper']");
        public static final By MARKETPLACE_EDITBTN= By.xpath("//button[@class='btn btn-default']");
        public static final By VARIOUS_BTN= By.xpath(".//button[@class='btn btn-default']");

        public static final By ACTIVE_LIMIT= By.xpath("//div[@id='react-select-loan-option-0']");
        public static final By SELECT_BENEFICIARY= By.xpath("//label[@class='radioLabel']//span[text()='Self']");
        public static final By DISBURSEMENT_REASON= By.xpath("//div[@id='react-select-reasonsForDisbursement-option-2']");
        public static final By BANK_ACC_OPTION= By.xpath("//div[@id='react-select-payeeBankAccountId-option-0']");
        public static final By INVOICE_NUMBER= By.xpath("//input[@name='disbDetails[0][invoiceNo]']");
        public static final By INVOICE_AMOUNT= By.xpath("//input[@name='disbDetails[0][invoiceAmount]']");
        public static final By DISBURSAL_AMOUNT= By.xpath("//input[@name='disbDetails[0][disbursalAmount]']");
        public static final By UPLOADINVOICE_BTN= By.xpath("//button[@class='btn btn-default uploadButton']");
        public static final By DOC_UPLOADER= By.xpath("//div[@class='documentUploader']");
        public static final By DOC_INPUT= By.xpath(".//input[@id='file']");
        public static final By NEXT_BTN= By.xpath("//button[@class='btn btn-primary createBtn']");
        public static final By IS_DOC_UPLOADED= By.xpath("//span[@class='docTag']");
        public static final By MODAL_CONTENT= By.xpath("//div[@class='modalContent']");
        public static final By TAB_CONTAINER= By.xpath(".//div[@class='tabContainer']");
        public static final By TAB_BTNS= By.xpath(".//button[@class='btn btn-link']");
        public static final By UPLOAD_DOC_LABEL= By.xpath("//label[@class='uploadButton undefined']");
        public static final By UPLOADDOC_INPUT= By.xpath(".//input[@id='viaUpload']");
        public static final By CHECK_DOC_UPLOADED= By.xpath("//div[@class='listItem']");

        public static final By BUYER_PREFS= By.xpath("//span[text()='Buyer Preferences']");
        public static final By BUYER_PREFS_OPTIONS= By.className("contentView");
        public static final By PAYMENT_BUYERPO= By.className("heading");
        public static final By ACTION_BTNS= By.cssSelector("button.btn.btn-default");
        public static final By ADDRESS_OPTIONS= By.xpath("//div[@class= ' css-1i8o47w']");
        public static final By TOLERANCE_POSTALCODE = By.id("tfid-0-5");
        public static final By BTN_XPATH= By.cssSelector("button.btn.btn-primary");

        public static final By SHIPPING_ADDRESS_OPTION= By.xpath("//div[@class=' css-yxf0z2']");
        public static final By SAVEBTN= By.cssSelector("button.btn.btn-primary.saveBtn");
        public static final By SEND_FOR_APPROVAL= By.xpath("//button[text()='Send for Approval']");
        public static final By CHECK_BOX= By.xpath("//input[@class='enable']");
        public static final By EDITBTN= By.cssSelector("button.btn.btn-default.editBtn");
        public static final By BUYER_CONTAINER= By.className("buyerPoContainer");
        public static final By ADDRESS_PO_NUMBER = By.id("tfid-0-1");
        public static final By UPLOADDOCS= By.id("upload-document-undefined");
        public static final By SAVE= By.xpath("//button[text()='Save ']");
        public static final By EDIT_ENTITY= By.cssSelector("button.btnEdit.material-icons");
        public static final By ENTITY_NAME_SECTION= By.xpath("//div[@class='modalContent']//div[@id='ofbEntityName-tfid-0-0']");
        public static final By ADDRESS_VALUE= By.xpath("//div[@class=' css-1ul4jvx-option']");
        public static final By ADDRESS_SECTION= By.xpath("//div[@class='modalContent']//div[@id='ofbEntityAddress-tfid-0-1']");
        public static final By UPDATE_BTN= By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']");
        public static final By ITEM_SPECIFICATIONS= By.xpath("//div[@class='optHeader']//span");
        public static final By SUBMIT_QUOTE= By.xpath("//button[text()='Submit Buyer Quote ']");
        public static final By MULTIPLE_USED_INPUT= By.id("tfid-0-0");

        public static final By SUPPLIER_QUOTE= By.className("supplierQuote");
        public static final By CHECKBOX_SECTION= By.className("checkBoxContent");
        public static final By CHECKBOX_OPTION= By.cssSelector("input[type='checkbox']");
        public static final By OPTIONS_SEARCHSUPPLIER= By.xpath("//div[@class=' css-1i8o47w']");
        public static final By SUPPLIER_HINT= By.xpath("//input[@id='selectSupplier-input-tfid-0-0']");
        public static final By SUPPLIER_OPTION= By.id("react-select-selectSupplier-option-0");
        public static final By ROLE_ADDRESS_OPTIONS= By.xpath("//div[@class=' css-17vhrl4']");
        public static final By PICKUP_ADDRESS_VALUE= By.xpath("//div[@class=' css-1m5nn3x']//div");
        public static final By INCENTIVE_REASON= By.id("reason-tfid-0-0");
        public static final By INCENTIVE_REASON_VALUE= By.id("react-select-reason-option-0");
        public static final By RADIO_GRP= By.xpath("//div[@class='radio-group']");
        public static final By INCENTIVE_LEVEL= By.xpath("//span[text()='Item Level']");
        public static final By SUBCATEGORY_FORM= By.className("subCategoryForm");
        public static final By SUBCATEGORY= By.className("form-control");
        public static final By FREIGHT_RATE= By.id("tfid-0-6");
        public static final By LOADING_CHARGES= By.id("tfid-0-7");
        public static final By GST_OPTION= By.id("react-select-gst-option-2");
        public static final By SAVE_BTN= By.xpath("//button[@class='btn btn-primary' and contains(text(),'Save')]");

        public static final By LANDMARK_BASERATE= By.id("tfid-0-2");
        public static final By MULTIPLE_INPUT_XPATH= By.id("tfid-0-4");
        public static final By GST_OPTIONS= By.xpath("//div[@id='react-select-gst-option-2']");
        public static final By DROPDOWN_OPTIONS= By.className("reactSelectContainer");
        public static final By VIEW_DETAILS= By.xpath("//div[@class='optHeader']//span[@class='active']");
        public static final By APPROVAL_BTN = By.xpath("//button[@class='btn btn-default']");
        public static final By LOADING= By.xpath("//span[@class='loading-icon m-r-10 hide']");
        public static final By CHECKBOXES= By.xpath("//div[@class='checkbox-group']//span");
        public static final By UPDATE_SUBMIT_BTN= By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']");


        public static final By COMPANY_PROFILE= By.xpath("//button[text()='Company Profile']");
    }

    static WebDriver driver;
    static Properties prop;
    static String organisationName="Jerde LLC Test";
    String EnquiryID="";
    static String mainWindow;

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
        driver.get(prop.getProperty("stg5-url"));
        mainWindow = driver.getWindowHandle();
    }


    @Test(dependsOnMethods = "setUp")
    public void selectOrganization() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ORGANIZATION_SECTION));
        WebElement organizationSection= driver.findElement(XPathConstants.ORGANIZATION_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(organizationSection));
        highlightElement(driver,organizationSection);
        organizationSection.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.ORGANIZATIONS));
        List<WebElement> organizations= driver.findElements(XPathConstants.ORGANIZATIONS);
        for(WebElement organization:organizations)
        {
            highlightElement(driver,organization);
            WebElement organizationName= organization.findElement(XPathConstants.ORGANIZATION);

            if(organizationName.getText().equalsIgnoreCase(organisationName))
            {
                highlightElement(driver,organizationName);
                organization.click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.COMPANY_PROFILE));
        WebElement companyProfile = driver.findElement(XPathConstants.COMPANY_PROFILE);
        wait.until(ExpectedConditions.elementToBeClickable(companyProfile));
        highlightElement(driver, companyProfile);
        companyProfile.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BANKACCOUNT_SECTION));
        WebElement bankAccounts = driver.findElement(XPathConstants.BANKACCOUNT_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(bankAccounts));
        highlightElement(driver, bankAccounts);
        bankAccounts.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ADD_BANK));
        WebElement addBankBtn= driver.findElement(XPathConstants.ADD_BANK);
        wait.until(ExpectedConditions.elementToBeClickable(addBankBtn));
        highlightElement(driver,addBankBtn);
        addBankBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACCOUNT_HOLDER));
        WebElement accountHolder= driver.findElement(XPathConstants.ACCOUNT_HOLDER);
        accountHolder.sendKeys(prop.getProperty("name"));

        WebElement ifscCode= driver.findElement(XPathConstants.IFSC_CODE);
        ifscCode.sendKeys("123456");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.GET_DETAILS));
        WebElement getDetailsBtn= driver.findElement(XPathConstants.GET_DETAILS);
        wait.until(ExpectedConditions.elementToBeClickable(getDetailsBtn));
        highlightElement(driver,getDetailsBtn);
        getDetailsBtn.click();



        List<WebElement> accountOptions= driver.findElements(XPathConstants.VARIOUS_OPTIONS);
        WebElement accountType= accountOptions.get(0);

        wait.until(ExpectedConditions.elementToBeClickable(accountType));
        highlightElement(driver,accountType);
        accountType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACCTYPE_VALUE));
        WebElement accountType_option= driver.findElement(XPathConstants.ACCTYPE_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(accountType_option));
        highlightElement(driver,accountType_option);
        accountType_option.click();

        WebElement isPrimary= accountOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(isPrimary));
        highlightElement(driver,isPrimary);
        isPrimary.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ISPRIMARY));
        WebElement isPrimary_option= driver.findElement(XPathConstants.ISPRIMARY);
        wait.until(ExpectedConditions.elementToBeClickable(isPrimary_option));
        highlightElement(driver,isPrimary_option);
        isPrimary_option.click();

        String acc_no= String.valueOf(UtilityMethod.generateAccountNumber());

        WebElement accountNumber= driver.findElement(XPathConstants.ACC_NO);
        accountNumber.sendKeys(acc_no);

        WebElement reEnter_accountNumber= driver.findElement(XPathConstants.RE_ACCNO);
        reEnter_accountNumber.sendKeys(acc_no);

        WebElement submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.CREATED_ACCOUNTS));
        List<WebElement> createdBankAccounts= driver.findElements(XPathConstants.CREATED_ACCOUNTS);
        Actions actions= new Actions(driver);
        for(WebElement createdBank: createdBankAccounts)
        {
            highlightElement(driver,createdBank);

            WebElement accountNumber_Element= createdBank.findElements(XPathConstants.ACC_NUMBER).get(2);
            highlightElement(driver, accountNumber_Element);
            if(accountNumber_Element.getText().equalsIgnoreCase(acc_no))
            {
                WebElement showMore= createdBank.findElement(XPathConstants.SHOW_MORE);
                actions.moveToElement(showMore).build().perform();

                WebElement listOfOptions= createdBank.findElement(XPathConstants.ACTION_DROPDOWN);
                WebElement verifyButton= listOfOptions.findElement(XPathConstants.ACTION_VERIFY);
                verifyButton.click();
                break;
            }
        }

        Thread.sleep(4000);
        WebElement uploadDoc= driver.findElement(XPathConstants.UPLOAD_DOC);
        uploadDoc.sendKeys(prop.getProperty("file-path"));

        WebElement docType= driver.findElement(XPathConstants.VARIOUS_OPTIONS);
        wait.until(ExpectedConditions.elementToBeClickable(docType));
        highlightElement(driver,docType);
        docType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DOCTYPE_VALUE));
        WebElement docType_option= driver.findElement(XPathConstants.DOCTYPE_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(docType_option));
        highlightElement(driver,docType_option);
        docType_option.click();

        submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();
    }

    @Test(dependsOnMethods = "selectOrganization")
    public static void createRFQ() throws InterruptedException
    {
        Thread.sleep(6000);

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
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


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MARKETPLACE_EDITBTN));
        WebElement marketPlaceBtn= driver.findElement(XPathConstants.MARKETPLACE_EDITBTN);
        wait.until(ExpectedConditions.elementToBeClickable(marketPlaceBtn));
        highlightElement(driver,marketPlaceBtn);
        marketPlaceBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.VARIOUS_OPTIONS));
        WebElement activeLimits= driver.findElement(XPathConstants.VARIOUS_OPTIONS);
        wait.until(ExpectedConditions.elementToBeClickable(activeLimits));
        highlightElement(driver,activeLimits);
        activeLimits.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ACTIVE_LIMIT));
        WebElement activeLimit_option= driver.findElement(XPathConstants.ACTIVE_LIMIT);
        wait.until(ExpectedConditions.elementToBeClickable(activeLimit_option));
        highlightElement(driver,activeLimit_option);
        activeLimit_option.click();

        WebElement nextBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SELECT_BENEFICIARY));
        WebElement selectBeneficiary= driver.findElement(XPathConstants.SELECT_BENEFICIARY);
        highlightElement(driver,selectBeneficiary);
        selectBeneficiary.click();

        List<WebElement> beneficiaryOptions= driver.findElements(XPathConstants.VARIOUS_OPTIONS);
        WebElement disbursementReason= beneficiaryOptions.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(disbursementReason));
        highlightElement(driver,disbursementReason);
        disbursementReason.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DISBURSEMENT_REASON));
        WebElement disbursementReason_Option= driver.findElement(XPathConstants.DISBURSEMENT_REASON);
        wait.until(ExpectedConditions.elementToBeClickable(disbursementReason_Option));
        highlightElement(driver,disbursementReason_Option);
        disbursementReason_Option.click();

        WebElement bankAccount= beneficiaryOptions.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(bankAccount));
        highlightElement(driver,bankAccount);
        bankAccount.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BANK_ACC_OPTION));
        WebElement bankAccount_option= driver.findElement(XPathConstants.BANK_ACC_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(bankAccount_option));
        highlightElement(driver,bankAccount_option);
        bankAccount_option.click();

        WebElement inVoiceNumber= driver.findElement(XPathConstants.INVOICE_NUMBER);
        inVoiceNumber.sendKeys("12345");

        WebElement invoiceAmount= driver.findElement(XPathConstants.INVOICE_AMOUNT);
        invoiceAmount.sendKeys("120000");

        WebElement disbursalAmount= driver.findElement(XPathConstants.DISBURSAL_AMOUNT);
        disbursalAmount.sendKeys("120000");

        WebElement uploadInvoiceBtn= driver.findElement(XPathConstants.UPLOADINVOICE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(uploadInvoiceBtn));
        highlightElement(driver,uploadInvoiceBtn);
        uploadInvoiceBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DOC_UPLOADER));
        WebElement docUploader= driver.findElement(XPathConstants.DOC_UPLOADER);
        wait.until(ExpectedConditions.elementToBeClickable(docUploader));
        highlightElement(driver,docUploader);

        WebElement docInput= docUploader.findElement(XPathConstants.DOC_INPUT);
        docInput.sendKeys(prop.getProperty("file-path"));

        Thread.sleep(1500);

        WebElement submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.NEXT_BTN));
        nextBtn= driver.findElement(XPathConstants.NEXT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));

        WebElement checkDocIsUploaded= driver.findElement(XPathConstants.IS_DOC_UPLOADED);
        Assert.assertNotNull(checkDocIsUploaded,"Doc is uploaded successfully");

        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_BTN));
        nextBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        Thread.sleep(9000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MODAL_CONTENT));
        WebElement quotationDialog= driver.findElement(XPathConstants.MODAL_CONTENT);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.TAB_CONTAINER));
        WebElement tabContainer= quotationDialog.findElement(XPathConstants.TAB_CONTAINER);
        highlightElement(driver,tabContainer);

        WebElement viaDoc= tabContainer.findElements(XPathConstants.TAB_BTNS).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(viaDoc));
        highlightElement(driver,viaDoc);
        viaDoc.click();

        WebElement uploadDoc_label= driver.findElement(XPathConstants.UPLOAD_DOC_LABEL);
        wait.until(ExpectedConditions.elementToBeClickable(uploadDoc_label));
        highlightElement(driver,uploadDoc_label);

        WebElement uploadDoc_input= uploadDoc_label.findElement(XPathConstants.UPLOADDOC_INPUT);
        uploadDoc_input.sendKeys(prop.getProperty("file-path"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CHECK_DOC_UPLOADED));
        WebElement isDocUploaded= driver.findElement(XPathConstants.CHECK_DOC_UPLOADED);
        Assert.assertNotNull(isDocUploaded,"Doc Uploaded Successfully");

        submitBtn= driver.findElement(XPathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();
    }

    @Test(dependsOnMethods = "createRFQ")
    public void handlePureMarketPlace()
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.get(prop.getProperty("stg5-cms-url"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MARKETPLACE_BTN));
        WebElement ofbMarketPlace= driver.findElement(XPathConstants.MARKETPLACE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(ofbMarketPlace));
        highlightElement(driver,ofbMarketPlace);
        ofbMarketPlace.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SEARCH_INPUT));
        WebElement searchInput= driver.findElement(XPathConstants.SEARCH_INPUT);

        //searchInput.sendKeys(RFQ_ID);

        WebElement searchBtn= driver.findElement(XPathConstants.SEARCH_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        highlightElement(driver,searchBtn);
        searchBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.RFQ_TABLE));

        WebElement tableContent= driver.findElement(XPathConstants.TABLE_CONTENT);
        List<WebElement> requiredRFQ_options= tableContent.findElements(By.xpath(".//td"));

        WebElement buyerNameElement= requiredRFQ_options.get(1).findElement(XPathConstants.BUYER_NAME);
        highlightElement(driver,buyerNameElement);

        Assert.assertTrue(buyerNameElement.getText().equalsIgnoreCase(organisationName),"Choosen Buyer Name is: "+ buyerNameElement.getText());

        WebElement RFQ_ID_ELEMENT= requiredRFQ_options.get(2).findElement(XPathConstants.RFQ_ID_ELEMENT);
        highlightElement(driver,RFQ_ID_ELEMENT);

        //Assert.assertTrue(RFQ_ID_ELEMENT.getText().equalsIgnoreCase(RFQ_ID),"RFQ ID of choosen buyer is "+ RFQ_ID_ELEMENT.getText());

        tableContent.click();
    }

    //https://stg5-cms.ofbusiness.co.in/oasys-fe/rfq/BRFQ_20240626284819


    @Test(dependsOnMethods = "handlePureMarketPlace")
    public void handleBuyerQuotation() throws InterruptedException, IOException {


//        loadPropFile();
//        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile4");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        mainWindow = driver.getWindowHandle();
//        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-fe/rfq/BRFQ_20240626284819");

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MARKETPLACE_WRAPPER));

        WebElement marketPlaceWrapper= driver.findElement(XPathConstants.MARKETPLACE_WRAPPER);
        highlightElement(driver, marketPlaceWrapper);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MARKETPLACE_EDITBTN));
        WebElement editBtn= marketPlaceWrapper.findElement(XPathConstants.VARIOUS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        highlightElement(driver,editBtn);
        editBtn.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.DATEPICKER));

        WebElement scrollTo= driver.findElement(By.xpath("//span[@class='btn btn-primary uploadBtn']"));

        WebElement datePicker= driver.findElement(XPathConstants.DATEPICKER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollTo);
        Thread.sleep(600);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XPathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XPathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT1);
        dateInput.sendKeys(date);

        WebElement saveBtn= driver.findElement(XPathConstants.SAVE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));

        Thread.sleep(3000);

        highlightElement(driver,saveBtn);
        saveBtn.click();

        WebElement addItemsBtn= driver.findElement(By.xpath("//button[@class='btn btn-default']//i[text()='add']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addItemsBtn);
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(addItemsBtn));
        highlightElement(driver,addItemsBtn);
        addItemsBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='baseCatWrapper']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='catItem']")));
        WebElement product= driver.findElements(By.xpath("//div[@class='catItem']")).get(0);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default']")));
        WebElement viewProductBtn= product.findElement(XPathConstants.VARIOUS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(viewProductBtn));
        highlightElement(driver,viewProductBtn);
        viewProductBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='leafCatWrapper']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='catItem']")));
        WebElement items= driver.findElements(By.xpath("//div[@class='catItem']")).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(items));
        highlightElement(driver,items);

        WebElement addToCart= items.findElement(XPathConstants.VARIOUS_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        highlightElement(driver,addToCart);
        addToCart.click();




        WebElement cartBtn= driver.findElement(By.xpath("//div[@class='cartBtn']"));
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn));

        WebElement cartDetails= cartBtn.findElement(By.xpath(".//span[@class='countLabel']"));
        System.out.println("Cart Details for assertion are "+ cartDetails.getText());

        highlightElement(driver,cartBtn);
        cartBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Quantity']")));
        WebElement quantityInput= driver.findElement(By.xpath("//input[@name='Quantity']"));
        quantityInput.sendKeys("100");

        WebElement unit_dropdown= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(unit_dropdown));
        highlightElement(driver,unit_dropdown);
        unit_dropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-Unit-option-0']")));
        WebElement unit_option= driver.findElement(By.xpath("//div[@id='react-select-Unit-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(unit_option));
        highlightElement(driver,unit_option);
        unit_option.click();

        WebElement brand_dopdown= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
        wait.until(ExpectedConditions.elementToBeClickable(brand_dopdown));
        highlightElement(driver,brand_dopdown);
        brand_dopdown.click();

        WebElement brand_hint= driver.findElement(By.xpath("//input[contains(@id,'tfid-0-2')]"));
        brand_hint.sendKeys("TATA");
        Thread.sleep(1400);
        brand_hint.sendKeys(Keys.ENTER);

        WebElement confirmItems= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        wait.until(ExpectedConditions.elementToBeClickable(confirmItems));
        highlightElement(driver,confirmItems);
        confirmItems.click();

    }

    @Test(dependsOnMethods = "handleBuyerQuotation")
    public void handleBuyerPrefs() throws InterruptedException, IOException {
//        loadPropFile();
//        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile4");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        mainWindow = driver.getWindowHandle();
//        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-fe/rfq/BRFQ_20240626284819/buyer/item-rate");

        Thread.sleep(5000);

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BUYER_PREFS));

        WebElement buyerPrefs= driver.findElement(XPathConstants.BUYER_PREFS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buyerPrefs);
        Thread.sleep(600);
        highlightElement(driver,buyerPrefs);
        buyerPrefs.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XPathConstants.BUYER_PREFS_OPTIONS));
        List<WebElement> buyerPrefsOptions= driver.findElements(XPathConstants.BUYER_PREFS_OPTIONS);


        WebElement preferences= buyerPrefsOptions.get(0).findElement(XPathConstants.PAYMENT_BUYERPO);
        wait.until(ExpectedConditions.elementToBeClickable(preferences));
        highlightElement(driver,preferences);


        WebElement editBtn=  buyerPrefsOptions.get(0).findElement(XPathConstants.ACTION_BTNS);
        highlightElement(driver,editBtn);
        editBtn.click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("address")));
//
//        List<WebElement> addressesOptions= driver.findElements(XPathConstants.ADDRESS_OPTIONS);
//
//        WebElement billingAddress= addressesOptions.get(1);
//        highlightElement(driver,billingAddress);
//        billingAddress.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-billingAddress-option-0']")));
//        WebElement billingAddressOption= driver.findElement(By.xpath("//div[@id='react-select-billingAddress-option-0']"));
//        wait.until(ExpectedConditions.elementToBeClickable(billingAddressOption));
//        highlightElement(driver,billingAddressOption);
//        billingAddressOption.click();
//
//
//
//        WebElement shippingAddressBtn= addressesOptions.get(3);
//        highlightElement(driver,shippingAddressBtn);
//        shippingAddressBtn.click();
//
//        List<WebElement> shippingAddressOptions= driver.findElements(XPathConstants.SHIPPING_ADDRESS_OPTION);
//        if(!shippingAddressOptions.isEmpty())
//            shippingAddressOptions.get(0).click();
//
//        WebElement toleranceInput= buyerPrefsOptions.get(0).findElement(XPathConstants.TOLERANCE_POSTALCODE);
//        toleranceInput.sendKeys("0");

        WebElement saveAddressBtn= buyerPrefsOptions.get(0).findElement(XPathConstants.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(saveAddressBtn));
        highlightElement(driver,saveAddressBtn);
        saveAddressBtn.click();



        WebElement paymentTerms=  buyerPrefsOptions.get(1);
        WebElement paymentTermsSection= paymentTerms.findElement(XPathConstants.PAYMENT_BUYERPO);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentTermsSection);
        Thread.sleep(400);

        highlightElement(driver,paymentTermsSection);
        paymentTermsSection.click();

        Thread.sleep(2000);

        WebElement editBtn2= paymentTerms.findElement(XPathConstants.ACTION_BTNS);
        highlightElement(driver,editBtn2);
        editBtn2.click();

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        WebElement advanceInput= paymentTerms.findElement(XPathConstants.MULTIPLE_USED_INPUT);
        advanceInput.clear();
        advanceInput.sendKeys("100");

//        WebElement financer= driver.findElement(By.xpath("//div[@class=' css-1i8o47w']"));
//        wait.until(ExpectedConditions.elementToBeClickable(financer));
//        highlightElement(driver,financer);
//        financer.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-financier-option-0']")));
        WebElement financerOption= driver.findElement(By.xpath("//div[@id='react-select-financier-option-0']"));
        wait.until(ExpectedConditions.elementToBeClickable(financerOption));
        highlightElement(driver,financerOption);
        financerOption.click();

        WebElement saveBtn= paymentTerms.findElement(XPathConstants.SAVEBTN);
        highlightElement(driver,saveBtn);
        saveBtn.click();

        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentTermsSection);
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(paymentTermsSection));
        highlightElement(driver,paymentTermsSection);
        paymentTermsSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SEND_FOR_APPROVAL));
        WebElement sendForApproval= paymentTerms.findElement(XPathConstants.SEND_FOR_APPROVAL);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sendForApproval);
        Thread.sleep(1500);

        wait.until(ExpectedConditions.elementToBeClickable(sendForApproval));

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();

        WebElement uploadPO=  buyerPrefsOptions.get(2);
        WebElement uploadBuyerPoSection= uploadPO.findElement(XPathConstants.PAYMENT_BUYERPO);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadBuyerPoSection);
        Thread.sleep(1400);
        highlightElement(driver,uploadBuyerPoSection);
        uploadBuyerPoSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.CHECK_BOX));
        WebElement checkBox= driver.findElement(XPathConstants.CHECK_BOX);
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

        WebElement dateInput= driver.findElement(XPathConstants.DATE_INPUT1);
        dateInput.sendKeys(date);

        WebElement uploadDoc= uploadPO.findElement(XPathConstants.UPLOADDOCS);
        uploadDoc.sendKeys(prop.getProperty("file-path"));

        Thread.sleep(6000);

        WebElement saveBtn2= uploadPO.findElement(ConfirmedEnquiry.XpathConstants.SAVE);
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

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading-icon m-r-10 hide']")));
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ITEM_SPECIFICATIONS));
        WebElement itemSpecifications= driver.findElement(XPathConstants.ITEM_SPECIFICATIONS);
        itemSpecifications.click();


        WebElement checkBoxSection= driver.findElement(XPathConstants.CHECKBOX_SECTION);
        highlightElement(driver,checkBoxSection);

        System.out.println("After check Box");

        WebElement checkoption= checkBoxSection.findElement(XPathConstants.CHECKBOX_OPTION);
        highlightElement(driver,checkoption);
        checkoption.click();
        System.out.println("Check Box Clicked");

        WebElement actions= driver.findElement(By.xpath("//div[@class='actions']"));
        List<WebElement> actionButtons= actions.findElements(XPathConstants.VARIOUS_BTN);
        actionButtons.get(1).click();

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SAVE_BTN));
        saveBtn = driver.findElement(XPathConstants.SAVE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();





        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUBMIT_QUOTE));
        WebElement submitBuyerQuote= driver.findElement(XPathConstants.SUBMIT_QUOTE);

        wait.until(ExpectedConditions.elementToBeClickable(submitBuyerQuote));
        highlightElement(driver,submitBuyerQuote);
        submitBuyerQuote.click();
    }

    //@Test//(dependsOnMethods = "handleBuyerPrefs")
    public void handleSupplierQuotation() throws InterruptedException, IOException {

        loadPropFile();
        System.setProperty("webdriver.chrome.driver", "/home/yash/Downloads/chromedriver-linux64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/home/yash/.config/google-chrome/AutomationProfile4");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        mainWindow = driver.getWindowHandle();
        driver.get("https://stg5-cms.ofbusiness.co.in/oasys-fe/rfq/BRFQ_20240626284828/supplier/item-rate");


        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUPPLIER_QUOTE));
        WebElement supplierQuote= driver.findElement(XPathConstants.SUPPLIER_QUOTE);
        highlightElement(driver,supplierQuote);
        supplierQuote.click();


        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        WebElement checkBoxSection= driver.findElement(XPathConstants.CHECKBOX_SECTION);
        highlightElement(driver,checkBoxSection);

        System.out.println("After check Box");

        WebElement checkoption= checkBoxSection.findElement(XPathConstants.CHECKBOX_OPTION);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoption);
        Thread.sleep(400);
        highlightElement(driver,checkoption);
        checkoption.click();
        System.out.println("Check Box Clicked");

        WebElement addSupplier= driver.findElements(XPathConstants.BTN_XPATH).get(1);
        highlightElement(driver,addSupplier);
        addSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.OPTIONS_SEARCHSUPPLIER));
        WebElement searchSupplier= driver.findElement(XPathConstants.OPTIONS_SEARCHSUPPLIER);
        searchSupplier.click();

        WebElement supplier_hint= driver.findElement(XPathConstants.SUPPLIER_HINT);
        supplier_hint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.SUPPLIER_OPTION));
        WebElement supplierOptions= driver.findElement(XPathConstants.SUPPLIER_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(supplierOptions));
        highlightElement(driver,supplierOptions);
        supplierOptions.click();


        Thread.sleep(4000);

        List<WebElement> addressOptions= driver.findElements(XPathConstants.ROLE_ADDRESS_OPTIONS);
        System.out.println(addressOptions.size());
        WebElement pickupAddress= addressOptions.get(4);
        pickupAddress.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.PICKUP_ADDRESS_VALUE));
        WebElement pickupAddressValue= driver.findElement(XPathConstants.PICKUP_ADDRESS_VALUE);
        pickupAddressValue.click();

        WebElement billingAddress= addressOptions.get(2);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.ADDRESS_VALUE));
        WebElement billingAddressvalue= driver.findElement(XPathConstants.ADDRESS_VALUE);
        billingAddressvalue.click();

        System.out.println("Done till here");
        WebElement incentiveReason= driver.findElement(XPathConstants.INCENTIVE_REASON);
        wait.until(ExpectedConditions.visibilityOf(incentiveReason));
        highlightElement(driver,incentiveReason);
        incentiveReason.click();

        WebElement incentiveReasonValue= driver.findElement(XPathConstants.INCENTIVE_REASON_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(incentiveReasonValue));
        highlightElement(driver,incentiveReasonValue);
        incentiveReasonValue.click();

        System.out.println("Done");

        List<WebElement> radioGroups= driver.findElements(XPathConstants.RADIO_GRP);

        WebElement incentiveTypes= radioGroups.get(2);
        incentiveTypes.findElement(By.xpath("//span[text()='Incoming']")).click();

        WebElement taxTypes= radioGroups.get(3);
        taxTypes.findElement(By.xpath("//span[text()='Without Tax']")).click();

        WebElement incentiveLevel= driver.findElements(XPathConstants.INCENTIVE_LEVEL).get(1);
        incentiveLevel.click();

        Thread.sleep(2500);
        WebElement nextBtn= driver.findElement(XPathConstants.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        List<WebElement> subcategoryForms= driver.findElements(XPathConstants.SUBCATEGORY_FORM);
        for(WebElement subcategoryForm:subcategoryForms)
        {
            WebElement itemQty= subcategoryForm.findElement(XPathConstants.MULTIPLE_USED_INPUT);
            itemQty.clear();
            itemQty.sendKeys("100");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.MULTIPLE_USED_INPUT));
        WebElement itemQty= driver.findElement(XPathConstants.MULTIPLE_USED_INPUT);
        itemQty.clear();
        itemQty.sendKeys("100");

        WebElement baseRate= driver.findElement(XPathConstants.LANDMARK_BASERATE);
        baseRate.sendKeys("100");

        WebElement freightRate= driver.findElement(XPathConstants.MULTIPLE_INPUT_XPATH);
        freightRate.sendKeys("10");


        Thread.sleep(3000);
        WebElement dropDownOptions= driver.findElement(XPathConstants.DROPDOWN_OPTIONS);
        dropDownOptions.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.GST_OPTIONS));

        WebElement gstOption= driver.findElement(XPathConstants.GST_OPTIONS);
        highlightElement(driver,gstOption);
        gstOption.click();

//        WebElement copyRatesToAll= driver.findElement(ConfirmedEnquiry.XpathConstants.COPY_BTN);
//        if(copyRatesToAll.isDisplayed())
//            copyRatesToAll.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BTN_XPATH));
        WebElement saveBtn= driver.findElement(XPathConstants.BTN_XPATH);
        highlightElement(driver,saveBtn);
        saveBtn.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='View Supplier Details ']")));
        WebElement viewDetails= driver.findElement(By.xpath("//span[text()='View Supplier Details ']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewDetails);
        Thread.sleep(900);
        highlightElement(driver,viewDetails);
        viewDetails.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Send all for Approval')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewDetails);
        Thread.sleep(900);
        WebElement sendForApproval= driver.findElement(By.xpath("//button[contains(text(),'Send all for Approval')]"));

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();

        Thread.sleep(500);
        driver.navigate().refresh();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XPathConstants.BTN_XPATH));
        WebElement createOrder= driver.findElement(XPathConstants.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(createOrder));
        highlightElement(driver,createOrder);
        createOrder.click();

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

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XPathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Order']")));
        WebElement orderLink= driver.findElement(By.xpath("//a[text()='Order']"));
        Assert.assertNotNull(orderLink, "Order Created Sucessfully");
        Thread.sleep(10000);
    }
}
