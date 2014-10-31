package com.kmangutov.foodtime;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kmangutov on 10/29/14.
 */
public class TimeBar extends View {

    public TimeBar(Context context) {
        super(context);
    }

    public TimeBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    double selection = 0.0;
    private Bitmap topIndicator = BitmapFactory.decodeResource(getResources(),
            R.drawable.indicator);
    private Bitmap bottomIndicator = BitmapFactory.decodeResource(getResources(),
            R.drawable.indicator);
    private TimeBarChangeListener tcl;

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0xFF33B5E5);
        paint.setStrokeWidth(4);

        int barHeight = (int) (selection * getHeight());
        canvas.drawRect(0, barHeight, getWidth() / 2, getHeight(), paint);
        canvas.drawBitmap(topIndicator, getWidth() / 2, barHeight - topIndicator.getHeight() / 2, paint);
        canvas.drawBitmap(bottomIndicator, getWidth() / 2, getHeight() - bottomIndicator.getHeight() / 2, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0x000);
        canvas.drawLine(0, 0, getWidth(), getHeight(), paint);
        this.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("MOTIONEVENT", event.getX() + "," + event.getY());
                selection = event.getY() / getHeight();
                System.out.println("selection: " + selection);

        }

        if(tcl !=null){
            tcl.TimeBarValueChanged(event.getY());
        }

        return true;
    }

    interface TimeBarChangeListener {
        void TimeBarValueChanged(float topY);
    }

    public void setTimeBarChangeListener(TimeBarChangeListener tcl) {
        this.tcl = tcl;
    }
}
