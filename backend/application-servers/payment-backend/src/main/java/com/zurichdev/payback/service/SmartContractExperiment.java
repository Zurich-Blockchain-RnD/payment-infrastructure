package com.zurichdev.payback.service;

import com.zurichdev.payback.ethereum.Dentist;
import com.zurichdev.payback.ethereum.Storage;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by thanak on 10/1/2018.
 * Place to experiment...you don't need to start whole server if you just want to call Ethereum network trough Infura.
 * Infura token is mine, use it.
 * You can use this guide: https://docs.web3j.io/smart_contracts.html
 * and generate your solidity contract in Java, pretty powerful, example with test/java folders and proper package in this project:
 * web3j solidity generate storage.bin storage.abi -o test/java -p com.zurichdev.payback.ethereum
 * Unfortunately deployment doesn't work. I always end up with Ethereum error :-(
 */
public class SmartContractExperiment {


    private static final String C_TEMP_WALLET = "c:/temp/wallet";

    public static void main(String[] args) {
        try {
            Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/33d188c393be4e53ac1b3afe82066767"));
            Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            System.out.println("Client version:" + clientVersion);

            deployContract(web3);

            web3.shutdown();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deployContract(Web3j web3) throws Exception {


        Credentials credentials = getCredentials();
        //deploy contract, expect it to wait several minutes as its synchronous call and creating contract takes a few minutes
        //Dentist dentistContract = Dentist.deploy(web3, credentials, Dentist.GAS_PRICE, Dentist.GAS_LIMIT).send();  // constructor params
        Storage storageContract = Storage.deploy(web3, credentials, Storage.GAS_PRICE, Storage.GAS_LIMIT).send();
    }

    private static Credentials getCredentials() throws IOException, CipherException {
        //you need to use some local wallet file. Could be generated with MyEtherWallet.com. Its in the project in case you need example.
        String walletFile = C_TEMP_WALLET+"/UTC--2018-09-30T11-44-14.517000000Z--87a3d5362590e8d263c04c1fd957d11a26cad520.json";
        return WalletUtils.loadCredentials("password", walletFile);
    }

    public static void callContract(Web3j web3) throws IOException, CipherException {
        //TODO: fill up proper address, when cotract deploy succeed...which is not the case now
        Dentist dentistContract = Dentist.load("0x<address>|<ensName>", web3, getCredentials(), Storage.GAS_PRICE, Storage.GAS_LIMIT);
    }

    private static void generateWallet() throws CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
        File wallet = new File(C_TEMP_WALLET);
        String fileGenerated = WalletUtils.generateNewWalletFile("password",wallet);
        System.out.println(fileGenerated);
        String generatedFile = wallet.getAbsolutePath() + "/" + fileGenerated;
    }

}
