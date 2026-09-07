package com.pubmatic.sdk.common.session;

import com.pubmatic.sdk.common.POBAdFormat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/pubmatic/sdk/common/session/POBImpDepthHandling;", "", "getImpressions", "", "placementType", "Lcom/pubmatic/sdk/common/POBAdFormat;", "initiate", "", "recordImpression", "common_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface POBImpDepthHandling {
    int getImpressions(POBAdFormat placementType);

    void initiate();

    void recordImpression(POBAdFormat placementType);
}
