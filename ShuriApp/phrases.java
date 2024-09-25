import java.sql.Date;
import java.time.LocalDateTime;
import java.awt.AWTException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ArrayList;
import java.awt.AWTException;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import java.util.List;


public class phrases {
    private static final TrustManager DUMMY_TRUST_MANAGER = new X509ExtendedTrustManager() {
		@Override
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return new java.security.cert.X509Certificate[0];
		}

		@Override
		public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket)
				throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket)
				throws CertificateException {
		}

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine)
				throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine)
				throws CertificateException {
		}
	};
    

    private int id;
    private String phrase;
    private LocalDateTime Saytime;
    private boolean Processado;
    private ArrayList<palavra> listaDePalavras = new ArrayList<palavra>();
    responses responda = new responses();
    

    // Construtor da classe

    public phrases(int id, String frase, LocalDateTime data)
    throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException, AWTException {
        // TODO Auto-generated constructor stub
        String fraseAuxiliar = frase + " ";
        char[] teste = fraseAuxiliar.toCharArray();
        fraseAuxiliar = "";

        setId(id);
        setPhrase(frase);
        setSaytime(data);

        for (int i = 0; i < teste.length; i++) {
            if (teste[i] == ' ') {
                listaDePalavras.add(new palavra(fraseAuxiliar));
                fraseAuxiliar = "";
            } else {
                fraseAuxiliar = fraseAuxiliar + teste[i];
            }
        }

        if (data.getYear() < LocalDateTime.now().getYear() || data.getMonthValue() < LocalDateTime.now().getMonthValue()
                ||
                data.getDayOfMonth() < LocalDateTime.now().getDayOfMonth()
                || data.getHour() < LocalDateTime.now().getHour() ||
                data.getMinute() + 1 < LocalDateTime.now().getMinute()) {
            Processado = true;
        } else {
            Processado = false;
        }
    }

    // Sessão de GETs

    public int getId() {
        return id;
    }

    public LocalDateTime getSaytime() {
        return Saytime;
    }

    public String getPhrase() {

        return phrase;

    }

    private boolean getProcessado() {
        return Processado;
    }

    // Sessão de SETs

    public void setId(int id) {
        this.id = id;
    }

    public void setSaytime(LocalDateTime saytime) {
        Saytime = saytime;
    }

    public void setPhrase(String frase) {

        this.phrase = frase;
    }

    public void setProcessado(boolean Processado) {
        this.Processado = Processado;
    }

    private ArrayList<Integer> classeGramatical(boolean positive, int index)
    {
        ArrayList<Integer> cod = new ArrayList<Integer>();
        if(positive == true)
        {
            cod.add(0);
        }
        else
        {
            //Se uma frase tem 2 palavras, não é possivel usar uma interjeição
            //conjunçoes não devem vir seguidas umas das outras
            //
            switch (listaDePalavras.get(index).classegramatical) {
                case "substantivo":
                    cod.add(1);
                    break;
                case "artigo":
                    cod.add(2);
                    break;
                case "adjetivo":
                    cod.add(3);
                    break;
                case "numeral":
                    cod.add(4);
                    break;
                case "pronome":
                    cod.add(5);
                    break;
                case "verbo":
                    cod.add(6);  
                    break;
                case "adverbio":
                    cod.add(7); 
                    break;
                case "preposicao:":
                    cod.add(8);
                    break;
                case "conjuncao":
                    cod.add(9);
                    break;
                case "interjeicao":
                    cod.add(10); 
                    break;
            
                default:
                    cod.add(11);
                    break;
            }
        }
        
        return cod;
    }
    private ArrayList<Integer> concordanciaComAdjacentes(boolean positive, int index)
    {
        ArrayList<Integer> cod = new ArrayList<Integer>();
        cod.add(4);
        return cod;
    }
    private ArrayList<Integer> contexto(boolean positive, int index)
    {
        ArrayList<Integer> cod = new ArrayList<Integer>();
        cod.add(0);
        return cod;
    }
    private boolean formalidade(Boolean positive, int index)
    {
        return true;
    }
    private boolean entendimento(Boolean positive)
    {
        return false;
    }



    private ArrayList<ArrayList<Integer>> processaFrase() {

        ArrayList<ArrayList<Integer>> matriz1 = new ArrayList<ArrayList<Integer>>();

        
        for(int x = 0; x <= listaDePalavras.size();x++)
        {
            ArrayList<Integer> cod = new ArrayList<Integer>();
            //cod.add(listaDePalavras.get(x).conhecida);
            cod.add(classeGramatical(listaDePalavras.get(x).conhecida, x).get(0));
            //cod.add(listaDePalavras.get(x).numero);
            cod.add(concordanciaComAdjacentes(listaDePalavras.get(x).conhecida, x).get(0));
            cod.add(concordanciaComAdjacentes(listaDePalavras.get(x).conhecida, x).get(1));
            cod.add(contexto(listaDePalavras.get(x).conhecida, x).get(0));
            //cod.add(formalidade(listaDePalavras.get(x).conhecida, x));
            //cod.add(entendimento(listaDePalavras.get(x).conhecida));
            matriz1.add(cod);

        }

      
        return matriz1;
    }
    
    
    
    public void resposta(int ultimoid)
            throws AWTException, IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {

        if (Processado == false && id > ultimoid) {
            responda.awnser(processaFrase(), listaDePalavras);
            System.out.println(processaFrase());
        } else {

        }
    }

}