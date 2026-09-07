package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Yg implements Zg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final DataSendingRestrictionController f11438a;

    public Yg(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f11438a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.Zg
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
