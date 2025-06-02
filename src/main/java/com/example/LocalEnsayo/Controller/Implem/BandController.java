package com.example.LocalEnsayo.Controller.Implem;
import com.example.LocalEnsayo.DTO.BandDTO;
import com.example.LocalEnsayo.Model.Band;
import com.example.LocalEnsayo.Service.Interfaces.IBandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BandController {
    @Autowired
    IBandService bandService;

    @GetMapping("/band")
    public List<Band> findAllBands() {
        return bandService.findAllBands();
    }

    @GetMapping("/band/{id}")
    public Optional<Band> findById(@PathVariable Long id){
        return bandService.findById(id);

    }

    @PostMapping("/band")
    @ResponseStatus(HttpStatus.CREATED)
    public Band createBand(@RequestBody Band band){
        return bandService.createBand(band);
    }

    @PutMapping("/{id}")
    public Band updateBand (@PathVariable Long id, @RequestBody BandDTO dto){
        return bandService.updateBand(id,dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBand(@PathVariable Long id){
        Optional<Band> optionalBand=bandService.findById(id);
        if(optionalBand.isPresent()){
            bandService.deleteBand(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }


    }









}
