package edu.westga.tamikowilliamsstaticfragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.miko.tamikowilliamsstaticfragment.R;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.DataEntryListener, DataDisplayFragment.DataDisplayListener {

    private double numberOne;
    private double numberTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataEntry(Double a, Double b) {
        DataDisplayFragment displayFragment = (DataDisplayFragment)
                getSupportFragmentManager().findFragmentById(R.id.dataDisplayFragment);
        numberOne = a;
        numberTwo = b;
        displayFragment.displayProduct(a*b);

    }
    @Override
    public void onDataDisplay() {
        DataAddDisplayFragment displayFragment = (DataAddDisplayFragment)
                getSupportFragmentManager().findFragmentById(R.id.dataAddDisplayFragment);
        displayFragment.displayAddProduct(numberOne + numberTwo);
    }
}