package com.example.kinito;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Objects;
import java.util.Random;



public class MainActivity extends AppCompatActivity {

    private String descriptionCappellino = "Il giocatore con il cappellino beve una tacca";
    private String descriptionKinito = "L'ultimo ad urlare 'kinito' beve una tacca";
    private String descriptionBiscuits = "L'ultimo ad urlare 'biscuits' beve una tacca";
    private String descriptionBrindisi = "Ogni giocatore beve una tacca";
    private String descriptionPrecedente = "Il giocatore precedente beve una tacca";
    private String descriptionSuccessivo = "Il giocatore successivo beve una tacca";
    private String descriptionHarryPotter = "Il giocatore con i dadi beve ogni cosa";
    private String descriptionTacche = "Il giocatore con i dadi deve assegnare le tacche ai giocatori";
    private String descriptionNullo = "I dadi passano al giocatore successivo";
    private ImageView diceImage1, diceImage2;
    private LottieAnimationView cappellino;
    private TextView tacche;
    private LottieAnimationView cappellino2;
    private ImageView goBack;
    private int val1, val2;
    private int harryPotter = 0;
    private int counter = 0;
    private long mLastClickTime = 0;
    private LottieAnimationView animationHarryPotter;
    private LottieAnimationView animationMessage;
    private LottieAnimationView animationTacche;
    private final View.OnClickListener diceClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            rotateDice();
            if(harryPotter==0) new Handler().postDelayed(threadRenderResult, 1000);
            else renderHarryPotter();
        }
    };


    private final View.OnClickListener cappellinoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            Toast toast = Toast.makeText(getApplicationContext(), descriptionCappellino, Toast.LENGTH_SHORT);
            toast.show();
        }
    };
    private final View.OnClickListener kinitoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            Toast toast = Toast.makeText(getApplicationContext(), descriptionKinito, Toast.LENGTH_SHORT);
            toast.show();
        }
    };
    private final View.OnClickListener biscuitsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            Toast toast = Toast.makeText(getApplicationContext(), descriptionBiscuits, Toast.LENGTH_SHORT);
            toast.show();
        }
    };
    private final View.OnClickListener precedenteListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            Toast toast = Toast.makeText(getApplicationContext(), descriptionPrecedente, Toast.LENGTH_SHORT);
            toast.show();
        }
    };
    private final View.OnClickListener successivoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            Toast toast = Toast.makeText(getApplicationContext(), descriptionSuccessivo, Toast.LENGTH_SHORT);
            toast.show();
        }
    };
    private final View.OnClickListener brindisiListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            Toast toast = Toast.makeText(getApplicationContext(), descriptionBrindisi, Toast.LENGTH_SHORT);
            toast.show();
        }
    };
    private final View.OnClickListener nulloListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            Toast toast = Toast.makeText(getApplicationContext(), descriptionNullo, Toast.LENGTH_SHORT);
            toast.show();
        }
    };
    private final View.OnClickListener taccheListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            Toast toast = Toast.makeText(getApplicationContext(), descriptionTacche, Toast.LENGTH_SHORT);
            toast.show();
        }
    };


    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //handle ad banner
        AdView adView = findViewById(R.id.adView);
        MobileAds.initialize(this, initializationStatus -> { });
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //find view elements
        goBack = findViewById(R.id.goBack);
        diceImage1 = findViewById(R.id.dice_first);
        diceImage2 = findViewById(R.id.dice_second);
        cappellino = findViewById(R.id.animationCappellino);
        cappellino2 = findViewById(R.id.animationCappellino2);
        tacche = findViewById(R.id.tacche);
        animationHarryPotter = findViewById(R.id.animationHarryPotter);
        animationMessage = findViewById(R.id.animationMessage);
        animationTacche = findViewById(R.id.animationTacche);

        Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        diceImage1.startAnimation(fadeInAnimation);
        diceImage2.startAnimation(fadeInAnimation);
        goBack.startAnimation(fadeInAnimation);

        goBack.setClipToOutline(true);
        diceImage1.setOnClickListener(diceClickListener);
        diceImage2.setOnClickListener(diceClickListener);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private final Runnable threadRenderResult = new Runnable() {
        public void run() {
            renderResult();
        }
    };

    private final Runnable threadReSetDiceClickListener = new Runnable() {
        public void run() {
            diceImage1.setOnClickListener(diceClickListener);
            diceImage2.setOnClickListener(diceClickListener);

        }
    };

    private final Runnable threadAnimationHarryPotter = new Runnable() {
        public void run() {
            diceImage1.setVisibility(View.INVISIBLE);
            animationHarryPotter.setVisibility(View.VISIBLE);
            animationHarryPotter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    backToNormal(false);
                }
            });

        }
    };

    private final Runnable threadDiceVisible = new Runnable() {
        public void run() {
            diceImage2.setVisibility(View.VISIBLE);

        }
    };

    private final Runnable threadDiceInvisible = new Runnable() {
        public void run() {
            ObjectAnimator fadeOut = ObjectAnimator.ofFloat(diceImage2, "alpha", 1f, 0f);
            fadeOut.setDuration(500);
            fadeOut.start();

        }
    };

    private final Runnable threadDiceVisibleFadeIn = new Runnable() {
        public void run() {
            ObjectAnimator fadeOut = ObjectAnimator.ofFloat(diceImage2, "alpha", 0f, 1f);
            fadeOut.setDuration(500);
            fadeOut.start();

        }
    };

    private final Runnable threadShowNullo = new Runnable() {
        public void run() {
            animationMessage.setAnimation(R.raw.animation_nullo);
            animationMessage.setVisibility(View.VISIBLE);
            animationMessage.setOnClickListener(nulloListener);
        }
    };

    private void rotateDice() {

        //housekeeping
        cappellino.setVisibility(View.INVISIBLE);
        cappellino2.setVisibility(View.INVISIBLE);
        cappellino.setOnClickListener(null);
        cappellino2.setOnClickListener(null);
        animationTacche.setVisibility(View.INVISIBLE);
        animationTacche.setOnClickListener(null);
        animationMessage.setVisibility(View.INVISIBLE);
        animationMessage.setOnClickListener(null);
        tacche.setVisibility(View.INVISIBLE);

        //compute next values
        val1 = random.nextInt(6)+1;
        val2 = random.nextInt(6)+1;

        //FORCE HARRY POTTER: comment these 4 after debug
        /*val1 = 2;
        val2 = 4;
        if(harryPotter==-1) val1=4;
        if(harryPotter==4) val1=2;*/

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);


        if(harryPotter==0){
            diceImage2.startAnimation(anim);
            diceImage1.startAnimation(anim);
        }
        else{
            diceImage1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotateharrypotter));
        }




        //show next values

        switch (val1){
            case 1: diceImage1.setImageResource(R.drawable.dice1); break;

            case 2: diceImage1.setImageResource(R.drawable.dice2); break;

            case 3: diceImage1.setImageResource(R.drawable.dice3); break;

            case 4: diceImage1.setImageResource(R.drawable.dice4); break;

            case 5: diceImage1.setImageResource(R.drawable.dice5); break;

            case 6: diceImage1.setImageResource(R.drawable.dice6); break;

        }

        switch (val2){
            case 1: diceImage2.setImageResource(R.drawable.dice1); break;

            case 2: diceImage2.setImageResource(R.drawable.dice2); break;

            case 3: diceImage2.setImageResource(R.drawable.dice3); break;

            case 4: diceImage2.setImageResource(R.drawable.dice4); break;

            case 5: diceImage2.setImageResource(R.drawable.dice5); break;

            case 6: diceImage2.setImageResource(R.drawable.dice6); break;

        }


    }

    private void renderResult(){
        boolean isCappellino=false;
        boolean isDouble=false;
        boolean vibrate=false;




        if(val1==3 || val2==3){
            cappellino.setVisibility(View.VISIBLE);
            cappellino.setOnClickListener(cappellinoListener);
            isCappellino=true;
            if(val1 == val2) {
                cappellino2.setVisibility(View.VISIBLE);
                cappellino2.setOnClickListener(cappellinoListener);
            }
        }


        //enter harry potter
        if((val1==2 && val2==4) || (val1==4 && val2==2)){
            new Handler().postDelayed(threadDiceInvisible, 500);
            harryPotter=-1;


            ObjectAnimator animation = ObjectAnimator.ofFloat(diceImage1, "translationX", 250f);
            diceImage2.setOnClickListener(null);
            diceImage1.setOnClickListener(null);
            animation.setDuration(1500);
            animation.start();
            new Handler().postDelayed(threadReSetDiceClickListener, 1500);

        }


        if(val1 == val2){
            isDouble=true;
            String x1, x2, x3, x4, x5, x6;
            x1="x1";x2="x2";x3="x3";x4="x4";x5="x5";x6="x6";
            animationTacche.setOnClickListener(taccheListener);
            switch(val1){
                case 1:
                    tacche.setText(x1);
                    tacche.setVisibility(View.VISIBLE);
                    animationTacche.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    tacche.setText(x2);
                    tacche.setVisibility(View.VISIBLE);
                    animationTacche.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    tacche.setText(x3);
                    tacche.setVisibility(View.VISIBLE);
                    animationTacche.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    tacche.setText(x4);
                    tacche.setVisibility(View.VISIBLE);
                    animationTacche.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    tacche.setText(x5);
                    tacche.setVisibility(View.VISIBLE);
                    animationTacche.setVisibility(View.VISIBLE);
                    break;
                case 6:
                    tacche.setText(x6);
                    animationTacche.setVisibility(View.VISIBLE);
                    tacche.setVisibility(View.VISIBLE);
                    break;
            }
        }

        switch(val1 + val2) {
            //kinito
            case 7:
                animationMessage.setAnimation(R.raw.animation_kinito);
                animationMessage.setVisibility(View.VISIBLE);
                animationMessage.setOnClickListener(kinitoListener);
                break;

            case 3:
                animationMessage.setAnimation(R.raw.animation_biscuits);
                animationMessage.setVisibility(View.VISIBLE);
                animationMessage.setOnClickListener(biscuitsListener);
                break;

            case 10:
                animationMessage.setAnimation(R.raw.brindisi_animation);
                animationMessage.setVisibility(View.VISIBLE);
                animationMessage.setOnClickListener(brindisiListener);
                break;

            case 9:
                animationMessage.setAnimation(R.raw.animation_previous);
                animationMessage.setVisibility(View.VISIBLE);
                animationMessage.setOnClickListener(precedenteListener);
                break;


            case 11:
                animationMessage.setAnimation(R.raw.animation_next);
                animationMessage.setVisibility(View.VISIBLE);
                animationMessage.setOnClickListener(successivoListener);
                break;


            default:
                if(!isCappellino && !isDouble && harryPotter==0) {
                    animationMessage.setAnimation(R.raw.animation_nullo);
                    animationMessage.setVisibility(View.VISIBLE);
                    animationMessage.setOnClickListener(nulloListener);
                }

        }





    }

    private void renderHarryPotter(){
        counter++;

        if(((harryPotter==2 && val1==4) || (harryPotter==4 && val1==2)) && counter==2 ){
            System.out.println("inside the harry potter animation");
            Toast toast = Toast.makeText(getApplicationContext(), descriptionHarryPotter, Toast.LENGTH_SHORT);
            toast.show();
            new Handler().postDelayed(threadAnimationHarryPotter, 1000);

            return;
        }
        if((val1 == 2 && harryPotter==-1) || (val1 == 4 && harryPotter==-1)){
            if(counter==1) harryPotter=val1;
        }

        else{
            backToNormal(true);
        }

    }

    public void  backToNormal(boolean showNullo){
        harryPotter=0;
        counter=0;
        ObjectAnimator animation = ObjectAnimator.ofFloat(diceImage1, "translationX", 0);
        diceImage2.setOnClickListener(null);
        diceImage1.setOnClickListener(null);
        animation.setDuration(1000);
        animation.start();
        new Handler().postDelayed(threadReSetDiceClickListener, 1000);
        new Handler().postDelayed(threadDiceVisible, 1000);
        animationHarryPotter.setVisibility(View.INVISIBLE);
        diceImage1.setVisibility(View.VISIBLE);
        diceImage2.setVisibility(View.VISIBLE);
        new Handler().postDelayed(threadDiceVisibleFadeIn, 500);

        //show nullo
        if(showNullo){
            new Handler().postDelayed(threadShowNullo, 800);
        }
        else{
            animationHarryPotter.setOnClickListener(null);

        }

    }
}