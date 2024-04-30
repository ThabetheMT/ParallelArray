package com.business;

import jdk.dynalink.linker.support.CompositeGuardingDynamicLinker;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] universities = {"TUT", "NMU", "UP", "UL", "WSU", "VUT", "UJ"};
        Integer[] judgeScores = {75, 65, 60, 55, 60, 70, 77};
        Integer[] onlineScores = new Integer[universities.length];
        Integer[] totalScore = new Integer[universities.length];
        onlineScores = populateOnlineScore(universities);
        totalScore = populateTotalScore(onlineScores, judgeScores);
        int winnerIndex = determineWinner(totalScore);

        System.out.println("Univiersities"+"\t"+"Judges score"+"\t"+"Online score"+"\t"+"Total score");
        String output = "";
        for(int i = 0; i < universities.length; i++){
            System.out.println(universities[i]+"\t\t\t\t"+judgeScores[i]+"\t\t\t\t"+onlineScores[i]+"\t\t\t\t"+totalScore[i]);
        }
        System.out.println("The Hackathon winners is " + universities[winnerIndex] + "\t" + "total score: " + totalScore[winnerIndex]);
    }
    //to populate the online score array
    public static Integer[] populateOnlineScore(String[] universities){
        Integer[] score = new Integer[universities.length];
            for(int i = 0; i < score.length; i++){
                score[i] = new Random().nextInt(100) + 5;
            }
            return score;
    }
    //populate total score
    public static Integer[] populateTotalScore(Integer[] onlineScore, Integer[] judgesScore){
        Integer[] totalScore = new Integer[onlineScore.length];
        for(int i = 0; i < onlineScore.length; i++){
            totalScore[i] = onlineScore[i] + judgesScore[i];
        }
        return totalScore;
    }
    //determine the highest total score
    public static int determineWinner(Integer[] totalScore){
        int index = 0;
        for(int i = 0; i < totalScore.length - 1; i++){
            if(totalScore[index] < totalScore[i]){
                index = i;
            }
        }
        return index;
    }
}