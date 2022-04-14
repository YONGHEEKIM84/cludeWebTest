package pnp.cluoudWebStudy.cluoudWeb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pnp.cluoudWebStudy.cluoudWeb.domain.User;
import pnp.cluoudWebStudy.cluoudWeb.dto.UserForm;
import pnp.cluoudWebStudy.cluoudWeb.exception.DuplicateEmailException;
import pnp.cluoudWebStudy.cluoudWeb.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signUpUser(UserForm userForm) throws Exception {
        validateDuplicateEmail(userForm.getEmail());
        userRepository.save(User.createUser(userForm));
    }

    private void validateDuplicateEmail(String email) throws Exception {
        if(userRepository.existsByEmail(email)){
            throw new DuplicateEmailException();
        }
    }



}
