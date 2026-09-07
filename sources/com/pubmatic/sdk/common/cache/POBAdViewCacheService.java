package com.pubmatic.sdk.common.cache;

import android.view.View;
import com.pubmatic.sdk.common.ui.POBFullScreenActivityBackPressListener;
import com.pubmatic.sdk.common.ui.POBFullScreenActivityListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class POBAdViewCacheService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map f7565a = Collections.synchronizedMap(new HashMap());

    public static class AdViewConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private View f7566a;
        private POBFullScreenActivityListener b;
        private POBFullScreenActivityBackPressListener c;

        public AdViewConfig(View view, POBFullScreenActivityListener pOBFullScreenActivityListener) {
            this.f7566a = view;
            this.b = pOBFullScreenActivityListener;
        }

        public View getAdView() {
            return this.f7566a;
        }

        public POBFullScreenActivityBackPressListener getBackPressListener() {
            return this.c;
        }

        public POBFullScreenActivityListener getEventListener() {
            return this.b;
        }

        public void setBackPressListener(POBFullScreenActivityBackPressListener pOBFullScreenActivityBackPressListener) {
            this.c = pOBFullScreenActivityBackPressListener;
        }
    }

    public AdViewConfig getStoredAdView(Integer num) {
        return (AdViewConfig) this.f7565a.get(num);
    }

    public AdViewConfig popStoredAdView(Integer num) {
        return (AdViewConfig) this.f7565a.remove(num);
    }

    public void storeAdView(Integer num, AdViewConfig adViewConfig) {
        this.f7565a.put(num, adViewConfig);
    }
}
