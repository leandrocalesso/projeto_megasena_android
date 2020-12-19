package com.lcc_megapremium.megapremium_lcc.Views_tela_principal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lcc_megapremium.megapremium_lcc.R;

public class Menu_doacao extends Activity {

    private Button   botao_doacao;
    private TextView dados_doacao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_doacao);

        botao_doacao = findViewById( R.id.id_botao_doacao );
        dados_doacao = findViewById( R.id.id_textview_dados);

        botao_doacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( dados_doacao.getVisibility() == View.INVISIBLE )
                    dados_doacao.setVisibility( View.VISIBLE);
            }
        });
    }
}
