package com.pubmatic.sdk.common.network;

import android.content.Context;
import android.graphics.Bitmap;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.json.cc;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.utils.Logger;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class POBNetworkHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final POBRequestQueue f7594a;

    public interface POBImageNetworkListener<T> {
        void onFailure(POBError pOBError);

        void onSuccess(Bitmap bitmap);
    }

    public interface POBNetworkListener<T> {
        void onFailure(POBError pOBError);

        void onSuccess(T t);
    }

    public interface POBNetworkResultListener {
        void onResult(POBNetworkResult pOBNetworkResult);
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7595a;

        static {
            int[] iArr = new int[POBHttpRequest.HTTP_METHOD.values().length];
            f7595a = iArr;
            try {
                iArr[POBHttpRequest.HTTP_METHOD.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7595a[POBHttpRequest.HTTP_METHOD.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7595a[POBHttpRequest.HTTP_METHOD.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    class b implements Response.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBNetworkListener f7596a;

        b(POBNetworkListener pOBNetworkListener) {
            this.f7596a = pOBNetworkListener;
        }

        public void a(String str) {
            POBNetworkListener pOBNetworkListener = this.f7596a;
            if (pOBNetworkListener != null) {
                pOBNetworkListener.onSuccess(str);
            }
        }

        @Override // com.android.volley.Response.Listener
        public /* bridge */ /* synthetic */ void onResponse(Object obj) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/network/POBNetworkHandler$b;->onResponse(Ljava/lang/Object;)V");
            CreativeInfoManager.onVolleyGetResponse(com.safedk.android.utils.h.F, this, obj);
            safedk_POBNetworkHandler$b_onResponse_739d05bb7634f0b095742430ef108f3d(obj);
        }

        public void safedk_POBNetworkHandler$b_onResponse_739d05bb7634f0b095742430ef108f3d(Object p0) {
            a((String) p0);
        }
    }

    class c extends StringRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBHttpRequest f7597a;
        final /* synthetic */ POBNetworkHandler b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        c(POBNetworkHandler pOBNetworkHandler, int i, String str, Response.Listener listener, Response.ErrorListener errorListener, POBHttpRequest pOBHttpRequest) {
            this(pOBNetworkHandler, i, str, listener, errorListener, pOBHttpRequest, null);
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/network/POBNetworkHandler$c;-><init>(Lcom/pubmatic/sdk/common/network/POBNetworkHandler;ILjava/lang/String;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;Lcom/pubmatic/sdk/common/network/POBHttpRequest;)V");
            CreativeInfoManager.onVolleyStringRequestCtor(com.safedk.android.utils.h.F, str, listener);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private c(POBNetworkHandler p1, int p2, String p3, Response.Listener p4, Response.ErrorListener p5, POBHttpRequest p6, StatsEvent p7) {
            super(p2, p3, p4, p5);
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/network/POBNetworkHandler$c;-><init>(Lcom/pubmatic/sdk/common/network/POBNetworkHandler;ILjava/lang/String;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;Lcom/pubmatic/sdk/common/network/POBHttpRequest;)V");
            if ("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/network/POBNetworkHandler$c;-><init>(Lcom/pubmatic/sdk/common/network/POBNetworkHandler;ILjava/lang/String;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;Lcom/pubmatic/sdk/common/network/POBHttpRequest;)V" == 0) {
                this.b = p1;
                this.f7597a = p6;
            } else {
                this.b = p1;
                this.f7597a = p6;
                super(p2, p3, p4, p5);
            }
        }

        @Override // com.android.volley.Request
        public byte[] getBody() {
            if (this.f7597a.getPostData() == null) {
                return null;
            }
            return this.f7597a.getPostData().getBytes(StandardCharsets.UTF_8);
        }

        @Override // com.android.volley.Request
        public Map getHeaders() {
            return this.f7597a.getHeaders();
        }
    }

    class d implements Response.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBImageNetworkListener f7598a;

        d(POBImageNetworkListener pOBImageNetworkListener) {
            this.f7598a = pOBImageNetworkListener;
        }

        public void a(Bitmap bitmap) {
            POBImageNetworkListener pOBImageNetworkListener = this.f7598a;
            if (pOBImageNetworkListener != null) {
                pOBImageNetworkListener.onSuccess(bitmap);
            }
        }

        @Override // com.android.volley.Response.Listener
        public /* bridge */ /* synthetic */ void onResponse(Object obj) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/network/POBNetworkHandler$d;->onResponse(Ljava/lang/Object;)V");
            CreativeInfoManager.onVolleyGetResponse(com.safedk.android.utils.h.F, this, obj);
            safedk_POBNetworkHandler$d_onResponse_592f11f730de7fb80646b2978968126c(obj);
        }

        public void safedk_POBNetworkHandler$d_onResponse_592f11f730de7fb80646b2978968126c(Object p0) {
            a((Bitmap) p0);
        }
    }

    class e implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBImageNetworkListener f7599a;

        e(POBImageNetworkListener pOBImageNetworkListener) {
            this.f7599a = pOBImageNetworkListener;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (this.f7599a != null) {
                this.f7599a.onFailure(new POBError(1007, "not able to fetch response"));
            }
        }
    }

    class f implements Response.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBNetworkListener f7600a;

        f(POBNetworkListener pOBNetworkListener) {
            this.f7600a = pOBNetworkListener;
        }

        public void a(JSONObject jSONObject) {
            POBNetworkListener pOBNetworkListener = this.f7600a;
            if (pOBNetworkListener != null) {
                pOBNetworkListener.onSuccess(jSONObject);
            }
        }

        @Override // com.android.volley.Response.Listener
        public /* bridge */ /* synthetic */ void onResponse(Object obj) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/network/POBNetworkHandler$f;->onResponse(Ljava/lang/Object;)V");
            CreativeInfoManager.onVolleyGetResponse(com.safedk.android.utils.h.F, this, obj);
            safedk_POBNetworkHandler$f_onResponse_334679e25feaf4b11c4b777184f6aedb(obj);
        }

        public void safedk_POBNetworkHandler$f_onResponse_334679e25feaf4b11c4b777184f6aedb(Object p0) {
            a((JSONObject) p0);
        }
    }

    class g extends JsonObjectRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBHttpRequest f7601a;
        final /* synthetic */ POBNetworkResultListener b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i, String str, JSONObject jSONObject, Response.Listener listener, Response.ErrorListener errorListener, POBHttpRequest pOBHttpRequest, POBNetworkResultListener pOBNetworkResultListener) {
            super(i, str, jSONObject, listener, errorListener);
            this.f7601a = pOBHttpRequest;
            this.b = pOBNetworkResultListener;
        }

        @Override // com.android.volley.toolbox.JsonRequest, com.android.volley.Request
        public byte[] getBody() {
            if (this.f7601a.getPostData() == null) {
                return null;
            }
            return this.f7601a.getPostData().getBytes(StandardCharsets.UTF_8);
        }

        @Override // com.android.volley.Request
        public Map getHeaders() {
            return this.f7601a.getHeaders();
        }

        @Override // com.android.volley.toolbox.JsonObjectRequest, com.android.volley.toolbox.JsonRequest, com.android.volley.Request
        protected Response parseNetworkResponse(NetworkResponse networkResponse) {
            try {
                JSONObject jSONObject = new JSONObject(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, cc.N)));
                if (this.b != null) {
                    Map map = networkResponse.headers;
                    if (map == null) {
                        map = new HashMap();
                    }
                    this.b.onResult(new POBNetworkResult(map, networkResponse.networkTimeMs));
                }
                return Response.success(jSONObject, HttpHeaderParser.parseCacheHeaders(networkResponse));
            } catch (UnsupportedEncodingException | JSONException unused) {
                return Response.error(new ParseError(networkResponse));
            }
        }
    }

    class h implements RequestQueue.RequestFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7602a;

        h(String str) {
            this.f7602a = str;
        }

        @Override // com.android.volley.RequestQueue.RequestFilter
        public boolean apply(Request request) {
            if (!this.f7602a.equals(request.getTag())) {
                return false;
            }
            POBLog.debug("PMNetworkHandler", "Cancelled volley Ad Request for Tag <" + this.f7602a + "> ", new Object[0]);
            return true;
        }
    }

    class i implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBNetworkResultListener f7603a;
        final /* synthetic */ POBHttpRequest b;
        final /* synthetic */ POBNetworkListener c;

        i(POBNetworkResultListener pOBNetworkResultListener, POBHttpRequest pOBHttpRequest, POBNetworkListener pOBNetworkListener, k kVar) {
            this.f7603a = pOBNetworkResultListener;
            this.b = pOBHttpRequest;
            this.c = pOBNetworkListener;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (this.f7603a != null) {
                NetworkResponse networkResponseA = POBNetworkHandler.this.a(volleyError, this.b);
                Map map = networkResponseA.headers;
                if (map == null) {
                    map = new HashMap();
                }
                this.f7603a.onResult(new POBNetworkResult(map, networkResponseA.networkTimeMs));
            }
            if (this.c != null) {
                try {
                    POBHttpRequest pOBHttpRequestA = POBNetworkHandler.this.a(volleyError, this.b, (k) null);
                    if (pOBHttpRequestA != null) {
                        POBNetworkHandler.this.sendRequest(pOBHttpRequestA, this.c);
                    } else {
                        this.c.onFailure(POBNetworkHandler.this.a(volleyError));
                    }
                } catch (VolleyError e) {
                    this.c.onFailure(POBNetworkHandler.this.a(e));
                }
            }
        }
    }

    class j implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBNetworkResultListener f7604a;
        final /* synthetic */ POBHttpRequest b;
        final /* synthetic */ POBNetworkListener c;

        j(POBNetworkResultListener pOBNetworkResultListener, POBHttpRequest pOBHttpRequest, k kVar, POBNetworkListener pOBNetworkListener) {
            this.f7604a = pOBNetworkResultListener;
            this.b = pOBHttpRequest;
            this.c = pOBNetworkListener;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (this.f7604a != null) {
                NetworkResponse networkResponseA = POBNetworkHandler.this.a(volleyError, this.b);
                Map map = networkResponseA.headers;
                if (map == null) {
                    map = new HashMap();
                }
                this.f7604a.onResult(new POBNetworkResult(map, networkResponseA.networkTimeMs));
            }
            try {
                POBHttpRequest pOBHttpRequestA = POBNetworkHandler.this.a(volleyError, this.b, (k) null);
                if (pOBHttpRequestA != null) {
                    POBNetworkHandler.this.sendJSONRequest(pOBHttpRequestA, this.c);
                    return;
                }
                POBNetworkListener pOBNetworkListener = this.c;
                if (pOBNetworkListener != null) {
                    pOBNetworkListener.onFailure(POBNetworkHandler.this.a(volleyError));
                }
            } catch (VolleyError e) {
                POBNetworkListener pOBNetworkListener2 = this.c;
                if (pOBNetworkListener2 != null) {
                    pOBNetworkListener2.onFailure(POBNetworkHandler.this.a(e));
                }
            }
        }
    }

    interface k {
        POBHttpRequest a(POBHttpRequest pOBHttpRequest);
    }

    public POBNetworkHandler(Context context) {
        this(POBVolley.newRequestQueue(context, new BasicNetwork((BaseHttpStack) new HurlStack())));
    }

    private Response.ErrorListener b(POBHttpRequest pOBHttpRequest, POBNetworkListener pOBNetworkListener, k kVar, POBNetworkResultListener pOBNetworkResultListener) {
        return new j(pOBNetworkResultListener, pOBHttpRequest, kVar, pOBNetworkListener);
    }

    private void c(POBHttpRequest pOBHttpRequest, POBNetworkListener pOBNetworkListener, k kVar, POBNetworkResultListener pOBNetworkResultListener) {
        g gVar = new g(a(pOBHttpRequest.getRequestMethod()), (pOBHttpRequest.getRequestMethod() != POBHttpRequest.HTTP_METHOD.GET || POBUtils.isNullOrEmpty(pOBHttpRequest.getPostData())) ? pOBHttpRequest.getUrl() : pOBHttpRequest.getUrl() + pOBHttpRequest.getPostData(), null, new f(pOBNetworkListener), b(pOBHttpRequest, pOBNetworkListener, kVar, pOBNetworkResultListener), pOBHttpRequest, pOBNetworkResultListener);
        a(pOBHttpRequest, gVar);
        a(gVar, pOBHttpRequest.getRequestTag());
    }

    public void cancelRequest(String str) {
        POBRequestQueue pOBRequestQueue = this.f7594a;
        if (pOBRequestQueue != null) {
            pOBRequestQueue.cancelAll((RequestQueue.RequestFilter) new h(str));
        }
    }

    public void sendImageRequest(POBImageRequest pOBImageRequest, POBImageNetworkListener<String> pOBImageNetworkListener) {
        if (pOBImageRequest == null || pOBImageRequest.getUrl() == null) {
            if (pOBImageNetworkListener != null) {
                pOBImageNetworkListener.onFailure(new POBError(1001, "Request parameter or URL is null."));
            }
        } else {
            ImageRequest imageRequest = new ImageRequest(pOBImageRequest.getUrl(), new d(pOBImageNetworkListener), pOBImageRequest.getMaxWidth(), pOBImageRequest.getMaxHeight(), pOBImageRequest.getScaleType(), pOBImageRequest.getDecodeConfig(), new e(pOBImageNetworkListener));
            a(pOBImageRequest, imageRequest);
            a(imageRequest, pOBImageRequest.getRequestTag());
        }
    }

    public void sendJSONRequest(POBHttpRequest pOBHttpRequest, POBNetworkListener<JSONObject> pOBNetworkListener) {
        c(pOBHttpRequest, pOBNetworkListener, null, null);
    }

    public void sendRequest(String str, String str2, POBNetworkListener<String> pOBNetworkListener, k kVar) {
        POBHttpRequest pOBHttpRequest = new POBHttpRequest();
        pOBHttpRequest.setUrl(str);
        pOBHttpRequest.setRequestTag(str2);
        sendRequest(pOBHttpRequest, pOBNetworkListener, kVar);
    }

    public POBNetworkHandler(POBRequestQueue pOBRequestQueue) {
        this.f7594a = pOBRequestQueue;
    }

    private boolean b(VolleyError volleyError) {
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (networkResponse == null) {
            return false;
        }
        int i2 = networkResponse.statusCode;
        return 301 == i2 || i2 == 302 || i2 == 303;
    }

    public void sendJSONRequest(POBHttpRequest pOBHttpRequest, POBNetworkListener<JSONObject> pOBNetworkListener, POBNetworkResultListener pOBNetworkResultListener) {
        c(pOBHttpRequest, pOBNetworkListener, null, pOBNetworkResultListener);
    }

    private void a(POBHttpRequest pOBHttpRequest, Request request) {
        if (pOBHttpRequest.getTimeout() > 0 || pOBHttpRequest.getRetryCount() > 0) {
            request.setRetryPolicy(new DefaultRetryPolicy(pOBHttpRequest.getTimeout(), pOBHttpRequest.getRetryCount(), pOBHttpRequest.getRetryBackoffMultiplier()));
        }
    }

    public void sendRequest(String str, String str2, POBNetworkListener<String> pOBNetworkListener) {
        sendRequest(str, str2, pOBNetworkListener, null);
    }

    public void sendRequest(POBHttpRequest pOBHttpRequest, POBNetworkListener<String> pOBNetworkListener) {
        sendRequest(pOBHttpRequest, pOBNetworkListener, (k) null);
    }

    public void sendRequest(POBHttpRequest pOBHttpRequest, POBNetworkListener<String> pOBNetworkListener, k kVar) {
        if (pOBHttpRequest == null || pOBHttpRequest.getUrl() == null || pOBHttpRequest.getRequestMethod() == null) {
            if (pOBNetworkListener != null) {
                pOBNetworkListener.onFailure(new POBError(1001, "Request parameter or URL is null."));
            }
        } else {
            c cVar = new c(this, a(pOBHttpRequest.getRequestMethod()), pOBHttpRequest.getUrl(), new b(pOBNetworkListener), a(pOBHttpRequest, pOBNetworkListener, kVar, (POBNetworkResultListener) null), pOBHttpRequest);
            a(pOBHttpRequest, cVar);
            a(cVar, pOBHttpRequest.getRequestTag());
        }
    }

    private void a(Request request, String str) {
        request.setTag(str);
        this.f7594a.add(request);
    }

    private int a(POBHttpRequest.HTTP_METHOD http_method) {
        int i2 = a.f7595a[http_method.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 3;
        }
        return 2;
    }

    private Response.ErrorListener a(POBHttpRequest pOBHttpRequest, POBNetworkListener pOBNetworkListener, k kVar, POBNetworkResultListener pOBNetworkResultListener) {
        return new i(pOBNetworkResultListener, pOBHttpRequest, pOBNetworkListener, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetworkResponse a(VolleyError volleyError, POBHttpRequest pOBHttpRequest) {
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (networkResponse == null) {
            networkResponse = new NetworkResponse(0, (byte[]) null, false, volleyError.getNetworkTimeMs(), (List<Header>) new ArrayList());
        }
        return networkResponse.networkTimeMs > ((long) pOBHttpRequest.getTimeout()) ? new NetworkResponse(networkResponse.statusCode, networkResponse.data, networkResponse.notModified, pOBHttpRequest.getTimeout(), networkResponse.allHeaders) : networkResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public POBError a(VolleyError volleyError) {
        int i2;
        String message = volleyError.getMessage() != null ? volleyError.getMessage() : "Unknown error message.";
        if (volleyError instanceof TimeoutError) {
            return new POBError(1005, message);
        }
        if (volleyError instanceof ParseError) {
            if (volleyError.networkResponse != null) {
                String str = "Parsing error with HTTP status code: " + volleyError.networkResponse.statusCode;
                if (volleyError.networkResponse.statusCode == 204) {
                    return new POBError(1002, str);
                }
                return new POBError(1007, str);
            }
            return new POBError(1007, message);
        }
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (networkResponse != null && (i2 = networkResponse.statusCode) >= 500 && i2 < 600) {
            return new POBError(1004, message);
        }
        return new POBError(1006, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public POBHttpRequest a(VolleyError volleyError, POBHttpRequest pOBHttpRequest, k kVar) throws VolleyError {
        POBHttpRequest pOBHttpRequestA;
        if (!b(volleyError)) {
            return null;
        }
        Map<String, String> map = volleyError.networkResponse.headers;
        String str = map != null ? map.get("Location") : null;
        if (str != null) {
            try {
                POBHttpRequest pOBHttpRequestM5492clone = pOBHttpRequest.m5492clone();
                pOBHttpRequestM5492clone.setUrl(str);
                return (kVar == null || (pOBHttpRequestA = kVar.a(pOBHttpRequestM5492clone)) == null) ? pOBHttpRequestM5492clone : pOBHttpRequestA;
            } catch (CloneNotSupportedException e2) {
                throw new VolleyError(e2);
            }
        }
        throw new VolleyError("Location header does not exists for Redirection");
    }
}
