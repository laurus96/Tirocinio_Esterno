package com.esercizio.xmlParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@Getter
@Setter
@Slf4j
public class Xml2JsonService {

    private JAXBContext context;
    private Unmarshaller unmarshaller;
    private Gson gson;
    private String fileToUnmarsh;

    public Xml2JsonService() throws JAXBException, IOException {
        this(null);
        gson = new GsonBuilder().setPrettyPrinting().create();

    }

    private Xml2JsonService(String fileToUnmarsh) {
        this.fileToUnmarsh = fileToUnmarsh;

    }

    public <classToUnmarsh> void toJson(Class<classToUnmarsh> umClass) throws JAXBException {
        this.context = JAXBContext.newInstance(umClass);
        this.unmarshaller = this.context.createUnmarshaller();

        Object ob = this.unmarshaller.unmarshal(new File(this.fileToUnmarsh));

        if (isInstace(ob, umClass)){
            classToUnmarsh c = (classToUnmarsh) ob;
            log.info(this.gson.toJson(ob));
        }
    }

    private boolean isInstace(Object object, Class<?> type){
        return  type.isInstance(object);
    }
}
