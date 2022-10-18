package com.esercizio.xmlParser;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Slf4j
public class App {

    public static void main(String @NotNull [] args ) {

//        JAXBContext context = JAXBContext.newInstance(CreditCard.class);
//        Unmarshaller um = context.createUnmarshaller();
//
//        File file = new File(args[0]);
//
//        CreditCard c1 = (CreditCard) um.unmarshal(file);
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String jsonXml = gson.toJson(c1);
//
//        log.info(jsonXml);

        try {
            Xml2JsonService service = new Xml2JsonService();
            service.setFileToUnmarsh(args[0]);
            service.toJson(CreditCard.class);
        }

        catch (JAXBException | IOException je){
           log.error(je.getMessage());
        }


    }
}
