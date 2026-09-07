package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes10.dex */
public abstract class k12 implements g01.b {
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "SCTE-35 splice command: type=".concat(getClass().getSimpleName());
    }
}
