package com.tugas.deployPertemuan6.controller;

import com.tugas.deployPertemuan6.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140182";

    // Penyimpanan sementara (tanpa database)
    private List<User> users = new ArrayList<>();

    // ================= LOGIN =================
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            model.addAttribute("users", users); // kirim data ke home
            return "home";
        } else {
            model.addAttribute("error", "Username atau Password salah");
            return "login";
        }
    }

    // ================= HOME =================
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", users);
        return "home";
    }

    // ================= FORM =================
    @GetMapping("/form")
    public String form() {
        return "form";
    }

    // ================= ADD DATA =================
    @PostMapping("/add")
    public String addUser(@RequestParam String nama,
                          @RequestParam String nim,
                          @RequestParam String jenisKelamin,
                          Model model) {

        users.add(new User(nama, nim, jenisKelamin));
        model.addAttribute("users", users);

        return "home";
    }
}
