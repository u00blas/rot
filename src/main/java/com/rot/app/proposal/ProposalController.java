package com.rot.app.proposal;


import com.rot.app.category.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/proposals/new")
    public String showProposalsForm(Model model) {
        model.addAttribute("proposal", new Proposal());
        return "proposal_form";
    }

    @PostMapping("/proposals/save")
    public String saveProposal(Proposal proposal) {
        proposalRepository.save(proposal);
        return "redirect:/proposals";
    }
}
