package com.hyperwallet.example.payment;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletStatusTransition;
import com.hyperwallet.example.Util;

public class RetrievePaymentStatusTransition {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String paymentToken = (args.length > i) ? args[i++] : "pmt-129a7e89-fb1f-4ef6-956b-640afc570837";
        String statusTransitionToken = (args.length > i) ? args[i++] : "sts-9b45f86c-090d-4190-b508-bf615318c28e";

        Hyperwallet client = new Hyperwallet(username,
                password,
                programToken);

        HyperwalletStatusTransition
                statusTransition =
                client.getPaymentStatusTransition(paymentToken,
                        statusTransitionToken);

        Util.print(statusTransition);
    }
}
