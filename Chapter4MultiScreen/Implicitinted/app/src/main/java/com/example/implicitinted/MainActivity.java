package com.example.implicitinted; // Consider renaming to com.example.implicitintent if it's a typo

import android.net.Uri;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        url = findViewById(R.id.url);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlText = url.getText().toString();
                Toast.makeText(MainActivity.this, "URL: " + urlText, Toast.LENGTH_SHORT).show();

                // Ensure the URL has a proper scheme, e.g., "http://" or "https://"
//                Uri webpage = Uri.parse(urlText);
//                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(MainActivity.this, "No application can handle this request", Toast.LENGTH_SHORT).show();
//                }
                //to ope an email seding appp
                String [] address={"rohit@gmail.com" ,"rohit33i@gmail.com"};
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL,address);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Harry Subject");
                intent.putExtra(Intent.EXTRA_TEXT,urlText);
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent);
                }


            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
