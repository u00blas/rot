package com.rot.app.proposal;


import com.rot.app.category.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/proposals/{id}/edit")
    public String showEditProposalForm(Model model, @PathVariable("id") Long id) {
        if (id == null) return "redirect:/proposals";
        model.addAttribute("proposal", proposalRepository.findById(id).get());
        return "proposal_form";
    }

    @GetMapping("/proposals/{id}/delete")
    public String deleteProposal(@PathVariable("id") Long id) {
        proposalRepository.deleteById(id);
        return "redirect:/proposals";
    }
}
