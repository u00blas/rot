
package com.rot.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This Java code defines a Spring MVC controller (AppController)
 * with a method (index) that handles HTTP GET requests to the
 * root path ("/") of a web application. The method returns the
 * name of a view ("index"), which will be rendered by the application.
 */
@Controller
public class AppController {
    /**
     * Mapping for the root path ("/"). Returns the view "index".
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Mapping for the "/privacy" path. Returns the view "privacy".
     * This view displays the privacy policy of the app.
     */
    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }

    /**
     * Mapping for the "/contact" path. Returns the view "contact".
     * This view displays a contact form for users to contact the app owner.
     */
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
