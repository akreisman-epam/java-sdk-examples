package com.hyperwallet.example.bankcard;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletBankCard;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CreateBankCard {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z");

    public static void main(String[] args) throws Exception {
        String username = System.getProperty("HYPERWALLET_USERNAME");
        String password = System.getProperty("HYPERWALLET_PASSWORD");

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             "prg-44a64920-45fc-4578-a7f9-e14813b3ed54");

        HyperwalletBankCard bankCard = new HyperwalletBankCard()
            .userToken("usr-0fb6d624-f18d-480d-b1e7-f48f534bbd75")
            .cardNumber("4216701111100120")
            .dateOfExpiry(dateFormat.parse("2020-01-01T00:00:00 UTC"))
            .transferMethodCountry("US")
            .transferMethodCurrency("USD");

        HyperwalletBankCard createdBankCard = client.createBankCard(bankCard);

        System.out.println(ToStringBuilder.reflectionToString(createdBankCard, new MultilineRecursiveToStringStyle()));
    }

}
