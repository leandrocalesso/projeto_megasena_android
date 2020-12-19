package com.lcc_megapremium.megapremium_lcc.Model;

import android.util.Log;
import android.widget.Toast;

import com.lcc_megapremium.megapremium_lcc.Model.ENUM.EnumBotoesTelaPrincipal;
import com.lcc_megapremium.megapremium_lcc.R;

import java.util.Arrays;
import java.util.List;

public abstract  class Model_encontrar_concurso {

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

}
