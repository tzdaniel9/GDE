package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class LearnerRegistrationPage {
    LearnerRegistrationPage learnerRegistrationPage;
    By RegisterLearner = By.xpath("//button[@text='Sign In']");
    By NonSaCitizenLearner = By.xpath("//span[contains(text(),'Non South African Citizen')]");
//    By NonSaCitizenLearner = By.id("learner-reg-nonSaCitizen");
    By SaCitizen = By.xpath("//span[starts-with(text(),'South African Citizen')]");
//    By SaCitizen = By.id("parent-reg-step1-saCitizen");
    By DocumentStatusUndocumented = By.xpath("//span[contains(text(),'Undocumented')]");
//    By DocumentStatusUndocumented = By.id("parent-reg-step1-notDocumented");
    By LearnerDocumentStatusDocumented = By.xpath("//span[contains(text(),'Documented')]");
//    By LearnerDocumentStatusDocumented = By.id("learner-reg-documented");
    By clickCountryOfOriginOfLearner = By.xpath("//div[contains(text(),'Select a Country of Origin')]");//ToDo
    By selectClickCountryOfOriginLearner = By.xpath("//li[contains(text(),'Afghanistan')]");//ToDo
    By IAmInTheCountryForStudy = By.xpath("//span[contains(text(),'Study')]");
//    By IAmInTheCountryForStudy = By.id("learner-reg-studyReason");
    By LearnerName = By.name("firstName");
//    By LearnerName = By.id("learner-reg-firstName");
    By LearnerSurname = By.name("lastName");
//    By LearnerSurname = By.id("learner-reg-lastName");
    By GenderMaleLearner = By.xpath("//span[contains(text(),'Male')]");
//    By GenderMaleLearner = By.id("learner-reg-male");
    By emailAddress = By.name("emailAddress");
    By CellphoneNumber = By.id("parent-reg-step1-mobileNumber");
    By GenderFemale = By.xpath("//span[contains(text(),'Female')]");
//    By GenderFemale = By.id("parent-reg-step1-female");
    By Password = By.xpath("//input[@placeholder='Password']");
    By ConfirmPassword = By.xpath("//input[@placeholder='Repeat password']");
    By NextStepButton = By.id("parent-reg-step1-submitButton");
    By AcceptTermsAndConditionsCheckBox = By.xpath("//input[@type='checkbox']");
    By ButtonOK = By.cssSelector(".gde-terms-modal .gde-modal-ok-button");
    By EnterYourOTP = By.id("rcDialogTitle0");
    By confirmOTPButton = By.cssSelector("button.ant-btn:nth-child(2)");
    By PassportNumberLearner = By.name("passportNumber");
//    By PassportNumberLearner = By.id("learner-reg-passportNumber");
//    By clickDateOfBirthLearner = By.id("learner-reg-dateOfBirth");
    By clickDateOfBirthLearner = By.cssSelector("[class='ant-calendar-picker-input ant-input']");
    By clickPreviousYears = By.cssSelector(".ant-calendar-header a[role='button']");
    By DateOfBirthLearner = By.cssSelector("ant-calendar-picker-input");
    By workPermitImmigrationStatus = By.id("parent-reg-step1-workPermit");
    By countryOfOrigin = By.cssSelector(".ant-select-selection__placeholder");
    By NextStep = By.id("parent-reg-step1-submitButton");
    By PleaseConfirmYourOTP = By.xpath("//input[@placeholder='Enter Your OTP Number']");
    By OkButtonOnOTP = By.cssSelector("button.ant-btn:nth-child(2)");
    By IDNumber = By.id("parent-reg-step1-citizenIdNumber");
    By DHAyesValidation = By.cssSelector("button.ant-btn:nth-child(2)");
    By HomeAddress = By.id("parent-reg-step2-searchInput");//ToDo
    By clickFirstItemOnListHomeAddress = By.cssSelector(".gde-auto-complete-places-suggestions:nth-child(1)");//ToDo
    By clickFirstItemOnList = By.cssSelector(".gde-auto-complete-places-suggestions:nth-child(1)");//ToDo
    By clickFirstItemOnTreeList = By.cssSelector("li.ant-tree-treenode-switcher-close:nth-child(1)");//ToDo
    By SubmitButtonAddress = By.id("parent-reg-step2-submitButton");
    By IntentToApplyCloseToWork = By.id("parent-reg-step2-isNotRegNearWork");
    By HomeLanguage = By.xpath("//div[contains(text(),'Select a Home Language')]");
    By clickHomeLanguage = By.xpath("//li[contains(text(),'English')]");
    By clickRace = By.xpath("//div[contains(text(),'Select a Race')]");
    By ethnicity = By.xpath("//li[contains(text(),'White')]");
    By grade8 = By.xpath("//span[contains(text(),'Grade 8')]");
//    By grade8 = By.id("learner-reg-grade8");
    By grade1 = By.xpath("//span[contains(text(),'Grade 1')]");
//    By grade1 = By.id("learner-reg-grade1");
    By preferedLanguageOfTeaching = By.xpath("//div[contains(text(),'Select Preferred Language of Teaching')]");
    By languageOfTeaching = By.cssSelector(".learner-reg-preferredLanguage-1");
    By IsInstitutionInGauteng = By.xpath("//span[contains(text(),'Yes')]");
//    By IsInstitutionInGauteng = By.id("learner-reg-isSchoolGauteng");
    By SchoolIsPublic = By.xpath("//span[contains(text(),'Public')]");
//    By SchoolIsPublic = By.id("learner-reg-isSchoolPublic");
    By SchoolIsPrivate = By.xpath("//span[contains(text(),'Private')]");
//    By SchoolIsPrivate = By.id("learner-reg-isNotSchoolPublic");
    By ApplyToSchools = By.cssSelector("[text ='Apply to Schools']");
//    By ApplyToSchools = By.id("learner-reg-submitButton");
    By ApplicationOption = By.xpath("//div[contains(text(),'Home Address Within Schools Feeder Zone')]");
    By HomeFeederZoneApplicationOption = By.xpath("//li[contains(text(),'Home Address Within Schools Feeder Zone')]");
    By SiblingOrPreviousSchoolOption = By.xpath("//li[contains(text(),'Sibling/Previous School')]");
    By WorkAddressWithinSchoolsFeederZone = By.xpath("//li[contains(text(),'Work Address Within Schools Feeder Zone')]");
    By HomeAddressWithin30km = By.xpath("//li[contains(text(),'Home Address Within 30km')]");
    By SchoolsOfSpecializationOrFocusSchools = By.xpath("//li[contains(text(),'Schools Of Specialization/Focus Schools')]");
    By HomeAddressBeyond30km = By.xpath("//li[contains(text(),'Home Address Beyond 30km')]");
    By SchoolName = By.cssSelector("[placeholder='Search School Name']");
//    By SchoolName = By.id("learner-application-searchSchoolName");
    By SchoolSearchResultsTitle = By.xpath("//div[contains(text(),'School Search Result(s)')]"); //get text of search results
    By selectSchoolsToApply = By.cssSelector("ant-checkbox-input");
    By monthOfBirth = By.cssSelector(".ant-calendar-body td");
    By submitApplications = By.cssSelector("[text='Submit Applications']");
//    By submitApplications = By.id("learner-application-submitApplications");
    By ApplyToMoreSchools = By.xpath("//span[contains(text(),'Apply to More Schools')]");
    By ContinueToDocuments = By.cssSelector(".gde-app-success-upload-documents-button");
//    By ContinueToDocuments = By.xpath("//span[contains(text(),'Continue to Documents')]");
    //    By SchoolSearchResultsCheck = By.cssSelector("gde-school-result-details-col-2");
    By SchoolSearchResultsCheck = By.cssSelector(".gde-school-results .gde-school-result:nth-child(1) .ant-checkbox-input");
    By DHAOkValidation = By.cssSelector(".gde-modal-ok-button");
    By DHACancelValidation = By.cssSelector(".gde-modal-ok-button");
    By AsylumSeeker = By.id("learner-reg-asylumSeekerReason");
    By Refugee = By.id("learner-reg-refugeeReason");
    By RefugeNumber = By.id("learner-reg-refugeeNumber");
    By IsLeanerInGradeRorAnEarlyChildhoodDevelopmentProgram = By.id("learner-reg-isGradeR");
    By SuburbOrTownship = By.cssSelector("[placeholder='Suburb/Township']");
    By SiblingName = By.id("learner-application-siblingName");
    By SiblingSurname = By.id("learner-application-siblingSurname");
    By SiblingGrade = By.id("learner-application-siblingGrade");
    By SiblingSchool = By.id("learner-application-siblingSchool");
    By LearnerApplicationApply = By.id("learner-application-applyButton");
    By ApplyBtnOnLearnerApplication = By.id("learner-application-applyButton");
    By ApplyToMoreSchoolsButton = By.cssSelector("gde-app-success-apply-to-more-schools-button");
//    By CurrentSchool = By //ToDo
    //.gde-school-results .gde-school-result:nth-child(1) .ant-checkbox-input
    By YouCanOnlyApplyTo1SchoolsAtATimeForThisApplicationOption = By.cssSelector(".ant-message > span > :nth-child(1)");


    private WebDriver driver;

    public LearnerRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public LearnerRegistrationPage() {
    }

    public Boolean youCanOnlyApplyTo1SchoolsAtATimeForThisApplicationOption(){
        if (!driver.findElement(YouCanOnlyApplyTo1SchoolsAtATimeForThisApplicationOption).isDisplayed()){
            return false;
        }else {
            return true;
        }

    }

    public void currentSchool(String schoolCurrent) throws InterruptedException {
//        driver.findElement(CurrentSchool).sendKeys(schoolCurrent); //ToDo
        Thread.sleep(500);
        driver.findElement(clickFirstItemOnList).click();
    }


    public LearnerRegistrationPage applyToMoreSchoolsBtn() {
        driver.findElement(ApplyToMoreSchoolsButton).click();
        return new LearnerRegistrationPage(driver);
    }


    public void siblingName(String name) {
        driver.findElement(SiblingName).sendKeys(name);
    }

    public void applyBtnOnLearnerApplication() {
        driver.findElement(ApplyBtnOnLearnerApplication).click();
    }

    public void siblingSurname(String surname) {
        driver.findElement(SiblingSurname).sendKeys(surname);
    }

    public void siblingGrade(String grade) {
        driver.findElement(SiblingGrade).sendKeys(grade);
    }

    public void siblingSchool(String school) throws InterruptedException {
        driver.findElement(SiblingSchool).sendKeys(school);
        Thread.sleep(500);
        driver.findElement(clickFirstItemOnTreeList).click();
    }

    public void learnerApplicationApply() {
        driver.findElement(LearnerApplicationApply).click();
    }

    public void suburbOrTownship(String area) throws InterruptedException {
        driver.findElement(SuburbOrTownship).sendKeys(area);
        Thread.sleep(500);
        driver.findElement(clickFirstItemOnList).click();
    }

    public void isLeanerInGradeRorAnEarlyChildhoodDevelopmentProgram() {
        driver.findElement(IsLeanerInGradeRorAnEarlyChildhoodDevelopmentProgram).click();
    }

    public void dhaOkValidation() {
        driver.findElement(DHAOkValidation);
    }

    public void dhaCancelValidation() {
        driver.findElement(DHACancelValidation).click();
    }

    public void asylumSeeker() {
        driver.findElement(AsylumSeeker).click();
    }

    public void refugee() {
        driver.findElement(Refugee).click();
    }

    public void refugeeNumber(String refugeeNum) {
        driver.findElement(RefugeNumber).sendKeys(refugeeNum);
    }


    //    public boolean validateGdeLogo(){
//        driver.findElement("");
//    }

//    public void HomeAddressWithSchoolsFeederZone(){
//        driver.findElement(applicationOption();)
//    }

    public DocumentsPage continueToDocuments() {
        driver.findElement(ContinueToDocuments).click();
        return new DocumentsPage(driver);
    }

    public void schoolSearchResults() {

        driver.findElement(SchoolSearchResultsCheck).click();
//        WebElement element = driver.findElement(SchoolSearchResultsCheck);
//       while (element != null){
//           element.click();
//       }
//        for (int i =0; i < 3;i++){
//            element.click();
//        }
    }

    public void applyToMoreSchools() {
        driver.findElement(ApplyToMoreSchools).click();
    }


    public void previousYears() {
        WebElement element = driver.findElement(clickPreviousYears);
        for (int i = 0; i < 11; i++) {
            element.click();
        }
        driver.findElement(monthOfBirth).click();
    }

    public void SubmitApplications() {
        driver.findElement(submitApplications).click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    public void inTheCountryForStudy() {
        driver.findElement(IAmInTheCountryForStudy).click();
    }

    public void selectSchoolsToApplyTo() {
        driver.findElement(selectSchoolsToApply).click();
    }

    public void institutionName(String institutionName) {
        driver.findElement(SchoolName).sendKeys(institutionName);
    }

    public void applicationOptionFeederZone() {
        driver.findElement(ApplicationOption).click();
        driver.findElement(HomeFeederZoneApplicationOption).click();
    }

    public void siblingOrPreviousSchoolApplicationOption() {
        driver.findElement(ApplicationOption).click();
        driver.findElement(SiblingOrPreviousSchoolOption).click();//SiblingOrPreviousSchoolOption
    }

    public void workAddressWithinSchoolsFeederZone() {
        driver.findElement(ApplicationOption).click();
        driver.findElement(WorkAddressWithinSchoolsFeederZone).click();//SiblingOrPreviousSchoolOption
    }

    public void schoolsOfSpecializationOrFocusSchools() {
        driver.findElement(ApplicationOption).click();
        driver.findElement(SchoolsOfSpecializationOrFocusSchools).click();//SiblingOrPreviousSchoolOption
    }

    public void homeAddressWithin30km() {
        driver.findElement(ApplicationOption).click();
        driver.findElement(HomeAddressWithin30km).click();//SiblingOrPreviousSchoolOption
    }


    public void applyToSchools() {
        driver.findElement(ApplyToSchools).click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    public void schoolIsPrivate() {
        driver.findElement(SchoolIsPrivate).click();
    }

    public void schoolIsPublic() {
        driver.findElement(SchoolIsPublic).click();
    }

    public void isTheInstitutionInGauteng() {
        driver.findElement(IsInstitutionInGauteng).click();
    }


    public void PreferredLanguageOfTeaching(String teachingLanguage) throws InterruptedException {
        driver.findElement(preferedLanguageOfTeaching).click();
        Thread.sleep(1000);
        driver.findElement(languageOfTeaching).click();
    }

    public void Grade8() {
        driver.findElement(grade8).click();
    }

    public void Grade1() {
        driver.findElement(grade1).click();
    }

    public void Race() {
        driver.findElement(clickRace).click();
        driver.findElement(ethnicity).click();
    }

    public void homeLanguage() {
        driver.findElement(HomeLanguage).click();
        driver.findElement(clickHomeLanguage).click();
    }

    public void intentToApplyCloseToWork() {
        driver.findElement(IntentToApplyCloseToWork).click();
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
        driver.findElement(clickCountryOfOriginOfLearner).click();
        driver.findElement(selectClickCountryOfOriginLearner).click();
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
        driver.findElement(LearnerDocumentStatusDocumented).click();
    }

    public void dateOfBirth(String dob) {
        driver.findElement(DateOfBirthLearner).click();
//        driver.findElement(DateOfBirthLearner).sendKeys(dob);

    }

    public void clickDOB() {
        driver.findElement(clickDateOfBirthLearner).click();
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
        driver.findElement(NonSaCitizenLearner).click();
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
        driver.findElement(PassportNumberLearner).sendKeys(passportNumber);
    }
//
//    public void DateOfBirth(String dob) {
//        DateOfBirth.sendKeys(dob);
//
//    }

    public void Name(String name) {
        driver.findElement(LearnerName).sendKeys(name);
    }

    public void Surname(String surname) {
        driver.findElement(LearnerSurname).sendKeys(surname);
    }

    public void GenderMale() {
        driver.findElement(GenderMaleLearner).click();
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


    public void registerLearner() {
        driver.findElement(RegisterLearner).click();
    }

}
