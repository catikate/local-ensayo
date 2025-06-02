package com.example.LocalEnsayo.Controller.Implem;
import com.example.LocalEnsayo.DTO.MemberUpdateDTO;
import com.example.LocalEnsayo.Model.Member;
import com.example.LocalEnsayo.Service.Interfaces.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    IMemberService memberService;

    @GetMapping
    public List<Member> findAllMembers(){
        return memberService.findAllMembers();
    }

    @GetMapping("/{id}")
    public Optional<Member> findById (@PathVariable Long id){
        return memberService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Member createMember (@RequestBody Member member){
        return memberService.createMember(member);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember (@PathVariable Long id) {
        Optional<Member> optionalMember = memberService.findById(id);
        if (optionalMember.isPresent()) {
            memberService.deleteMember(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember (@PathVariable Long id, @RequestBody MemberUpdateDTO dto){
        try {
            Member updatedMember = memberService.updateMember(id, dto);
            return ResponseEntity.ok(updatedMember);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}






