package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase{


  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()){
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void loginPositiveTest() {// // Позитивный тест на вход в систему
    // Переходим на страницу входа
    app.getUser().clickOnLoginLink();

    // Заполняем форму входа данными пользователя
    app.getUser().fillLoginRegisterForm(new User()
        .setEmail("lora@gm.com")
        .setPassword("Lora1254$"));

    // Нажимаем кнопку "Login"
    app.getUser().clickOnLoginButton();
    // Проверяем, что кнопка выхода из системы присутствует, что может служить индикатором успешного входа
    Assert.assertTrue(app.getUser().isSignOutButtonPresent());
  }

  @Test
  public void loginNegativeTestWithoutEmail() {// // Негативный тест на вход в систему без указания email
    // Переходим на страницу входа
    app.getUser().clickOnLoginLink();

// Заполняем форму входа без указания email
    app.getUser().fillLoginRegisterForm(new User()
        .setPassword("Lora1254$"));

    // Нажимаем кнопку "Login"
    app.getUser().clickOnLoginButton();
    // Проверяем, что появляется предупреждение (alert), что может указывать на неуспешную попытку входа
    Assert.assertTrue(app.getUser().isAlertAppears());
  }


}