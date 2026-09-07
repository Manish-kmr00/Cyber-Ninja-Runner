package com.smaato.sdk.core.mvvm.view;

import android.content.Context;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.ui.AdContentView;

/* JADX INFO: loaded from: classes9.dex */
public interface RichMediaAdContentViewCreator {
    AdContentView createAdContentView(Context context, String str, int i, int i2, boolean z, ImpressionCountingType impressionCountingType, SmaatoSdkViewDelegate smaatoSdkViewDelegate);
}
