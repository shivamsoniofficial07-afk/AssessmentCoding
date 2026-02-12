package com.web.workoutRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.workoutEntity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
    public List<Member> findAll();
	
	//public void Save(Member member);
	
	public Member findById(long MemberId);

}
