package com.example.nibali.brat.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final  class AppUtils {
    private static final DateTimeFormatter SHORT_DATE = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter FULL_DATE = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");

    /**
     * Получение строки с датой и временем сообщений
     *
     * @param unixTime дата/время
     * @return строка с датой и временем
     */
    public static String getDateFromUnixTime(LocalDateTime unixTime) {
        LocalDateTime now = LocalDateTime.now();
        return unixTime.plusDays(1).isAfter(now) ? unixTime.format(SHORT_DATE) :  unixTime.format(FULL_DATE);
    }

    /**
     * Замена текстовых спец. символов используемых в Vk Api
     * @param text текст пришедший из api
     * @return преобразованный в читабельный вид(замена пробелов и т.д)
     */
    public static String unescape(String text) {
        if (text == null) {
            return null;
        }

        return text.replace("&amp;", "&")
                .replace("&quot;", "\"")
                .replace("<br>", "\n")
                .replace("&gt;", ">")
                .replace("&lt;", "<")
                .replace("<br/>", "\n")
                .replace("&ndash;", "-")
                .trim();

        //Баг в API
        //amp встречается в сообщении, br в Ответах тип comment_photo, gt lt на стене - баг API, ndash в статусе когда аудио транслируется
        //quot в тексте сообщения из LongPoll - то есть в уведомлении
    }

}
