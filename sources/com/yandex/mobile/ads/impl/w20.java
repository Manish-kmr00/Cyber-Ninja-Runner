package com.yandex.mobile.ads.impl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.yandex.div.core.DivConfiguration;
import com.yandex.div.core.view2.Div2View;
import com.yandex.mobile.ads.R;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w20 implements bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m61 f10527a;
    private final wr b;
    private final lp1 c;
    private final e30 d;
    private final k30 e;
    private Dialog f;

    public w20(m61 nativeAdPrivate, wr contentCloseListener, lp1 reporter, e30 divKitDesignProvider, k30 divViewCreator) {
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(divKitDesignProvider, "divKitDesignProvider");
        Intrinsics.checkNotNullParameter(divViewCreator, "divViewCreator");
        this.f10527a = nativeAdPrivate;
        this.b = contentCloseListener;
        this.c = reporter;
        this.d = divKitDesignProvider;
        this.e = divViewCreator;
    }

    @Override // com.yandex.mobile.ads.impl.bq
    public final void a() {
        Dialog dialog = this.f;
        if (dialog != null) {
            k10.a(dialog);
        }
    }

    @Override // com.yandex.mobile.ads.impl.bq
    public final void a(Context context) {
        y20 y20Var;
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            e30 e30Var = this.d;
            m61 nativeAdPrivate = this.f10527a;
            e30Var.getClass();
            Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
            List<y20> listC = nativeAdPrivate.c();
            if (listC != null) {
                Iterator<T> it = listC.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((y20) next).e(), e10.e.a()));
                y20Var = (y20) next;
            } else {
                y20Var = null;
            }
            if (y20Var == null) {
                this.b.f();
                return;
            }
            x20 x20Var = new x20(context, null);
            k30 k30Var = this.e;
            DivConfiguration divConfigurationA = x20Var.a();
            Intrinsics.checkNotNullExpressionValue(divConfigurationA, "<get-divConfiguration>(...)");
            k30Var.getClass();
            Div2View div2ViewA = k30.a(context, divConfigurationA, null);
            Dialog dialog = new Dialog(context, R.style.MonetizationAdsInternal_FullscreenDialog);
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.yandex.mobile.ads.impl.w20$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    w20.a(this.f$0, dialogInterface);
                }
            });
            div2ViewA.setActionHandler(new aq(new zp(dialog, this.b)));
            div2ViewA.setData(y20Var.b(), y20Var.c());
            dialog.setContentView(div2ViewA);
            this.f = dialog;
            dialog.show();
        } catch (Throwable th) {
            this.c.reportError("Failed to show DivKit close dialog", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(w20 this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f = null;
    }
}
