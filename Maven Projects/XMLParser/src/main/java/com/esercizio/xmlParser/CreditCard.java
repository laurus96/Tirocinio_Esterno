package com.esercizio.xmlParser;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@ToString

@XmlRootElement
public class CreditCard {

    private String number;
    private String expiryDate;
    private Integer controlNumber;
    private String type;


}
