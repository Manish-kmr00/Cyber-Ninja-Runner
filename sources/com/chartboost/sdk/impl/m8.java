package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010\u0004R\u0019\u0010%\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\"\u001a\u0004\b$\u0010\u0004R\u0019\u0010&\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010'\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b\f\u0010\u0004¨\u0006*"}, d2 = {"Lcom/chartboost/sdk/impl/m8;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/Integer;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/lang/Integer;", "openRtbConsent", "", "Lcom/chartboost/sdk/privacy/model/DataUseConsent;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "i", "()Ljava/util/List;", "whitelistedPrivacyStandardsList", "e", "openRtbGdpr", "d", "openRtbCoppa", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "g", "()Lorg/json/JSONObject;", "privacyListAsJson", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/lang/String;", "piDataUseConsent", "h", "tcfString", "gppString", "gppSid", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class m8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Integer openRtbConsent;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final List<DataUseConsent> whitelistedPrivacyStandardsList;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Integer openRtbGdpr;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Integer openRtbCoppa;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final JSONObject privacyListAsJson;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final String piDataUseConsent;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final String tcfString;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final String gppString;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final String gppSid;

    public m8() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof m8)) {
            return false;
        }
        m8 m8Var = (m8) other;
        return Intrinsics.areEqual(this.openRtbConsent, m8Var.openRtbConsent) && Intrinsics.areEqual(this.whitelistedPrivacyStandardsList, m8Var.whitelistedPrivacyStandardsList) && Intrinsics.areEqual(this.openRtbGdpr, m8Var.openRtbGdpr) && Intrinsics.areEqual(this.openRtbCoppa, m8Var.openRtbCoppa) && Intrinsics.areEqual(this.privacyListAsJson, m8Var.privacyListAsJson) && Intrinsics.areEqual(this.piDataUseConsent, m8Var.piDataUseConsent) && Intrinsics.areEqual(this.tcfString, m8Var.tcfString) && Intrinsics.areEqual(this.gppString, m8Var.gppString) && Intrinsics.areEqual(this.gppSid, m8Var.gppSid);
    }

    public int hashCode() {
        Integer num = this.openRtbConsent;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<DataUseConsent> list = this.whitelistedPrivacyStandardsList;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.openRtbGdpr;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.openRtbCoppa;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        JSONObject jSONObject = this.privacyListAsJson;
        int iHashCode5 = (iHashCode4 + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        String str = this.piDataUseConsent;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tcfString;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.gppString;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.gppSid;
        return iHashCode8 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "PrivacyBodyFields(openRtbConsent=" + this.openRtbConsent + ", whitelistedPrivacyStandardsList=" + this.whitelistedPrivacyStandardsList + ", openRtbGdpr=" + this.openRtbGdpr + ", openRtbCoppa=" + this.openRtbCoppa + ", privacyListAsJson=" + this.privacyListAsJson + ", piDataUseConsent=" + this.piDataUseConsent + ", tcfString=" + this.tcfString + ", gppString=" + this.gppString + ", gppSid=" + this.gppSid + ')';
    }

    public m8(Integer num, List<DataUseConsent> list, Integer num2, Integer num3, JSONObject jSONObject, String str, String str2, String str3, String str4) {
        this.openRtbConsent = num;
        this.whitelistedPrivacyStandardsList = list;
        this.openRtbGdpr = num2;
        this.openRtbCoppa = num3;
        this.privacyListAsJson = jSONObject;
        this.piDataUseConsent = str;
        this.tcfString = str2;
        this.gppString = str3;
        this.gppSid = str4;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Integer getOpenRtbConsent() {
        return this.openRtbConsent;
    }

    public final List<DataUseConsent> i() {
        return this.whitelistedPrivacyStandardsList;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Integer getOpenRtbGdpr() {
        return this.openRtbGdpr;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final Integer getOpenRtbCoppa() {
        return this.openRtbCoppa;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final JSONObject getPrivacyListAsJson() {
        return this.privacyListAsJson;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getPiDataUseConsent() {
        return this.piDataUseConsent;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getTcfString() {
        return this.tcfString;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getGppString() {
        return this.gppString;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getGppSid() {
        return this.gppSid;
    }

    public /* synthetic */ m8(Integer num, List list, Integer num2, Integer num3, JSONObject jSONObject, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : jSONObject, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : str3, (i & 256) == 0 ? str4 : null);
    }
}
