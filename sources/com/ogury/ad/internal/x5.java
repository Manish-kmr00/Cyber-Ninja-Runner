package com.ogury.ad.internal;

import com.ogury.core.internal.network.NetworkClient;
import com.ogury.core.internal.network.NetworkRequest;
import com.ogury.core.internal.network.NetworkResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class x5 {
    public static x5 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2 f7440a;
    public final NetworkClient b;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        public a(Object obj) {
            super(1, obj, u3.class, "e", "e(Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable p0 = th;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((u3) this.receiver).getClass();
            return Unit.INSTANCE;
        }
    }

    public x5(m2 m2Var, NetworkClient networkClient) {
        this.f7440a = m2Var;
        this.b = networkClient;
    }

    public static final Unit c(x5 x5Var, NetworkRequest networkRequest) throws Throwable {
        NetworkResponse networkResponseExecute = x5Var.b.newCall(networkRequest).execute();
        if (networkResponseExecute instanceof NetworkResponse.Failure) {
            throw ((NetworkResponse.Failure) networkResponseExecute).getException();
        }
        return Unit.INSTANCE;
    }

    public static final Unit d(x5 x5Var, NetworkRequest networkRequest) throws Throwable {
        NetworkResponse networkResponseExecute = x5Var.b.newCall(networkRequest).execute();
        if (networkResponseExecute instanceof NetworkResponse.Failure) {
            throw ((NetworkResponse.Failure) networkResponseExecute).getException();
        }
        return Unit.INSTANCE;
    }

    public static final Unit e(x5 x5Var, NetworkRequest networkRequest) throws Throwable {
        NetworkResponse networkResponseExecute = x5Var.b.newCall(networkRequest).execute();
        if (networkResponseExecute instanceof NetworkResponse.Failure) {
            throw ((NetworkResponse.Failure) networkResponseExecute).getException();
        }
        return Unit.INSTANCE;
    }

    public final h1 a(String str, JSONObject requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        if (str == null || str.length() == 0) {
            str = l9.a("pl", "pl", com.moloco.sdk.internal.services.bidtoken.s.f6343a);
        }
        String string = requestBody.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        final NetworkRequest networkRequest = new NetworkRequest(str, "POST", string, this.f7440a.f7353a);
        Function0 action = new Function0() { // from class: com.ogury.ad.internal.x5$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return x5.c(this.f$0, networkRequest);
            }
        };
        Intrinsics.checkNotNullParameter(action, "action");
        return new h1(action);
    }

    public final NetworkResponse b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return this.b.newCall(new NetworkRequest(url, "GET", "", this.f7440a.f7353a)).execute();
    }

    public final NetworkResponse b(JSONObject requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        String strB = l9.b("inapp/config", "sac", "v1");
        String string = requestBody.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        NetworkRequest networkRequest = new NetworkRequest(strB, "POST", string, this.f7440a.c);
        a("sendProfig", networkRequest);
        NetworkResponse networkResponseExecute = this.b.newCall(networkRequest).execute();
        a("sendProfig", networkRequest, networkResponseExecute);
        return networkResponseExecute;
    }

    public final h1 c(String str, JSONObject requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        if (str == null || str.length() == 0) {
            str = l9.a("track", "tr", "v1");
        }
        String string = requestBody.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        final NetworkRequest networkRequest = new NetworkRequest(str, "POST", string, this.f7440a.b);
        Function0 action = new Function0() { // from class: com.ogury.ad.internal.x5$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return x5.e(this.f$0, networkRequest);
            }
        };
        Intrinsics.checkNotNullParameter(action, "action");
        return new h1(action);
    }

    public static final Unit b(x5 x5Var, NetworkRequest networkRequest) throws Throwable {
        NetworkResponse networkResponseExecute = x5Var.b.newCall(networkRequest).execute();
        if (!(networkResponseExecute instanceof NetworkResponse.Failure)) {
            return Unit.INSTANCE;
        }
        throw ((NetworkResponse.Failure) networkResponseExecute).getException();
    }

    public final h1 b(String str, JSONObject requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        if (str == null || str.length() == 0) {
            str = l9.a("ad_history", "ah", "v1");
        }
        String string = requestBody.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        final NetworkRequest networkRequest = new NetworkRequest(str, "POST", string, this.f7440a.b);
        Function0 action = new Function0() { // from class: com.ogury.ad.internal.x5$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return x5.d(this.f$0, networkRequest);
            }
        };
        Intrinsics.checkNotNullParameter(action, "action");
        return new h1(action);
    }

    public final h1 a(JSONObject requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        String strA = l9.a();
        String string = requestBody.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        final NetworkRequest networkRequest = new NetworkRequest(strA, "POST", string, this.f7440a.c);
        Function0 action = new Function0() { // from class: com.ogury.ad.internal.x5$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return x5.b(this.f$0, networkRequest);
            }
        };
        Intrinsics.checkNotNullParameter(action, "action");
        return new h1(action);
    }

    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        final NetworkRequest networkRequest = new NetworkRequest(url, "GET", "", this.f7440a.b);
        Function0 action = new Function0() { // from class: com.ogury.ad.internal.x5$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return x5.a(this.f$0, networkRequest);
            }
        };
        Intrinsics.checkNotNullParameter(action, "action");
        h1 h1Var = new h1(action);
        a consumer = new a(u3.f7411a);
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        h1Var.c = consumer;
        h1Var.b(new Function0() { // from class: com.ogury.ad.internal.x5$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return x5.a();
            }
        });
    }

    public static final Unit a(x5 x5Var, NetworkRequest networkRequest) throws Throwable {
        NetworkResponse networkResponseExecute = x5Var.b.newCall(networkRequest).execute();
        if (!(networkResponseExecute instanceof NetworkResponse.Failure)) {
            return Unit.INSTANCE;
        }
        throw ((NetworkResponse.Failure) networkResponseExecute).getException();
    }

    public static final Unit a() {
        u3.f7411a.getClass();
        return Unit.INSTANCE;
    }

    public static void a(String str, NetworkRequest networkRequest) throws JSONException {
        u3 u3Var = u3.f7411a;
        String url = networkRequest.getUrl();
        String method = networkRequest.getMethod();
        Map<String, String> mapLoadHeaders = networkRequest.getHeaders().loadHeaders();
        ArrayList arrayList = new ArrayList(mapLoadHeaders.size());
        for (Map.Entry<String, String> entry : mapLoadHeaders.entrySet()) {
            arrayList.add("\n" + ((Object) entry.getKey()) + ":" + ((Object) entry.getValue()));
        }
        String str2 = "-------------------------------------------------- \n[Ads][setup] " + str + " request :\nurl     : " + url + " \nmethod  : " + method + " \nheaders : " + arrayList + " \nbody    : " + new JSONObject(networkRequest.getBody()).toString(4) + " \n--------------------------------------------------";
        u3Var.getClass();
    }

    public static void a(String str, NetworkRequest networkRequest, NetworkResponse networkResponse) {
        String str2;
        try {
            ArrayList arrayList = null;
            if (networkResponse instanceof NetworkResponse.Success) {
                Map<String, List<String>> responseHeaders = ((NetworkResponse.Success) networkResponse).getResponseHeaders();
                if (responseHeaders != null) {
                    arrayList = new ArrayList(responseHeaders.size());
                    for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                        arrayList.add("\n" + ((Object) entry.getKey()) + ":" + entry.getValue());
                    }
                }
                str2 = "headers : " + arrayList + " \n";
            } else if (networkResponse instanceof NetworkResponse.Failure) {
                Map<String, List<String>> responseHeaders2 = ((NetworkResponse.Failure) networkResponse).getResponseHeaders();
                if (responseHeaders2 != null) {
                    arrayList = new ArrayList(responseHeaders2.size());
                    for (Map.Entry<String, List<String>> entry2 : responseHeaders2.entrySet()) {
                        arrayList.add("\n" + ((Object) entry2.getKey()) + ":" + entry2.getValue());
                    }
                }
                str2 = "headers : " + arrayList + " \nbody    : " + (e3.a(((NetworkResponse.Failure) networkResponse).getResponseBody()) ? new JSONObject(((NetworkResponse.Failure) networkResponse).getResponseBody()).toString(4) : ((NetworkResponse.Failure) networkResponse).getResponseBody()) + " \nexception    : " + ((NetworkResponse.Failure) networkResponse).getException() + " \n";
            } else {
                str2 = "ELSE........";
            }
            u3 u3Var = u3.f7411a;
            String str3 = "-------------------------------------------------- \n[Ads][setup] " + str + " response :\nurl     : " + networkRequest.getUrl() + " \nmethod  : " + networkRequest.getMethod() + " \n" + str2 + " \n--------------------------------------------------";
            u3Var.getClass();
        } catch (Exception e) {
            String str4 = "[Ads][setup] " + str + " response : Error when displaying response log";
            u3.f7411a.getClass();
            c9.a(e);
        }
    }
}
