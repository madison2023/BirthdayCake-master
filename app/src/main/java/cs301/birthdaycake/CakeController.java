package cs301.birthdaycake;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {


    private CakeView myCakeView;
    private CakeModel myCakeModel;

    public CakeController(CakeView cakeView) {
        myCakeView = cakeView;
        myCakeModel = myCakeView.getMyCakeModel();
    }

    @Override
    public void onClick(View view) {
        Log.d("blowOutButton", "click");
        myCakeModel.lit = false;
        myCakeView.invalidate();
    }

    //switch method
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        myCakeModel.hasCandles = isChecked;
        myCakeView.invalidate();
    }

    //seek bar methods
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        myCakeModel.numCandles = progress;
        myCakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void drawText(String text, float x, float y, Paint paint){

    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        myCakeModel.text = true;
        myCakeModel.x = motionEvent.getX();
        myCakeModel.y = motionEvent.getY();
        myCakeView.invalidate();

        return false;
    }
}
