package com.amazon.aps.ads.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: ApsLogLevel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/amazon/aps/ads/model/ApsLogLevel;", "", "value", "", "(Ljava/lang/String;II)V", "intValue", "All", "Trace", "Debug", "Info", "Warn", "Error", "Fatal", "Off", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ApsLogLevel {
    All(0),
    Trace(1),
    Debug(2),
    Info(3),
    Warn(4),
    Error(5),
    Fatal(6),
    Off(7);

    private final int value;

    ApsLogLevel(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: intValue, reason: from getter */
    public final int getValue() {
        return this.value;
    }
}
