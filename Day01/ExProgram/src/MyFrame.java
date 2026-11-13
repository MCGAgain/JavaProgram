
//---- 获取真实可用窗口范围 ----
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

//---- 队列 ----
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JFrame;  //窗口



public class MyFrame {
    Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    int x = 100, y = 70, topy = bounds.y, topx = bounds.x;
    int dx = 20, dy = 15;
    int frameWidth = 200, frameHigh = 120;
    int initVx = 20, initVy = 0;
    final int g = 2;
    final int windowWidth = bounds.width;
    final int windowHigh = bounds.height;
    final int frameNum = 25;
    
    Queue<JFrame> queue = new ArrayDeque<>();

    void move() {
        initVy += g;
        x += initVx; y += initVy;
        if (x <= topx || x + frameWidth>= windowWidth) initVx = -initVx;
        if (y <= topy || y + frameHigh>= windowHigh) {
            if (y + frameHigh>= windowHigh) {
                initVy = -initVy;
                initVy -= 10;
            }
            else initVy = 10;
        }
    }

    void updateQueue() {
        JFrame curFrame = new JFrame("window");
        curFrame.setSize(frameWidth, frameHigh);
        curFrame.setLocation(x, y);
        curFrame.setVisible(true);

        queue.offer(curFrame);

        if (queue.size() > frameNum) {
            JFrame old = queue.poll();
            if (old != null) old.dispose(); 
        }
    }

    void run() {
        while (true) {
            move();
            updateQueue();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new MyFrame().run();
    }
}