package com.yandex.div.core;

import android.view.View;
import com.yandex.div2.Div;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface DivVisibilityChangeListener {
    public static final DivVisibilityChangeListener STUB = new DivVisibilityChangeListener() { // from class: com.yandex.div.core.DivVisibilityChangeListener$$ExternalSyntheticLambda0
        @Override // com.yandex.div.core.DivVisibilityChangeListener
        public final void onViewsVisibilityChanged(Map map) {
            DivVisibilityChangeListener.lambda$static$0(map);
        }
    };

    static /* synthetic */ void lambda$static$0(Map map) {
    }

    void onViewsVisibilityChanged(Map<View, Div> map);
}
