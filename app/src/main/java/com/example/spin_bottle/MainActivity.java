package com.example.spin_bottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random random=new Random();//to genetrate any random number within a given bound
    private ImageView bottle;
    private int lastdir;//to store the last value of the rotation
    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle =findViewById(R.id.bottle);//for bottle image

    }
    public void spinbottle(View v)//main spinning method
    {
        if(!spinning)//so that click only works when the bottle is not spinning
        {
            int newdir=random.nextInt(2000);//to get every time new direction
            float intx=bottle.getWidth()/2;
            float inty=bottle.getHeight()/2;
            Animation rotate=new RotateAnimation(lastdir,newdir,intx,inty);
            rotate.setDuration(2500);//duration
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning=true;//on start of rotation set spinning to true
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning=false;//on stop set it to false
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            lastdir=newdir;//assign every time a new variable
            bottle.startAnimation(rotate);
        }
    }
}
