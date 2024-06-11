package github.io.helmigandi.springthymeleafproject.user.web;

import github.io.helmigandi.springthymeleafproject.infrastructure.validation.ValidationGroupOne;
import github.io.helmigandi.springthymeleafproject.infrastructure.validation.ValidationGroupTwo;
import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

import jakarta.validation.GroupSequence;

@GroupSequence({Default.class, ValidationGroupOne.class, ValidationGroupTwo.class})
public interface CreateUserValidationGroupSequence {
}