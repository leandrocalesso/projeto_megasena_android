package com.lcc_megapremium.megapremium_lcc.Views_tela_principal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.lcc_megapremium.megapremium_lcc.Controller.Recebe_requisicoes;
import com.lcc_megapremium.megapremium_lcc.R;

import java.text.NumberFormat;
import java.util.Locale;

public class Menu_notificacoes extends Activity {

    private Button bt_salva_notificacoes;
    //-------------------------
    private CheckBox proximo_sorteio;
    private CheckBox resultado_sorteio;
    private CheckBox acumulado;
    private CheckBox meus_jogos;
    private CheckBox valor_premio;
    //------------------------
    private SeekBar seekbar_notifica_valor_premio;
    //------------------------
    private EditText valor_para_notificar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_notificacoes);

        bt_salva_notificacoes = (Button) findViewById( R.id.id_bt_serv_salva_notificacoes);
        //------------------------------------------------------------------------
        proximo_sorteio   = ( CheckBox ) findViewById( R.id.checkBox_proximo_sorteio_notificacoes);
        resultado_sorteio = ( CheckBox ) findViewById( R.id.checkBox_resultado_sorteio_notificacoes );
        acumulado         = ( CheckBox ) findViewById( R.id.checkBox_acumulado_notificacoes );
        meus_jogos        = ( CheckBox ) findViewById( R.id.checkBox_meus_jogos_notificacoes );
        valor_premio      = ( CheckBox ) findViewById( R.id.checkBox_valorpremio_notificacoes );
        //------------------------------------------------------------------------
        seekbar_notifica_valor_premio = ( SeekBar ) findViewById( R.id.seekBar_1_notificacoes );
        //------------------------------------------------------------------------
        valor_para_notificar = ( EditText ) findViewById( R.id.editText_notifica_valorpremio_notificacoes );

        seekbar_notifica_valor_premio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                String valor_com_mascara = coloca_mascara_financeira_valor( progress );
                valor_para_notificar.setText( valor_com_mascara );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Botão Salvar.
        bt_salva_notificacoes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                long res;
                Dados_notificacoes dados_gravar = new Dados_notificacoes(
                                                                         proximo_sorteio.isChecked(),
                                                                         resultado_sorteio.isChecked(),
                                                                         acumulado.isChecked(),
                                                                         meus_jogos.isChecked(),
                                                                         valor_premio.isChecked());
                res = Recebe_requisicoes.requi_salva_notificacoes( dados_gravar, Menu_notificacoes.this );

                Context ctx    = Menu_notificacoes.this;
                String texto_p = "Dados inseridos com Sucesso!!!";
                String texto_n = "Erro na inserção dos dados!!!";
                int duracao_toast = Toast.LENGTH_LONG;

                if ( res != -1 ){
                    Toast toast = Toast.makeText( ctx, texto_p, duracao_toast );
                    toast.show();
                }else{

                    Toast toast = Toast.makeText( ctx, texto_n, duracao_toast );
                    toast.show();

                }
            }
        });

    }

    // ------------------- Getters -------------------

    public boolean getProximo_sorteio() {
        return proximo_sorteio.isChecked();
    }

    public boolean getResultado_sorteio() {
        return resultado_sorteio.isChecked();
    }

    public boolean getAcumulado() {
        return acumulado.isChecked();
    }

    public boolean getMeus_jogos() {
        return meus_jogos.isChecked();
    }

    // Extamente como retornar o valor aqui ?
    public EditText getValor_para_notificar() {
        return valor_para_notificar;
    }

    public String coloca_mascara_financeira_valor(int valor ){

         String valor_str;

        NumberFormat df = NumberFormat.getCurrencyInstance( new Locale( "pt","BR" ) );
        valor_str = df.format( valor );

        return valor_str;
    }

    // Classe p/ encapsular os dados fundamentais da Activity Menu_notificacao .
    public class Dados_notificacoes{

        private boolean proximo_sorteio;
        private boolean resultado_sorteio; // notifica quando saí um resultado.
        private boolean acumulado;
        private boolean meus_jogos;
        private boolean valor_premio; // Notifica quando o valor prêmio estiver no que foi setado.

        Dados_notificacoes( boolean proximo_sorteio, boolean resultado_sorteio,
                            boolean acumulado, boolean meus_jogos, boolean valor_premio ){

            this.proximo_sorteio   = proximo_sorteio;
            this.resultado_sorteio = resultado_sorteio;
            this.acumulado         = acumulado;
            this.meus_jogos        = meus_jogos;
            this.valor_premio      = valor_premio;
            //valor_escolhido_notifica ?
        }

        public boolean isProximo_sorteio() {
            return this.proximo_sorteio;
        }

        public boolean isResultado_sorteio() {
            return this.resultado_sorteio;
        }

        public boolean isAcumulado() {
            return this.acumulado;
        }

        public boolean isMeus_jogos() {
            return this.meus_jogos;
        }

        public boolean isValor_premio() {
            return this.valor_premio;
        }

        //private ( Tipo ? )valor_premio_notificar;

    }
}
