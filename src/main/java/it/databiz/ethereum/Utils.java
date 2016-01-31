package it.databiz.ethereum;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bigmoby on 28/01/16.
 */
public class Utils {

    final static Map<String, BigDecimal> unitMap = new HashMap<String, BigDecimal>();

    static {
        unitMap.put("wei", new BigDecimal("1"));
        unitMap.put("szabo", new BigDecimal("1000000000000"));
        unitMap.put("ether", new BigDecimal("1000000000000000000"));
    }

    public static BigDecimal fromWei(BigInteger number, String strCurrency) {
        return new BigDecimal(number).divide(unitMap.get(strCurrency));
    }

    /**
     * Takes an hex input and transforms it into an BigInteger.
     *
     * @param {String} HEX string
     * @return {BigInteger} BigInteger
     * @method toNumber
     */
    public static BigInteger toNumber(final String strNumber) {
        return new BigInteger(strNumber.replace("0x", ""), 16);
    }

    public static String toHex(final String strNumber) {
        return "0x"+new BigInteger(strNumber).toString(16);
    }

    public static void main(String[] args) {
        System.out.println(toHex("255"));
    }
}
