import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

public class ConfirmedEnquiry {

    class XpathConstants
    {
        public static final By DATEPICKER= By.className("react-datepicker__input-container");
        public static final By MONTH_YEAR_BTN= By.cssSelector("div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown");
        public static final By CURRDATE= By.xpath("//div[contains(@class, 'react-datepicker__day--today')]");
        public static final By DATE_INPUT1= By.className("react-datepicker-ignore-onclickoutside");
        public static final By DATE_INPUT= By.xpath("//input[@placeholder='Select date']");

        public static final By ENQUIRY_SECTION= By.xpath("//span[text()='Confirmed Enquiry']");
        public static final By NEW_ENQUIRY= By.xpath("//button[@class='btn btn-primary newEnquiryBtn']");
        public static final By CLIENT_HINT= By.xpath("//input[@id='react-select-2-input']");
        public static final By CLIENT_OPTIONS= By.xpath("//div[@class=' css-1ul4jvx-option']");
        public static final By CLIENT_NAME= By.xpath(".//div[@class='name']");
        public static final By SHIPPING_CITY= By.xpath("//input[@id='tfid-0-0']");
        public static final By BILLINGCITY_QTY= By.xpath("//input[@id='tfid-0-1']");
        public static final By INST_OPTION= By.xpath("//div[@id='react-select-instrument-option-0']");
        public static final By SUBMIT_BTN= By.xpath("//button[@class='btn btn-primary']");
        public static final By SUBCATEGORY_HINT= By.xpath("//input[@id='category-input-tfid-0-0']");
        public static final By SUBCATEGORY_OPTION= By.xpath("//div[@id='react-select-category-option-0']");
        public static final By UOM_OPTION= By.xpath("//div[@id='react-select-uom-option-0']");
        public static final By PURCHASE_UNITRATE= By.xpath("//input[@id='tfid-0-3']");
        public static final By SALE_UNITRATE= By.xpath("//input[@id='tfid-0-4']");
        public static final By CREATE_BTN= By.xpath("//button[@class='btn btn-primary' and contains(text(),'Create')]");
        public static final By COPY_RFQ= By.xpath("//button[@class='btn  btn-primary']");
        public static final By ALL_ENQUIRIES_BTN= By.xpath("//button[@class='btn btn-default' and contains(text(),'All Enquires')]");
        public static final By ENQUIRIES= By.xpath("//div[@class='enquiryCard']");
        public static final By ENQUIRY_TITLE= By.xpath(".//div[@class='title']");
        public static final By ENQUIRY_OPTIONS= By.xpath(".//div[@class='singleInfo']");
        public static final By ITEM_QTY= By.xpath(".//div[@class='categoryName']");

        public static final By DRAWER= By.cssSelector("tri-menu.customSideMenu.ng-scope.ng-isolate-scope.md-ofb-brown-theme.flex");
        public static final By RFQ_SECTION= By.xpath("//span[text()='Buyout RFQs']");
        public static final By BUYOUT_BTN= By.xpath("//button[@aria-label='Confirmed Enquiry']");
        public static final By RFQ_SUBTYPE= By.xpath("//div[@class='selectedRfqSubtype']");
        public static final By ALL_RFQ= By.xpath("//div[@class='rfqViewTypeButton']");
        public static final By SEARCH_BTN= By.cssSelector("button.btn.search-btn");
        public static final By RFQ_LIST= By.xpath("//div[@class='rfqListTable']//tbody//tr");
        public static final By MULTIPLE_USED_INPUT= By.id("tfid-0-0");
        public static final By CHECKBOX_SECTION= By.className("checkBoxContent");
        public static final By CHECKBOX_OPTION= By.cssSelector("input[type='checkbox']");
        public static final By ACTION_BTNS= By.cssSelector("button.btn.btn-default");


        public static final By SUBCATEGORY_FORM= By.className("subCategoryForm");

