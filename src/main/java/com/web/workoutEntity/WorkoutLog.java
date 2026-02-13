package com.web.workoutEntity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "WorkoutLog")
@Entity
public class WorkoutLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	
	@Column
	private Date workoutDate;
	
	@Column
	private String exerciseName;
	
	@Column(name = "sets")
	private Integer sets;
	
	@Column(name="reps")
	private Integer reps;
    
	@Column
	private float weight;
	
	@Column
	private String note;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "member_id", nullable = false)
	private Member member;
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
		return sets;
	}

	public void setSet(Integer set) {
		this.sets = set;
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
				+ sets + ", reps=" + reps + ", weight=" + weight + ", note=" + note + "]";
	}
	
	
}
