package com.example.mizyner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Hacktober{
    public void hacktoberDemo(){
        System.out.println("This is HacktoberFest Demo);
    }
}

public class HomeActivity extends AppCompatActivity {
    LinearLayout card_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        card_view=findViewById(R.id.homedecor);

        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        card_view=findViewById(R.id.officedecor);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,OfficeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        card_view=findViewById(R.id.celdecor);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,CelebrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
