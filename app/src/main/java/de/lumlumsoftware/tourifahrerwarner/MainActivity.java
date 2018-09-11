package de.lumlumsoftware.tourifahrerwarner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    Button liveModeBtn;
    Button settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liveModeBtn = (Button)findViewById(R.id.liveModeBtn);
        liveModeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent liveModeIntent = new Intent(MainActivity.this, LiveModeActivity.class);
                startActivity(liveModeIntent);
            }
        });

        settingsBtn = (Button)findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });
    }
}
