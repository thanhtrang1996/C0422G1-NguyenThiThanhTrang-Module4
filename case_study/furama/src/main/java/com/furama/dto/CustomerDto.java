package com.furama.dto;

import com.furama.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;

public class CustomerDto implements Validator {
    private Integer id;
    private CustomerType customerType;
    @NotBlank
    @Pattern(regexp = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$", message = "Enter the wrong format .Please enter!!")
    private String name;
    private String dateOfBirth;
    private Integer gender;
    @NotBlank
    @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$", message = "Enter the wrong format .Please enter!!")
    private String idCard;
    @NotBlank
    @Pattern(regexp = "^(090|091|(84+)90|(84+)91)[0-9]{6}$", message = "Enter the wrong format .Please enter!!")
    private String phoneNumber;
    @Email(message = "Please enter email !!")
    private String email;
    private String address;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, CustomerType customerType, String name, String dateOfBirth,
                       Integer gender, String idCard, String phoneNumber, String email, String address) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        LocalDate now = LocalDate.now();
        if (customerDto.getDateOfBirth() != null && !customerDto.getDateOfBirth().equals("")) {
            LocalDate age = LocalDate.parse(customerDto.getDateOfBirth());
            int space = Period.between(age, now).getYears();
            if (space < 18) {
                errors.rejectValue("dateOfBirth", "date", " Age must be over 18");
            }
        } else {
            errors.rejectValue("dateOfBirth", "date", "Please enter Age !");
        }
    }

}

