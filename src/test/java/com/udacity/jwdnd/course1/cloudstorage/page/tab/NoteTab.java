
package com.udacity.jwdnd.course1.cloudstorage.page.tab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NoteTab {
    @FindBy(name = "nedit")
    private WebElement noteEditButton;

    @FindBy(name = "ndel")
    private WebElement noteDeleteButton;

    @FindBy(id = "noteTitle")
    private WebElement noteTitle;

    @FindBy(id = "noteDescription")
    private WebElement noteDescription;

    @FindBy(id = "addNoteButton")
    private WebElement addNoteButton;

    @FindBy(id = "note-title")
    private WebElement noteTitleValue;

    @FindBy(id = "note-description")
    private WebElement noteDescriptionValue;

    @FindBy(id = "nav-notes-tab")
    private WebElement notesTab;

    public NoteTab(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickNotesTab() {
        notesTab.click();
    }

    public void setNoteTitle(String title) {
        noteTitleValue.clear();
        noteTitleValue.sendKeys(title);
    }

    public void setNoteDescription(String description) {
        noteDescriptionValue.clear();
        noteDescriptionValue.sendKeys(description);
        noteDescriptionValue.submit();
    }

    public void clickAddNoteButton() {
        addNoteButton.click();
    }

    public String getNoteTitle() {
        return noteTitle.getAttribute("name");
    }

    public String getNoteDescription() {
        return noteDescription.getAttribute("name");
    }

    public void clickNoteEdit() {
        noteEditButton.click();
    }

    public void clickNoteDelete() {
        noteDeleteButton.click();
    }

}