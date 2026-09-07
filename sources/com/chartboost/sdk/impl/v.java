package com.chartboost.sdk.impl;

import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.smaato.sdk.video.vast.model.MediaFile;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001BÅ\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020 \u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u0003\u0012\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020100\u0012\b\b\u0002\u00107\u001a\u00020\u0003\u0012\b\b\u0002\u0010;\u001a\u00020\u0003\u0012\b\b\u0002\u0010?\u001a\u00020\u0003\u0012\b\b\u0002\u0010A\u001a\u00020\u0003\u0012\b\b\u0002\u0010D\u001a\u00020\u0003\u0012\b\b\u0002\u0010I\u001a\u00020\n\u0012\b\b\u0002\u0010L\u001a\u00020\u0003\u0012\b\b\u0002\u0010P\u001a\u00020\u0003\u0012\b\b\u0002\u0010U\u001a\u000201\u0012\u0014\b\u0002\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000300\u0012\b\b\u0002\u0010\\\u001a\u00020X\u0012\u000e\b\u0002\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00030]\u0012\u001a\b\u0002\u0010b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030]00\u0012\b\b\u0002\u0010c\u001a\u00020\u0003\u0012\b\b\u0002\u0010e\u001a\u00020\u0003\u0012\b\b\u0002\u0010i\u001a\u00020f\u0012\b\b\u0002\u0010m\u001a\u00020j\u0012\b\b\u0002\u0010n\u001a\u00020\u0003¢\u0006\u0004\bs\u0010tJ\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0017\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0007R\"\u0010\u001f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u0015R\u0017\u0010$\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b\u001a\u0010!\u001a\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\u0015R\"\u0010+\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0012\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\u0015R\"\u0010/\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\u0015R#\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000201008\u0006¢\u0006\f\n\u0004\b)\u00102\u001a\u0004\b\u001c\u0010\u0005R\"\u00107\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0012\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\u0015R\"\u0010;\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0012\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010\u0015R\"\u0010?\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0012\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\u0015R\"\u0010A\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b8\u0010\u0007\"\u0004\b@\u0010\u0015R\"\u0010D\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0012\u001a\u0004\bB\u0010\u0007\"\u0004\bC\u0010\u0015R\"\u0010I\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010E\u001a\u0004\bF\u0010\f\"\u0004\bG\u0010HR\"\u0010L\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0012\u001a\u0004\bJ\u0010\u0007\"\u0004\bK\u0010\u0015R\"\u0010P\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010\u0012\u001a\u0004\bN\u0010\u0007\"\u0004\bO\u0010\u0015R\"\u0010U\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010Q\u001a\u0004\b%\u0010R\"\u0004\bS\u0010TR#\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003008\u0006¢\u0006\f\n\u0004\bV\u00102\u001a\u0004\bV\u0010\u0005R\u0017\u0010\\\u001a\u00020X8\u0006¢\u0006\f\n\u0004\b\b\u0010Y\u001a\u0004\bZ\u0010[R\u001d\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00030]8\u0006¢\u0006\f\n\u0004\bZ\u0010^\u001a\u0004\b_\u0010`R)\u0010b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030]008\u0006¢\u0006\f\n\u0004\bF\u00102\u001a\u0004\b<\u0010\u0005R\u0017\u0010c\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bJ\u0010\u0012\u001a\u0004\b\u0019\u0010\u0007R\u0017\u0010e\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b_\u0010\u0012\u001a\u0004\bd\u0010\u0007R\u0017\u0010i\u001a\u00020f8\u0006¢\u0006\f\n\u0004\bN\u0010g\u001a\u0004\bM\u0010hR\u0017\u0010m\u001a\u00020j8\u0006¢\u0006\f\n\u0004\bd\u0010k\u001a\u0004\b,\u0010lR\u0017\u0010n\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bB\u0010\u0012\u001a\u0004\b4\u0010\u0007R\u0017\u0010r\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b9\u0010o\u001a\u0004\bp\u0010q¨\u0006u"}, d2 = {"Lcom/chartboost/sdk/impl/v;", "", "", "", ExifInterface.LONGITUDE_EAST, "()Ljava/util/Map;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "r", "setName", "(Ljava/lang/String;)V", "name", "setAdId", "adId", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "e", "baseUrl", "d", "m", "setImpressionId", "impressionId", "Lcom/chartboost/sdk/impl/s6;", "Lcom/chartboost/sdk/impl/s6;", "n", "()Lcom/chartboost/sdk/impl/s6;", "infoIcon", InneractiveMediationDefs.GENDER_FEMALE, "g", "setCgn", "cgn", "i", "setCreative", Reporting.Key.CREATIVE, "h", "p", "setMediaType", MediaFile.MEDIA_TYPE, "", "Lcom/chartboost/sdk/impl/c1;", "Ljava/util/Map;", POBNativeConstants.NATIVE_ASSETS, "j", "C", "setVideoUrl", UnifiedMediationParams.KEY_VIDEO_URL, CampaignEx.JSON_KEY_AD_K, "B", "setVideoFilename", "videoFilename", "l", "o", "setLink", "link", "setDeepLink", SDKConstants.PARAM_DEEP_LINK, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setTo", "to", "I", "v", "setRewardAmount", "(I)V", IronSourceConstants.EVENTS_REWARD_AMOUNT, "w", "setRewardCurrency", "rewardCurrency", CampaignEx.JSON_KEY_AD_Q, VastAttributes.VERTICAL_POSITION, "setTemplate", "template", "Lcom/chartboost/sdk/impl/c1;", "()Lcom/chartboost/sdk/impl/c1;", "setBody", "(Lcom/chartboost/sdk/impl/c1;)V", "body", "s", "parameters", "Lcom/chartboost/sdk/impl/b9;", "Lcom/chartboost/sdk/impl/b9;", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "()Lcom/chartboost/sdk/impl/b9;", "renderingEngine", "", "Ljava/util/List;", VastAttributes.HORIZONTAL_POSITION, "()Ljava/util/List;", "scripts", "events", "adm", "z", "templateParams", "Lcom/chartboost/sdk/impl/d7;", "Lcom/chartboost/sdk/impl/d7;", "()Lcom/chartboost/sdk/impl/d7;", "mtype", "Lcom/chartboost/sdk/impl/b3;", "Lcom/chartboost/sdk/impl/b3;", "()Lcom/chartboost/sdk/impl/b3;", "clkp", "decodedAdm", "Z", "D", "()Z", "isPrecacheVideoAd", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/s6;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/c1;Ljava/util/Map;Lcom/chartboost/sdk/impl/b9;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/d7;Lcom/chartboost/sdk/impl/b3;Ljava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class v {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final String decodedAdm;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public final boolean isPrecacheVideoAd;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public String name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String adId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String baseUrl;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public String impressionId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final s6 infoIcon;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public String cgn;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public String creative;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public String mediaType;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Map<String, c1> assets;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public String videoUrl;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public String videoFilename;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public String link;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public String deepLink;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public String to;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int rewardAmount;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public String rewardCurrency;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public String template;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public c1 body;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public final Map<String, String> parameters;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final b9 renderingEngine;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public final List<String> scripts;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public final Map<String, List<String>> events;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public final String adm;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public final String templateParams;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public final d7 mtype;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public final b3 clkp;

    public v() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof v)) {
            return false;
        }
        v vVar = (v) other;
        return Intrinsics.areEqual(this.name, vVar.name) && Intrinsics.areEqual(this.adId, vVar.adId) && Intrinsics.areEqual(this.baseUrl, vVar.baseUrl) && Intrinsics.areEqual(this.impressionId, vVar.impressionId) && Intrinsics.areEqual(this.infoIcon, vVar.infoIcon) && Intrinsics.areEqual(this.cgn, vVar.cgn) && Intrinsics.areEqual(this.creative, vVar.creative) && Intrinsics.areEqual(this.mediaType, vVar.mediaType) && Intrinsics.areEqual(this.assets, vVar.assets) && Intrinsics.areEqual(this.videoUrl, vVar.videoUrl) && Intrinsics.areEqual(this.videoFilename, vVar.videoFilename) && Intrinsics.areEqual(this.link, vVar.link) && Intrinsics.areEqual(this.deepLink, vVar.deepLink) && Intrinsics.areEqual(this.to, vVar.to) && this.rewardAmount == vVar.rewardAmount && Intrinsics.areEqual(this.rewardCurrency, vVar.rewardCurrency) && Intrinsics.areEqual(this.template, vVar.template) && Intrinsics.areEqual(this.body, vVar.body) && Intrinsics.areEqual(this.parameters, vVar.parameters) && this.renderingEngine == vVar.renderingEngine && Intrinsics.areEqual(this.scripts, vVar.scripts) && Intrinsics.areEqual(this.events, vVar.events) && Intrinsics.areEqual(this.adm, vVar.adm) && Intrinsics.areEqual(this.templateParams, vVar.templateParams) && this.mtype == vVar.mtype && this.clkp == vVar.clkp && Intrinsics.areEqual(this.decodedAdm, vVar.decodedAdm);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((this.name.hashCode() * 31) + this.adId.hashCode()) * 31) + this.baseUrl.hashCode()) * 31) + this.impressionId.hashCode()) * 31) + this.infoIcon.hashCode()) * 31) + this.cgn.hashCode()) * 31) + this.creative.hashCode()) * 31) + this.mediaType.hashCode()) * 31) + this.assets.hashCode()) * 31) + this.videoUrl.hashCode()) * 31) + this.videoFilename.hashCode()) * 31) + this.link.hashCode()) * 31) + this.deepLink.hashCode()) * 31) + this.to.hashCode()) * 31) + Integer.hashCode(this.rewardAmount)) * 31) + this.rewardCurrency.hashCode()) * 31) + this.template.hashCode()) * 31) + this.body.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.renderingEngine.hashCode()) * 31) + this.scripts.hashCode()) * 31) + this.events.hashCode()) * 31) + this.adm.hashCode()) * 31) + this.templateParams.hashCode()) * 31) + this.mtype.hashCode()) * 31) + this.clkp.hashCode()) * 31) + this.decodedAdm.hashCode();
    }

    public final String t() {
        JSONObject getParametersAsString$lambda$1$lambda$0 = z1.a(new z1.a[0]);
        for (Map.Entry<String, String> entry : E().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(getParametersAsString$lambda$1$lambda$0, "getParametersAsString$lambda$1$lambda$0");
            a2.a(getParametersAsString$lambda$1$lambda$0, key, value);
        }
        String string = getParametersAsString$lambda$1$lambda$0.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject().apply {\n   …e) }\n        }.toString()");
        return string;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AdUnit(name=");
        sb.append(this.name).append(", adId=").append(this.adId).append(", baseUrl=").append(this.baseUrl).append(", impressionId=").append(this.impressionId).append(", infoIcon=").append(this.infoIcon).append(", cgn=").append(this.cgn).append(", creative=").append(this.creative).append(", mediaType=").append(this.mediaType).append(", assets=").append(this.assets).append(", videoUrl=").append(this.videoUrl).append(", videoFilename=").append(this.videoFilename).append(", link=");
        sb.append(this.link).append(", deepLink=").append(this.deepLink).append(", to=").append(this.to).append(", rewardAmount=").append(this.rewardAmount).append(", rewardCurrency=").append(this.rewardCurrency).append(", template=").append(this.template).append(", body=").append(this.body).append(", parameters=").append(this.parameters).append(", renderingEngine=").append(this.renderingEngine).append(", scripts=").append(this.scripts).append(", events=").append(this.events).append(", adm=").append(this.adm);
        sb.append(", templateParams=").append(this.templateParams).append(", mtype=").append(this.mtype).append(", clkp=").append(this.clkp).append(", decodedAdm=").append(this.decodedAdm).append(')');
        return sb.toString();
    }

    public v(String name, String adId, String baseUrl, String impressionId, s6 infoIcon, String cgn, String creative, String mediaType, Map<String, c1> assets, String videoUrl, String videoFilename, String link, String deepLink, String to, int i, String rewardCurrency, String template, c1 body, Map<String, String> parameters, b9 renderingEngine, List<String> scripts, Map<String, List<String>> events, String adm, String templateParams, d7 mtype, b3 clkp, String decodedAdm) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(infoIcon, "infoIcon");
        Intrinsics.checkNotNullParameter(cgn, "cgn");
        Intrinsics.checkNotNullParameter(creative, "creative");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        Intrinsics.checkNotNullParameter(videoFilename, "videoFilename");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(rewardCurrency, "rewardCurrency");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(renderingEngine, "renderingEngine");
        Intrinsics.checkNotNullParameter(scripts, "scripts");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(templateParams, "templateParams");
        Intrinsics.checkNotNullParameter(mtype, "mtype");
        Intrinsics.checkNotNullParameter(clkp, "clkp");
        Intrinsics.checkNotNullParameter(decodedAdm, "decodedAdm");
        this.name = name;
        this.adId = adId;
        this.baseUrl = baseUrl;
        this.impressionId = impressionId;
        this.infoIcon = infoIcon;
        this.cgn = cgn;
        this.creative = creative;
        this.mediaType = mediaType;
        this.assets = assets;
        this.videoUrl = videoUrl;
        this.videoFilename = videoFilename;
        this.link = link;
        this.deepLink = deepLink;
        this.to = to;
        this.rewardAmount = i;
        this.rewardCurrency = rewardCurrency;
        this.template = template;
        this.body = body;
        this.parameters = parameters;
        this.renderingEngine = renderingEngine;
        this.scripts = scripts;
        this.events = events;
        this.adm = adm;
        this.templateParams = templateParams;
        this.mtype = mtype;
        this.clkp = clkp;
        this.decodedAdm = decodedAdm;
        this.isPrecacheVideoAd = videoUrl.length() > 0 && this.videoFilename.length() > 0;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final String getImpressionId() {
        return this.impressionId;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final s6 getInfoIcon() {
        return this.infoIcon;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getCgn() {
        return this.cgn;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getCreative() {
        return this.creative;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final String getMediaType() {
        return this.mediaType;
    }

    public final Map<String, c1> d() {
        return this.assets;
    }

    /* JADX INFO: renamed from: C, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* JADX INFO: renamed from: B, reason: from getter */
    public final String getVideoFilename() {
        return this.videoFilename;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getDeepLink() {
        return this.deepLink;
    }

    /* JADX INFO: renamed from: A, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    /* JADX INFO: renamed from: v, reason: from getter */
    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    /* JADX INFO: renamed from: w, reason: from getter */
    public final String getRewardCurrency() {
        return this.rewardCurrency;
    }

    /* JADX INFO: renamed from: y, reason: from getter */
    public final String getTemplate() {
        return this.template;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final c1 getBody() {
        return this.body;
    }

    public final Map<String, String> s() {
        return this.parameters;
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    public final b9 getRenderingEngine() {
        return this.renderingEngine;
    }

    public final List<String> x() {
        return this.scripts;
    }

    public final Map<String, List<String>> l() {
        return this.events;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getAdm() {
        return this.adm;
    }

    /* JADX INFO: renamed from: z, reason: from getter */
    public final String getTemplateParams() {
        return this.templateParams;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final d7 getMtype() {
        return this.mtype;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final b3 getClkp() {
        return this.clkp;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getDecodedAdm() {
        return this.decodedAdm;
    }

    /* JADX INFO: renamed from: D, reason: from getter */
    public final boolean getIsPrecacheVideoAd() {
        return this.isPrecacheVideoAd;
    }

    public /* synthetic */ v(String str, String str2, String str3, String str4, s6 s6Var, String str5, String str6, String str7, Map map, String str8, String str9, String str10, String str11, String str12, int i, String str13, String str14, c1 c1Var, Map map2, b9 b9Var, List list, Map map3, String str15, String str16, d7 d7Var, b3 b3Var, String str17, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        s6 s6Var2;
        String str18 = (i2 & 1) != 0 ? "" : str;
        String str19 = (i2 & 2) != 0 ? "" : str2;
        String str20 = (i2 & 4) != 0 ? "https://live.chartboost.com" : str3;
        String str21 = (i2 & 8) != 0 ? "" : str4;
        if ((i2 & 16) != 0) {
            s6Var2 = new s6(null, null, null, null, null, null, 63, null);
        } else {
            s6Var2 = s6Var;
        }
        this(str18, str19, str20, str21, s6Var2, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) != 0 ? new HashMap() : map, (i2 & 512) != 0 ? "" : str8, (i2 & 1024) != 0 ? "" : str9, (i2 & 2048) != 0 ? "" : str10, (i2 & 4096) != 0 ? "" : str11, (i2 & 8192) != 0 ? "" : str12, (i2 & 16384) != 0 ? 0 : i, (i2 & 32768) != 0 ? "" : str13, (i2 & 65536) != 0 ? "" : str14, (i2 & 131072) != 0 ? new c1("", "", "") : c1Var, (i2 & 262144) != 0 ? new HashMap() : map2, (i2 & 524288) != 0 ? b9.UNKNOWN : b9Var, (i2 & 1048576) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2097152) != 0 ? new HashMap() : map3, (i2 & 4194304) != 0 ? "" : str15, (i2 & 8388608) != 0 ? "" : str16, (i2 & 16777216) != 0 ? d7.UNKNOWN : d7Var, (i2 & 33554432) != 0 ? b3.CLICK_PREFERENCE_EMBEDDED : b3Var, (i2 & 67108864) == 0 ? str17 : "");
    }

    public final String b() {
        if (this.decodedAdm.length() == 0) {
            return "";
        }
        if (StringsKt.contains((CharSequence) this.decodedAdm, (CharSequence) "<VAST ", true)) {
            return "Wrapper";
        }
        return "Inline";
    }

    public final Map<String, String> E() {
        Map<String, String> map = this.parameters;
        Map<String, c1> map2 = this.assets;
        ArrayList arrayList = new ArrayList(map2.size());
        for (Map.Entry<String, c1> entry : map2.entrySet()) {
            String key = entry.getKey();
            c1 value = entry.getValue();
            arrayList.add(TuplesKt.to(key, value.f983a + '/' + value.b));
        }
        return MapsKt.plus(map, arrayList);
    }
}
