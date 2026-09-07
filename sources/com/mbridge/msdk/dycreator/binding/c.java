package com.mbridge.msdk.dycreator.binding;

import android.text.TextUtils;
import com.mbridge.msdk.dycreator.binding.base.BaseStrategy;
import com.mbridge.msdk.dycreator.binding.strategy.d;
import com.mbridge.msdk.dycreator.binding.strategy.e;
import com.mbridge.msdk.dycreator.binding.strategy.f;
import com.mbridge.msdk.dycreator.binding.strategy.g;

/* JADX INFO: compiled from: ViewDataFactory.java */
/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f4845a;

    private c() {
    }

    public static c a() {
        if (f4845a == null) {
            synchronized (c.class) {
                if (f4845a == null) {
                    f4845a = new c();
                }
            }
        }
        return f4845a;
    }

    public <T extends BaseStrategy> T a(String str) {
        T aVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("close")) {
            aVar = new com.mbridge.msdk.dycreator.binding.strategy.c();
        } else if (str.equals("download")) {
            aVar = new com.mbridge.msdk.dycreator.binding.strategy.b();
        } else if (!str.equals("deeplink") && str.equals("activity")) {
            aVar = new com.mbridge.msdk.dycreator.binding.strategy.a();
        }
        if (str.equals("feedback")) {
            aVar = new d();
        }
        if (str.equals("notice")) {
            aVar = new e();
        }
        if (str.equals("permissionInfo")) {
            aVar = new f();
        }
        return str.equals("privateAddress") ? new g() : aVar;
    }
}
