package com.example.LocalEnsayo.Service.Interfaces;

import com.example.LocalEnsayo.DTO.BacklineLoanUpdateDTO;
import com.example.LocalEnsayo.Model.Backline;

import java.util.List;
import java.util.Optional;

public interface IBacklineService {
    List<Backline> findAll();
    Optional<Backline> findById(Long id);

    Backline createBackline (Backline backline);

    void deleteBackline(Long id);

    Backline updateLoan(Long id, BacklineLoanUpdateDTO dto);
}
