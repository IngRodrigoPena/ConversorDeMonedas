package com.rodstone.conversordemonedas;
import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;


//La clase ApiClient encapsula el cliente HTTP (HttpClient)
//que usaremos para enviar solicitudes a la API de ExchangeRate.

//HttpClient es la clase que se encarga de enviar solicitudes HTTP y recibir respuestas.
//Creamos una instancia de HttpClient dentro de la clase ApiClient.
//Usamos encapsulamiento: client es private, y solo se accede a través del método getClient().

public class ApiClient {
        private final HttpClient client;

        // Constructor
        public ApiClient() {
            // Creamos una instancia del cliente HTTP
            this.client = HttpClient.newHttpClient();
        }

        // Getter para obtener el cliente desde otras clases
        public HttpClient getClient() {
            return client;
        }

        //Este método se encargara de construir una solicitud HTTP (HttpRequest)
        // a la API, usando una URL con parámetros dinámicos:
        // moneda base y moneda objetivo.

        //String.format(...): construye la URL usando los códigos de moneda base y destino.
        //HttpRequest.newBuilder(): crea una solicitud HTTP.
        //.uri(...): especifica la dirección a la que se enviará la solicitud.
        //.GET(): es una solicitud de tipo GET (porque no estamos enviando datos, solo solicitándolos).
        //.build(): finaliza la construcción del objeto.

        public HttpRequest createRequest(String baseCode, String targetCode) {
               String apiKey = "59fa01b6e1764f26115f52fa";  // API_KEY
               String uri = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                                            apiKey, baseCode, targetCode);

            return HttpRequest.newBuilder()
                              .uri(URI.create(uri))
                              .GET()
                              .build();
       }
}

