package com.inmobi.media;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class K9 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final K9 f3116a = new K9();

    public K9() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean z;
        try {
            Class.forName("com.android.billingclient.api.BillingClient");
            z = true;
        } catch (ClassNotFoundException | Exception unused) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
