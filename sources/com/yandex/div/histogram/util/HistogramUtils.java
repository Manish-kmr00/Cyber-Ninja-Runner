package com.yandex.div.histogram.util;

import com.safedk.android.utils.j;
import com.yandex.div.histogram.HistogramCallType;
import com.yandex.div.histogram.HistogramRecordConfiguration;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: HistogramUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/histogram/util/HistogramUtils;", "", "()V", "calculateUtf8JsonByteSize", "", "json", "Lorg/json/JSONObject;", "calculateUtf8StringByteSize", "str", "", "getUtf8CharByteSize", "ch", "", "shouldRecordHistogram", "", "callType", j.c, "Lcom/yandex/div/histogram/HistogramRecordConfiguration;", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HistogramUtils {
    public static final HistogramUtils INSTANCE = new HistogramUtils();

    private HistogramUtils() {
    }

    public final int calculateUtf8StringByteSize(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        int length = str.length();
        int utf8CharByteSize = 0;
        for (int i = 0; i < length; i++) {
            utf8CharByteSize += getUtf8CharByteSize(str.charAt(i));
        }
        return utf8CharByteSize;
    }

    public final int getUtf8CharByteSize(char ch) {
        if (Character.isHighSurrogate(ch)) {
            return 4;
        }
        if (Character.isLowSurrogate(ch)) {
            return 0;
        }
        if (ch < 128) {
            return 1;
        }
        if (ch < 2048) {
            return 2;
        }
        if (ch < 0) {
            return 3;
        }
        KAssert kAssert = KAssert.INSTANCE;
        if (!Assert.isEnabled()) {
            return 4;
        }
        Assert.fail("Unsupported character: '" + ch + '\'');
        return 4;
    }

    public final boolean shouldRecordHistogram(@HistogramCallType String callType, HistogramRecordConfiguration configuration) {
        Intrinsics.checkNotNullParameter(callType, "callType");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        int iHashCode = callType.hashCode();
        if (iHashCode != 2106116) {
            if (iHashCode != 2106217) {
                if (iHashCode == 2688677 && callType.equals("Warm")) {
                    return configuration.getIsWarmRecordingEnabled();
                }
            } else if (callType.equals("Cool")) {
                return configuration.getIsCoolRecordingEnabled();
            }
        } else if (callType.equals("Cold")) {
            return configuration.getIsColdRecordingEnabled();
        }
        KAssert kAssert = KAssert.INSTANCE;
        if (Assert.isEnabled()) {
            Assert.fail("Unknown histogram call type: " + callType);
        }
        return false;
    }

    public final int calculateUtf8JsonByteSize(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        return JSONUtf8BytesCalculator.INSTANCE.calculateUtf8JsonBytes(json);
    }
}
