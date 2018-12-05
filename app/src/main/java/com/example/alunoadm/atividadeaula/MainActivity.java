package com.example.alunoadm.atividadeaula;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button botaoLogin;
    private Button creatUser;

    private EditText login;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);

        botaoLogin = (Button) findViewById(R.id.botaoLogin);
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CriaBancoDao banco = new CriaBancoDao(MainActivity.this, "BancoAndroid", null, 1);

                if (banco.authentication(login.getText().toString(), senha.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Sucess!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, tela2.class);

                    String aux;
                    aux = login.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("nome", aux);

                    intent.putExtras(bundle);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "Usuario ou Senha está invalido!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        creatUser = (Button) findViewById(R.id.creatUser);
        creatUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CadastroLogin.class);
                startActivity(intent);
            }
        });

    }
}
