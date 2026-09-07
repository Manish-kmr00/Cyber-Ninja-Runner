package com.inmobi.media;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.inmobi.media.a9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3300a9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3268a;
    public final L4 b;
    public final String c;
    public final boolean d;
    public final SignalsConfig.NovatiqConfig e;

    public C3300a9(Context context, L4 l4) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3268a = context;
        this.b = l4;
        this.c = "";
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        SignalsConfig.NovatiqConfig novatiqConfig = ((SignalsConfig) B4.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getNovatiqConfig();
        this.e = novatiqConfig;
        Intrinsics.checkNotNullParameter(context, "context");
        if (novatiqConfig.getIsNovatiqEnabled()) {
            Object systemService = context.getSystemService("phone");
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : null;
            String str = networkOperatorName != null ? networkOperatorName : "";
            List<String> carrierNames = novatiqConfig.getCarrierNames();
            if (!(carrierNames instanceof Collection) || !carrierNames.isEmpty()) {
                Iterator<T> it = carrierNames.iterator();
                while (it.hasNext()) {
                    if (StringsKt.contains((CharSequence) str, (CharSequence) it.next(), true)) {
                        try {
                            Context context2 = this.f3268a;
                            Intrinsics.checkNotNullParameter(context2, "context");
                            String str2 = StringsKt.replace$default(context2.getPackageManager().getApplicationLabel(context2.getApplicationInfo()).toString(), ' ', '_', false, 4, (Object) null) + "_app";
                            this.d = true;
                            StringBuilder sb = new StringBuilder();
                            Random random = new Random();
                            for (int i = 0; i < 40; i++) {
                                char cCharAt = "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxxxxxx".charAt(i);
                                if (cCharAt == 'x') {
                                    sb.append(Character.forDigit(random.nextInt(16), 16));
                                } else {
                                    sb.append(cCharAt);
                                }
                            }
                            String string = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            this.c = string;
                            new C3329c9(new C3315b9(string, str2, this.e), this.b).a(new Z8(this));
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
            }
        }
        L4 l5 = this.b;
        if (l5 != null) {
            ((M4) l5).a("NovatiqDataHandler", "Novatiq disabled.. skipping");
        }
    }
}
