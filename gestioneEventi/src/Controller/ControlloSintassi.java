package Controller;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlloSintassi {

    public static boolean controllaSintassiEmail(String email) {
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

        Matcher m = p.matcher(email);

        boolean matchFound = m.matches();

        StringTokenizer st = new StringTokenizer(email, ".");
        String lastToken = null;
        while (st.hasMoreTokens()) {
            lastToken = st.nextToken();
        }

        if (matchFound && lastToken.length() >= 2
                && email.length() - 1 != lastToken.length()) {
            return true;
        }
        else {
            return false;
        }

    }

    public static boolean controllaSintassiCF(String CF) {
        Pattern p = Pattern.compile("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$");

        Matcher m = p.matcher(CF);

        boolean matchFound = m.matches();

        if (matchFound)
            return true;
        else
            return false;
    }

    public static boolean controllaSintassiIban(String iban) {
        Pattern p = Pattern.compile("^[A-Z]{2}[0-9]*");

        Matcher m = p.matcher(iban);

        if (m.matches()) {
            return true;
        }
        else {
            return false;
        }
    }
}