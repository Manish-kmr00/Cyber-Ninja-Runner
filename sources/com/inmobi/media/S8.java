package com.inmobi.media;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class S8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3193a;
    public final String b;
    public final C3545rc c;
    public boolean d;
    public final L4 e;
    public final String f;
    public final boolean g;
    public final String h;
    public final HashMap i;
    public final HashMap j;
    public final HashMap k;
    public JSONObject l;
    public String m;
    public T8 n;
    public boolean o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public Oa w;
    public boolean x;

    public S8(String requestType, String str, C3545rc c3545rc, boolean z, L4 l4, String requestContentType, boolean z2) {
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        Intrinsics.checkNotNullParameter(requestContentType, "requestContentType");
        this.f3193a = requestType;
        this.b = str;
        this.c = c3545rc;
        this.d = z;
        this.e = l4;
        this.f = requestContentType;
        this.g = z2;
        this.h = "S8";
        this.i = new HashMap();
        this.m = C3517pb.b();
        this.p = 60000;
        this.q = 60000;
        this.r = true;
        this.t = true;
        this.u = true;
        this.v = true;
        this.x = true;
        if (Intrinsics.areEqual("GET", requestType)) {
            this.j = new HashMap();
        } else if (Intrinsics.areEqual("POST", requestType)) {
            this.k = new HashMap();
            this.l = new JSONObject();
        }
    }

    public final void a(Function1 onResponse) {
        Intrinsics.checkNotNullParameter(onResponse, "onResponse");
        L4 l4 = this.e;
        if (l4 != null) {
            String str = this.h;
            ((M4) l4).a(str, O5.a(str, "TAG", "executeAsync: ").append(this.b).toString());
        }
        e();
        if (!this.d) {
            L4 l5 = this.e;
            if (l5 != null) {
                String TAG = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l5).c(TAG, "Dropping REQUEST FOR GDPR");
            }
            T8 t8 = new T8();
            t8.c = new P8(I3.j, "Network Request dropped as current request is not GDPR compliant.");
            onResponse.invoke(t8);
            return;
        }
        Pa request = a();
        R8 responseListener = new R8(this, onResponse);
        Intrinsics.checkNotNullParameter(responseListener, "responseListener");
        request.l = responseListener;
        Set set = Ra.f3184a;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(request, "request");
        Ra.f3184a.add(request);
        Ra.a(request, 0L);
    }

    public final T8 b() {
        Va vaA;
        P8 p8;
        L4 l4 = this.e;
        if (l4 != null) {
            String str = this.h;
            ((M4) l4).c(str, O5.a(str, "TAG", "Executing network request to URL: ").append(this.b).toString());
        }
        e();
        if (!this.d) {
            L4 l5 = this.e;
            if (l5 != null) {
                String TAG = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l5).c(TAG, "Dropping REQUEST FOR GDPR");
            }
            T8 t8 = new T8();
            t8.c = new P8(I3.j, "Network Request dropped as current request is not GDPR compliant.");
            return t8;
        }
        if (this.n != null) {
            L4 l6 = this.e;
            if (l6 != null) {
                String str2 = this.h;
                StringBuilder sbA = O5.a(str2, "TAG", "response has been failed before execute - ");
                T8 t9 = this.n;
                ((M4) l6).c(str2, sbA.append(t9 != null ? t9.c : null).toString());
            }
            T8 t10 = this.n;
            Intrinsics.checkNotNull(t10);
            return t10;
        }
        Pa request = a();
        L4 l7 = this.e;
        if (l7 != null) {
            String str3 = this.h;
            ((M4) l7).c(str3, O5.a(str3, "TAG", "Making network request to: ").append(request.f3170a).toString());
        }
        Intrinsics.checkNotNullParameter(request, "request");
        do {
            vaA = O8.a(request, (Function2) null);
            p8 = vaA.f3220a;
        } while ((p8 != null ? p8.f3168a : null) == I3.m);
        Intrinsics.checkNotNullParameter(vaA, "<this>");
        T8 response = new T8();
        byte[] value = vaA.c;
        if (value != null) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value.length == 0) {
                response.b = new byte[0];
            } else {
                byte[] bArr = new byte[value.length];
                response.b = bArr;
                System.arraycopy(value, 0, bArr, 0, value.length);
            }
        }
        response.e = vaA.b;
        response.d = vaA.e;
        response.c = vaA.f3220a;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(this, "request");
        return response;
    }

    public final String d() {
        String strConcat = this.b;
        HashMap map = this.j;
        if (map != null) {
            boolean z = W8.f3228a;
            W8.a(map);
            String strA = W8.a(com.ironsource.b9.i.c, (Map) this.j);
            L4 l4 = this.e;
            if (l4 != null) {
                String str = this.h;
                ((M4) l4).c(str, P5.a(str, "TAG", "Get params: ", strA));
            }
            int length = strA.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = Intrinsics.compare((int) strA.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            if (strA.subSequence(i, length + 1).toString().length() > 0) {
                if (strConcat != null && !StringsKt.contains$default((CharSequence) strConcat, (CharSequence) "?", false, 2, (Object) null)) {
                    strConcat = strConcat.concat("?");
                }
                if (strConcat != null && !StringsKt.endsWith$default(strConcat, com.ironsource.b9.i.c, false, 2, (Object) null) && !StringsKt.endsWith$default(strConcat, "?", false, 2, (Object) null)) {
                    strConcat = strConcat.concat(com.ironsource.b9.i.c);
                }
                strConcat = strConcat + strA;
            }
        }
        Intrinsics.checkNotNull(strConcat);
        return strConcat;
    }

    public final void e() {
        f();
        this.i.put("User-Agent", C3517pb.k());
        if (Intrinsics.areEqual("POST", this.f3193a)) {
            this.i.put("Content-Type", this.f);
            if (this.g) {
                this.i.put("Content-Encoding", "gzip");
            } else {
                this.i.put("Content-Length", String.valueOf(c().length()));
            }
        }
    }

    public void f() {
        HashMap map;
        JSONObject jSONObjectC;
        HashMap map2;
        X3 x3 = X3.f3234a;
        x3.j();
        this.d = x3.a(this.d);
        if (Intrinsics.areEqual("GET", this.f3193a)) {
            HashMap map3 = this.j;
            if (this.t) {
                if (map3 != null) {
                    map3.putAll(O0.e);
                }
                if (map3 != null) {
                    map3.putAll(C3435k3.f3355a.a(this.o));
                }
                if (map3 != null) {
                    map3.putAll(AbstractC3466m4.a());
                }
            }
            HashMap map4 = this.j;
            if (this.u) {
                a(map4);
            }
        } else if (Intrinsics.areEqual("POST", this.f3193a)) {
            HashMap map5 = this.k;
            if (this.t) {
                if (map5 != null) {
                    map5.putAll(O0.e);
                }
                if (map5 != null) {
                    map5.putAll(C3435k3.f3355a.a(this.o));
                }
                if (map5 != null) {
                    map5.putAll(AbstractC3466m4.a());
                }
            }
            HashMap map6 = this.k;
            if (this.u) {
                a(map6);
            }
        }
        if (this.v && (jSONObjectC = X3.c()) != null) {
            if (Intrinsics.areEqual("GET", this.f3193a)) {
                HashMap map7 = this.j;
                if (map7 != null) {
                    String string = jSONObjectC.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                }
            } else if (Intrinsics.areEqual("POST", this.f3193a) && (map2 = this.k) != null) {
                String string2 = jSONObjectC.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            }
        }
        if (this.x) {
            if (Intrinsics.areEqual("GET", this.f3193a)) {
                HashMap map8 = this.j;
                if (map8 != null) {
                    return;
                }
                return;
            }
            if (!Intrinsics.areEqual("POST", this.f3193a) || (map = this.k) == null) {
                return;
            }
        }
    }

    public final String c() {
        String str = this.f;
        if (Intrinsics.areEqual(str, "application/json")) {
            return String.valueOf(this.l);
        }
        if (!Intrinsics.areEqual(str, ShareTarget.ENCODING_TYPE_URL_ENCODED)) {
            return "";
        }
        boolean z = W8.f3228a;
        W8.a(this.k);
        return W8.a(com.ironsource.b9.i.c, (Map) this.k);
    }

    public /* synthetic */ S8(String str, String str2, C3545rc c3545rc, boolean z, L4 l4, String str3, int i) {
        this(str, str2, c3545rc, (i & 8) != 0 ? false : z, l4, (i & 32) != 0 ? ShareTarget.ENCODING_TYPE_URL_ENCODED : str3, false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public S8(String url, L4 l4) {
        this("GET", url, (C3545rc) null, false, l4, ShareTarget.ENCODING_TYPE_URL_ENCODED, 64);
        Intrinsics.checkNotNullParameter("GET", "requestType");
        Intrinsics.checkNotNullParameter(url, "url");
        this.v = false;
    }

    public final Pa a() {
        String type = this.f3193a;
        Intrinsics.checkNotNullParameter(type, "type");
        Ma method = (!Intrinsics.areEqual(type, "GET") && Intrinsics.areEqual(type, "POST")) ? Ma.POST : Ma.GET;
        String url = this.b;
        Intrinsics.checkNotNull(url);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        La la = new La(url, method);
        boolean z = W8.f3228a;
        W8.a(this.i);
        HashMap header = this.i;
        Intrinsics.checkNotNullParameter(header, "header");
        la.c = header;
        la.h = Integer.valueOf(this.p);
        la.i = Integer.valueOf(this.q);
        la.f = Boolean.valueOf(this.r);
        la.j = Boolean.valueOf(this.s);
        Oa retryPolicy = this.w;
        if (retryPolicy != null) {
            Intrinsics.checkNotNullParameter(retryPolicy, "retryPolicy");
            la.g = retryPolicy;
        }
        int iOrdinal = method.ordinal();
        if (iOrdinal == 0) {
            HashMap queryParams = this.j;
            if (queryParams != null) {
                L4 l4 = this.e;
                if (l4 != null) {
                    String TAG = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).c(TAG, "getParams " + queryParams);
                }
                Intrinsics.checkNotNullParameter(queryParams, "queryParams");
                la.d = queryParams;
            }
        } else if (iOrdinal == 1) {
            String postBody = c();
            L4 l5 = this.e;
            if (l5 != null) {
                String str = this.h;
                ((M4) l5).c(str, P5.a(str, "TAG", "httpPostBody ", postBody));
            }
            Intrinsics.checkNotNullParameter(postBody, "postBody");
            la.e = postBody;
        }
        return new Pa(la);
    }

    public final void a(HashMap map) {
        F0 f0B;
        String strA;
        C3545rc c3545rc = this.c;
        if (c3545rc == null || map == null) {
            return;
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        try {
            if (c3545rc.f3419a.a() && (f0B = C3532qc.f3412a.b()) != null && (strA = f0B.a()) != null) {
                Intrinsics.checkNotNull(strA);
                map3.put("GPID", strA);
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT, "getSimpleName(...)");
        }
        String string = new JSONObject(map3).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        map2.put("u-id-map", string);
        map.putAll(map2);
    }
}
