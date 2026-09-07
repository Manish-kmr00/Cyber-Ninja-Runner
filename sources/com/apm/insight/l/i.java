package com.apm.insight.l;

import android.app.ActivityManager;

/* JADX INFO: compiled from: JellyBeanV16Compat.java */
/* JADX INFO: loaded from: classes12.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f254a = new b(0);

    /* JADX INFO: compiled from: JellyBeanV16Compat.java */
    static class a {
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: compiled from: JellyBeanV16Compat.java */
    static class b extends a {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.apm.insight.l.i.a
        public final long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return f254a.a(memoryInfo);
    }
}
