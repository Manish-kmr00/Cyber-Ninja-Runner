package com.smaato.sdk.video.vast.widget.companion;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Size;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.UIUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.vast.model.VastCompanionScenario;
import com.smaato.sdk.video.vast.model.VastScenarioResourceData;
import com.smaato.sdk.video.vast.utils.VastScenarioResourceDataConverter;
import com.smaato.sdk.video.vast.widget.element.VastElementException;
import com.smaato.sdk.video.vast.widget.element.VastElementLoadingException;
import com.smaato.sdk.video.vast.widget.element.VastElementPresentationManager;
import com.smaato.sdk.video.vast.widget.element.VastElementView;

/* JADX INFO: loaded from: classes.dex */
final class CompanionPresentationManager implements VastElementPresentationManager {
    private final VastScenarioResourceDataConverter resourceDataConverter;
    private final VastCompanionScenario vastCompanionScenario;

    CompanionPresentationManager(Logger logger, VastCompanionScenario vastCompanionScenario, VastScenarioResourceDataConverter vastScenarioResourceDataConverter) {
        this.vastCompanionScenario = (VastCompanionScenario) Objects.requireNonNull(vastCompanionScenario);
        this.resourceDataConverter = (VastScenarioResourceDataConverter) Objects.requireNonNull(vastScenarioResourceDataConverter);
    }

    @Override // com.smaato.sdk.video.vast.widget.element.VastElementPresentationManager
    public void prepare(VastElementView vastElementView, Consumer<VastElementException> consumer) {
        Size sizeCalculateCompanionSizes = calculateCompanionSizes(this.vastCompanionScenario);
        VastScenarioResourceData vastScenarioResourceData = this.vastCompanionScenario.resourceData;
        String uriFromResources = this.resourceDataConverter.getUriFromResources(vastScenarioResourceData, sizeCalculateCompanionSizes.width, sizeCalculateCompanionSizes.height);
        if (TextUtils.isEmpty(uriFromResources)) {
            consumer.accept(new VastElementLoadingException(String.format("Error while preparing Companion. Unable to convert Companion resource: %s", vastScenarioResourceData)));
        } else {
            vastElementView.load(uriFromResources);
            vastElementView.setSize(sizeCalculateCompanionSizes.width, sizeCalculateCompanionSizes.height);
        }
    }

    private Size calculateCompanionSizes(VastCompanionScenario vastCompanionScenario) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        float fDpToPx = UIUtils.dpToPx(UIUtils.getNormalizedSize(vastCompanionScenario.width), f);
        float fDpToPx2 = UIUtils.dpToPx(UIUtils.getNormalizedSize(vastCompanionScenario.height), f);
        if (fDpToPx <= 0.0f) {
            fDpToPx = i;
        }
        if (fDpToPx2 <= 0.0f) {
            fDpToPx2 = i2;
        }
        float f2 = i;
        if (fDpToPx > f2) {
            fDpToPx2 = (fDpToPx2 / fDpToPx) * f2;
            fDpToPx = f2;
        }
        float f3 = i2;
        if (fDpToPx2 > f3) {
            fDpToPx = (fDpToPx / fDpToPx2) * f3;
            fDpToPx2 = f3;
        }
        return new Size((int) fDpToPx, (int) fDpToPx2);
    }
}
