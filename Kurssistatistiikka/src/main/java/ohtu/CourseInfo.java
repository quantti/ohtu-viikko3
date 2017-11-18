/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author kari
 */
class CourseInfo {
    private String name;
    private String term;
    private int[] exercises;

    public String getName() {
        return name;
    }

    public int[] getExercises() {
        return exercises;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

//    public void setTerm(String term) {
//        this.term = term;
//    }


    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }
    
    
}
