package com.smaato.sdk.core.mvvm.viewmodel;

import android.graphics.Bitmap;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.mvvm.model.imagead.Extension;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public interface SmaatoSdkViewModelListener {
    void onCsmAdObjectLoaded(Object obj, ImpressionCountingType impressionCountingType);

    void onImageAdLoaded(Bitmap bitmap, int i, int i2, List<Extension> list, ImpressionCountingType impressionCountingType);

    void onRichMediaAdLoaded(String str, int i, int i2, ImpressionCountingType impressionCountingType);

    void onVideoAdLoaded(Object obj, ImpressionCountingType impressionCountingType);
}
