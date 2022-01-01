package crud_boot.springboot.example.controllers;

import crud_boot.springboot.example.models.User;
import crud_boot.springboot.example.service.RoleService;
import crud_boot.springboot.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminsController {

    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public AdminsController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Transactional
    @GetMapping(value = "")
    public String printAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/index";
    }

    @GetMapping("/{id}")
    public String printUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/show";
    }

    @GetMapping("/add_user")
    public String newUser(Model model) {
        model.addAttribute("roles", roleService.allRoles());
        model.addAttribute("user", new User());
        return "admin/add_user";
    }

    @Transactional
    @PostMapping("")
    public String addUser(@ModelAttribute("addUser") User user,
                          @RequestParam(value = "nameRoles") String[] nameRoles) {
        user.setRoles(roleService.getSetOfRoles(nameRoles));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String getUserById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.allRoles());
        return "admin/edit";
    }

    @Transactional
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,
                             @PathVariable("id") Long id,
                             @RequestParam(value = "nameRoles") String[] nameRoles) {
        user.setRoles(roleService.getSetOfRoles(nameRoles));
        userService.updateUser(user, id);
        return "redirect:/admin";
    }

    @Transactional
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}