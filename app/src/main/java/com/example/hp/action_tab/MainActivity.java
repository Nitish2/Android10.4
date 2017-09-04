package com.example.hp.action_tab;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/*
ActionBar.TabListener This interface was deprecated in API level 21.
Action bar navigation modes are deprecated and not supported by inline toolbar action bars.
*/

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //From your activity,you can retrieve an instance of ActionBar by calling getSupportActionBar()
        ActionBar actionBar = getSupportActionBar();


        actionBar.setNavigationMode(actionBar.NAVIGATION_MODE_TABS);

        //Adding tabs into the action bar
        actionBar.addTab(actionBar.newTab().setText("AUDIO") // Setting string to Tab 1
                .setTabListener(this));

        actionBar.addTab(actionBar.newTab().setText("VIDEO") //Setting string to Tab 2
                .setTabListener(this));
    }

    @Override
    //Creating onTabSelected () method. This method is called when a tab enters the selected state.
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        //  getPosition() method is used to set the current positions of both the tabs
        int currentTab=tab.getPosition();

        switch (currentTab) {
            case 0:
                setContentView(R.layout.audio_tab); // Initializing value in tab by ID.
                break;
            case 1:
                setContentView(R.layout.video_tab); // Initializing value in tab by ID.
                break;
        }

        }

    @Override
    // Creating onTabUnselected () method. It is called when a tab exits the selected state.
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
    @Override
    /*
     * Creating onTabReselected () method.
     * It is called when a tab that is already selected is chosen again by the user.
     * Some applications may use this action to return to the top level of a category.
     */
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Toast.makeText(this, tab.getText()+ " is Selected", Toast.LENGTH_LONG).show();

    }
}
