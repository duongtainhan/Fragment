package com.example.duongtainhan555.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnChange;
    private boolean status =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Init
        Init();
        //Event Click
        btnChange.setText(R.string.change_b);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(status)
                {
                    Fragment fragmentA = new FragmentA();
                    CreateFragment(fragmentA);
                    status = false;
                    btnChange.setText(R.string.change_b);
                }
                else
                {
                    Fragment fragmentB = new FragmentB();
                    CreateFragment(fragmentB);
                    status = true;
                    btnChange.setText(R.string.change_a);
                }
            }
        });

    }
    private void Init()
    {
        btnChange = findViewById(R.id.btnChange);
    }
    private void CreateFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent,fragment);
        fragmentTransaction.commit();
    }
}
