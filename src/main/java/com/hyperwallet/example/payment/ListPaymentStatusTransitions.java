package com.hyperwallet.example.payment;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletList;
import com.hyperwallet.clientsdk.model.HyperwalletStatusTransition;
import com.hyperwallet.example.Util;

public class ListPaymentStatusTransitions {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String paymentToken = (args.length > i) ? args[i++] : "pmt-129a7e89-fb1f-4ef6-956b-640afc570837";

        Hyperwallet client = new Hyperwallet(username,
                password,
                programToken);

        HyperwalletList<HyperwalletStatusTransition>
                statusTransitions =
                client.listPaymentStatusTransitions(paymentToken);

        Util.print(statusTransitions);
    }
}
