package com.yandex.div.core.images;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: compiled from: DivImagePriority.kt */
/* JADX INFO: loaded from: classes6.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/core/images/DivImagePriority;", "", "Companion", "div-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface DivImagePriority {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int IMAGES_PRIORITY_DEFAULT = 0;
    public static final int IMAGES_PRIORITY_PRELOAD = -1;

    /* JADX INFO: compiled from: DivImagePriority.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/yandex/div/core/images/DivImagePriority$Companion;", "", "()V", "IMAGES_PRIORITY_DEFAULT", "", "IMAGES_PRIORITY_PRELOAD", "div-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int IMAGES_PRIORITY_DEFAULT = 0;
        public static final int IMAGES_PRIORITY_PRELOAD = -1;

        private Companion() {
        }
    }
}
