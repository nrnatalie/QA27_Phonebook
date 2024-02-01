package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
  // Предварительное условие: пользователь должен быть в системе и создан контакт
  @BeforeMethod
  public void ensurePrecondition() {// проверяется, присутствует ли ссылка на вход
    if (!app.getUser().isLoginLinkPresent()){
      app.getUser().clickOnSignOutButton();
    }

    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginRegisterForm(new User()
        .setEmail("lora@gm.com")
       .setPassword("Lora1254$"));
    app.getUser().clickOnLoginButton();

    // Создаем контакт
    app.getContact().clickOnAddLink();
    app.getContact().fillAddContactForm(
        new Contact()
            .setName("Lolik")
            .setLastname( "Lolovic")
            .setPhone( "1234567890")
            .setEmail( "adam@gm.com")
            .setAddress( "Koblenz")
            .setDescription( "goalkeeper"));
    app.getContact().clickOnSaveButton();
  }

  private void setPassword(String Lora1254$) {
  }

  @Test
  public void removeContactPositiveTest() {
    // Позитивный тест на удаление контакта

    // Получаем количество контактов перед удалением
    int sizeBefore = app.getContact().sizeOfContacts();

    // Удаляем контакт
    app.getContact().removeContact();
    app.getContact().pause(1000);//Ждем некоторое время (1000

    // Получаем количество контактов после удаления
    int sizeAfter = app.getContact().sizeOfContacts();

    // Проверяем, что количество контактов уменьшилось на 1
    Assert.assertEquals(sizeAfter,sizeBefore-1);
  }

}