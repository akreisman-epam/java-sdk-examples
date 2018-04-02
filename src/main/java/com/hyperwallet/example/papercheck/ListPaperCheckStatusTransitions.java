package com.hyperwallet.example.papercheck;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletList;
import com.hyperwallet.clientsdk.model.HyperwalletStatusTransition;
import com.hyperwallet.example.Util;

public class ListPaperCheckStatusTransitions {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String userToken = (args.length > i) ? args[i++] : "usr-b4a1f0bd-cbf7-4467-aa6f-4445dea7e67d";
        String paperCheckToken = (args.length > i) ? args[i++] : "trm-b379ca8e-973a-47d4-a79c-eaaf2af89ee6";

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             programToken);

        HyperwalletList<HyperwalletStatusTransition> statusTransitions =
                client.listPaperCheckStatusTransitions(userToken, paperCheckToken);

        Util.print(statusTransitions);
    }
}
