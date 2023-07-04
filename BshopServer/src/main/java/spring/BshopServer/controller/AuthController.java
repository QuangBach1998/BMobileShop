package spring.BshopServer.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.BshopServer.dto.ProfileDTO;
import spring.BshopServer.entity.Account;
import spring.BshopServer.form.AuthChangePasswordForm;
import spring.BshopServer.form.createForm.AccountCreateForm;
import spring.BshopServer.service.IAccountService;

import javax.validation.Valid;
import java.security.Principal;

@Validated
@RestController
@RequestMapping(value = "api/v1/auth")
public class AuthController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IAccountService service;


    @GetMapping("/login")
    public ProfileDTO login(Principal principal) {
        String username = principal.getName();
        Account account = service.findByUsername(username);
        return mapper.map(account, ProfileDTO.class);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid AccountCreateForm form) {
        service.create(form);
    }

    @PutMapping("/change-password")
    public void changePassword(@RequestBody @Valid AuthChangePasswordForm form) {
        service.changePassword(form);
    }
}
