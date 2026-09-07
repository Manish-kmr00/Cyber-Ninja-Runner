package com.chartboost.sdk.impl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "", "Lcom/chartboost/sdk/internal/video/repository/DownloadState;", "a", "(F)I", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class c9 {
    public static final int a(float f) {
        if (f == 0.0f) {
            return 0;
        }
        double d = f;
        if (d < 0.25d) {
            return 1;
        }
        if (d < 0.5d) {
            return 2;
        }
        if (d < 0.75d) {
            return 3;
        }
        return f < 1.0f ? 4 : 5;
    }
}
