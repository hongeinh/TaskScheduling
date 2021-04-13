package entity.pool;


import common.Common;
import entity.Task;
import java.util.HashMap;
import java.util.Map;

public class TaskPool {
	private static final TaskPool pool = null;
	private Map<Integer, Task> taskMap;
	public static final double maxDuration = 27.0;

	private TaskPool() {
		this.taskMap = new HashMap<>();
		this.taskMap.put(0 , new Task(0 , 0, 24, 26 ) );
		this.taskMap.put(1 , new Task(1 , 0, 26, 0  ) );
		this.taskMap.put(3 , new Task(3 , 0, 20, 50 ) );
		this.taskMap.put(4 , new Task(4 , 0, 12, 70 ) );
		this.taskMap.put(5 , new Task(5 , 0, 15, 82 ) );
		this.taskMap.put(6 , new Task(6 , 0, 18, 52 ) );
		this.taskMap.put(7 , new Task(7 , 0, 15, 107) );
		this.taskMap.put(8 , new Task(8 , 0, 15, 97 ) );
		this.taskMap.put(9 , new Task(9 , 0, 20, 50 ) );
		this.taskMap.put(10, new Task(10, 0, 27, 23 ) );
		this.taskMap.put(11, new Task(11, 0, 10, 112) );

		for (int i = 0; i < Common.numOfTasks; i++) {
			this.taskMap.get(i).setPredecessors();
			this.taskMap.get(i).setTreq();
		}
	}

	public static TaskPool getPool() {
		if (pool == null) {
			return new TaskPool();
		} else return pool;
	}

	public Task getTask(int i) {
		return this.taskMap.get(i);
	}
}
