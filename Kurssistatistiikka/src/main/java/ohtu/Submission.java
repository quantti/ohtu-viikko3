package ohtu;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;
    private int maxPoints;
    
    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    public int getHours() {
        return hours;
    }

    public String getExercisesString() {
        String exercisesS = "";
        for (int exercise : exercises) {
            exercisesS += exercise + " ";
        }
        return exercisesS;
    }

    public int[] getExercises() {
        return exercises;
    }
    

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
    
    @Override
    public String toString() {
        return "viikko "+ week + ": tehtyjä tehtäviä yhteensä: " + this.exercises.length + " (maksimi " + getMaxPoints() + "), aikaa kului " + getHours() + " tuntia, tehdyt tehtävät: " + getExercisesString();
    }
    
}