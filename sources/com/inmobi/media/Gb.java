package com.inmobi.media;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class Gb extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gb f3083a = new Gb();

    public Gb() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NetworkInfo activeNetworkInfo;
        N1 it = (N1) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        ConcurrentHashMap concurrentHashMap = Ib.f3099a;
        Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
        Map map = it.c;
        Object obj2 = map != null ? map.get(SDKConstants.PARAM_INTENT) : null;
        Intent intent = obj2 instanceof Intent ? (Intent) obj2 : null;
        if (intent != null) {
            Object obj3 = it.c.get("context");
            Context context = obj3 instanceof Context ? (Context) obj3 : null;
            if (context != null) {
                Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
                intent.getAction();
                try {
                    if (intent.getAction() != null) {
                        Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
                        intent.getAction();
                        boolean z = true;
                        if (Intrinsics.areEqual("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
                            Object systemService = context.getSystemService("connectivity");
                            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                            if (connectivityManager != null && ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.isConnected() != Ib.c)) {
                                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                                    z = false;
                                }
                                Ib.c = z;
                                Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
                                C3517pb.f().b(new N1(10, Ib.c ? "available" : "lost", null, 4));
                            }
                        } else if (StringsKt.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED", intent.getAction(), true)) {
                            boolean zA = Ib.a(context);
                            if (zA != Ib.c && C3435k3.f3355a.H()) {
                                Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
                                C3517pb.f().b(new N1(11, String.valueOf(zA), null, 4));
                            }
                        } else if (Intrinsics.areEqual("android.intent.action.USER_PRESENT", intent.getAction())) {
                            Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
                            C3517pb.f().b(new N1(100, null, null, 6));
                        } else if (Intrinsics.areEqual("android.intent.action.ACTION_SHUTDOWN", intent.getAction())) {
                            Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
                            C3517pb.f().b(new N1(1, null, null, 6));
                            Iterator it2 = Ib.f3099a.entrySet().iterator();
                            while (it2.hasNext()) {
                                Ib.b((String) ((Map.Entry) it2.next()).getKey());
                            }
                            Ib.f3099a.clear();
                            Ib.b = null;
                        } else if (Intrinsics.areEqual("android.intent.action.REBOOT", intent.getAction())) {
                            Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
                            C3517pb.f().b(new N1(2, null, null, 6));
                            Iterator it3 = Ib.f3099a.entrySet().iterator();
                            while (it3.hasNext()) {
                                Ib.b((String) ((Map.Entry) it3.next()).getKey());
                            }
                            Ib.f3099a.clear();
                            Ib.b = null;
                        } else {
                            Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
                            C3517pb.f().b(new N1(99, intent.getAction(), null, 4));
                        }
                    }
                } catch (Exception unused) {
                    ConcurrentHashMap concurrentHashMap2 = Ib.f3099a;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
