package com.hyperwallet.example.transfer;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletList;
import com.hyperwallet.clientsdk.model.HyperwalletTransfer;
import com.hyperwallet.clientsdk.model.HyperwalletTransferListOptions;
import com.hyperwallet.example.Util;

public class ListTransfers {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String sourceToken = (args.length > i) ? args[i++] : "usr-b4a1f0bd-cbf7-4467-aa6f-4445dea7e67d";

        Hyperwallet client = new Hyperwallet(username,
                password,
                programToken);

        HyperwalletTransferListOptions options = new HyperwalletTransferListOptions();
        options.sourceToken(sourceToken);
        options.limit(5);

        HyperwalletList<HyperwalletTransfer> transfers = client.listTransfers(options);

        Util.print(transfers);
    }
}
