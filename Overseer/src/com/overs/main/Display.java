package com.overs.main;

import com.overs.components.Font;
import com.overs.components.Pixel;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Display {
    public static int WIDTH, HEIGHT;

    private String title;

    private long windowHandle;

    public static int resX = 240;
    public static int resY = (resX * 9) / 12;

    private static Pixel pixels[][];

    private static Font font;

    public Display(int w, int h, String title){
        this.WIDTH = w;
        this.HEIGHT = h;
        this.title = title;
        this.font = new Font();
    }

    public long CreateWindow(){
        if(!glfwInit())
            throw new IllegalStateException("Could not initialize GLFW");

        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        windowHandle = glfwCreateWindow(WIDTH, HEIGHT, title, 0, 0);
        if(windowHandle == 0)
            throw new IllegalStateException("Could not create window");

        glfwSetWindowPos(windowHandle, (vidMode.width() - WIDTH) / 2, (vidMode.height() - HEIGHT) / 2);

        glfwMakeContextCurrent(windowHandle);
        glfwShowWindow(windowHandle);

        GL.createCapabilities();

        glViewport(0, 0, WIDTH, HEIGHT);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        //glOrtho(-HEIGHT, WIDTH, HEIGHT, -WIDTH, 1, -1);
        glOrtho(-WIDTH/2, WIDTH/2, HEIGHT/2, -HEIGHT/2, 1, -1);
        glMatrixMode(GL_MODELVIEW);

        return windowHandle;
    }

    public static void GeneratePixels(){
        float pW = WIDTH / resX;
        float pH = HEIGHT / resY;

        pixels = new Pixel[resX][resY];

        for(int x = 0; x < resX; x++){
            for(int y = 0; y < resY; y++){
                pixels[x][y] = new Pixel(x * pW, y * pH, pW, pH);
            }
        }


    }

    public static void Update(){
        for(int x = 0; x < pixels.length; x++){
            for(int y = 0; y < pixels[x].length; y++){
                Pixel temp = pixels[x][y];
                temp.Draw();
            }
        }

        glPushMatrix();
        glColor3f(0, 0.5f, 0.4f);
        glBegin(GL_QUADS);
        glVertex2f(WIDTH, HEIGHT);
        glVertex2f(WIDTH - 10, HEIGHT);
        glVertex2f(WIDTH - 10, HEIGHT - 10);
        glVertex2f(WIDTH, HEIGHT - 10);
        glEnd();
        glPopMatrix();
    }

    public static Pixel[][] GetSelectedPixels(int x, int y, int w, int h){
        Pixel[][] temp = new Pixel[w][h];
        int i = 0;
        for(int xx = x; xx < x + w; xx++){
            int k = 0;
            for(int yy = y; yy < y + h; yy++){
                temp[i][k] = pixels[xx][yy];
                k++;
            }
            i++;
        }
        return temp;
    }

    public static void MergePixels(Pixel[][] p, int x, int y){
        int w = p.length;
        int h = p[0].length;

        int i = 0;
        for(int xx = x; xx < x + w; xx++){
            int k = 0;
            for(int yy = y; yy < y + h; yy++){
                pixels[xx][yy] = p[i][k];
                k++;
            }
            i++;
        }
    }

    public static void printch(int x, int y, char c){
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

    public static void print(int x, int y, String str){
        int fs = font.GetFontSize();
        for(int i = 0; i < str.length(); i++){
            printch((x + i) * fs, y * fs, str.charAt(i));
        }
    }

    public void destroy(){
        glfwDestroyWindow(windowHandle);
        glfwTerminate();
    }
}
