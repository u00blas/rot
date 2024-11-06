package com.rot.app.session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    /*@GetMapping
    public String sessions() {
        return "sessions/session";
    }*/

    @GetMapping("/{session_id}")
    public String session(@PathVariable("session_id") String id, Model model) {
        Session session = sessionService.findBySessionId(id);
        System.out.println("=".repeat(80));
        System.out.println(session);
        System.out.println("=".repeat(80));
        model.addAttribute("sessionobject", session);
        return "sessions/session";
    }

    @PostMapping("/save")
    public String saveSession(@ModelAttribute Session session,Model model) {

        System.out.println(session);
        sessionService.saveSession(session);

        model.addAttribute("sessionobject", session);
        return "sessions/session";
    }

}
