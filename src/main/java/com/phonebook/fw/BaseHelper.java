package com.phonebook.fw;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHelper {
  WebDriver driver;

  public BaseHelper(WebDriver driver) {//необходимый для взаимодействия с браузером.

    this.driver = driver;
  }

  public boolean isElementPresent(By locator) {// Проверяет наличие элемента на странице,используя указанный локатор.

    return driver.findElements(locator).size()>0;
  }

  public void type(By locator, String text) {//Вводит текст в элемент, определенный локатором.
    if (text != null) {
      click(locator);//Нажимает на элемент, определенный локатором.
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(text);
    }
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public boolean isAlertAppears() {//Проверяет наличие всплывающего окна (alert) на странице.
    // Если alert присутствует, он принимается (accept)
    // и возвращается true, в противном случае возвращается false.
    Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
        .until(ExpectedConditions.alertIsPresent());
    if (alert==null) {
      return false;
    }else {
      driver.switchTo().alert().accept();
      return true;
    }
  }
  //Этот базовый класс предоставляет общие методы для работы с веб-элементами,
  // которые могут быть использованы в других вспомогательных классах.

  public void pause(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
  public String takeScreenshot() {

    File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File screenchot = new File("screenshots/screen" + System.currentTimeMillis() + ".png");
   try {
     Files.copy(tmp, screenchot);
   }catch (IOException e) {
     throw new RuntimeException(e);
   }
   return screenchot.getAbsolutePath();

  }


}

//Класс BaseHelper представляет собой базовый класс для
// вспомогательных классов, предназначенных для взаимодействия
// с элементами пользовательского интерфейса на веб-страницах