package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;
import io.bidmachine.iab.vast.view.CircleCountdownView;

/* JADX INFO: loaded from: classes11.dex */
public class IabMuteWrapper extends IabElementWrapper<CircleCountdownView> {
    private boolean g;

    public IabMuteWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
        this.g = false;
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle iabElementStyle) {
        if (iabElementStyle == null || !"speakerfill".equals(iabElementStyle.getStyle())) {
            return Assets.DEF_MUTE_STYLE;
        }
        IabElementStyle iabElementStyle2 = new IabElementStyle();
        iabElementStyle2.setOutlined(Boolean.TRUE);
        return Assets.DEF_MUTE_STYLE.copyWith(iabElementStyle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.bidmachine.iab.utils.IabElementWrapper
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public CircleCountdownView b(Context context, IabElementStyle iabElementStyle) {
        return new CircleCountdownView(context);
    }

    public void setMuted(boolean muted) {
        this.g = muted;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.iab.utils.IabElementWrapper
    public void a(Context context, CircleCountdownView circleCountdownView, IabElementStyle iabElementStyle) {
        circleCountdownView.setImage(Assets.getBitmapFromBase64(this.g ? Assets.UNMUTE : Assets.MUTE));
    }
}
