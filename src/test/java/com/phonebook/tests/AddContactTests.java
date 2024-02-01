package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;


import com.phonebook.utils.DataProviders;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
  // Предварительное условие: пользователь должен быть в системе
  @BeforeMethod
  public void ensurePrecondition() {
    // Проверяем предварительное условие перед выполнением теста
    if (!app.getUser().isLoginLinkPresent()){
      app.getUser().clickOnSignOutButton();
    }

    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegisterForm(new User()
        .setEmail("lora@gm.com")
        .setPassword("Lora1254$"));

    app.getUser().clickOnLoginButton();
  }

  @Test
  public void addContactPositiveTest() {
    // Позитивный тест на добавление контакта
    app.getContact().clickOnAddLink();

// Заполняем форму добавления контакта данными
    app.getContact().fillAddContactForm(
        new Contact()
            .setName("Lolik")
            .setLastname( "Lolovic")
            .setPhone( "1234567890")
            .setEmail( "adam@gm.com")
            .setAddress( "Koblenz")
            .setDescription( "goalkeeper"));

    // Нажимаем кнопку "Save"
    app.getContact().clickOnSaveButton();

    // Проверяем, что контакт был создан по имени
    Assert.assertTrue(app.getContact().isContactCreatedByText("Lolik"));
  }

  @AfterMethod
  public void postCondition() {
    //  удаляем созданный контакт
    app.getContact().removeContact();
  }



  @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
  public void addContactPositiveFromDataProviderTest(String name, String surname, String phone, String email, String address, String desc) {

    app.getContact().clickOnAddLink();


    app.getContact().fillAddContactForm(
        new Contact()
            .setName(name)
            .setLastname( surname)
            .setPhone( phone)
            .setEmail( email)
            .setAddress( address)
            .setDescription( desc));
    app.getContact().clickOnSaveButton();


    Assert.assertTrue(app.getContact().isContactCreatedByText("Lolik"));
  }

  @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class)
  public void addContactPositiveFromDataProviderWithCSVTest(Contact contact) {

    app.getContact().clickOnAddLink();


    app.getContact().fillAddContactForm(contact);
    app.getContact().clickOnSaveButton();
  Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getName()));


  }


}

