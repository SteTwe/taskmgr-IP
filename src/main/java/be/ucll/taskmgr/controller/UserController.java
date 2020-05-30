package be.ucll.taskmgr.controller;

import be.ucll.taskmgr.model.domain.dto.CreateUserDto;
import be.ucll.taskmgr.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginForm(Model model){
        return "loginForm";
    }

    @GetMapping("/signup")
    public String getSingupForm(Model model){
        model.addAttribute("user", new CreateUserDto());
        return "signupForm";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute("user") @Valid CreateUserDto dto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) return "signupForm";
        userService.createUser(dto);
        return "redirect:/login";
    }
}
