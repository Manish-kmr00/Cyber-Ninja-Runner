package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.smaato.sdk.video.vast.model.Ad;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.unified.UnifiedMediationParams;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0004\u0007\u0010\u0015\u0019B\u000f\u0012\u0006\u0010+\u001a\u00020)¢\u0006\u0004\b,\u0010-J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0007\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u000eJ\u0013\u0010\u0007\u001a\u00020\n*\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0007\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0007\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00140\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0010\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0002¢\u0006\u0004\b\u0010\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0007\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u001eJ\u001f\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u0007\u0010\u001fJ3\u0010\u0007\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0007\u0010\"J\u0017\u0010\u0015\u001a\u00020$2\u0006\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010%J\u0017\u0010\u0010\u001a\u00020'2\u0006\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010(R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010*¨\u0006."}, d2 = {"Lcom/chartboost/sdk/impl/x7;", "", "Lcom/chartboost/sdk/impl/u;", Ad.AD_TYPE, "Lorg/json/JSONObject;", "response", "Lcom/chartboost/sdk/impl/v;", "a", "(Lcom/chartboost/sdk/impl/u;Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/v;", "", "", "Lcom/chartboost/sdk/impl/x7$a;", "bid", "", "(Ljava/util/Map;Lcom/chartboost/sdk/impl/x7$a;Lcom/chartboost/sdk/impl/u;)V", "(Lcom/chartboost/sdk/impl/u;)Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "Lcom/chartboost/sdk/impl/c1;", "(Ljava/util/List;)Lcom/chartboost/sdk/impl/c1;", "Lcom/chartboost/sdk/impl/x7$d;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Ljava/util/List;)Lcom/chartboost/sdk/impl/x7$d;", "(Ljava/util/List;)Lcom/chartboost/sdk/impl/x7$a;", "Lcom/chartboost/sdk/impl/x7$c;", "d", "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/x7$c;", "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/c1;", "ext", "Lcom/chartboost/sdk/impl/x7$b;", "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/x7$b;", "(Lorg/json/JSONObject;Lcom/chartboost/sdk/impl/x7$b;)Lcom/chartboost/sdk/impl/x7$a;", "seatbid", POBNativeConstants.NATIVE_ASSETS, "(Lorg/json/JSONObject;Ljava/util/List;Ljava/util/List;)Lcom/chartboost/sdk/impl/x7$c;", "sizedouble", "Lcom/chartboost/sdk/impl/s6$a;", "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/s6$a;", "infoIcon", "Lcom/chartboost/sdk/impl/s6;", "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/s6;", "Lcom/chartboost/sdk/impl/n1;", "Lcom/chartboost/sdk/impl/n1;", "base64Wrapper", "<init>", "(Lcom/chartboost/sdk/impl/n1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class x7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final n1 base64Wrapper;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010(\u001a\u00020$¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u0004R\u0017\u0010\u001e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u0004R\u0017\u0010 \u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\f\u0010\u0004R\u0017\u0010#\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010(\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\u0010\u0010'¨\u0006+"}, d2 = {"Lcom/chartboost/sdk/impl/x7$a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getId", "id", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getImpid", POBConstants.KEY_IMPRESSION_ID, "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "D", "getPrice", "()D", "price", "d", "getBurl", com.json.m5.y, "e", "getCrid", "crid", InneractiveMediationDefs.GENDER_FEMALE, "adm", "g", "I", "mtype", "Lcom/chartboost/sdk/impl/x7$b;", "h", "Lcom/chartboost/sdk/impl/x7$b;", "()Lcom/chartboost/sdk/impl/x7$b;", "ext", "<init>", "(Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/chartboost/sdk/impl/x7$b;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String id;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final String impid;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final double price;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public final String burl;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public final String crid;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public final String adm;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public final int mtype;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public final b ext;

        public a() {
            this(null, null, 0.0d, null, null, null, 0, null, 255, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Intrinsics.areEqual(this.id, aVar.id) && Intrinsics.areEqual(this.impid, aVar.impid) && Double.compare(this.price, aVar.price) == 0 && Intrinsics.areEqual(this.burl, aVar.burl) && Intrinsics.areEqual(this.crid, aVar.crid) && Intrinsics.areEqual(this.adm, aVar.adm) && this.mtype == aVar.mtype && Intrinsics.areEqual(this.ext, aVar.ext);
        }

        public int hashCode() {
            return (((((((((((((this.id.hashCode() * 31) + this.impid.hashCode()) * 31) + Double.hashCode(this.price)) * 31) + this.burl.hashCode()) * 31) + this.crid.hashCode()) * 31) + this.adm.hashCode()) * 31) + Integer.hashCode(this.mtype)) * 31) + this.ext.hashCode();
        }

        public String toString() {
            return "BidModel(id=" + this.id + ", impid=" + this.impid + ", price=" + this.price + ", burl=" + this.burl + ", crid=" + this.crid + ", adm=" + this.adm + ", mtype=" + this.mtype + ", ext=" + this.ext + ')';
        }

        public a(String id, String impid, double d, String burl, String crid, String adm, int i, b ext) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(impid, "impid");
            Intrinsics.checkNotNullParameter(burl, "burl");
            Intrinsics.checkNotNullParameter(crid, "crid");
            Intrinsics.checkNotNullParameter(adm, "adm");
            Intrinsics.checkNotNullParameter(ext, "ext");
            this.id = id;
            this.impid = impid;
            this.price = d;
            this.burl = burl;
            this.crid = crid;
            this.adm = adm;
            this.mtype = i;
            this.ext = ext;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getAdm() {
            return this.adm;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final int getMtype() {
            return this.mtype;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final b getExt() {
            return this.ext;
        }

        public /* synthetic */ a(String str, String str2, double d, String str3, String str4, String str5, int i, b bVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0.0d : d, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) == 0 ? str5 : "", (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? new b(null, null, null, null, null, null, null, null, 0, null, null, null, null, 8191, null) : bVar);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020'\u0012\b\b\u0002\u0010/\u001a\u00020,\u0012\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\f\u0010\u0004R\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0017\u0010\u0004R\u0017\u0010\u001a\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0019\u0010\u0004R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u0004R\u0017\u0010$\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b!\u0010#\u001a\u0004\b\u0015\u0010\u0007R\u0017\u0010&\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u0017\u0010+\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b \u0010*R\u0017\u0010/\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b%\u0010.R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b(\u0010\u001e¨\u00063"}, d2 = {"Lcom/chartboost/sdk/impl/x7$b;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "impressionid", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "e", "crtype", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "adId", "d", "cgn", "l", "template", "m", UnifiedMediationParams.KEY_VIDEO_URL, "", "g", "Ljava/util/List;", "()Ljava/util/List;", POBNativeConstants.NATIVE_IMPRESSION_TRACKER, "h", "i", "params", "I", "clkp", "j", "baseUrl", "Lcom/chartboost/sdk/impl/s6;", CampaignEx.JSON_KEY_AD_K, "Lcom/chartboost/sdk/impl/s6;", "()Lcom/chartboost/sdk/impl/s6;", "infoIcon", "Lcom/chartboost/sdk/impl/b9;", "Lcom/chartboost/sdk/impl/b9;", "()Lcom/chartboost/sdk/impl/b9;", "renderEngine", "scripts", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Lcom/chartboost/sdk/impl/s6;Lcom/chartboost/sdk/impl/b9;Ljava/util/List;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String impressionid;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final String crtype;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final String adId;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public final String cgn;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public final String template;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public final String videoUrl;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public final List<String> imptrackers;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public final String params;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        public final int clkp;

        /* JADX INFO: renamed from: j, reason: from kotlin metadata */
        public final String baseUrl;

        /* JADX INFO: renamed from: k, reason: from kotlin metadata */
        public final s6 infoIcon;

        /* JADX INFO: renamed from: l, reason: from kotlin metadata */
        public final b9 renderEngine;

        /* JADX INFO: renamed from: m, reason: from kotlin metadata */
        public final List<String> scripts;

        public b() {
            this(null, null, null, null, null, null, null, null, 0, null, null, null, null, 8191, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            return Intrinsics.areEqual(this.impressionid, bVar.impressionid) && Intrinsics.areEqual(this.crtype, bVar.crtype) && Intrinsics.areEqual(this.adId, bVar.adId) && Intrinsics.areEqual(this.cgn, bVar.cgn) && Intrinsics.areEqual(this.template, bVar.template) && Intrinsics.areEqual(this.videoUrl, bVar.videoUrl) && Intrinsics.areEqual(this.imptrackers, bVar.imptrackers) && Intrinsics.areEqual(this.params, bVar.params) && this.clkp == bVar.clkp && Intrinsics.areEqual(this.baseUrl, bVar.baseUrl) && Intrinsics.areEqual(this.infoIcon, bVar.infoIcon) && this.renderEngine == bVar.renderEngine && Intrinsics.areEqual(this.scripts, bVar.scripts);
        }

        public int hashCode() {
            return (((((((((((((((((((((((this.impressionid.hashCode() * 31) + this.crtype.hashCode()) * 31) + this.adId.hashCode()) * 31) + this.cgn.hashCode()) * 31) + this.template.hashCode()) * 31) + this.videoUrl.hashCode()) * 31) + this.imptrackers.hashCode()) * 31) + this.params.hashCode()) * 31) + Integer.hashCode(this.clkp)) * 31) + this.baseUrl.hashCode()) * 31) + this.infoIcon.hashCode()) * 31) + this.renderEngine.hashCode()) * 31) + this.scripts.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ExtensionModel(impressionid=");
            sb.append(this.impressionid).append(", crtype=").append(this.crtype).append(", adId=").append(this.adId).append(", cgn=").append(this.cgn).append(", template=").append(this.template).append(", videoUrl=").append(this.videoUrl).append(", imptrackers=").append(this.imptrackers).append(", params=").append(this.params).append(", clkp=").append(this.clkp).append(", baseUrl=").append(this.baseUrl).append(", infoIcon=").append(this.infoIcon).append(", renderEngine=");
            sb.append(this.renderEngine).append(", scripts=").append(this.scripts).append(')');
            return sb.toString();
        }

        public b(String impressionid, String crtype, String adId, String cgn, String template, String videoUrl, List<String> imptrackers, String params, int i, String baseUrl, s6 infoIcon, b9 renderEngine, List<String> scripts) {
            Intrinsics.checkNotNullParameter(impressionid, "impressionid");
            Intrinsics.checkNotNullParameter(crtype, "crtype");
            Intrinsics.checkNotNullParameter(adId, "adId");
            Intrinsics.checkNotNullParameter(cgn, "cgn");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
            Intrinsics.checkNotNullParameter(imptrackers, "imptrackers");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            Intrinsics.checkNotNullParameter(infoIcon, "infoIcon");
            Intrinsics.checkNotNullParameter(renderEngine, "renderEngine");
            Intrinsics.checkNotNullParameter(scripts, "scripts");
            this.impressionid = impressionid;
            this.crtype = crtype;
            this.adId = adId;
            this.cgn = cgn;
            this.template = template;
            this.videoUrl = videoUrl;
            this.imptrackers = imptrackers;
            this.params = params;
            this.clkp = i;
            this.baseUrl = baseUrl;
            this.infoIcon = infoIcon;
            this.renderEngine = renderEngine;
            this.scripts = scripts;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final String getImpressionid() {
            return this.impressionid;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final String getCrtype() {
            return this.crtype;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getAdId() {
            return this.adId;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getCgn() {
            return this.cgn;
        }

        /* JADX INFO: renamed from: l, reason: from getter */
        public final String getTemplate() {
            return this.template;
        }

        /* JADX INFO: renamed from: m, reason: from getter */
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        public final List<String> g() {
            return this.imptrackers;
        }

        /* JADX INFO: renamed from: i, reason: from getter */
        public final String getParams() {
            return this.params;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final int getClkp() {
            return this.clkp;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getBaseUrl() {
            return this.baseUrl;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final s6 getInfoIcon() {
            return this.infoIcon;
        }

        /* JADX INFO: renamed from: j, reason: from getter */
        public final b9 getRenderEngine() {
            return this.renderEngine;
        }

        public final List<String> k() {
            return this.scripts;
        }

        public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, int i, String str8, s6 s6Var, b9 b9Var, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? CollectionsKt.emptyList() : list, (i2 & 128) == 0 ? str7 : "", (i2 & 256) != 0 ? b3.CLICK_PREFERENCE_EMBEDDED.getValue() : i, (i2 & 512) != 0 ? "https://live.chartboost.com" : str8, (i2 & 1024) != 0 ? new s6(null, null, null, null, null, null, 63, null) : s6Var, (i2 & 2048) != 0 ? b9.UNKNOWN : b9Var, (i2 & 4096) != 0 ? CollectionsKt.emptyList() : list2);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u001e¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0010R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0010R(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u0016\u0010\"\"\u0004\b#\u0010$R(\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b\f\u0010\"\"\u0004\b(\u0010$R\u001d\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0*8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010+¨\u0006/"}, d2 = {"Lcom/chartboost/sdk/impl/x7$c;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "id", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getNbr", "setNbr", "nbr", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "getCurrency", "setCurrency", "currency", "d", "getBidId", "setBidId", "bidId", "", "Lcom/chartboost/sdk/impl/x7$d;", "e", "Ljava/util/List;", "()Ljava/util/List;", "setSeatbidList", "(Ljava/util/List;)V", "seatbidList", "Lcom/chartboost/sdk/impl/c1;", InneractiveMediationDefs.GENDER_FEMALE, "setAssets", POBNativeConstants.NATIVE_ASSETS, "", "()Ljava/util/Map;", "assetsAsMap", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public String id;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public String nbr;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public String currency;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public String bidId;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public List<d> seatbidList;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public List<? extends c1> assets;

        public c() {
            this(null, null, null, null, null, null, 63, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            return Intrinsics.areEqual(this.id, cVar.id) && Intrinsics.areEqual(this.nbr, cVar.nbr) && Intrinsics.areEqual(this.currency, cVar.currency) && Intrinsics.areEqual(this.bidId, cVar.bidId) && Intrinsics.areEqual(this.seatbidList, cVar.seatbidList) && Intrinsics.areEqual(this.assets, cVar.assets);
        }

        public int hashCode() {
            return (((((((((this.id.hashCode() * 31) + this.nbr.hashCode()) * 31) + this.currency.hashCode()) * 31) + this.bidId.hashCode()) * 31) + this.seatbidList.hashCode()) * 31) + this.assets.hashCode();
        }

        public String toString() {
            return "OpenRTBModel(id=" + this.id + ", nbr=" + this.nbr + ", currency=" + this.currency + ", bidId=" + this.bidId + ", seatbidList=" + this.seatbidList + ", assets=" + this.assets + ')';
        }

        public c(String id, String nbr, String currency, String bidId, List<d> seatbidList, List<? extends c1> assets) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(nbr, "nbr");
            Intrinsics.checkNotNullParameter(currency, "currency");
            Intrinsics.checkNotNullParameter(bidId, "bidId");
            Intrinsics.checkNotNullParameter(seatbidList, "seatbidList");
            Intrinsics.checkNotNullParameter(assets, "assets");
            this.id = id;
            this.nbr = nbr;
            this.currency = currency;
            this.bidId = bidId;
            this.seatbidList = seatbidList;
            this.assets = assets;
        }

        public final List<d> c() {
            return this.seatbidList;
        }

        public final List<c1> a() {
            return this.assets;
        }

        public /* synthetic */ c(String str, String str2, String str3, String str4, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "USD" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? CollectionsKt.emptyList() : list2);
        }

        public final Map<String, c1> b() {
            List<? extends c1> list = this.assets;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(((c1) obj).b, obj);
            }
            return MapsKt.toMutableMap(linkedHashMap);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\f\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/impl/x7$d;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getSeat", "seat", "", "Lcom/chartboost/sdk/impl/x7$a;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "()Ljava/util/List;", "bidList", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String seat;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final List<a> bidList;

        public d() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d dVar = (d) other;
            return Intrinsics.areEqual(this.seat, dVar.seat) && Intrinsics.areEqual(this.bidList, dVar.bidList);
        }

        public int hashCode() {
            return (this.seat.hashCode() * 31) + this.bidList.hashCode();
        }

        public String toString() {
            return "SeatbidModel(seat=" + this.seat + ", bidList=" + this.bidList + ')';
        }

        public d(String seat, List<a> bidList) {
            Intrinsics.checkNotNullParameter(seat, "seat");
            Intrinsics.checkNotNullParameter(bidList, "bidList");
            this.seat = seat;
            this.bidList = bidList;
        }

        public final List<a> a() {
            return this.bidList;
        }

        public /* synthetic */ d(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    public x7(n1 base64Wrapper) {
        Intrinsics.checkNotNullParameter(base64Wrapper, "base64Wrapper");
        this.base64Wrapper = base64Wrapper;
    }

    public final String a(u uVar) {
        if (Intrinsics.areEqual(uVar, u.b.g)) {
            return "true";
        }
        if (Intrinsics.areEqual(uVar, u.c.g) || Intrinsics.areEqual(uVar, u.a.g)) {
            return "false";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final d c(List<d> list) {
        d dVar = (d) CollectionsKt.firstOrNull((List) list);
        if (dVar != null) {
            return dVar;
        }
        return new d(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final s6.a c(JSONObject sizedouble) throws JSONException {
        return new s6.a(sizedouble.optDouble("w"), sizedouble.optDouble("h"));
    }

    public final c d(JSONObject response) throws JSONException {
        List<JSONObject> listAsList;
        b bVarA;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = response.optJSONArray("seatbid");
        b bVar = new b(null, null, null, null, null, null, null, null, 0, null, null, null, null, 8191, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (jSONArrayOptJSONArray != null && (listAsList = b5.asList(jSONArrayOptJSONArray)) != null) {
            for (JSONObject jSONObject : listAsList) {
                String seat = jSONObject.optString("seat");
                JSONArray bidArray = jSONObject.optJSONArray("bid");
                if (bidArray != null) {
                    Intrinsics.checkNotNullExpressionValue(bidArray, "bidArray");
                    List<JSONObject> listAsList2 = b5.asList(bidArray);
                    if (listAsList2 != null) {
                        for (JSONObject jSONObject2 : listAsList2) {
                            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("ext");
                            if (jSONObjectOptJSONObject != null) {
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(\"ext\")");
                                bVarA = a(jSONObjectOptJSONObject);
                                c1 c1VarA = a(bVarA.getTemplate());
                                if (c1VarA != null) {
                                    arrayList.add(c1VarA);
                                }
                            } else {
                                bVarA = bVar;
                            }
                            arrayList2.add(a(jSONObject2, bVarA));
                            bVar = bVarA;
                        }
                    }
                }
                Intrinsics.checkNotNullExpressionValue(seat, "seat");
                arrayList3.add(new d(seat, arrayList2));
            }
        }
        return a(response, arrayList3, arrayList);
    }

    public final void a(Map<String, String> map, a aVar, u uVar) {
        map.put("{% encoding %}", "base64");
        map.put("{% adm %}", aVar.getAdm());
        map.put("{{ ad_type }}", b(uVar));
        map.put("{{ show_close_button }}", a(uVar));
        map.put("{{ preroll_popup }}", "false");
        map.put("{{ post_video_reward_toaster_enabled }}", "false");
        if (Intrinsics.areEqual(uVar, u.a.g)) {
            map.put("{% is_banner %}", "true");
        }
    }

    public final s6 b(JSONObject infoIcon) throws JSONException {
        s6.a aVarC;
        s6.a aVarC2;
        s6.a aVarC3;
        String strOptString = infoIcon.optString("imageurl");
        Intrinsics.checkNotNullExpressionValue(strOptString, "infoIcon.optString(\"imageurl\")");
        String strOptString2 = infoIcon.optString("clickthroughurl");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "infoIcon.optString(\"clickthroughurl\")");
        s6.b bVarA = s6.b.INSTANCE.a(infoIcon.optInt(com.ironsource.b9.h.L));
        JSONObject jSONObjectOptJSONObject = infoIcon.optJSONObject(VastAttributes.MARGIN);
        s6.a aVar = (jSONObjectOptJSONObject == null || (aVarC3 = c(jSONObjectOptJSONObject)) == null) ? new s6.a(0.0d, 0.0d, 3, null) : aVarC3;
        JSONObject jSONObjectOptJSONObject2 = infoIcon.optJSONObject(VastAttributes.PADDING);
        s6.a aVar2 = (jSONObjectOptJSONObject2 == null || (aVarC2 = c(jSONObjectOptJSONObject2)) == null) ? new s6.a(0.0d, 0.0d, 3, null) : aVarC2;
        JSONObject jSONObjectOptJSONObject3 = infoIcon.optJSONObject(ContentDisposition.Parameters.Size);
        return new s6(strOptString, strOptString2, bVarA, aVar, aVar2, (jSONObjectOptJSONObject3 == null || (aVarC = c(jSONObjectOptJSONObject3)) == null) ? new s6.a(0.0d, 0.0d, 3, null) : aVarC);
    }

    public final String b(u adType) {
        if (Intrinsics.areEqual(adType, u.a.g)) {
            return "10";
        }
        if (Intrinsics.areEqual(adType, u.b.g)) {
            return "8";
        }
        if (Intrinsics.areEqual(adType, u.c.g)) {
            return "9";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final b a(JSONObject ext) throws JSONException {
        List listEmptyList;
        s6 s6Var;
        List listEmptyList2;
        String strOptString = ext.optString("impressionid");
        Intrinsics.checkNotNullExpressionValue(strOptString, "ext.optString(\"impressionid\")");
        String strOptString2 = ext.optString("crtype");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "ext.optString(\"crtype\")");
        String strOptString3 = ext.optString("adId");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "ext.optString(\"adId\")");
        String strOptString4 = ext.optString("cgn");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "ext.optString(\"cgn\")");
        String string = ext.getString("template");
        Intrinsics.checkNotNullExpressionValue(string, "ext.getString(\"template\")");
        String strOptString5 = ext.optString(UnifiedMediationParams.KEY_VIDEO_URL);
        Intrinsics.checkNotNullExpressionValue(strOptString5, "ext.optString(\"videoUrl\")");
        JSONArray jSONArrayOptJSONArray = ext.optJSONArray(POBNativeConstants.NATIVE_IMPRESSION_TRACKER);
        if (jSONArrayOptJSONArray == null || (listEmptyList = b5.asList(jSONArrayOptJSONArray)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list = listEmptyList;
        String strOptString6 = ext.optString("params");
        Intrinsics.checkNotNullExpressionValue(strOptString6, "ext.optString(\"params\")");
        int iOptInt = ext.optInt("clkp");
        String strOptString7 = ext.optString("baseurl");
        Intrinsics.checkNotNullExpressionValue(strOptString7, "ext.optString(BASE_URL_JSON_FIELD)");
        JSONObject jSONObjectOptJSONObject = ext.optJSONObject("infoicon");
        if (jSONObjectOptJSONObject == null || (s6Var = b(jSONObjectOptJSONObject)) == null) {
            s6Var = new s6(null, null, null, null, null, null, 63, null);
        }
        s6 s6Var2 = s6Var;
        b9 b9VarA = b9.INSTANCE.a(ext.optString("renderingengine"));
        JSONArray jSONArrayOptJSONArray2 = ext.optJSONArray("scripts");
        if (jSONArrayOptJSONArray2 == null || (listEmptyList2 = b5.asList(jSONArrayOptJSONArray2)) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return new b(strOptString, strOptString2, strOptString3, strOptString4, string, strOptString5, list, strOptString6, iOptInt, strOptString7, s6Var2, b9VarA, listEmptyList2);
    }

    public final a b(List<a> list) {
        a aVar = (a) CollectionsKt.firstOrNull((List) list);
        if (aVar != null) {
            return aVar;
        }
        return new a(null, null, 0.0d, null, null, null, 0, null, 255, null);
    }

    public final c1 a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String strSubstring = str.substring(StringsKt.lastIndexOf$default((CharSequence) str, '/', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return new c1("html", strSubstring, str);
    }

    public final c1 a(List<? extends c1> list) {
        c1 c1Var = (c1) CollectionsKt.firstOrNull((List) list);
        return c1Var == null ? new c1("", "", "") : c1Var;
    }

    public final v a(u adType, JSONObject response) throws JSONException {
        Intrinsics.checkNotNullParameter(adType, "adType");
        if (response != null) {
            c cVarD = d(response);
            a aVarB = b(c(cVarD.c()).a());
            b ext = aVarB.getExt();
            c1 c1VarA = a(cVarD.a());
            Map<String, c1> mapB = cVarD.b();
            mapB.put("body", c1VarA);
            String videoUrl = ext.getVideoUrl();
            String strA = f0.a(videoUrl);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(POBNativeConstants.NATIVE_IMPRESSION_TRACKER, ext.g());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            a(linkedHashMap2, aVarB, adType);
            return new v("", ext.getAdId(), ext.getBaseUrl(), ext.getImpressionid(), ext.getInfoIcon(), ext.getCgn(), "", ext.getCrtype(), mapB, videoUrl, strA, "", "", "", 0, "", "dummy_template", c1VarA, linkedHashMap2, ext.getRenderEngine(), ext.k(), linkedHashMap, aVarB.getAdm(), ext.getParams(), f0.a(aVarB.getMtype()), b3.INSTANCE.a(ext.getClkp()), this.base64Wrapper.b(aVarB.getAdm()));
        }
        throw new JSONException("Missing response");
    }

    public final a a(JSONObject bid, b ext) throws JSONException {
        String string = bid.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "bid.getString(\"id\")");
        String string2 = bid.getString(POBConstants.KEY_IMPRESSION_ID);
        Intrinsics.checkNotNullExpressionValue(string2, "bid.getString(\"impid\")");
        double d2 = bid.getDouble("price");
        String strOptString = bid.optString(com.json.m5.y);
        Intrinsics.checkNotNullExpressionValue(strOptString, "bid.optString(\"burl\")");
        String strOptString2 = bid.optString("crid");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "bid.optString(\"crid\")");
        String strOptString3 = bid.optString("adm");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "bid.optString(\"adm\")");
        return new a(string, string2, d2, strOptString, strOptString2, strOptString3, bid.optInt("mtype"), ext);
    }

    public final c a(JSONObject response, List<d> seatbid, List<? extends c1> assets) throws JSONException {
        String string = response.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "response.getString(\"id\")");
        String strOptString = response.optString("nbr");
        Intrinsics.checkNotNullExpressionValue(strOptString, "response.optString(\"nbr\")");
        String strOptString2 = response.optString("cur", "USD");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "response.optString(\"cur\", \"USD\")");
        String strOptString3 = response.optString("bidid");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "response.optString(\"bidid\")");
        return new c(string, strOptString, strOptString2, strOptString3, seatbid, assets);
    }
}
