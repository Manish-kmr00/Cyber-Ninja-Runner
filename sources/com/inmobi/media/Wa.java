package com.inmobi.media;

import androidx.browser.trusted.sharing.ShareTarget;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Wa extends S8 {
    public final AtomicBoolean A;
    public final int y;
    public final int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Wa(String url, C3545rc c3545rc, String str, int i, int i2) {
        super("POST", url, c3545rc, X3.a(X3.f3234a, false, 1, null), (L4) null, ShareTarget.ENCODING_TYPE_URL_ENCODED, 64);
        Intrinsics.checkNotNullParameter("POST", "requestType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(ShareTarget.ENCODING_TYPE_URL_ENCODED, "requestContentType");
        this.y = i;
        this.z = i2;
        this.m = str;
        this.A = new AtomicBoolean(false);
    }
}
