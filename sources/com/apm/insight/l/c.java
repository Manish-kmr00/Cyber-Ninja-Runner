package com.apm.insight.l;

import android.os.Debug;
import java.util.Map;

/* JADX INFO: compiled from: DebugMemInfoCompat.java */
/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f246a = new b(0);

    /* JADX INFO: compiled from: DebugMemInfoCompat.java */
    static class a {
        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: compiled from: DebugMemInfoCompat.java */
    static class b extends a {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.apm.insight.l.c.a
        public final int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.apm.insight.l.c.a
        public final int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.apm.insight.l.c.a
        public final int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return f246a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return f246a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return f246a.c(memoryInfo);
    }

    /* JADX INFO: renamed from: com.apm.insight.l.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: DebugMemInfoCompat.java */
    public static /* synthetic */ class AnonymousClass1 {
        public static Long a(Map<? super String, Long> map, String str, Long l) {
            if (str == null || map == null) {
                return -1L;
            }
            Long l2 = map.get(str);
            if (l2 != null) {
                l = Long.valueOf(l2.longValue() + l.longValue());
            }
            map.put(str, l);
            return l;
        }

        public static Float a(Map<? super String, Float> map) {
            float fFloatValue = 0.0f;
            for (Float f : map.values()) {
                if (f != null) {
                    fFloatValue += f.floatValue();
                }
            }
            return Float.valueOf(fFloatValue);
        }

        public static int a(Object obj, int i) {
            if (obj == null) {
                return i;
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof String) {
                try {
                    return Integer.parseInt(String.valueOf(obj));
                } catch (Throwable unused) {
                }
            }
            return i;
        }
    }
}
