package com.example.aplikasibiodata;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button keMaps , keTelepon , keEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keMaps = (Button)findViewById(R.id.btnAlamat);
        keTelepon = findViewById(R.id.btnTelepon);
        keEmail = findViewById(R.id.btnEmail);

        keMaps.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jalan+Taman+Semeru+2+No+32");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if(mapIntent.resolveActivity(getPackageManager())!=null)
                    startActivity(mapIntent);
            }
        });

        keTelepon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:087700535264"));
                startActivity(callIntent);
            }
        });

        keEmail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","triwaluyo433@gmail.com", null));
                startActivity(Intent.createChooser(intent, "Send mail.."));
            }
        });
    }



}
