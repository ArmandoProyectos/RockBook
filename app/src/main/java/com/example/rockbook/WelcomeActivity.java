package com.example.rockbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    private View iwl, iwu, iws, iwa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        iwl = (ImageView) findViewById(R.id.imageViewLike);
        iwu = (ImageView) findViewById(R.id.imageViewUnlike);
        iws = (ImageView) findViewById(R.id.imageViewShare);
        iwa = (ImageView) findViewById(R.id.imageViewAdd);

        iwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this, "Me gusta", Toast.LENGTH_SHORT).show();
            }
        });

        iwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this, "No me gusta", Toast.LENGTH_SHORT).show();
            }
        });

        iws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(WelcomeActivity.this, "Compartir", Toast.LENGTH_SHORT).show();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        iwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }
}
