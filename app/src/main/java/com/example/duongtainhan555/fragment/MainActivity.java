package com.example.duongtainhan555.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnChangeA, btnChangeB;
    private boolean status =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Init
        Init();
        //Event Click


    }
    public void ChangeFragment(View view)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (view.getId())
        {
            case R.id.btnChangeA:
                fragment = new FragmentA();

                break;
            case R.id.btnChangeB:
                fragment = new FragmentB();
                break;
        }
        fragmentTransaction.replace(R.id.frameContent,fragment);
        fragmentTransaction.commit();

    }
    private void Init()
    {
        btnChangeA = findViewById(R.id.btnChangeA);
        btnChangeB = findViewById(R.id.btnChangeB);
    }
    private void CreateFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent,fragment);
        fragmentTransaction.commit();
    }
}
