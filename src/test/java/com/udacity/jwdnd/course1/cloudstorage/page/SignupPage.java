package com.udacity.jwdnd.course1.cloudstorage.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    @FindBy(id = "succ")
    private WebElement successElement;

    @FindBy(name = "firstName")
    private WebElement inputFirstName;

    @FindBy(name = "lastName")
    private WebElement inputLastName;

    @FindBy(name = "username")
    private WebElement inputUsername;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(name = "submit")
    private WebElement submit;

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void signUp(String firstname, String lastname, String username, String password) {
        inputFirstName.sendKeys(firstname);
        inputLastName.sendKeys(lastname);
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        submit.click();
    }

    public String getSuccessMessage() {
        return successElement.getText();
    }
}
