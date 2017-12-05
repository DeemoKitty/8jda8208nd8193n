package com.overs.components;

import static org.lwjgl.opengl.GL11.*;

public class Pixel {
    private float x, y;
    private float width, height;
    private float color[];

    public Pixel(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = new float[]{ 0, 0, 0 };
    }

    public void Draw(){
        glColor3f(color[0], color[1], color[2]);
        glBegin(GL_QUADS);
        {
            glVertex2f(x, y);
            glVertex2f(x + width, y);
            glVertex2f(x + width, y + height);
            glVertex2f(x, y + height);
        }
        glEnd();
    }

    public void SetColor(float[] color){ this.color = color; }
    public void SetColor(float r, float g, float b){
        this.color = new float[]{
                r, g, b
        };
    }

    public float[] GetColor() { return color; }
}
