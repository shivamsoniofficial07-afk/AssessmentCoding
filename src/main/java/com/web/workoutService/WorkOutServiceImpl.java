package com.web.workoutService;

import java.util.List;import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.workRequestobject.MemberRequestobject;
import com.web.workoutEntity.Member;
import com.web.workoutRepository.MemberRepository;
import com.web.workoutRepository.WorkoutRepository;

import jakarta.validation.Valid;

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
			updateMember.setMemberId(member.getId());
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
	public Member updateMemberById(long memberId, Member member) {
		Member checkMember = repository.findById(memberId);
		Member updateMember = new Member();
		if(checkMember != null) {
			updateMember.setMemberId(member.getMemberId());
			updateMember.setName(member.getName());
			updateMember.setJoinDate(member.getJoinDate());
			
		}
		return repository.save(updateMember);
	}
	@Override
	public List<Member> getworkoutByMemebr(long memberId) {
		
		Member member = repository.findById(memberId);
		List<Member>listOfMembers = workRepository.findByMemberIdOrderByWorkOutLogDesc(member.getMemberId());
		return listOfMembers;
	}


}
