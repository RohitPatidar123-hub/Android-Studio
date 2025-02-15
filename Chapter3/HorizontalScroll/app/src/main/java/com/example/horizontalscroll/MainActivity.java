package com.example.horizontalscroll;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // ✅ Call super first
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // ✅ Set layout before findViewById

        Button button = findViewById(R.id.submit); // ✅ Now it will not be null
        if (button != null) { // ✅ Always check if findViewById returns null
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Harry", "This button is working properly");
                }
            });
        } else {
            Log.e("MainActivity", "Button with ID 'submit' not found in layout!");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
