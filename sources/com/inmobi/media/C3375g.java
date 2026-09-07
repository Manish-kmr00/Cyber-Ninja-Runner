package com.inmobi.media;

import com.inmobi.ads.AdMetaInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3375g extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3389h f3320a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3375g(C3389h c3389h) {
        super(0);
        this.f3320a = c3389h;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new AdMetaInfo(this.f3320a.o(), this.f3320a.E());
    }
}
