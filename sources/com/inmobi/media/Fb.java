package com.inmobi.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Fb extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ConcurrentHashMap concurrentHashMap = Ib.f3099a;
        Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
        intent.getAction();
        C3517pb.f().b(new N1(0, null, MapsKt.mapOf(TuplesKt.to(SDKConstants.PARAM_INTENT, intent), TuplesKt.to("context", context)), 2));
    }
}
