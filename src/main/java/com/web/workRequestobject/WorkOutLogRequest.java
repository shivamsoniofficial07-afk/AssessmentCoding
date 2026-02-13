package com.web.workRequestobject;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class WorkOutLogRequest {
	
	
	private long id;
	
	@NotBlank
	private Date workoutDate;
	
	@NotBlank
	private String exerciseName;
	
	@NotNull
	@PositiveOrZero
	private Integer set;
	
	@NotBlank
	@PositiveOrZero
	private Integer reps;
    
	@Nonnull
	private float weight;
	
	@NotBlank
	private String note;

	public WorkOutLogRequest(long id, @NotBlank Date workoutDate, @NotBlank String exerciseName,
			@NotNull @PositiveOrZero Integer set, @NotBlank @PositiveOrZero Integer reps, float weight,
			@NotBlank String note) {
		super();
		this.id = id;
		this.workoutDate = workoutDate;
		this.exerciseName = exerciseName;
		this.set = set;
		this.reps = reps;
		this.weight = weight;
		this.note = note;
	}

	public WorkOutLogRequest() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getWorkoutDate() {
		return workoutDate;
	}

	public void setWorkoutDate(Date workoutDate) {
		this.workoutDate = workoutDate;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public Integer getSet() {
		return set;
	}

	public void setSet(Integer set) {
		this.set = set;
	}

	public Integer getReps() {
		return reps;
	}

	public void setReps(Integer reps) {
		this.reps = reps;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "WorkOutLog [id=" + id + ", workoutDate=" + workoutDate + ", exerciseName=" + exerciseName + ", set="
				+ set + ", reps=" + reps + ", weight=" + weight + ", note=" + note + "]";
	}
	
	

}
