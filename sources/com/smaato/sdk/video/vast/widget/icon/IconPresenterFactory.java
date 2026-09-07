package com.smaato.sdk.video.vast.widget.icon;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.utils.AnimationHelper;
import com.smaato.sdk.video.vast.browser.VastWebComponentSecurityPolicy;
import com.smaato.sdk.video.vast.model.VastIconScenario;
import com.smaato.sdk.video.vast.model.VastMediaFileScenario;
import com.smaato.sdk.video.vast.utils.VastScenarioResourceDataConverter;
import com.smaato.sdk.video.vast.widget.element.NoOpVastElementPresenter;
import com.smaato.sdk.video.vast.widget.element.VastElementPresenter;

/* JADX INFO: loaded from: classes11.dex */
public final class IconPresenterFactory {
    private final AnimationHelper animationHelper;
    private final IconErrorCodeStrategy errorCodeStrategy;
    private final VastScenarioResourceDataConverter resourceDataConverter;
    private final VastWebComponentSecurityPolicy securityPolicy;

    public IconPresenterFactory(VastScenarioResourceDataConverter vastScenarioResourceDataConverter, VastWebComponentSecurityPolicy vastWebComponentSecurityPolicy, AnimationHelper animationHelper, IconErrorCodeStrategy iconErrorCodeStrategy) {
        this.resourceDataConverter = (VastScenarioResourceDataConverter) Objects.requireNonNull(vastScenarioResourceDataConverter);
        this.securityPolicy = (VastWebComponentSecurityPolicy) Objects.requireNonNull(vastWebComponentSecurityPolicy);
        this.animationHelper = (AnimationHelper) Objects.requireNonNull(animationHelper);
        this.errorCodeStrategy = (IconErrorCodeStrategy) Objects.requireNonNull(iconErrorCodeStrategy);
    }

    public VastElementPresenter create(Logger logger, VastMediaFileScenario vastMediaFileScenario) {
        VastIconScenario vastIconScenario = vastMediaFileScenario.vastIconScenario;
        if (vastIconScenario == null) {
            return new NoOpVastElementPresenter();
        }
        return new IconPresenterImpl(logger, new IconPresentationManagerImpl(logger, vastIconScenario, this.resourceDataConverter), this.securityPolicy, this.errorCodeStrategy, vastIconScenario, this.animationHelper, vastMediaFileScenario.duration);
    }
}
