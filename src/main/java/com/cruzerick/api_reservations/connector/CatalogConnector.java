package com.cruzerick.api_reservations.connector;

import com.cruzerick.api_reservations.connector.configuration.EndpointConfiguration;
import com.cruzerick.api_reservations.connector.configuration.HostConfiguration;
import com.cruzerick.api_reservations.connector.configuration.HttpConnectorConfiguration;
import com.cruzerick.api_reservations.connector.response.CityDTO;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Component
public class CatalogConnector {
    private final String HOST = "api-catalog";
    private final String ENDPOINT = "get-city";


    private HttpConnectorConfiguration configuration;

    @Autowired
    public CatalogConnector(HttpConnectorConfiguration configuration){
            this.configuration = configuration;
     }


    // Metodo que se conecta a un servicio externo para obtener la informacion de una ciudad
    public CityDTO getCity(String code) {
        // PAra acceder a los valores del archivo application.yml
        HostConfiguration hostConfiguration = this.configuration.getHosts().get(HOST);
        EndpointConfiguration endpointConfiguration = hostConfiguration.getEndpoints().get(ENDPOINT);

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, Math.toIntExact(endpointConfiguration.getConnectionTimeout()))
                .doOnConnected(conn -> conn
                        .addHandler(new ReadTimeoutHandler(endpointConfiguration.getReadTimeout(), TimeUnit.MILLISECONDS))
                        .addHandler(new WriteTimeoutHandler(endpointConfiguration.getWriteTimeout(), TimeUnit.MILLISECONDS)));


        // clase que se encarga de la comunicacion con el servicio externo
        WebClient client = WebClient.builder()
//                .baseUrl("http://localhost:6070/api/flights/catalog/city/{code}") //se inserta el parametro code con {code}
                .baseUrl("http://" + hostConfiguration.getHost() + ":" + hostConfiguration.getPort() + endpointConfiguration.getUrl())
                //se definen los headers
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) // peticion en formato JSON
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE) // respuesta en formato JSON
//                .clientConnector(new ReactorClientHttpConnector(HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE))) // se crea el cliente
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        return client.get()
                // funcion lambda que recibe un objeto de tipo UriBuilder y retorna un objeto de tipo UriBuilder
                .uri(uriBuilder -> uriBuilder.build(code))
                .retrieve()// se realiza la peticion de obtener informacion
                .bodyToMono(CityDTO.class) // la convierte en un objeto
//                .bodyToFlux(CityListDTO.class) // la convierte en un listado de objetos
                .share()
                .block(); // peticion sincronico: se bloquea la ejecucion hasta que se obtenga la respuesta

    }
}
