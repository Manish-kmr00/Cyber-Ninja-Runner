package com.apm.insight.k;

import com.apm.insight.CrashType;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashUploadHandler.java */
/* JADX INFO: loaded from: classes9.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<c> f230a = new ConcurrentLinkedQueue<>();

    static void a(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<c> concurrentLinkedQueue = f230a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        new a(jSONObject, crashType);
        while (!f230a.isEmpty()) {
            f230a.poll();
        }
        f230a = null;
    }

    /* JADX INFO: compiled from: CrashUploadHandler.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f232a;
        private JSONObject b;
        private CrashType c;

        a(JSONObject jSONObject, CrashType crashType) {
            this.c = crashType;
            if (crashType == CrashType.LAUNCH) {
                this.f232a = ((JSONArray) jSONObject.opt("data")).optJSONObject(0);
            } else {
                this.f232a = jSONObject;
            }
            this.b = jSONObject.optJSONObject("header");
        }

        public final String a() {
            return this.f232a.optString("crash_thread_name", null);
        }

        public final long b() {
            return this.f232a.optInt("app_start_time", -1);
        }

        public final String c() {
            int i = AnonymousClass1.f231a[this.c.ordinal()];
            if (i == 1) {
                return this.f232a.optString("data", null);
            }
            if (i == 2) {
                return this.f232a.optString("stack", null);
            }
            if (i != 3) {
                return null;
            }
            return this.f232a.optString("data", null);
        }
    }

    /* JADX INFO: renamed from: com.apm.insight.k.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: CrashUploadHandler.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f231a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f231a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f231a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f231a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
