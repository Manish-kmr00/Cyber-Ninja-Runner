package com.inmobi.media;

import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class W1 implements InterfaceC3308b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ X1 f3222a;

    public W1(X1 x1) {
        this.f3222a = x1;
    }

    @Override // com.inmobi.media.InterfaceC3308b2
    public final void a(T1 click) {
        Intrinsics.checkNotNullParameter(click, "click");
        X1 x1 = this.f3222a;
        x1.getClass();
        Message messageObtain = Message.obtain();
        messageObtain.what = 4;
        messageObtain.obj = click;
        x1.sendMessage(messageObtain);
    }

    @Override // com.inmobi.media.InterfaceC3308b2
    public final void a(T1 click, I3 errorCode) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        L4 l4 = this.f3222a.f3232a;
        if (l4 != null) {
            String strF = C3364f2.f();
            ((M4) l4).b(strF, O5.a(strF, "access$getTAG$p(...)", "Pinging click (").append(click.b).append(") via WebView failed ...").toString());
        }
        C3364f2.c(C3364f2.f3308a, click);
        this.f3222a.b(click);
    }
}
