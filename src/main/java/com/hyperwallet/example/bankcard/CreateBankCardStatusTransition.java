package com.hyperwallet.example.bankcard;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletStatusTransition;
import com.hyperwallet.example.Util;

public class CreateBankCardStatusTransition {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String userToken = (args.length > i) ? args[i++] : "usr-0fb6d624-f18d-480d-b1e7-f48f534bbd75";
        String bankCardToken = (args.length > i) ? args[i++] : "trm-02d27299-55bf-4a13-b37e-3ab246efd95a";

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             programToken);

        HyperwalletStatusTransition transition = new HyperwalletStatusTransition();
        transition.setTransition(HyperwalletStatusTransition.Status.DE_ACTIVATED);

        HyperwalletStatusTransition statusTransition = client.createBankCardStatusTransition(userToken,
                                                                                             bankCardToken,
                                                                                             transition);

        Util.print(statusTransition);
    }
}
