package com.example.rush_hour.Model;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Player {

    //Attributes
    private String name;
    private int numberStars;
    private int reverse;
    private List<Integer> scoresList;
    private String id;

    //Constructor
    public Player (String name){
        this.name = name;
        scoresList = new ArrayList<>();
        initScoresList();
    }

    private void initScoresList(){
        for(int i = 0; i < 40; i++){
            scoresList.add(0);
        }
    }

    public void changeElement(int index, Integer value){

        if(scoresList.get(index) < value) {
            scoresList.set(index, value);
        }
    }

    public void setScoresList(List<Integer> scoresList){
        this.scoresList = scoresList;
    }

    //Default constructor
    public Player(){
        super();
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getNumberStars(){

        Integer totalStars = 0;

        for (Integer stars : scoresList){
            totalStars += stars;
        }

        numberStars = totalStars;
        reverse = -totalStars;
        return numberStars;
    }

    public int getReverse(){
        return reverse;
    }

    public String getId() {
        return id;
    }

    public List<Integer> getScoresList(){
        return scoresList;
    }

    //Setters
    public void setId(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", numberStars=" + numberStars +
                ", reverse=" + reverse +
                ", scoresList=" + scoresList +
                ", id='" + id + '\'' +
                '}';
    }
}
