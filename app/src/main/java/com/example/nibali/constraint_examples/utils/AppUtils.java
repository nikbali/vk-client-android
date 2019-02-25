package com.example.nibali.constraint_examples.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final  class AppUtils {
    private static final SimpleDateFormat SHORT_DATE = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private static final SimpleDateFormat FULL_DATE = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault());
    private static final Date DATE = new Date();
    private static final Calendar CALENDAR = Calendar.getInstance();

    /**
     * Получение строки с датой и временем сообщений
     *
     * @param unixTime дата в формате unix-time
     * @return строка с датой и временем
     */
    public static String getDateFromUnixTime(long unixTime) {
        CALENDAR.setTimeInMillis(System.currentTimeMillis());

        DATE.setTime(unixTime * 1000);
        CALENDAR.set(CALENDAR.get(Calendar.YEAR), CALENDAR.get(Calendar.MONTH), CALENDAR.get(Calendar.DATE), 0, 0, 0);
        return unixTime * 1000 > CALENDAR.getTimeInMillis() ? SHORT_DATE.format(DATE) : FULL_DATE.format(DATE);
    }

}
