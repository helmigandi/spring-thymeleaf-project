package github.io.helmigandi.springthymeleafproject.infrastructure.validation;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class, ValidationGroupOne.class, ValidationGroupTwo.class})
public interface ValidationGroupSequence {
}
