package com.yandex.div.core.view2.logging.patch;

import com.yandex.div.core.view2.logging.bind.SimpleRebindReporter;
import kotlin.Metadata;

/* JADX INFO: compiled from: PatchEventReporter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/logging/patch/PatchEventReporter;", "Lcom/yandex/div/core/view2/logging/bind/SimpleRebindReporter;", "onPatchNoState", "", "onPatchSuccess", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface PatchEventReporter extends SimpleRebindReporter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void onPatchNoState();

    void onPatchSuccess();

    /* JADX INFO: compiled from: PatchEventReporter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/view2/logging/patch/PatchEventReporter$Companion;", "", "()V", "STUB", "Lcom/yandex/div/core/view2/logging/patch/PatchEventReporter;", "getSTUB", "()Lcom/yandex/div/core/view2/logging/patch/PatchEventReporter;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final PatchEventReporter STUB = new PatchEventReporter() { // from class: com.yandex.div.core.view2.logging.patch.PatchEventReporter$Companion$STUB$1
            @Override // com.yandex.div.core.view2.logging.patch.PatchEventReporter
            public void onPatchNoState() {
            }

            @Override // com.yandex.div.core.view2.logging.patch.PatchEventReporter
            public void onPatchSuccess() {
            }
        };

        private Companion() {
        }

        public final PatchEventReporter getSTUB() {
            return STUB;
        }
    }
}
