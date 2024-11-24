package com.rot.app.targetgroup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetGroupRepository extends JpaRepository<TargetGroup, Long> {
    TargetGroup findByName(String part);
}
