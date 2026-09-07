package io.bidmachine.displays;

import android.graphics.Point;
import io.bidmachine.ContextProvider;
import io.bidmachine.unified.UnifiedAdRequestParams;

/* JADX INFO: loaded from: classes7.dex */
interface ISizableDisplayPlacement<UnifiedAdRequestParamsType extends UnifiedAdRequestParams> {
    Point getSize(ContextProvider contextProvider, UnifiedAdRequestParamsType unifiedadrequestparamstype);
}
