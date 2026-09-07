package com.json;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.os.Build;
import android.os.ext.SdkExtensions;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\n\u001a\u00020\u00068GX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/ironsource/k1;", "", "Landroid/content/Context;", "context", "Landroid/adservices/measurement/MeasurementManager;", "a", "", "()I", "getSdkExtensionLevel$annotations", "()V", "sdkExtensionLevel", "<init>", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f3824a = new k1();

    private k1() {
    }

    public static final int a() {
        if (Build.VERSION.SDK_INT < 30) {
            return 0;
        }
        try {
            return SdkExtensions.getExtensionVersion(1000000);
        } catch (Exception e) {
            o9.d().a(e);
            return 0;
        }
    }

    @JvmStatic
    public static final MeasurementManager a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 30 || a() < 4) {
            return null;
        }
        try {
            return (MeasurementManager) context.getSystemService(MeasurementManager.class);
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static /* synthetic */ void b() {
    }
}
