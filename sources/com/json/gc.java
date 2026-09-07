package com.json;

import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;

/* JADX INFO: loaded from: classes10.dex */
class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f3719a = "ironbeast";
    static final String b = "outcome";
    static final int c = 3;
    static final int d = 2;
    static final int e = 0;

    gc() {
    }

    static e a(String str, int i) {
        if (f3719a.equals(str)) {
            return new lk(i);
        }
        if (b.equals(str)) {
            return new wo(i);
        }
        if (i == 2) {
            return new lk(i);
        }
        if (i == 3) {
            return new wo(i);
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.NATIVE, "EventsFormatterFactory failed to instantiate a formatter (type: " + str + ", adUnit: " + i + ")", 2);
        return null;
    }
}
