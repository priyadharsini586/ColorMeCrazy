package com.nickteck.colormecrazy.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.nickteck.colormecrazy.R;
import com.nickteck.colormecrazy.database.DataBaseHandler;
import com.nickteck.htextview_base.HTextView;

public class SplashActivity extends AppCompatActivity {

    private HTextView lineTextView_1,lineTextView_2,lineTextView_3;
    int SPLASH_TIME_OUT = 2000;
    private DataBaseHandler dataBaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_activity);

        dataBaseHandler = new DataBaseHandler(getApplicationContext());
        init();


    }
    private void init() {
        lineTextView_1 = findViewById(R.id.text_1);
        lineTextView_2 = findViewById(R.id.text_2);
        lineTextView_3 = findViewById(R.id.text_3);
        lineTextView_1.animateText("COLOR ME");
        lineTextView_2.animateText("CRAZY");
        lineTextView_3.animateText("Unisex Salon & parlour");
        // Create a TypeFace using font from Assets folder
        Typeface mtypeFace = Typeface.createFromAsset(getAssets(),
                "Futura Md BT Bold.ttf");
        // set TypeFace to the TextView or Edittext
        lineTextView_1.setTypeface(mtypeFace);
        lineTextView_2.setTypeface(mtypeFace);
        lineTextView_3.setTypeface(mtypeFace);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (dataBaseHandler.checkTableIsEmpty()) {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                }else {
                    Intent intent = new Intent(SplashActivity.this, DashBoardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }


        }, SPLASH_TIME_OUT);
    }





}


