package com.automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "message")
    WebElement messageInputField;
    @FindBy(id = "id_contact")
    WebElement subjectHeadingDrop;
    @FindBy(id = "email")
    WebElement emailInputField;
    @FindBy(name = "id_order")
    WebElement orderReferenceDrop;
    @FindBy(name = "id_order")
    WebElement orderReferenceInput;
    @FindBy(name = "id_product")
    WebElement productDrop;
    @FindBy(id = "fileUpload")
    WebElement attachFile;
    @FindBy(id = "submitMessage")
    WebElement sendBtn;
    @FindBy(css = "#center_column > div > ol > li")
    WebElement errorMessage;

    public void fillContact(String msg, String subjectHeading, String mail, String orderText, int indexForOrderReference, int indexForProduct, String filePath) {
        if (!msg.isEmpty())
           fillText(messageInputField, msg);
        if (!subjectHeading.isEmpty())
           selectByText(subjectHeadingDrop, subjectHeading);
        if (!mail.isEmpty())
            fillText(emailInputField, mail);
        fillOrderReferenceField(orderText, indexForOrderReference,indexForProduct);
        try {
            fillText(attachFile, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        click(sendBtn);
    }

    public boolean isValidErrorMsg (String expectedMsg){
       String actualMessage = getText(errorMessage);
       if (actualMessage.contains(expectedMsg))
           return true;
       else
           return false;
    }

    public void fillOrderReferenceField(String orderText , int orderIndex, int productIndex){
        String tagName = driver.findElement(By.name("id_order")).getTagName();
        if (tagName.contains("select")) {
            selectByIndex(orderReferenceDrop, orderIndex);
            if (orderIndex==1)
                selectByIndex(productDrop, 1);
        }
        else
            fillText(orderReferenceInput,orderText);
    }

}
