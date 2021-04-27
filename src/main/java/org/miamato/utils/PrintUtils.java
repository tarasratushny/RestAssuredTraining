package org.miamato.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintUtils {

    private static final Logger log = LogManager.getLogger(PrintUtils.class.getSimpleName());

    public static String prettyPrintPojo(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String prettyJson = null;
        try{
            log.info("Converting pojo object to pretty string");
            prettyJson = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Conversion failed");
            log.error(e.getMessage());
        }
        return prettyJson;
    }

}
