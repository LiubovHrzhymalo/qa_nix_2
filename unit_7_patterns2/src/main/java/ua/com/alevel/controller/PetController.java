package ua.com.alevel.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.PetRequestDto;
import ua.com.alevel.dto.PetResponseDto;
import ua.com.alevel.dto.ResponseContainer;
import ua.com.alevel.facade.PetFacade;

import java.util.List;

@RestController
@RequestMapping("/api/pets")

public class PetController {private final PetFacade petFacade;

    public PetController(PetFacade petFacade) {
        this.petFacade = petFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody PetRequestDto dto) {
        petFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody PetRequestDto dto, @PathVariable String id) {
        petFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        petFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<PetResponseDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(petFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<PetResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(petFacade.findAll()));
    }
}
