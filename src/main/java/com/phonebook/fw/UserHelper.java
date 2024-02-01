package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{//Класс UserHelper представляет собой вспомогательный класс для взаимодействия с элементами пользовательского интерфейса,
  // связанными с пользователями
  public UserHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnSignOutButton() {
    click(By.xpath("//button[.='Sign Out']"));
  }//Нажимает на кнопку "Sign Out" с использованием XPath-селектора

  public boolean isLoginLinkPresent() {// Проверяет наличие ссылки на вход на странице,
    return isElementPresent(By.cssSelector("[href='/login']"));
  }

  public void clickOnRegisterButton() {
    click(By.name("registration"));
  } // Нажимает на кнопку с именем "registration".

  public void fillLoginRegisterForm(User user) {//Заполняет форму входа/регистрации,
    type(By.name("email"), user.getEmail());
    type(By.name("password"), user.getPassword());
  }

  public void clickOnLoginLink() {
    click(By.cssSelector("[href='/login']"));
  }//Нажимает на ссылку "Login" с использованием CSS-селектора.

  public boolean isSignOutButtonPresent() {
    return isElementPresent(By.xpath("//button[.='Sign Out']"));//Проверяет наличие кнопки "Sign Out" на странице
  }

  public void clickOnLoginButton() {
    click(By.name("login"));
  }//Нажимает на кнопку с именем "login".
}
//Этот класс предоставляет методы для выполнения действий,
// связанных с пользователями на веб-странице,
// таких как вход, выход, проверка наличия элементов и заполнение форм.