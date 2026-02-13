package com.web.workoutService;

import java.util.List;import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.workRequestobject.MemberRequestobject;
import com.web.workRequestobject.WorkOutLogRequest;
import com.web.workoutEntity.Member;
import com.web.workoutEntity.WorkoutLog;
import com.web.workoutRepository.MemberRepository;
import com.web.workoutRepository.WorkoutRepository;

import jakarta.validation.Valid;
@Service
public class WorkOutServiceImpl implements WorkOutService{
	
	@Autowired
	private MemberRepository repository;
	@Autowired
   private WorkoutRepository workRepository;
	@Override
	public List<Member> getFindAllMember() {
		List<Member> listofMember = repository.findAll();
		
		return listofMember;
	}

	@Override
	public void saveMember(MemberRequestobject member) {
		Member updateMember = new Member();
		if(member != null) {
			updateMember.setId(member.getId());
			updateMember.setName(member.getName());
			updateMember.setJoinDate(member.getJoinDate());
			
		}
		repository.save(updateMember);
		
	}

	@Override
	public Member findByMemberId(long MemberId) {
     Member member =    repository.findById(MemberId);
		return member;
	}

	@Override
	public void deletedByMemberId(long memebrId) {
		 repository.deleteById(memebrId);
	}

	@Override
	public Member updateMemberById(long memberId, MemberRequestobject member) {
		Member checkMember = repository.findById(memberId);
		Member updateMember = new Member();
		if(checkMember != null) {
			updateMember.setId(member.getId());
			updateMember.setName(member.getName());
			updateMember.setJoinDate(member.getJoinDate());
			
		}
		return repository.save(updateMember);
	}
	@Override
	public List<Member> getworkoutByMemebr(long memberId) {
		
		Member member = repository.findById(memberId);
		List<Member>listOfMembers = workRepository.findByMember_IdOrderByWorkoutDateDesc(member.getId());
		return listOfMembers;
	}

	@Override
	public void saveWorkoutLogs(WorkOutLogRequest workOutLogRequest) {
		WorkoutLog workoutLog = new WorkoutLog();
		workoutLog.setId(workOutLogRequest.getId());
		workoutLog.setExerciseName(workOutLogRequest.getExerciseName());
		workoutLog.setNote(workOutLogRequest.getNote());
		workoutLog.setSet(workOutLogRequest.getSet());
		workoutLog.setReps(workOutLogRequest.getReps());
		workoutLog.setWeight(workOutLogRequest.getWeight());
		workoutLog.setWorkoutDate(workOutLogRequest.getWorkoutDate());
		workRepository.save(workoutLog);
		
	}


}
