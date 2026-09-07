package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.inmobi.sdk.InMobiSdk;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class cb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z7 f8585a;
    private final s50 b;
    private final Sequence<Map.Entry<String, Object>> c;
    private final Sequence<Map.Entry<String, Object>> d;
    private final Lazy e;

    public static final class a {
        private Integer A;
        private String A0;
        private Integer B;
        private String B0;
        private Float C;
        private Boolean C0;
        private Integer D;
        private String D0;
        private Integer E;
        private String E0;
        private String F;
        private String F0;
        private String G;
        private String G0;
        private v7 H;
        private String H0;
        private Integer I;
        private String I0;
        private Integer J;
        private Boolean J0;
        private String K;
        private Boolean K0;
        private Boolean L;
        private Boolean L0;
        private Boolean M;
        private String N;
        private Boolean O;
        private String P;
        private Integer Q;
        private Boolean R;
        private String S;
        private String T;
        private String U;
        private String V;
        private String W;
        private Long X;
        private String Y;
        private String Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8586a;
        private String a0;
        private String b0;
        private String c0;
        private String d0;
        private String e0;
        private boolean f;
        private String f0;
        private String g0;
        private String h0;
        private Boolean i;
        private String i0;
        private Boolean j;
        private String j0;
        private String k;
        private String k0;
        private Integer l;
        private String l0;
        private boolean m;
        private String m0;
        private String n;
        private String n0;
        private String o;
        private String o0;
        private String p;
        private int p0;
        private String q;
        private float q0;
        private String r;
        private float r0;
        private String s;
        private float s0;
        private String t;
        private float t0;
        private String u;
        private String u0;
        private Integer v;
        private String v0;
        private Integer w;
        private String w0;
        private String x;
        private String x0;
        private String y;
        private String y0;
        private Location z;
        private String z0;
        private final g10 b = new g10(0);
        private final tf c = new tf();
        private final pw1 d = new pw1();
        private final kc e = new kc();
        private final HashMap g = new HashMap();
        private final HashMap h = new HashMap();

        public final a J0() {
            this.Y = "UTF-8";
            return this;
        }

        public final a K0() {
            this.Z = null;
            return this;
        }

        public final a N0() {
            this.a0 = null;
            return this;
        }

        public final HashMap b0() {
            return this.h;
        }

        public final HashMap f() {
            return this.g;
        }

        public final a f(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            gq.f9028a.getClass();
            this.o = ((iq) gq.a.a(context)).b();
            return this;
        }

        public a(boolean z) {
            this.f8586a = z;
        }

        public final boolean G() {
            return this.f;
        }

        public final Boolean x0() {
            return this.i;
        }

        public final Boolean i() {
            return this.j;
        }

        public final a i(Context context) {
            Integer intOrNull;
            Integer intOrNull2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(context, "context");
            String str = null;
            try {
                Object systemService = context.getSystemService("phone");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                String networkOperator = ((TelephonyManager) systemService).getNetworkOperator();
                Intrinsics.checkNotNullExpressionValue(networkOperator, "getNetworkOperator(...)");
                String strSubstring = networkOperator.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                intOrNull = StringsKt.toIntOrNull(strSubstring);
            } catch (Exception unused) {
                intOrNull = null;
            }
            this.D = intOrNull;
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Object systemService2 = context.getSystemService("phone");
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                String networkOperator2 = ((TelephonyManager) systemService2).getNetworkOperator();
                Intrinsics.checkNotNullExpressionValue(networkOperator2, "getNetworkOperator(...)");
                String strSubstring2 = networkOperator2.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                intOrNull2 = StringsKt.toIntOrNull(strSubstring2);
            } catch (Exception unused2) {
                intOrNull2 = null;
            }
            this.E = intOrNull2;
            this.F = eh1.a(context);
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Object systemService3 = context.getSystemService("phone");
                Intrinsics.checkNotNull(systemService3, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                String networkOperatorName = ((TelephonyManager) systemService3).getNetworkOperatorName();
                if (networkOperatorName.length() != 0) {
                    str = networkOperatorName;
                }
            } catch (Exception unused3) {
            }
            this.G = str;
            return this;
        }

        public final String R() {
            return this.k;
        }

        public final Integer g() {
            return this.l;
        }

        public final a g(Context context) {
            Integer numValueOf;
            Integer numValueOf2;
            String str;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(context, "context");
            String string = null;
            try {
                Object systemService = context.getSystemService("phone");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                CellLocation cellLocation = ((TelephonyManager) systemService).getCellLocation();
                Intrinsics.checkNotNull(cellLocation, "null cannot be cast to non-null type android.telephony.gsm.GsmCellLocation");
                int cid = ((GsmCellLocation) cellLocation).getCid();
                numValueOf = -1 != cid ? Integer.valueOf(cid & 65535) : null;
            } catch (Exception unused) {
            }
            this.I = numValueOf;
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Object systemService2 = context.getSystemService("phone");
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                CellLocation cellLocation2 = ((TelephonyManager) systemService2).getCellLocation();
                Intrinsics.checkNotNull(cellLocation2, "null cannot be cast to non-null type android.telephony.gsm.GsmCellLocation");
                int lac = ((GsmCellLocation) cellLocation2).getLac();
                numValueOf2 = -1 != lac ? Integer.valueOf(lac & 65535) : null;
            } catch (Exception unused2) {
            }
            this.J = numValueOf2;
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Object systemService3 = context.getApplicationContext().getSystemService(com.json.x8.b);
                Intrinsics.checkNotNull(systemService3, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                WifiManager wifiManager = (WifiManager) systemService3;
                if (wifiManager.isWifiEnabled()) {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    if (scanResults == null) {
                        scanResults = CollectionsKt.emptyList();
                    }
                    List listSortedWith = CollectionsKt.sortedWith(scanResults, new dh1());
                    if (!listSortedWith.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        int iMin = Math.min(3, listSortedWith.size());
                        int i = 0;
                        while (i < iMin) {
                            sb.append(((ScanResult) listSortedWith.get(i)).BSSID);
                            sb.append(StringUtils.COMMA);
                            sb.append(((ScanResult) listSortedWith.get(i)).level);
                            i++;
                            if (i < iMin) {
                                str = ";";
                            } else {
                                str = "";
                            }
                            sb.append(str);
                        }
                        string = sb.toString();
                    }
                }
            } catch (Exception unused3) {
            }
            this.K = string;
            return this;
        }

        public final boolean s() {
            return this.m;
        }

        public final String A() {
            return this.n;
        }

        public final String B() {
            return this.o;
        }

        public final String e0() {
            return this.p;
        }

        public final String A0() {
            return this.q;
        }

        public final String e() {
            return this.r;
        }

        public final a e(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            gq.f9028a.getClass();
            this.n = ((iq) gq.a.a(context)).a();
            return this;
        }

        public final String z0() {
            return this.s;
        }

        public final String d() {
            return this.t;
        }

        public final a d(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.A0 = (new mv(context).a() ? gq1.d : gq1.c).a();
            return this;
        }

        public final String c() {
            return this.u;
        }

        public final a c(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            gq.f9028a.getClass();
            this.m = ((iq) gq.a.a(context)).e();
            return this;
        }

        public final Integer E0() {
            return this.v;
        }

        public final Integer I() {
            return this.w;
        }

        public final String b() {
            return this.x;
        }

        public final a b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(context, "context");
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            this.l0 = packageName;
            this.m0 = te.a(context);
            this.n0 = te.b(context);
            return this;
        }

        public final String Y() {
            return this.y;
        }

        public final Location P() {
            return this.z;
        }

        public final Integer n0() {
            return this.A;
        }

        public final Integer m0() {
            return this.B;
        }

        public final Float k0() {
            return this.C;
        }

        public final Integer S() {
            return this.D;
        }

        public final Integer T() {
            return this.E;
        }

        public final String V() {
            return this.F;
        }

        public final String p() {
            return this.G;
        }

        public final v7 a() {
            return this.H;
        }

        public final Integer q() {
            return this.I;
        }

        public final Integer N() {
            return this.J;
        }

        public final String F0() {
            return this.K;
        }

        public final Boolean F() {
            return this.L;
        }

        public final Boolean z() {
            return this.M;
        }

        public final String E() {
            return this.N;
        }

        public final Boolean K() {
            return this.O;
        }

        public final String J() {
            return this.P;
        }

        public final Integer o() {
            return this.Q;
        }

        public final a o(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.C0 = Boolean.valueOf(oa.a(context));
            return this;
        }

        public final Boolean G0() {
            return this.R;
        }

        public final String t() {
            return this.S;
        }

        public final String u() {
            return this.T;
        }

        public final String L() {
            return this.U;
        }

        public final String f0() {
            return this.V;
        }

        public final String t0() {
            return this.W;
        }

        public final Long s0() {
            return this.X;
        }

        public final String r() {
            return this.Y;
        }

        public final String v() {
            return this.Z;
        }

        public final String y0() {
            return this.a0;
        }

        public final String W() {
            return this.b0;
        }

        public final String n() {
            return this.c0;
        }

        public final a n(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            gq.f9028a.getClass();
            this.q = ((iq) gq.a.a(context)).f();
            return this;
        }

        public final String H() {
            return this.d0;
        }

        public final String d0() {
            return this.e0;
        }

        public final String y() {
            return this.f0;
        }

        public final String Z() {
            return this.g0;
        }

        public final String a0() {
            return this.h0;
        }

        public final String Q() {
            return this.i0;
        }

        public final String U() {
            return this.j0;
        }

        public final String O() {
            return this.k0;
        }

        public final String j() {
            return this.l0;
        }

        public final a j(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            gq.f9028a.getClass();
            this.p = ((iq) gq.a.a(context)).c();
            return this;
        }

        public final String l() {
            return this.m0;
        }

        public final a l(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.A = Integer.valueOf(oh2.c(context));
            this.B = Integer.valueOf(oh2.b(context));
            this.C = Float.valueOf(bb0.a(context, "context").density);
            this.p0 = oh2.a(context);
            return this;
        }

        public final String m() {
            return this.n0;
        }

        public final a m(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int i = iw1.l;
            cu1 cu1VarA = iw1.a.a().a(context);
            if (cu1VarA != null) {
                this.D0 = cu1VarA.O();
            }
            return this;
        }

        public final String w() {
            return this.o0;
        }

        public final int l0() {
            return this.p0;
        }

        public final float h0() {
            return this.q0;
        }

        public final float j0() {
            return this.r0;
        }

        public final float i0() {
            return this.s0;
        }

        public final float g0() {
            return this.t0;
        }

        public final String h() {
            return this.u0;
        }

        public final a h(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int i = ts0.h;
            this.z = this.f8586a ? null : ts0.a.a(context).c();
            return this;
        }

        public final String C() {
            return this.v0;
        }

        public final String o0() {
            return this.w0;
        }

        public final String p0() {
            return this.x0;
        }

        public final String k() {
            return this.y0;
        }

        public final a k(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            q10 q10VarA = ak2.a(context);
            this.q0 = q10VarA.c();
            this.r0 = q10VarA.e();
            this.s0 = q10VarA.d();
            this.t0 = q10VarA.b();
            return this;
        }

        public final String c0() {
            return this.z0;
        }

        public final String x() {
            return this.A0;
        }

        public final String B0() {
            return this.B0;
        }

        public final Boolean D0() {
            return this.C0;
        }

        public final String u0() {
            return this.D0;
        }

        public final String w0() {
            return this.E0;
        }

        public final String r0() {
            return this.F0;
        }

        public final String q0() {
            return this.G0;
        }

        public final String M() {
            return this.H0;
        }

        public final String v0() {
            return this.I0;
        }

        public final Boolean D() {
            return this.J0;
        }

        public final Boolean X() {
            return this.K0;
        }

        public final Boolean C0() {
            return this.L0;
        }

        public final a I0() {
            this.y0 = this.c.a();
            return this;
        }

        public final a L0() {
            this.w0 = this.d.a();
            this.x0 = this.d.b();
            return this;
        }

        public final a M0() {
            int i = iw1.l;
            this.i = iw1.a.a().j();
            return this;
        }

        public final a H0() {
            int i = iw1.l;
            this.j = iw1.a.a().f();
            return this;
        }

        public final a a(v7 v7Var) {
            String strDecode;
            if (v7Var != null) {
                String strDecode2 = null;
                this.H = this.f8586a ? null : v7Var;
                String strC = v7Var.c();
                if (strC == null || strC.length() == 0) {
                    strDecode = null;
                } else {
                    String strEncode = Uri.encode(strC);
                    if (strEncode != null && strEncode.length() > 1024) {
                        int i = wm1.b;
                        wm1.a("Exceeded the length of the parameter! The maximum size of the parameter is %s bytes. First %s bytes of the parameter will be used", 1024, 1024);
                        String strEncode2 = Uri.encode(" ");
                        String strSubstring = strEncode.substring(0, 1024);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        Intrinsics.checkNotNull(strEncode2);
                        boolean zStartsWith$default = StringsKt.startsWith$default(strEncode, strEncode2, 1024, false, 4, (Object) null);
                        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) strSubstring, strEncode2, 0, false, 6, (Object) null);
                        if (zStartsWith$default || iLastIndexOf$default < 0) {
                            strEncode = strSubstring;
                        } else {
                            strEncode = strSubstring.substring(0, iLastIndexOf$default);
                            Intrinsics.checkNotNullExpressionValue(strEncode, "substring(...)");
                        }
                    }
                    strDecode = Uri.decode(strEncode);
                }
                this.S = strDecode;
                List<String> listD = v7Var.d();
                String string = "";
                if (listD != null) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : listD) {
                        sb.append(string);
                        sb.append(str);
                        sb.append("\n");
                        string = "3";
                    }
                    string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                }
                if (string.length() != 0) {
                    String strEncode3 = Uri.encode(string);
                    if (strEncode3 != null && strEncode3.length() > 2048) {
                        int i2 = wm1.b;
                        wm1.a("Exceeded the length of the parameter! The maximum size of the parameter is %s bytes. First %s bytes of the parameter will be used", 2048, 2048);
                        String strEncode4 = Uri.encode("\n");
                        strEncode3 = strEncode3.substring(0, 2048);
                        Intrinsics.checkNotNullExpressionValue(strEncode3, "substring(...)");
                        Intrinsics.checkNotNull(strEncode4);
                        int iLastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence) strEncode3, strEncode4, 0, false, 6, (Object) null);
                        if (!StringsKt.endsWith$default(strEncode3, strEncode4, false, 2, (Object) null) && iLastIndexOf$default2 >= 0) {
                            strEncode3 = strEncode3.substring(0, iLastIndexOf$default2);
                            Intrinsics.checkNotNullExpressionValue(strEncode3, "substring(...)");
                        }
                    }
                    strDecode2 = Uri.decode(strEncode3);
                }
                this.T = strDecode2;
                this.u0 = b8.a(v7Var.b());
                this.v0 = b8.a(v7Var.e());
                this.b0 = v7Var.g();
                gq1 gq1VarI = v7Var.i();
                if (gq1VarI != null) {
                    this.z0 = b8.a(gq1VarI.a());
                }
                a(b8.a(v7Var.h()));
            }
            return this;
        }

        public final a b(String str) {
            this.c0 = str;
            return this;
        }

        public final a i(String str) {
            this.E0 = str;
            return this;
        }

        public final a a(qs qsVar) {
            if (qsVar != null) {
                this.u = qsVar.a();
            }
            return this;
        }

        public final a f(String str) {
            this.e0 = str;
            return this;
        }

        public final a e(String str) {
            this.k = str;
            return this;
        }

        public final a b(Integer num) {
            this.Q = num;
            return this;
        }

        public final a j(String str) {
            this.s = str;
            return this;
        }

        public final a c(String str) {
            this.d0 = str;
            return this;
        }

        public final a g(String str) {
            this.G0 = str;
            return this;
        }

        public final a h(String str) {
            this.F0 = str;
            return this;
        }

        public final a a(String str) {
            this.t = str;
            return this;
        }

        public final a a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            gq.f9028a.getClass();
            this.r = ((iq) gq.a.a(context)).d();
            return this;
        }

        public final a d(String str) {
            this.H0 = str;
            return this;
        }

        public final a b(boolean z) {
            this.K0 = z ? Boolean.valueOf(z) : null;
            return this;
        }

        public final a b(Map<String, String> map) {
            if (map != null) {
                this.h.putAll(map);
            }
            return this;
        }

        public final a a(Map<String, String> map) {
            if (map != null) {
                this.g.putAll(map);
            }
            return this;
        }

        public final a a(Integer num) {
            this.l = num;
            return this;
        }

        public final a a(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f0 = this.b.a(context);
            this.b.getClass();
            this.g0 = "android";
            this.b.getClass();
            this.h0 = Build.VERSION.RELEASE;
            this.b.getClass();
            this.i0 = g10.a();
            this.b.getClass();
            this.j0 = Build.MODEL;
            this.k0 = this.b.b(context);
            if (this.f8586a) {
                str = null;
            }
            this.o0 = str;
            this.R = Boolean.valueOf(this.b.c());
            return this;
        }

        public final a a(lc lcVar, boolean z) {
            if (lcVar != null) {
                this.L = Boolean.valueOf(lcVar.b());
                this.M = Boolean.valueOf(z);
                String strA = lcVar.a();
                this.e.getClass();
                boolean z2 = (strA == null || strA.length() == 0 || Intrinsics.areEqual("00000000-0000-0000-0000-000000000000", strA)) ? false : true;
                if (!this.f8586a && Intrinsics.areEqual(this.L, Boolean.FALSE) && z2) {
                    this.N = strA;
                }
            }
            return this;
        }

        public final a a(l50 environmentConfiguration) {
            Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
            this.J0 = Boolean.valueOf(environmentConfiguration.c());
            return this;
        }

        public final a a(boolean z) {
            this.f = z;
            return this;
        }

        public final a a(lc lcVar) {
            if (lcVar != null) {
                this.O = Boolean.valueOf(lcVar.b());
                String strA = lcVar.a();
                this.e.getClass();
                boolean z = (strA == null || strA.length() == 0 || Intrinsics.areEqual("00000000-0000-0000-0000-000000000000", strA)) ? false : true;
                if (!this.f8586a && Intrinsics.areEqual(this.O, Boolean.FALSE) && z) {
                    this.P = strA;
                }
            }
            return this;
        }

        public final a a(List<String> list) {
            this.U = list != null ? CollectionsKt.joinToString$default(list, StringUtils.COMMA, null, null, 0, null, null, 62, null) : null;
            return this;
        }

        public final a a(int i) {
            String str;
            if (1 == i) {
                str = "portrait";
            } else {
                str = "landscape";
            }
            this.y = str;
            return this;
        }

        public final a a(y91 y91Var) {
            if (y91Var != null) {
                this.V = y91Var.a();
            }
            return this;
        }

        public final a a(long j) {
            this.X = Long.valueOf(j);
            return this;
        }

        public final a a(Context context, zy1 zy1Var) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (zy1Var != null) {
                this.x = zy1Var.a().a();
                this.v = Integer.valueOf(zy1Var.c(context));
                this.w = Integer.valueOf(zy1Var.a(context));
            }
            return this;
        }

        public final a a(ba1 ba1Var) {
            if (ba1Var != null && ba1.d == ba1Var) {
                this.W = ba1Var.a();
            }
            return this;
        }

        public final a a(au1 au1Var) {
            this.I0 = au1Var != null ? au1Var.a() : null;
            return this;
        }

        public final a a(Context context, o3 adConfiguration) {
            String strA;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
            String strC = adConfiguration.c();
            int iO = adConfiguration.o();
            if (strC != null && (strA = new ih2(context).a(new kh2(iO, strC))) != null) {
                this.B0 = strA;
            }
            return this;
        }

        public final a a(Boolean bool) {
            this.L0 = bool;
            return this;
        }
    }

    static final class c extends Lambda implements Function0<String> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return SequencesKt.joinToString$default(SequencesKt.plus(cb0.this.c, cb0.this.d), com.ironsource.b9.i.c, null, null, 0, null, db0.b, 30, null);
        }
    }

    public final String toString() {
        return (String) this.e.getValue();
    }

    private cb0(a aVar) {
        z7 z7Var = new z7();
        this.f8585a = z7Var;
        this.b = new s50();
        Map<String, Object> mapCreateMapBuilder = MapsKt.createMapBuilder();
        a(mapCreateMapBuilder, "ad_unit_id", aVar.d());
        a(mapCreateMapBuilder, "width", aVar.E0());
        a(mapCreateMapBuilder, "height", aVar.I());
        a(mapCreateMapBuilder, "ad_size_type", aVar.b());
        a(mapCreateMapBuilder, "orientation", aVar.Y());
        a(mapCreateMapBuilder, "ads_count", aVar.g());
        a(mapCreateMapBuilder, CommonUrlParts.SCREEN_WIDTH, aVar.n0());
        a(mapCreateMapBuilder, CommonUrlParts.SCREEN_HEIGHT, aVar.m0());
        a(mapCreateMapBuilder, CommonUrlParts.SCALE_FACTOR, aVar.k0());
        a(mapCreateMapBuilder, "ad_type", aVar.c());
        a(mapCreateMapBuilder, "network_type", aVar.V());
        a(mapCreateMapBuilder, "carrier", aVar.p());
        a(mapCreateMapBuilder, "dnt", aVar.F());
        a(mapCreateMapBuilder, "gaid_reset", aVar.z());
        a(mapCreateMapBuilder, "huawei_dnt", aVar.K());
        a(mapCreateMapBuilder, "battery_charge", aVar.o());
        a(mapCreateMapBuilder, "image_sizes", aVar.L());
        a(mapCreateMapBuilder, "response_ad_format", aVar.f0());
        a(mapCreateMapBuilder, FirebaseAnalytics.Param.AD_SOURCE, aVar.t0());
        a(mapCreateMapBuilder, "debug_uid", aVar.v());
        a(mapCreateMapBuilder, "user_id", aVar.y0());
        a(mapCreateMapBuilder, "open_bidding_data", aVar.W());
        a(mapCreateMapBuilder, "session_random", aVar.s0());
        a(mapCreateMapBuilder, "charset", aVar.r());
        a(mapCreateMapBuilder, z7Var.b(), aVar.y());
        a(mapCreateMapBuilder, z7Var.f(), aVar.Z());
        a(mapCreateMapBuilder, z7Var.g(), aVar.a0());
        a(mapCreateMapBuilder, z7Var.d(), aVar.Q());
        a(mapCreateMapBuilder, z7Var.e(), aVar.U());
        a(mapCreateMapBuilder, z7Var.c(), aVar.G0());
        a(mapCreateMapBuilder, CommonUrlParts.LOCALE, aVar.O());
        a(mapCreateMapBuilder, "app_id", aVar.j());
        a(mapCreateMapBuilder, "app_version_code", aVar.l());
        a(mapCreateMapBuilder, CommonUrlParts.APP_VERSION, aVar.m());
        a(mapCreateMapBuilder, "appmetrica_version", aVar.k());
        a(mapCreateMapBuilder, CommonUrlParts.SCREEN_DPI, Integer.valueOf(aVar.l0()));
        a(mapCreateMapBuilder, "safe_area_inset_left", Float.valueOf(aVar.h0()));
        a(mapCreateMapBuilder, "safe_area_inset_top", Float.valueOf(aVar.j0()));
        a(mapCreateMapBuilder, "safe_area_inset_right", Float.valueOf(aVar.i0()));
        a(mapCreateMapBuilder, "safe_area_inset_bottom", Float.valueOf(aVar.g0()));
        a(mapCreateMapBuilder, "user_consent", aVar.x0());
        a(mapCreateMapBuilder, "gdpr", aVar.A());
        a(mapCreateMapBuilder, InMobiSdk.IM_GDPR_CONSENT_IAB, aVar.B());
        a(mapCreateMapBuilder, "cmp_present", Boolean.valueOf(aVar.s()));
        a(mapCreateMapBuilder, "parsed_purpose_consents", aVar.e0());
        a(mapCreateMapBuilder, "parsed_vendor_consents", aVar.A0());
        a(mapCreateMapBuilder, "addtl_consent", aVar.e());
        a(mapCreateMapBuilder, "bidding_data", aVar.H());
        a(mapCreateMapBuilder, "prefetched_mediation_data", aVar.d0());
        a(mapCreateMapBuilder, "sdk_version", aVar.o0());
        a(mapCreateMapBuilder, "sdk_version_name", aVar.p0());
        a(mapCreateMapBuilder, "sdk_vendor", "yandex");
        a(mapCreateMapBuilder, "preferred_theme", aVar.c0());
        a(mapCreateMapBuilder, "device_theme", aVar.x());
        a(mapCreateMapBuilder, "age_restricted_user", aVar.i());
        a(mapCreateMapBuilder, "view_size_info", aVar.B0());
        a(mapCreateMapBuilder, "web_view_available", aVar.D0());
        a(mapCreateMapBuilder, "startup_version", aVar.u0());
        a(mapCreateMapBuilder, "session-data", aVar.r0());
        a(mapCreateMapBuilder, "user-agent", aVar.w0());
        a(mapCreateMapBuilder, "server_side_client_ip", aVar.q0());
        a(mapCreateMapBuilder, "ipv6", aVar.M());
        a(mapCreateMapBuilder, "stub_reason", aVar.v0());
        a(mapCreateMapBuilder, "gms_available", aVar.D());
        a(mapCreateMapBuilder, "opt_out", aVar.X());
        a(mapCreateMapBuilder, "vpn_enabled", aVar.C0());
        a(mapCreateMapBuilder, aVar.b0());
        a(mapCreateMapBuilder, aVar);
        this.c = MapsKt.asSequence(MapsKt.build(mapCreateMapBuilder));
        Map<String, Object> mapCreateMapBuilder2 = MapsKt.createMapBuilder();
        for (Map.Entry entry : aVar.f().entrySet()) {
            a(mapCreateMapBuilder2, (String) entry.getKey(), entry.getValue());
        }
        this.d = MapsKt.asSequence(MapsKt.build(mapCreateMapBuilder2));
        this.e = LazyKt.lazy(new c());
    }

    private final void a(Map<String, Object> map, a aVar) {
        if (aVar.G()) {
            return;
        }
        a(map, "age", aVar.h());
        a(map, "gender", aVar.C());
        a(map, "context_query", aVar.t());
        a(map, "context_taglist", aVar.u());
        a(map, "google_aid", aVar.E());
        a(map, "huawei_oaid", aVar.J());
        a(map, CommonUrlParts.UUID, aVar.z0());
        a(map, "mauid", aVar.R());
        a(map, "autograb", aVar.n());
        a(map, this.f8585a.a(), aVar.w());
        a(map, "mcc", aVar.S());
        a(map, "mnc", aVar.T());
        a(map, "cellid", aVar.q());
        a(map, "lac", aVar.N());
        a(map, com.json.x8.b, aVar.F0());
        v7 v7VarA = aVar.a();
        Location locationF = v7VarA != null ? v7VarA.f() : null;
        if (locationF != null) {
            int i = iw1.l;
            if (iw1.a.a().d()) {
                a(map, "lat", String.valueOf(locationF.getLatitude()));
                a(map, POBConstants.KEY_LONGITUDE, String.valueOf(locationF.getLongitude()));
                a(map, "location_timestamp", String.valueOf(locationF.getTime()));
                a(map, "precision", String.valueOf((int) locationF.getAccuracy()));
                return;
            }
            return;
        }
        Location locationP = aVar.P();
        if (locationP != null) {
            int i2 = iw1.l;
            if (iw1.a.a().d()) {
                a(map, "lat", String.valueOf(locationP.getLatitude()));
                a(map, POBConstants.KEY_LONGITUDE, String.valueOf(locationP.getLongitude()));
                a(map, "location_timestamp", String.valueOf(locationP.getTime()));
                a(map, "precision", String.valueOf((int) locationP.getAccuracy()));
            }
        }
    }

    private final void a(Map map, HashMap map2) {
        for (Map.Entry entry : map2.entrySet()) {
            a((Map<String, Object>) map, (String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static final class b {
        @JvmStatic
        public static a a(Context context, dx1 sensitiveModeChecker, sq configuration, nq1 resourceUtils, cf1 optOutRepository) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(resourceUtils, "resourceUtils");
            Intrinsics.checkNotNullParameter(optOutRepository, "optOutRepository");
            l50 l50VarB = configuration.b();
            jc jcVarA = configuration.a();
            a aVarA = new a(sensitiveModeChecker.b(context)).b(context).I0().a(jcVarA.a(), jcVarA.b()).a(jcVarA.c());
            Intrinsics.checkNotNullParameter(context, "context");
            Integer numValueOf = null;
            try {
                Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver != null) {
                    int intExtra = intentRegisterReceiver.getIntExtra("level", -1);
                    int intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
                    if (intExtra > -1 && intExtra2 > 0) {
                        numValueOf = Integer.valueOf(MathKt.roundToInt((intExtra / intExtra2) * 100));
                    }
                }
            } catch (Exception unused) {
                op0.c(new Object[0]);
            }
            a aVarA2 = aVarA.b(numValueOf).J0().g(context).h(context).i(context).l(context).k(context).L0().a(dx1.a(context)).a(oa.a());
            l50VarB.getClass();
            a aVarM0 = aVarA2.K0().a(context, l50VarB.b()).j(l50VarB.g()).e(l50VarB.e()).a(configuration.c()).d(context).M0();
            resourceUtils.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            return aVarM0.a(context.getResources().getConfiguration().orientation).H0().e(context).f(context).c(context).j(context).n(context).a(context).o(context).m(context).a(l50VarB).b(optOutRepository.a()).a(eh1.c(context));
        }

        public static a a(Context context, o3 adConfiguration, dx1 sensitiveModeChecker) {
            nq1 resourceUtils = new nq1();
            cf1 optOutRepository = new cf1(context, ns0.a(context));
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
            Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
            Intrinsics.checkNotNullParameter(resourceUtils, "resourceUtils");
            Intrinsics.checkNotNullParameter(optOutRepository, "optOutRepository");
            return a(context, sensitiveModeChecker, adConfiguration.g(), resourceUtils, optOutRepository).a(adConfiguration.a()).a(adConfiguration.b()).a(adConfiguration.d()).a(adConfiguration.c()).a(adConfiguration.p()).a(context, adConfiguration.r()).a(adConfiguration.s()).N0().b(adConfiguration.f()).c(adConfiguration.l()).f(adConfiguration.n()).a(adConfiguration.o()).a(context, adConfiguration);
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    private final void a(Map<String, Object> map, String str, Boolean bool) {
        if (bool != null) {
            a(map, str, Integer.valueOf(bool.booleanValue() ? 1 : 0));
        }
    }

    private final void a(Map<String, Object> map, String str, Object obj) {
        String strEncode;
        if (obj != null) {
            String strEncode2 = Uri.encode(str);
            if (this.b.a(str)) {
                strEncode = Uri.encode(obj.toString());
            } else {
                strEncode = Uri.encode(obj.toString(), ":");
            }
            Intrinsics.checkNotNull(strEncode2);
            Intrinsics.checkNotNull(strEncode);
            map.put(strEncode2, strEncode);
        }
    }

    public /* synthetic */ cb0(a aVar, int i) {
        this(aVar);
    }
}
