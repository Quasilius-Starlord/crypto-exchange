package com.example.crypto;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple6;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class Ethereum {
    private static Ethereum ethereum = null;
    private static Web3j web3j;

    final static private BigInteger GAS_LIMIT = new BigInteger(String.valueOf(3000000L));
    final static private BigInteger GAS_PRICE = new BigInteger(String.valueOf(300000L));

    private static CryptoTrade contract;
    Credentials credentials = null;

    public static class CoinCode{
        public static final int ETHEREUM = 1;
        public static final int BINANCE = 2;
        public static final int BITCOIN = 3;
        public static final int DAICOIN = 4;
        public static final int LINKCOIN = 5;
        public static final int LITECOIN = 6;
        public static final int SWISS_FRANC = 7;
        public static final int COMPOUND = 8;
        public static final int TRON = 9;
        public static final int UNISWAP = 10;
        public static final int VELO = 11;
    }

    public static interface CoinStats{
        BigInteger getRoundID();

        BigInteger getAnswer();

        BigInteger getStartedAt();

        BigInteger getUpdatedAt();

        BigInteger getAnsweredInRound();

        BigInteger getDecimal();
    }

    private static class EthereumBlockCountThread extends Thread{
        String blockCount;
        String validity;
        EthereumBlockCountThread(){
            blockCount=new String("0");
        }

        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(2000);
                EthBlockNumber blockNumber = web3j.ethBlockNumber().sendAsync().get();
                blockCount = blockNumber.getBlockNumber().toString();
                validity = String.valueOf(contract.isValid());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getBlockCount(){
            return blockCount;
        }

        public String getValidity() {
            return validity;
        }
    }

    private static class EthereumETHToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceETHToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID(){
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt(){
            return startedAt;
        }

        public BigInteger getUpdatedAt(){
            return updatedAt;
        }

        public BigInteger getAnsweredInRound(){
            return answeredInRound;
        }

        public BigInteger getDecimal(){
            return decimal;
        }
    }

    private static class EthereumBNBToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceBNBToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID() {
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt() {
            return startedAt;
        }

        public BigInteger getUpdatedAt() {
            return updatedAt;
        }

        public BigInteger getAnsweredInRound() {
            return answeredInRound;
        }

        public BigInteger getDecimal() {
            return decimal;
        }
    }

    private static class EthereumBTCToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceBTCToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID() {
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt() {
            return startedAt;
        }

        public BigInteger getUpdatedAt() {
            return updatedAt;
        }

        public BigInteger getAnsweredInRound() {
            return answeredInRound;
        }

        public BigInteger getDecimal() {
            return decimal;
        }
    }

    private static class EthereumDAIToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceDAIToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID() {
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt() {
            return startedAt;
        }

        public BigInteger getUpdatedAt() {
            return updatedAt;
        }

        public BigInteger getAnsweredInRound() {
            return answeredInRound;
        }

        public BigInteger getDecimal() {
            return decimal;
        }
    }

    private static class EthereumLINKToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceLINKToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID() {
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt() {
            return startedAt;
        }

        public BigInteger getUpdatedAt() {
            return updatedAt;
        }

        public BigInteger getAnsweredInRound() {
            return answeredInRound;
        }

        public BigInteger getDecimal() {
            return decimal;
        }
    }

    private static class EthereumLTCToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceLTCToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID() {
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt() {
            return startedAt;
        }

        public BigInteger getUpdatedAt() {
            return updatedAt;
        }

        public BigInteger getAnsweredInRound() {
            return answeredInRound;
        }

        public BigInteger getDecimal() {
            return decimal;
        }
    }

    private static class EthereumCHFTToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceCHFTToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID() {
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt() {
            return startedAt;
        }

        public BigInteger getUpdatedAt() {
            return updatedAt;
        }

        public BigInteger getAnsweredInRound() {
            return answeredInRound;
        }

        public BigInteger getDecimal() {
            return decimal;
        }
    }

    private static class EthereumCOMPToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceCOMPToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID() {
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt() {
            return startedAt;
        }

        public BigInteger getUpdatedAt() {
            return updatedAt;
        }

        public BigInteger getAnsweredInRound() {
            return answeredInRound;
        }

        public BigInteger getDecimal() {
            return decimal;
        }
    }

    private static class EthereumTRXToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceTRXToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID() {
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt() {
            return startedAt;
        }

        public BigInteger getUpdatedAt() {
            return updatedAt;
        }

        public BigInteger getAnsweredInRound() {
            return answeredInRound;
        }

        public BigInteger getDecimal() {
            return decimal;
        }
    }

    private static class EthereumUNIToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceUNIToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID() {
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt() {
            return startedAt;
        }

        public BigInteger getUpdatedAt() {
            return updatedAt;
        }

        public BigInteger getAnsweredInRound() {
            return answeredInRound;
        }

        public BigInteger getDecimal() {
            return decimal;
        }
    }

    private static class EthereumVELOToUSDThread extends Thread implements CoinStats{
        private BigInteger roundID;
        private BigInteger answer;
        private BigInteger startedAt;
        private BigInteger updatedAt;
        private BigInteger answeredInRound;
        private BigInteger decimal;

        @Override
        public void run() {
            super.run();
            try {
                Tuple6<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> pricefeed = contract.getLatestPriceVELOToUSD().send();
                System.out.println("price of "+pricefeed.toString());
                roundID = pricefeed.component1();
                answer = pricefeed.component2();
                startedAt = pricefeed.component3();
                updatedAt = pricefeed.component4();
                answeredInRound = pricefeed.component5();
                decimal = pricefeed.component6();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public BigInteger getRoundID() {
            return roundID;
        }

        public BigInteger getAnswer(){
            return answer;
        }

        public BigInteger getStartedAt() {
            return startedAt;
        }

        public BigInteger getUpdatedAt() {
            return updatedAt;
        }

        public BigInteger getAnsweredInRound() {
            return answeredInRound;
        }

        public BigInteger getDecimal() {
            return decimal;
        }
    }

    private Ethereum() throws IOException {
        web3j = Web3j.build(new HttpService("https://kovan.infura.io/v3/64ddd9125ae5409093ebd43f2939e1ff"));
        credentials = Credentials.create("0ce95fca9455a57cfcec56223f8287c92078433214d307577ffa951718962a48");
        contract = CryptoTrade.load("0x5cec46aF447C52d030ee00CaFe95445A96047a02",web3j,credentials,GAS_LIMIT,GAS_PRICE);
    }

    public String getBlockCount() {
        EthereumBlockCountThread ethereumBlockCountThread = new EthereumBlockCountThread();
        ethereumBlockCountThread.start();

        System.out.println(ethereumBlockCountThread.getValidity());
        return ethereumBlockCountThread.getBlockCount();
    }

    public BigInteger getEthereumETHToUSD(){
        EthereumETHToUSDThread ethereumETHToUSDThread = new EthereumETHToUSDThread();
        try{
            ethereumETHToUSDThread.start();
            ethereumETHToUSDThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        BigInteger price = ethereumETHToUSDThread.getAnswer();
        return price;
    }

    public Tuple6<BigInteger,BigInteger,BigInteger,BigInteger,BigInteger,BigInteger> getCoinToUSD(int COINCODE){
        CoinStats coinstats=null;
        Thread coinThread=null;
        switch (COINCODE){
            case CoinCode.ETHEREUM:{
                coinThread=new EthereumETHToUSDThread();
                break;
            }
            case CoinCode.BINANCE:{
                coinThread=new EthereumBNBToUSDThread();
                break;
            }
            case CoinCode.BITCOIN:{
                coinThread=new EthereumBTCToUSDThread();
                break;
            }
            case CoinCode.DAICOIN:{
                coinThread=new EthereumDAIToUSDThread();
                break;
            }
            case CoinCode.LINKCOIN:{
                coinThread=new EthereumLINKToUSDThread();
                break;
            }
            case CoinCode.LITECOIN:{
                coinThread=new EthereumLTCToUSDThread();
                break;
            }
            case CoinCode.SWISS_FRANC:{
                coinThread=new EthereumCHFTToUSDThread();
                break;
            }
            case CoinCode.COMPOUND:{
                coinThread=new EthereumCOMPToUSDThread();
                break;
            }
            case CoinCode.TRON:{
                coinThread=new EthereumTRXToUSDThread();
                break;
            }
            case CoinCode.UNISWAP:{
                coinThread=new EthereumUNIToUSDThread();
                break;
            }
            case CoinCode.VELO:{
                coinThread=new EthereumVELOToUSDThread();
                break;
            }
        }
        try{
            coinThread.start();
            coinThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        coinstats= (CoinStats) coinThread;

        return new Tuple6<BigInteger,BigInteger,BigInteger,BigInteger,BigInteger,BigInteger>(
                coinstats.getRoundID(),
                coinstats.getAnswer(),
                coinstats.getStartedAt(),
                coinstats.getUpdatedAt(),
                coinstats.getAnsweredInRound(),
                coinstats.getDecimal()
        );
    }

    public static Ethereum getInstance() throws IOException {
        if(ethereum == null){
            ethereum = new Ethereum();
        }
        return ethereum;
    }
}
