package com.example.LocalEnsayo.Service.Implem;

import com.example.LocalEnsayo.DTO.MemberUpdateDTO;
import com.example.LocalEnsayo.Model.Band;
import com.example.LocalEnsayo.Model.Member;
import com.example.LocalEnsayo.Repository.BandRepository;
import com.example.LocalEnsayo.Repository.MemberRepository;
import com.example.LocalEnsayo.Service.Interfaces.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements IMemberService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BandRepository bandRepository;

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
   public Member createMember (Member member){
        memberRepository.save(member);
        return member;
    }

    @Override
    public void deleteMember(Long id) {
    }

    @Override
    public Member updateMember(Long id, MemberUpdateDTO dto) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();

            if (dto.getName() != null) {
                member.setName(dto.getName());
            }

            if (dto.getBandId() != null) {
                Optional<Band> optionalBand = bandRepository.findById(dto.getBandId());
                if (optionalBand.isPresent()) {
                    member.setBand(optionalBand.get());
                } else {
                    throw new RuntimeException("Band not found with id " + dto.getBandId());
                }
            }

            return memberRepository.save(member);
        } else {
            throw new RuntimeException("Member not found with id " + id);
        }
    }
}










