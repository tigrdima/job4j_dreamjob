package ru.job4j.dream.control;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.dream.model.User;
import ru.job4j.dream.service.UserService;
import java.util.Optional;

@ThreadSafe
@Controller
public class UserControl {
    private final UserService userService;

    public UserControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/formRegistration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @GetMapping("/fail")
    public String fail(Model model) {
        model.addAttribute("message", "Пользователь с таким именем уже существует");
        return "fail";
    }

    @GetMapping("/success")
    public String success(Model model) {
        model.addAttribute("message", "Новый пользователь зарегистрирован");
        return "success";
    }

    @PostMapping("/registration")
    public String createRegistration(@ModelAttribute User user) {
        Optional<User> regUser = userService.add(user);
        if (regUser.isEmpty()) {
            return "redirect:/fail";
        }
        return "redirect:/success";
    }

}
