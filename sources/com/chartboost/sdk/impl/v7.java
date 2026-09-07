package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b+\u0010,JW\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0012\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0012\u0010\u0017JY\u0010\u0012\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u001aJI\u0010\u0012\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0002¢\u0006\u0004\b\u0012\u0010\u001bJ%\u0010\u0012\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u001cJ9\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u001eJ#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0002¢\u0006\u0004\b\u0012\u0010\u001fJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010!2\u0006\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\"J\u0019\u0010\u0012\u001a\u0004\u0018\u00010#2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/chartboost/sdk/impl/v7;", "", "Lcom/chartboost/sdk/impl/p2;", "webView", "Lcom/chartboost/sdk/impl/d7;", "mtype", "Lcom/chartboost/sdk/impl/f8;", "omidPartner", "", "omidJsServiceContent", "", "Lcom/chartboost/sdk/impl/fb;", "verificationScriptResourcesList", "", "isValidationEnabled", "Lcom/chartboost/sdk/impl/eb;", "verificationListConfig", "Lcom/chartboost/sdk/impl/v7$a;", "a", "(Lcom/chartboost/sdk/impl/p2;Lcom/chartboost/sdk/impl/d7;Lcom/chartboost/sdk/impl/f8;Ljava/lang/String;Ljava/util/List;ZLjava/util/List;)Lcom/chartboost/sdk/impl/v7$a;", "Lcom/chartboost/sdk/impl/p;", "adSession", "Lcom/chartboost/sdk/impl/c7;", "(Lcom/chartboost/sdk/impl/d7;Lcom/chartboost/sdk/impl/p;)Lcom/chartboost/sdk/impl/c7;", com.ironsource.b9.h.K, "Lcom/chartboost/sdk/impl/r;", "(Lcom/chartboost/sdk/impl/f8;Ljava/lang/String;Ljava/util/List;ZLjava/util/List;Lcom/chartboost/sdk/impl/d7;Lcom/chartboost/sdk/impl/p2;)Lcom/chartboost/sdk/impl/r;", "(Lcom/chartboost/sdk/impl/f8;Ljava/lang/String;Ljava/util/List;ZLjava/util/List;)Lcom/chartboost/sdk/impl/r;", "(Lcom/chartboost/sdk/impl/f8;Lcom/chartboost/sdk/impl/p2;)Lcom/chartboost/sdk/impl/r;", "resources", "(Ljava/util/List;Ljava/util/List;Z)Ljava/util/List;", "(Ljava/util/List;)Ljava/util/List;", "url", "Ljava/net/URL;", "(Ljava/lang/String;)Ljava/net/URL;", "Lcom/chartboost/sdk/impl/q;", "(Lcom/chartboost/sdk/impl/d7;)Lcom/chartboost/sdk/impl/q;", "Lcom/chartboost/sdk/impl/q3;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/impl/d7;)Lcom/chartboost/sdk/impl/q3;", "Lcom/chartboost/sdk/impl/e8;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Lcom/chartboost/sdk/impl/d7;)Lcom/chartboost/sdk/impl/e8;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class v7 {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1166a;

        static {
            int[] iArr = new int[d7.values().length];
            try {
                iArr[d7.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d7.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d7.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d7.AUDIO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d7.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f1166a = iArr;
        }
    }

    public final q3 b(d7 mtype) {
        int i = b.f1166a[mtype.ordinal()];
        if (i == 1) {
            return q3.NATIVE_DISPLAY;
        }
        if (i == 2) {
            return q3.HTML_DISPLAY;
        }
        if (i == 3) {
            return q3.VIDEO;
        }
        if (i == 4) {
            return q3.AUDIO;
        }
        if (i == 5) {
            return q3.NATIVE_DISPLAY;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final e8 c(d7 mtype) {
        int i = b.f1166a[mtype.ordinal()];
        if (i == 1) {
            return e8.NATIVE;
        }
        if (i == 2) {
            return e8.NONE;
        }
        if (i == 3) {
            return e8.NATIVE;
        }
        if (i == 4) {
            return e8.NATIVE;
        }
        if (i == 5) {
            return e8.NATIVE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final List<fb> a(List<fb> resources, List<eb> verificationListConfig, boolean isValidationEnabled) {
        ArrayList arrayList = new ArrayList();
        if (isValidationEnabled) {
            arrayList.addAll(a(verificationListConfig));
        }
        arrayList.addAll(resources);
        return arrayList;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\r\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\r\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\r\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/chartboost/sdk/impl/v7$a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/chartboost/sdk/impl/p;", "a", "Lcom/chartboost/sdk/impl/p;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/chartboost/sdk/impl/p;", "(Lcom/chartboost/sdk/impl/p;)V", "omSession", "Lcom/chartboost/sdk/impl/k;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/k;", "()Lcom/chartboost/sdk/impl/k;", "(Lcom/chartboost/sdk/impl/k;)V", "omAdEvents", "Lcom/chartboost/sdk/impl/c7;", "Lcom/chartboost/sdk/impl/c7;", "()Lcom/chartboost/sdk/impl/c7;", "setMediaEvents", "(Lcom/chartboost/sdk/impl/c7;)V", "mediaEvents", "<init>", "(Lcom/chartboost/sdk/impl/p;Lcom/chartboost/sdk/impl/k;Lcom/chartboost/sdk/impl/c7;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public p omSession;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public k omAdEvents;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public c7 mediaEvents;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Intrinsics.areEqual(this.omSession, aVar.omSession) && Intrinsics.areEqual(this.omAdEvents, aVar.omAdEvents) && Intrinsics.areEqual(this.mediaEvents, aVar.mediaEvents);
        }

        public int hashCode() {
            p pVar = this.omSession;
            int iHashCode = (pVar == null ? 0 : pVar.hashCode()) * 31;
            k kVar = this.omAdEvents;
            int iHashCode2 = (iHashCode + (kVar == null ? 0 : kVar.hashCode())) * 31;
            c7 c7Var = this.mediaEvents;
            return iHashCode2 + (c7Var != null ? c7Var.hashCode() : 0);
        }

        public String toString() {
            return "OMSessionHolder(omSession=" + this.omSession + ", omAdEvents=" + this.omAdEvents + ", mediaEvents=" + this.mediaEvents + ')';
        }

        public a(p pVar, k kVar, c7 c7Var) {
            this.omSession = pVar;
            this.omAdEvents = kVar;
            this.mediaEvents = c7Var;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final p getOmSession() {
            return this.omSession;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final k getOmAdEvents() {
            return this.omAdEvents;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final c7 getMediaEvents() {
            return this.mediaEvents;
        }

        public final void a(k kVar) {
            this.omAdEvents = kVar;
        }

        public final void a(p pVar) {
            this.omSession = pVar;
        }
    }

    public final q a(d7 mtype) {
        try {
            return q.a(b(mtype), n6.BEGIN_TO_RENDER, e8.NATIVE, c(mtype), false);
        } catch (IllegalArgumentException e) {
            b7.a("buildAdSessionVideoConfig error", e);
            return null;
        }
    }

    public final r a(f8 omidPartner, p2 webView) {
        try {
            return r.a(omidPartner, webView, null, null);
        } catch (IllegalArgumentException e) {
            b7.a("buildHtmlContext error", e);
            return null;
        }
    }

    public final r a(f8 omidPartner, String omidJsServiceContent, List<fb> verificationScriptResourcesList, boolean isValidationEnabled, List<eb> verificationListConfig) {
        try {
            return r.a(omidPartner, omidJsServiceContent, a(verificationScriptResourcesList, verificationListConfig, isValidationEnabled), null, null);
        } catch (IllegalArgumentException e) {
            b7.a("buildNativeContext error", e);
            return null;
        }
    }

    public final List<fb> a(List<eb> verificationListConfig) {
        try {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(verificationListConfig, 10));
            for (eb ebVar : verificationListConfig) {
                arrayList.add(fb.a(ebVar.getVendor(), a(ebVar.getUrl()), ebVar.getParams()));
            }
            return arrayList;
        } catch (Exception e) {
            b7.a("buildVerificationResources error", e);
            return CollectionsKt.emptyList();
        }
    }

    public final c7 a(d7 mtype, p adSession) {
        if (mtype == d7.HTML) {
            return null;
        }
        return c7.a(adSession);
    }

    public final a a(p2 webView, d7 mtype, f8 omidPartner, String omidJsServiceContent, List<fb> verificationScriptResourcesList, boolean isValidationEnabled, List<eb> verificationListConfig) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(mtype, "mtype");
        Intrinsics.checkNotNullParameter(verificationScriptResourcesList, "verificationScriptResourcesList");
        Intrinsics.checkNotNullParameter(verificationListConfig, "verificationListConfig");
        try {
            p it = p.a(a(mtype), a(omidPartner, omidJsServiceContent, verificationScriptResourcesList, isValidationEnabled, verificationListConfig, mtype, webView));
            it.a(webView);
            k kVarA = k.a(it);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            return new a(it, kVarA, a(mtype, it));
        } catch (Exception e) {
            b7.b("OMSDK create session exception", e);
            return null;
        }
    }

    public final r a(f8 omidPartner, String omidJsServiceContent, List<fb> verificationScriptResourcesList, boolean isValidationEnabled, List<eb> verificationListConfig, d7 mtype, p2 webview) {
        if (mtype == d7.HTML) {
            return a(omidPartner, webview);
        }
        return a(omidPartner, omidJsServiceContent, verificationScriptResourcesList, isValidationEnabled, verificationListConfig);
    }

    public final URL a(String url) {
        try {
            return new URL(url);
        } catch (Exception e) {
            b7.a("buildVerificationResources invalid url", e);
            return null;
        }
    }
}
