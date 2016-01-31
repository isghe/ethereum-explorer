package it.databiz.ethereum;

/**
 * Created by bigmoby on 29/01/16.
 */
public class Params {
    private boolean transaction;
    private boolean balance;
    private boolean infos;
    private boolean allInfos;
    private String fromAddress;
    private String blockNumber;
    private String host;
    private String port;
    private boolean manual;

    public Params(final String fromAddress, final String blockNumber, final boolean transaction, final boolean balance,
                  final boolean infos, final boolean allInfos, final String host, final String port, final boolean manual) {
        this.fromAddress = fromAddress;
        this.blockNumber = blockNumber;
        this.balance = balance;
        this.transaction = transaction;
        this.infos = infos;
        this.allInfos = allInfos;
        this.host = host;
        this.port = port;
        this.manual = manual;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public boolean isTransaction() {
        return transaction;
    }

    public void setTransaction(boolean transaction) {
        this.transaction = transaction;
    }

    public boolean isBalance() {
        return balance;
    }

    public void setBalance(boolean balance) {
        this.balance = balance;
    }

    public boolean isInfos() {
        return infos;
    }

    public void setInfos(boolean infos) {
        this.infos = infos;
    }

    public boolean isAllInfos() {
        return allInfos;
    }

    public void setAllInfos(boolean allInfos) {
        this.allInfos = allInfos;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    @Override
    public String toString() {
        return "Params{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", blockNumber='" + blockNumber + '\'' +
                ", transaction=" + transaction +
                ", balance=" + balance +
                ", infos=" + infos +
                ", allInfos=" + allInfos +
                '}';
    }
}

