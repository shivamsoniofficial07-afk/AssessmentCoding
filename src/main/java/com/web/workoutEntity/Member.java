package com.web.workoutEntity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Member")
public class Member {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long memberId;
	
	@Column
	private String Name;
	
	private Date joinDate;

	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		memberId = memberId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}




	@Override
	public String toString() {
		return "Member [MemberId=" + memberId + ", Name=" + Name + ", joinDate=" + joinDate + "]";
	}
	
	

}
