package com.bantanger.tank03_;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class Shot implements Runnable{
    int x;
    int y;
    int direct = 0;
    int speed = 2;
    boolean isLive = true; // 判断子弹是否存活,决定子弹是否继续运动

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() { // 射击行为
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 根据方向来改变x,y坐标
            switch (direct){
                case 0://向上
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            // 子弹边界处理
            if (!(x >= 0 && x<= 1000 && y >= 0 && y <= 750)){
                isLive = false;
                break;
            }
        }
    }
}
