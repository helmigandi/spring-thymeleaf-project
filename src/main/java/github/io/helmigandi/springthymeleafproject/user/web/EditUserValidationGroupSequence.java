package github.io.helmigandi.springthymeleafproject.user.web;

import github.io.helmigandi.springthymeleafproject.infrastructure.validation.ValidationGroupOne;
import github.io.helmigandi.springthymeleafproject.infrastructure.validation.ValidationGroupTwo;
import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class, ValidationGroupOne.class})
public interface EditUserValidationGroupSequence {
}
