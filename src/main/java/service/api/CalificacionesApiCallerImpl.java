package service.api;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import service.dto.RecordDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CalificacionesApiCallerImpl implements CalificacionesApiCaller {

    //https://api.jsonbin.io/v3/b/684069908960c979a5a53c21
    private String basePath;
    private Gson gson;


    // https://dummyjson.com/
    public CalificacionesApiCallerImpl(String basePath) {
        this.basePath = basePath;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public RecordDTO getRecord() throws ApiCallException, IOException, InterruptedException {

        HttpResponse<String> response = null;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath)).headers("X-Access-Key","$2a$10$4YgatT4iXPwhqpC6IRy44OTZjDNITUdJbtRwEIP2V58Vv9mzPJw3i",    "X-Bin-Meta", "false")
                .method("GET", HttpRequest.BodyPublishers.noBody()).build();


        response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        handleResponse(response);
        RecordDTO recordDTO = gson.fromJson(response.body(), RecordDTO.class);
        return recordDTO;
    }

    private void handleResponse(HttpResponse<String> response) throws ApiCallException {
        int statusCode = response.statusCode();
        if (statusCode != 200 && statusCode != 201) {
            handleError(response);
        }
    }

    private void handleError(HttpResponse<String> response) throws ApiCallException {
        String responseBody = response.body();
        switch (response.statusCode()) {
            case 401:
                throw new ApiCallException("Problemas de permisos", response.statusCode(), responseBody);
            case 404:
                throw new ApiCallException("El recurso no fue encontrado.", response.statusCode(), responseBody);
            case 400:
                throw new ApiCallException("Error en la solicitud del cliente.", response.statusCode(), responseBody);
            case 500:
                throw new ApiCallException("Error en el servidor.", response.statusCode(), responseBody);
            default:
                throw new ApiCallException("Error desconocido", response.statusCode(), responseBody);
        }
    }



}
