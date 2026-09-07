package io.bidmachine.unified;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UnifiedParams {
    private final UnifiedMediationParams mediationParams;

    public abstract boolean isValid(UnifiedAdCallback unifiedAdCallback);

    public UnifiedParams(UnifiedMediationParams unifiedMediationParams) {
        this.mediationParams = unifiedMediationParams;
    }

    public UnifiedMediationParams getMediationParams() {
        return this.mediationParams;
    }
}
