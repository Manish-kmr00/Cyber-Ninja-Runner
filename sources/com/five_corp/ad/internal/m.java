package com.five_corp.ad.internal;

import com.five_corp.ad.FiveAdCustomLayout;
import com.five_corp.ad.FiveAdCustomLayoutEventListener;
import com.five_corp.ad.FiveAdNative;
import com.five_corp.ad.FiveAdNativeEventListener;

/* JADX INFO: loaded from: classes10.dex */
public interface m {
    static m a(final FiveAdCustomLayoutEventListener fiveAdCustomLayoutEventListener, final FiveAdCustomLayout fiveAdCustomLayout) {
        return new m() { // from class: com.five_corp.ad.internal.m$$ExternalSyntheticLambda1
            @Override // com.five_corp.ad.internal.m
            public final void a() {
                fiveAdCustomLayoutEventListener.onRemove(fiveAdCustomLayout);
            }
        };
    }

    void a();

    static m a(final FiveAdNativeEventListener fiveAdNativeEventListener, final FiveAdNative fiveAdNative) {
        return new m() { // from class: com.five_corp.ad.internal.m$$ExternalSyntheticLambda0
            @Override // com.five_corp.ad.internal.m
            public final void a() {
                fiveAdNativeEventListener.onRemove(fiveAdNative);
            }
        };
    }
}
