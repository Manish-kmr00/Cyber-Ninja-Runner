package com.moloco.sdk.internal.error;

/* JADX INFO: loaded from: classes8.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b bVar, String str, com.moloco.sdk.internal.error.a aVar, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportError");
            }
            if ((i & 2) != 0) {
                aVar = new com.moloco.sdk.internal.error.a(null, 1, null);
            }
            bVar.a(str, aVar);
        }
    }

    void a(String str, com.moloco.sdk.internal.error.a aVar);
}
