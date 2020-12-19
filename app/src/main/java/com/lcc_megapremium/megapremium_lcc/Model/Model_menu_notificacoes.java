package com.lcc_megapremium.megapremium_lcc.Model;

import android.content.Context;

import com.lcc_megapremium.megapremium_lcc.Model.DAO.Conexao_db;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Menu_notificacoes.Dados_notificacoes;
import com.lcc_megapremium.megapremium_lcc.Model.ENUM.EnumBotoesTelaPrincipal;

import java.util.Arrays;
import java.util.List;

public abstract class Model_menu_notificacoes {

    public static boolean analiza_entrar_activity_servicos( String id_menu ){

        boolean retorno = false;
        List<EnumBotoesTelaPrincipal> list_valor_constante = Arrays.asList( EnumBotoesTelaPrincipal.values() );
        for ( EnumBotoesTelaPrincipal constant : list_valor_constante ){
            if ( constant.getValor_constante().equals( id_menu ) ){
                retorno = true;
                break;
            }
        }
        return retorno;

    }

    //------------------------------------------------------------------------------------------------
    public static long model_salva_notificacoes( Dados_notificacoes dados_notificacoes, Context ctx ){

        Conexao_db conexao_db = new Conexao_db( ctx );
        long res = conexao_db.gravar_registro_notificacoes( dados_notificacoes );

        return res;
    }
}
