package com.rot.app.session;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubProposalRepository extends JpaRepository<SubProposal, Long> {
    SubProposal findByProposalLabel(String proposalLabel);
}
