package com.rot.app.marking;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkingService {

    private final MarkingRepository markingRepository;

    public MarkingService(MarkingRepository markingRepository) {
        this.markingRepository = markingRepository;
    }


    public List<MarkingDto> findAll() {
        return markingRepository.findAll().stream().map(MarkingDto::toDto).toList();
    }

    public MarkingDto save(MarkingDto markingDto) {
        Marking marking = MarkingDto.fromDto(markingDto);
        return MarkingDto.toDto(markingRepository.save(marking));
    }

    public void delete(Long id) {
        markingRepository.deleteById(id);
    }
}
