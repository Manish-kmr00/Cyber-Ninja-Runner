package com.yandex.div.core.widget;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: compiled from: ShowSeparatorsMode.kt */
/* JADX INFO: loaded from: classes13.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0080\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/core/widget/ShowSeparatorsMode;", "", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public @interface ShowSeparatorsMode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int NONE = 0;
    public static final int SHOW_AT_END = 4;
    public static final int SHOW_AT_START = 1;
    public static final int SHOW_BETWEEN = 2;

    /* JADX INFO: compiled from: ShowSeparatorsMode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div/core/widget/ShowSeparatorsMode$Companion;", "", "()V", "NONE", "", "SHOW_AT_END", "SHOW_AT_START", "SHOW_BETWEEN", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int NONE = 0;
        public static final int SHOW_AT_END = 4;
        public static final int SHOW_AT_START = 1;
        public static final int SHOW_BETWEEN = 2;

        private Companion() {
        }
    }
}
