package io.bidmachine;

import io.bidmachine.models.DataRestrictions;
import io.bidmachine.models.TargetingInfo;

/* JADX INFO: loaded from: classes5.dex */
public interface GeneralParams {
    DataRestrictions getDataRestrictions();

    TargetingInfo getTargetingInfo();

    boolean isTestMode();
}
