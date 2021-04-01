import java.util.List;

public class NSGAImproved extends NSGA{

    boolean [][] isUseful = new boolean[Common.numberOfTasks][Common.numberOfResource];
    @Override
    public void createOffspringPopulation() {
        super.createOffspringPopulation();
    }

    @Override
    public void init() {
        for (int i = 0; i < Common.populationSize; i++) {
            Vertices vertices = new Vertices();
            this.getVerticesList().add(initElement(Common.maxDuration*i/Common.populationSize, vertices));
        }
    }


    /**
     * Initialize the individuals
     *
     * */
    public Vertices initElement(int k, Vertices vertices) {
        List<Task> tasks = vertices.taskList;
        int i = 0;
        for (Task task: tasks) {
           for (int j = 0; j < i; j++) {
               Task tj = tasks.get(j);
               if(Common.relationship[tj.getId()-1][task.getId()-1] == 1) {
                   double start = Math.max(task.getStart(), tj.getStart() + tj.getDuration());
                   task.setStart(start);
               }
           }

           for(int j = 0; j < Common.numberOfResource; j++) {
               int [] assign = task.getAssign();
               if(Common.isUseful[task.getId()-1][j] == 0){
                   assign[j] = 0;
               } else {
                   double rand = Math.random();
                   assign[j] = rand >= 0.5 ? 1 : 0;
                   if(assign[j] == 1) {
                       task.setNumbOfAssigned(task.getNumbOfAssigned()+1);
                   }
               }
               task.setAssign(assign);
           }
           i++;
        }
        return vertices;
    }


    @Override
    public void crossover() {
        for (int i = 0; i < Common.parentPoolSize/2; i++) {
            int first = (int) Math.ceil(Math.random()*Common.populationSize/2);
            int second = (int) Math.ceil(Math.random()*Common.populationSize/2);
            if(first != second) {
                crossover(this.getVerticesList().get(first), this.getVerticesList().get(second));
            } else {
                i--;
            }
        }
    }

    public void crossover(Vertices a, Vertices b) {
        int pos1, pos2, begin, end;
        do {
            pos1 = (int) Math.floor(Math.random()*Common.numberOfTasks);
            pos2 = (int) Math.floor(Math.random()*Common.numberOfTasks);
        } while (pos1 == pos2);

        if(pos1 > pos2) {
            begin = pos2;
            end = pos1;
        } else {
            begin = pos1;
            end = pos2;
        }
        List<Task> taskList1 = a.taskList;
        List<Task> taskList2 = b.taskList;

        for (int i = begin; i < end; i++) {
            Task t1 = taskList1.get(i);
            Task t2 = taskList2.get(i);

            double dif = t1.getStart() - t2.getStart();

            if(dif < 0) {
                t1.setStart(t1.getStart() + dif*0.1);
                t2.setStart(t2.getStart() - dif*0.1);
            } else {
                t1.setStart(t1.getStart() - dif*0.1);
                t2.setStart(t2.getStart() + dif*0.1);
            }
        }
    }
}
