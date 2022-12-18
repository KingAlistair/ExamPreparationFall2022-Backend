package com.example.exampreperationfall2022backend.service;

import com.example.exampreperationfall2022backend.entity.Member;
import com.example.exampreperationfall2022backend.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    private MemberService memberService;

    private long id;

    private Member member;

    @BeforeEach
    void setUp() {
        memberService = new MemberService(memberRepository);
        member = new Member("John", "Smith", "Stone street 1.",
                "Copenhagen", 2200, true, 1);

        id = 1L;
        member.setId(id);
    }

    @Test
    void canGetAllMembers() {
        //when
        memberService.getAllMembers();
        //then
        verify(memberRepository).findAll();
    }

    @Test
    void canGetMemberById() {
        //when
        memberService.getMemberById(id);
        //then
        verify(memberRepository).findById(id);
    }

    @Test
    void canCreateMember() {
        //when
        memberService.createMember(member);
        //then
        ArgumentCaptor<Member> memberArgumentCaptor = ArgumentCaptor.forClass(Member.class);
        verify(memberRepository).save(memberArgumentCaptor.capture());
        Member capturedMember = memberArgumentCaptor.getValue();
        assertThat(capturedMember).isEqualTo(member);
    }

    @Test
    void canUpdateMember() {
        //given
        member.setFirstName("Tibor");
        Mockito.when(memberRepository.findById(id)).thenReturn(Optional.ofNullable(member));
        Mockito.when(memberRepository.save(member)).thenReturn(member);

        //when
        Member updatedMember = memberService.updateMember(id, member);

        //then
        assertThat(updatedMember.getFirstName()).isEqualTo("Tibor");
    }

    @Test
    void canUpdateMemberReturnNull() {
        //when
        Member updatedMember = memberService.updateMember(id, member);

        //then
        assertThat(updatedMember).isNull();
    }

    @Test
    void canDeleteMember() {
        //when
        memberService.deleteMember(id);
        //then
        verify(memberRepository).deleteById(id);
    }
}