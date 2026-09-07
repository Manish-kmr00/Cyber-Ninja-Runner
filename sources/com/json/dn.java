package com.json;

import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.model.Placement;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\t\b\u0010¢\u0006\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ironsource/dn;", "Lcom/ironsource/f1;", "Ljava/util/UUID;", "adId", "", "adUnitId", "Lcom/ironsource/mediationsdk/model/Placement;", "placement", "<init>", "(Ljava/util/UUID;Ljava/lang/String;Lcom/ironsource/mediationsdk/model/Placement;)V", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class dn extends f1 {
    public dn() {
        this(lf.f3858a.a(), "", null, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn(UUID adId, String adUnitId, Placement placement) {
        super(IronSource.AD_UNIT.NATIVE_AD, adId, adUnitId, placement, null, 16, null);
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
    }

    public /* synthetic */ dn(UUID uuid, String str, Placement placement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid, str, (i & 4) != 0 ? null : placement);
    }
}
