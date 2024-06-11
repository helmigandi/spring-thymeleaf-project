package github.io.helmigandi.springthymeleafproject.user.web;

import github.io.helmigandi.springthymeleafproject.user.Email;
import github.io.helmigandi.springthymeleafproject.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotExistingUserValidator implements ConstraintValidator<NotExistingUser, CreateUserFormData> {

    private final UserService userService;

    @Autowired
    public NotExistingUserValidator(UserService userService) { //<.>
        this.userService = userService;
    }

    public void initialize(NotExistingUser constraint) {
        // intentionally empty
    }

    // tag::isValid[]
    public boolean isValid(CreateUserFormData formData, ConstraintValidatorContext context) {
        if (userService.userWithEmailExists(new Email(formData.getEmail()))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{UserAlreadyExisting}")
                    .addPropertyNode("email")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
    // end::isValid[]
}
