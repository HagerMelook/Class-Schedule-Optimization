package classSchedule;

import java.util.ArrayList;
import java.util.HashMap;

public class scheduleGraph {
    String [] possibleColors = new String[50];
    HashMap<Character,String> colors = new HashMap<>();
    HashMap<Character,ArrayList<Character>> conflicts = new HashMap<>();
    public void addClasses(String [] classes){
        for(String className: classes){
            ArrayList <Character> conflictedClasses = new ArrayList<>();
            conflicts.put(className.charAt(0), conflictedClasses);
            colors.put(className.charAt(0),null);
        }
    }
    public void addConflict(String[] conflict){
        ArrayList <Character> conflictedClasses = conflicts.get(conflict[0].charAt(0));
        if(!conflicts.containsKey(conflict[0].charAt(0))){
            System.out.println("class "+conflict[0].charAt(0)+" is not found !!");
            return;
        }
        if(!conflicts.containsKey(conflict[1].charAt(0))){
            System.out.println("class "+conflict[1].charAt(0)+" is not found !!");
            return;
        }
        conflictedClasses.add(conflict[1].charAt(0));
        conflictedClasses = conflicts.get(conflict[1].charAt(0));
        conflictedClasses.add(conflict[0].charAt(0));
    }
    public void assignColors(){
        colorInitialization();
        for(char classColor: colors.keySet()){
            if(colors.get(classColor)==null){
                ArrayList <Character> conflictedClasses = conflicts.get(classColor);
                boolean flag;
                for(String color: possibleColors){
                    flag = true;
                    for(char conflicted_class: conflictedClasses){
                        if(colors.get(conflicted_class)==color){
                            flag = false;
                            break;
                        }
                    }
                    if(flag == true){
                        colors.replace(classColor, null, color);
                        break;
                    }
                }
            }
        }
        for(char Class: conflicts.keySet()){
            System.out.print(Class+" - ");
            System.out.println(colors.get(Class));
        }
    }

    private void colorInitialization(){
        possibleColors[0]="Red";
        possibleColors[1]= "Blue";
        possibleColors[2]="Green";
        possibleColors[3]="Brown";
        possibleColors[4]="Pink";
        possibleColors[5]= "Black";
        possibleColors[6]="Lavender";
        possibleColors[7]="Yellow";
        possibleColors[8]="Wight";
        possibleColors[9]="Orange";
        possibleColors[10]="Rose";
        possibleColors[11]= "Sky";
        possibleColors[12]="Lime";
        possibleColors[13]="Coffee";
        possibleColors[14]="Watermelon";
        possibleColors[15]= "Steel";
        possibleColors[16]="Purple";
        possibleColors[17]="Latte";
        possibleColors[18]="Mauve";
        possibleColors[19]="Gold";
        possibleColors[20]="Blush";
        possibleColors[21]= "Navy";
        possibleColors[22]="Mint";
        possibleColors[23]="Caramel";
        possibleColors[24]="Peach";
        possibleColors[25]= "Salmon";
        possibleColors[26]="Magenta";
        possibleColors[27]="Beige";
        possibleColors[28]="Gray";
        possibleColors[29]="Honey";
        possibleColors[30]="Duke blue";
        possibleColors[31]= "Dutch White";
        possibleColors[32]="Deep Taupe";
        possibleColors[33]="Deep cerise";
        possibleColors[34]="Dark slate gray";
        possibleColors[35]= "corn";
        possibleColors[36]="Copper red";
        possibleColors[37]="Citron";
        possibleColors[38]="Chocolate";
        possibleColors[39]="Canary";
        possibleColors[40]="British racing green";
        possibleColors[41]= "Blue Sapphire";
        possibleColors[42]="Blanched";
        possibleColors[43]="Aqua";
        possibleColors[44]="Finn";
        possibleColors[45]= "SMASHED PUMPKIN";
        possibleColors[46]="Sepia";
        possibleColors[47]="Silver";
        possibleColors[48]="Frost";
        possibleColors[49]="Cotton";
    }
}
