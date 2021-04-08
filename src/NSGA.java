import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class NSGA {

    public List<Vertices> getVerticesList() {
        return verticesList;
    }

    public void setVerticesList(List<Vertices> verticesList) {
        this.verticesList = verticesList;
    }

    List<Vertices> verticesList;

    NSGA() {
        this.verticesList = new ArrayList<>();
    }

    private List<Vertices> originalList;
    private List<Vertices> offspringList;

    public void execute(){
        init();
        crossover();
        display();
    }
    public void init() {
        for (int i = 0; i < Common.populationSize; i++) {
            Vertices vertices = new Vertices();
            List<Task> taskList = vertices.taskList;
            for (Task task: taskList) {
                int operator = Math.random() >= 0.5 ? 1 : 0;
                if(operator == 1) {
                    task.setStart(task.getScheduledTime() + (int) Math.random()*100);
                } else {
                    task.setStart(task.getScheduledTime() - (int) Math.random()*100);
                }
                int [] assign = task.getAssign();
                for (int j = 0; j < Common.numberOfResource; j++) {
                    int rand = Math.random() >= 0.5 ? 1 : 0;
                    assign[j] = rand;
                    if(rand == 1) {
                        task.setNumbOfAssigned(task.getNumbOfAssigned() + 1);
                    }
                }
                task.setAssign(assign);
            }
            vertices.setDuration();
            vertices.setAssign();
            vertices.setExperience();
            this.verticesList.add(vertices);
        }
    }


    public void createOffspringPopulation() {
        int i = 0;
        calculateRank();
        calculateDistance();
        do {

        } while (i < Common.parentPoolSize);
    }

    public void calculateRank() {

    }

    public void calculateDistance() {

    }

//    public void write() throws FileNotFoundException, UnsupportedEncodingException {
//        PrintWriter writer = new PrintWriter("results.txt", "UTF-8");
//        int i = 1;
//        for (Vertices v: this.verticesList) {
//            List<Task> taskList = v.taskList;
//            writer.println("Vertice " + i);
//            for (Task t: taskList) {
//                writer.println(t.toString());
//            }
//            writer.println("----- Duration: " + v.getDuration() + " ----- Experience: " + v.getExperience() + " ----- Assign: " + v.getAssignment());
//            writer.println("\n");
//            i++;
//        }
//    }

    public void display(){
        int i = 1;
        for (Vertices v: this.verticesList) {
            List<Task> taskList = v.taskList;
            System.out.println("Vertice " + i);
            for (Task t: taskList) {
                System.out.println(t.toString());
            }

            System.out.println("----- Duration: " + v.getDuration() + " ----- Experience: " + v.getExperience() + " ----- Assign: " + v.getAssignment());
            System.out.println("\n");
            i++;
        }
    }
    public void crossover() {

    }
}
