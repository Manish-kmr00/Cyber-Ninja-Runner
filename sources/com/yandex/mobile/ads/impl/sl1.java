package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class sl1 implements uc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10216a;
    private final List<rl1> b;

    public sl1(Context context, rb2<?> videoAdInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f10216a = context.getApplicationContext();
        this.b = a(videoAdInfo);
    }

    private static List a(rb2 rb2Var) {
        ru ruVarB = rb2Var.b();
        long jD = ruVarB.d();
        List<e62> listI = ruVarB.i();
        ArrayList<e62> arrayList = new ArrayList();
        for (Object obj : listI) {
            if (Intrinsics.areEqual("progress", ((e62) obj).a())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (e62 e62Var : arrayList) {
            fa2 fa2VarB = e62Var.b();
            rl1 rl1Var = null;
            if (fa2VarB != null) {
                Long lValueOf = fa2.b.b == fa2VarB.c() ? Long.valueOf((long) fa2VarB.d()) : fa2.b.c == fa2VarB.c() ? Long.valueOf((long) ((fa2VarB.d() / 100) * jD)) : null;
                if (lValueOf != null) {
                    rl1Var = new rl1(e62Var.c(), lValueOf.longValue());
                }
            }
            if (rl1Var != null) {
                arrayList2.add(rl1Var);
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList2);
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        Iterator<rl1> it = this.b.iterator();
        while (it.hasNext()) {
            rl1 next = it.next();
            if (next.a() <= j2) {
                re2.a aVar = re2.c;
                Context context = this.f10216a;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                aVar.a(context).a(next.b());
                it.remove();
            }
        }
    }
}
