package net.pubnative.lite.sdk.mrect.presenter;

import android.content.Context;
import net.pubnative.lite.sdk.banner.presenter.BannerPresenterFactory;
import net.pubnative.lite.sdk.models.IntegrationType;

/* JADX INFO: loaded from: classes12.dex */
@Deprecated
public class MRectPresenterFactory extends BannerPresenterFactory {
    public MRectPresenterFactory(Context context) {
        super(context, IntegrationType.STANDALONE);
    }
}
