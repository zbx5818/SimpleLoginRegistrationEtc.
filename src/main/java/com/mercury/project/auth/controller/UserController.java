package com.mercury.project.auth.controller;

import com.mercury.project.auth.model.User;
import com.mercury.project.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/registration")
    public String regtest(User user) {
        return userService.findAll().toString();
    }

    @RequestMapping("/")
    public User index() {
        return userService.findByFirstName("tester");
    }

    @GetMapping("/reg")
    public User regtest2() {
        return new User();
    }

    @GetMapping("/login")
    public String loginPage(User user) {
        return "Login.html";
    }
    /*
    @RequestMapping(value = "/ds", method = RequestMethod.GET)
    public Iterable<User> getAllPersons() {
        return repo.findAll();
    }

    @RequestMapping(value = "/ds/{name}", method = RequestMethod.GET)
    public User getPerson(@PathVariable String name) {
        return repo.findByUsername(name);
    }

    @RequestMapping(value = "/ds", method = RequestMethod.POST)
    @ResponseBody
    public void savePerson(@RequestBody User user) {
        System.out.println("user: " + user);
        repo.save(user);
    }
    */
    /*
    @RequestMapping(value="/ds/{name}", method=RequestMethod.DELETE)
	public void deletePerson(@PathVariable String name) {
		repo.deleteByName(name);
	}
	*/
}
