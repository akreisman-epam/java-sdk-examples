package com.hyperwallet.example.bankcard;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletStatusTransition;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreateBankCardStatusTransition {

    public static void main(String[] args) throws Exception {
        String username = System.getProperty("HYPERWALLET_USERNAME");
        String password = System.getProperty("HYPERWALLET_PASSWORD");

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             "prg-44a64920-45fc-4578-a7f9-e14813b3ed54");

        HyperwalletStatusTransition transition = new HyperwalletStatusTransition();
        transition.setTransition(HyperwalletStatusTransition.Status.DE_ACTIVATED);

        HyperwalletStatusTransition statusTransition = client.createBankCardStatusTransition("usr-0fb6d624-f18d-480d-b1e7-f48f534bbd75",
                                                                                             "trm-02d27299-55bf-4a13-b37e-3ab246efd95a",
                                                                                             transition);

        System.out.println(ToStringBuilder.reflectionToString(statusTransition, new MultilineRecursiveToStringStyle()));
    }
}
