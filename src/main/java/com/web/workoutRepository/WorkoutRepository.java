package com.web.workoutRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.workoutEntity.Member;
import com.web.workoutEntity.WorkoutLog;

public interface WorkoutRepository extends JpaRepository<WorkoutLog, Long>{
	
	public List<Member> findAll();
	
	//public void Save(Member member);
	
	public Member findById(long MemberId);
	
	public List<Member> findByMemberIdOrderByWorkOutLogDesc(long memberId);

}
