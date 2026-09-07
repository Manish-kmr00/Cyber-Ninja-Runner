package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.Networking.NetworkHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/chartboost/sdk/impl/pa;", "Lcom/chartboost/sdk/impl/i2;", "Lcom/chartboost/sdk/impl/d2;", "a", "()Lcom/chartboost/sdk/impl/d2;", "", "", "l", "()Ljava/util/Map;", "Lcom/chartboost/sdk/impl/la;", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "Lcom/chartboost/sdk/impl/la;", "trackingEventCache", "url", "Lcom/chartboost/sdk/impl/i2$a;", "callback", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "<init>", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/la;Lcom/chartboost/sdk/impl/i2$a;Lcom/chartboost/sdk/impl/l4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class pa extends i2 {

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final la trackingEventCache;

    /* JADX WARN: Illegal instructions before constructor call */
    public pa(String url, la trackingEventCache, i2.a callback, l4 eventTracker) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(trackingEventCache, "trackingEventCache");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        NetworkHelper networkHelper = NetworkHelper.f1212a;
        super(networkHelper.a(url), networkHelper.b(url), null, k8.NORMAL, callback, eventTracker);
        this.trackingEventCache = trackingEventCache;
        this.checkStatusInResponseBody = false;
    }

    public final Map<String, String> l() {
        return MapsKt.mapOf(TuplesKt.to("Accept", "application/json"), TuplesKt.to("X-Chartboost-Client", n2.b()), TuplesKt.to("X-Chartboost-API", "9.8.3"));
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"com/chartboost/sdk/impl/pa$a", "Lcom/chartboost/sdk/impl/i2$a;", "Lcom/chartboost/sdk/impl/i2;", "request", "Lorg/json/JSONObject;", "response", "", "a", "(Lcom/chartboost/sdk/impl/i2;Lorg/json/JSONObject;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Lcom/chartboost/sdk/impl/i2;Lcom/chartboost/sdk/internal/Model/CBError;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class a implements i2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ la f1108a;

        public a(la laVar) {
            this.f1108a = laVar;
        }

        @Override // com.chartboost.sdk.impl.i2.a
        public void a(i2 request, JSONObject response) {
        }

        @Override // com.chartboost.sdk.impl.i2.a
        public void a(i2 request, CBError error) {
            JSONArray bodyArray;
            b7.a("Request " + (request != null ? request.getUri() : null) + " failed!", (Throwable) null, 2, (Object) null);
            if (request == null || (bodyArray = request.getBodyArray()) == null) {
                return;
            }
            this.f1108a.a(bodyArray);
        }
    }

    @Override // com.chartboost.sdk.impl.i2, com.chartboost.sdk.impl.c2
    public d2 a() {
        Map<String, String> mapL = l();
        JSONArray bodyArray = getBodyArray();
        return new d2(mapL, bodyArray != null ? a2.a(bodyArray) : null, "application/json");
    }

    public /* synthetic */ pa(String str, la laVar, i2.a aVar, l4 l4Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, laVar, (i & 4) != 0 ? new a(laVar) : aVar, l4Var);
    }
}
