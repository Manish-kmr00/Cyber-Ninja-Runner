package com.chartboost.sdk.impl;

import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\b*\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u0002*\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0013\u0010\f\u001a\u00020\u0002*\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/impl/l4;", "Lcom/chartboost/sdk/impl/ka;", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "Lcom/chartboost/sdk/impl/da;", com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "Lcom/chartboost/sdk/impl/ia;", ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "persist", "clearFromStorage", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface m4 extends l4 {
    ka clearFromStorage(ka kaVar);

    ka persist(ka kaVar);

    ia refresh(ia iaVar);

    da store(da daVar);

    ka track(ka kaVar);
}
