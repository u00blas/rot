package com.rot.app.proposal.replayoption;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplayOptionRepository extends JpaRepository<ReplayOption, Long> {
    ReplayOption findByName(String name);
}