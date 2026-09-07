package com.yandex.div.internal.widget;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: compiled from: DivGravity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/internal/widget/DivGravity;", "", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface DivGravity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int HORIZONTAL_GRAVITY_MASK = 125829127;
    public static final int SPACE_AROUND_HORIZONTAL = 16777216;
    public static final int SPACE_AROUND_VERTICAL = 268435456;
    public static final int SPACE_BETWEEN_HORIZONTAL = 33554432;
    public static final int SPACE_BETWEEN_VERTICAL = 536870912;
    public static final int SPACE_EVENLY_HORIZONTAL = 67108864;
    public static final int SPACE_EVENLY_VERTICAL = 1073741824;
    public static final int VERTICAL_GRAVITY_MASK = 1879048304;

    /* JADX INFO: compiled from: DivGravity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0002X\u0083T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/internal/widget/DivGravity$Companion;", "", "()V", "AXIS_SPACE_AROUND", "", "AXIS_SPACE_BETWEEN", "AXIS_SPACE_EVENLY", "EXTRA_GRAVITY_AXIS", "HORIZONTAL_GRAVITY_MASK", "SPACE_AROUND_HORIZONTAL", "SPACE_AROUND_VERTICAL", "SPACE_BETWEEN_HORIZONTAL", "SPACE_BETWEEN_VERTICAL", "SPACE_EVENLY_HORIZONTAL", "SPACE_EVENLY_VERTICAL", "VERTICAL_GRAVITY_MASK", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int AXIS_SPACE_AROUND = 16777216;
        private static final int AXIS_SPACE_BETWEEN = 33554432;
        private static final int AXIS_SPACE_EVENLY = 67108864;
        private static final int EXTRA_GRAVITY_AXIS = 117440512;
        public static final int HORIZONTAL_GRAVITY_MASK = 125829127;
        public static final int SPACE_AROUND_HORIZONTAL = 16777216;
        public static final int SPACE_AROUND_VERTICAL = 268435456;
        public static final int SPACE_BETWEEN_HORIZONTAL = 33554432;
        public static final int SPACE_BETWEEN_VERTICAL = 536870912;
        public static final int SPACE_EVENLY_HORIZONTAL = 67108864;
        public static final int SPACE_EVENLY_VERTICAL = 1073741824;
        public static final int VERTICAL_GRAVITY_MASK = 1879048304;

        private Companion() {
        }
    }
}
