package com.moloco.sdk.internal;

/* JADX INFO: loaded from: classes12.dex */
public interface w {

    public static final class a {
        public static /* synthetic */ boolean a(w wVar, String str, long j, s sVar, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i & 4) != 0) {
                sVar = null;
            }
            return wVar.a(str, j, sVar);
        }
    }

    boolean a(String str, long j, s sVar);
}
