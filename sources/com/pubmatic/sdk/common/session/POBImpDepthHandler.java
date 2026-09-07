package com.pubmatic.sdk.common.session;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.common.POBAdFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/pubmatic/sdk/common/session/POBImpDepthHandler;", "Lcom/pubmatic/sdk/common/session/POBImpDepthHandling;", "Lcom/pubmatic/sdk/common/session/POBAppSessionHandler$POBAppSessionListener;", "Lcom/pubmatic/sdk/common/session/POBAppSessionHandling;", "sessionHandler", "<init>", "(Lcom/pubmatic/sdk/common/session/POBAppSessionHandling;)V", "", "initiate", "()V", "Lcom/pubmatic/sdk/common/POBAdFormat;", "placementType", "recordImpression", "(Lcom/pubmatic/sdk/common/POBAdFormat;)V", "", "getImpressions", "(Lcom/pubmatic/sdk/common/POBAdFormat;)I", "onAppSessionStarted", "onAppSessionReset", "a", "Lcom/pubmatic/sdk/common/session/POBAppSessionHandling;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/Map;", "impMap", "common_release"}, k = 1, mv = {1, 7, 1})
public final class POBImpDepthHandler implements POBImpDepthHandling, POBAppSessionHandler.POBAppSessionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private POBAppSessionHandling sessionHandler;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private Map impMap;

    public POBImpDepthHandler(POBAppSessionHandling sessionHandler) {
        Intrinsics.checkNotNullParameter(sessionHandler, "sessionHandler");
        this.sessionHandler = sessionHandler;
        this.impMap = new LinkedHashMap();
    }

    @Override // com.pubmatic.sdk.common.session.POBImpDepthHandling
    public int getImpressions(POBAdFormat placementType) {
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        Integer num = (Integer) this.impMap.get(placementType);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.pubmatic.sdk.common.session.POBImpDepthHandling
    public void initiate() {
        this.sessionHandler.addAppSessionListener(this);
    }

    @Override // com.pubmatic.sdk.common.session.POBAppSessionHandler.POBAppSessionListener
    public void onAppSessionReset() {
        this.impMap.clear();
    }

    @Override // com.pubmatic.sdk.common.session.POBAppSessionHandler.POBAppSessionListener
    public void onAppSessionStarted() {
        this.impMap.clear();
    }

    @Override // com.pubmatic.sdk.common.session.POBImpDepthHandling
    public void recordImpression(POBAdFormat placementType) {
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        Map map = this.impMap;
        Integer num = (Integer) map.get(placementType);
        map.put(placementType, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
    }
}
