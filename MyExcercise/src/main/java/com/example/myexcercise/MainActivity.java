package com.example.myexcercise;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BankAccount bac = new BankAccount();
        bac.setAccountNumber(1234);
        System.out.println("bac = " + bac.getAccountNumber());
        Account b = bac;
        System.out.println("MainActivity.onCreate");
        System.out.println("b = " + b.getAccountNumber());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
