package com.web.workoutRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.workoutEntity.Member;
import com.web.workoutEntity.WorkoutLog;

@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutLog, Long>{	
	
	public List<Member> findByMember_IdOrderByWorkoutDateDesc(long memberId);

}
