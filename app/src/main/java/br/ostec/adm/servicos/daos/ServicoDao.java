package br.ostec.adm.servicos.daos;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.ostec.adm.servicos.model.Servico;

public class ServicoDao extends SQLiteOpenHelper {

    public ServicoDao(Context context) {
        super(context, "Orcamento", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE Servicos(";
        sql += "id INTEGER PRIMARY KEY, ";
        sql += "cliente TEXT, ";
        sql += "endereco TEXT, ";
        sql += "fone TEXT, ";
        sql += "dispositivo TEXT, ";
        sql += "obsdisp TEXT, ";
        sql += "servico TEXT, ";
        sql += "valor TEXT ";
        sql += ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    private ContentValues pegaDadosServico(Servico servico){
        ContentValues values = new ContentValues();
        values.put("cliente", servico.getCliente());
        values.put("endereco", servico.getEndereco());
        values.put("fone", servico.getFone());
        values.put("dispositivo", servico.getDispositivo());
        values.put("obsdisp", servico.getObsdisp());
        values.put("servico", servico.getServico());
        values.put("valor", servico.getValor());
        return values;
    }

    public void inserir(Servico servico){
        SQLiteDatabase db = getWritableDatabase();
        db.insert("Servicos", null, pegaDadosServico(servico));
    }

    public void editar(Servico servico){
        SQLiteDatabase db = getWritableDatabase();
        String where = "id = ?";
        String[] params = {servico.getId().toString()};
        db.update("Servicos", pegaDadosServico(servico), where, params);
    }

    public void deletar(Servico servico){
        SQLiteDatabase db = getWritableDatabase();
        String where = "id = ?";
        String[] params = {servico.getId().toString()};
        db.delete("Servicos", where, params);

    }


    public List<Servico> buscarTodos(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM Servicos";
        Cursor cursor = db.rawQuery(sql, null);
        List<Servico> servicos = new ArrayList<Servico>();
        while (cursor.moveToNext()){
            Servico servico = new Servico();
            servico.setId(cursor.getInt(cursor.getColumnIndex("id")));
            servico.setCliente(cursor.getString(cursor.getColumnIndex("cliente")));
            servico.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            servico.setFone(cursor.getString(cursor.getColumnIndex("fone")));
            servico.setDispositivo(cursor.getString(cursor.getColumnIndex("dispositivo")));
            servico.setObsdisp(cursor.getString(cursor.getColumnIndex("obsdisp")));
            servico.setServico(cursor.getString(cursor.getColumnIndex("servico")));
            servico.setValor(cursor.getString(cursor.getColumnIndex("valor")));

        }
        cursor.close();
        return servicos;
    }

}
