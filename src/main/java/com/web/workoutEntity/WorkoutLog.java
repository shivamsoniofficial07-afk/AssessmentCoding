package com.web.workoutEntity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "WorkoutLog")
@Entity
public class WorkoutLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private Date workoutDate;
	
	@Column
	private String exerciseName;
	
	@Column
	private Integer set;
	
	@Column
	private Integer reps;
    
	@Column
	private float weight;
	
	@Column
	private String note;
	
	@OneToMany
	@JoinColumn(name = "memberId")
	private Member member;

	public WorkoutLog(long id, Date workoutDate, String exerciseName, Integer set, Integer reps, float weight,
			String note) {
		super();
		this.id = id;
		this.workoutDate = workoutDate;
		this.exerciseName = exerciseName;
		this.set = set;
		this.reps = reps;
		this.weight = weight;
		this.note = note;
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
		return "WorkoutLog [id=" + id + ", workoutDate=" + workoutDate + ", exerciseName=" + exerciseName + ", set="
				+ set + ", reps=" + reps + ", weight=" + weight + ", note=" + note + "]";
	}
	
	
}
