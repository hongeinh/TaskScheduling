import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class Task {
	private int id;
	private int duration;
	private int scheduledTime;
	private double start;
	private int[] assign;
	private int numbOfAssigned;
	private double lexp;

	public double getLexp() {
		return lexp;
	}

	public void setLexp(double lexp) {
		this.lexp = lexp;
	}

	public int getNumbOfAssigned() {
		return numbOfAssigned;
	}

	public void setNumbOfAssigned(int numbOfAssigned) {
		this.numbOfAssigned = numbOfAssigned;
	}

	public Task(int id, double start, int duration, int scheduledTime) {
		this.id = id;
		this.start = start;
		this.duration = duration;
		this.scheduledTime = scheduledTime;
		this.assign = new int[Common.numberOfResource];
		this.numbOfAssigned = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(int scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public int[] getAssign() {
		return assign;
	}

	public void setAssign(int[] assign) {
		this.assign = assign;
	}


	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(
				this.getId() + "\tStart time: " + this.getStart() + "\tAssign: ") ;

		for (int i = 0; i < Common.numberOfResource; i++) {
			str.append(this.getAssign()[i] + "\t");
		}
		return str.toString();
	}
}
