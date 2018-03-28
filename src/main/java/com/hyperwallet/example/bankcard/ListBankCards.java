package com.hyperwallet.example.bankcard;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletBankCard;
import com.hyperwallet.clientsdk.model.HyperwalletList;
import com.hyperwallet.clientsdk.model.HyperwalletPaginationOptions;
import com.hyperwallet.example.Util;

public class ListBankCards {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String userToken = (args.length > i) ? args[i++] : "usr-0fb6d624-f18d-480d-b1e7-f48f534bbd75";
        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             programToken);

        HyperwalletPaginationOptions options = new HyperwalletPaginationOptions().limit(5);
        HyperwalletList<HyperwalletBankCard>
            bankCards =
            client.listBankCards(userToken, options);

        Util.print(bankCards);
    }

}
