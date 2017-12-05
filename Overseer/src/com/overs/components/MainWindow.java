package com.overs.components;

import com.overs.main.Display;

public class MainWindow extends Window {

    public MainWindow(int x, int y, int w, int h){
        super(x, y, w, h);
    }

    public MainWindow(int x, int y, int w, int h, boolean border){
        super(x, y, w, h, border);
    }

    @Override
    public void update() {

    }

    @Override
    public void display() {
        if(border)
            drawBorder();

        wprint(0, 0, "HELLO WORLD!");

        Display.MergePixels(pixels, x, y);
    }
}
