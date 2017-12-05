package com.overs.main;

public class Main {

    public static final int WIDTH = 800, HEIGHT = 480;

    private Display d;
    private Renderer r;

    Main(){
        d = new Display(WIDTH, HEIGHT, "overSEEr");
        r = new Renderer(d.CreateWindow());
        r.initLoop();

        d.destroy();
    }

    public static void LOG(String text) { System.out.println(text); }

    public static void main(String... args){
        new Main();
    }
}
