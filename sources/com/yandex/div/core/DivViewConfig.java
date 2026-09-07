package com.yandex.div.core;

/* JADX INFO: loaded from: classes12.dex */
public interface DivViewConfig {
    public static final DivViewConfig DEFAULT = new DivViewConfig() { // from class: com.yandex.div.core.DivViewConfig$$ExternalSyntheticLambda0
        @Override // com.yandex.div.core.DivViewConfig
        public final boolean isContextMenuEnabled() {
            return DivViewConfig.lambda$static$0();
        }
    };

    static /* synthetic */ boolean lambda$static$0() {
        return true;
    }

    default int getLogCardScrollSignificantThreshold() {
        return 0;
    }

    boolean isContextMenuEnabled();
}
