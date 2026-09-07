package com.smaato.sdk.video.vast.widget.icon;

import android.content.res.Resources;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.UIUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.model.VastIconScenario;
import com.smaato.sdk.video.vast.utils.VastScenarioResourceDataConverter;
import com.smaato.sdk.video.vast.widget.element.VastElementException;
import com.smaato.sdk.video.vast.widget.element.VastElementLoadingException;
import com.smaato.sdk.video.vast.widget.element.VastElementPresentationManager;
import com.smaato.sdk.video.vast.widget.element.VastElementView;

/* JADX INFO: loaded from: classes14.dex */
final class IconPresentationManagerImpl implements VastElementPresentationManager {
    private final VastIconScenario iconScenario;
    private final VastScenarioResourceDataConverter resourceDataConverter;

    IconPresentationManagerImpl(Logger logger, VastIconScenario vastIconScenario, VastScenarioResourceDataConverter vastScenarioResourceDataConverter) {
        this.iconScenario = (VastIconScenario) Objects.requireNonNull(vastIconScenario);
        this.resourceDataConverter = (VastScenarioResourceDataConverter) Objects.requireNonNull(vastScenarioResourceDataConverter);
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresentationManager
    public void prepare(VastElementView vastElementView, Consumer<VastElementException> consumer) {
        float f = Resources.getSystem().getDisplayMetrics().density;
        float fMax = Math.max(Math.min(UIUtils.getNormalizedSize(this.iconScenario.width), 50.0f), 12.0f);
        float fMax2 = Math.max(Math.min(UIUtils.getNormalizedSize(this.iconScenario.height), 50.0f), 12.0f);
        String uriFromResources = this.resourceDataConverter.getUriFromResources(this.iconScenario.resourceData, UIUtils.dpToPx(fMax, f), UIUtils.dpToPx(fMax2, f));
        if (TextUtils.isEmpty(uriFromResources)) {
            consumer.accept(new VastElementLoadingException(String.format("Error while preparing Icon. Unable to convert Icon resource: %s", uriFromResources)));
        }
    }
}
