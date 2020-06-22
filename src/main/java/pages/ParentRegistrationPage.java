package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

public class ParentRegistrationPage {


    By NonSaCitizen = By.id("parent-reg-step1-noSaCitizen");
    By SaCitizen = By.id("parent-reg-step1-saCitizen");
    By DocumentStatusUndocumented = By.id("parent-reg-step1-notDocumented");
    By DocumentStatusDocumented = By.id("parent-reg-step1-documented");
    By clickCountryOfOrigin = By.cssSelector(".ant-select-selection__placeholder");//ToDo
    By selectClickCountryOfOrigin = By.cssSelector("li.ant-select-dropdown-menu-item:nth-child(1)");//ToDo
    By Name = By.name("firstName");
    By Surname = By.name("lastName");
    By GenderMale = By.id("parent-reg-step1-male");
    By emailAddress = By.name("emailAddress");
    By CellphoneNumber = By.id("parent-reg-step1-mobileNumber");
    By GenderFemale = By.id("parent-reg-step1-female");
    By Password = By.xpath("//input[@placeholder='Password']");
    By ConfirmPassword = By.xpath("//input[@placeholder='Repeat password']");
    By NextStepButton = By.id("parent-reg-step1-submitButton");
    By AcceptTermsAndConditionsCheckBox = By.xpath("//input[@type='checkbox']");
    By ButtonOK = By.cssSelector(".gde-terms-modal .gde-modal-ok-button");
    By EnterYourOTP = By.id("rcDialogTitle0");
    By confirmOTPButton = By.cssSelector("button.ant-btn:nth-child(2)");
    By PassportNumber = By.id("parent-reg-step1-passportNumber");
    By DateOfBirth = By.className("ant-calendar-picker-input ant-input");
    By workPermitImmigrationStatus = By.id("parent-reg-step1-workPermit");
    By countryOfOrigin = By.cssSelector(".ant-select-selection__placeholder");
    By NextStep = By.id("parent-reg-step1-submitButton");
    By PleaseConfirmYourOTP = By.xpath("//input[@placeholder='Enter Your OTP Number']");
    By OkButtonOnOTP = By.cssSelector("button.ant-btn:nth-child(2)");
    By IDNumber = By.id("parent-reg-step1-citizenIdNumber");
    By DHAyesValidation = By.cssSelector("button.ant-btn:nth-child(2)");
    By HomeAddress = By.id("parent-reg-step2-searchInput");//ToDo
    By clickFirstItemOnListHomeAddress = By.cssSelector(".gde-auto-complete-places-suggestions:nth-child(1)");//ToDo
    By SubmitButtonAddress = By.id("parent-reg-step2-submitButton");
    By NonIntentToApplyCloseToWork = By.id("parent-reg-step2-isNotRegNearWork");
    By AsylumSeekerImmigrationStatus = By.id("parent-reg-step1-asylumSeeker");
    By IntentToApplyToWork = By.id("parent-reg-step2-isRegNearWork");
    By AsylumSeekerNumber = By.id("parent-reg-step1-asylumSeekerNumber");
    By searchForWorkAddress = By.id("parent-reg-step2-searchInput");
    By clickFirstItemListOnWorkAddressList = By.cssSelector(".gde-auto-complete-places-suggestions:nth-child(1)");







    private WebDriver driver;


    public ParentRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


//    public boolean validateGdeLogo(){
//        driver.findElement("");
//    }

    public void asylumSeekerImmigrationStatus() {
        driver.findElement(AsylumSeekerImmigrationStatus).click();
    }

    public void searchForWorkAddress(String workAddress) throws InterruptedException {
        driver.findElement(searchForWorkAddress).sendKeys(workAddress);
        Thread.sleep(500);
        driver.findElement(clickFirstItemListOnWorkAddressList).click();
    }

    public void asylumSeekerNumber(String numberAsylum) {
        driver.findElement(AsylumSeekerNumber).sendKeys(numberAsylum);
    }

    public void NonIntentToApplyCloseToWork() {
        driver.findElement(NonIntentToApplyCloseToWork).click();
    }

    public void intentToApplyCloseToWork() {
        driver.findElement(IntentToApplyToWork).click();
    }

    public void searchForHomeAddress(String AddressHome) throws InterruptedException {
        driver.findElement(HomeAddress).sendKeys(AddressHome);
        Thread.sleep(2000);
        driver.findElement(clickFirstItemOnListHomeAddress).click();
    }

    public void submitAddress() {
        driver.findElement(SubmitButtonAddress).click();
    }

    public LearnerRegistrationPage submitWorkAddress() {
        driver.findElement(SubmitButtonAddress).click();
        return new LearnerRegistrationPage(driver);
    }


    public void unDocumented() {
        driver.findElement(DocumentStatusUndocumented).click();
    }

