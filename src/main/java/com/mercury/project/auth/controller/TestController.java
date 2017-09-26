package com.mercury.project.auth.controller;

import com.mercury.project.auth.model.User;
import com.mercury.project.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    private final UserService userService;

    @Autowired
    public TestController(UserService userService) {
        this.userService = userService;
    }




    @PostMapping("/regtest")
    public String regtest(User user) {

        userService.save(user);
        System.out.println(user);
        return "succeed";

    }

    @RequestMapping("/")
    public User index() {
        return userService.findByFirstName("tester");
    }

    @GetMapping("/regtest")
    public User regtest2() {
        return new User();
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
