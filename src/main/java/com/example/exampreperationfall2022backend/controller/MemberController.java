package com.example.exampreperationfall2022backend.controller;

import com.example.exampreperationfall2022backend.entity.Member;
import com.example.exampreperationfall2022backend.repository.MemberRepository;
import com.example.exampreperationfall2022backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MemberController {

    private MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public List<Member> getAllMember(){
        return memberService.getAllMembers();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") Long id){
        Member member = memberService.getMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        Member newMember = memberService.createMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable("id") Long id, @RequestBody Member member){
        return new ResponseEntity<>(memberService.updateMember(id, member), HttpStatus.OK);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Member> deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}