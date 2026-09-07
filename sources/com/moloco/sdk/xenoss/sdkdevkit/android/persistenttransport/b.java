package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import io.ktor.http.ContentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements a {
    public final d b;

    public b(d delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.b = delegate;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.b.a(url);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url, byte[] body, ContentType contentType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.b.a(url, body, contentType);
    }
}
