package com.fyber.inneractive.sdk.network;

import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
public final class K implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((U) obj).m().ordinal() - ((U) obj2).m().ordinal();
    }
}
