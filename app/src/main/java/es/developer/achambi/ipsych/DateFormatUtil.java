package es.developer.achambi.ipsych;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatUtil {
    private static String CHAT_TIMESTAMP_PATTERN = "HH:mm";

    public static String formatChatTimestamp(Locale locale, Date timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat( CHAT_TIMESTAMP_PATTERN, locale );
        return dateFormat.format( timestamp );
    }
}
