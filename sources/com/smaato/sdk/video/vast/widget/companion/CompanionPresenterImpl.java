package com.smaato.sdk.video.vast.widget.companion;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.video.vast.browser.VastWebComponentSecurityPolicy;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import com.smaato.sdk.video.vast.widget.element.VastElementErrorCodeStrategy;
import com.smaato.sdk.video.vast.widget.element.VastElementPresentationManager;
import com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl;

/* JADX INFO: loaded from: classes6.dex */
public class CompanionPresenterImpl extends VastElementPresenterImpl {
    private final VastCompanionScenario companionScenario;

    CompanionPresenterImpl(Logger logger, VastElementPresentationManager vastElementPresentationManager, VastWebComponentSecurityPolicy vastWebComponentSecurityPolicy, VastElementErrorCodeStrategy vastElementErrorCodeStrategy, VastCompanionScenario vastCompanionScenario) {
        super(logger, vastElementPresentationManager, vastWebComponentSecurityPolicy, vastElementErrorCodeStrategy);
        this.companionScenario = (VastCompanionScenario) Objects.requireNonNull(vastCompanionScenario);
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresenterImpl, com.smaato.sdk.video.vast.widget.element.VastElementPresenter
    public void onClicked(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.companionScenario.companionClickThrough;
        }
        super.onClicked(str);
    }
}
