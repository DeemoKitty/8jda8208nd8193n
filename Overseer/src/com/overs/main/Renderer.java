package com.overs.main;

import com.overs.components.MainWindow;
import com.overs.components.Window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Renderer {

    private long window;

    private MainWindow test;

    public Renderer(long window){
        this.window = window;
        Display.GeneratePixels();

        test = new MainWindow(3, 3, Display.resX - 3, Display.resY - 3);
    }

    public void update(){
        if(glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_TRUE)
            glfwSetWindowShouldClose(window, true);

        test.update();
    }

    public void render(){

        test.display();

        Display.Update();
    }

    public void initLoop(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;
        while(!glfwWindowShouldClose(window)){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                glfwPollEvents();
                update();
                delta--;
            }

            if(!glfwWindowShouldClose(window)){
                glClear(GL_COLOR_BUFFER_BIT);
                glClearColor(.4f, .4f, .4f, 1);
                render();
                glfwSwapBuffers(window);
            }
        }
    }

}
