package com.taimur.ToDo.Controller;

import com.taimur.ToDo.User.MyUser;
import com.taimur.ToDo.User.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new MyUser());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute MyUser myuser) {
        userService.registerUser(myuser);
        return "redirect:/login";
    }


}
