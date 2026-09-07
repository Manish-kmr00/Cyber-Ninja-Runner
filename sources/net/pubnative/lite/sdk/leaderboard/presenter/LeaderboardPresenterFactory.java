package net.pubnative.lite.sdk.leaderboard.presenter;

import android.content.Context;
import net.pubnative.lite.sdk.banner.presenter.BannerPresenterFactory;
import net.pubnative.lite.sdk.models.IntegrationType;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public class LeaderboardPresenterFactory extends BannerPresenterFactory {
    public LeaderboardPresenterFactory(Context context) {
        super(context, IntegrationType.STANDALONE);
    }
}
