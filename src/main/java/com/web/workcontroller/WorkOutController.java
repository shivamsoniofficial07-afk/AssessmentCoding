package com.web.workcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.workRequestobject.MemberRequestobject;
import com.web.workoutEntity.Member;
import com.web.workoutService.WorkOutService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/workouts")
public class WorkOutController {
	
	@Autowired
	private WorkOutService workOutService;
	
	@GetMapping("/Member/GetAllMember")
	public ResponseEntity<List<Member>> getAllMember(){
		
		List<Member> listOfmemberList = workOutService.getFindAllMember();
		if(listOfmemberList !=null) {
		return (ResponseEntity<List<Member>>) listOfmemberList;
		}
		return new ResponseEntity<List<Member>>(HttpStatus.BAD_REQUEST);
		
	}
	@PostMapping("/createMember")
	public ResponseEntity<String> createMember(@Valid @RequestBody MemberRequestobject member){
		Optional<@Valid MemberRequestobject> memberOptional = Optional.of(member);
		if(memberOptional.isPresent()) {
			workOutService.saveMember(member);
		}
				 
		return new ResponseEntity<String>(HttpStatus.OK);		
	}
	@GetMapping("/Member/{id}")
	public ResponseEntity<Member> findBymemberId(@PathVariable long memberId){
		Member member = workOutService.findByMemberId(memberId);
		return new ResponseEntity<Member>((HttpStatusCode) member);
	}
	@PutMapping("{id}")
	public ResponseEntity<Member> updateAllMember(@PathVariable long memberId,@RequestBody MemberRequestobject member){
		return null;
		
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deletedByMemberId(@PathVariable long memberId){		
		workOutService.deletedByMemberId(memberId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@GetMapping("memberId")
	public ResponseEntity<List<Member>> getWorkOutByMember(@RequestParam long memberId){
	List<Member> listOfMembers =	workOutService.getworkoutByMemebr(memberId);
		return (ResponseEntity<List<Member>>) listOfMembers;
		
	}
}
