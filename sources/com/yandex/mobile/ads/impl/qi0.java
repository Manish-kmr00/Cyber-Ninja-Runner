package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes12.dex */
public abstract class qi0 implements g01.b {
    public final String b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public qi0(String str) {
        this.b = str;
    }

    public String toString() {
        return this.b;
    }
}
