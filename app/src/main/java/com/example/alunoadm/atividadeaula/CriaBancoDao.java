package com.example.alunoadm.atividadeaula;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class CriaBancoDao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
    private static final String TABELA = "usuario";
    private static final String ID = "id";
    private static final String LOGIN = "login";
    private static final String SENHA = "senha";
    private static final int VERSAO = 1;

    public CriaBancoDao(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ TABELA +"("
                + ID + " integer primary key autoincrement,"
                + LOGIN + " text,"
                + SENHA + " text"
                + ")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }

    public void insertUser(String login, String senha){
        ContentValues valores = new ContentValues();
        valores.put("login", login);
        valores.put("senha", senha);
        getWritableDatabase().insert("usuario",null, valores);
    }

    public boolean authentication(String login, String senha){
        String sql="SELECT * FROM usuario WHERE login = '"+login+"' AND senha = '"+senha+"' ";
        Cursor cursor = getReadableDatabase().rawQuery(sql,null);

        if (cursor.getCount()==0){
            return false;
        }else{
            return true;
        }

    }
}