        public static final By SUBCATEGORY= By.className("form-control");
        public static final By FREIGHT_RATE= By.id("tfid-0-6");
        public static final By LOADING_CHARGES= By.id("tfid-0-7");
        public static final By BTN_XPATH= By.cssSelector("button.btn.btn-primary");
        public static final By DROPDOWN_OPTIONS= By.className("reactSelectContainer");
        public static final By GST_OPTION= By.id("react-select-gst-option-2");
        public static final By COPY_BTN= By.className("copyBtn");
        public static final By SAVE_BTN= By.xpath("//button[@class='btn btn-primary' and contains(text(),'Save')]");

        public static final By BUYER_PREFS= By.xpath("//span[text()='Buyer Preferences']");
        public static final By BUYER_PREFS_OPTIONS= By.className("contentView");
        public static final By PAYMENT_BUYERPO= By.className("heading");
        public static final By ADDRESS_OPTIONS= By.xpath("//div[@class= ' css-1i8o47w']");
        public static final By BILLING_ADDRESS_VALUE= By.xpath("//div[@id='react-select-billingAddress-option-0']");
        public static final By TOLERANCE_POSTALCODE = By.id("tfid-0-5");
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

        public static final By SUPPLIER_QUOTE= By.className("supplierQuote");
        public static final By OPTIONS_SEARCHSUPPLIER= By.xpath("//div[@class=' css-1i8o47w']");
        public static final By OPS_ASSIGNEE_HINT= By.xpath("//input[@id='opsAssignee-input-tfid-0-3']");
        public static final By OPS_ASSIGNEE_VALUE= By.xpath("//div[@id='react-select-opsAssignee-option-0']");
        public static final By SUPPLIER_HINT= By.xpath("//input[@id='selectSupplier-input-tfid-0-0']");
        public static final By SUPPLIER_OPTION= By.id("react-select-selectSupplier-option-0");
        public static final By ROLE_ADDRESS_OPTIONS= By.xpath("//div[@class=' css-17vhrl4']");
        public static final By PICKUP_ADDRESS_VALUE= By.xpath("//div[@class=' css-1m5nn3x']//div");
        public static final By INCENTIVE_REASON= By.id("reason-tfid-0-0");
        public static final By INCENTIVE_REASON_VALUE= By.id("react-select-reason-option-0");
        public static final By RADIO_GRP= By.xpath("//div[@class='radio-group']");
        public static final By INCENTIVE_LEVEL= By.xpath("//span[text()='Item Level']");
        public static final By LANDMARK_BASERATE= By.id("tfid-0-2");
        public static final By MULTIPLE_INPUT_XPATH= By.id("tfid-0-4");
        public static final By GST_OPTIONS= By.xpath("//div[@id='react-select-gst-option-2']");
        public static final By VIEW_DETAILS= By.xpath("//div[@class='optHeader']//span[@class='active']");
        public static final By APPROVAL_BTN = By.xpath("//button[@class='btn btn-default']");
        public static final By LOADING= By.xpath("//span[@class='loading-icon m-r-10 hide']");
        public static final By MODAL_CONTENT= By.xpath("//div[@class='modalContent']");
        public static final By CHECKBOXES= By.xpath("//div[@class='checkbox-group']//span");
        public static final By UPDATE_SUBMIT_BTN= By.xpath("//div[@class='modalFooter']//button[@class='btn btn-primary']");
        public static final By ORDER_LINK= By.xpath("//a[text()='Order']");

    }

    static WebDriver driver;
    static Properties prop;
    static String organisationName="DZAF JSLNSJJWX";
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

