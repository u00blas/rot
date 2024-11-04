package com.rot.app.session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public String sessions() {
        return "sessions/session";
    }

    @GetMapping("/{session_id}")
    public String session(@PathVariable("session_id") String id, Model model) {
        Session session = sessionService.findBySessionId(id);
        model.addAttribute("sessionobject", session);
        return "sessions/session";
    }

}
