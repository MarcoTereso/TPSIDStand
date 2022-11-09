package com.example.stand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CarrosCaros extends AppCompatActivity {
    Spinner sp;
    ImageView iv;
    public String carros [] = {"BMW","Ferrari","Mercedes Benz", "Porche"};
    public int imagens[] = {R.drawable.bmw,R.drawable.ferrari,R.drawable.mercedes,R.drawable.porche};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros_caros);

        sp = findViewById(R.id.spinnercaros);
        iv = findViewById(R.id.imagecaros);
        //carregar valores no array
        ArrayAdapter<String> valores = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,carros);

        sp.setAdapter(valores);
        //evento de seleção de valores
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                iv.setImageResource(imagens[i]);
                Toast.makeText(CarrosCaros.this, "Carro Selecionado:\n"+carros[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //inserir menu na app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menucarros,menu);
        menu.removeItem(R.id.btcaro);
        return super.onCreateOptionsMenu(menu);
    }
    //colocar botões a funcionar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.btsair){
            finish();
        }
        if(id == R.id.btbarato){
            Intent it = new Intent(CarrosCaros.this, CarrosBaratos.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.btemconta){
            Intent it = new Intent(CarrosCaros.this, CarrosMedios.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.volta){
            Intent it = new Intent(CarrosCaros.this, StandInfo.class);
            startActivity(it);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}