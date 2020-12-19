package com.lcc_megapremium.megapremium_lcc.Views_tela_principal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.lcc_megapremium.megapremium_lcc.R;

import java.math.BigDecimal;
import java.util.Date;

public class Encontrar_concurso extends Activity {

    private int    num_concurso;
    private Date   data;
    private int[]  sequencia = new int[6];
    private int    num_ganhadores_quadra;
    private int    num_ganhadores_quina;
    private BigDecimal valor_mega;

    private Button bt_serv_encontrar_concurso;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_encontrar_concurso);

        bt_serv_encontrar_concurso = findViewById( R.id.id_bt_serv_encontrar_concurso);
        bt_serv_encontrar_concurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
