package com.yandex.div.core.view2.logging.bind;

import com.yandex.div.core.view2.animations.DivComparatorReporter;
import com.yandex.div.core.view2.reuse.ComplexRebindReporter;
import kotlin.Metadata;

/* JADX INFO: compiled from: BindingEventReporter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b`\u0018\u0000 \n2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\nJ\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/logging/bind/BindingEventReporter;", "Lcom/yandex/div/core/view2/animations/DivComparatorReporter;", "Lcom/yandex/div/core/view2/reuse/ComplexRebindReporter;", "Lcom/yandex/div/core/view2/logging/bind/SimpleRebindReporter;", "Lcom/yandex/div/core/view2/logging/bind/ForceRebindReporter;", "onBindingFatalNoData", "", "onBindingFatalNoState", "onBindingFatalSameData", "onStateUpdateCompleted", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface BindingEventReporter extends DivComparatorReporter, ComplexRebindReporter, SimpleRebindReporter, ForceRebindReporter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void onBindingFatalNoData();

    void onBindingFatalNoState();

    void onBindingFatalSameData();

    void onStateUpdateCompleted();

    /* JADX INFO: compiled from: BindingEventReporter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/view2/logging/bind/BindingEventReporter$Companion;", "", "()V", "STUB", "Lcom/yandex/div/core/view2/logging/bind/BindingEventReporter;", "getSTUB", "()Lcom/yandex/div/core/view2/logging/bind/BindingEventReporter;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final BindingEventReporter STUB = new BindingEventReporter() { // from class: com.yandex.div.core.view2.logging.bind.BindingEventReporter$Companion$STUB$1
            @Override // com.yandex.div.core.view2.logging.bind.BindingEventReporter
            public void onBindingFatalNoData() {
            }

            @Override // com.yandex.div.core.view2.logging.bind.BindingEventReporter
            public void onBindingFatalNoState() {
            }

            @Override // com.yandex.div.core.view2.logging.bind.BindingEventReporter
            public void onBindingFatalSameData() {
            }

            @Override // com.yandex.div.core.view2.logging.bind.BindingEventReporter
            public void onStateUpdateCompleted() {
            }
        };

        private Companion() {
        }

        public final BindingEventReporter getSTUB() {
            return STUB;
        }
    }
}
