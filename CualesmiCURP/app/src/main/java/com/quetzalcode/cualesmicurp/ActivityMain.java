package com.quetzalcode.cualesmicurp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.quetzalcode.cualesmicurp.modelo.Persona;
import com.quetzalcode.cualesmicurp.util.CURPUtil;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ActivityMain extends AppCompatActivity {

    private TextView lblNombre;
    private EditText txtNombre;
    private EditText txtPrimerApellido;
    private TextView lblPrimerApellido;
    private EditText txtSegundoApellido;
    private TextView lblSegundoApellido;
    private Spinner spnDiaDeNacimiento;
    private Spinner spnMesDeNacimiento;
    private TextView lblAñoDeNacimiento;
    private EditText txtAñoDeNacimiento;
    private Spinner spnSexo;
    private Spinner spnEstado;
    private TextView lblResultado;
    private Button btnGenerar;
    private Button btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        lblNombre = findViewById(R.id.lblNombre);
        txtNombre = findViewById(R.id.txtNombre);
        txtPrimerApellido = findViewById(R.id.txtPrimerApellido);
        lblPrimerApellido = findViewById(R.id.lblPrimerApellido);
        txtSegundoApellido = findViewById(R.id.txtSegundoApellido);
        lblSegundoApellido = findViewById(R.id.lblSegundoApellido);
        spnDiaDeNacimiento = findViewById(R.id.spnDiaDeNacimiento);
        spnMesDeNacimiento = findViewById(R.id.spnMesDeNacimiento);
        lblAñoDeNacimiento = findViewById(R.id.lblAñoDeNacimiento);
        txtAñoDeNacimiento = findViewById(R.id.txtAñoDeNacimiento);
        spnSexo = findViewById(R.id.spnSexo);
        spnEstado = findViewById(R.id.spnEstado);
        btnGenerar = findViewById(R.id.btnGenerar);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        lblResultado = findViewById(R.id.lblResultado);

        spnDiaDeNacimiento.setAdapter(listar(CURPUtil.DIAS));
        spnMesDeNacimiento.setAdapter(listar(CURPUtil.MESES));
        spnSexo.setAdapter(listar(CURPUtil.SEXOS));
        spnEstado.setAdapter(listar(CURPUtil.ESTADOS));

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarDatos()) {
                    generar();
                }
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }

    private ArrayAdapter<String> listar(String[] palabras) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(ActivityMain.this, android.R.layout.simple_spinner_item, palabras);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return arrayAdapter;
    }

    private void generar() {
        Persona persona = new Persona(
                txtNombre.getText().toString().trim(),
                txtPrimerApellido.getText().toString().trim(),
                txtSegundoApellido.getText().toString().trim(),
                spnDiaDeNacimiento.getSelectedItemPosition() + 1,
                spnMesDeNacimiento.getSelectedItemPosition() + 1,
                Integer.valueOf(txtAñoDeNacimiento.getText().toString()),
                spnSexo.getSelectedItem().toString(),
                spnEstado.getSelectedItem().toString()
        );

        Gson gson = new Gson();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Persona resultado = gson.fromJson(response, Persona.class);
                lblResultado.setText(resultado.getCurp());
                Toast.makeText(ActivityMain.this, "CURP generada.", Toast.LENGTH_LONG)
                        .show();
            }
        };
        Response.ErrorListener reponseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ActivityMain.this);
                alertDialogBuilder.setTitle("ERROR");
                alertDialogBuilder.setMessage("No podemos generar la CURP :(\n" + error.toString());
                alertDialogBuilder.create()
                        .show();
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                                                        CURPUtil.URL,
                                                        responseListener,
                                                        reponseErrorListener)
        {
            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return gson.toJson(persona).getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    Log.i("info", "Unsupported Encoding");
                    return null;
                }
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
        requestQueue.add(stringRequest);
    }

    private void generarfp() {
        Persona persona = new Persona(
                txtNombre.getText().toString().trim(),
                txtPrimerApellido.getText().toString().trim(),
                txtSegundoApellido.getText().toString().trim(),
                spnDiaDeNacimiento.getSelectedItemPosition() + 1,
                spnMesDeNacimiento.getSelectedItemPosition() + 1,
                Integer.valueOf(txtAñoDeNacimiento.getText().toString()),
                spnSexo.getSelectedItem().toString(),
                spnEstado.getSelectedItem().toString()
        );

        Gson gson = new Gson();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Persona resultado = gson.fromJson(response, Persona.class);
                lblResultado.setText(resultado.getCurp());
                Toast.makeText(ActivityMain.this, "CURP generada.", Toast.LENGTH_LONG)
                        .show();
            }
        };
        Response.ErrorListener reponseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ActivityMain.this);
                alertDialogBuilder.setTitle("ERROR");
                alertDialogBuilder.setMessage("No podemos generar la CURP :(\n" + error.toString());
                alertDialogBuilder.create()
                        .show();
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                CURPUtil.URL,
                responseListener,
                reponseErrorListener)
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("persona", gson.toJson(persona));
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
        requestQueue.add(stringRequest);
    }

    private boolean validarDatos() {
        boolean sonValidos;
        if (txtNombre.getText().toString().isEmpty()) {
            lblNombre.setTextColor(Color.RED);
            sonValidos = false;
        } else {
            lblNombre.setTextColor(Color.BLACK);
            sonValidos = true;
        }

        if (txtPrimerApellido.getText().toString().isEmpty()) {
            lblPrimerApellido.setTextColor(Color.RED);
            sonValidos = false;
        } else {
            lblPrimerApellido.setTextColor(Color.BLACK);
            sonValidos = true;
        }

        if (txtSegundoApellido.getText().toString().isEmpty()) {
            lblSegundoApellido.setTextColor(Color.RED);
            sonValidos = false;
        } else {
            lblSegundoApellido.setTextColor(Color.BLACK);
            sonValidos = true;
        }

        if (txtAñoDeNacimiento.getText().toString().isEmpty()
                || txtAñoDeNacimiento.getText().toString().length() < 4) {
            lblAñoDeNacimiento.setTextColor(Color.RED);
            sonValidos = false;
        } else {
            lblAñoDeNacimiento.setTextColor(Color.BLACK);
            sonValidos = true;
        }

        return sonValidos;
    }

    public void limpiar() {
        txtNombre.setText("");
        txtPrimerApellido.setText("");
        txtSegundoApellido.setText("");
        spnDiaDeNacimiento.setSelection(0);
        spnMesDeNacimiento.setSelection(0);
        txtAñoDeNacimiento.setText("");
        spnSexo.setSelection(0);
        spnEstado.setSelection(0);
        lblResultado.setText("");
        txtNombre.requestFocus();
    }
}