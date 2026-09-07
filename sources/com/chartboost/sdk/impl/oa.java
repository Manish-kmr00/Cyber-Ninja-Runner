package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BJ\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012)\b\u0002\u0010\u0019\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR5\u0010\u0019\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/chartboost/sdk/impl/oa;", "", "", "url", "", "Lorg/json/JSONObject;", "events", "", "a", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/chartboost/sdk/impl/g2;", "Lcom/chartboost/sdk/impl/g2;", "networkService", "Lcom/chartboost/sdk/impl/la;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/la;", "trackingEventCache", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "collection", "Lorg/json/JSONArray;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lkotlin/jvm/functions/Function1;", "jsonFactory", "Lcom/chartboost/sdk/impl/l4;", "d", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "<init>", "(Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/la;Lkotlin/jvm/functions/Function1;Lcom/chartboost/sdk/impl/l4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class oa {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g2 networkService;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final la trackingEventCache;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function1<Collection<? extends JSONObject>, JSONArray> jsonFactory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final l4 eventTracker;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Collection, JSONArray> {
        public static final a b = new a();

        public a() {
            super(1, JSONArray.class, "<init>", "<init>(Ljava/util/Collection;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final JSONArray invoke(Collection collection) {
            return new JSONArray(collection);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public oa(g2 networkService, la trackingEventCache, Function1<? super Collection<? extends JSONObject>, ? extends JSONArray> jsonFactory, l4 eventTracker) {
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(trackingEventCache, "trackingEventCache");
        Intrinsics.checkNotNullParameter(jsonFactory, "jsonFactory");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.networkService = networkService;
        this.trackingEventCache = trackingEventCache;
        this.jsonFactory = jsonFactory;
        this.eventTracker = eventTracker;
    }

    public final void a(String url, List<? extends JSONObject> events) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(events, "events");
        pa paVar = new pa(url, this.trackingEventCache, null, this.eventTracker, 4, null);
        paVar.a(this.jsonFactory.invoke(events));
        this.networkService.a(paVar);
    }

    public /* synthetic */ oa(g2 g2Var, la laVar, Function1 function1, l4 l4Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(g2Var, laVar, (i & 4) != 0 ? a.b : function1, l4Var);
    }
}
