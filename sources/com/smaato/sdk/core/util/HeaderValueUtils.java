package com.smaato.sdk.core.util;

import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.Headers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class HeaderValueUtils {
    Logger logger;

    public HeaderValueUtils(Logger logger) {
        this.logger = logger;
    }

    public String retrieveSessionId(Headers headers) {
        List<String> listValues = headers.values("X-SMT-SessionId");
        if (listValues.isEmpty()) {
            return null;
        }
        return Joiner.join("", listValues);
    }

    public String retrieveImpressionCountingType(Headers headers) {
        List<String> listValues = headers.values("X-SMT-Impression-Measurement");
        if (listValues.isEmpty()) {
            return null;
        }
        return listValues.get(0);
    }

    public String retrieveBundleId(Headers headers) {
        List<String> listValues = headers.values("X-SMT-BUNDLE");
        if (listValues.isEmpty()) {
            return null;
        }
        return listValues.get(0);
    }

    public String retrieveSci(Headers headers) {
        List<String> listValues = headers.values("SCI");
        if (listValues.isEmpty()) {
            return null;
        }
        return Joiner.join("", listValues);
    }

    public long getTtl(Headers headers) {
        List<String> listValues = headers.values("X-SMT-Expires");
        if (listValues.isEmpty()) {
            return Long.MAX_VALUE;
        }
        try {
            long j = Long.parseLong(listValues.get(0));
            List<String> listValues2 = headers.values("Date");
            if (listValues2.isEmpty()) {
                return j - System.currentTimeMillis();
            }
            Long lDecodeHeaderDate = decodeHeaderDate(listValues2.get(0));
            return j - (lDecodeHeaderDate == null ? System.currentTimeMillis() : lDecodeHeaderDate.longValue());
        } catch (NumberFormatException e) {
            this.logger.error(LogDomain.CORE, "Error when parsing TTL in header", e);
            return 0L;
        }
    }

    public ImpressionCountingType retrieveImpressionType(Headers headers) {
        return getImpressionCountingType(getImpressionTypeHeaderValue(headers));
    }

    public ImpressionCountingType retrieveImpressionType(Map<String, List<String>> map) {
        List<String> list = map.get("X-SMT-Impression-Measurement");
        return getImpressionCountingType((list == null || list.isEmpty()) ? null : list.get(0));
    }

    private ImpressionCountingType getImpressionCountingType(String str) {
        if (str != null) {
            return ImpressionCountingType.VIEWABLE;
        }
        this.logger.debug(LogDomain.CORE, "No X-SMT-Impression-Measurement header in ad response. Using standard impression type.", new Object[0]);
        return ImpressionCountingType.STANDARD;
    }

    public AdFormat getAdFormat(Headers headers) {
        String adTypeHeaderValue = getAdTypeHeaderValue(headers);
        String csmHeaderValue = getCsmHeaderValue(headers);
        if (adTypeHeaderValue == null && csmHeaderValue == null) {
            this.logger.debug(LogDomain.CORE, "missing %s response header", "X-SMT-ADTYPE");
            return null;
        }
        if (adTypeHeaderValue == null) {
            return AdFormat.CSM;
        }
        Logger logger = this.logger;
        LogDomain logDomain = LogDomain.CORE;
        logger.debug(logDomain, "%s header value: %s", "X-SMT-ADTYPE", adTypeHeaderValue);
        if (adTypeHeaderValue.isEmpty()) {
            this.logger.debug(logDomain, "invalid %s response header value", "X-SMT-ADTYPE");
            return null;
        }
        return getAdFormatForAdFormatHeaderField(adTypeHeaderValue);
    }

    public AdFormat getAdFormatForAdFormatHeaderField(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "Native":
            case "NativeVideo":
                return AdFormat.NATIVE;
            case "Img":
                return AdFormat.STATIC_IMAGE;
            case "Video":
                return AdFormat.VIDEO;
            case "Richmedia":
                return AdFormat.RICH_MEDIA;
            default:
                this.logger.debug(LogDomain.CORE, "unexpected X-SMT-ADTYPE response header value: %s", str);
                return null;
        }
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.util.HeaderValueUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$ad$AdFormat;

        static {
            int[] iArr = new int[AdFormat.values().length];
            $SwitchMap$com$smaato$sdk$core$ad$AdFormat = iArr;
            try {
                iArr[AdFormat.DISPLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdFormat[AdFormat.STATIC_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdFormat[AdFormat.RICH_MEDIA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdFormat[AdFormat.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdFormat[AdFormat.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdFormat[AdFormat.INTERSTITIAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String adFormatToApiValue(AdFormat adFormat) {
        switch (AnonymousClass1.$SwitchMap$com$smaato$sdk$core$ad$AdFormat[adFormat.ordinal()]) {
            case 1:
                return "display";
            case 2:
                return "img";
            case 3:
                return "richmedia";
            case 4:
                return "video";
            case 5:
                return "native";
            case 6:
                return "interstitial";
            default:
                String str = String.format("Unexpected %s: %s", "AdFormat", adFormat);
                this.logger.error(LogDomain.CORE, str, new Object[0]);
                throw new IllegalArgumentException(str);
        }
    }

    public String getCharSet(Headers headers) {
        List<String> listValues = headers.values("Content-Type");
        if (listValues.isEmpty()) {
            this.logger.debug(LogDomain.CORE, "%s header is absent in response", "Content-Type");
            return null;
        }
        return parseCharset(listValues);
    }

    private String parseCharset(List list) {
        String charset;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            if (str != null && (charset = ContentTypeUtil.parseCharset(str)) != null) {
                this.logger.debug(LogDomain.CORE, "charset found in response = %s", charset);
                return charset;
            }
        }
        this.logger.debug(LogDomain.CORE, "charset not found in response", new Object[0]);
        return null;
    }

    private Long decodeHeaderDate(String str) {
        if (str == null) {
            return null;
        }
        try {
            Date date = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", new Locale("en", "US", "POSIX")).parse(str);
            if (date != null) {
                return Long.valueOf(date.getTime());
            }
            return null;
        } catch (ParseException e) {
            this.logger.error(LogDomain.CORE, "date parse error", e);
            return null;
        }
    }

    private String getImpressionTypeHeaderValue(Headers headers) {
        List<String> listValues = headers.values("X-SMT-Impression-Measurement");
        if (listValues.isEmpty()) {
            return null;
        }
        return listValues.get(0);
    }

    private String getAdTypeHeaderValue(Headers headers) {
        List<String> listValues = headers.values("X-SMT-ADTYPE");
        if (listValues.isEmpty()) {
            return null;
        }
        return listValues.get(0);
    }

    private String getCsmHeaderValue(Headers headers) {
        String strJoin = Joiner.join("", headers.values("X-SMT-CSM"));
        if (!strJoin.isEmpty()) {
            return strJoin;
        }
        this.logger.debug(LogDomain.CORE, "No X-SMT-CSM header in ad response. null is returned.", new Object[0]);
        return null;
    }
}
