package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        CakeView cakeView = findViewById(R.id.cakeview);
        CakeController cakeController = new CakeController(cakeView);
        //blow out candles
        Button blowOut = findViewById(R.id.button2);
        blowOut.setOnClickListener(cakeController);
        //take away candles
        CompoundButton hasCandles = findViewById(R.id.switch1);
        hasCandles.setOnCheckedChangeListener(cakeController);
        //change num candles
        SeekBar candlesNum = findViewById(R.id.seekBar);
        candlesNum.setOnSeekBarChangeListener(cakeController);
        //draw balloon
        cakeView.setOnTouchListener(cakeController);


    }

    public void goodbye(View button) {
        //System.out.println("Goodbye");
        Log.i("button", "Goodbye");
        finishAffinity();
    }



}
