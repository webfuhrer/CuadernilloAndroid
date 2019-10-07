package com.example.cuadernillo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv_puntuacion, tv_operando1, tv_operando2, tv_simbolo;
    Button btn_jugar, btn_comprobar;
    EditText et_resultado;
    Spinner spn_nivel;
    Operacion o;
    int puntuacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargaVistas();
        mostrarPantallaInicio();
        cargarOyentes();
    }

    private void cargarOyentes() {
        btn_jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar();
            }
        });
        btn_comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar();
            }
        });
    }

    private void comprobar() {
    int resultado_correcto=o.getResultado();
    int resultado_usuario=Integer.parseInt(et_resultado.getText().toString());
    if (resultado_correcto==resultado_usuario)
        {
            Toast.makeText(this, "Enhorabuena", Toast.LENGTH_LONG).show();
            puntuacion++;
            mostrarPuntuacion();
        }
        else
        {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show();
        }
        jugar();
    }

    private void mostrarPuntuacion() {
        tv_puntuacion.setText(String.valueOf(puntuacion));
    }

    private void jugar() {
        int opcion=spn_nivel.getSelectedItemPosition();
        o=Operacion.pedirOperacion(opcion);
        hacerVisible();
        tv_operando1.setText(String.valueOf(o.getOperando1()));
        tv_operando2.setText(String.valueOf(o.getOperando2()));
        tv_simbolo.setText(String.valueOf(o.getSimbolo()));

    }

    private void hacerVisible() {
        btn_comprobar.setEnabled(true);
        tv_operando1.setVisibility(View.VISIBLE);
        tv_operando2.setVisibility(View.VISIBLE);
        tv_simbolo.setVisibility(View.VISIBLE);
        et_resultado.setVisibility(View.VISIBLE);
    }

    private void mostrarPantallaInicio() {
        btn_comprobar.setEnabled(false);
        tv_operando1.setVisibility(View.INVISIBLE);
        tv_operando2.setVisibility(View.INVISIBLE);
        tv_simbolo.setVisibility(View.INVISIBLE);
        et_resultado.setVisibility(View.INVISIBLE);
    }

    private void cargaVistas()
    {
        tv_puntuacion=findViewById(R.id.tv_puntuacion);
        tv_operando1=findViewById(R.id.tv_operando1);
        tv_operando2=findViewById(R.id.tv_operando2);
        tv_simbolo=findViewById(R.id.tv_simbolo);
        btn_jugar=findViewById(R.id.btn_jugar);
        btn_comprobar=findViewById(R.id.btn_comprobar);
        et_resultado=findViewById(R.id.et_respuesta);
        spn_nivel=findViewById(R.id.spn_nivel);
    }
}
