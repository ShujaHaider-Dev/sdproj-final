package com.udacity.jwdnd.course1.cloudstorage.page.tab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//TODO: Rewrite CredentialsTab
public class CredentialsTab {
    @FindBy(id = "nav-credentials-tab")
    private WebElement tab;

    @FindBy(id = "btnAddCredential")
    private WebElement add;

    @FindBy(name = "url")
    private WebElement url;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "tableCredentialUrl")
    private WebElement urlVal;

    @FindBy(id = "tableCredentialPassword")
    private WebElement usernameVal;

    @FindBy(id = "tableCredentialPassword")
    private WebElement passwordVal;

    @FindBy(name = "cedit")
    private WebElement edit;
    
    @FindBy(name = "cdel")
    private WebElement delete;

    public CredentialsTab(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCredentialsTab() {
        tab.click();
    }

    public void clickAddCredentialButton() {
        add.click();
    }


    public void setCredentialURL(String url) {
        this.url.clear();
        this.url.sendKeys(url);
    }

    public void setCredentialUsername(String username) {
        this.username.clear();
        this.username.sendKeys(username);
    }

    public void setCredentialPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        this.password.submit();
    }

    public String getCredentialURL() {
        return urlVal.getAttribute("name");
    }

    public String getCredentialUsername() {
        return usernameVal.getAttribute("name");
    }

    public String getCredentialPassword() {
        return passwordVal.getAttribute("name");
    }

    public void clickCredentialEdit() {
        edit.click();
    }

	public void clickCredentialDelete() {
		delete.click();
	}
}
