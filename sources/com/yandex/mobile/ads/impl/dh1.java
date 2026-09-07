package com.yandex.mobile.ads.impl;

import android.net.wifi.ScanResult;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class dh1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((ScanResult) t2).level), Integer.valueOf(((ScanResult) t).level));
    }
}
