package com.example.LocalEnsayo.Service.Implem;

import com.example.LocalEnsayo.DTO.BandDTO;
import com.example.LocalEnsayo.Model.Band;
import com.example.LocalEnsayo.Repository.BandRepository;
import com.example.LocalEnsayo.Service.Interfaces.IBandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandService implements IBandService {

    @Autowired
    private BandRepository bandRepository;

    @Override
    public List<Band> findAllBands(){
        return bandRepository.findAll();
    }

    @Override
    public Optional<Band> findById(Long id){
        return bandRepository.findById(id);
    }

    @Override
    public Band createBand(Band band){
        bandRepository.save(band);
        return band;
    }

    @Override
    public Band updateBand(Long id, BandDTO dto) {
        Optional<Band> optionalBand = bandRepository.findById(id);
        if (optionalBand.isPresent()) {
            Band band = optionalBand.get();
            if (dto.getName() != null) {
                band.setBandName(dto.getName());
            }
            if (dto.getPhone() != null) {
                band.setBandPhone(dto.getPhone());
            }
            if (dto.getMail() != null) {
                band.setBandMail(dto.getMail());
            }
            return bandRepository.save(band);
        } else {
            throw new RuntimeException("Band not found with id: " + id);
        }
    }

    @Override
    public void deleteBand(Long id) {
    }


}
