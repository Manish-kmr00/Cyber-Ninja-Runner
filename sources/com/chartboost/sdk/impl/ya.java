package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.ChartboostNetworkBridge;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB'\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006*\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\nJ\u0013\u0010\u0007\u001a\u00020\u000b*\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\fJ\u0013\u0010\r\u001a\u00020\u000b*\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0007\u0010\u0010R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/chartboost/sdk/impl/ya;", "", "", "url", "", "limit", "Lkotlin/Result;", "a", "(Ljava/lang/String;I)Ljava/lang/Object;", "Lcom/chartboost/sdk/impl/ya$b;", "(Lcom/chartboost/sdk/impl/ya$b;)Ljava/lang/Object;", "", "(I)Z", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/net/URL;", "Ljavax/net/ssl/HttpsURLConnection;", "(Ljava/net/URL;)Ljavax/net/ssl/HttpsURLConnection;", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "urlFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocket", "<init>", "(Lkotlin/jvm/functions/Function1;Ljavax/net/ssl/SSLSocketFactory;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class ya {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Function1<String, URL> urlFactory;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final SSLSocketFactory sslSocket;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<String, URL> {
        public static final a b = new a();

        public a() {
            super(1, URL.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final URL invoke(String str) {
            return new URL(str);
        }
    }

    public ya() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ya(Function1<? super String, URL> urlFactory, SSLSocketFactory sslSocket) {
        Intrinsics.checkNotNullParameter(urlFactory, "urlFactory");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        this.urlFactory = urlFactory;
        this.sslSocket = sslSocket;
    }

    public /* synthetic */ ya(Function1 function1, SSLSocketFactory sSLSocketFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? a.b : function1, (i & 2) != 0 ? k2.INSTANCE.a() : sSLSocketFactory);
    }

    public final Object a(b bVar) {
        Result.Companion companion = Result.INSTANCE;
        return Result.m7904constructorimpl(ResultKt.createFailure(bVar));
    }

    public final boolean b(int i) {
        return i <= p5.REQUEST_SUCCESS_END.getCode() && p5.REQUEST_SUCCESS_START.getCode() <= i;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0005\u000b\f\r\u000e\u000fB\u001d\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0005\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/chartboost/sdk/impl/ya$b;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "toString", "()Ljava/lang/String;", "message", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "e", "Lcom/chartboost/sdk/impl/ya$b$a;", "Lcom/chartboost/sdk/impl/ya$b$b;", "Lcom/chartboost/sdk/impl/ya$b$c;", "Lcom/chartboost/sdk/impl/ya$b$d;", "Lcom/chartboost/sdk/impl/ya$b$e;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static abstract class b extends Exception {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/chartboost/sdk/impl/ya$b$a;", "Lcom/chartboost/sdk/impl/ya$b;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
        public static final class a extends b {
            public static final a b = new a();

            public a() {
                super("Empty or null URL", null, 2, 0 == true ? 1 : 0);
            }
        }

        public b(String str, Throwable th) {
            super(str, th);
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/chartboost/sdk/impl/ya$b$d;", "Lcom/chartboost/sdk/impl/ya$b;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
        public static final class d extends b {
            public static final d b = new d();

            public d() {
                super("Too many redirects", null, 2, 0 == true ? 1 : 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/chartboost/sdk/impl/ya$b$c;", "Lcom/chartboost/sdk/impl/ya$b;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
        public static final class c extends b {
            public static final c b = new c();

            public c() {
                super("Returned connection is null", null, 2, 0 == true ? 1 : 0);
            }
        }

        /* JADX INFO: renamed from: com.chartboost.sdk.impl.ya$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/chartboost/sdk/impl/ya$b$b;", "Lcom/chartboost/sdk/impl/ya$b;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "getStatusCode", "()I", "statusCode", "<init>", "(I)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
        public static final class C0266b extends b {

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public final int statusCode;

            public C0266b(int i) {
                super("Failed with HTTP code " + i, null, 2, 0 == true ? 1 : 0);
                this.statusCode = i;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/ya$b$e;", "Lcom/chartboost/sdk/impl/ya$b;", "", "toString", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "a", "url", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
        public static final class e extends b {

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public final String url;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(String url, Throwable cause) {
                super("Uncontrolled error", cause, null);
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(cause, "cause");
                this.url = url;
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            @Override // com.chartboost.sdk.impl.ya.b, java.lang.Throwable
            public String toString() {
                String string;
                Throwable cause = getCause();
                return (cause == null || (string = cause.toString()) == null) ? "No cause" : string;
            }
        }

        @Override // java.lang.Throwable
        public String toString() {
            String message = getMessage();
            return message == null ? "No message" : message;
        }

        public /* synthetic */ b(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : th, null);
        }

        public /* synthetic */ b(String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, th);
        }
    }

    public final boolean a(int i) {
        return i <= p5.REDIRECTION_END.getCode() && p5.REDIRECTION_START.getCode() <= i;
    }

    public final HttpsURLConnection a(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        HttpsURLConnection httpsURLConnection = uRLConnectionOpenConnection instanceof HttpsURLConnection ? (HttpsURLConnection) uRLConnectionOpenConnection : null;
        if (httpsURLConnection == null) {
            return null;
        }
        httpsURLConnection.setSSLSocketFactory(this.sslSocket);
        httpsURLConnection.setInstanceFollowRedirects(false);
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        return httpsURLConnection;
    }

    public final Object a(String url, int limit) throws Throwable {
        Object objA;
        if (url == null || url.length() == 0) {
            return a(b.a.b);
        }
        if (limit < 0) {
            return a(b.d.b);
        }
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                URL urlInvoke = this.urlFactory.invoke(url);
                HttpsURLConnection httpsURLConnectionA = a(urlInvoke);
                try {
                    if (httpsURLConnectionA != null) {
                        if (b(ChartboostNetworkBridge.httpUrlConnectionGetResponseCode(httpsURLConnectionA))) {
                            Result.Companion companion = Result.INSTANCE;
                            objA = Result.m7904constructorimpl(url);
                        } else if (a(ChartboostNetworkBridge.httpUrlConnectionGetResponseCode(httpsURLConnectionA))) {
                            String location = httpsURLConnectionA.getHeaderField("Location");
                            Intrinsics.checkNotNullExpressionValue(location, "location");
                            if (StringsKt.startsWith$default(location, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                                location = urlInvoke.getProtocol() + "://" + urlInvoke.getHost() + location;
                            }
                            objA = a(location, limit - 1);
                        } else {
                            objA = a(new b.C0266b(ChartboostNetworkBridge.httpUrlConnectionGetResponseCode(httpsURLConnectionA)));
                        }
                    } else {
                        objA = a(b.c.b);
                    }
                    if (httpsURLConnectionA != null) {
                        ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnectionA);
                    }
                } catch (Exception e) {
                    e = e;
                    httpsURLConnection = httpsURLConnectionA;
                    b7.b("Cannot redirect " + url, e);
                    objA = a(new b.e(url, e));
                    if (httpsURLConnection != null) {
                        httpsURLConnectionA = httpsURLConnection;
                        ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnectionA);
                    }
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection = httpsURLConnectionA;
                    if (httpsURLConnection != null) {
                        ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return objA;
    }

    public static /* synthetic */ Object a(ya yaVar, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 10;
        }
        return yaVar.a(str, i);
    }
}
