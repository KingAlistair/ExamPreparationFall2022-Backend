package com.example.exampreperationfall2022backend.repository;

import com.example.exampreperationfall2022backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
