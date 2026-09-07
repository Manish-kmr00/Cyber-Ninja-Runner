package com.yandex.div.histogram;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: compiled from: HistogramCallType.kt */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/histogram/HistogramCallType;", "", "Companion", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public @interface HistogramCallType {
    public static final String CALL_TYPE_COLD = "Cold";
    public static final String CALL_TYPE_COOL = "Cool";
    public static final String CALL_TYPE_WARM = "Warm";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: HistogramCallType.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/histogram/HistogramCallType$Companion;", "", "()V", "CALL_TYPE_COLD", "", "CALL_TYPE_COOL", "CALL_TYPE_WARM", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CALL_TYPE_COLD = "Cold";
        public static final String CALL_TYPE_COOL = "Cool";
        public static final String CALL_TYPE_WARM = "Warm";

        private Companion() {
        }
    }
}
