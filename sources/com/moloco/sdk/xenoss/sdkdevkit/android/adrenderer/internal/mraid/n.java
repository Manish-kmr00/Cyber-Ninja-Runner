package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.net.Uri;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public abstract class n {
    public static final b b = new b(null);
    public static final String c = "close";
    public static final String d = "expand";
    public static final String e = "open";
    public static final String f = "resize";
    public static final String g = "setOrientationProperties";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6650a;

    public static final class a extends n {
        public static final a h = new a();
        public static final int i = 0;

        public a() {
            super("close", null);
        }
    }

    public static final class b {

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f6651a;
            public final String b;

            public a(boolean z, String description) {
                Intrinsics.checkNotNullParameter(description, "description");
                this.f6651a = z;
                this.b = description;
            }

            public final String a() {
                return this.b;
            }

            public final boolean b() {
                return this.f6651a;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return null;
        }

        public final d b(Map<String, String> map) {
            Object objM7904constructorimpl;
            String str = map.get("url");
            if (str == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Uri uri = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(uri, "parse(rawOpenUrl)");
                objM7904constructorimpl = Result.m7904constructorimpl(new d(uri));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            return (d) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
        }

        public final f c(Map<String, String> map) {
            Boolean booleanStrictOrNull;
            String str = map.get("allowOrientationChange");
            if (str == null || (booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(str)) == null) {
                return null;
            }
            boolean zBooleanValue = booleanStrictOrNull.booleanValue();
            p pVarA = p.f6652a.a(map.get("forceOrientation"));
            if (pVarA == null) {
                return null;
            }
            return new f(zBooleanValue, pVarA);
        }

        public b() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final com.moloco.sdk.internal.v<n, a> a(String str) {
            Object objM7904constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(Uri.parse(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            Object objA = null;
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                objM7904constructorimpl = null;
            }
            Uri uri = (Uri) objM7904constructorimpl;
            if (uri == null) {
                return new com.moloco.sdk.internal.v.a(new a(false, "Invalid url: " + str));
            }
            if (!Intrinsics.areEqual(uri.getScheme(), "mraid")) {
                return new com.moloco.sdk.internal.v.a(new a(false, "Non-mraid url scheme: " + str));
            }
            Map<String, String> mapA = a(uri);
            String host = uri.getHost();
            if (host != null) {
                switch (host.hashCode()) {
                    case -1289167206:
                        if (host.equals("expand")) {
                            objA = a(mapA);
                        }
                        break;
                    case -934437708:
                        if (host.equals("resize")) {
                            objA = a();
                        }
                        break;
                    case 3417674:
                        if (host.equals("open")) {
                            objA = b(mapA);
                        }
                        break;
                    case 94756344:
                        if (host.equals("close")) {
                            objA = a.h;
                        }
                        break;
                    case 133423073:
                        if (host.equals("setOrientationProperties")) {
                            objA = c(mapA);
                        }
                        break;
                }
            }
            return objA != null ? new com.moloco.sdk.internal.v.b(objA) : new com.moloco.sdk.internal.v.a(new a(true, "Unknown/unsupported mraid command " + uri.getHost()));
        }

        public final c a(Map<String, String> map) {
            Object objM7904constructorimpl;
            String str = map.get("url");
            Uri uri = null;
            if (str != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(Uri.parse(str));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
                }
                uri = (Uri) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
            }
            return new c(uri);
        }

        public final Map<String, String> a(Uri uri) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String queryParam : uri.getQueryParameterNames()) {
                Intrinsics.checkNotNullExpressionValue(queryParam, "queryParam");
                String strJoin = TextUtils.join(StringUtils.COMMA, uri.getQueryParameters(queryParam));
                Intrinsics.checkNotNullExpressionValue(strJoin, "join(\",\", getQueryParameters(queryParam))");
                linkedHashMap.put(queryParam, strJoin);
            }
            return linkedHashMap;
        }
    }

    public static final class c extends n {
        public static final int i = 8;
        public final Uri h;

        public c(Uri uri) {
            super("expand", null);
            this.h = uri;
        }

        public final Uri b() {
            return this.h;
        }
    }

    public static final class d extends n {
        public static final int i = 8;
        public final Uri h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Uri uri) {
            super("open", null);
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.h = uri;
        }

        public final Uri b() {
            return this.h;
        }
    }

    public static final class e extends n {
        public static final int m = 0;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final boolean l;

        public e(int i, int i2, int i3, int i4, boolean z) {
            super("resize", null);
            this.h = i;
            this.i = i2;
            this.j = i3;
            this.k = i4;
            this.l = z;
        }

        public final boolean b() {
            return this.l;
        }

        public final int c() {
            return this.i;
        }

        public final int d() {
            return this.j;
        }

        public final int e() {
            return this.k;
        }

        public final int f() {
            return this.h;
        }
    }

    public static final class f extends n {
        public static final int j = 0;
        public final boolean h;
        public final p i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z, p forceOrientation) {
            super("setOrientationProperties", null);
            Intrinsics.checkNotNullParameter(forceOrientation, "forceOrientation");
            this.h = z;
            this.i = forceOrientation;
        }

        public final boolean b() {
            return this.h;
        }

        public final p c() {
            return this.i;
        }
    }

    public /* synthetic */ n(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String a() {
        return this.f6650a;
    }

    public n(String str) {
        this.f6650a = str;
    }
}
