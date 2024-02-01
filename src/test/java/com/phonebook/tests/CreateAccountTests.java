package com.phonebook.tests;


import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {


  @BeforeMethod
  public void ensurePrecondition() {// проверяется, присутствует ли ссылка на вход.
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void registerExistedUserNegativeTest() {

    app.getUser().clickOnLoginLink();//  // Переходим на страницу входа
    // Заполняем форму регистрации данными существующего пользователя
    app.getUser().fillLoginRegisterForm(new User()
        .setEmail("lora@gm.com")
      .setPassword( "Lora1254$"));

    app.getUser().clickOnRegisterButton();

    Assert.assertTrue(app.getUser().isAlertAppears());
  }

}
//Этот класс представляет собой тестирование регистрации существующего пользователя
// с отрицательным сценарием, ожидая, что при попытке регистрации с уже существующими
// данными появится предупреждение.