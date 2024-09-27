package classSchedule;

import java.util.Scanner;

public class scheduleRep {
    public static void main(String[] args) {
        Scanner reader= new Scanner(System.in);
        System.out.println("\nClasses: ");
        String[] classes = reader.nextLine().split(", ");
        scheduleGraph schedulegraph = new scheduleGraph();
        schedulegraph.addClasses(classes);
        System.out.println("\nConflicting classes(cannot occur simultaneously):");
        while(reader.hasNextLine()){
            String [] conflict = reader.nextLine().split("-");
            if(conflict.length==1) break;
            schedulegraph.addConflict(conflict);
        }
        System.out.println("\nOptimized Class Schedule:");
        schedulegraph.assignColors();
        reader.close();
    }
}
