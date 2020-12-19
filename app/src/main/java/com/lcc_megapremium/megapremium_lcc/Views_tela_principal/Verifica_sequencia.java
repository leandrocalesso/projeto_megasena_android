package com.lcc_megapremium.megapremium_lcc.Views_tela_principal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lcc_megapremium.megapremium_lcc.Controller.Recebe_requisicoes;
import com.lcc_megapremium.megapremium_lcc.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Verifica_sequencia extends Activity {

    private ListView listview_tela_verifica_sequencia;
    private EditText edittext_tela_verifica_sequencia;
    private Button   botao_verifica_sequencia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_verifica_sequencia);

        listview_tela_verifica_sequencia = ( ListView ) findViewById( R.id.id_listview_tela_verifica_sequencia );
        edittext_tela_verifica_sequencia = ( EditText ) findViewById( R.id.id_edittext_tela_verifica_sequencia );
        botao_verifica_sequencia         = ( Button )   findViewById( R.id.id_botao_verifica_sequencia );

        botao_verifica_sequencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Integer> sequencia_inteiro = null;
                sequencia_inteiro = sequencia_para_verificar( edittext_tela_verifica_sequencia.getText().toString() );
                HashMap<String,Boolean> seq_verificada = null;
                seq_verificada = Recebe_requisicoes.requi_verifica_validade_sequencia( sequencia_inteiro );

                List<Dados_listiview> dados_obj = new ArrayList<>();
                for (Map.Entry<String, Boolean> dados: seq_verificada.entrySet() ) {
                    String key    = dados.getKey();
                    Boolean value = dados.getValue();
                    if ( value == true ) {
                         dados_obj.add( new Dados_listiview( R.drawable.verifica_positivo, key )  );
                    }
                    if ( value == false ) {
                        dados_obj.add( new Dados_listiview( R.drawable.verificado_negativo, key )  );
                    }
                }
                Dados_array_adapter dados_array_adapter = new Dados_array_adapter( getApplicationContext(),
                                                                                   R.id.textViewlayoutListview,
                                                                                   dados_obj);
                listview_tela_verifica_sequencia.setAdapter( dados_array_adapter );
            }
        });
    }

    private List<Integer> sequencia_para_verificar( String sequencia_verificar ){

        String[] vetor_str = sequencia_verificar.split("-");
        List<Integer> lista_inteiro = new ArrayList<>();

        for ( String str : vetor_str ) {
            lista_inteiro.add( Integer.parseInt( str ) );
        }

        return lista_inteiro;
    }

    /* Essa Classe contém as informações que serão passadas a Classe que extende ArrayAdapter. */
    class Dados_listiview {

        public int     imagem;
        public String  str_estatistica;

        Dados_listiview( int imagem, String str_estatistica ){

            super();
            this.imagem = imagem;
            this.str_estatistica = str_estatistica;

        }

        public int getImagem() {
            return imagem;
        }

        public String getStr_estatistica() {
            return str_estatistica;
        }
    }

    /*
    * Nesse adapter personalizado, colocaremos a lógica de como fazer o
    * binding dos campos de cada item da listview conforme o layout XML.
    * */
    class Dados_array_adapter extends ArrayAdapter<Dados_listiview> {

         private List<Dados_listiview> items;

         public Dados_array_adapter( Context context, int textViewResourceId, List<Dados_listiview> items ){
             super(context, textViewResourceId,items);
             this.items = items;
         }
         /*
         *  Dentro do método getView() precisamos transformar numa View o XML
         *  contendo o layout do item da lista, para isso usamos o método
         *  inflate do LayoutInflater.
         * */
         @Override
         public View getView(int position, View convertView, ViewGroup parent ){

             View v = convertView;
             if ( v == null ){
                 Context ctx = getContext();
                 LayoutInflater vi = ( LayoutInflater )ctx.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                 v = vi.inflate( R.layout.listview_customizado, null );
             }

             Dados_listiview dados_listview = items.get( position );
             if ( dados_listview != null ){

                 ( ( ImageView )v.findViewById( R.id.imagemlayoutListview ) ).setImageResource( dados_listview.getImagem() );
                 ( ( TextView )v.findViewById( R.id.textViewlayoutListview ) ).setText( dados_listview.getStr_estatistica() );
             }
          return v;
         }

    }

}
