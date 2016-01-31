package it.databiz.ethereum;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;

/**
 * Created by bigmoby on 29/01/16.
 */
public class BlockInfo {

    private String number;
    private String hash;
    private String parentHash;
    private String nonce;
    private String sha3Uncles;
    private String logsBloom;
    private String transactionsRoot;
    private String stateRoot;
    private String receiptRoot;
    private String miner;
    private String difficulty;
    private String totalDifficulty;
    private String size;
    private String extraData;
    private String gasLimit;
    private String gasUsed;
    private String timestamp;
    private Transaction[] transactions;
    private String[] uncles;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getParentHash() {
        return parentHash;
    }

    public void setParentHash(String parentHash) {
        this.parentHash = parentHash;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSha3Uncles() {
        return sha3Uncles;
    }

    public void setSha3Uncles(String sha3Uncles) {
        this.sha3Uncles = sha3Uncles;
    }

    public String getLogsBloom() {
        return logsBloom;
    }

    public void setLogsBloom(String logsBloom) {
        this.logsBloom = logsBloom;
    }

    public String getTransactionsRoot() {
        return transactionsRoot;
    }

    public void setTransactionsRoot(String transactionsRoot) {
        this.transactionsRoot = transactionsRoot;
    }

    public String getStateRoot() {
        return stateRoot;
    }

    public void setStateRoot(String stateRoot) {
        this.stateRoot = stateRoot;
    }

    public String getReceiptRoot() {
        return receiptRoot;
    }

    public void setReceiptRoot(String receiptRoot) {
        this.receiptRoot = receiptRoot;
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTotalDifficulty() {
        return totalDifficulty;
    }

    public void setTotalDifficulty(String totalDifficulty) {
        this.totalDifficulty = totalDifficulty;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    public String getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    public String[] getUncles() {
        return uncles;
    }

    public void setUncles(String[] uncles) {
        this.uncles = uncles;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("number", Utils.toNumber(number))
                .append("hash", hash)
                .append("parentHash", parentHash)
                .append("nonce", nonce)
                .append("sha3Uncles", sha3Uncles)
                .append("logsBloom", logsBloom)
                .append("transactionsRoot", transactionsRoot)
                .append("stateRoot", stateRoot)
                .append("receiptRoot", receiptRoot)
                .append("miner", miner)
                .append("difficulty", Utils.toNumber(difficulty))
                .append("totalDifficulty", totalDifficulty)
                .append("size", Utils.toNumber(size))
                .append("extraData", extraData)
                .append("gasLimit", Utils.toNumber(gasLimit))
                .append("gasUsed", Utils.toNumber(gasUsed))
                .append("timestamp", Utils.toNumber(timestamp))
                .append("\ntransactions", transactions)
                .append("\nuncles", uncles)
                .toString();
    }
}
