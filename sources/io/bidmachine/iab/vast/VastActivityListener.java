package io.bidmachine.iab.vast;

import io.bidmachine.iab.IabError;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.iab.vast.activity.VastActivity;

/* JADX INFO: loaded from: classes.dex */
public interface VastActivityListener {
    void onVastClick(VastActivity vastActivity, VastRequest vastRequest, IabClickCallback clickCallback, String url);

    void onVastComplete(VastActivity vastActivity, VastRequest vastRequest);

    void onVastDismiss(VastActivity vastActivity, VastRequest vastRequest, boolean finished);

    void onVastShowFailed(VastRequest vastRequest, IabError iabError);

    void onVastShown(VastActivity vastActivity, VastRequest vastRequest);
}