    public static int getNumericValue(String str) {
        // Remove non-digit characters
        String numericString = str.replaceAll("[^\\d]", "");
        // Convert the string to an integer
        return Integer.parseInt(numericString);
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
    public void handleConfirmedEnquiry() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ENQUIRY_SECTION));
        WebElement enquirySection= driver.findElement(XpathConstants.ENQUIRY_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(enquirySection));
        highlightElement(driver,enquirySection);
        enquirySection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.NEW_ENQUIRY));
        WebElement newEnquiryBtn= driver.findElement(XpathConstants.NEW_ENQUIRY);
        wait.until(ExpectedConditions.elementToBeClickable(newEnquiryBtn));
        highlightElement(driver,newEnquiryBtn);
        newEnquiryBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.OPTIONS_SEARCHSUPPLIER));
        WebElement searchClient= driver.findElement(XpathConstants.OPTIONS_SEARCHSUPPLIER);
        wait.until(ExpectedConditions.elementToBeClickable(searchClient));
        highlightElement(driver,searchClient);
        searchClient.click();

        WebElement clientHint= driver.findElement(XpathConstants.CLIENT_HINT);
        clientHint.sendKeys(organisationName);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.CLIENT_OPTIONS));
        List<WebElement> clientOptions= driver.findElements(XpathConstants.CLIENT_OPTIONS);
        for(WebElement clientoption:clientOptions)
        {
            WebElement client_option_name= clientoption.findElement(XpathConstants.CLIENT_NAME);
            highlightElement(driver,client_option_name);
            if(client_option_name.getText().equalsIgnoreCase(organisationName))
            {
                highlightElement(driver,clientoption);
                clientoption.click();
                break;
            }
        }

        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SHIPPING_CITY));
        WebElement shippingCity= driver.findElement(XpathConstants.SHIPPING_CITY);
        shippingCity.sendKeys("Ghaziabad");

        WebElement billingCity= driver.findElement(XpathConstants.BILLINGCITY_QTY);
        billingCity.sendKeys("Delhi");

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

        List<WebElement> options= driver.findElements(XpathConstants.OPTIONS_SEARCHSUPPLIER);
        WebElement opsAssignee= options.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(opsAssignee));
        highlightElement(driver,opsAssignee);
        opsAssignee.click();

        WebElement opsAssignee_hint= driver.findElement(XpathConstants.OPS_ASSIGNEE_HINT);
        opsAssignee_hint.sendKeys("anas");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.OPS_ASSIGNEE_VALUE));
        WebElement opsAssignee_value= driver.findElement(XpathConstants.OPS_ASSIGNEE_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(opsAssignee_value));
        highlightElement(driver,opsAssignee_value);
        opsAssignee_value.click();

        WebElement selectInstrument= options.get(1);
        wait.until(ExpectedConditions.elementToBeClickable(selectInstrument));
        highlightElement(driver,selectInstrument);
        selectInstrument.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.INST_OPTION));
        WebElement select_inst_option= driver.findElement(XpathConstants.INST_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(select_inst_option));
        highlightElement(driver,selectInstrument);
        select_inst_option.click();

        WebElement nextBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.OPTIONS_SEARCHSUPPLIER));
        WebElement selectSubCategory= driver.findElement(XpathConstants.OPTIONS_SEARCHSUPPLIER);
        wait.until(ExpectedConditions.elementToBeClickable(selectSubCategory));
        highlightElement(driver,selectSubCategory);
        selectSubCategory.click();

        WebElement subCategory_hint= driver.findElement(XpathConstants.SUBCATEGORY_HINT);
        subCategory_hint.sendKeys("tmt");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBCATEGORY_OPTION));
        WebElement subCategory_option= driver.findElement(XpathConstants.SUBCATEGORY_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(subCategory_option));
        highlightElement(driver,subCategory_option);
        subCategory_option.click();


        WebElement UOM= driver.findElement(XpathConstants.OPTIONS_SEARCHSUPPLIER);
        wait.until(ExpectedConditions.elementToBeClickable(UOM));
        highlightElement(driver,UOM);
        UOM.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.UOM_OPTION));
        WebElement uom_option= driver.findElement(XpathConstants.UOM_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(uom_option));
        highlightElement(driver,uom_option);
        uom_option.click();



        WebElement qty= driver.findElement(XpathConstants.BILLINGCITY_QTY);
        qty.sendKeys("100");

        WebElement purchaseUnitRate= driver.findElement(XpathConstants.PURCHASE_UNITRATE);
        purchaseUnitRate.sendKeys("900");

        WebElement saleUnitPrice= driver.findElement(XpathConstants.SALE_UNITRATE);
        saleUnitPrice.sendKeys("1000");

        WebElement totalPurchase= driver.findElements(By.xpath("//strong")).get(2);
        WebElement totalSales= driver.findElements(By.xpath("//strong")).get(3);
        WebElement profit_percent= driver.findElements(By.xpath("//strong")).get(4);

        int total_purchase= getNumericValue(totalPurchase.getText());
        int total_sale= getNumericValue(totalSales.getText());
        int profit= Integer.parseInt(profit_percent.getText().substring(0,2));

        //Assert.assertEquals(profit, ((total_sale - total_purchase)*100) / total_purchase);

        System.out.println("TotalSales: "+ totalSales.getText()+" --" + total_sale);
        System.out.println("TotalPurchase: "+ totalPurchase.getText()+" -- "+ total_purchase);
        System.out.println("Profit%: "+ profit_percent.getText()+" -- "+ profit);

        System.out.println("");

        WebElement submitBtn= driver.findElement(XpathConstants.SUBMIT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(driver,submitBtn);
        submitBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.CREATE_BTN));
        WebElement createBtn= driver.findElement(XpathConstants.CREATE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        highlightElement(driver,createBtn);
        createBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.COPY_RFQ));
        WebElement copyRFQID_Btn= driver.findElement(XpathConstants.COPY_RFQ);
        wait.until(ExpectedConditions.elementToBeClickable(copyRFQID_Btn));
        highlightElement(driver,copyRFQID_Btn);
        copyRFQID_Btn.click();



