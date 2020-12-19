package com.lcc_megapremium.megapremium_lcc.Model;

import android.content.Context;

import com.lcc_megapremium.megapremium_lcc.Model.DAO.Conexao_db;
import com.lcc_megapremium.megapremium_lcc.Model.ENUM.EnumBotoesTelaPrincipal;
import com.lcc_megapremium.megapremium_lcc.Views_tela_principal.Gera_sequencia.Dados_gera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class Model_gera_sequencia {

    public static HashMap<String,Boolean> map_estatistica = new HashMap<>();
    // Analiza se o pedido para entrar na Activity ' Gera_sequencia ' está OK.
    public static boolean analiza_entrar_activity_servicos(String id_tela) {

        boolean retorno = false;
        List<EnumBotoesTelaPrincipal> list_valor_constante = Arrays.asList(EnumBotoesTelaPrincipal.values());
        for (EnumBotoesTelaPrincipal constant : list_valor_constante) {
            if (constant.getValor_constante().equals(id_tela)) {
                retorno = true;
                break;
            }
        }
        return retorno;

    }

    // Gera uma sequência aleátoria.
    public static String func_model_gera_sequencia_aleatoria() {

        List<Integer> sequencia_gerada_int = func_model_gera_sequencia_aleatoria_inteiro();

        return arrayInteiroParaString ( sequencia_gerada_int );
    }

    // Verifica se uma sequencia aleatória é ouro, se for retorna retorna a mesma.
    public static String func_model_gera_sequencia_ouro() {

        boolean ciclo = true;
        List<Integer> sequencia_gerada_int = null;

        while ( ciclo ) {
            sequencia_gerada_int = func_model_gera_sequencia_aleatoria_inteiro();
            if ( verifica_par_impar ( sequencia_gerada_int ) == false ) continue;
            if ( verifica_num_primos ( sequencia_gerada_int ) == false ) continue;
            if ( verifica_fibonacci ( sequencia_gerada_int ) == false ) continue;
            ciclo = false;
        }

        return arrayInteiroParaString( sequencia_gerada_int );
    }

    // ********************* Funções estátisticas de Verificação. *********************

    public static boolean verifica_par_impar( List<Integer> sequencia_aleatoria ) {

        /*
        * 3 par e 3 impar - 681x - 30.69%
          4 par e 2 impar - 535x - 24.11%
          2 par e 4 impar - 524x - 23.61%
          5 par e 1 impar - 226x - 10.18%
          1 par e 5 impar - 200x - 9.01%
          Somente Impar   - 28x  - 1.26%
          Somente Par     - 25x  - 1.13%
        *
        * */
        int num_par   = 0;
        int num_impar = 0;

        for ( int i = 0; i < sequencia_aleatoria.size(); i++ ) {
            int dezena = sequencia_aleatoria.get ( i );
            if ( dezena % 2 == 0 ) {
                num_par++;
            } else {
                num_impar++;
            }
        }

        if ( num_impar == 3 && num_par == 3 ) return true;
        else if ( num_par == 4 && num_impar == 3 ) return true;
        else if ( num_par == 2 && num_impar == 4 ) return true;

        return false;
    }

    /* Vou utilizar o 'Crivo de Erastóstenes' para descobrir se um número é primo. */
    public static boolean verifica_num_primos ( List<Integer> sequencia_aleatoria ) {

        /*
         0 : 250x - 11.27%
         1 : 733x - 33.03%
         2 : 740x - 33.35%
         3 : 380x - 17.12%
         4 : 98x  - 4.42%
         5 : 17x  - 0.77%
         6 : 1x   - 0.05%
        * */
        int           cont_num_primos = 0;
        List<Integer> dezenas_volante = new ArrayList<>();
        List<Integer> primos_volante  = new ArrayList<>();
        Integer[]     principais_multiplos = { 2,3,5,7 };

        // ArrayList com todas as dezenas do volante.
        for ( int i = 2; i < 61; i++ ){ dezenas_volante.add( i ); }

        int avanca_multiplos = 0;
        int res              = 0;
        while ( avanca_multiplos < principais_multiplos.length  ){
            int p_multiplos      = principais_multiplos [ avanca_multiplos ];
            for ( int a = 0; a < dezenas_volante.size(); a++ ){
                res = ( dezenas_volante.get ( a ) % p_multiplos );
                if ( res == 0 && dezenas_volante.get ( a ) > p_multiplos  ){
                    dezenas_volante.remove( dezenas_volante.get ( a ) ); }
            }
          avanca_multiplos++;
        }

        for ( int d = 0; d < sequencia_aleatoria.size(); d++ ){
            for ( int v = 0; v < dezenas_volante.size(); v++ ){
                if ( sequencia_aleatoria.get ( d ) == dezenas_volante.get ( v ) ){
                    cont_num_primos++;
                }
            }
        }

        if ( cont_num_primos >= 1 && cont_num_primos <= 3 )
           return true;

        return false;
    }

    public static boolean verifica_fibonacci ( List<Integer> sequencia_aleatoria ) {

        int cont_num_fibonacci = 0;

        int indice         = 2;
        int ant_primaria   = 0;
        int ant_secundaria = 1;
        while ( indice < ( sequencia_aleatoria.size() ) ) {
            int result = ( sequencia_aleatoria.get ( ant_primaria ) + sequencia_aleatoria.get ( ant_secundaria ) );
            if (sequencia_aleatoria.get ( indice ) == result ) {
                cont_num_fibonacci++;
            }
            indice++;
            ant_primaria++;
            ant_secundaria++;
        }

        if (cont_num_fibonacci == 0) {
            return true;
        }

        return false;
    }

    public static HashMap<String, Boolean> valida_sequencia( List<Integer> sequencia_para_verificar ){

        if ( verifica_par_impar ( sequencia_para_verificar ) == true ) {
            map_estatistica.put("Par Impar",true);
        }else {
            map_estatistica.put("Par Impar",false);
        }

        if ( verifica_num_primos ( sequencia_para_verificar ) == true ) {
            map_estatistica.put("Números Primos",true);
        }else {
            map_estatistica.put("Números Primos",false);
        }

        if ( verifica_fibonacci ( sequencia_para_verificar ) == true ) {
            map_estatistica.put("Fibonacci",true);
        }else {
            map_estatistica.put("Fibonacci",false);
        }

        return map_estatistica;
    }

    // Retorna um HashMap de todas as estatísticas que estão sendo usadas p/ validar uma sequência.
    public static HashMap<String, Boolean> retorna_lista_estatisticas_usadas(){

        HashMap<String, Boolean> hash_lista = map_estatistica;
        map_estatistica.clear();
        return hash_lista;

    }

    // ******************* Funções ferramentas. *******************

    // Recebe array de inteiros e retorna string.
    public static String arrayInteiroParaString( List<Integer> sequencia_gerada_int ){

        StringBuilder sequencia_gerada_str = new StringBuilder();

        for ( int c = 0; c < sequencia_gerada_int.size(); c++ ) {
            if (c <= 4) {
                if ( sequencia_gerada_int.get ( c ) < 10 ) {
                    sequencia_gerada_str.append ( "0" + String.valueOf ( sequencia_gerada_int.get ( c ) ) + " - " );
                }
                else sequencia_gerada_str.append ( String.valueOf ( sequencia_gerada_int.get ( c ) ) + " - " );
            }
            else sequencia_gerada_str.append ( String.valueOf ( sequencia_gerada_int.get ( c ) ) );
        }

        return sequencia_gerada_str.toString();
    }

   // Retorna um Lista com seis sequências não repetidas de inteiros.
    public static List<Integer> func_model_gera_sequencia_aleatoria_inteiro() {

        List<Integer> sequencia_gerada_int = new ArrayList<>();

        Random r = new Random();
        int dezena = 0;
        int flag = 0;
        int i = 0;
        while (i < 6) {
            dezena = r.nextInt(60) + 1;
            for (int l = 0; l < sequencia_gerada_int.size(); l++) {
                if (dezena == sequencia_gerada_int.get(l)) {
                    flag = -1;
                    break;
                }
            }
            if (flag == -1) {
                i = 0;
                flag = 0;
                sequencia_gerada_int.clear();
                continue;
            } else {
                sequencia_gerada_int.add(dezena);
                i++;
            }

        }
        Collections.sort(sequencia_gerada_int);

        return sequencia_gerada_int;
    }

    //--------------------------------------------------------

    public static long model_salva_sequencia ( Dados_gera dados_gravar, Context ctx ){

        Conexao_db conexao_db = new Conexao_db( ctx );
        long res = conexao_db.gravar_registro_gera_sequencia( dados_gravar );

        return res;
    }
}