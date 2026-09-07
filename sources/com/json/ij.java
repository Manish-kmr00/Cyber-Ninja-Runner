package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.model.NetworkSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J1\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/ironsource/ij;", "Lcom/ironsource/u0;", "", "s", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "Lcom/ironsource/mj;", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "userId", "providerList", ug.p, "a", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "Ljava/util/List;", "j", "()Ljava/util/List;", "Lcom/ironsource/mj;", "v", "()Lcom/ironsource/mj;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/ironsource/mj;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ij extends u0 {

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final String userId;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final List<NetworkSettings> providerList;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final mj configs;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public ij(String str, List<? extends NetworkSettings> list, mj configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        o5 o5VarG = configs.g();
        Intrinsics.checkNotNullExpressionValue(o5VarG, "configs.interstitialAuctionSettings");
        super(ad_unit, str, list, o5VarG, configs.c(), configs.d(), configs.f(), configs.b(), -1, new o2(o2.a.MANUAL, configs.g().j(), configs.g().b(), -1L), new i2(-1L), configs.h(), configs.k(), configs.m(), configs.l(), false, 32768, null);
        this.userId = str;
        this.providerList = list;
        this.configs = configs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ij a(ij ijVar, String str, List list, mj mjVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ijVar.userId;
        }
        if ((i & 2) != 0) {
            list = ijVar.providerList;
        }
        if ((i & 4) != 0) {
            mjVar = ijVar.configs;
        }
        return ijVar.a(str, list, mjVar);
    }

    public final ij a(String userId, List<? extends NetworkSettings> providerList, mj configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new ij(userId, providerList, configs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ij)) {
            return false;
        }
        ij ijVar = (ij) other;
        return Intrinsics.areEqual(this.userId, ijVar.userId) && Intrinsics.areEqual(this.providerList, ijVar.providerList) && Intrinsics.areEqual(this.configs, ijVar.configs);
    }

    public int hashCode() {
        String str = this.userId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<NetworkSettings> list = this.providerList;
        return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.configs.hashCode();
    }

    @Override // com.json.u0
    public List<NetworkSettings> j() {
        return this.providerList;
    }

    @Override // com.json.u0
    /* JADX INFO: renamed from: o, reason: from getter */
    public String getUserId() {
        return this.userId;
    }

    public final String s() {
        return this.userId;
    }

    public final List<NetworkSettings> t() {
        return this.providerList;
    }

    public String toString() {
        return "InterstitialAdManagerData(userId=" + this.userId + ", providerList=" + this.providerList + ", configs=" + this.configs + ')';
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    public final mj getConfigs() {
        return this.configs;
    }

    public final mj v() {
        return this.configs;
    }
}
