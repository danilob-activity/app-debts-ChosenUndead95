package com.example.danilo.appdebts.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.danilo.appdebts.classes.Category;
import com.example.danilo.appdebts.classes.Debts;
import com.example.danilo.appdebts.database.ScriptDLL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 27/06/19.
 */

public class DebtsDAO {
    private SQLiteDatabase mConnection;
    public DebtsDAO(SQLiteDatabase conection){
        mConnection = conection;
    }
    public void insert(Debts deb){
        ContentValues contentValues = new ContentValues();
        contentValues.put("cod_cat",deb.getmCodCat() );
        contentValues.put("valor",deb.getValor() );
        contentValues.put("descricao",deb.getDescricao());
        contentValues.put("data_vencimento", String.valueOf(deb.getDataVencimento()));
        contentValues.put("data_pagamento", String.valueOf(deb.getDataPagamento()));

        mConnection.insertOrThrow("dividas",null,contentValues);
        Log.d("DebtsDAO", "Inserção realizada com sucesso");
    }
    public void remove(int id){
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        mConnection.delete("dividas","id = ?",params);
    }

    public void alter(Debts deb){
        ContentValues contentValues = new ContentValues();
        contentValues.put("cod_cat",deb.getmCodCat() );
        contentValues.put("valor",deb.getValor() );
        contentValues.put("descricao",deb.getDescricao());
        contentValues.put("data_vencimento", String.valueOf(deb.getDataVencimento()));
        contentValues.put("data_pagamento", String.valueOf(deb.getDataPagamento()));
        String[] params = new String[1];
        params[0] = String.valueOf(deb.getId());
        mConnection.update("dividas",contentValues, "id = ?",params);
    }

    public List<Debts> listDebts(){
        List<Debts> debts = new ArrayList<Debts>();
        Cursor result = mConnection.rawQuery(ScriptDLL.getDebts(), null);
        if(result.getCount() > 0){
            result.moveToFirst();
            do{
                Debts deb = new Debts();
                deb.setId(result.getInt(result.getColumnIndexOrThrow("id")));
                deb.setValor(result.getFloat(result.getColumnIndexOrThrow("valor")));
                deb.setDescricao(result.getString(result.getColumnIndexOrThrow("descricao")));
                deb.setDataVencimento(result.getString(result.getColumnIndexOrThrow("data_vencimento")));
                debts.add(deb);
                Log.d("DebtsDAO","Listando: "+deb.getId()+" - "+deb.getmCodCat()+ " - " + deb.getDescricao() + " - " + deb.getDataPagamento() + " - " + deb.getDataVencimento() );
            }while(result.moveToNext());
            result.close();
        }
        return debts;
    }
    public Debts getDebts(int id){
        Debts deb = new Debts();
        String[] params = new String[1];
        params[0] = String.valueOf(id);
        Cursor result = mConnection.rawQuery(ScriptDLL.getDebts(),params);
        if(result.getCount()>0){
            result.moveToFirst();
            deb.setId(result.getInt(result.getColumnIndexOrThrow("id")));
            deb.setValor(result.getFloat(result.getColumnIndexOrThrow("valor")));
            deb.setDescricao(result.getString(result.getColumnIndexOrThrow("descricao")));
            result.close();
            return  deb;
        }return  null;
    }
}
