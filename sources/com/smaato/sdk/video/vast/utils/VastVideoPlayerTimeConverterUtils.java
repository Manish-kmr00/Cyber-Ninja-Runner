package com.smaato.sdk.video.vast.utils;

import android.text.TextUtils;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public final class VastVideoPlayerTimeConverterUtils {
    private static final Pattern PERCENTAGE_PATTERN = Pattern.compile("^(\\d?\\d(\\.\\d*)?|100(?:\\.0*)?)%$");
    private static final Pattern TIME_PATTERN_SEMICOLON_OR_DOTS_WITH_MILLISECONDS = Pattern.compile("^(([01]?[0-9]|2[0-3])(:|\\.)[0-5][0-9](:|\\.)[0-5][0-9](:|\\.)\\d{1,3}$)");
    private static final Pattern TIME_PATTERN_SEMICOLON_OR_DOTS_WITHOUT_MILLISECONDS = Pattern.compile("^(([01]?[0-9]|2[0-3])(:|\\.)[0-5][0-9](:|\\.)[0-5][0-9]$)");
    private static final Pattern TIME_PATTERN_SEMICOLON_OR_DOTS_WITHOUT_HOURS = Pattern.compile("^([0-5][0-9](:|\\.)[0-5][0-9]$)");
    private static final Pattern TIME_PATTERN_WITH_SECONDS = Pattern.compile("^([0-5][0-9]$)");

    public static int convertOffsetStringToPercentage(String str, long j, Logger logger) {
        if (j == 0) {
            return -1;
        }
        return (int) ((convertOffsetStringToMilliseconds(str, j, logger) * 100) / j);
    }

    public static long convertOffsetStringToMilliseconds(String str, long j, Logger logger) {
        if (!TextUtils.isEmpty(str)) {
            long millisecondsFromString = getMillisecondsFromString(str, logger);
            if (millisecondsFromString >= 0) {
                return millisecondsFromString;
            }
            if (PERCENTAGE_PATTERN.matcher(str).matches()) {
                try {
                    float f = Float.parseFloat(str.replace("%", ""));
                    if (f != 0.0f) {
                        return Math.round((j / 100.0d) * ((double) f));
                    }
                    return -1L;
                } catch (NumberFormatException unused) {
                    logger.debug(LogDomain.VAST, "Invalid baseOffsetInMs value: %s", str);
                }
            }
        }
        return -1L;
    }

    public static long convertDurationStringToMilliseconds(String str, Logger logger) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        return getMillisecondsFromString(str, logger);
    }

    private static long buildTimeOffset(String str, Logger logger, String str2) {
        String strReplace = str.replace('.', AbstractJsonLexerKt.COLON);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return simpleDateFormat.parse(strReplace).getTime();
        } catch (ParseException unused) {
            logger.debug(LogDomain.VAST, "Received invalid duration parameter: %s", strReplace);
            return -1L;
        }
    }

    private static long getMillisecondsFromString(String str, Logger logger) {
        if (TIME_PATTERN_SEMICOLON_OR_DOTS_WITH_MILLISECONDS.matcher(str).matches()) {
            return buildTimeOffset(str, logger, "HH:mm:ss:SSS");
        }
        if (TIME_PATTERN_SEMICOLON_OR_DOTS_WITHOUT_MILLISECONDS.matcher(str).matches()) {
            return buildTimeOffset(str, logger, "HH:mm:ss");
        }
        if (TIME_PATTERN_SEMICOLON_OR_DOTS_WITHOUT_HOURS.matcher(str).matches()) {
            return buildTimeOffset(str, logger, "mm:ss");
        }
        if (TIME_PATTERN_WITH_SECONDS.matcher(str).matches()) {
            return buildTimeOffset(str, logger, "ss");
        }
        return -1L;
    }
}
