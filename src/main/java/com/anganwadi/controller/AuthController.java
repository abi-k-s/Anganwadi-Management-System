package com.anganwadi.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
    // This will show the login form
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // maps to login.jsp
    }

    // Redirect after successful login
    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("TEACHER")) {
            return "redirect:/teacher/dashboard";
        } else if (request.isUserInRole("ASSISTANT")) {
            return "redirect:/assistant/dashboard";
        }
        return "redirect:/login";
    }
    
    // Teacher dashboard
    @GetMapping("/teacher/dashboard")
    public String teacherDashboard(Model model, Principal principal) {
        return "teacher/dashboard"; // JSP: /WEB-INF/views/teacher/dashboard.jsp
    }

    // Assistant dashboard
    @GetMapping("/assistant/dashboard")
    public String assistantDashboard() {
        return "assistant/dashboard"; // JSP: /WEB-INF/views/assistant/dashboard.jsp
    }
}