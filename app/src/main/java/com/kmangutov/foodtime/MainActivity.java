package com.kmangutov.foodtime;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity implements TimeBar.TimeBarChangeListener{

    TextView textViewTop, textViewBottom;
    TimeBar timeBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTop = (TextView) findViewById(R.id.twHw);
        textViewBottom = (TextView) findViewById(R.id.tvBottom);
        timeBar = (TimeBar) findViewById(R.id.timeBar);
        timeBar.setTimeBarChangeListener(this);

    }

    public void TimeBarValueChanged(float selection, double topSelection, double bottomSelection) {
        textViewTop.setText("Top indicator position: " + topSelection);
        textViewBottom.setText("Bottom indicator position: " + bottomSelection);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
