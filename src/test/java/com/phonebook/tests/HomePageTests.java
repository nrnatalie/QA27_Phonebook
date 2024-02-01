package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {//проверяется, присутствует ли компонент на главной странице.
    if (! app.getHomepage().isHomeComponentPresent()) {
      app.getHomepage().clickOnHomeLink();
    }
  }

  @Test //что делает его тестовым методом.
  public void isHomeComponentPresentTest() {
    // который выполняет проверку наличия компонента на главной странице.
//   driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
    Assert.assertTrue(app.getHomepage().isHomeComponentPresent());

  }

}





