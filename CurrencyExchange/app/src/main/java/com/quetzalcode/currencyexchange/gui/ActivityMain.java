package com.quetzalcode.currencyexchange.gui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.quetzalcode.currencyexchange.R;
import com.quetzalcode.currencyexchange.core.Exchanger;

import java.text.DecimalFormat;
import java.util.Date;

public class ActivityMain extends AppCompatActivity {
    Exchanger exchanger;
    EditText txtDollarPrice;
    EditText txtQuantity;
    EditText txtTotal;

    Button btnShareTo;
    Button btnDollarPrice;
    Button btnDollarToPeso;
//    Button btnPesoToDollar;

    private static final String URL = "https://v6.exchangerate-api.com/v6/f0b0fc7f3f7680c84b0d9266/latest/USD";

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
        btnShareTo = findViewById(R.id.btnShareTo);
        btnDollarPrice = findViewById(R.id.btnDollarPrice);
        btnDollarToPeso = findViewById(R.id.btnDollarToPeso);
        btnDollarToPeso.setOnClickListener(new View.OnClickListener() { // One way
            @Override
            public void onClick(View view) {
                convertToPeso();
            }
        });
        btnDollarPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDollarPrice();
            }
        });
        btnShareTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareDollarPrice();
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

    private void getDollarPrice() {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JsonObject jsonObject = JsonParser.parseString(response)
                        .getAsJsonObject();
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                double dollarPrice = conversionRates.get("MXN").getAsDouble();
                txtDollarPrice.setText(Double.toString(dollarPrice));
                Toast.makeText(ActivityMain.this, "MXN dollar price has been updated.", Toast.LENGTH_LONG)
                        .show();
            }
        };
        Response.ErrorListener reponseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ActivityMain.this);
                alertDialogBuilder.setTitle("ERROR");
                alertDialogBuilder.setMessage("Cannot get the dollar price :(\n" + error.toString());
                alertDialogBuilder.create()
                        .show();
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, responseListener, reponseErrorListener);
        RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
        requestQueue.add(stringRequest);
    }

    public void shareDollarPrice() {
        Date date = new Date();
        String message = date.toString() + " 1 USD IS " + txtDollarPrice.getText().toString() + " MXN ";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}