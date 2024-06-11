package github.io.helmigandi.springthymeleafproject.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    User createUser(CreateUserParameters parameters);

    // tag::editUser[]
    User editUser(UserId userId, EditUserParameters parameters);
    // end::editUser[]

    Page<User> getUsers(Pageable pageable); //<.>

    boolean userWithEmailExists(Email email);

    Optional<User> getUser(UserId userId);
}
