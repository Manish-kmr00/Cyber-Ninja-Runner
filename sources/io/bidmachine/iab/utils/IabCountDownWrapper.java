package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;
import io.bidmachine.iab.vast.view.CircleCountdownView;
import io.bidmachine.iab.vast.view.TextCountdownView;

/* JADX INFO: loaded from: classes.dex */
public class IabCountDownWrapper extends IabElementWrapper<View> {
    public IabCountDownWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    View b(Context context, IabElementStyle iabElementStyle) {
        return "text".equals(iabElementStyle.getStyle()) ? new TextCountdownView(context) : new CircleCountdownView(context);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle iabElementStyle) {
        return (iabElementStyle == null || !"text".equals(iabElementStyle.getStyle())) ? Assets.DEF_COUNT_DOWN_STYLE : Assets.DEF_TEXT_COUNT_DOWN_STYLE;
    }

    public void changePercentage(int percent, int remainingTimeSec) {
        View view = this.b;
        if (!(view instanceof TextCountdownView)) {
            if (view instanceof CircleCountdownView) {
                ((CircleCountdownView) view).changePercentage(percent, remainingTimeSec);
            }
        } else {
            TextCountdownView textCountdownView = (TextCountdownView) view;
            if (remainingTimeSec == 0) {
                textCountdownView.setText("");
            } else {
                textCountdownView.setRemaining(remainingTimeSec);
            }
        }
    }
}
