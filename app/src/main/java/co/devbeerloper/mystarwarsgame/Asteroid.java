package co.devbeerloper.mystarwarsgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Asteroid implements Sprite {

    public static int initSizeWidth;
    public static int initSizeHeight;

    private float maxY;
    private float maxX;

    private boolean canCollide;
    private float speed;
    private float speedbase;
    private float positionX;
    private float positionY;
    private Bitmap[] sprites;
    private int actualSprite;
    Random random = new Random();


    public Asteroid(Context context, float screenWidth, float screenHeigth) {
        initSizeHeight = initSizeWidth = (random.nextInt(3) + 3) * (int) (screenWidth * 5 / 100);
        speed = (random.nextInt(3) + 1) * 4;
        speedbase = speed;
        sprites = new Bitmap[6];
        canCollide = true;

        //Getting bitmap from resource
        Bitmap originalBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.asteroid);
        sprites[0] = Bitmap.createScaledBitmap(originalBitmap, initSizeWidth, initSizeHeight, false);
        Bitmap kaboom1Bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.kaboom1);
        sprites[1] = Bitmap.createScaledBitmap(kaboom1Bitmap, initSizeWidth, initSizeHeight, false);
        Bitmap kaboom2Bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.kaboom2);
        sprites[2] = Bitmap.createScaledBitmap(kaboom2Bitmap, initSizeWidth, initSizeHeight, false);
        Bitmap kaboom3Bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.kaboom3);
        sprites[3] = Bitmap.createScaledBitmap(kaboom3Bitmap, initSizeWidth, initSizeHeight, false);
        Bitmap kaboom4Bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.kaboom4);
        sprites[4] = Bitmap.createScaledBitmap(kaboom4Bitmap, initSizeWidth, initSizeHeight, false);
        Bitmap blankBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.blank);
        sprites[5] = Bitmap.createScaledBitmap(blankBitmap, initSizeWidth, initSizeHeight, false);

        positionX = random.nextInt((int) screenWidth - initSizeWidth);
        positionY = -initSizeHeight;
        this.maxY = screenHeigth;
    }

    public void updateInfo() {

        positionY += speed;
        if (!canCollide) {
            actualSprite++;
        }
        if (actualSprite >= sprites.length) {
            positionY += maxY + speed + initSizeHeight;
            actualSprite--;
            return;
        }
    }

    public void setSpeed(float speed) {
        this.speed = speed + speedbase;
    }

    public void disableCollide() {
        canCollide = false;
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
    public int spriteSizeHeigth() {
        return initSizeHeight;
    }

    @Override
    public int spriteSizeWidth() {
        return initSizeWidth;
    }

    @Override
    public float speed() {
        return speed;
    }

    @Override
    public Bitmap spriteImage() {
        return sprites[actualSprite];
    }

    @Override
    public boolean canCollide() {
        return canCollide;
    }

}
