package com.chartboost.sdk.impl;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(I)Ljava/lang/String;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class n0 {
    public static final String b(int i) {
        if (i == 1) {
            return "STATE_IDLE";
        }
        if (i == 2) {
            return "STATE_BUFFERING";
        }
        if (i == 3) {
            return "STATE_READY";
        }
        if (i != 4) {
            return "UNKNOWN";
        }
        return "STATE_ENDED";
    }
}
