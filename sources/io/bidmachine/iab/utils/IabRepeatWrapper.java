package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;
import io.bidmachine.iab.vast.view.CircleCountdownView;

/* JADX INFO: loaded from: classes8.dex */
public class IabRepeatWrapper extends IabElementWrapper<CircleCountdownView> {
    public IabRepeatWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle iabElementStyle) {
        if (iabElementStyle == null || !"repeatfill".equals(iabElementStyle.getStyle())) {
            return Assets.DEF_REPEAT_STYLE;
        }
        IabElementStyle iabElementStyle2 = new IabElementStyle();
        iabElementStyle2.setOutlined(Boolean.TRUE);
        return Assets.DEF_REPEAT_STYLE.copyWith(iabElementStyle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.bidmachine.iab.utils.IabElementWrapper
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public CircleCountdownView b(Context context, IabElementStyle iabElementStyle) {
        return new CircleCountdownView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.iab.utils.IabElementWrapper
    public void a(Context context, CircleCountdownView circleCountdownView, IabElementStyle iabElementStyle) {
        circleCountdownView.setImage(Assets.getBitmapFromBase64(Assets.REPEAT));
    }
}
