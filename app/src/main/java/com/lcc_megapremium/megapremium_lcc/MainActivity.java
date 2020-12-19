package com.lcc_megapremium.megapremium_lcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.lcc_megapremium.megapremium_lcc.Controller.Recebe_requisicoes;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Encontrar_concurso;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Gera_estatistica;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Gera_sequencia;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Menu_ajuda;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Menu_doacao;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Menu_notificacoes;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Qual_minha_chance;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Quanto_ja_gastei;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Verifica_sequencia;

public class MainActivity extends AppCompatActivity {

    private Button verifica_sequencia;
    private Button gera_sequencia;
    private Button gerar_estatistica;
    private Button encontrar_concurso;
    private Button quanto_ja_gastei;
    private Button qual_minha_chance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verifica_sequencia  = ( Button ) findViewById( R.id.id_bt_verifica_sequencia);
        gera_sequencia      = ( Button ) findViewById( R.id.id_bt_gera_sequencia_ouro);
        gerar_estatistica   = ( Button ) findViewById( R.id.id_bt_gerar_estatistica);
        encontrar_concurso  = ( Button ) findViewById( R.id.id_bt_encontrar_concurso);
        quanto_ja_gastei    = ( Button ) findViewById( R.id.id_bt_quanto_ja_gastei);
        qual_minha_chance   = ( Button ) findViewById( R.id.id_bt_qual_minha_chance);

        verifica_sequencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean r = Recebe_requisicoes.entrar_aquitivit_verifica_sequencia( getResources().getResourceEntryName( R.id.id_bt_verifica_sequencia) );
                if ( r ){

                    Intent int_verifica_sequencia = new Intent( getApplicationContext(), Verifica_sequencia.class );
                    int_verifica_sequencia.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity( int_verifica_sequencia );
                }
            }
        });

        gera_sequencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean r = Recebe_requisicoes.entrar_aquitivit_gerar_sequencia( getResources().getResourceEntryName( R.id.id_bt_gera_sequencia_ouro) );

                if ( r ){
                    Intent int_gera_sequencia = new Intent( getApplicationContext(), Gera_sequencia.class );
                    int_gera_sequencia.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity( int_gera_sequencia );
                }
            }
        });

        gerar_estatistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean r = Recebe_requisicoes.entrar_aquitivit_gerar_estatistica( getResources().getResourceEntryName( R.id.id_bt_gerar_estatistica) );

                if ( r ){
                    Intent int_gerar_estatistica = new Intent( getApplicationContext(), Gera_estatistica.class );
                    int_gerar_estatistica.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity( int_gerar_estatistica );
                }
            }
        });

        encontrar_concurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean r = Recebe_requisicoes.entrar_aquitivit_encontrar_concurso( getResources().getResourceEntryName( R.id.id_bt_encontrar_concurso) );

                if ( r ){
                    Intent int_encontrar_concurso = new Intent( getApplicationContext(), Encontrar_concurso.class );
                    int_encontrar_concurso.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity( int_encontrar_concurso );
                }

            }
        });

        quanto_ja_gastei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean r = Recebe_requisicoes.entrar_aquitivit_quanto_ja_gastei( getResources().getResourceEntryName( R.id.id_bt_quanto_ja_gastei) );

                if ( r ){
                    Intent int_quanto_ja_gastei = new Intent( getApplicationContext(), Quanto_ja_gastei.class );
                    int_quanto_ja_gastei.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity( int_quanto_ja_gastei );
                }
            }
        });

        qual_minha_chance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean r = Recebe_requisicoes.entrar_aquitivit_quanto_ja_gastei( getResources().getResourceEntryName( R.id.id_bt_qual_minha_chance) );

                if ( r ){
                    Intent int_qual_minha_chance = new Intent( getApplicationContext(), Qual_minha_chance.class );
                    int_qual_minha_chance.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity( int_qual_minha_chance );

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* ' Menu menu '        : Objeto Menu que representa a ' barra de a??o '
         ' R.menu.menu_main ' : Arquivo de Recursos de Menu.
         ' getMenuInflater().inflate( R.menu.menu_main, menu ) ' : Isso pega os itens
           de menu do arquivo de recursos de menu ' menu_main.xml ' e os adiciona ao objeto
           Menu da barra de a??o.
         */
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // MenuItem item : Representa o item da barra de a??o que foi clicado.

        if (item.getItemId() == R.id.id_menu_notificacao) {
            boolean r_notificacao = Recebe_requisicoes.entrar_aquitivit_menu_notificacoes(getResources().getResourceEntryName(R.id.id_menu_notificacao));
            if (r_notificacao) {
                Intent int_menu_notificacao = new Intent(getApplicationContext(), Menu_notificacoes.class);
                int_menu_notificacao.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(int_menu_notificacao);
            }
        }
        if (item.getItemId() == R.id.id_menu_doacao){
            boolean r_doacao = Recebe_requisicoes.entrar_aquitivit_menu_doacao(getResources().getResourceEntryName(R.id.id_menu_doacao));
            if (r_doacao) {
               Intent int_menu_doacao = new Intent(getApplicationContext(), Menu_doacao.class);
               int_menu_doacao.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(int_menu_doacao);
            }
       }
        if (item.getItemId() == R.id.id_menu_ajuda){
            boolean r_ajuda = Recebe_requisicoes.entrar_aquitivit_menu_ajuda(getResources().getResourceEntryName(R.id.id_menu_ajuda));
            if (r_ajuda) {
                Intent int_menu_ajuda = new Intent(getApplicationContext(), Menu_ajuda.class);
                int_menu_ajuda.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(int_menu_ajuda);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
