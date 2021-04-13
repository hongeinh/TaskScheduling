package entity;

import common.Common;
import entity.pool.SkillPool;
import entity.pool.TaskPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task {

	/**
	 * Unique identification for this task
	 * */
	private int id;

	/**
	 * Task's duration
	 * */
	private double duration;

	/**
	 * Task's scheduled start time.
	 * */
	private double scheduledTime;

	/**
	 * Task's actual start time
	 * */
	private double start;

	/**
	 * Defines all required skills to perform this task
	 * */
	private List<Skill> treq;

	/**
	 * Clarifies the tasks that need to finish before this task's execution
	 * */
	private List<Task> predecessors;


	public Task(int id, double start, int duration, int scheduledTime) {
		this.id = id;
		this.start = start;
		this.duration = duration;
		this.scheduledTime = scheduledTime;
		this.treq = new ArrayList<>();
		this.predecessors = new ArrayList<>();


	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(double scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public List<Skill> getTreq() {
		return treq;
	}

	/**
	 * Initialize the list of skills needed for this task
	 * Does not change
	 * */
	public void setTreq() {
		for (int i = 0; i < Common.numOfSkills; i++) {
			if (Common.treq[this.id][i] == 1) {
				this.treq.add(SkillPool.getPool().getSkill(i));
			}
		}
	}

	public List<Task> getPredecessors() {
		return predecessors;
	}

	/**
	 * Initialize the list of tasks needed to finish before this task
	 * Does not change
	 * */
	public void setPredecessors() {
		for (int i = 0; i < Common.numOfTasks; i++) {
			if(Common.relationship[i][this.id] == 1) {
				this.predecessors.add(TaskPool.getPool().getTask(i));
			}
		}
	}


	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(
				this.getId() + "\tSched time: " + this.getScheduledTime() + "\tStart time: " + this.getStart() + "\tAssign: ") ;
		return str.toString();
	}
}
