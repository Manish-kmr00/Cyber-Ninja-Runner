package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes6.dex */
public final class c91 implements dk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e91 f8580a;
    final /* synthetic */ o41 b;
    final /* synthetic */ pj0 c;
    final /* synthetic */ CancellableContinuation<Unit> d;

    c91(e91 e91Var, o41 o41Var, pj0 pj0Var, CancellableContinuationImpl cancellableContinuationImpl) {
        this.f8580a = e91Var;
        this.b = o41Var;
        this.c = pj0Var;
        this.d = cancellableContinuationImpl;
    }

    @Override // com.yandex.mobile.ads.impl.dk0
    public final void a(String url, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
    }

    @Override // com.yandex.mobile.ads.impl.dk0
    public final void a(Map<String, Bitmap> images) {
        Intrinsics.checkNotNullParameter(images, "images");
        this.f8580a.f8775a.a(f5.q);
        o8<?> o8VarB = this.b.b();
        if (!Intrinsics.areEqual(o8VarB.E(), y81.c.a()) && !Intrinsics.areEqual(o8VarB.E(), y81.d.a())) {
            zj0 zj0Var = this.f8580a.c;
            o41 nativeAdBlock = this.b;
            zj0Var.getClass();
            Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
            Intrinsics.checkNotNullParameter(images, "images");
            Iterator<c41> it = nativeAdBlock.c().e().iterator();
            while (it.hasNext()) {
                List<ig<?>> listB = it.next().b();
                if (!listB.isEmpty()) {
                    zj0Var.a(listB, images);
                }
            }
            ah ahVar = this.f8580a.b;
            o41 nativeAdBlock2 = this.b;
            ahVar.getClass();
            Intrinsics.checkNotNullParameter(nativeAdBlock2, "nativeAdBlock");
            Intrinsics.checkNotNullParameter(images, "images");
            for (c41 c41Var : nativeAdBlock2.c().e()) {
                List<ig<?>> listB2 = c41Var.b();
                if (!listB2.isEmpty()) {
                    c41Var.a(ahVar.a(listB2, images));
                }
            }
        }
        this.c.a(images);
        if (this.d.isActive()) {
            CancellableContinuation<Unit> cancellableContinuation = this.d;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7904constructorimpl(Unit.INSTANCE));
        }
    }
}
