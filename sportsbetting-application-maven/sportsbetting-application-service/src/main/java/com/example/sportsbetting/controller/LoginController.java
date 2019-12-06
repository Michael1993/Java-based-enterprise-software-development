package com.example.sportsbetting.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.sportsbetting.SportsBettingService;
import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.User;

@Controller
public class LoginController {

    @Autowired
    private SportsBettingService service;

    @GetMapping("/")
    public String loginInit(Locale locale, Model model) {
        return "login";
    }

    @GetMapping("/login")
    public String loginIniti(Locale locale, Model model) {
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView ShowData(Model model, Principal principal) {

        User user = service.findUserByEmail(principal.getName());
        ModelAndView result = new ModelAndView();

        User player = service.findPlayer(user.getId());
        model.addAttribute("player", player);

        model.addAttribute("wagers", service.TableWagers(user.getId()));
        model.addAttribute("currencies", Currency.values());

        result.addAllObjects(model.asMap());
        result.setViewName("welcome");
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void saveData(HttpServletRequest request, HttpServletResponse response) {

        try {
            this.service.updatePlayer(request.getParameter("inputname")
                , request.getParameter("inputbirth")
                , request.getParameter("inputaccountnumber")
                , request.getParameter("inputcurrency")
                , request.getParameter("inputbalance")
                , request.getParameter("inputid"));
            response.sendRedirect("welcome");
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteData(HttpServletRequest request, HttpServletResponse response) {
        String url = "welcome";

        try {
            String pa = request.getParameter("delete");
            this.service.deleteWager(Integer.parseInt(pa));
            response.sendRedirect(url);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}		



