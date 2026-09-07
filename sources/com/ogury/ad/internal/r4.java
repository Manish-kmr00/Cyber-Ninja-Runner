package com.ogury.ad.internal;

import com.ogury.core.internal.network.NetworkResponse;

/* JADX INFO: loaded from: classes14.dex */
public final class r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f7393a = new r4();

    public static void a(String str, boolean z, p4 p4Var, x5 x5Var) throws InterruptedException, q4 {
        NetworkResponse networkResponseB = x5Var.b(str);
        if (networkResponseB instanceof NetworkResponse.Success) {
            NetworkResponse.Success success = (NetworkResponse.Success) networkResponseB;
            if (success.getResponseBody().length() > 0) {
                p4Var.b(success.getResponseBody());
                p4Var.a(str);
                return;
            }
        }
        if (!z) {
            throw new q4("Failed to download mraid (" + str + ")");
        }
        Thread.sleep(400L);
        a(str, false, p4Var, x5Var);
    }
}
