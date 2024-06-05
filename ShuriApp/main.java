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
import java.util.Scanner;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import java.util.List;
import java.util.ArrayList;

public class main {
	// Parte da configuração pra ignorar certificação SSL, como? também não entendi
	// ainda
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

	public static void main(String[] args)
			throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException, AWTException {

		/////////////////////////////////////////////////
		//////////// Area de configurrações//////////////
		////////////////////////////////////////////////

		// Configuração para ignorar a certificação SSL
		SSLContext sslContext = SSLContext.getInstance("SSL"); // OR TLS
		sslContext.init(null, new TrustManager[] { DUMMY_TRUST_MANAGER }, new SecureRandom());

		///////////////////////////////////////////////
		/////////// Começo das operações///////////////
		//////////////////////////////////////////////

		// realiza o primeiro movimento ao iniciar, começando por um delay para que de
		// tempo da api inicializar

		// Declarando algumas variaveis necessarias
		int skip = 0;
		int take = 2;
		String segura = "?skip=" + skip + "&take=" + take;
		testejson tst = new testejson();
		agenda agd = new agenda();

		phrases fraseatual = new phrases(0, "", LocalDateTime.now());

		while (true) {
			Thread.sleep(1000);
			// Configuração do http client
			HttpClient httpClient = HttpClient.newBuilder().sslContext(sslContext).build();
			// Configuração da http request
			HttpRequest request = HttpRequest.newBuilder().GET()
					.uri(URI.create("https://localhost:7199/Interpretation" + segura)).build();
			// envia a requisição

			ArrayList<phrases> frases = new ArrayList<phrases>();
			ArrayList<String> chaves = new ArrayList<String>();
			ArrayList<String> valores = new ArrayList<String>();
			
			try
			{
			HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
			chaves = tst.keys(response.body().toString());
			valores = tst.values(response.body().toString());
			}
			catch(IOException e)
			{
				System.out.println("por ai não jovem");
			}
			// Instancia uma lista de frases


			for (int y = 1; y <= chaves.size(); y++) 
			{
				if(chaves.get(y-1).equals("id"))
				{
					fraseatual.setId(Integer.parseInt(valores.get(y-1)));
				}
				else if(chaves.get(y-1).equals("text"))
				{
					fraseatual.setPhrase(valores.get(y-1));
				}
				else if(chaves.get(y-1).equals("saytime"))
				{
					fraseatual.setSaytime(LocalDateTime.parse(valores.get(y-1)));
					frases.add(new phrases(fraseatual.getId(), fraseatual.getPhrase(), fraseatual.getSaytime()));
				}
			}

			for (int h = 0; h < frases.size(); h++) {
				frases.get(h).resposta(skip);
				skip = frases.get(h).getId();
			}

			segura = "?skip=" + skip + "&take=" + take;
		}
		
	}
}