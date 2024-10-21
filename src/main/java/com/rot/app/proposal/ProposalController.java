package com.rot.app.proposal;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProposalController {

    private final ProposalRepository proposalRepository;

    public ProposalController(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @GetMapping("/proposals")
    public String listAllProposals(Model model) {
        List<Proposal> proposals = proposalRepository.findAll();
        model.addAttribute("proposals", proposals);
        return "proposals";
    }

}