//        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ALL_ENQUIRIES_BTN));
//        WebElement allEnquiriesBtn= driver.findElement(XpathConstants.ALL_ENQUIRIES_BTN);
//        wait.until(ExpectedConditions.elementToBeClickable(allEnquiriesBtn));
//        highlightElement(driver,allEnquiriesBtn);
//        allEnquiriesBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(XpathConstants.ENQUIRIES));


        String clipBoardData= UtilityMethod.getDataFromClipBoard();
        System.out.println("-------Clipboard data is-------\n "+ clipBoardData);
        String rfqID= clipBoardData.substring(clipBoardData.indexOf("BRFQ"), clipBoardData.indexOf("BRFQ")+19);
        System.out.println("--------ClipBoard ENQUIRYID is "+ rfqID);

        Thread.sleep(1500);
        List<WebElement> enquiries= driver.findElements(XpathConstants.ENQUIRIES);


        for(WebElement enquiry:enquiries)
        {
            highlightElement(driver,enquiry);
            String title= enquiry.findElement(XpathConstants.ENQUIRY_TITLE).getText();
            System.out.println("Title is "+ title);
            //Assert.assertTrue(title.equalsIgnoreCase(organisationName),"The selected title is "+ title);

            List<WebElement> cardOptions= enquiry.findElements(XpathConstants.ENQUIRY_OPTIONS);

            WebElement enquiryID= cardOptions.get(3).findElement(By.xpath(".//a"));
            highlightElement(driver,enquiryID);
            System.out.println("EnquiryID is "+ enquiryID.getText());

            WebElement item_quantity= enquiry.findElement(XpathConstants.ITEM_QTY);
            System.out.println("Item is "+ item_quantity.getText());

            if(title.equalsIgnoreCase(organisationName) && enquiryID.getText().equalsIgnoreCase(rfqID))
            {
                EnquiryID= enquiryID.getText();
                break;
            }

        }
    }

    @Test(dependsOnMethods = "handleConfirmedEnquiry")
    public void handleCMS() throws InterruptedException, IOException {
        driver.get(prop.getProperty("stg5-cms-url"));
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.switchTo().window(mainWindow);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.DRAWER));

        WebElement drawer= driver.findElement(XpathConstants.DRAWER);
        highlightElement(driver,drawer);

        WebElement orderSection= driver.findElement(XpathConstants.RFQ_SECTION);
        wait.until(ExpectedConditions.elementToBeClickable(orderSection));
        highlightElement(driver,orderSection);
        orderSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.BUYOUT_BTN));
        WebElement buyoutBtn= driver.findElement(XpathConstants.BUYOUT_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(buyoutBtn));
        highlightElement(driver,buyoutBtn);
        buyoutBtn.click();

        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.RFQ_SUBTYPE));
        WebElement rfqSubType= driver.findElement(XpathConstants.RFQ_SUBTYPE);
        wait.until(ExpectedConditions.elementToBeClickable(rfqSubType));
        highlightElement(driver,rfqSubType);
        rfqSubType.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ALL_RFQ));
        WebElement AllRFQs= driver.findElement(XpathConstants.ALL_RFQ);
        wait.until(ExpectedConditions.elementToBeClickable(AllRFQs));
        highlightElement(driver,AllRFQs);
        AllRFQs.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_INPUT));
        WebElement searchRFQ= driver.findElement(XpathConstants.MULTIPLE_USED_INPUT);

        searchRFQ.sendKeys(EnquiryID);

        driver.findElement(XpathConstants.SEARCH_BTN).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.RFQ_LIST));
        driver.findElement(XpathConstants.RFQ_LIST).click();

        System.out.println("Before Check Box");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        WebElement checkBoxSection= driver.findElement(XpathConstants.CHECKBOX_SECTION);
        highlightElement(driver,checkBoxSection);

        System.out.println("After check Box");

        WebElement checkoption= checkBoxSection.findElement(XpathConstants.CHECKBOX_OPTION);
        highlightElement(driver,checkoption);
        checkoption.click();
        System.out.println("Check Box Clicked");

        Thread.sleep(2000);
        List<WebElement> actionButtons= driver.findElements(XpathConstants.ACTION_BTNS);
        actionButtons.get(2).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBCATEGORY_FORM));

        WebElement subcategoryForm= driver.findElement(XpathConstants.SUBCATEGORY_FORM);
        highlightElement(driver,subcategoryForm);

        List<WebElement> option= subcategoryForm.findElements(XpathConstants.SUBCATEGORY);
        WebElement baseRate= option.get(2);
        highlightElement(driver,baseRate);
        baseRate.sendKeys("100");

        WebElement freightRate= subcategoryForm.findElement(XpathConstants.FREIGHT_RATE);
        highlightElement(driver,freightRate);
        freightRate.sendKeys("100");

        WebElement loadingCharges= subcategoryForm.findElement(XpathConstants.LOADING_CHARGES);
        loadingCharges.sendKeys("50");

        List<WebElement> dropDownOptions= driver.findElements(XpathConstants.DROPDOWN_OPTIONS);
        dropDownOptions.get(2).click();

        WebElement gstOption= dropDownOptions.get(2).findElement(XpathConstants.GST_OPTION);
        highlightElement(driver,gstOption);
        gstOption.click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SAVE_BTN));
        WebElement saveBtn = driver.findElement(XpathConstants.SAVE_BTN);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        highlightElement(driver,saveBtn);
        saveBtn.click();
    }

    @Test(dependsOnMethods = "handleCMS")
    public void handleBuyerPrefs() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.BUYER_PREFS));

        WebElement buyerPrefs= driver.findElement(XpathConstants.BUYER_PREFS);
        highlightElement(driver,buyerPrefs);
        buyerPrefs.click();

        List<WebElement> buyerPrefsOptions= driver.findElements(XpathConstants.BUYER_PREFS_OPTIONS);

        WebElement preferences= buyerPrefsOptions.get(0).findElement(XpathConstants.PAYMENT_BUYERPO);
        preferences.click();

        WebElement editBtn=  buyerPrefsOptions.get(0).findElement(XpathConstants.ACTION_BTNS);
        highlightElement(driver,editBtn);
        editBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("address")));

        List<WebElement> addressesOptions= driver.findElements(XpathConstants.ADDRESS_OPTIONS);

        WebElement billingAddress= addressesOptions.get(1);
        highlightElement(driver,billingAddress);
        billingAddress.click();

