package com.inmobi.media;

import com.yandex.div.core.DivActionHandler;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class Z6 implements InterfaceC3386ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3313b7 f3255a;

    public Z6(C3313b7 c3313b7) {
        this.f3255a = c3313b7;
    }

    @Override // com.inmobi.media.InterfaceC3386ga
    public final void a(String triggerApi) {
        Intrinsics.checkNotNullParameter(triggerApi, "triggerApi");
        HashMap map = new HashMap();
        map.put("creativeId", this.f3255a.getCreativeId());
        map.put(DivActionHandler.DivActionReason.TRIGGER, triggerApi);
        map.put("impressionId", this.f3255a.getImpressionId());
        map.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, "native");
        Ob ob = Ob.f3160a;
        Ob.b("BlockAutoRedirection", map, Sb.SDK);
    }

    @Override // com.inmobi.media.InterfaceC3386ga
    public final boolean d() {
        return true;
    }

    @Override // com.inmobi.media.InterfaceC3386ga
    public final long getViewTouchTimestamp() {
        return -1L;
    }
}
