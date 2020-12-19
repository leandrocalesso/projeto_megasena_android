package com.lcc_megapremium.megapremium_lcc.Model.ENUM;

import android.widget.Button;

import com.lcc_megapremium.megapremium_lcc.R;

public enum EnumBotoesTelaPrincipal {

    BOTAO_1("id_bt_verifica_sequencia"),
    BOTAO_2("id_bt_gera_sequencia_ouro"),
    BOTAO_3("id_bt_gerar_estatistica"),
    BOTAO_4("id_bt_encontrar_concurso"),
    BOTAO_5("id_bt_quanto_ja_gastei"),
    BOTAO_6("id_bt_qual_minha_chance"),
    BOTAO_7("id_menu_notificacao"),
    BOTAO_8("id_menu_doacao"),
    BOTAO_9("id_menu_ajuda");

    String valor_constante;

    EnumBotoesTelaPrincipal(String valor_constante ){
        this.valor_constante = valor_constante;
    }

    public String getValor_constante() {
        return valor_constante;
    }

}
