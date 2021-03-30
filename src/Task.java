import java.util.List;

public class Task {
	private String id;
	private int duration;
	private int scheduledTime;
	private List<Task> predecessors;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<Task> getPredecessors() {
		return predecessors;
	}

	public void setPredecessors(List<Task> predecessors) {
		this.predecessors = predecessors;
	}
}
