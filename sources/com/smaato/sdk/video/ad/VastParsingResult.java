package com.smaato.sdk.video.ad;

import com.smaato.sdk.video.vast.model.VastScenario;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public class VastParsingResult {
    public final Set<String> errorUrls;
    public final Set<Integer> errors;
    public final VastScenario vastScenario;

    public VastParsingResult(VastScenario vastScenario, Set<Integer> set, Set<String> set2) {
        this.vastScenario = vastScenario;
        this.errors = set;
        this.errorUrls = set2;
    }
}
