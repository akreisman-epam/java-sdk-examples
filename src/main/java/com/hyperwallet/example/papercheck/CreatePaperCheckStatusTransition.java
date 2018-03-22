package com.hyperwallet.example.papercheck;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletStatusTransition;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreatePaperCheckStatusTransition {

    public static void main(String[] args) throws Exception {
        String username = System.getProperty("HYPERWALLET_USERNAME");
        String password = System.getProperty("HYPERWALLET_PASSWORD");

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             "prg-44a64920-45fc-4578-a7f9-e14813b3ed54");

        HyperwalletStatusTransition transition = new HyperwalletStatusTransition();
        transition.setTransition(HyperwalletStatusTransition.Status.DE_ACTIVATED);

        HyperwalletStatusTransition statusTransition = client.createPaperCheckStatusTransition("usr-b4a1f0bd-cbf7-4467-aa6f-4445dea7e67d",
                                                                                             "trm-b379ca8e-973a-47d4-a79c-eaaf2af89ee6",
                                                                                             transition);

        System.out.println(ToStringBuilder.reflectionToString(statusTransition, new MultilineRecursiveToStringStyle()));
    }
}
