package com.lcc_megapremium.megapremium_lcc.Model;

import com.lcc_megapremium.megapremium_lcc.Model.ENUM.EnumBotoesTelaPrincipal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class Model_verifica_sequencia {

    public static boolean analiza_entrar_activity_servicos( String id_tela ){

        boolean retorno = false;
        List<EnumBotoesTelaPrincipal> list_valor_constante = Arrays.asList( EnumBotoesTelaPrincipal.values() );
        for ( EnumBotoesTelaPrincipal constant : list_valor_constante ){
            if ( constant.getValor_constante().equals( id_tela ) ){
                retorno = true;
                break;
            }
        }
        return retorno;

    }
    public static HashMap<String,Boolean> valida_sequencia(List<Integer> sequencia_validar ){

        HashMap<String,Boolean> seq_validada;
        seq_validada = Model_gera_sequencia.valida_sequencia( sequencia_validar );

        return seq_validada;
    }

}
