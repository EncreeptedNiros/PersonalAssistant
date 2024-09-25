import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import java.net.Socket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.util.Scanner;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;


    /*
     * tipos de frase
     * 
     * Frase declarativa
     * 
     * Uma frase declarativa tem como intenção dar uma informação ou constatar um
     * fato.
     * 
     * Frase declarativa Afirmativa -> Gosto de ler antes de dormir - Meu irmão foi
     * a natação - A palestra começara na hora marcada
     * Frase declarativa Negativa -> Não gosto de ler antes de dormir - Meu irmão
     * nunca foi a natação - A palestra jamais começara na hora marcada
     * 
     * Frase interrogativa
     * 
     * Numa frase interrogativa, o emissor faz uma pergunta ao interlocutor.
     * 
     * Frase interrogativa direta -> Que horas são? - Você viu meu irmão? - Posso
     * passar?
     * Frase interrogativa indireta -> Eu queria saber que horas são - Eu queria
     * saber se você viu meu irmão - Gostaria de saber se posso passar
     * 
     * Frase imperativa
     * 
     * Uma frase imperativa tem como intenção dar ordens ou conselhos, bem como
     * fazer pedidos, havendo uma ação direta sobre o comportamento do interlocutor
     * 
     * Frase imperativa afirmativa -> Pare com esse barulho imediatamente - Ajuda-me
     * aqui, por favor - Fale com minha mulher, ela pode ajudala
     * Frase imperativa negativa -> Não seja paranoico, ninguém estava falndo de
     * você - Não empurre seu irmão - Não faça confusão
     * 
     * Frase exclamativa
     * 
     * Numa frase exclamativa, o emissor exprime um estado emotivo, exteriorizando
     * seus sentimentos
     * 
     * Frase exclamativa -> Que dia maravilhoso - Que bom que você chegou - nossa
     * que horror
     * 
     * Frase optativa
     * 
     * Uma frase otativa é utilizada para exprimir um desejo, uma vontade
     * 
     * Frase optativa -> Deus te acompanhe - Bons ventos te levem - Tomara que tudo
     * de certo
     * 
     * Frase nominal e frase verbal
     * 
     * Além da classificação dos tipos de frase, as frases podem ser classificadas
     * em nominais e verbais
     * 
     * Frase verbal é uma frase que apresenta verbos na sua construção como: O dia
     * amanheceu frio - Ja li o livro todo - Voce entendeu alguma coisa?
     * 
     * Frase nominal é uma frase que não apresenta verbos na sua construção como:
     * Atenção - Coisa estranha - Que lindo
     * 
     */

public class responses {

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

    mouseteclado m = new mouseteclado();
    private int codigo;
    private String responseString = "";

    public void voiceResponse(String text)
            throws AWTException, IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("SSL"); // OR TLS
        sslContext.init(null, new TrustManager[] { DUMMY_TRUST_MANAGER }, new SecureRandom());
        // Configuração do http client
        HttpClient httpClient = HttpClient.newBuilder().sslContext(sslContext).build();
        // Configuração da http request
        HttpRequest request = HttpRequest.newBuilder().headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"responsetext\":\"" + text + "\"}"))
                .uri(URI.create("https://localhost:7199/Response"))
                .build();
        // envia a requisição
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
    }
    public boolean actionAwnser(ArrayList<ArrayList<Integer>> i, ArrayList<palavra> x) throws IOException, KeyManagementException, NoSuchAlgorithmException, AWTException, InterruptedException
    {
        boolean confirm = false;
        for(int y = 0;y <= x.size();y++)
        {
                switch(x.get(y).getLema())
                {
                        case "abra":
                                for(int zx = 0; zx <= x.size(); zx++)
                                {
                                        switch(x.get(zx).getLema())
                                        {
                                                case "arquivo":
                                                        arquivo target = new arquivo();
                                                        target.abrir();
                                                        break;
                                                
                                                case "tarefa":
                                                        break;
                                                default:
                                                        voiceResponse("Não entendi");
                                                        break;
                                        }
                                }
                                break;
                        case "crie":
                                for(int zx = 0; zx <= x.size(); zx++)
                                {
                                        switch(x.get(zx).getLema())
                                        {
                                                case "arquivo":
                                                        arquivo target = new arquivo();
                                                        target.criar();
                                                        break;
                                                
                                                case "tarefa":
                                                        break;
                                                default:
                                                        voiceResponse("Não entendi");
                                                        break;
                                        }
                                }
                                break;
                        case "exclua":
                                for(int zx = 0; zx <= x.size(); zx++)
                                {
                                        switch(x.get(zx).getLema())
                                        {
                                                case "arquivo":
                                                        break;
                                                
                                                case "tarefa":
                                                        break;
                                                default:
                                                        voiceResponse("Não entendi");
                                                        break;
                                        }
                                }
                                break;
                        case "desligar":
                                m.desligar();
                                break;
                        default:
                                voiceResponse("Não entendi");
                        break;
                        
                }
        }

        return confirm;
    }

    public void awnser(ArrayList<ArrayList<Integer>> i, ArrayList<palavra> x)
        throws AWTException, IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException 
        {
                //tem que colocar uma condicional nessa joça
                boolean action = actionAwnser(i,x);
                if(action == true)
                {
                        voiceResponse("Certo, estou fazendo isso");
                }
                else
                {
                        voiceResponse("Desculpe, não consegui fazer isso"); 
                }
                /*
                * Frase declarativa Afirmativa
                * Frase declarativa Negativa
                * Frase interrogativa direta
                * Frase interrogativa indireta
                * Frase imperativa afirmativa
                * Frase imperativa negativa
                * Solicitado
                * Não solicitado
                * 
                * classe
                */
                //voiceResponse(responseString);
                //actionResponse();
        }

}