    public void insertYourOTP(String OTPpin) {
        driver.findElement(PleaseConfirmYourOTP).sendKeys(OTPpin);
    }

    public void okButtonOTP() {
        driver.findElement(OkButtonOnOTP).click();
    }

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement() {
        return new Select(driver.findElement(countryOfOrigin));
    }

    public void CountryOfOrigin() {
        driver.findElement(clickCountryOfOrigin).click();
        driver.findElement(selectClickCountryOfOrigin).click();
    }

    public void nextButton() {
        driver.findElement(NextStep).click();
    }

    public void pleaseConfirmYourOTP(int otp) {
        driver.findElement(EnterYourOTP).sendKeys("otp");
    }

//    public void xValidationBtnDHA(){
//        XValidationDHA.click();
//    }

    public void yesBtnValidationDHA() {
        driver.findElement(DHAyesValidation).click();
    }

    //    public void noBtnValidationDHA(){
//        DHAnoValidation.click();
//    }
    public void SouthAfricanCitizen() {
        driver.findElement(SaCitizen).click();
    }

    public void idNumber(String idNumber) {
        driver.findElement(IDNumber).sendKeys(idNumber);
    }


    public void confirmOkButtonOnOTP() {
        driver.findElement(confirmOTPButton).click();
    }

//    public void ButtonOnOTP() {
//        XButtonOnOTPModal.click();
//    }

//    public void cancelOTPButton() {
//        cancelOTP.click();
//    }

//    public void NonIntentToApplyToSchoolsCloseToYourPlaceOfWork() {
//        NonIntentToApplyToSchoolsCloseToYourPlaceOfWork.click();
//    }

    public void DocumentStatusDocumented() {
        driver.findElement(DocumentStatusDocumented).click();
    }

    public void dateOfBirth(String dob) {
        driver.findElement(DateOfBirth).sendKeys(dob);

    }

//    public void IntentToApplyToSchoolsCloseToYourPlaceOfWork() {
//        IntentToApplyToSchoolsCloseToYourPlaceOfWork.click();
//    }
//
//    public void AddressDetails() {
//        AddressDetails.click();
//    }
//
//    public WebElement goBackToSearchButton() {  //ToDo Continue with other elements
//        GoBackToSearchButton.click();
//        return AddressDetails;
//    }

//    public void CantFindYourHomeAddressClickHere() {
//        cantFindYourHomeAddressClickHere.click();
//    }
//
//    public void SubmitAtHomeAnnWorkAddress() {
//        Submit.click();
//    }
//
//    public void elementAtFirstPositionInHomeAndWorkAddress() {
//
//        elementAtFirstPosition.get(1).click();
//    }
//
//    public void SearchForTheHomeAddress() {
//        SearchForTheHomeAddress.sendKeys("");  //ToDo
//    }


    public void NationalityNonSouthAfricanCitizen() {
        driver.findElement(NonSaCitizen).click();
    }


//    public void DocumentStatusUndocumented() {
//        DocumentStatusUndocumented.click();
//    }
//
//    public void clickCountryOfOrigin() { //ToDo Select By Index
//        CountryOfOriginClick.click();
//    }

//    public void CountryOfOrigin() { //ToDo Select By Index
//        driver.findElement(CountryOfOrigin).click();
//    }

    public void ImmigrationStatus() {
        driver.findElement(workPermitImmigrationStatus).click();
    }

    public void PassportNumber(String passportNumber) {
        driver.findElement(PassportNumber).sendKeys(passportNumber);
    }
//
//    public void DateOfBirth(String dob) {
//        DateOfBirth.sendKeys(dob);
//
//    }

    public void Name(String name) {
        driver.findElement(Name).sendKeys(name);
    }

    public void Surname(String surname) {
        driver.findElement(Surname).sendKeys(surname);
    }

    public void GenderMale() {
        driver.findElement(GenderMale).click();
    }

    public void GenderFemale() {
        driver.findElement(GenderFemale).click();
    }

    public void CellphoneNumber(String phoneNumber) {
        driver.findElement(CellphoneNumber).sendKeys(phoneNumber);
    }

    public void emailAddress() {
        driver.findElement(emailAddress).sendKeys("");
    }

    public void password(String password) {

        driver.findElement(Password).sendKeys(password);
    }

    public void ConfirmPassword(String confirmPassword) {
        driver.findElement(ConfirmPassword).sendKeys(confirmPassword);
    }

    public void NextStepButton() {
        driver.findElement(NextStepButton).click();
    }

    public void AcceptTermsAndConditionsCheckBox() {
        driver.findElement(AcceptTermsAndConditionsCheckBox).click();
    }

    public void ButtonOK() {
        driver.findElement(ButtonOK).click();
    }
//
//    public ParentRegistration BackButton() {
//        BackButton.click();
//        return new ParentRegistration(driver);
//    }
}
