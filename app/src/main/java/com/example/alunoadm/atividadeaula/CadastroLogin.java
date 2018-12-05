package com.example.alunoadm.atividadeaula;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroLogin extends AppCompatActivity {

    private Button buttonSalvar;
    private EditText login;
    private EditText senha;
    private EditText confSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);

        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);
        confSenha = (EditText) findViewById(R.id.confSenha);

        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (senha.getText().toString().equals(confSenha.getText().toString())) {

                    CriaBancoDao banco = new CriaBancoDao(CadastroLogin.this, "BancoAndroid", null, 1);
                    banco.insertUser(login.getText().toString(), senha.getText().toString());


                    Toast.makeText(CadastroLogin.this, "Usuário Cadastrado com Sucesso!!!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(CadastroLogin.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(CadastroLogin.this, "Senhas não correspondem!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

