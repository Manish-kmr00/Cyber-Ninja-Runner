package com.amazon.device.ads;

/* JADX INFO: loaded from: classes11.dex */
public enum DTBLogLevel {
    All(0),
    Trace(1),
    Debug(2),
    Info(3),
    Warn(4),
    Error(5),
    Fatal(6),
    Off(7);

    private int value;

    DTBLogLevel(int i) {
        this.value = i;
    }

    public int intValue() {
        return this.value;
    }
}
