package com.yandex.div.histogram;

import com.safedk.android.analytics.events.CrashEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: HistogramFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bç\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/yandex/div/histogram/HistogramFilter;", "", CrashEvent.e, "", "componentName", "", "Companion", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface HistogramFilter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    boolean report(String componentName);

    /* JADX INFO: compiled from: HistogramFilter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/yandex/div/histogram/HistogramFilter$Companion;", "", "()V", "OFF", "Lcom/yandex/div/histogram/HistogramFilter;", "getOFF", "()Lcom/yandex/div/histogram/HistogramFilter;", "ON", "getON", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final HistogramFilter ON = new HistogramFilter() { // from class: com.yandex.div.histogram.HistogramFilter$Companion$$ExternalSyntheticLambda0
            @Override // com.yandex.div.histogram.HistogramFilter
            public final boolean report(String str) {
                return HistogramFilter.Companion.ON$lambda$0(str);
            }
        };
        private static final HistogramFilter OFF = new HistogramFilter() { // from class: com.yandex.div.histogram.HistogramFilter$Companion$$ExternalSyntheticLambda1
            @Override // com.yandex.div.histogram.HistogramFilter
            public final boolean report(String str) {
                return HistogramFilter.Companion.OFF$lambda$1(str);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean OFF$lambda$1(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean ON$lambda$0(String str) {
            return true;
        }

        private Companion() {
        }

        public final HistogramFilter getON() {
            return ON;
        }

        public final HistogramFilter getOFF() {
            return OFF;
        }
    }
}
