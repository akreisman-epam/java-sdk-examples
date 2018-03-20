package com.hyperwallet.example;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletBankCard;
import com.hyperwallet.clientsdk.model.HyperwalletList;
import com.hyperwallet.clientsdk.model.HyperwalletPaginationOptions;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ListBankCards {

    public static void main(String[] args) throws Exception {
        String username = System.getProperty("HYPERWALLET_USERNAME");
        String password = System.getProperty("HYPERWALLET_PASSWORD");

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             "prg-44a64920-45fc-4578-a7f9-e14813b3ed54");

        HyperwalletPaginationOptions options = new HyperwalletPaginationOptions().limit(5);
        HyperwalletList<HyperwalletBankCard>
            bankCards =
            client.listBankCards("usr-0fb6d624-f18d-480d-b1e7-f48f534bbd75", options);

        System.out.println(ToStringBuilder.reflectionToString(bankCards, new MultilineRecursiveToStringStyle()));
    }

}
