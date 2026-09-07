package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface l {

    public static final class a {
        public static /* synthetic */ void a(l lVar, List list, x xVar, Integer num, String str, List list2, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f fVar, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackClick");
            }
            lVar.a(list, (i & 2) != 0 ? null : xVar, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str, list2, aVar, fVar);
        }

        public static /* synthetic */ void a(l lVar, List list, x xVar, Integer num, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
            }
            if ((i & 2) != 0) {
                xVar = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            if ((i & 8) != 0) {
                str = null;
            }
            lVar.a(list, xVar, num, str);
        }
    }

    void a(List<String> list, x xVar, Integer num, String str);

    void a(List<String> list, x xVar, Integer num, String str, List<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> list2, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f fVar);
}
