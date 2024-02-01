package com.phonebook.fw;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

  String browser;//Класс ApplicationManager представляет собой основной класс,
  // управляющий инициализацией и завершением работы приложения.

  WebDriver driver;//для взаимодействия с браузером.

  UserHelper user;
  ContactHelper contact;
  HomePageHelper homepage;//главной страницей.

  public ApplicationManager(String browser) {
    this.browser = browser;

  }

  public void init() {
    if (browser.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();//открывает веб-страницу, максимизирует окно браузера и устанавливает неявное ожидание.
    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
      driver = new EdgeDriver();
    }

    driver.get("https://telranedu.web.app");

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    user = new UserHelper(driver);
    contact = new ContactHelper(driver);
    homepage = new HomePageHelper(driver);
  }

  public UserHelper getUser() {
    return user;
  }

  public ContactHelper getContact() {
    return contact;
  }

  public HomePageHelper getHomepage() {
    return homepage;
  }

  public void stop() {//Завершает работу приложения, закрывая браузер.
    driver.quit();
  }
}

