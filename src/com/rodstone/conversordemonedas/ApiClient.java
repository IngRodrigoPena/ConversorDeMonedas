package com.rodstone.conversordemonedas;
import java.net.http.HttpClient;

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
}

