package com.hyperwallet.example;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletStatusTransition;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RetrieveBankCardStatusTransition {

    public static void main(String[] args) throws Exception {
        String username = System.getProperty("HYPERWALLET_USERNAME");
        String password = System.getProperty("HYPERWALLET_PASSWORD");

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             "prg-44a64920-45fc-4578-a7f9-e14813b3ed54");

        HyperwalletStatusTransition
            statusTransition =
            client.getBankCardStatusTransition("usr-0fb6d624-f18d-480d-b1e7-f48f534bbd75",
                                               "trm-3bdcb6c3-022b-4263-bec9-3efce4c4cb35",
                                               "sts-9b45f86c-090d-4190-b508-bf615318c28e");

        System.out.println(ToStringBuilder.reflectionToString(statusTransition, new MultilineRecursiveToStringStyle()));
    }
}
