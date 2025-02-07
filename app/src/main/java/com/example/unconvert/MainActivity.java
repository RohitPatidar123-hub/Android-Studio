package com.example.unconvert;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;100
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView4;
    private EditText editTextText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView4 =findViewById(R.id.textView4);
        editTextText=findViewById(R.id.editTextText);
        button.setOnClickListener(new View.OnClickListener(){
                   @Override
                   public void onClick(View view){
                       Toast.makeText(MainActivity.this, "Input accept ", Toast.LENGTH_SHORT).show();
                       String s = editTextText.getText().toString();
                       int kg = Integer.parseInt(s);
                       double pound =2.205 * kg;
                       textView4.setText("The corresponding value in pound is " + pound);


                   }
         });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}