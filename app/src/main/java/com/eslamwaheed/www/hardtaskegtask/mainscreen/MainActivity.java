package com.eslamwaheed.www.hardtaskegtask.mainscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.eslamwaheed.www.hardtaskegtask.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_frame, mainFragment)
                .commit();
    }

}
