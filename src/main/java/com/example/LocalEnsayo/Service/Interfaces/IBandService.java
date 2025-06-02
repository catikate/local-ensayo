package com.example.LocalEnsayo.Service.Interfaces;

import com.example.LocalEnsayo.DTO.BandDTO;
import com.example.LocalEnsayo.Model.Band;

import java.util.List;
import java.util.Optional;

public interface IBandService {
    List<Band> findAllBands();
    Optional<Band> findById(Long id);
    Band createBand(Band band);
    Band updateBand(Long id, BandDTO dto);

    void deleteBand(Long id);
}
