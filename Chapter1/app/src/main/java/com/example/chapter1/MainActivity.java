package com.example.chapter1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText n1, n2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Hii Lavdoo..", Toast.LENGTH_SHORT).show();

        text = findViewById(R.id.text);
        button = findViewById(R.id.button);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);

        // Set up the button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get updated values inside the click listener
                String num1 = n1.getText().toString();
                String num2 = n2.getText().toString();

                // Check if the inputs are not empty
                if (!num1.isEmpty() && !num2.isEmpty()) {
                    try {
                        int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
                        text.setText("The sum is " + sum);
                    } catch (NumberFormatException e) {
                        text.setText("Invalid input! Please enter numbers.");
                    }
                } else {
                    text.setText("Please enter numbers!");
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
