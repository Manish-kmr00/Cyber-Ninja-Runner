package com.apm.insight.b;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.k;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.o;
import com.apm.insight.runtime.p;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.b9;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.unity3d.services.UnityAdsConstants;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ANRManager.java */
/* JADX INFO: loaded from: classes10.dex */
public final class b {
    private static volatile boolean z = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f167a;
    private final Context b;
    private volatile boolean c;
    private JSONObject g;
    private JSONObject h;
    private JSONArray m;
    private JSONObject n;
    private JSONArray q;
    private JSONArray r;
    private JSONObject s;
    private boolean t;
    private volatile boolean v;
    private long d = -1;
    private File e = null;
    private boolean f = true;
    private String i = "unknown";
    private String j = "unknown";
    private String k = "unknown";
    private String l = "npth_inner_default";
    private int o = 0;
    private long p = -1;
    private final Object u = new Object();
    private long w = -1;
    private long x = 0;
    private final Runnable y = new Runnable() { // from class: com.apm.insight.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.this.g();
            } catch (Throwable th) {
                com.apm.insight.c.a();
                k.a(th, "NPTH_CATCH");
            }
        }
    };
    private int A = 0;
    private List<Pattern> B = null;
    private Pattern C = null;
    private File D = null;

    public b(Context context) {
        this.b = context;
    }

    public final void a() {
        if (this.c) {
            return;
        }
        this.f167a = new c(this);
        this.d = com.apm.insight.e.j();
        this.c = true;
    }

    public final void b() {
        if (this.c) {
            this.c = false;
            c cVar = this.f167a;
            if (cVar != null) {
                cVar.b();
            }
            this.f167a = null;
        }
    }

    public final void c() {
        c cVar = this.f167a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void d() {
        synchronized (this.u) {
        }
        this.y.run();
    }

    public final void e() {
        if (NativeImpl.h()) {
            try {
                com.apm.insight.l.f.a(i(), String.valueOf(this.A + 1), false);
            } catch (Throwable th) {
                com.apm.insight.c.a();
                k.a(th, "NPTH_CATCH");
            }
        }
        this.w = SystemClock.uptimeMillis();
        this.v = true;
    }

    public final void f() {
        File fileI = i();
        try {
            int iIntValue = Integer.decode(com.apm.insight.l.f.a(fileI.getAbsolutePath(), "\n")).intValue();
            this.A = iIntValue;
            if (iIntValue >= 2) {
                NativeImpl.a(false);
            } else {
                NativeImpl.a(true);
            }
        } catch (IOException unused) {
            NativeImpl.a(true);
        } catch (Throwable unused2) {
            com.apm.insight.l.f.a(fileI);
        }
    }

    private boolean a(long j) {
        if (this.v) {
            this.v = false;
            b(j);
        }
        return false;
    }

    private boolean h() {
        boolean zA = com.apm.insight.l.a.a(this.b);
        boolean z2 = !zA;
        if (zA || com.apm.insight.runtime.a.b.d().e() > 2000) {
            return z2;
        }
        return false;
    }

    private void b(long j) {
        if (this.x != this.w) {
            try {
                this.p = System.currentTimeMillis();
                this.r = f.b().b();
                this.q = j.a(j);
                this.h = f.b().a(j).a();
                JSONObject jSONObject = new JSONObject();
                this.s = jSONObject;
                com.apm.insight.l.a.a(this.b, jSONObject);
                this.t = h();
                this.f = !Npth.hasCrash();
            } catch (Throwable unused) {
            }
            try {
                this.d = this.p;
                String strB = com.apm.insight.l.j.b();
                File file = new File(new File(com.apm.insight.l.j.f(this.b), strB), "trace_" + com.apm.insight.l.a.d(this.b).replace(AbstractJsonLexerKt.COLON, '_') + ".txt");
                file.getParentFile().mkdirs();
                com.apm.insight.l.f.a(file, com.apm.insight.l.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                p.a("anr_trace", strB);
                NativeImpl.i(file.getAbsolutePath());
                try {
                    JSONArray jSONArrayA = com.apm.insight.l.f.a(file.getAbsolutePath());
                    this.m = jSONArrayA;
                    a(jSONArrayA);
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    k.a(th, "NPTH_CATCH");
                }
                if (this.g == null) {
                    this.g = d.a();
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                k.a(th2, "NPTH_CATCH");
            }
            com.apm.insight.a.d();
        } else {
            try {
                this.d = this.p;
                String strB2 = com.apm.insight.l.j.b();
                File file2 = new File(new File(com.apm.insight.l.j.f(this.b), strB2), "trace" + com.apm.insight.l.a.d(this.b).replace(AbstractJsonLexerKt.COLON, '_') + ".txt");
                file2.getParentFile().mkdirs();
                com.apm.insight.l.f.a(file2, com.apm.insight.l.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                p.a("anr_trace", strB2);
                NativeImpl.i(file2.getAbsolutePath());
                try {
                    JSONArray jSONArrayA2 = com.apm.insight.l.f.a(file2.getAbsolutePath());
                    this.m = jSONArrayA2;
                    a(jSONArrayA2);
                } catch (IOException unused3) {
                } catch (Throwable th3) {
                    com.apm.insight.c.a();
                    k.a(th3, "NPTH_CATCH");
                }
                if (this.g == null) {
                    this.g = d.a();
                }
            } catch (Throwable th4) {
                com.apm.insight.c.a();
                k.a(th4, "NPTH_CATCH");
            }
        }
        long j2 = this.w;
        this.x = j2;
        this.w = -1L;
        if (j2 == -1) {
            this.x = (-1) - 1;
        }
    }

    private void a(JSONArray jSONArray) {
        int[] iArrB;
        int[] iArrB2;
        if (jSONArray == null) {
            return;
        }
        this.g = null;
        this.n = null;
        this.o = 0;
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        this.i = "unknown";
        this.j = "unknown";
        this.k = "unknown";
        int[] iArr = {0, 0, 0};
        JSONArray jSONArray5 = jSONArray4;
        String strTrim = null;
        boolean z2 = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            if (TextUtils.isEmpty(strOptString)) {
                if (jSONArray5.length() > 0 && !TextUtils.isEmpty(strTrim)) {
                    if (this.g == null && b9.h.Z.equals(strTrim)) {
                        this.g = c(jSONArray5);
                    } else {
                        jSONArray2.put(a(strTrim, jSONArray5));
                    }
                    try {
                        if (!b9.h.Z.equals(strTrim)) {
                            strTrim = strTrim.substring(0, strTrim.indexOf(40)).trim();
                        }
                    } catch (Throwable unused) {
                    }
                    String str = strTrim;
                    if (!a(str)) {
                        try {
                            iArrB2 = b(jSONArray5);
                        } catch (IllegalArgumentException e) {
                            com.apm.insight.c.a();
                            k.a(e, "NPTH_CATCH");
                            iArrB2 = null;
                        } catch (Throwable unused2) {
                            iArrB2 = null;
                        }
                        if (iArrB2 != null) {
                            int i2 = iArrB2[0];
                            if (i2 > iArr[0]) {
                                iArr[0] = i2;
                                this.i = str;
                            }
                            int i3 = iArrB2[1];
                            if (i3 > iArr[1]) {
                                iArr[1] = i3;
                                this.j = str;
                            }
                            int i4 = iArrB2[2];
                            if (i4 > iArr[2]) {
                                iArr[2] = i4;
                                this.k = str;
                            }
                        }
                    }
                }
                if (jSONArray5.length() > 0) {
                    jSONArray5 = new JSONArray();
                }
                strTrim = null;
            } else {
                if (!z2) {
                    if (strOptString.startsWith("DALVIK THREADS") || strOptString.startsWith("suspend") || strOptString.startsWith("\"")) {
                        z2 = true;
                    }
                    jSONArray3.put(strOptString);
                } else if (z2) {
                    if (strOptString.contains(" prio=")) {
                        if (jSONArray5.length() > 0 && !TextUtils.isEmpty(strTrim)) {
                            if (this.g == null && b9.h.Z.equals(strTrim)) {
                                this.g = c(jSONArray5);
                            } else {
                                jSONArray2.put(a(strTrim, jSONArray5));
                            }
                            try {
                                if (!b9.h.Z.equals(strTrim)) {
                                    strTrim = strTrim.substring(0, strTrim.indexOf(40)).trim();
                                }
                            } catch (Throwable unused3) {
                            }
                            String str2 = strTrim;
                            if (!a(str2)) {
                                try {
                                    iArrB = b(jSONArray5);
                                } catch (IllegalArgumentException e2) {
                                    com.apm.insight.c.a();
                                    k.a(e2, "NPTH_CATCH");
                                    iArrB = null;
                                } catch (Throwable unused4) {
                                    iArrB = null;
                                }
                                if (iArrB != null) {
                                    int i5 = iArrB[0];
                                    if (i5 > iArr[0]) {
                                        iArr[0] = i5;
                                        this.i = str2;
                                    }
                                    int i6 = iArrB[1];
                                    if (i6 > iArr[1]) {
                                        iArr[1] = i6;
                                        this.j = str2;
                                    }
                                    int i7 = iArrB[2];
                                    if (i7 > iArr[2]) {
                                        iArr[2] = i7;
                                        this.k = str2;
                                    }
                                }
                            }
                        }
                        String strSubstring = strOptString.substring(1, strOptString.indexOf(34, 1));
                        strTrim = !b9.h.Z.equals(strSubstring) ? strSubstring + "  (" + strOptString.substring(strOptString.indexOf(34, 2) + 1) + " )" : strSubstring;
                        if (jSONArray5.length() > 0) {
                            jSONArray5 = new JSONArray();
                        }
                        jSONArray5.put(strOptString);
                    } else if (TextUtils.isEmpty(strTrim)) {
                        jSONArray3.put(strOptString);
                    } else {
                        jSONArray5.put(strOptString);
                    }
                }
            }
        }
        if (jSONArray2.length() > 0) {
            this.m = jSONArray3;
            try {
                JSONObject jSONObject = new JSONObject();
                this.n = jSONObject;
                jSONObject.put("thread_all_count", jSONArray2.length());
                this.n.put("thread_stacks", jSONArray2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    private boolean a(String str) {
        if (this.B == null) {
            JSONArray jSONArrayB = com.apm.insight.runtime.a.b();
            if (jSONArrayB != null) {
                this.B = new LinkedList();
                this.l = jSONArrayB.optString(0);
                for (int i = 1; i < jSONArrayB.length(); i++) {
                    try {
                        this.B.add(Pattern.compile(jSONArrayB.optString(i)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.B == null) {
                LinkedList linkedList = new LinkedList();
                this.B = linkedList;
                linkedList.add(Pattern.compile("^main$"));
                this.B.add(Pattern.compile("^default_npth_thread$"));
                this.B.add(Pattern.compile("^RenderThread$"));
                this.B.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        Iterator<Pattern> it = this.B.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private int[] b(JSONArray jSONArray) throws IllegalArgumentException {
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            int iIndexOf = (strOptString == null || strOptString.isEmpty()) ? -1 : strOptString.indexOf("utm=");
            if (iIndexOf > 0) {
                if (this.C == null) {
                    this.C = Pattern.compile("[^0-9]+");
                }
                String[] strArrSplit = this.C.split(strOptString.substring(iIndexOf));
                if (strArrSplit == null || strArrSplit.length < 2) {
                    return null;
                }
                try {
                    int iIntValue = Integer.decode(strArrSplit[1]).intValue();
                    int iIntValue2 = Integer.decode(strArrSplit[2]).intValue();
                    return new int[]{iIntValue, iIntValue2, iIntValue + iIntValue2};
                } catch (Throwable unused) {
                    throw new IllegalArgumentException("Err stack line: ".concat(String.valueOf(strOptString)));
                }
            }
        }
        return null;
    }

    private JSONObject c(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayB = com.apm.insight.a.b(jSONArray);
        if (jSONArrayB.length() != jSONArray.length()) {
            this.o++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArrayB.length(); i++) {
                sb.append(jSONArrayB.getString(i)).append('\n');
            }
            jSONObject.put("mainStackFromTrace", sb.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONObject a(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayB = com.apm.insight.a.b(jSONArray);
        if (jSONArrayB.length() != jSONArray.length()) {
            this.o++;
        }
        try {
            jSONObject.put("thread_name", str);
            jSONObject.put("thread_stack", jSONArrayB);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private File i() {
        if (this.D == null) {
            this.D = new File(this.b.getFilesDir(), "has_anr_signal_" + com.apm.insight.l.a.d(this.b).replaceAll(":", "_"));
        }
        return this.D;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:103:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:105:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:107:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:109:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:111:0x0201  */
    /* JADX WARN: Code duplicated, block: B:114:0x0207  */
    /* JADX WARN: Code duplicated, block: B:115:0x020a  */
    /* JADX WARN: Code duplicated, block: B:116:0x020d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0210  */
    /* JADX WARN: Code duplicated, block: B:118:0x0213  */
    /* JADX WARN: Code duplicated, block: B:120:0x0220  */
    /* JADX WARN: Code duplicated, block: B:123:0x022f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0232 A[PHI: r27
  0x0232: PHI (r27v2 char) = (r3v31 char), (r27v15 char) binds: [B:122:0x022d, B:116:0x020d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:126:0x023c  */
    /* JADX WARN: Code duplicated, block: B:127:0x0240 A[PHI: r27
  0x0240: PHI (r27v3 char) = (r27v2 char), (r27v16 char) binds: [B:125:0x023a, B:115:0x020a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:129:0x024a  */
    /* JADX WARN: Code duplicated, block: B:130:0x024e A[PHI: r27
  0x024e: PHI (r27v4 char) = (r27v3 char), (r27v17 char) binds: [B:128:0x0248, B:114:0x0207] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:132:0x0256  */
    /* JADX WARN: Code duplicated, block: B:133:0x0258 A[PHI: r27
  0x0258: PHI (r27v13 char) = (r27v4 char), (r27v18 char) binds: [B:131:0x0254, B:112:0x0204] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:135:0x0260  */
    /* JADX WARN: Code duplicated, block: B:136:0x0262 A[PHI: r27
  0x0262: PHI (r27v5 char) = (r27v13 char), (r27v18 char) binds: [B:134:0x025e, B:112:0x0204] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:138:0x0267  */
    /* JADX WARN: Code duplicated, block: B:143:0x028c  */
    /* JADX WARN: Code duplicated, block: B:144:0x028f  */
    /* JADX WARN: Code duplicated, block: B:151:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:154:0x02bf A[LOOP:2: B:99:0x01ed->B:154:0x02bf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:155:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:183:0x0368  */
    /* JADX WARN: Code duplicated, block: B:187:0x0379  */
    /* JADX WARN: Code duplicated, block: B:189:0x038b  */
    /* JADX WARN: Code duplicated, block: B:192:0x038f A[LOOP:4: B:190:0x038c->B:192:0x038f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:194:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:201:0x03db A[PHI: r15 r22 r23 r24 r25
  0x03db: PHI (r15v6 java.lang.String) = (r15v5 java.lang.String), (r15v7 java.lang.String), (r15v12 java.lang.String), (r15v26 java.lang.String) binds: [B:199:0x03cc, B:196:0x03ab, B:156:0x02cb, B:15:0x0063] A[DONT_GENERATE, DONT_INLINE]
  0x03db: PHI (r22v3 char) = (r22v1 char), (r22v4 char), (r22v7 char), (r22v8 char) binds: [B:199:0x03cc, B:196:0x03ab, B:156:0x02cb, B:15:0x0063] A[DONT_GENERATE, DONT_INLINE]
  0x03db: PHI (r23v6 java.lang.String) = (r23v2 java.lang.String), (r23v7 java.lang.String), (r23v11 java.lang.String), (r23v12 java.lang.String) binds: [B:199:0x03cc, B:196:0x03ab, B:156:0x02cb, B:15:0x0063] A[DONT_GENERATE, DONT_INLINE]
  0x03db: PHI (r24v8 java.util.HashMap) = (r24v4 java.util.HashMap), (r24v9 java.util.HashMap), (r24v14 java.util.HashMap), (r24v24 java.util.HashMap) binds: [B:199:0x03cc, B:196:0x03ab, B:156:0x02cb, B:15:0x0063] A[DONT_GENERATE, DONT_INLINE]
  0x03db: PHI (r25v8 java.util.HashMap) = (r25v4 java.util.HashMap), (r25v9 java.util.HashMap), (r25v14 java.util.HashMap), (r25v23 java.util.HashMap) binds: [B:199:0x03cc, B:196:0x03ab, B:156:0x02cb, B:15:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:211:0x0437  */
    /* JADX WARN: Code duplicated, block: B:212:0x043b  */
    /* JADX WARN: Code duplicated, block: B:215:0x0452  */
    /* JADX WARN: Code duplicated, block: B:216:0x0456  */
    /* JADX WARN: Code duplicated, block: B:219:0x046d  */
    /* JADX WARN: Code duplicated, block: B:221:0x0471  */
    /* JADX WARN: Code duplicated, block: B:240:0x040c A[EDGE_INSN: B:240:0x040c->B:209:0x040c BREAK  A[LOOP:0: B:3:0x0045->B:207:0x03f4], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x03f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x02cb A[EDGE_INSN: B:244:0x02cb->B:156:0x02cb BREAK  A[LOOP:2: B:99:0x01ed->B:154:0x02bf], SYNTHETIC] */
    private void a(String str, JSONObject jSONObject) throws JSONException {
        HashMap map;
        String str2;
        char c;
        char c2;
        String str3;
        char c3;
        boolean z2;
        String str4;
        String str5;
        String strTrim;
        String[] strArrSplit;
        int i;
        String string;
        HashMap map2;
        String str6;
        int i2;
        char c4;
        String str7;
        String[] strArr;
        float fFloatValue;
        SystemClock.uptimeMillis();
        String[] strArrSplit2 = str.split("\n");
        float[] fArr = new float[3];
        int i3 = 0;
        Float fValueOf = Float.valueOf(-1.0f);
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        fArr[2] = -1.0f;
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        HashMap map5 = new HashMap();
        HashMap map6 = new HashMap();
        HashMap map7 = new HashMap();
        int length = strArrSplit2.length;
        String str8 = "unknown";
        char c5 = 0;
        boolean z3 = false;
        String strTrim2 = "unknown";
        String str9 = strTrim2;
        while (true) {
            if (i3 >= length) {
                map = map6;
                map7 = map7;
                break;
            }
            String strTrim3 = strArrSplit2[i3];
            if (!TextUtils.isEmpty(strTrim3)) {
                if (c5 == 0) {
                    c2 = c5;
                    map = map6;
                    map7 = map7;
                    str2 = str8;
                    str3 = strTrim2;
                    String strTrim4 = strTrim3.trim();
                    if (strTrim4.startsWith("tag:")) {
                        strTrim2 = strTrim4.replace("tag:", "").trim();
                        c3 = 4;
                        c = 1;
                    } else {
                        strTrim2 = str3;
                        c = c2;
                        c3 = 4;
                    }
                } else if (c5 == 1) {
                    c2 = c5;
                    map = map6;
                    map7 = map7;
                    str2 = str8;
                    strTrim3 = strTrim3.trim();
                    String lowerCase = strTrim3.toLowerCase();
                    if (lowerCase.startsWith("shortmsg")) {
                        strTrim3.substring(strTrim3.indexOf(58));
                        z2 = false;
                    } else {
                        if (lowerCase.startsWith("reason:")) {
                            strTrim3.substring(strTrim3.indexOf(58));
                            z2 = true;
                        } else {
                            str3 = strTrim2;
                            if (lowerCase.contains("appfreeze")) {
                                c = '\n';
                                str9 = "AppFreeze";
                                strTrim2 = str3;
                            } else {
                                strTrim2 = str3;
                                c = c2;
                            }
                        }
                        c3 = 4;
                    }
                    if (lowerCase.contains("input dispatch")) {
                        str5 = "Input dispatching timed out";
                    } else {
                        if (lowerCase.contains("broadcast of intent")) {
                            str5 = "Broadcast of Intent";
                        } else if (lowerCase.contains("executing service")) {
                            str4 = strTrim2;
                            if (!"null".equalsIgnoreCase(str4)) {
                                str9 = "executing service";
                                strTrim2 = str4;
                            } else {
                                strTrim2 = strTrim3.substring(strTrim3.indexOf("service ") + 8).trim();
                                str9 = "executing service";
                            }
                        } else {
                            str4 = strTrim2;
                            if (lowerCase.contains("service.startforeground")) {
                                str9 = "not call Service.startForeground";
                                strTrim2 = str4;
                            } else {
                                strTrim2 = str4;
                                str9 = str2;
                            }
                        }
                        if (z2) {
                            c3 = 4;
                            c = 2;
                        }
                        strTrim = strTrim3.trim();
                        if (strTrim.startsWith("Load:")) {
                            strArrSplit = strTrim.replace("Load:", "").trim().split(RemoteSettings.FORWARD_SLASH_STRING);
                            if (3 == strArrSplit.length) {
                                for (i = 0; i < strArrSplit.length; i++) {
                                    fArr[i] = Float.valueOf(strArrSplit[i]).floatValue();
                                }
                            }
                            c = 3;
                        } else {
                            c = c2;
                        }
                        c3 = 4;
                    }
                    str9 = str5;
                    if (z2) {
                        c3 = 4;
                        c = 2;
                    }
                    strTrim = strTrim3.trim();
                    if (strTrim.startsWith("Load:")) {
                        strArrSplit = strTrim.replace("Load:", "").trim().split(RemoteSettings.FORWARD_SLASH_STRING);
                        if (3 == strArrSplit.length) {
                            while (i < strArrSplit.length) {
                                fArr[i] = Float.valueOf(strArrSplit[i]).floatValue();
                            }
                        }
                        c = 3;
                    } else {
                        c = c2;
                    }
                    c3 = 4;
                } else if (c5 != 2) {
                    if (c5 != 3) {
                        c2 = c5;
                        map = map6;
                        map7 = map7;
                        str2 = str8;
                        str3 = strTrim2;
                    } else {
                        String[] strArrSplit3 = strTrim3.split("\\s");
                        c2 = c5;
                        str2 = str8;
                        if (strArrSplit3.length < 2) {
                            map = map6;
                            map7 = map7;
                        } else {
                            if ("CPU".equalsIgnoreCase(strArrSplit3[0]) && "usage".equalsIgnoreCase(strArrSplit3[1])) {
                                if (strTrim3.contains("ago")) {
                                    z3 = true;
                                }
                                if (map3.isEmpty() && map4.isEmpty() && map5.isEmpty() && map7.isEmpty() && map6.isEmpty()) {
                                    map = map6;
                                    map7 = map7;
                                    c = c2;
                                    c3 = 4;
                                }
                            } else if (map3.isEmpty() || map4.isEmpty() || map5.isEmpty() || map7.isEmpty() || map6.isEmpty()) {
                                if (map3.isEmpty() && strArrSplit3[1].equalsIgnoreCase("TOTAL:")) {
                                    string = "";
                                    map2 = map3;
                                } else if (strTrim3.contains(this.b.getPackageName())) {
                                    string = "";
                                    int i4 = 0;
                                    while (i4 < strArrSplit3.length) {
                                        if (strArrSplit3[i4].contains(this.b.getPackageName())) {
                                            StringBuilder sb = new StringBuilder();
                                            String str10 = strArrSplit3[i4];
                                            string = sb.append(str10.substring(str10.indexOf(47) + 1, strArrSplit3[i4].length() - 1)).append('_').toString();
                                        }
                                        i4++;
                                        this = this;
                                    }
                                    map2 = map5;
                                } else if (map4.isEmpty() && strTrim3.contains("system_server:")) {
                                    string = "";
                                    map2 = map4;
                                } else if (map7.isEmpty() && strTrim3.contains("kswapd")) {
                                    string = "";
                                    map2 = map7;
                                } else if (!map6.isEmpty() || !strTrim3.contains("dex2oat")) {
                                    string = "";
                                    map2 = null;
                                } else {
                                    string = "";
                                    map2 = map6;
                                }
                                if (map2 != null) {
                                    int i5 = 0;
                                    do {
                                        str6 = "%";
                                        if (strArrSplit3[i5].contains("%")) {
                                            break;
                                        } else {
                                            i5++;
                                        }
                                    } while (i5 < strArrSplit3.length);
                                    try {
                                        float fFloatValue2 = Float.valueOf(strArrSplit3[i5].replace("%", "")).floatValue();
                                        map = map6;
                                        try {
                                            String str11 = string + b9.h.l;
                                            if (map2 != map3) {
                                                fFloatValue2 /= com.apm.insight.l.d.d();
                                            }
                                            try {
                                                map2.put(str11, Float.valueOf(fFloatValue2));
                                            } catch (Throwable unused) {
                                                map2.put(string + b9.h.l, fValueOf);
                                            }
                                        } catch (Throwable unused2) {
                                            map7 = map7;
                                            map2.put(string + b9.h.l, fValueOf);
                                            i2 = i5 + 3;
                                            c4 = 0;
                                            while (i2 < strArrSplit3.length) {
                                                str7 = "softirq";
                                                if (c4 != 0) {
                                                    if (POBConstants.KEY_USER.equalsIgnoreCase(strArrSplit3[i2])) {
                                                        str7 = POBConstants.KEY_USER;
                                                        c4 = 1;
                                                    }
                                                    if (str7 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str12 = string + str7;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str12, Float.valueOf(fFloatValue));
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str6 = str6;
                                                    }
                                                    if (c4 < 6) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i2 += 3;
                                                        strArrSplit3 = strArr;
                                                        str6 = str6;
                                                    }
                                                } else {
                                                    if (c4 != 1) {
                                                        if (c4 != 2) {
                                                            c4 = c4;
                                                            if ("iowait".equalsIgnoreCase(strArrSplit3[i2])) {
                                                                str7 = "iowait";
                                                                c4 = 3;
                                                            } else if ("irq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                                if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                                    c4 = 5;
                                                                } else if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                                    c4 = 6;
                                                                }
                                                            } else {
                                                                str7 = "irq";
                                                                c4 = 4;
                                                            }
                                                            if (str7 != null) {
                                                                fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                                strArr = strArrSplit3;
                                                                String str13 = string + str7;
                                                                if (map2 == map3) {
                                                                    fFloatValue /= com.apm.insight.l.d.d();
                                                                }
                                                                map2.put(str13, Float.valueOf(fFloatValue));
                                                            } else {
                                                                strArr = strArrSplit3;
                                                                str6 = str6;
                                                            }
                                                            if (c4 < 6) {
                                                                break;
                                                                break;
                                                            } else {
                                                                i2 += 3;
                                                                strArrSplit3 = strArr;
                                                                str6 = str6;
                                                            }
                                                        } else if (c4 != 3) {
                                                            c4 = c4;
                                                            if ("irq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                                if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                                    c4 = 5;
                                                                } else if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                                    c4 = 6;
                                                                }
                                                            } else {
                                                                str7 = "irq";
                                                                c4 = 4;
                                                            }
                                                            if (str7 != null) {
                                                                fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                                strArr = strArrSplit3;
                                                                String str14 = string + str7;
                                                                if (map2 == map3) {
                                                                    fFloatValue /= com.apm.insight.l.d.d();
                                                                }
                                                                map2.put(str14, Float.valueOf(fFloatValue));
                                                            } else {
                                                                strArr = strArrSplit3;
                                                                str6 = str6;
                                                            }
                                                            if (c4 < 6) {
                                                                break;
                                                                break;
                                                            } else {
                                                                i2 += 3;
                                                                strArrSplit3 = strArr;
                                                                str6 = str6;
                                                            }
                                                        } else if (c4 != 4) {
                                                            c4 = c4;
                                                            if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                                c4 = 5;
                                                            } else if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                                c4 = 6;
                                                            }
                                                            if (str7 != null) {
                                                                fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                                strArr = strArrSplit3;
                                                                String str15 = string + str7;
                                                                if (map2 == map3) {
                                                                    fFloatValue /= com.apm.insight.l.d.d();
                                                                }
                                                                map2.put(str15, Float.valueOf(fFloatValue));
                                                            } else {
                                                                strArr = strArrSplit3;
                                                                str6 = str6;
                                                            }
                                                            if (c4 < 6) {
                                                                break;
                                                                break;
                                                            } else {
                                                                i2 += 3;
                                                                strArrSplit3 = strArr;
                                                                str6 = str6;
                                                            }
                                                        } else {
                                                            c4 = c4;
                                                            if (c4 != 5) {
                                                                if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                                    c4 = 6;
                                                                }
                                                            }
                                                            if (str7 != null) {
                                                                try {
                                                                    fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                                    strArr = strArrSplit3;
                                                                    try {
                                                                        String str16 = string + str7;
                                                                        if (map2 == map3) {
                                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                                        }
                                                                        try {
                                                                            map2.put(str16, Float.valueOf(fFloatValue));
                                                                        } catch (Throwable unused3) {
                                                                            map2.put(string + str7, fValueOf);
                                                                        }
                                                                    } catch (Throwable unused4) {
                                                                        str6 = str6;
                                                                        map2.put(string + str7, fValueOf);
                                                                        if (c4 < 6) {
                                                                            i2 += 3;
                                                                            strArrSplit3 = strArr;
                                                                            str6 = str6;
                                                                        } else {
                                                                            break;
                                                                            str3 = strTrim2;
                                                                            strTrim2 = str3;
                                                                            c = c2;
                                                                            c3 = 4;
                                                                            if (c >= c3) {
                                                                                break;
                                                                                jSONObject.put("anr_tag", strTrim2);
                                                                                jSONObject.put("anr_has_ago", String.valueOf(z3));
                                                                                jSONObject.put("anr_reason", str9);
                                                                                a(map5, jSONObject, "app");
                                                                                a(map3, jSONObject, b9.h.l);
                                                                                if (map4.isEmpty()) {
                                                                                    jSONObject.put("npth_anr_systemserver_total", "not found");
                                                                                } else {
                                                                                    jSONObject.put("npth_anr_systemserver_total", b(com.apm.insight.l.c.AnonymousClass1.a(map4).floatValue()));
                                                                                }
                                                                                if (map7.isEmpty()) {
                                                                                    jSONObject.put("npth_anr_kswapd_total", "not found");
                                                                                } else {
                                                                                    jSONObject.put("npth_anr_kswapd_total", b(com.apm.insight.l.c.AnonymousClass1.a(map7).floatValue()));
                                                                                }
                                                                                if (map.isEmpty()) {
                                                                                    jSONObject.put("npth_anr_dex2oat_total", "not found");
                                                                                } else {
                                                                                    jSONObject.put("npth_anr_dex2oat_total", b(com.apm.insight.l.c.AnonymousClass1.a(map).floatValue()));
                                                                                }
                                                                            }
                                                                            i3++;
                                                                            c5 = c;
                                                                            strArrSplit2 = strArrSplit2;
                                                                            length = length;
                                                                            str8 = str2;
                                                                            map6 = map;
                                                                            map7 = map7;
                                                                        }
                                                                    }
                                                                } catch (Throwable unused5) {
                                                                    strArr = strArrSplit3;
                                                                }
                                                            } else {
                                                                strArr = strArrSplit3;
                                                                str6 = str6;
                                                            }
                                                            if (c4 < 6) {
                                                                break;
                                                            }
                                                            i2 += 3;
                                                            strArrSplit3 = strArr;
                                                            str6 = str6;
                                                        }
                                                    }
                                                    c4 = c4;
                                                    str7 = null;
                                                    if (str7 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str17 = string + str7;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str17, Float.valueOf(fFloatValue));
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str6 = str6;
                                                    }
                                                    if (c4 < 6) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i2 += 3;
                                                        strArrSplit3 = strArr;
                                                        str6 = str6;
                                                    }
                                                }
                                                if ("kernel".equalsIgnoreCase(strArrSplit3[i2])) {
                                                    str7 = "kernel";
                                                    c4 = 2;
                                                } else if ("iowait".equalsIgnoreCase(strArrSplit3[i2])) {
                                                    str7 = "iowait";
                                                    c4 = 3;
                                                } else if ("irq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                    if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                        c4 = 5;
                                                    } else if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                        c4 = 6;
                                                    } else {
                                                        c4 = c4;
                                                        str7 = null;
                                                    }
                                                } else {
                                                    str7 = "irq";
                                                    c4 = 4;
                                                }
                                                if (str7 != null) {
                                                    fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                    strArr = strArrSplit3;
                                                    String str18 = string + str7;
                                                    if (map2 == map3) {
                                                        fFloatValue /= com.apm.insight.l.d.d();
                                                    }
                                                    map2.put(str18, Float.valueOf(fFloatValue));
                                                } else {
                                                    strArr = strArrSplit3;
                                                    str6 = str6;
                                                }
                                                if (c4 < 6) {
                                                    break;
                                                    break;
                                                } else {
                                                    i2 += 3;
                                                    strArrSplit3 = strArr;
                                                    str6 = str6;
                                                }
                                            }
                                            str3 = strTrim2;
                                            strTrim2 = str3;
                                            c = c2;
                                            c3 = 4;
                                            if (c >= c3) {
                                                break;
                                                jSONObject.put("anr_tag", strTrim2);
                                                jSONObject.put("anr_has_ago", String.valueOf(z3));
                                                jSONObject.put("anr_reason", str9);
                                                a(map5, jSONObject, "app");
                                                a(map3, jSONObject, b9.h.l);
                                                if (map4.isEmpty()) {
                                                    jSONObject.put("npth_anr_systemserver_total", "not found");
                                                } else {
                                                    jSONObject.put("npth_anr_systemserver_total", b(com.apm.insight.l.c.AnonymousClass1.a(map4).floatValue()));
                                                }
                                                if (map7.isEmpty()) {
                                                    jSONObject.put("npth_anr_kswapd_total", "not found");
                                                } else {
                                                    jSONObject.put("npth_anr_kswapd_total", b(com.apm.insight.l.c.AnonymousClass1.a(map7).floatValue()));
                                                }
                                                if (map.isEmpty()) {
                                                    jSONObject.put("npth_anr_dex2oat_total", "not found");
                                                } else {
                                                    jSONObject.put("npth_anr_dex2oat_total", b(com.apm.insight.l.c.AnonymousClass1.a(map).floatValue()));
                                                }
                                            }
                                            i3++;
                                            c5 = c;
                                            strArrSplit2 = strArrSplit2;
                                            length = length;
                                            str8 = str2;
                                            map6 = map;
                                            map7 = map7;
                                        }
                                    } catch (Throwable unused6) {
                                        map = map6;
                                    }
                                    i2 = i5 + 3;
                                    c4 = 0;
                                    while (i2 < strArrSplit3.length) {
                                        str7 = "softirq";
                                        if (c4 != 0) {
                                            if (POBConstants.KEY_USER.equalsIgnoreCase(strArrSplit3[i2])) {
                                                str7 = POBConstants.KEY_USER;
                                                c4 = 1;
                                            }
                                            if (str7 != null) {
                                                fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                strArr = strArrSplit3;
                                                String str19 = string + str7;
                                                if (map2 == map3) {
                                                    fFloatValue /= com.apm.insight.l.d.d();
                                                }
                                                map2.put(str19, Float.valueOf(fFloatValue));
                                            } else {
                                                strArr = strArrSplit3;
                                                str6 = str6;
                                            }
                                            if (c4 < 6) {
                                                break;
                                                break;
                                            } else {
                                                i2 += 3;
                                                strArrSplit3 = strArr;
                                                str6 = str6;
                                            }
                                        } else {
                                            if (c4 != 1) {
                                                if (c4 != 2) {
                                                    c4 = c4;
                                                    if ("iowait".equalsIgnoreCase(strArrSplit3[i2])) {
                                                        str7 = "iowait";
                                                        c4 = 3;
                                                    } else if ("irq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                        if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                            c4 = 5;
                                                        } else if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                            c4 = 6;
                                                        }
                                                    } else {
                                                        str7 = "irq";
                                                        c4 = 4;
                                                    }
                                                    if (str7 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str110 = string + str7;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str110, Float.valueOf(fFloatValue));
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str6 = str6;
                                                    }
                                                    if (c4 < 6) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i2 += 3;
                                                        strArrSplit3 = strArr;
                                                        str6 = str6;
                                                    }
                                                } else if (c4 != 3) {
                                                    c4 = c4;
                                                    if ("irq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                        if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                            c4 = 5;
                                                        } else if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                            c4 = 6;
                                                        }
                                                    } else {
                                                        str7 = "irq";
                                                        c4 = 4;
                                                    }
                                                    if (str7 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str111 = string + str7;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str111, Float.valueOf(fFloatValue));
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str6 = str6;
                                                    }
                                                    if (c4 < 6) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i2 += 3;
                                                        strArrSplit3 = strArr;
                                                        str6 = str6;
                                                    }
                                                } else if (c4 != 4) {
                                                    c4 = c4;
                                                    if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                        c4 = 5;
                                                    } else if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                        c4 = 6;
                                                    }
                                                    if (str7 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str112 = string + str7;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str112, Float.valueOf(fFloatValue));
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str6 = str6;
                                                    }
                                                    if (c4 < 6) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i2 += 3;
                                                        strArrSplit3 = strArr;
                                                        str6 = str6;
                                                    }
                                                } else {
                                                    c4 = c4;
                                                    if (c4 != 5) {
                                                        if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                            c4 = 6;
                                                        }
                                                    }
                                                    if (str7 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str113 = string + str7;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str113, Float.valueOf(fFloatValue));
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str6 = str6;
                                                    }
                                                    if (c4 < 6) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i2 += 3;
                                                        strArrSplit3 = strArr;
                                                        str6 = str6;
                                                    }
                                                }
                                            }
                                            c4 = c4;
                                            str7 = null;
                                            if (str7 != null) {
                                                fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                                strArr = strArrSplit3;
                                                String str114 = string + str7;
                                                if (map2 == map3) {
                                                    fFloatValue /= com.apm.insight.l.d.d();
                                                }
                                                map2.put(str114, Float.valueOf(fFloatValue));
                                            } else {
                                                strArr = strArrSplit3;
                                                str6 = str6;
                                            }
                                            if (c4 < 6) {
                                                break;
                                                break;
                                            } else {
                                                i2 += 3;
                                                strArrSplit3 = strArr;
                                                str6 = str6;
                                            }
                                        }
                                        if ("kernel".equalsIgnoreCase(strArrSplit3[i2])) {
                                            str7 = "kernel";
                                            c4 = 2;
                                        } else if ("iowait".equalsIgnoreCase(strArrSplit3[i2])) {
                                            str7 = "iowait";
                                            c4 = 3;
                                        } else if ("irq".equalsIgnoreCase(strArrSplit3[i2])) {
                                            if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                c4 = 5;
                                            } else if ("softirq".equalsIgnoreCase(strArrSplit3[i2])) {
                                                c4 = 6;
                                            } else {
                                                c4 = c4;
                                                str7 = null;
                                            }
                                        } else {
                                            str7 = "irq";
                                            c4 = 4;
                                        }
                                        if (str7 != null) {
                                            fFloatValue = Float.valueOf(strArrSplit3[i2 - 1].replace(str6, "")).floatValue();
                                            strArr = strArrSplit3;
                                            String str115 = string + str7;
                                            if (map2 == map3) {
                                                fFloatValue /= com.apm.insight.l.d.d();
                                            }
                                            map2.put(str115, Float.valueOf(fFloatValue));
                                        } else {
                                            strArr = strArrSplit3;
                                            str6 = str6;
                                        }
                                        if (c4 < 6) {
                                            break;
                                            break;
                                        } else {
                                            i2 += 3;
                                            strArrSplit3 = strArr;
                                            str6 = str6;
                                        }
                                    }
                                } else {
                                    map = map6;
                                    map7 = map7;
                                }
                            }
                            map = map6;
                            map7 = map7;
                            c3 = 4;
                            c = 4;
                        }
                        str3 = strTrim2;
                    }
                    strTrim2 = str3;
                    c = c2;
                    c3 = 4;
                } else {
                    c2 = c5;
                    map = map6;
                    map7 = map7;
                    str2 = str8;
                    strTrim = strTrim3.trim();
                    if (strTrim.startsWith("Load:")) {
                        strArrSplit = strTrim.replace("Load:", "").trim().split(RemoteSettings.FORWARD_SLASH_STRING);
                        if (3 == strArrSplit.length) {
                            while (i < strArrSplit.length) {
                                fArr[i] = Float.valueOf(strArrSplit[i]).floatValue();
                            }
                        }
                        c = 3;
                    } else {
                        c = c2;
                    }
                    c3 = 4;
                }
                if (c >= c3) {
                    break;
                }
            } else {
                map = map6;
                map7 = map7;
                str2 = str8;
                c = c5;
            }
            i3++;
            c5 = c;
            strArrSplit2 = strArrSplit2;
            length = length;
            str8 = str2;
            map6 = map;
            map7 = map7;
        }
        jSONObject.put("anr_tag", strTrim2);
        jSONObject.put("anr_has_ago", String.valueOf(z3));
        jSONObject.put("anr_reason", str9);
        a(map5, jSONObject, "app");
        a(map3, jSONObject, b9.h.l);
        if (map4.isEmpty()) {
            jSONObject.put("npth_anr_systemserver_total", "not found");
        } else {
            jSONObject.put("npth_anr_systemserver_total", b(com.apm.insight.l.c.AnonymousClass1.a(map4).floatValue()));
        }
        if (map7.isEmpty()) {
            jSONObject.put("npth_anr_kswapd_total", "not found");
        } else {
            jSONObject.put("npth_anr_kswapd_total", b(com.apm.insight.l.c.AnonymousClass1.a(map7).floatValue()));
        }
        if (map.isEmpty()) {
            jSONObject.put("npth_anr_dex2oat_total", "not found");
        } else {
            jSONObject.put("npth_anr_dex2oat_total", b(com.apm.insight.l.c.AnonymousClass1.a(map).floatValue()));
        }
    }

    private static void a(HashMap<String, Float> map, JSONObject jSONObject, String str) throws JSONException {
        String strConcat = "npth_anr_".concat(String.valueOf(str));
        if (map.isEmpty()) {
            jSONObject.put(strConcat + "_total", "not found");
            return;
        }
        float fFloatValue = 0.0f;
        float fFloatValue2 = 0.0f;
        float fFloatValue3 = 0.0f;
        float fFloatValue4 = 0.0f;
        float fFloatValue5 = 0.0f;
        for (Map.Entry<String, Float> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.endsWith(POBConstants.KEY_USER)) {
                fFloatValue += entry.getValue().floatValue();
            } else if (key.endsWith("kernel")) {
                fFloatValue2 += entry.getValue().floatValue();
            } else if (key.endsWith("iowait")) {
                fFloatValue3 += entry.getValue().floatValue();
            } else if (key.endsWith("irq")) {
                fFloatValue4 += entry.getValue().floatValue();
            } else if (key.endsWith("softirq")) {
                fFloatValue5 += entry.getValue().floatValue();
            }
        }
        float f = fFloatValue + fFloatValue2 + fFloatValue3 + fFloatValue4 + fFloatValue5;
        jSONObject.put(strConcat + "_total", b(f));
        jSONObject.put(strConcat + "_kernel_user_ratio", a(fFloatValue2, f));
        jSONObject.put(strConcat + "_iowait_user_ratio", a(fFloatValue3, f));
    }

    private static String a(float f, float f2) {
        if (f2 > 0.0f) {
            return a(f / f2);
        }
        return f > 0.0f ? "100%" : "0%";
    }

    private static String a(float f) {
        if (f <= 0.0f) {
            return "0%";
        }
        if (f <= 0.1f) {
            return "0% - 10%";
        }
        if (f <= 0.3f) {
            return "10% - 30%";
        }
        if (f <= 0.6f) {
            return "30% - 60%";
        }
        if (f <= 0.9f) {
            return "60% - 90%";
        }
        return "90% - 100%";
    }

    private static String b(float f) {
        return a(f / 100.0f);
    }

    private static void b(String str, JSONArray jSONArray) {
        for (ICrashCallback iCrashCallback : m.a().e()) {
            try {
                if (iCrashCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iCrashCallback).a(CrashType.ANR, str, (Thread) null, jSONArray);
                } else {
                    iCrashCallback.onCrash(CrashType.ANR, str, null);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                k.a(th, "NPTH_CATCH");
            }
        }
    }

    final boolean g() {
        String str;
        String str2;
        JSONArray jSONArrayB;
        JSONArray jSONArrayA;
        JSONObject jSONObject;
        boolean z2;
        JSONObject jSONObjectA;
        boolean z3;
        String str3;
        String str4;
        JSONArray jSONArray;
        final long j;
        JSONObject jSONObjectA2;
        JSONObject jSONObject2;
        String str5;
        JSONObject jSONObject3;
        boolean zB = com.apm.insight.runtime.j.a().b();
        long jUptimeMillis = SystemClock.uptimeMillis();
        a(jUptimeMillis);
        String strA = d.a(this.b);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str6 = Constants.NORMAL;
        TextUtils.isEmpty(strA);
        if (TextUtils.isEmpty(strA)) {
            str = "unknown";
            str2 = "unknown";
            jSONArrayB = null;
            jSONArrayA = null;
            jSONObject = null;
            z2 = false;
            jSONObjectA = null;
            z3 = false;
            str3 = Constants.NORMAL;
            str4 = "unknown";
            jSONArray = null;
            j = jCurrentTimeMillis;
            jSONObjectA2 = null;
        } else {
            synchronized (this.u) {
            }
            if (this.g != null && System.currentTimeMillis() - this.d <= 20000) {
                str6 = "trace_last";
            } else {
                if (this.v) {
                    this.v = false;
                    str6 = "trace_after";
                }
                b(jUptimeMillis);
            }
            JSONObject jSONObject4 = this.g;
            String str7 = this.i;
            String str8 = this.j;
            String str9 = this.k;
            JSONArray jSONArray2 = this.m;
            JSONArray jSONArray3 = this.r;
            JSONArray jSONArray4 = this.q;
            JSONObject jSONObject5 = this.s;
            JSONObject jSONObject6 = this.h;
            z3 = this.t;
            long j2 = this.p;
            this.g = null;
            this.m = null;
            this.q = null;
            this.h = null;
            this.r = null;
            this.i = "unknown";
            this.j = "unknown";
            this.k = "unknown";
            this.o = 0;
            jSONArrayA = jSONArray4;
            str2 = str9;
            str4 = str7;
            jSONArray = jSONArray2;
            jSONObjectA = jSONObject6;
            jSONObject = jSONObject5;
            jSONArrayB = jSONArray3;
            str = str8;
            str3 = str6;
            j = j2;
            jSONObjectA2 = jSONObject4;
            z2 = true;
        }
        if (TextUtils.isEmpty(strA)) {
            if (this.g != null && System.currentTimeMillis() - this.d > 20000) {
                this.g = null;
                this.m = null;
                this.q = null;
                this.h = null;
                this.r = null;
                this.i = "unknown";
                this.j = "unknown";
                this.k = "unknown";
                this.o = 0;
                this.e = null;
                return false;
            }
            if (this.g == null || System.currentTimeMillis() - this.d <= 2000 || !NativeImpl.h()) {
                return false;
            }
            com.apm.insight.l.f.a(i());
            return false;
        }
        if (jSONObjectA2 == null) {
            if (jSONArrayA == null) {
                try {
                    jSONArrayB = f.b().b();
                    jSONArrayA = j.a(jUptimeMillis);
                    jSONObject3 = jSONObjectA2;
                    try {
                        jSONObjectA = f.b().a(jUptimeMillis).a();
                        JSONObject jSONObject7 = new JSONObject();
                        try {
                            com.apm.insight.l.a.a(this.b, jSONObject7);
                            jSONObject = jSONObject7;
                        } catch (Throwable unused) {
                            jSONObject = jSONObject7;
                            jSONObjectA2 = jSONObject3;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    jSONObject3 = jSONObjectA2;
                }
            } else {
                jSONObject3 = jSONObjectA2;
            }
            jSONObjectA2 = d.a();
        }
        JSONObject jSONObject8 = jSONObjectA;
        if (jSONObjectA2 != null && jSONObjectA2.length() > 0) {
            try {
                jSONObjectA2.put("pid", Process.myPid());
                jSONObjectA2.put("package", this.b.getPackageName());
                jSONObjectA2.put("is_remote_process", 0);
                jSONObjectA2.put("is_new_stack", 10);
                com.apm.insight.entity.a aVar = new com.apm.insight.entity.a(new JSONObject());
                String str10 = str2;
                aVar.a("data", (Object) jSONObjectA2.toString());
                JSONObject jSONObject9 = jSONObjectA2;
                aVar.a("is_anr", (Object) 1);
                aVar.a("anrType", (Object) str3);
                aVar.a("history_message", (Object) jSONArrayB);
                aVar.a("current_message", jSONObject8);
                aVar.a("pending_messages", (Object) jSONArrayA);
                aVar.a("anr_time", Long.valueOf(System.currentTimeMillis()));
                aVar.a("crash_time", Long.valueOf(j));
                com.apm.insight.c.a.b();
                aVar.c(jSONObject);
                aVar.a("anr_info", (Object) strA);
                if (jSONArray != null) {
                    aVar.a("dump_trace", (Object) jSONArray);
                }
                JSONObject jSONObject10 = this.n;
                aVar.a("all_thread_stacks", (jSONObject10 == null || jSONObject10.length() == 0) ? com.apm.insight.l.m.b((String) null) : this.n);
                com.apm.insight.entity.a aVarA = com.apm.insight.runtime.a.f.a().a(CrashType.ANR, aVar);
                aVarA.a("is_background", Boolean.valueOf(z3));
                aVarA.a("logcat", (Object) com.apm.insight.runtime.i.a(com.apm.insight.e.f()));
                aVarA.a("has_dump", (Object) "true");
                aVarA.a("crash_uuid", (Object) com.apm.insight.e.a(j, CrashType.ANR, false, false));
                aVarA.a("jiffy", Long.valueOf(o.a.a()));
                JSONObject jSONObjectOptJSONObject = aVarA.c().optJSONObject("filters");
                com.apm.insight.entity.d.b(aVarA.c());
                if (jSONObjectOptJSONObject == null) {
                    try {
                        jSONObject2 = new JSONObject();
                        try {
                            aVarA.a("filters", jSONObject2);
                        } catch (Throwable unused4) {
                            jSONObjectOptJSONObject = jSONObject2;
                            jSONObject2 = jSONObjectOptJSONObject;
                        }
                    } catch (Throwable unused5) {
                        jSONObject2 = jSONObjectOptJSONObject;
                    }
                } else {
                    jSONObject2 = jSONObjectOptJSONObject;
                }
                jSONObject2.put("anrType", str3);
                jSONObject2.put("max_utm_thread", str4);
                jSONObject2.put("max_stm_thread", str);
                jSONObject2.put("max_utm_stm_thread", str10);
                jSONObject2.put("max_utm_thread_version", this.l);
                long j3 = j - com.apm.insight.e.j();
                if (j3 < 30000) {
                    str5 = "0 - 30s";
                } else if (j3 < 60000) {
                    str5 = "30s - 1min";
                } else if (j3 < UnityAdsConstants.Timeout.INIT_TIMEOUT_MS) {
                    str5 = "1min - 2min";
                } else if (j3 < 300000) {
                    str5 = "2min - 5min";
                } else if (j3 < 600000) {
                    str5 = "5min - 10min";
                } else if (j3 < 1800000) {
                    str5 = "10min - 30min";
                } else if (j3 < 3600000) {
                    str5 = "30min - 1h";
                } else {
                    str5 = "1h - ";
                }
                jSONObject2.put("crash_length", str5);
                jSONObject2.put("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.c()));
                jSONObject2.put("npth_force_apm_crash", String.valueOf(com.apm.insight.c.a.b()));
                jSONObject2.put("sdk_version", "1.3.8.nourl-rc.1");
                jSONObject2.put("has_logcat", String.valueOf(aVarA.a()));
                jSONObject2.put("memory_leak", String.valueOf(com.apm.insight.entity.a.a(com.apm.insight.e.f())));
                jSONObject2.put("fd_leak", String.valueOf(com.apm.insight.entity.a.b(com.apm.insight.e.f())));
                jSONObject2.put("threads_leak", String.valueOf(com.apm.insight.entity.a.c(com.apm.insight.e.f())));
                jSONObject2.put("is_64_devices", String.valueOf(Header.a()));
                jSONObject2.put("is_64_runtime", String.valueOf(NativeImpl.f()));
                jSONObject2.put("is_x86_devices", String.valueOf(Header.b()));
                jSONObject2.put("has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(com.apm.insight.e.f()).exists()));
                jSONObject2.put("is_root", com.apm.insight.nativecrash.a.k() ? "true" : "false");
                jSONObject2.put("anr_normal_trace", String.valueOf(!this.v));
                jSONObject2.put("anr_no_run", String.valueOf(zB));
                jSONObject2.put("crash_after_crash", Npth.hasCrash() ? "true" : "false");
                jSONObject2.put("from_file", String.valueOf(d.b()));
                jSONObject2.put("has_dump", "true");
                jSONObject2.put("from_kill", "false");
                jSONObject2.put("last_resume_activity", com.apm.insight.runtime.a.b.d().h());
                int i = this.o;
                if (i > 0) {
                    jSONObject2.put("may_have_stack_overflow", String.valueOf(i));
                }
                try {
                    a(strA, jSONObject2);
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    k.a(th, "NPTH_CATCH");
                }
                com.apm.insight.a.a.a();
                CrashType crashType = CrashType.ANR;
                com.apm.insight.e.e();
                try {
                    if (com.apm.insight.a.e().length() > 1024) {
                        aVarA.a("has_system_traces", "true");
                    }
                } catch (Throwable unused6) {
                }
                try {
                    JSONArray jSONArrayA2 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.e(com.apm.insight.e.f()), com.apm.insight.l.j.f(com.apm.insight.e.f()));
                    jSONObject2.put("leak_threads_count", String.valueOf(jSONArrayA2.length()));
                    if (jSONArrayA2.length() > 0) {
                        com.apm.insight.l.f.a(com.apm.insight.l.j.g(com.apm.insight.e.f()), jSONArrayA2);
                    }
                } catch (Throwable unused7) {
                }
                String strOptString = jSONObject9.optString("mainStackFromTrace");
                JSONArray jSONArrayA3 = com.apm.insight.entity.b.a(strOptString);
                com.apm.insight.entity.b.a(aVarA.c(), jSONArrayA3, new com.apm.insight.entity.b.a() { // from class: com.apm.insight.b.b.2
                    @Override // com.apm.insight.entity.b.a
                    public final void a(JSONObject jSONObject11) {
                        com.apm.insight.k.d.a().a(jSONObject11, j, b.this.f);
                    }
                });
                b(strOptString, jSONArrayA3);
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                k.a(th2, "NPTH_CATCH");
            }
        }
        return z2;
    }
}
