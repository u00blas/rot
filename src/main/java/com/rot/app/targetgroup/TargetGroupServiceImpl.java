package com.rot.app.targetgroup;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetGroupServiceImpl implements TargetGroupService {

    private final TargetGroupRepository targetGroupRepository;

    public TargetGroupServiceImpl(TargetGroupRepository targetGroupRepository) {
        this.targetGroupRepository = targetGroupRepository;
    }

    public List<TargetGroup> findAll() {
        return targetGroupRepository.findAll();
    }

    public TargetGroup findById(Long id) {
        return targetGroupRepository.findById(id).orElse(null);
    }

    public void save(TargetGroup targetGroup) {
        targetGroupRepository.save(targetGroup);
    }

    public void deleteById(Long id) {
        targetGroupRepository.deleteById(id);
    }
}
