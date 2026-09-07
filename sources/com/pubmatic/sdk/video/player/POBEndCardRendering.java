package com.pubmatic.sdk.video.player;

import android.widget.FrameLayout;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.webrendering.ui.POBOnSkipOptionUpdateListener;

/* JADX INFO: loaded from: classes12.dex */
public interface POBEndCardRendering {
    FrameLayout getView();

    void render(POBAdDescriptor pOBAdDescriptor);

    void setLearnMoreTitle(String str);

    void setListener(a aVar);

    void setOnSkipOptionUpdateListener(POBOnSkipOptionUpdateListener pOBOnSkipOptionUpdateListener);

    void setSkipAfter(int i);
}
