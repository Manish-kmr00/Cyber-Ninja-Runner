package com.inmobi.media;

import android.os.Build;
import com.inmobi.commons.core.configs.TelemetryConfig;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Xb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TelemetryConfig f3238a;

    public Xb(TelemetryConfig telemetryConfig) {
        Intrinsics.checkNotNullParameter(telemetryConfig, "telemetryConfig");
        this.f3238a = telemetryConfig;
        C3517pb.f().a(new int[]{150, 152}, new Wb(this));
    }

    public final void a(N0 n0) {
        if (Build.VERSION.SDK_INT < 30 || n0 == null || n0.g != 6) {
            return;
        }
        a("ANREvent", n0);
    }

    public final void a(String str, C3353e5 c3353e5) {
        if (this.f3238a.getPriorityEventsList().contains(str) && c3353e5 != null && Ec.a(c3353e5)) {
            Ob.b(str, new LinkedHashMap(), Sb.SDK);
        }
    }
}
