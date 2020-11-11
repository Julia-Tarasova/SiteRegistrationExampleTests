package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalInfoRegistrationPage {

    public WebDriver driver;
    //Constructor
    public PersonalInfoRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'customer_firstname')]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[contains(@id, 'customer_lastname')]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[contains(@id, 'passwd')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[contains(@id, 'address1')]")
    private WebElement addressInput;

    @FindBy(xpath = "//*[contains(@id, 'city')]")
    private WebElement cityInput;

    @FindBy(xpath = "//*[contains(@id, 'id_state')]")
    private WebElement stateInput;

    @FindBy(xpath = "//*[contains(@id, 'postcode')]")
    private WebElement zipInput;

    @FindBy(xpath = "//*[contains(@id, 'phone_mobile')]")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[contains(@id, 'submitAccount')]")
    private WebElement registerButton;

    public String getErrorText() {
        return driver.findElement(By.xpath("//*[contains(@class, 'alert alert-danger')]//b")).getText();
    }

    public void setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void setAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void setCity(String city) {
        cityInput.sendKeys(city);
    }

    public void setState(String state) {
        stateInput.click();
        By option = By.xpath("//option[contains(text(),'"+ state + "')]");
        driver.findElement(option).click();
    }

    public void setZip(String zip) {
        zipInput.sendKeys(zip);
    }

    public void setPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void registrationButtonClick() {
        registerButton.click();
    }
}
