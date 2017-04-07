package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Submission {
    private String student_number;
    private int week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        List<Integer> completedTasks = completedTasks();
        String returnString = "Viikko " + getWeek() + ": tehtyjä tehtäviä yhteensä: " 
                + completedTasks.size() + ", aikaa kului " + getHours() 
                + " tuntia, tehdyt tehtävät: ";
        int i = 0;
        while(i < completedTasks.size()) {
            if (i == completedTasks.size() - 1) {
                returnString += completedTasks.get(i);
                returnString += ".";
            } else {
                returnString += completedTasks.get(i) + " ";
            }
            i++;
        }
        return returnString;
    }
    
    public List<Integer> completedTasks() {
        List<Integer> tasks = new ArrayList<>();
        if (a1) tasks.add(1);
        if (a2) tasks.add(2);
        if (a3) tasks.add(3);
        if (a4) tasks.add(4);
        if (a5) tasks.add(5);
        if (a6) tasks.add(6);
        if (a7) tasks.add(7);
        if (a8) tasks.add(8);
        if (a9) tasks.add(9);
        if (a10) tasks.add(10);
        if (a11) tasks.add(11);
        if (a12) tasks.add(12);
        if (a13) tasks.add(13);
        if (a14) tasks.add(14);
        if (a15) tasks.add(15);
        if (a16) tasks.add(16);
        if (a17) tasks.add(17);
        if (a18) tasks.add(18);
        if (a19) tasks.add(19);
        if (a20) tasks.add(20);
        if (a21) tasks.add(21);
        return tasks;
    }
}