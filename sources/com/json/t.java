package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0002\u0007\u0013B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u0005\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ironsource/t;", "", "", "", "Lcom/ironsource/t$d;", "a", "Ljava/util/Map;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/util/Map;", sp.c, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/t$d;", "()Lcom/ironsource/t$d;", "features", y2.c, "Lorg/json/JSONObject;", "configurations", "<init>", "(Lorg/json/JSONObject;)V", "d", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class t {
    public static final String e = "capping";
    public static final String f = "pacing";
    public static final String g = "delivery";
    public static final String h = "progressiveLoadingConfig";
    public static final String i = "expiredDurationInMinutes";
    public static final String j = "reward";
    public static final String k = "name";
    public static final String l = "amount";
    public static final String m = "virtualItemName";
    public static final String n = "virtualItemCount";
    public static final long o = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, d> placements;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final d features;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Map<String, d> adUnits;

    /* JADX INFO: renamed from: com.ironsource.t$a, reason: from Kotlin metadata */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lorg/json/JSONObject;", "it", "Lcom/ironsource/t$d;", "a", "(Lorg/json/JSONObject;)Lcom/ironsource/t$d;"}, k = 3, mv = {1, 8, 0})
    static final class JSONObject extends Lambda implements Function1<org.json.JSONObject, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final JSONObject f4435a = new JSONObject();

        JSONObject() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke(org.json.JSONObject it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new d(it);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.t$b, reason: from Kotlin metadata and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lorg/json/JSONObject;", "it", "Lcom/ironsource/t$d;", "a", "(Lorg/json/JSONObject;)Lcom/ironsource/t$d;"}, k = 3, mv = {1, 8, 0})
    static final class C3659b extends Lambda implements Function1<org.json.JSONObject, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3659b f4436a = new C3659b();

        C3659b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke(org.json.JSONObject it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new d(it);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0003\u0010\u0019R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010!\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 ¨\u0006&"}, d2 = {"Lcom/ironsource/t$d;", "", "Lcom/ironsource/h8;", "a", "Lcom/ironsource/h8;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/ironsource/h8;", t.e, "Lcom/ironsource/cp;", "Lcom/ironsource/cp;", "e", "()Lcom/ironsource/cp;", t.f, "Lcom/ironsource/oa;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/oa;", "()Lcom/ironsource/oa;", "delivery", "", "d", "Ljava/lang/Long;", "()Ljava/lang/Long;", t.i, "Lcom/ironsource/gq;", "Lcom/ironsource/gq;", "()Lcom/ironsource/gq;", "adUnitReward", InneractiveMediationDefs.GENDER_FEMALE, "placementReward", "Lcom/ironsource/wp;", "g", "Lcom/ironsource/wp;", "()Lcom/ironsource/wp;", t.h, "Lorg/json/JSONObject;", "features", "<init>", "(Lorg/json/JSONObject;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final h8 capping;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final cp pacing;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final oa delivery;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final Long expiredDurationInMinutes;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private final gq adUnitReward;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private final gq placementReward;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private final wp progressiveLoadingConfig;

        public d(org.json.JSONObject features) throws JSONException {
            h8 h8Var;
            cp cpVar;
            Intrinsics.checkNotNullParameter(features, "features");
            wp wpVar = null;
            if (features.has(t.e)) {
                org.json.JSONObject jSONObject = features.getJSONObject(t.e);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "features.getJSONObject(key)");
                h8Var = new h8(jSONObject);
            } else {
                h8Var = null;
            }
            this.capping = h8Var;
            if (features.has(t.f)) {
                org.json.JSONObject jSONObject2 = features.getJSONObject(t.f);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "features.getJSONObject(key)");
                cpVar = new cp(jSONObject2);
            } else {
                cpVar = null;
            }
            this.pacing = cpVar;
            this.delivery = features.has("delivery") ? new oa(features.getBoolean("delivery")) : null;
            this.expiredDurationInMinutes = features.has(t.i) ? Long.valueOf(features.getLong(t.i)) : null;
            org.json.JSONObject jSONObjectOptJSONObject = features.optJSONObject("reward");
            this.adUnitReward = jSONObjectOptJSONObject != null ? new gq(jSONObjectOptJSONObject, "name", "amount") : null;
            gq gqVar = new gq(features, t.m, t.n);
            String name = gqVar.getName();
            this.placementReward = (name == null || name.length() == 0 || gqVar.getAmount() == null) ? null : gqVar;
            if (features.has(t.h)) {
                org.json.JSONObject jSONObject3 = features.getJSONObject(t.h);
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "features.getJSONObject(key)");
                wpVar = new wp(jSONObject3);
            }
            this.progressiveLoadingConfig = wpVar;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final gq getAdUnitReward() {
            return this.adUnitReward;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final h8 getCapping() {
            return this.capping;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final oa getDelivery() {
            return this.delivery;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final Long getExpiredDurationInMinutes() {
            return this.expiredDurationInMinutes;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final cp getPacing() {
            return this.pacing;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final gq getPlacementReward() {
            return this.placementReward;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final wp getProgressiveLoadingConfig() {
            return this.progressiveLoadingConfig;
        }
    }

    public t(org.json.JSONObject configurations) {
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        this.placements = new sp(configurations).a(C3659b.f4436a);
        this.features = new d(configurations);
        this.adUnits = new y2(configurations).a(JSONObject.f4435a);
    }

    public final Map<String, d> a() {
        return this.adUnits;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final d getFeatures() {
        return this.features;
    }

    public final Map<String, d> c() {
        return this.placements;
    }
}
