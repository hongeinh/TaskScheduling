package old;

import java.util.ArrayList;
import java.util.List;

public class Vertices {

    public List<Task> taskList = new ArrayList<Task>();

    private double duration;

    private double assignment;

    private double experience;

    private int rank;

    private double distance;

    public Vertices() {
        Task t1 = new Task(1, 0, 24, 26);
        Task t2 = new Task(2, 0, 26, 0);
        Task t3 = new Task(3, 0, 20, 50);
        Task t4 = new Task(4, 0, 12, 70);
        Task t5 = new Task(5, 0, 15, 82);
        Task t6 = new Task(6, 0, 18, 52);
        Task t7 = new Task(7, 0, 15, 107);
        Task t8 = new Task(8, 0, 15, 97);
        Task t9 = new Task(9, 0, 20, 50);
        Task t10 = new Task(10, 0, 27, 23);
        Task t11 = new Task(11, 0, 10, 112);
        Task t12 = new Task(12, 0, 18, 32);

        taskList.add(t2);
        taskList.add(t3);
        taskList.add(t6);
        taskList.add(t10);
        taskList.add(t12);
        taskList.add(t1);
        taskList.add(t9);
        taskList.add(t4);
        taskList.add(t7);
        taskList.add(t5);
        taskList.add(t8);
        taskList.add(t11);
    }


    public void setDuration() {
        double duration = 0;
        for (Task task : this.taskList) {
            double idle = task.getScheduledTime() - task.getStart();
            idle = idle < 0 ? 0 : (1/(1 + idle));
//            idle = idle < 0 ? 0 : (1 + idle);
            duration += idle;
        }
        this.duration = duration / Common.numberOfTasks;
    }


    public void setExperience() {
        double treq = 0;
        for (Task task : this.taskList) {
//            treq += getSkillsMaxExp(task.getId() - 1) + getLexp(task.getId()-1)/task.getNumbOfAssigned();
            for (int i = 0; i < Common.numberOfSkills; i++) {
                if (Common.treq[task.getId() - 1][i] == 1) {
                    treq = getMaxExpOfSkill(i) + getSumExpOfSkill(i) / task.getNumbOfAssigned();
                }
            }
        }
        treq /= Common.numberOfSkills;
        this.experience = treq / Common.numberOfTasks;
    }


    public double getMaxExpOfSkill(int j) {
        double max = 0;
        for (int i = 0; i < Common.numberOfResource; i++) {
            max = max > Common.lexp[i][j] ? max : Common.lexp[i][j];
        }
        return max;
    }
//    public double getSkillsMaxExp(int i){
//        double max = 0;
//        for (int j = 0; j < Common.numberOfSkills; j++) {
//            if( Common.treq[i][j] == 1) {
//                for (int k = 0; k < Common.numberOfResource; k++) {
//                    max = max > Common.lexp[k][i] ? max : Common.lexp[k][i];
//                }
//            }
//        }
//        return max;
//    }

    public double getSumExpOfSkill(int j) {
        double avg = 0;
        for (int i = 0; i < Common.numberOfResource; i++) {
            avg += Common.lexp[i][j];
        }
        return avg;
    }

    // pending
    public void setAssign() {
        this.assignment = 0;
    }

    public double getDuration() {
        return duration;
    }

    public double getAssignment() {
        return assignment;
    }

    public double getExperience() {
        return experience;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}

