package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f1912a;

    public S(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.serverapi.d dVar) {
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f1912a.put(str, str2);
    }
}
