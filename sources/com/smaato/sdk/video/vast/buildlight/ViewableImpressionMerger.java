package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.video.vast.model.ViewableImpression;

/* JADX INFO: loaded from: classes7.dex */
public class ViewableImpressionMerger {
    public ViewableImpression merge(ViewableImpression viewableImpression, ViewableImpression viewableImpression2) {
        if (viewableImpression == null) {
            return viewableImpression2;
        }
        return viewableImpression2 == null ? viewableImpression : new ViewableImpression.Builder().setId(viewableImpression.id).setViewable(VastScenarioMergeUtils.merge(viewableImpression.viewable, viewableImpression2.viewable)).setNotViewable(VastScenarioMergeUtils.merge(viewableImpression.notViewable, viewableImpression2.notViewable)).setViewUndetermined(VastScenarioMergeUtils.merge(viewableImpression.viewUndetermined, viewableImpression2.viewUndetermined)).build();
    }
}
