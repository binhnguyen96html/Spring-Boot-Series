package com.ltp.globalsuperstore;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;


public class Item {

  @NotBlank(message = "Please select a category")
  private String category;

  @NotBlank(message = "Name cannot be blank")
  private String name;

  @Min(value = 0, message = "Price cannot be negative")
  private Double price;

  @Min(value = 0, message = "Price cannot be negative")
  private Double discount;

  @Past(message = "Date must be of the past")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;
  private String id;


  public Item() {
    this.id = UUID.randomUUID().toString();
  }

  public Item(String category, String name, Double price, Double discount, Date date, String id) {
    this.category = category;
    this.name = name;
    this.price = price;
    this.discount = discount;
    this.date = date;
    this.id = id;
  }


  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }



  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getDiscount() {
    return this.discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


}
