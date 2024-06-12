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

@PasswordsMatch(groups = ValidationGroupTwo.class) //<.>
public class CreateUserFormData extends AbstractUserFormData {
    @NotBlank
    private String password;
    @NotBlank
    private String passwordRepeated;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public CreateUserParameters toParameters() {
        return new CreateUserParameters(new UserName(getFirstName(), getLastName()),
                password,
                getGender(),
                getBirthday(),
                new github.io.helmigandi.springthymeleafproject.user.Email(getEmail()),
                new PhoneNumber(getPhoneNumber()));
    }
}
