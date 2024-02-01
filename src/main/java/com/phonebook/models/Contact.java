package com.phonebook.models;

public class Contact {//Этот класс Contact служит для создания объектов, представляющих контакт,
  // и предоставляет методы для установки и получения значений его свойств

  private  String name;
  private  String lastname;
  private  String phone;
  private  String email;
  private  String address;
  private  String description;// Закрытое поле для хранения описания контакта.

  public Contact  setName(String name) {// Метод для установки значения имени контакта.
    this.name = name;
    return this;
  }

  public Contact  setLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public Contact  setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public Contact  setEmail(String email) {
    this.email = email;
    return this;
  }

  public Contact  setAddress(String address) {
    this.address = address;
    return this;
  }

  public Contact  setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }



  public String getDescription() {
    return description;
  }
  @Override
  public String toString() {
    return "Contact{" +
        "name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        '}';
  }
}
