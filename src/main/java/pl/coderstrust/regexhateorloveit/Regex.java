package pl.coderstrust.regexhateorloveit;

import java.util.regex.Pattern;

class Regex {

    private static final String IP_ADRESS_REGEX = "(((19[0-9]|1[0-9][0-9]|[1-9]?[0-9])|2[0-4][0-9]|25[0-5])\\.){3}" +
            "((19[0-9]|1[0-9][0-9]|[1-9]?[0-9])|2[0-4][0-9]|25[0-5])";

    private static final Pattern IP_ADRESS_PATTERN = Pattern.compile(IP_ADRESS_REGEX);

    public static boolean isIpAdress(String ip) {
        if (ip == null) {
            return false;
        }
        return IP_ADRESS_PATTERN.matcher(ip).matches();
    }
}
