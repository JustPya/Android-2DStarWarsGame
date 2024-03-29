package co.devbeerloper.mystarwarsgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Player implements Sprite {

    public static final float INIT_X = 100;
    private final float INIT_Y = 100;
    private int initSizeWidth = 150;
    private int initSizeHeight = 150;

    private float maxY;
    private float maxX;

    private boolean canCollide;
    private float speed = 0;
    private float positionX;
    private float positionY;
    private Bitmap[] sprites;
    private int actualSprite;
    Random random = new Random();


    public Player(Context context, float screenWidth, float screenHeigth) {
        initSizeWidth = initSizeHeight = (int) screenWidth * 15 / 100;
        speed = 0;
        sprites = new Bitmap[8];
        actualSprite = 0;
        canCollide =true;

        //Getting bitmap from resource
        Bitmap originalBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xwing);
        sprites[0] = Bitmap.createScaledBitmap(originalBitmap, initSizeWidth, initSizeHeight, false);
        Bitmap leftBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xwing1);
        sprites[1] = Bitmap.createScaledBitmap(leftBitmap, initSizeWidth, initSizeHeight, false);
        Bitmap rightBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xwing2);
        sprites[2] = Bitmap.createScaledBitmap(rightBitmap, initSizeWidth, initSizeHeight, false);
        Bitmap kaboom1Bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.kaboom1);
        sprites[3] = Bitmap.createScaledBitmap(kaboom1Bitmap, initSizeWidth, initSizeHeight, false);
        Bitmap kaboom2Bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.kaboom2);
        sprites[4] = Bitmap.createScaledBitmap(kaboom2Bitmap, initSizeWidth, initSizeHeight, false);
        Bitmap kaboom3Bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.kaboom3);
        sprites[5] = Bitmap.createScaledBitmap(kaboom3Bitmap, initSizeWidth, initSizeHeight, false);
        Bitmap kaboom4Bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.kaboom4);
        sprites[6] = Bitmap.createScaledBitmap(kaboom4Bitmap, initSizeWidth, initSizeHeight, false);
        Bitmap blankBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.blank);
        sprites[7] = Bitmap.createScaledBitmap(blankBitmap, initSizeWidth, initSizeHeight, false);

        positionX = screenWidth / 2 - sprites[0].getWidth() / 2;
        positionY = screenHeigth * 90 / 100 - sprites[0].getHeight();
        this.maxX = screenWidth - sprites[0].getWidth();
    }


    public void updateInfo(long actualTime) {
        if (!canCollide) {
            actualSprite++;
        }
        if (actualSprite >= sprites.length) {
            actualSprite--;
            return;
        }

        if (positionX + speed > 0 && positionX + speed < maxX)
            positionX += speed;
        if (speed != 0)
            if (actualTime % 200 < 100)
                actualSprite = 1;
            else
                actualSprite = 2;
    }


    public void disableCollide() {
        canCollide = false;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
