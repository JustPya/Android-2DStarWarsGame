package co.devbeerloper.mystarwarsgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Cloud implements Sprite {

    public static int initSizeWidth;
    public static int initSizeHeight;

    private float speed;
    private float speedbase;
    private float positionX;
    private float positionY;
    private Bitmap spriteImage;
    Random random = new Random();


    public Cloud(Context context, float screenWidth, float screenHeigth, boolean isPlaying) {
        initSizeHeight = initSizeWidth = (random.nextInt(3) + 1) * (int) (screenWidth / 100);
        if (isPlaying)
            speedbase = random.nextInt(3) * 3 + 2;
        else
            speedbase = random.nextInt(3) + 1;

        speed = speedbase;
        positionY = -initSizeHeight;
        positionX = random.nextInt((int) screenWidth - initSizeWidth);
        //Getting bitmap from resource
        Bitmap originalBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.cloud);
        spriteImage = Bitmap.createScaledBitmap(originalBitmap, initSizeWidth, initSizeHeight, false);


    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed + speedbase;
    }

    public void setSpriteCloud(Bitmap spriteIcecreamCar) {
        this.spriteImage = spriteIcecreamCar;
    }

    public void updateInfo(boolean isPlaying) {
        if (isPlaying && speed < 4)
            speedbase = random.nextInt(3) * 3 + 2;
        this.positionY += speed;
    }


    @Override
    public int spriteSizeWidth() {
        return spriteImage.getWidth();
    }

    @Override
    public int spriteSizeHeigth() {
        return spriteImage.getHeight();
    }

    @Override
    public float positionX() {
        return positionX;
    }

    @Override
    public float positionY() {
        return positionY;
    }

    @Override
    public float speed() {
        return speed;
    }

    @Override
    public Bitmap spriteImage() {
        return spriteImage;
    }

    @Override
    public boolean canCollide() {
        return true;
    }
}
