package com.hyperwallet.example.transfer;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletTransfer;
import com.hyperwallet.example.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateTransfer {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String sourceToken = (args.length > i) ? args[i++] : "usr-b4a1f0bd-cbf7-4467-aa6f-4445dea7e67d";
        String destinationToken = (args.length > i) ? args[i++] : "trm-2102dd61-3bed-40f9-aa25-56087cf2c75b";

        Hyperwallet client = new Hyperwallet(username,
                password,
                programToken);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String clientTransferId = dateFormat.format(new Date());
        HyperwalletTransfer transfer = new HyperwalletTransfer()
                .clientTransferId(clientTransferId)
                .sourceToken(sourceToken)
                .destinationToken(destinationToken);

        HyperwalletTransfer createdTransfer = client.createTransfer(transfer);

        Util.print(createdTransfer);
    }
}
