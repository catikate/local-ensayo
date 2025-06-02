package com.example.LocalEnsayo.Repository;

import com.example.LocalEnsayo.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByBandId (Long bandId);



}