//        List<WebElement> billingAddressOptions= driver.findElements(By.xpath("//div[@class=' css-1mwcg0e-option']"));
//        if(!billingAddressOptions.isEmpty())
//            billingAddressOptions.get(0).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.BILLING_ADDRESS_VALUE));
        WebElement billingAddressValue= driver.findElement(XpathConstants.BILLING_ADDRESS_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressValue));
        highlightElement(driver,billingAddressValue);
        billingAddressValue.click();


        WebElement shippingAddressBtn= addressesOptions.get(3);
        highlightElement(driver,shippingAddressBtn);
        shippingAddressBtn.click();

        List<WebElement> shippingAddressOptions= driver.findElements(XpathConstants.SHIPPING_ADDRESS_OPTION);
        if(!shippingAddressOptions.isEmpty())
            shippingAddressOptions.get(0).click();

        WebElement toleranceInput= buyerPrefsOptions.get(0).findElement(XpathConstants.TOLERANCE_POSTALCODE);
        toleranceInput.sendKeys("0");

        WebElement saveAddressBtn= buyerPrefsOptions.get(0).findElement(XpathConstants.BTN_XPATH);
        saveAddressBtn.click();



        WebElement paymentTerms=  buyerPrefsOptions.get(1);
        WebElement paymentTermsSection= paymentTerms.findElement(XpathConstants.PAYMENT_BUYERPO);
        highlightElement(driver,paymentTermsSection);
        paymentTermsSection.click();
        WebElement editBtn2= paymentTerms.findElement(XpathConstants.ACTION_BTNS);
        highlightElement(driver,editBtn2);
        editBtn2.click();

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        WebElement advanceInput= paymentTerms.findElement(XpathConstants.MULTIPLE_USED_INPUT);
        advanceInput.clear();
        advanceInput.sendKeys("100");

        WebElement saveBtn= paymentTerms.findElement(XpathConstants.SAVEBTN);
        highlightElement(driver,saveBtn);
        saveBtn.click();

        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentTermsSection);
        Thread.sleep(1500);
        highlightElement(driver,paymentTermsSection);
        paymentTermsSection.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SEND_FOR_APPROVAL));
        WebElement sendForApproval= paymentTerms.findElement(XpathConstants.SEND_FOR_APPROVAL);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sendForApproval);
        Thread.sleep(1500);

        wait.until(ExpectedConditions.elementToBeClickable(sendForApproval));

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();

        WebElement uploadPO=  buyerPrefsOptions.get(2);
        WebElement uploadBuyerPoSection= uploadPO.findElement(XpathConstants.PAYMENT_BUYERPO);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadBuyerPoSection);
        Thread.sleep(1400);
        highlightElement(driver,uploadBuyerPoSection);
        uploadBuyerPoSection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.CHECK_BOX));
        WebElement checkBox= driver.findElement(XpathConstants.CHECK_BOX);
        checkBox.click();
        System.out.println("Check Box Clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.EDITBTN));
        WebElement editBtn3= uploadPO.findElement(XpathConstants.EDITBTN);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn3));
        highlightElement(driver,editBtn3);
        editBtn3.click();

        WebElement buyerContainer= uploadPO.findElement(XpathConstants.BUYER_CONTAINER);
        WebElement PO_No= buyerContainer.findElement(XpathConstants.ADDRESS_PO_NUMBER);
        highlightElement(driver,PO_No);
        PO_No.sendKeys("12232");

        WebElement datePicker= driver.findElement(XpathConstants.DATEPICKER);
        datePicker.click();

        WebElement monthYearBtn= driver.findElement(XpathConstants.MONTH_YEAR_BTN);
        String month= monthYearBtn.getText().split(" ")[0];
        String year= monthYearBtn.getText().split(" ")[1];
        WebElement dateBtn = driver.findElement(XpathConstants.CURRDATE);
        String date= dateBtn.getText()+" "+ month+" "+year;

        WebElement dateInput= driver.findElement(XpathConstants.DATE_INPUT1);
        dateInput.sendKeys(date);

        WebElement uploadDoc= uploadPO.findElement(XpathConstants.UPLOADDOCS);
        uploadDoc.sendKeys(prop.getProperty("file-path"));

        Thread.sleep(6000);

        WebElement saveBtn2= uploadPO.findElement(XpathConstants.SAVE);
        Thread.sleep(1500);
        highlightElement(driver,saveBtn2);
        saveBtn2.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.EDIT_ENTITY));
        WebElement editEntity= driver.findElement(XpathConstants.EDIT_ENTITY);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", editEntity);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ENTITY_NAME_SECTION));
        WebElement entityNameSection= driver.findElement(XpathConstants.ENTITY_NAME_SECTION);
        highlightElement(driver,entityNameSection);
        entityNameSection.click();

        WebElement entityName= entityNameSection.findElement(XpathConstants.ADDRESS_VALUE);
        entityName.click();

        WebElement addressSection= driver.findElement(XpathConstants.ADDRESS_SECTION);
        highlightElement(driver,addressSection);
        addressSection.click();

        WebElement addressValue= addressSection.findElement(XpathConstants.ADDRESS_VALUE);
        highlightElement(driver,addressValue);
        addressValue.click();

        WebElement updateBtn= driver.findElement(XpathConstants.UPDATE_BTN);
        updateBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ITEM_SPECIFICATIONS));
        WebElement itemSpecifications= driver.findElement(XpathConstants.ITEM_SPECIFICATIONS);
        itemSpecifications.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUBMIT_QUOTE));
        WebElement submitBuyerQuote= driver.findElement(XpathConstants.SUBMIT_QUOTE);

        wait.until(ExpectedConditions.elementToBeClickable(submitBuyerQuote));
        highlightElement(driver,submitBuyerQuote);
        submitBuyerQuote.click();
    }

    @Test(dependsOnMethods = "handleBuyerPrefs")
    public void handleSupplierQuotation() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUPPLIER_QUOTE));
        WebElement supplierQuote= driver.findElement(XpathConstants.SUPPLIER_QUOTE);
        highlightElement(driver,supplierQuote);
        supplierQuote.click();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        WebElement checkBoxSection= driver.findElement(XpathConstants.CHECKBOX_SECTION);
        highlightElement(driver,checkBoxSection);

        System.out.println("After check Box");

        WebElement checkoption= checkBoxSection.findElement(XpathConstants.CHECKBOX_OPTION);
        highlightElement(driver,checkoption);
        checkoption.click();
        System.out.println("Check Box Clicked");

        WebElement addSupplier= driver.findElements(XpathConstants.BTN_XPATH).get(1);
        highlightElement(driver,addSupplier);
        addSupplier.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.OPTIONS_SEARCHSUPPLIER));
        WebElement searchSupplier= driver.findElement(XpathConstants.OPTIONS_SEARCHSUPPLIER);
        searchSupplier.click();

        WebElement supplier_hint= driver.findElement(XpathConstants.SUPPLIER_HINT);
        supplier_hint.sendKeys("abcs");

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.SUPPLIER_OPTION));
        WebElement supplierOptions= driver.findElement(XpathConstants.SUPPLIER_OPTION);
        wait.until(ExpectedConditions.elementToBeClickable(supplierOptions));
        highlightElement(driver,supplierOptions);
        supplierOptions.click();


        Thread.sleep(4000);

        List<WebElement> addressOptions= driver.findElements(XpathConstants.ROLE_ADDRESS_OPTIONS);
        System.out.println(addressOptions.size());
        WebElement pickupAddress= addressOptions.get(4);
        pickupAddress.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.PICKUP_ADDRESS_VALUE));
        WebElement pickupAddressValue= driver.findElement(XpathConstants.PICKUP_ADDRESS_VALUE);
        pickupAddressValue.click();

        WebElement billingAddress= addressOptions.get(2);
        billingAddress.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ADDRESS_VALUE));
        WebElement billingAddressvalue= driver.findElement(XpathConstants.ADDRESS_VALUE);
        billingAddressvalue.click();

        System.out.println("Done till here");
        WebElement incentiveReason= driver.findElement(XpathConstants.INCENTIVE_REASON);
        wait.until(ExpectedConditions.visibilityOf(incentiveReason));
        highlightElement(driver,incentiveReason);
        incentiveReason.click();

        WebElement incentiveReasonValue= driver.findElement(XpathConstants.INCENTIVE_REASON_VALUE);
        wait.until(ExpectedConditions.elementToBeClickable(incentiveReasonValue));
        highlightElement(driver,incentiveReasonValue);
        incentiveReasonValue.click();

        System.out.println("Done");

        List<WebElement> radioGroups= driver.findElements(XpathConstants.RADIO_GRP);

        WebElement incentiveTypes= radioGroups.get(2);
        incentiveTypes.findElement(By.xpath("//span[text()='Incoming']")).click();

        WebElement taxTypes= radioGroups.get(3);
        taxTypes.findElement(By.xpath("//span[text()='Without Tax']")).click();

        WebElement incentiveLevel= driver.findElements(XpathConstants.INCENTIVE_LEVEL).get(1);
        incentiveLevel.click();

        Thread.sleep(2500);
        WebElement nextBtn= driver.findElement(XpathConstants.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        highlightElement(driver,nextBtn);
        nextBtn.click();

        List<WebElement> subcategoryForms= driver.findElements(XpathConstants.SUBCATEGORY_FORM);
        for(WebElement subcategoryForm:subcategoryForms)
        {
            WebElement itemQty= subcategoryForm.findElement(XpathConstants.MULTIPLE_USED_INPUT);
            itemQty.clear();
            itemQty.sendKeys("100");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.MULTIPLE_USED_INPUT));
        WebElement itemQty= driver.findElement(XpathConstants.MULTIPLE_USED_INPUT);
        itemQty.clear();
        itemQty.sendKeys("100");

        WebElement baseRate= driver.findElement(XpathConstants.LANDMARK_BASERATE);
        baseRate.sendKeys("100");

        WebElement freightRate= driver.findElement(XpathConstants.MULTIPLE_INPUT_XPATH);
        freightRate.sendKeys("10");


        Thread.sleep(3000);
        WebElement dropDownOptions= driver.findElement(XpathConstants.DROPDOWN_OPTIONS);
        dropDownOptions.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.GST_OPTIONS));

        WebElement gstOption= driver.findElement(XpathConstants.GST_OPTIONS);
        highlightElement(driver,gstOption);
        gstOption.click();

        WebElement copyRatesToAll= driver.findElement(XpathConstants.COPY_BTN);
        if(copyRatesToAll.isDisplayed())
            copyRatesToAll.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.BTN_XPATH));
        WebElement saveBtn= driver.findElement(XpathConstants.BTN_XPATH);
        highlightElement(driver,saveBtn);
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.VIEW_DETAILS));
        WebElement viewDetails= driver.findElement(XpathConstants.VIEW_DETAILS);
        highlightElement(driver,viewDetails);
        viewDetails.click();

        wait.until(ExpectedConditions.elementToBeClickable(XpathConstants.APPROVAL_BTN));
        WebElement sendForApproval= driver.findElement(XpathConstants.APPROVAL_BTN);

        Thread.sleep(2000);
        highlightElement(driver,sendForApproval);
        sendForApproval.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.BTN_XPATH));
        WebElement createOrder= driver.findElement(XpathConstants.BTN_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(createOrder));
        highlightElement(driver,createOrder);
        createOrder.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(XpathConstants.LOADING));

        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathConstants.ORDER_LINK));
        WebElement orderLink= driver.findElement(XpathConstants.ORDER_LINK);
        Assert.assertNotNull(orderLink, "Order Not Created");
        highlightElement(driver, orderLink);
    }



}
