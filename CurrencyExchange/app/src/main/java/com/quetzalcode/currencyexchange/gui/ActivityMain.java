package com.quetzalcode.currencyexchange.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.quetzalcode.currencyexchange.R;
import com.quetzalcode.currencyexchange.core.Exchanger;

import java.text.DecimalFormat;

public class ActivityMain extends AppCompatActivity {
    Exchanger exchanger;
    EditText txtDollarPrice;
    EditText txtQuantity;
    EditText txtTotal;
    Button btnDollarPrice;
    Button btnDollarToPeso;
//    Button btnPesoToDollar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        exchanger = new Exchanger();
        txtDollarPrice = findViewById(R.id.txtDollarPrice);
        txtQuantity = findViewById(R.id.txtQuantity);
        txtTotal = findViewById(R.id.txtTotal);
        btnDollarPrice = findViewById(R.id.btnDollarPrice);
        btnDollarToPeso = findViewById(R.id.btnDollarToPeso);
        btnDollarToPeso.setOnClickListener(new View.OnClickListener() { // One way
            @Override
            public void onClick(View view) {
                convertToPeso();
            }
        });
    }

    public void convertToPeso() {
        if (!areEmptyFields()) {
            double dollarPrice = Double.parseDouble(txtDollarPrice.getText().toString());
            double quantity = Double.parseDouble(txtQuantity.getText().toString());
            txtTotal.setText(new DecimalFormat("#.##").format(exchanger.convertDollarToPeso(dollarPrice, quantity)));
        } else {
            txtFieldsToZero();
        }
    }

    public void convertToDollar(View view) { // Another way
        if (!areEmptyFields()) {
            double dollarPrice = Double.parseDouble(txtDollarPrice.getText().toString());
            double quantity = Double.parseDouble(txtQuantity.getText().toString());
            txtTotal.setText(new DecimalFormat("#.##").format(exchanger.convertPesoToDollar(dollarPrice, quantity)));
        } else {
            txtFieldsToZero();
        }
    }

    private boolean areEmptyFields() {
        return (txtDollarPrice.getText().toString().isEmpty() ||
                txtQuantity.getText().toString().isEmpty());
    }

    private void txtFieldsToZero() {
        txtDollarPrice.setText("0.0");
        txtQuantity.setText("0.0");
        txtTotal.setText("0.0");
        Toast.makeText(ActivityMain.this, "Please fill empty fields!", Toast.LENGTH_LONG).show();
    }
}