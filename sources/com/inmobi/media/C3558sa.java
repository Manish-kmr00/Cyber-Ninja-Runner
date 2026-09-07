package com.inmobi.media;

import com.inmobi.ads.rendering.InMobiAdActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.sa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3558sa extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3558sa f3429a = new C3558sa();

    public C3558sa() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Ba ba = InMobiAdActivity.l;
        if (ba != null) {
            ba.m();
        }
        return Unit.INSTANCE;
    }
}
