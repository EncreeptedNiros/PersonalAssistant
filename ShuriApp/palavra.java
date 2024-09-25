import java.sql.Date;
import java.time.LocalDateTime;
import java.awt.AWTException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ArrayList;
import java.net.Socket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalDate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;



public class palavra
{
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



    String lema;
    Boolean conhecida;
    Boolean numero;//0 false -> singular 1 true -> plural
	String classegramatical;
    String significados;
    String contexto;
	String sinonimos;
	String antonimos;
    int frequencia;


    //construtor
    public palavra(String l) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException, AWTException
    {
        setLema(l);


        // Configuração para ignorar a certificação SSL
		SSLContext sslContext = SSLContext.getInstance("SSL"); // OR TLS
		sslContext.init(null, new TrustManager[] { DUMMY_TRUST_MANAGER }, new SecureRandom());
        
        // Configuração do http client
			HttpClient httpClient = HttpClient.newBuilder().sslContext(sslContext).build();
			// Configuração da http request
			HttpRequest request = HttpRequest.newBuilder().GET()
					.uri(URI.create("https://localhost:7199/Dicionario/" + this.lema)).build();

                    ArrayList<String> chaves = new ArrayList<String>();
		        	ArrayList<String> valores = new ArrayList<String>();
                    testejson tst = new testejson();


                    try{
                    // envia a requisição
                    HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
                    chaves = tst.keys(response.body().toString());
			        valores = tst.values(response.body().toString());

                    if(response.statusCode() == 404)
                    {
                        conhecida = false;
                    }
                    else
                    {
                        conhecida = true;
                        for(int x = 0;x <= chaves.size();x++)
                        {
                            if(chaves.get(x).equals("numero"))
                            {
                                setNumero(valores.get(x));
                            }
                            else if(chaves.get(x).equals("classegramatical"))
                            {
                                setClasseGramatical(valores.get(x));
                            }
                            else if(chaves.get(x).equals("significados"))
                            {
                                setSignificados(valores.get(x));
                            }
                            else if(chaves.get(x).equals("contexto"))
                            {
                                setContexto(valores.get(x));
                            }
                            else if(chaves.get(x).equals("sinonimos"))
                            {
                                setSinonimos(valores.get(x));
                            }
                            else if(chaves.get(x).equals("antonimos"))
                            {
                                setAntonimos(valores.get(x));
                            }
                            else if(chaves.get(x).equals("frequencia"))
                            {
                                setFrequencia(valores.get(x));
                            }
                            
                            
                        }
                        

                    }
    
                    }
                    catch(IOException e)
                    {
                        System.out.println("Não foi possivel procurar no dicionario");
                    }

    }

    public void setLema(String lema) {
        this.lema = lema;
    }
    public void setClasseGramatical(String classegramatical) {
        this.classegramatical = classegramatical;
    }
    public void setSignificados(String significados) {
        this.significados = significados;
    }
    public void setContexto(String contexto) {
       // this.contexto = contexto;
    }
    public void setSinonimos(String sinonimos) {
        //this.sinonimos = sinonimos;
    }
    public void setAntonimos(String antonimos) {
        this.antonimos = antonimos;
    }
    public void setFrequencia(String frequencia) {
        //this.frequencia = frequencia;
    }
    public void setNumero(String numero) {
       // this.numero = numero;
    }



    public String getLema()
    {
        return lema;
    }

    public boolean getConhecida()
    {
        return conhecida;
    }

    public boolean getNumero()
    {
        return numero;
    }

    public String getClasseGramatical()
    {
        return classegramatical;
    }

    public String getContexto()
    {
        return contexto;
    }
    public String getSinonimos()
    {
        return sinonimos;
    }
    public String getAntonimos()
    {
        return antonimos;
    }
    public int getFrequencia()
    {
        return frequencia;
    }

}
