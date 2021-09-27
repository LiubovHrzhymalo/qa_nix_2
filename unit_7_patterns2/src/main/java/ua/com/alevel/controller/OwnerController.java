package ua.com.alevel.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.OwnerRequestDto;
import ua.com.alevel.dto.OwnerResponseDto;
import ua.com.alevel.dto.ResponseContainer;
import ua.com.alevel.facade.OwnerFacade;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerFacade ownerFacade;

    public OwnerController(OwnerFacade ownerFacade) {
        this.ownerFacade = ownerFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody OwnerRequestDto dto) {
        ownerFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody OwnerRequestDto dto, @PathVariable String id) {
       ownerFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        ownerFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<OwnerResponseDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(ownerFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<OwnerResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(ownerFacade.findAll()));
    }


}
