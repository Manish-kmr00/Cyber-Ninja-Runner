package com.yandex.div2;

import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivAnimationDirection.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/yandex/div2/DivAnimationDirection;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "NORMAL", "REVERSE", "ALTERNATE", "ALTERNATE_REVERSE", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum DivAnimationDirection {
    NORMAL(Constants.NORMAL),
    REVERSE("reverse"),
    ALTERNATE("alternate"),
    ALTERNATE_REVERSE("alternate_reverse");

    private final String value;

    /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Function1<DivAnimationDirection, String> TO_STRING = new Function1<DivAnimationDirection, String>() { // from class: com.yandex.div2.DivAnimationDirection$Converter$TO_STRING$1
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(DivAnimationDirection value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return DivAnimationDirection.INSTANCE.toString(value);
        }
    };
    public static final Function1<String, DivAnimationDirection> FROM_STRING = new Function1<String, DivAnimationDirection>() { // from class: com.yandex.div2.DivAnimationDirection$Converter$FROM_STRING$1
        @Override // kotlin.jvm.functions.Function1
        public final DivAnimationDirection invoke(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return DivAnimationDirection.INSTANCE.fromString(value);
        }
    };

    DivAnimationDirection(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: com.yandex.div2.DivAnimationDirection$Converter, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DivAnimationDirection.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivAnimationDirection$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivAnimationDirection;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toString(DivAnimationDirection obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return obj.value;
        }

        public final DivAnimationDirection fromString(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, DivAnimationDirection.NORMAL.value)) {
                return DivAnimationDirection.NORMAL;
            }
            if (Intrinsics.areEqual(value, DivAnimationDirection.REVERSE.value)) {
                return DivAnimationDirection.REVERSE;
            }
            if (Intrinsics.areEqual(value, DivAnimationDirection.ALTERNATE.value)) {
                return DivAnimationDirection.ALTERNATE;
            }
            if (Intrinsics.areEqual(value, DivAnimationDirection.ALTERNATE_REVERSE.value)) {
                return DivAnimationDirection.ALTERNATE_REVERSE;
            }
            return null;
        }
    }
}
