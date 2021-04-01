import java.io.FileNotFoundException;
import java.io.PrintStream;
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


    public void execute() throws FileNotFoundException, UnsupportedEncodingException {
        init();
        crossover();
        display();
        //write();
    }
    public void init() {

    }


    public void createOffspringPopulation() {

    }

    public void write() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("results.txt", "UTF-8");
        int i = 1;
        for (Vertices v: this.verticesList) {
            List<Task> taskList = v.taskList;
            writer.println("Vertice " + i);
            for (Task t: taskList) {
                writer.println(t.toString());
            }
            writer.println("----- Duration: " + v.duration() + " ----- Experience: " + v.experience() + " ----- Assign: " + v.assign());
            writer.println("-----------------------------------------------------------");
            i++;
        }
    }

    public void display() throws FileNotFoundException, UnsupportedEncodingException {
        int i = 1;
        for (Vertices v: this.verticesList) {
            List<Task> taskList = v.taskList;
            System.out.println("Vertice " + i);
            for (Task t: taskList) {
                System.out.println(t.toString());
            }
            System.out.println("----- Duration: " + v.duration() + " ----- Experience: " + v.experience() + " ----- Assign: " + v.assign());
            System.out.println("-----------------------------------------------------------");
            i++;
        }
    }
    public void crossover() {

    }

}
