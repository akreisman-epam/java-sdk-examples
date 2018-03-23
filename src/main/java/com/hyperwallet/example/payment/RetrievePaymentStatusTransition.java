package com.hyperwallet.example.payment;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletStatusTransition;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RetrievePaymentStatusTransition {

    public static void main(String[] args) throws Exception {
        String username = System.getProperty("HYPERWALLET_USERNAME");
        String password = System.getProperty("HYPERWALLET_PASSWORD");

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             "prg-44a64920-45fc-4578-a7f9-e14813b3ed54");

        HyperwalletStatusTransition
            statusTransition =
            client.getPaymentStatusTransition("pmt-129a7e89-fb1f-4ef6-956b-640afc570837",
                                               "sts-c8862f43-f3ad-4b0c-ad23-001c047ec050");

        System.out.println(ToStringBuilder.reflectionToString(statusTransition, new MultilineRecursiveToStringStyle()));
    }
}
