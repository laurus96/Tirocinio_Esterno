package com.esercizio.publisherData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class WriterService {
    private final Gson gson;
    //private static Logger LOGGER = LoggerFactory.getLogger(WriterService.class);

    public WriterService() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void log(String message){
        log.info(message);
    }

    public String write(String fileName, Map<?, ?> writableStructure) throws IOException {
        File myFile = new File(fileName);

        if (myFile.createNewFile()) {
            log.info("> " + fileName + " creato.");
        }else
            log.info("> " + fileName + " già presente.");

        FileWriter writer = new FileWriter(fileName);
        String jsonData = gson.toJson(writableStructure);
        writer.write(jsonData);

        writer.close();

        return "Scrittura completata su " + fileName;

    }
}
