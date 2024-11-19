package com.rot.app.proposal;


import com.rot.app.category.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/proposals")
public class ProposalController {

    private final ProposalRepository proposalRepository;

    public ProposalController(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @GetMapping
    public String listAllProposals(Model model) {
        List<Proposal> proposals = proposalRepository.findAll();
        model.addAttribute("proposals", proposals);
        return "proposals/index";
    }

    @GetMapping("/create")
    public String showProposalsForm(Model model) {
        model.addAttribute("proposal", new Proposal());
        return "proposals/create";
    }

    @PostMapping("/save")
    public String saveProposal(Proposal proposal) {
        proposalRepository.save(proposal);
        return "redirect:/proposals";
    }

    @GetMapping("/edit")
    public String showEditProposalForm(Model model, @RequestParam Long id) {
        if (id == null) return "redirect:/proposals";
        Proposal proposal = proposalRepository.findById(id).orElse(null);
        if (proposal == null) return "redirect:/proposals";
        model.addAttribute("proposal", proposal);
        return "proposals/edit";
    }

    @GetMapping("/proposals/delete")
    public String deleteProposal(@RequestParam Long id) {
        proposalRepository.deleteById(id);
        return "redirect:/proposals";
    }
}
