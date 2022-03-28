// SPDX-License-Identifier: GPL-3.0
pragma solidity 0.8.12;

import "@chainlink/contracts/src/v0.8/interfaces/AggregatorV3Interface.sol";

contract CryptoTrade{
    AggregatorV3Interface internal priceFeedETHToUSD;
    AggregatorV3Interface internal priceFeedBNBToUSD;
    AggregatorV3Interface internal priceFeedBTCToUSD;
    AggregatorV3Interface internal priceFeedDAIToUSD;
    AggregatorV3Interface internal priceFeedLINKToUSD;
    AggregatorV3Interface internal priceFeedLTCToUSD;
    AggregatorV3Interface internal priceFeedCHFTToUSD;
    AggregatorV3Interface internal priceFeedCOMPToUSD;
    AggregatorV3Interface internal priceFeedTRXToUSD;
    AggregatorV3Interface internal priceFeedUNIToUSD;
    AggregatorV3Interface internal priceFeedVELOToUSD;

    //constructor made for kovan network
    constructor(){
        priceFeedETHToUSD = AggregatorV3Interface(0x9326BFA02ADD2366b30bacB125260Af641031331); //ethereum
        priceFeedBNBToUSD = AggregatorV3Interface(0x8993ED705cdf5e84D0a3B754b5Ee0e1783fcdF16); //binance
        priceFeedBTCToUSD = AggregatorV3Interface(0x6135b13325bfC4B00278B4abC5e20bbce2D6580e); //bitcoin
        priceFeedDAIToUSD = AggregatorV3Interface(0x777A68032a88E5A84678A77Af2CD65A7b3c0775a); //daicoin
        priceFeedLINKToUSD = AggregatorV3Interface(0x396c5E36DD0a0F5a5D33dae44368D4193f69a1F0); //link coin
        priceFeedLTCToUSD = AggregatorV3Interface(0x4d38a35C2D87976F334c2d2379b535F1D461D9B4); //litecoin
        priceFeedCHFTToUSD = AggregatorV3Interface(0xed0616BeF04D374969f302a34AE4A63882490A8C); //Swiss Franc
        priceFeedCOMPToUSD = AggregatorV3Interface(0xECF93D14d25E02bA2C13698eeDca9aA98348EFb6); //compound token
        priceFeedTRXToUSD = AggregatorV3Interface(0x9477f0E5bfABaf253eacEE3beE3ccF08b46cc79c); //tron
        priceFeedUNIToUSD = AggregatorV3Interface(0xDA5904BdBfB4EF12a3955aEcA103F51dc87c7C39); //uniswap
        priceFeedVELOToUSD = AggregatorV3Interface(0x6d393f929E213D2Ca67A7FA73108A42b884F5f74); //velo
    }

    function getLatestPriceETHToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // ethereum
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedETHToUSD.latestRoundData();
        uint8 decimal = priceFeedETHToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }

    function getLatestPriceBNBToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // binance
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedBNBToUSD.latestRoundData();
        uint8 decimal = priceFeedETHToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }

    function getLatestPriceBTCToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // bitcoin
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedBTCToUSD.latestRoundData();
        uint8 decimal = priceFeedBTCToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }

    function getLatestPriceDAIToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // daicoin
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedDAIToUSD.latestRoundData();
        uint8 decimal = priceFeedDAIToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }

    function getLatestPriceLINKToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // link coin
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedLINKToUSD.latestRoundData();
        uint8 decimal = priceFeedLINKToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }

    function getLatestPriceLTCToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // litecoin
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedLTCToUSD.latestRoundData();
        uint8 decimal = priceFeedLTCToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }

    function getLatestPriceCHFTToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // Swiss Franc
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedCHFTToUSD.latestRoundData();
        uint8 decimal = priceFeedCHFTToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }

    function getLatestPriceCOMPToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // compound token
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedCOMPToUSD.latestRoundData();
        uint8 decimal = priceFeedCOMPToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }

    function getLatestPriceTRXToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // tron token
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedTRXToUSD.latestRoundData();
        uint8 decimal = priceFeedTRXToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }

    function getLatestPriceUNIToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // uniswap token
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedUNIToUSD.latestRoundData();
        uint8 decimal = priceFeedUNIToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }

    function getLatestPriceVELOToUSD() public view returns (uint80,int256,uint256,uint256,uint80,uint8){
        // velo
        (
            uint80 roundID,
            int256 price,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answeredInRound
        ) = priceFeedVELOToUSD.latestRoundData();
        uint8 decimal = priceFeedVELOToUSD.decimals();
        return (roundID,price,startedAt,updatedAt,answeredInRound,decimal);
    }
}


// 0x5cec46aF447C52d030ee00CaFe95445A96047a02