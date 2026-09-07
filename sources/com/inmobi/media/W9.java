package com.inmobi.media;

import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class W9 implements BillingClientStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3330ca f3229a;
    public final /* synthetic */ Y9 b;

    public W9(C3330ca c3330ca, Y9 y9) {
        this.f3229a = c3330ca;
        this.b = y9;
    }

    public static final void a(Function1 onComplete, V9 result) {
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(result, "$result");
        onComplete.invoke(result);
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        this.f3229a.getClass();
        final Y9 y9 = this.b;
        final C3330ca c3330ca = this.f3229a;
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.W9$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                W9.a(y9, c3330ca);
            }
        });
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(BillingResult billingResult) {
        final V9 t9;
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.f3229a.getClass();
        Objects.toString(billingResult);
        if (billingResult.getResponseCode() == 0) {
            t9 = U9.f3212a;
        } else {
            int responseCode = billingResult.getResponseCode();
            String debugMessage = billingResult.getDebugMessage();
            Intrinsics.checkNotNullExpressionValue(debugMessage, "getDebugMessage(...)");
            t9 = new T9(debugMessage, responseCode);
        }
        final Y9 y9 = this.b;
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.W9$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                W9.a(y9, t9);
            }
        });
    }

    public static final void a(Function1 onComplete, C3330ca this$0) {
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        onComplete.invoke(new T9("Billing Service Disconnected", -1));
    }
}
