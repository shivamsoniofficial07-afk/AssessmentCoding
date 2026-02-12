package com.web.workRequestobject;

import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;

public class MemberRequestobject {

	
	private long id;
	
	@Nonnull
	@NotBlank
	private String name;
	
	@NotBlank
	private Date joinDate;

	public MemberRequestobject(long id, @NotBlank String name, @NotBlank Date joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.joinDate = joinDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
