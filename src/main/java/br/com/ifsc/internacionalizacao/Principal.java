

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
 
        if (args.length != 2) {
            idioma = new String("pt");
            pais = new String("BR");
        } else {
            idioma = new String(args[0]);
            pais = new String(args[1]);
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
