package com.hyperwallet.example.bankcard;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletStatusTransition;
import com.hyperwallet.example.Util;

public class RetrieveBankCardStatusTransition {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String userToken = (args.length > i) ? args[i++] : "usr-0fb6d624-f18d-480d-b1e7-f48f534bbd75";
        String bankCardToken = (args.length > i) ? args[i++] : "trm-3bdcb6c3-022b-4263-bec9-3efce4c4cb35";
        String statusTransitionToken = (args.length > i) ? args[i++] : "sts-9b45f86c-090d-4190-b508-bf615318c28e";

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             programToken);

        HyperwalletStatusTransition
            statusTransition =
            client.getBankCardStatusTransition(userToken,
                                               bankCardToken,
                                               statusTransitionToken);

        Util.print(statusTransition);
    }
}
