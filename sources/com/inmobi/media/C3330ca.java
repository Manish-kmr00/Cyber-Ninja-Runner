package com.inmobi.media;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryPurchasesParams;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.inmobi.media.ca, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3330ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public J9 f3284a;
    public BillingClient b;
    public final AtomicInteger c = new AtomicInteger(0);
    public final M9 d = new M9();
    public final int e = 2;

    public static final void a(BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
    }

    public static final void b(BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
    }

    public static BillingClient b(Context context) {
        try {
            return BillingClient.newBuilder(context).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).setListener(new PurchasesUpdatedListener() { // from class: com.inmobi.media.ca$$ExternalSyntheticLambda5
                @Override // com.android.billingclient.api.PurchasesUpdatedListener
                public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                    C3330ca.b(billingResult, list);
                }
            }).build();
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return null;
        } catch (NoClassDefFoundError e2) {
            C3339d5 c3339d6 = C3339d5.f3292a;
            P1 event = new P1(e2);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            return null;
        }
    }

    public final void a(Context context, J9 onComplete) {
        Function1 c3301aa;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        try {
            this.f3284a = onComplete;
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            Bundle bundle = applicationInfo.metaData;
            String string = bundle != null ? bundle.getString("com.google.android.play.billingclient.version") : null;
            if (string == null) {
                a(new O9((short) 2236), (M9) null);
                return;
            }
            if (StringsKt.startsWith$default(string, "6", false, 2, (Object) null)) {
                c3301aa = new Z9(this);
            } else {
                c3301aa = StringsKt.startsWith$default(string, "7", false, 2, (Object) null) ? new C3301aa(this) : new C3316ba(this);
            }
            BillingClient billingClient = (BillingClient) c3301aa.invoke(context);
            if (billingClient == null) {
                a(new O9((short) 2233), (M9) null);
                return;
            }
            this.b = billingClient;
            Y9 onComplete2 = new Y9(this);
            Intrinsics.checkNotNullParameter(onComplete2, "onComplete");
            BillingClient billingClient2 = this.b;
            if (billingClient2 != null) {
                billingClient2.startConnection(new W9(this, onComplete2));
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            a(new O9((short) 2237), (M9) null);
        }
    }

    public static final void b(final C3330ca this$0, final Function1 onComplete, BillingResult billingResult, List purchasesResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(purchasesResult, "purchasesResult");
        M9 m9 = this$0.d;
        ArrayList arrayList = new ArrayList();
        for (Object obj : purchasesResult) {
            Purchase purchase = (Purchase) obj;
            if (purchase.getPurchaseState() == 1 && purchase.isAcknowledged()) {
                arrayList.add(obj);
            }
        }
        m9.b = arrayList.size();
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.ca$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3330ca.b(onComplete, this$0);
            }
        });
    }

    public static final void b(Function1 onComplete, C3330ca this$0) {
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onComplete.invoke(this$0.d);
    }

    public final void a(R9 r9, M9 m9) {
        S9.a(r9);
        J9 j9 = this.f3284a;
        if (j9 != null) {
            j9.invoke(m9);
        }
    }

    public static BillingClient a(Context context) {
        try {
            return BillingClient.newBuilder(context).enablePendingPurchases().setListener(new PurchasesUpdatedListener() { // from class: com.inmobi.media.ca$$ExternalSyntheticLambda3
                @Override // com.android.billingclient.api.PurchasesUpdatedListener
                public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                    C3330ca.a(billingResult, list);
                }
            }).build();
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return null;
        } catch (NoClassDefFoundError e2) {
            C3339d5 c3339d6 = C3339d5.f3292a;
            P1 event = new P1(e2);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            return null;
        }
    }

    public final void a(final X9 onComplete) {
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        QueryPurchasesParams.Builder builderNewBuilder = QueryPurchasesParams.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        builderNewBuilder.setProductType("inapp");
        QueryPurchasesParams.Builder builderNewBuilder2 = QueryPurchasesParams.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder2, "newBuilder(...)");
        builderNewBuilder2.setProductType("subs");
        BillingClient billingClient = this.b;
        if (billingClient != null) {
            billingClient.queryPurchasesAsync(builderNewBuilder.build(), new PurchasesResponseListener() { // from class: com.inmobi.media.ca$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.PurchasesResponseListener
                public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                    C3330ca.a(this.f$0, onComplete, billingResult, list);
                }
            });
        }
        BillingClient billingClient2 = this.b;
        if (billingClient2 != null) {
            billingClient2.queryPurchasesAsync(builderNewBuilder2.build(), new PurchasesResponseListener() { // from class: com.inmobi.media.ca$$ExternalSyntheticLambda1
                @Override // com.android.billingclient.api.PurchasesResponseListener
                public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                    C3330ca.b(this.f$0, onComplete, billingResult, list);
                }
            });
        }
    }

    public static final void a(final C3330ca this$0, final Function1 onComplete, BillingResult billingResult, List purchasesResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(purchasesResult, "purchasesResult");
        M9 m9 = this$0.d;
        ArrayList arrayList = new ArrayList();
        for (Object obj : purchasesResult) {
            Purchase purchase = (Purchase) obj;
            if (purchase.getPurchaseState() == 1 && purchase.isAcknowledged()) {
                arrayList.add(obj);
            }
        }
        m9.f3136a = arrayList.size();
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.ca$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3330ca.a(onComplete, this$0);
            }
        });
    }

    public static final void a(Function1 onComplete, C3330ca this$0) {
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onComplete.invoke(this$0.d);
    }
}
