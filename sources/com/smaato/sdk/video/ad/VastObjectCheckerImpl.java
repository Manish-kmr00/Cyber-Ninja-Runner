package com.smaato.sdk.video.ad;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.viewmodel.VastObjectChecker;
import com.smaato.sdk.video.vast.model.Category;
import com.smaato.sdk.video.vast.model.MediaFile;
import com.smaato.sdk.video.vast.model.VastScenario;
import com.smaato.sdk.video.vast.tracking.VastErrorTracker;
import com.smaato.sdk.video.vast.tracking.macro.PlayerState;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class VastObjectCheckerImpl implements VastObjectChecker {
    Logger logger;
    VastErrorTrackerCreator vastErrorTrackerCreator;

    public VastObjectCheckerImpl(VastErrorTrackerCreator vastErrorTrackerCreator, Logger logger) {
        this.vastErrorTrackerCreator = vastErrorTrackerCreator;
        this.logger = logger;
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.VastObjectChecker
    public boolean check(Object obj) {
        if (!(obj instanceof VastParsingResult)) {
            return false;
        }
        VastParsingResult vastParsingResult = (VastParsingResult) obj;
        VastScenario vastScenario = vastParsingResult.vastScenario;
        Set<String> set = vastParsingResult.errorUrls;
        Set<Integer> set2 = vastParsingResult.errors;
        VastErrorTracker vastErrorTrackerCreate = this.vastErrorTrackerCreator.create(vastScenario, set);
        Iterator<Integer> it = set2.iterator();
        if (it.hasNext()) {
            vastErrorTrackerCreate.track(new PlayerState.Builder().setErrorCode(it.next().intValue()).build());
        }
        if (vastScenario == null) {
            return false;
        }
        Iterator<Category> it2 = vastScenario.categories.iterator();
        while (it2.hasNext()) {
            if (vastScenario.blockedAdCategories.contains(it2.next().categoryCode)) {
                vastErrorTrackerCreate.track(new PlayerState.Builder().setErrorCode(205).build());
                this.logger.error(LogDomain.VIDEO, "Failed to build Vast Ad Player: Inline Category violates Wrapper BlockedAdCategories", new Object[0]);
                return false;
            }
        }
        MediaFile mediaFile = vastScenario.vastMediaFileScenario.mediaFile;
        if (mediaFile.url.equals(MediaFile.URL_DOWNLOAD_FAILED)) {
            vastErrorTrackerCreate.track(new PlayerState.Builder().setErrorCode(400).build());
            this.logger.error(LogDomain.VIDEO, "Failed to build VastAdPresenter: Download of media file failed", new Object[0]);
            return false;
        }
        if (mediaFile.delivery != null) {
            return true;
        }
        vastErrorTrackerCreate.track(new PlayerState.Builder().setErrorCode(405).build());
        this.logger.error(LogDomain.VIDEO, "Failed to build RewardedVideoAdPresenter: Unknown delivery method", new Object[0]);
        return false;
    }
}
