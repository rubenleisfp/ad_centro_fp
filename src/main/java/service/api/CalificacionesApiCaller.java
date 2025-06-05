package service.api;



import service.dto.RecordDTO;

import java.io.IOException;

public interface CalificacionesApiCaller {

    RecordDTO getRecord() throws ApiCallException, IOException, InterruptedException;
}
