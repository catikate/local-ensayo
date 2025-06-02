package com.example.LocalEnsayo.Service.Interfaces;

import com.example.LocalEnsayo.DTO.MemberUpdateDTO;
import com.example.LocalEnsayo.Model.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberService {
    List<Member> findAllMembers();

    Optional<Member> findById(Long id);

    void deleteMember(Long id);
    Member updateMember(Long id, MemberUpdateDTO dto);

    Member createMember(Member member);
}
