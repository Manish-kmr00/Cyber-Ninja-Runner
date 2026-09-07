package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;
import io.bidmachine.iab.vast.view.CircleCountdownView;
import io.bidmachine.iab.vast.view.LinearCountdownView;
import io.bidmachine.iab.vast.view.TextCountdownView;

/* JADX INFO: loaded from: classes12.dex */
public class IabProgressWrapper extends IabElementWrapper<View> {
    public IabProgressWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    View b(Context context, IabElementStyle iabElementStyle) {
        if ("text".equals(iabElementStyle.getStyle()) || "text-reverse".equals(iabElementStyle.getStyle())) {
            return new TextCountdownView(context);
        }
        return ("circular".equals(iabElementStyle.getStyle()) || "circular-reverse".equals(iabElementStyle.getStyle())) ? new CircleCountdownView(context) : new LinearCountdownView(context);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle iabElementStyle) {
        if (iabElementStyle != null) {
            if ("text".equals(iabElementStyle.getStyle()) || "text-reverse".equals(iabElementStyle.getStyle())) {
                return Assets.DEF_TEXT_PROGRESS_STYLE;
            }
            if ("circular".equals(iabElementStyle.getStyle()) || "circular-reverse".equals(iabElementStyle.getStyle())) {
                return Assets.DEF_COUNT_DOWN_PROGRESS_STYLE;
            }
        }
        return Assets.DEF_LINEAR_PROGRESS_STYLE;
    }

    public void changePercentage(float percent, int progressSec, int totalSec) {
        IabElementStyle iabElementStyle = this.c;
        if (iabElementStyle == null) {
            return;
        }
        boolean z = iabElementStyle.getStyle() != null && this.c.getStyle().endsWith("reverse");
        View view = this.b;
        if (view instanceof TextCountdownView) {
            TextCountdownView textCountdownView = (TextCountdownView) view;
            if (totalSec == 0) {
                textCountdownView.setText("");
                return;
            }
            if (z) {
                progressSec = totalSec - progressSec;
            }
            textCountdownView.setRemaining(Math.max(1, progressSec));
            return;
        }
        if (view instanceof CircleCountdownView) {
            CircleCountdownView circleCountdownView = (CircleCountdownView) view;
            if (z) {
                circleCountdownView.changePercentage(percent, totalSec != 0 ? Math.max(1, totalSec - progressSec) : 0);
                return;
            } else {
                circleCountdownView.changePercentage(100.0f - percent, progressSec);
                return;
            }
        }
        if (view instanceof LinearCountdownView) {
            LinearCountdownView linearCountdownView = (LinearCountdownView) view;
            if (z) {
                percent = 100.0f - percent;
            }
            linearCountdownView.changePercentage(percent);
        }
    }
}
