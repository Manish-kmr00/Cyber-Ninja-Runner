package com.json;

import android.app.Activity;
import android.content.Context;
import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.controller.v;
import com.yandex.div.core.ScrollDirection;

/* JADX INFO: loaded from: classes8.dex */
public class u5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u5 f4482a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4483a;

        static {
            int[] iArr = new int[eh.a.values().length];
            f4483a = iArr;
            try {
                iArr[eh.a.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4483a[eh.a.Device.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4483a[eh.a.Controller.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static u5 a() {
        u5 u5Var = f4482a;
        return u5Var == null ? new u5() : u5Var;
    }

    public boolean a(Activity activity) {
        if (a.f4483a[ik.e().b().ordinal()] != 3) {
            return false;
        }
        try {
            v vVar = (v) vj.b((Context) activity).a().j();
            if (vVar == null) {
                return true;
            }
            vVar.k(ScrollDirection.BACK);
            return true;
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }
}
