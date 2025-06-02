package com.example.LocalEnsayo.Service.Implem;

import com.example.LocalEnsayo.DTO.BacklineLoanUpdateDTO;
import com.example.LocalEnsayo.Model.Backline;
import com.example.LocalEnsayo.Model.Member;
import com.example.LocalEnsayo.Repository.BacklineRepository;
import com.example.LocalEnsayo.Repository.MemberRepository;
import com.example.LocalEnsayo.Service.Interfaces.IBacklineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BacklineService implements IBacklineService {

    @Autowired
    private BacklineRepository backlineRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Backline> findAll() {
        return backlineRepository.findAll();
    }

    @Override
    public Optional<Backline> findById(Long id) {
        return backlineRepository.findById(id);
    }

    @Override
    public Backline createBackline(Backline backline) {
        backlineRepository.save(backline);
        return backline;
    }


    @Override
    public void deleteBackline(Long id) {
    }

    @Override
    public Backline updateLoan(Long id, BacklineLoanUpdateDTO dto) {
        Backline backline = backlineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Backline not found with id: " + id));

        if (dto.getOnLoanToId() != null) {
            Member member = memberRepository.findById(dto.getOnLoanToId())
                    .orElseThrow(() -> new RuntimeException("Member not found with id: " + dto.getOnLoanToId()));
            backline.setOnLoanTo(member);
        } else {
            backline.setOnLoanTo(null);
        }

        return backlineRepository.save(backline);
    }
}

