package com.example.async;

public class PlayCode {

    public static void main(String[] args){
        int min = 10;
        int max = 1000;
        for(int i=0; i<20; i++){
            System.out.println(getRandomNumber(min, max));
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
