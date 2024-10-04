package com.example.formvalidationapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private Button buttonSubmit;
    private EditText editTextHaslo;
    private EditText editTextPowHaslo;

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextHaslo = findViewById(R.id.editTextHaslo);
        editTextPowHaslo = findViewById(R.id.editTextPowHaslo);
        buttonSubmit = findViewById(R.id.buttonSubmit);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {;
            @Override
                    public void onClick(View v){
            String name = editTextName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String haslo = editTextHaslo.getText().toString().trim();
            String powhaslo = editTextPowHaslo.getText().toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
            } else if (email.isEmpty()) {
                Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
            } else if (haslo.length() < 6) {
                Toast.makeText(MainActivity.this, "Hasło zawiera mniej niż 6 znaków", Toast.LENGTH_SHORT).show();
            } else if (!haslo.equals(powhaslo)) {
                Toast.makeText(MainActivity.this, "Hasła są niezgodne", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Formularz przełany poprawnie", Toast.LENGTH_SHORT).show();
            }
        }
    });
}
}