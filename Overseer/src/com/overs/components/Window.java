package com.overs.components;

import com.overs.main.Display;

public abstract class Window {

    protected int x, y, w, h;
    protected boolean border = true;

    protected Pixel[][] pixels;
    protected Font font;

    public Window(int x, int y, int w, int h, boolean border){
        this.x = x;
        this.y = y;
        this.w = w - x;
        this.h = h - y;
        this.border = border;

        font = new Font();
        pixels = Display.GetSelectedPixels(this.x, this.y, this.w, this.h);
    }

    public Window(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w - x;
        this.h = h - y;

        font = new Font();
        pixels = Display.GetSelectedPixels(this.x, this.y, this.w, this.h);
    }

    public abstract void update();

    public abstract void display();

    protected void drawBorder(){
        for(int x = 0; x < pixels.length; x++){
            for(int y = 0; y < pixels[x].length; y++){
                pixels[x][y].SetColor(1, 0, 0);
            }
        }
    }

    /*
     * TODO => Can cause issues later on with the "ArrayOutOfBounds" exception. Fix when possible
     */
    protected void wprintch(int x, int y, char c){
        String[] temp = font.GetChar(c);
        int i = 0;
        while(i < temp.length){
            String line = temp[i];
            for(int j = 0; j < line.length(); j++){
                if(line.charAt(j) == '#')
                    pixels[x+j][y+i].SetColor(1, 1, 1);
                else
                    pixels[x+j][y+i].SetColor(0, 0, 0);
            }
            i++;
        }
    }

    protected void wprint(int x, int y, String str){
        int fs = font.GetFontSize();
        for(int i = 0; i < str.length(); i++){
            wprintch((x + i) * fs, fs * y, str.charAt(i));
        }
    }
}
