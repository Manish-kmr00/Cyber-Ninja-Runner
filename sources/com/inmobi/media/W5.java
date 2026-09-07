package com.inmobi.media;

import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class W5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z5 f3225a;
    public final A3 b;
    public final LinkedHashSet c;
    public String d;
    public boolean e;

    public W5(Z5 z5, A3 embeddedBrowserViewClient) {
        Intrinsics.checkNotNullParameter(embeddedBrowserViewClient, "embeddedBrowserViewClient");
        this.f3225a = z5;
        this.b = embeddedBrowserViewClient;
        this.c = new LinkedHashSet();
    }
}
