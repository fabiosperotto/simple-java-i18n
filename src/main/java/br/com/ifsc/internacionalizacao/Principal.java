

package br.com.ifsc.internacionalizacao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        String idioma;
        String pais;
 
        if(args.length != 2){ //executavel foi chamado sem argumentos/parametro cli
            idioma = System.getProperty("user.language"); //idioma na config do sistema operacional
            pais = System.getProperty("user.country"); //pais na config do sistema operacional
        }else{ //temos argumentos por cli
            idioma = args[0]; //idioma enviado por cli
            pais = args[1]; //pais enviado por cli
        }
        
        //avaliando se temos traducao disponivel
        ArrayList<String> traducoesDisponiveis = new ArrayList<String>();
        traducoesDisponiveis.add("pt");
        traducoesDisponiveis.add("en");
        if(!traducoesDisponiveis.contains(idioma)){ //nao existe traducao disponivel, usar default:
            idioma = "pt";
            pais = "BR";
        }
        
        Locale localCorrente;
        ResourceBundle traducoes = null;
        
        //para desenvolvimento local
        //localCorrente = new Locale(idioma, pais);
        //traducoes = ResourceBundle.getBundle("MessagesBundle", localCorrente);
        //teremos MessagesBundle_idioma_pais.properties

        //para o executavel .jar final
        InputStream newInputStream;
        String nomeArquivo = "./idiomas/MessagesBundle_"+idioma+"_"+pais+".properties";
        try {
            newInputStream = Files.newInputStream(Paths.get(nomeArquivo));
            traducoes = new PropertyResourceBundle(newInputStream);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(traducoes.getString("cad_cliente_nome"));
    }
}
