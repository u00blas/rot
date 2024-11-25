package com.rot.app.targetgroup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/targetGroups")
public class TargetGroupController {

    private final TargetGroupServiceImpl targetGroupService;

    public TargetGroupController(TargetGroupServiceImpl targetGroupService) {
        this.targetGroupService = targetGroupService;
    }

    @GetMapping
    public String listAllTargetGroups(Model model) {
        List<TargetGroupDto> targetGroupDtos = targetGroupService.findAll().stream().map(TargetGroupDto::from).toList();
        model.addAttribute("targetGroupDtos", targetGroupDtos);
        return "targetGroups/index";
    }

    @GetMapping("/create")
    public String createTargetGroup(Model model) {
        TargetGroupDto targetGroupDto = new TargetGroupDto();
        model.addAttribute("targetGroupDto", targetGroupDto);
        return "targetGroups/edit";
    }

    @GetMapping("/edit")
    public String editTargetGroup(@RequestParam Long id, Model model) {
        TargetGroup targetGroup = targetGroupService.findById(id);
        if (targetGroup == null) {
            return "redirect:/targetGroups";
        }
        TargetGroupDto targetGroupDto = TargetGroupDto.from(targetGroup);
        model.addAttribute("targetGroupDto", targetGroupDto);
        return "targetGroups/edit";
    }

    @GetMapping("/delete")
    public String deleteTargetGroup(@RequestParam Long id, Model model) {
        targetGroupService.deleteById(id);

        return "redirect:/targetGroups";
    }

    @PostMapping("/save")
    public String saveTargetGroup(@ModelAttribute TargetGroupDto targetGroupDto) {
        if (targetGroupDto.getId() == null) {
            TargetGroup targetGroup = new TargetGroup(null, targetGroupDto.getName(), targetGroupDto.getDescription());
            targetGroupService.save(targetGroup);
            return "redirect:/targetGroups";
        }
        TargetGroup targetGroup = targetGroupService.findById(targetGroupDto.getId());
        if (targetGroup == null) {
            return "redirect:/targetGroups";
        }
        targetGroup.setName(targetGroupDto.getName());
        targetGroup.setDescription(targetGroupDto.getDescription());
        targetGroupService.save(targetGroup);
        return "redirect:/targetGroups";
    }

}
