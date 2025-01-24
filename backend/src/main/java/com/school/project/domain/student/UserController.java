package com.school.project.domain.student;


import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    final private UserService userService;

    @GetMapping("/signup")
    public String signUp(UserForm userForm) {
        return "signup_form"; // -> signup_form
    }
    @PostMapping("/signup")
    public String signUp(@Valid UserForm userForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "signup_form"; // -> signup_form with error messages
        }
        if (!userForm.getPassword().equals(userForm.getPassword2())){
            bindingResult.rejectValue("password2", "error.userForm", "비밀번호가 일치하지 않습니다.");
            return "signup_form"; // -> signup_form with error messages
        }


        try {
            userService.create(userForm.getId(), userForm.getName(), userForm.getEmail(), userForm.getPassword());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.rejectValue("signupFailed", "존재하는 사용자입니다.");
            return "signup_form"; // -> signup_form with error messages
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.rejectValue("signupFailed", e.getMessage());
            return "signup_form"; // -> signup_form with error messages
        }


        return "redirect:/user/login"; // -> login
    }

    @GetMapping("/login")
    public String login() {
        return "login_form"; // -> login_form
    }
}
