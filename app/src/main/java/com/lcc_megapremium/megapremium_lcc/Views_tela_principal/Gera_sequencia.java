package com.lcc_megapremium.megapremium_lcc.Views_tela_principal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.lcc_megapremium.megapremium_lcc.Controller.Recebe_requisicoes;
import com.lcc_megapremium.megapremium_lcc.R;

import java.util.Calendar;
import java.util.Date;

public class Gera_sequencia extends Activity {

    private TextView campo_mostra_sequencia_ouro;
    private TextView campo_mostra_sequencia_aleatoria;
    //-------------------------------------------
    private Button bt_gera_sequencia_ouro;
    private Button bt_salva_sequencia_ouro;
    private Button bt_limpa_sequencia_ouro;
    //-------------------------------------------
    private Button bt_gera_sequencia_aleatoria;
    private Button bt_salva_sequencia_aleat;
    private Button bt_limpa_sequencia_aleat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_gerar_sequencia);

        //------------------------------------------
        bt_gera_sequencia_ouro  = ( Button ) findViewById( R.id.id_bt_gera_sequencia_ouro );
        bt_salva_sequencia_ouro = ( Button ) findViewById( R.id.id_bt_salva_sequencia_ouro );
        bt_limpa_sequencia_ouro = ( Button ) findViewById( R.id.id_bt_limpar_sequencia_ouro );
        //------------------------------------------
        bt_gera_sequencia_aleatoria = ( Button ) findViewById( R.id.id_bt_gera_sequencia_aleat );
        bt_salva_sequencia_aleat    = ( Button ) findViewById( R.id.id_bt_salva_sequencia_aleat );
        bt_limpa_sequencia_aleat    = ( Button ) findViewById( R.id.id_bt_limpar_sequencia_aleat );
        //------------------------------------------
        campo_mostra_sequencia_ouro      = ( TextView ) findViewById( R.id.id_campo_sequencia_ouro ) ;
        campo_mostra_sequencia_aleatoria = ( TextView ) findViewById( R.id.id_campo_sequencia_aleatoria ) ;

        //------------------------------------------
        bt_gera_sequencia_ouro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sequencia_gerada = Recebe_requisicoes.requi_gera_sequencia_ouro();
                campo_mostra_sequencia_ouro.setText ( ( CharSequence ) sequencia_gerada );
            }
        });
        bt_salva_sequencia_ouro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c         = Calendar.getInstance();
                Date    date_hora  = c.getTime();// Data e hora atual.
                boolean seq_ouro   = false;
                boolean seq_aleat  = false;

                String  seq_salvar = null;

                if ( campo_mostra_sequencia_ouro.getText() != "" ){

                    seq_ouro   = true;
                    seq_salvar = campo_mostra_sequencia_ouro.getText().toString();
                    Dados_gera dados_gera = new Dados_gera( date_hora.toString(),seq_salvar,seq_ouro,seq_aleat);
                    long res = Recebe_requisicoes.requi_salva_sequencia( dados_gera, Gera_sequencia.this );

                    Context ctx    = Gera_sequencia.this;
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
                }else{ // Se o campo ouro estiver vazio, então entra um Toast avisando.

                    Context ctx    = Gera_sequencia.this;
                    String campo_ouro = "Campo ouro vazio !!!";
                    int duracao_toast = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText( ctx, campo_ouro, duracao_toast );
                    toast.show();

                }

            }
        });

        bt_limpa_sequencia_ouro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                campo_mostra_sequencia_ouro.setText( "" );
            }
        });
        //---------------------------------------------------------------------------
        bt_gera_sequencia_aleatoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sequencia_gerada = Recebe_requisicoes.requi_gera_sequencia_aleatoria();
                campo_mostra_sequencia_ouro.setText ( ( CharSequence ) sequencia_gerada );
            }
        });
        bt_salva_sequencia_aleat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c         = Calendar.getInstance();
                Date    date_hora  = c.getTime();// Data e hora atual.
                boolean seq_ouro   = false;
                boolean seq_aleat  = false;

                String  seq_salvar = null;

                if ( campo_mostra_sequencia_aleatoria.getText() != "" ){

                    seq_ouro   = true;
                    seq_salvar = campo_mostra_sequencia_aleatoria.getText().toString();
                    Dados_gera dados_gera = new Dados_gera( date_hora.toString(),seq_salvar,seq_aleat,seq_aleat);
                    long res = Recebe_requisicoes.requi_salva_sequencia( dados_gera, Gera_sequencia.this );

                    Context ctx    = Gera_sequencia.this;
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
                }else{ // Se o campo ouro estiver vazio, então entra um Toast avisando.

                    Context ctx        = Gera_sequencia.this;
                    String campo_aleat = "Campo Aleatorio vazio !!!";
                    int duracao_toast  = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText( ctx, campo_aleat, duracao_toast );
                    toast.show();

                }
            }
        });

        bt_limpa_sequencia_aleat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                campo_mostra_sequencia_aleatoria.setText( "" );

            }
        });

        //---------------------------------------------------------------------------

        bt_gera_sequencia_aleatoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sequencia_gerada = Recebe_requisicoes.requi_gera_sequencia_aleatoria();
                campo_mostra_sequencia_aleatoria.setText ( ( CharSequence ) sequencia_gerada );
            }
        });

    }

    public class Dados_gera{

        String  data_hora;
        String  sequencia_salvar;
        boolean seq_ouro;
        boolean seq_aleat;

        Dados_gera( String data_hora, String sequencia_salvar,
                    boolean seq_ouro, boolean seq_aleat  ){
            this.data_hora        = data_hora;
            this.sequencia_salvar = sequencia_salvar;
            this.seq_ouro         = seq_ouro;
            this.seq_aleat        = seq_aleat;
        }

        public String getData_hora() {
            return data_hora;
        }

        public String getSequencia_salvar() {
            return sequencia_salvar;
        }

        public boolean isSeq_ouro() {
            return seq_ouro;
        }

        public boolean isSeq_aleat() {
            return seq_aleat;
        }
    }
}
