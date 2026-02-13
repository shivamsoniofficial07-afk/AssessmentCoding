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
import com.web.workRequestobject.WorkOutLogRequest;
import com.web.workoutEntity.Member;
import com.web.workoutService.WorkOutService;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/api/workouts")
public class WorkOutController {
	
	@Autowired
	private WorkOutService workOutService;
	
	@GetMapping("/api/workouts/Member/GetAllMember")
	public ResponseEntity<List<Member>> getAllMember(){
		
		List<Member> listOfmemberList = workOutService.getFindAllMember();
		return ResponseEntity.ok(listOfmemberList);
		
	}
	@PostMapping("/api/workouts/createMember")
	public ResponseEntity<String> createMember( @RequestBody MemberRequestobject member) {

	    workOutService.saveMember(member);
	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body("Member created successfully");
	}
	@GetMapping("/api/workouts/{memberId}")
	public ResponseEntity<Member> findBymemberId(@PathVariable long memberId){
		Member member = workOutService.findByMemberId(memberId);
		return ResponseEntity.ok(member);
	}
	@PutMapping("/api/workouts/{memberId}")
	public ResponseEntity<Member> updateAllMember(@PathVariable long memberId,@RequestBody MemberRequestobject member){
		   Member updated = workOutService.updateMemberById(memberId, member);
	        return ResponseEntity.ok(updated);	
	}

	@DeleteMapping("/api/workouts/{id}")
	public ResponseEntity<String> deletedByMemberId(@PathVariable long memberId){		
		workOutService.deletedByMemberId(memberId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Member is deleted");
	}
	@GetMapping("/api/workouts/memberId")
	public ResponseEntity<List<Member>> getWorkOutByMember(@RequestParam long memberId){
	List<Member> listOfMembers =	workOutService.getworkoutByMemebr(memberId);
		return ResponseEntity.ok(listOfMembers);
		
	}
	@PostMapping("/api/workouts/workoutLogs")
	public ResponseEntity<String> createWorkLogs(@Valid @RequestBody WorkOutLogRequest workOutLogRequest){
		if(workOutLogRequest !=null) {
			workOutService.saveWorkoutLogs(workOutLogRequest);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Workout logs are created successfully");
	}
	
	@PostMapping("/api/workouts/members")
	public String create(@RequestBody @Valid MemberRequestobject dto) {
		return "Post API working successfully"; }
}
