package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;
import io.bidmachine.iab.vast.view.CircleCountdownView;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes13.dex */
public class IabCloseWrapper extends IabElementWrapper<CircleCountdownView> {
    public IabCloseWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle iabElementStyle) {
        return Assets.resolveDefCloseStyle(context, iabElementStyle);
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
        super.a(context, (View) circleCountdownView, iabElementStyle);
        circleCountdownView.setImage(Assets.getBitmapFromBase64((EventConstants.SKIP.equals(iabElementStyle.getStyle()) || "skipfill".equals(iabElementStyle.getStyle())) ? Assets.SKIP : Assets.CLOSE));
    }
}
