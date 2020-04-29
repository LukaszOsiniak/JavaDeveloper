package pl.coderstrust.regexhateorloveit;

import java.util.regex.Pattern;

class Regex {

    private static final String ipAdressRegex = "((19[0-9]|1[0-9][0-9]|[1-9]?[0-9])|2[0-4][0-9]|25[0-5])\\." +
            "((19[0-9]|1[0-9][0-9]|[1-9]?[0-9])|2[0-4][0-9]|25[0-5])\\." +
            "((19[0-9]|1[0-9][0-9]|[1-9]?[0-9])|2[0-4][0-9]|25[0-5])\\." +
            "((19[0-9]|1[0-9][0-9]|[1-9]?[0-9])|2[0-4][0-9]|25[0-5])";

    private static final Pattern ipAdressPattern = Pattern.compile(ipAdressRegex);

    public static boolean isIpAdress(String ip) {
        if (ip == null) {
            return false;
        }
        return ipAdressPattern.matcher(ip).matches();
    }
}
