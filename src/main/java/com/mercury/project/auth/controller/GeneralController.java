package com.mercury.project.auth.controller;

import com.mercury.project.auth.model.User;
import com.mercury.project.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@Controller
public class GeneralController {
    private final UserService userService;

    @Autowired
    public GeneralController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/registration")
    public String regtest(User user) {
        return userService.findAll().toString();
    }

    @GetMapping("/*")
    public String index() {
        return "redirect:/Welcome";
    }

    @GetMapping("/stocktest")
    public @ResponseBody
    String testStock() throws IOException {
        Stock stock = YahooFinance.get("INTC");
        StringBuilder sb = new StringBuilder();
        sb.append(stock.getName()).append(stock.getCurrency())
                .append(stock.getQuote().getPrice());
        return sb.toString();
    }

    @GetMapping("/Welcome")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("/reg")
    public User regtest2() {
        return new User();
    }

    @GetMapping("/login")
    public String loginPage(User user) {
        return "Login";
    }

    @GetMapping("/admin")
    public String adminPage(User user) {
        return "WelcomeAdmin";
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
