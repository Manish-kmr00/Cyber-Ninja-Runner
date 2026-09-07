package com.pubmatic.sdk.common.ui;

import android.view.View;
import com.pubmatic.sdk.common.POBError;

/* JADX INFO: loaded from: classes11.dex */
public interface POBHtmlRendererListener {
    void onRenderProcessGone();

    void onViewClicked(String str);

    void onViewRendered(View view);

    void onViewRenderingFailed(POBError pOBError);
}
