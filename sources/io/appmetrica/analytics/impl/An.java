package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: loaded from: classes13.dex */
public final class An {
    public static final int[] c = {0, 1, 2, 3};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f11064a = new SparseArray();
    public int b = 0;

    public An(int[] iArr) {
        for (int i : iArr) {
            this.f11064a.put(i, new HashMap());
        }
    }
}
