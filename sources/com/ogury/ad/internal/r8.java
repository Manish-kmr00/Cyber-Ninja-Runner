package com.ogury.ad.internal;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r8 implements x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f7396a;

    public r8(z androidDevice) {
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        this.f7396a = androidDevice;
    }

    @Override // com.ogury.ad.internal.x4
    public final void a(final n4 mraidCommandExecutor) {
        Intrinsics.checkNotNullParameter(mraidCommandExecutor, "mraidCommandExecutor");
        ca.a(mraidCommandExecutor.f7364a, new Function0() { // from class: com.ogury.ad.internal.r8$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return r8.a(this.f$0, mraidCommandExecutor);
            }
        });
    }

    public static final Unit a(r8 r8Var, n4 n4Var) {
        r8Var.getClass();
        ViewGroup viewGroup = n4Var.f7364a;
        int iB = j7.b(viewGroup.getWidth());
        int iB2 = j7.b(viewGroup.getHeight());
        ViewParent parent = viewGroup.getParent();
        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        }
        int iA = j7.a(viewGroup.getX());
        int iA2 = j7.a(viewGroup.getY());
        Rect rectA = r8Var.f7396a.a(n4Var.f7364a);
        h5.a(n4Var.f7364a, o4.b(j7.b(rectA.width()), j7.b(rectA.height())));
        h5.a(n4Var.f7364a, o4.b(iB, iB2, iA, iA2));
        return Unit.INSTANCE;
    }
}
