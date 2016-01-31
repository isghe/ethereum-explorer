package it.databiz.ethereum;

import com.cleancoder.args.Args;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * EthereumExplorer.
 * Created by bigmoby on 28/01/16.
 */
public class EthereumExplorer {

    public EthereumExplorer(String[] args) throws Throwable {
        System.out.println("Ethereum explorer");
        Args arg = new Args("h*,p*,t,b,i,f,a*,k*", args);
        Params params = new Params(arg.getString('a'), arg.getString('k'), arg.getBoolean('t'), arg.getBoolean('b')
                , arg.getBoolean('i'), arg.getBoolean('f'), arg.getString('h'), arg.getString('p'));

        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(params.getHost() + ":" + params.getPort()));

        final String ethereumClientVersion = client.invoke("web3_clientVersion", new Object[]{}, String.class);

        System.out.println("Client: " + ethereumClientVersion);
        System.out.println(params);

        if (params.isBalance()) {
            // Returns balance for the from address.
            String balance = client.invoke("eth_getBalance", new Object[]{params.getFromAddress(),
                    params.getBlockNumber()}, String.class);
            System.out.println("Balance (in szabo): " + Utils.fromWei(Utils.toNumber(balance), "szabo"));
            System.out.println("Balance (in ether): " + Utils.fromWei(Utils.toNumber(balance), "ether"));
        }

        if (params.isTransaction()) {
            // Returns the number of transactions sent from an address.
            String transactionCount = client.invoke("eth_getTransactionCount", new Object[]{params.getFromAddress(),
                    params.getBlockNumber()}, String.class);
            System.out.println("Transactions sent: " + transactionCount);
        }

        if (params.isInfos()) {
            // Returns information about a block by block number.
            BlockInfo infoBlock = client.invoke("eth_getBlockByNumber", new Object[]{Utils.toHex(params.getBlockNumber()), true},
                    BlockInfo.class);

            BlockInfo parentBlock = client.invoke("eth_getBlockByHash", new Object[]{infoBlock.getParentHash(), true},
                    BlockInfo.class);

            Transaction transactionRoot = client.invoke("eth_getTransactionByHash", new Object[]{infoBlock.getTransactionsRoot()},
                    Transaction.class);

            System.out.println("Block info: " + infoBlock);
            System.out.println("Block info for parentBlock: " + parentBlock);
            System.out.println("transactionRoot: " + transactionRoot);
        }

        if (params.isAllInfos()) {
            BlockInfo infoBlock = client.invoke("eth_getBlockByNumber", new Object[]{"latest", true}, BlockInfo.class);
            int maxBlock = Utils.toNumber(infoBlock.getNumber()).intValue();

            CellStyle rightStyle = new CellStyle(CellStyle.HorizontalAlign.right);
            CellStyle centerStyle = new CellStyle(CellStyle.HorizontalAlign.center);
            CellStyle leftStyle = new CellStyle(CellStyle.HorizontalAlign.left);

            Table consoleTable = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);

            consoleTable.addCell("#", leftStyle);
            consoleTable.addCell("Hash", centerStyle);
            consoleTable.addCell("To", centerStyle);
            consoleTable.addCell("Amount (Ether)", centerStyle);
            consoleTable.addCell("Time", centerStyle);

            int rowTable = 1;

            for (int i = maxBlock; i > 0; i--) {
                infoBlock = client.invoke("eth_getBlockByNumber", new Object[]{Utils.toHex(String.valueOf(i)), true}, BlockInfo.class);
                Transaction[] transactions = infoBlock.getTransactions();
                for (int j = 0; j < transactions.length; j++) {
                    if (transactions[j].getFrom().equalsIgnoreCase(params.getFromAddress())) {
                        consoleTable.addCell(String.valueOf(rowTable++), leftStyle);
                        consoleTable.addCell(transactions[j].getHash(), leftStyle);
                        consoleTable.addCell(transactions[j].getTo(), leftStyle);
                        consoleTable.addCell(Utils.fromWei(Utils.toNumber(transactions[j].getValue()), "ether").toPlainString(), rightStyle);
                        DateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                        consoleTable.addCell(format.format(new Date(Long.valueOf(Utils.toNumber(infoBlock.getTimestamp()).longValue()) * 1000)), rightStyle);
                    }
                }
            }

            System.out.println(consoleTable.render());
        }
    }

    public static void main(String[] args) throws Throwable {
        new EthereumExplorer(args);
    }

}
