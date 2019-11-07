package com.example.thirdclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etPrincipal, etTime, etRate;
    Button btnCalculate;
    TextView txtInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.bindingControls();
        this.configureListeners();
    }

    private void bindingControls() {
        this.etPrincipal = findViewById(R.id.etPrincipalAmount);
        this.etRate = findViewById(R.id.etRate);
        this.etTime = findViewById(R.id.etTime);
        this.btnCalculate = findViewById(R.id.btnCalculate);
        this.txtInterest = findViewById(R.id.txtInterest);
    }

    private void configureListeners() {
        this.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float principal, rate, time, SI;
                principal = rate = time = SI = 0.0f;
                try {
                    principal = Float.parseFloat(etPrincipal.getText().toString());
                } catch (Exception error) {
                    etPrincipal.setError("Invalid Principal Amount!");
                }
                try {
                    rate = Float.parseFloat(etRate.getText().toString());
                } catch (Exception error) {
                    etPrincipal.setError("Invalid Rate!");
                }
                try {
                    time = Float.parseFloat(etTime.getText().toString());
                } catch (Exception error) {
                    etPrincipal.setError("Invalid Time!");
                }
                SI = (principal * time * rate) / 100f;
                txtInterest.setText(String.valueOf(SI));
            }
        });
    }

}
