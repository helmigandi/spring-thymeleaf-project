package github.io.helmigandi.springthymeleafproject.user.web;

import github.io.helmigandi.springthymeleafproject.infrastructure.validation.ValidationGroupOne;
import github.io.helmigandi.springthymeleafproject.infrastructure.validation.ValidationGroupTwo;
import github.io.helmigandi.springthymeleafproject.user.CreateUserParameters;
import github.io.helmigandi.springthymeleafproject.user.Gender;
import github.io.helmigandi.springthymeleafproject.user.PhoneNumber;
import github.io.helmigandi.springthymeleafproject.user.UserName;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

@NotExistingUser(groups = ValidationGroupTwo.class)
public class CreateUserFormData {
    @NotBlank
    @Size(min = 1, max = 200, groups = ValidationGroupOne.class)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 200, groups = ValidationGroupOne.class)
    private String lastName;

    @NotNull
    private Gender gender;

    @NotBlank
    @Email(groups = ValidationGroupOne.class)
    private String email;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank
    @Pattern(regexp = "[0-9.\\-() x/+]+", groups = ValidationGroupOne.class)
    private String phoneNumber;

    // tag::getters-and-setters-comment[]
    // Getters and setters omitted
    // tag::getters-and-setters-comment[]

    // tag::getters-and-setters[]

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // end::getters-and-setters[]
    // tag::toParameters[]
    public CreateUserParameters toParameters() {
        return new CreateUserParameters(new UserName(firstName, lastName),
                gender,
                birthday,
                new github.io.helmigandi.springthymeleafproject.user.Email(email),
                new PhoneNumber(phoneNumber));
    }
    // end::toParameters[]
}
