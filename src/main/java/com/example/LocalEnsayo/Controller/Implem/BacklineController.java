package com.example.LocalEnsayo.Controller.Implem;

import com.example.LocalEnsayo.DTO.BacklineLoanUpdateDTO;
import com.example.LocalEnsayo.Model.Backline;
import com.example.LocalEnsayo.Service.Interfaces.IBacklineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BacklineController {

    @Autowired
    IBacklineService backlineService;

    @GetMapping("/backline")
    public List<Backline> getAll() {
        return backlineService.findAll();
    }

    @GetMapping("/backline/{id}")
    public ResponseEntity<Backline> getById(@PathVariable Long id) {
        Optional<Backline> optionalBackline = backlineService.findById(id);
        if (optionalBackline.isPresent()) {
            return ResponseEntity.ok(optionalBackline.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/backline")
    @ResponseStatus(HttpStatus.CREATED)
    public Backline createBackline(@RequestBody Backline backline) {
        return backlineService.createBackline(backline);
    }

    @DeleteMapping("/backline")
    public ResponseEntity<Void> deleteBackline(@PathVariable Long id) {
        Optional<Backline> optionalBackline = backlineService.findById(id);
        if (optionalBackline.isPresent()) {
            backlineService.deleteBackline(id);
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}/loan")
    public ResponseEntity<Backline> updateLoan(@PathVariable Long id, @RequestBody BacklineLoanUpdateDTO dto) {
        try {
            Backline updated = backlineService.updateLoan(id, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}





