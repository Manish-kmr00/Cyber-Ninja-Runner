package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import bolts.MeasurementEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B<\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012#\b\u0002\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100 ¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\rJ)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\u0011J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0005\u0010\u0012J\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0005\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001eR/\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/chartboost/sdk/impl/la;", "", "Lorg/json/JSONArray;", "jsonArray", "", "a", "(Lorg/json/JSONArray;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "Lcom/chartboost/sdk/impl/i4;", "environmentData", "", "persistenceMaxEvents", "(Lcom/chartboost/sdk/impl/ka;Lcom/chartboost/sdk/impl/i4;I)V", "", "events", "Lorg/json/JSONObject;", "(Ljava/util/List;Lcom/chartboost/sdk/impl/i4;)Ljava/util/List;", "()Ljava/util/List;", "(Lcom/chartboost/sdk/impl/ka;Lcom/chartboost/sdk/impl/i4;)V", "(Lcom/chartboost/sdk/impl/ka;)V", "json", "", "(Lorg/json/JSONObject;)Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/impl/ka;)Ljava/lang/String;", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Lcom/chartboost/sdk/impl/ha;", "Lcom/chartboost/sdk/impl/ha;", "trackingBodyBuilder", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lkotlin/jvm/functions/Function1;", "jsonFactory", "<init>", "(Landroid/content/SharedPreferences;Lcom/chartboost/sdk/impl/ha;Lkotlin/jvm/functions/Function1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class la {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final ha trackingBodyBuilder;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function1<String, JSONObject> jsonFactory;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lorg/json/JSONObject;", "a", "(Ljava/lang/String;)Lorg/json/JSONObject;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<String, JSONObject> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final JSONObject invoke(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new JSONObject(it);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public la(SharedPreferences sharedPreferences, ha trackingBodyBuilder, Function1<? super String, ? extends JSONObject> jsonFactory) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(trackingBodyBuilder, "trackingBodyBuilder");
        Intrinsics.checkNotNullParameter(jsonFactory, "jsonFactory");
        this.sharedPreferences = sharedPreferences;
        this.trackingBodyBuilder = trackingBodyBuilder;
        this.jsonFactory = jsonFactory;
    }

    public final void a(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        try {
            for (JSONObject jSONObject : b5.asList(jsonArray)) {
                this.sharedPreferences.edit().putString(a(jSONObject), jSONObject.toString()).apply();
            }
        } catch (Exception e) {
            b7.a("cacheEventToTrackingRequestBodyAndSave error " + e, (Throwable) null, 2, (Object) null);
        }
    }

    public final String b(ka event) {
        return event.getName().getValue() + event.getTimestamp();
    }

    public /* synthetic */ la(SharedPreferences sharedPreferences, ha haVar, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, haVar, (i & 4) != 0 ? a.b : function1);
    }

    public final void a(ka event, i4 environmentData, int persistenceMaxEvents) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(environmentData, "environmentData");
        if (this.sharedPreferences.getAll().size() > persistenceMaxEvents) {
            b7.a("Persistence limit reached. Drop old events!", (Throwable) null, 2, (Object) null);
            this.sharedPreferences.edit().clear().apply();
        }
        try {
            this.sharedPreferences.edit().putString(b(event), this.trackingBodyBuilder.a(event, environmentData)).apply();
        } catch (Exception e) {
            b7.a("cacheEventToTrackingRequestBodyAndSave error " + e, (Throwable) null, 2, (Object) null);
        }
    }

    public final void a(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            b7.a("clearEventFromStorage: " + event.getName().getValue(), (Throwable) null, 2, (Object) null);
            this.sharedPreferences.edit().remove(event.getName().getValue()).apply();
        } catch (Exception e) {
            b7.a("clearEventFromStorage error " + e, (Throwable) null, 2, (Object) null);
        }
    }

    public final List<JSONObject> a(List<? extends ka> events, i4 environmentData) {
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(environmentData, "environmentData");
        try {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(events, 10));
            Iterator<T> it = events.iterator();
            while (it.hasNext()) {
                arrayList.add(this.jsonFactory.invoke(this.trackingBodyBuilder.a((ka) it.next(), environmentData)));
            }
            return arrayList;
        } catch (Exception e) {
            b7.a("cacheEventToTrackingRequestBody error " + e, (Throwable) null, 2, (Object) null);
            return CollectionsKt.emptyList();
        }
    }

    public final void a(ka event, i4 environmentData) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(environmentData, "environmentData");
        try {
            b7.a("forcePersistEvent: " + event.getName().getValue(), (Throwable) null, 2, (Object) null);
            this.sharedPreferences.edit().putString(event.getName().getValue(), this.trackingBodyBuilder.a(event, environmentData)).apply();
        } catch (Exception e) {
            b7.a("forcePersistEvent error " + e, (Throwable) null, 2, (Object) null);
        }
    }

    public final List<JSONObject> a() {
        try {
            List list = CollectionsKt.toList(this.sharedPreferences.getAll().values());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectInvoke = this.jsonFactory.invoke(String.valueOf(it.next()));
                JSONObject jSONObject = jSONObjectInvoke;
                this.sharedPreferences.edit().clear().apply();
                arrayList.add(jSONObjectInvoke);
            }
            return arrayList;
        } catch (Exception e) {
            b7.a("loadEventsAsJsonList error " + e, (Throwable) null, 2, (Object) null);
            return CollectionsKt.emptyList();
        }
    }

    public final String a(JSONObject json) {
        return json.getString(MeasurementEvent.MEASUREMENT_EVENT_NAME_KEY) + json.getLong("event_timestamp");
    }
}
