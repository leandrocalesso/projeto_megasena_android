package com.lcc_megapremium.megapremium_lcc.Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Menu_notificacoes.Dados_notificacoes;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Gera_sequencia.Dados_gera;

public class Conexao_db {

    private SQLiteDatabase    db; // // Representa meu 'banco de dados'.

    public Conexao_db(Context ctx ){

        GerenciaDB gerenciaDB = new GerenciaDB( ctx );
        db = gerenciaDB.getWritableDatabase();
    }

    // ---------------------------------------------------------------------------------
    /*
      Médo insert() de SQLiteDatabase.
    * Retorna a identificação do registro se a inserção deu certo.
    * Retorna -1 se a inserção deu errado.
    * */
    public long gravar_registro_notificacoes ( Dados_notificacoes dados_gravar ){

        ContentValues contentValues = new ContentValues();
        contentValues.put( "PROXIMO_SORTEIO",dados_gravar.isProximo_sorteio() );
        contentValues.put( "RESULTADO_JOGOS",dados_gravar.isResultado_sorteio() );
        contentValues.put( "ACUMULOU",dados_gravar.isAcumulado() );
        contentValues.put( "MEUS_JOGOS",dados_gravar.isMeus_jogos() );
        contentValues.put( "NOTIFICA_VALOR",dados_gravar.isValor_premio() );

        long res;
        res = db.insert( GerenciaDB.TB_NOTI,null,contentValues );

        return res;
    }
    public long gravar_registro_gera_sequencia ( Dados_gera dados_gravar ){

        ContentValues contentValues = new ContentValues();
        contentValues.put( "SEQUENCIA",dados_gravar.getSequencia_salvar() );
        contentValues.put( "DATA_HORA",dados_gravar.getData_hora() );
        contentValues.put( "SEQ_OURO",dados_gravar.isSeq_ouro() );
        contentValues.put( "SEQ_ALEAT",dados_gravar.isSeq_aleat() );

        long res;
        res = db.insert( GerenciaDB.TB_NOTI,null,contentValues );

        return res;
    }

    // ---------------------------------------------------------------------------------

    public void excluir_registro(){

    }
    public void alterar_registro(){


    }

}

