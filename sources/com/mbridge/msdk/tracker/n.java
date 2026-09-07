package com.mbridge.msdk.tracker;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: MemoryEventFilter.java */
/* JADX INFO: loaded from: classes7.dex */
public class n implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f5625a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: MemoryEventFilter.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f5626a;

        public a(boolean z) {
            this.f5626a = z;
        }

        public boolean a() {
            return this.f5626a;
        }
    }

    @Override // com.mbridge.msdk.tracker.f
    public boolean a(e eVar) throws Exception {
        a aVar;
        if (eVar != null && !TextUtils.isEmpty(eVar.b())) {
            try {
                String strB = eVar.b();
                if (this.f5625a.containsKey(strB)) {
                    aVar = this.f5625a.get(strB);
                } else {
                    a aVar2 = new a(com.mbridge.msdk.foundation.same.report.c.a(strB));
                    this.f5625a.put(strB, aVar2);
                    aVar = aVar2;
                }
                return aVar != null && aVar.a();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("TrackManager", "apply", e);
                }
            }
        }
        return false;
    }
}
