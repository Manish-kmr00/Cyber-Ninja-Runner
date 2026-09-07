package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public class IabLoadingWrapper extends IabElementWrapper<CircularProgressBar> {
    public IabLoadingWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle iabElementStyle) {
        return Assets.DEF_LOADING_STYLE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.bidmachine.iab.utils.IabElementWrapper
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public CircularProgressBar b(Context context, IabElementStyle iabElementStyle) {
        return new CircularProgressBar(context);
    }
}
