package com.lcc_megapremium.megapremium_lcc.Controller;

import android.content.Context;

import com.lcc_megapremium.megapremium_lcc.Model.Model_encontrar_concurso;
import com.lcc_megapremium.megapremium_lcc.Model.Model_gera_estatística;
import com.lcc_megapremium.megapremium_lcc.Model.Model_gera_sequencia;
import com.lcc_megapremium.megapremium_lcc.Model.Model_menu_ajuda;
import com.lcc_megapremium.megapremium_lcc.Model.Model_menu_doacao;
import com.lcc_megapremium.megapremium_lcc.Model.Model_menu_notificacoes;
import com.lcc_megapremium.megapremium_lcc.Model.Model_minha_chance;
import com.lcc_megapremium.megapremium_lcc.Model.Model_quanto_ja_gastei;
import com.lcc_megapremium.megapremium_lcc.Model.Model_verifica_sequencia;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Menu_notificacoes.Dados_notificacoes;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Gera_sequencia.Dados_gera;

import java.util.HashMap;
import java.util.List;

public abstract class  Recebe_requisicoes {


    // Categoria requisições entrada Activitys principais.
    public static boolean entrar_aquitivit_encontrar_concurso( String id_bt_principal_clicado ){

        boolean res = Model_encontrar_concurso.analiza_entrar_activity_servicos( id_bt_principal_clicado );
        return res;
    }
    public static boolean entrar_aquitivit_gerar_estatistica ( String id_bt_principal_clicado ){

        boolean res = Model_gera_estatística.analiza_entrar_activity_servicos( id_bt_principal_clicado );
        return res;
    }
    public static boolean entrar_aquitivit_gerar_sequencia   ( String id_bt_principal_clicado ){

        boolean res = Model_gera_sequencia.analiza_entrar_activity_servicos( id_bt_principal_clicado );
        return res;
    }
    public static boolean entrar_aquitivit_menu_ajuda        ( String id_bt_principal_clicado ){

        boolean res = Model_menu_ajuda.analiza_entrar_activity_servicos( id_bt_principal_clicado );
        return res;
    }
    public static boolean entrar_aquitivit_menu_doacao       ( String id_bt_principal_clicado ){

        boolean res = Model_menu_doacao.analiza_entrar_activity_servicos( id_bt_principal_clicado );
        return res;
    }
    public static boolean entrar_aquitivit_menu_notificacoes ( String id_bt_principal_clicado ){

        boolean res = Model_menu_notificacoes.analiza_entrar_activity_servicos( id_bt_principal_clicado );
        return res;
    }
    public static boolean entrar_aquitivit_minha_chance      ( String id_bt_principal_clicado ){

        boolean res = Model_minha_chance.analiza_entrar_activity_servicos( id_bt_principal_clicado );
        return res;
    }
    public static boolean entrar_aquitivit_quanto_ja_gastei  ( String id_bt_principal_clicado ){

        boolean res = Model_quanto_ja_gastei.analiza_entrar_activity_servicos( id_bt_principal_clicado );
        return res;
    }
    public static boolean entrar_aquitivit_verifica_sequencia( String id_bt_principal_clicado ){

        boolean res = Model_verifica_sequencia.analiza_entrar_activity_servicos( id_bt_principal_clicado );
        return res;
    }

    // ******************* Funçõe requisitantes de serviços das Activities. *******************

    // Requisições p/ pedido de serviços activity Gera_sequencia.
    public static String requi_gera_sequencia_aleatoria (){

        String sequencia_gerada = Model_gera_sequencia.func_model_gera_sequencia_aleatoria();

        return sequencia_gerada;
    }

    public static String requi_gera_sequencia_ouro (){

        String sequencia_gerada = Model_gera_sequencia.func_model_gera_sequencia_ouro();

        return sequencia_gerada;
    }


    // Requisições p/ pedido de serviços activity Verifica_sequencia.
    public static HashMap<String,Boolean> requi_verifica_validade_sequencia( List<Integer> sequencia_verificar ){

         HashMap<String,Boolean> seq_verificada = null;
         seq_verificada = Model_verifica_sequencia.valida_sequencia( sequencia_verificar );

         return seq_verificada;
    }

    // Requisições p/ pedido de serviços activity Menu_notificacoes.
    public static long requi_salva_notificacoes( Dados_notificacoes dados_gravar, Context ctx ){

        long res = Model_menu_notificacoes.model_salva_notificacoes( dados_gravar, ctx );

        return res;
    }
    // Requisições p/ pedido de serviços activity Gera_sequencia.
    public static long requi_salva_sequencia( Dados_gera dados_gravar, Context ctx ){

        long res = Model_gera_sequencia.model_salva_sequencia( dados_gravar, ctx );

        return res;
    }

    // ------------------------------------------------------------------------------------



}
