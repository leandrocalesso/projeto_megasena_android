package com.lcc_megapremium.megapremium_lcc.Model.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
* Cuidará da 'criação' e 'atualização' do branco de dados.
* */
public class GerenciaDB extends SQLiteOpenHelper {

    private final static String NOME_DB    = "megaPremium.db";
    private final static int    DB_VERSION = 1;
    public static final String  TB_NOTI    = "tb_notificacao";
    public static final String  TB_SEQ     = "tb_sequencia";

    public GerenciaDB( Context context ){
        super( context, NOME_DB, null, DB_VERSION );

    }

    /*
    * Este método só é chamado quando o banco de dados não existe na aplicação.
    * Se terminar a sua execução com sucesso, o Android entende que o banco foi
    * criado com sucesso. A partir desse momento, o método onCreate não é nunca mais chamado.
    * */
    @Override
    public void onCreate(SQLiteDatabase db) {

       db.execSQL( "CREATE TABLE "+TB_SEQ+"("
                   +"_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                   +"SEQUENCIA TEXT, "
                   +"DATA_HORA TEXT, "
                   +"SEQ_OURO BOOLEAN, "
                   +"SEQ_ALEAT BOOLEAN"+")");

       db.execSQL( "CREATE TABLE "+TB_NOTI+"("
                  +"_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                  +"PROXIMO_SORTEIO NUMERIC, "
                  +"RESULTADO_JOGOS NUMERIC, "
                  +"ACOMULOU NUMERIC, "
                  +"MEUS_JOGOS NUMERIC, "
                  +"NOTIFICA_VALOR NUMERIC"+")" );

    }

    /*
    * Este método é chamado somente se a versão do construtor que marca a versão do banco de dados
    * é diferente da atual. Dentro desse método é onde deve ser feito a altercação do schema das
    * tabelas para a versão necessária.
    * */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
}
