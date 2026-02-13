package com.web.workoutService;

import java.util.List;

import com.web.workRequestobject.MemberRequestobject;
import com.web.workRequestobject.WorkOutLogRequest;
import com.web.workoutEntity.Member;

import jakarta.validation.Valid;

public interface WorkOutService {

	
	public List<Member> getFindAllMember();
	public void saveMember(@Valid MemberRequestobject member);
	public Member findByMemberId(long MemberId);
	public void deletedByMemberId(long memebrId);
	public Member updateMemberById(long memberId,MemberRequestobject member);
	public List<Member> getworkoutByMemebr(long memberId);
	public void saveWorkoutLogs(WorkOutLogRequest workOutLogRequest);
}
