package com.example.alunoadm.atividadeaula;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class tela2 extends AppCompatActivity {
    Button toast;
    String mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String txt = bundle.getString("nome");
        TextView txtResultado = (TextView) findViewById(R.id.textView1);
        mensagem = "Bem vindo!! " + txt + " a aula de android.";
        txtResultado.setText(mensagem);

        toast = (Button)findViewById(R.id.toast);

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context contexto = getApplicationContext();
                int duracao = Toast.LENGTH_SHORT;

                Toast toast2 = Toast.makeText(contexto, mensagem, duracao);
                toast2.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            Intent intent = new Intent(tela2.this, tela3.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

}