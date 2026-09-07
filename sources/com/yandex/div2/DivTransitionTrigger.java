package com.yandex.div2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTransitionTrigger.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivTransitionTrigger;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "DATA_CHANGE", "STATE_CHANGE", "VISIBILITY_CHANGE", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum DivTransitionTrigger {
    DATA_CHANGE("data_change"),
    STATE_CHANGE("state_change"),
    VISIBILITY_CHANGE("visibility_change");

    private final String value;

    /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Function1<DivTransitionTrigger, String> TO_STRING = new Function1<DivTransitionTrigger, String>() { // from class: com.yandex.div2.DivTransitionTrigger$Converter$TO_STRING$1
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(DivTransitionTrigger value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return DivTransitionTrigger.INSTANCE.toString(value);
        }
    };
    public static final Function1<String, DivTransitionTrigger> FROM_STRING = new Function1<String, DivTransitionTrigger>() { // from class: com.yandex.div2.DivTransitionTrigger$Converter$FROM_STRING$1
        @Override // kotlin.jvm.functions.Function1
        public final DivTransitionTrigger invoke(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return DivTransitionTrigger.INSTANCE.fromString(value);
        }
    };

    DivTransitionTrigger(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: com.yandex.div2.DivTransitionTrigger$Converter, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DivTransitionTrigger.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivTransitionTrigger$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivTransitionTrigger;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toString(DivTransitionTrigger obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return obj.value;
        }

        public final DivTransitionTrigger fromString(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, DivTransitionTrigger.DATA_CHANGE.value)) {
                return DivTransitionTrigger.DATA_CHANGE;
            }
            if (Intrinsics.areEqual(value, DivTransitionTrigger.STATE_CHANGE.value)) {
                return DivTransitionTrigger.STATE_CHANGE;
            }
            if (Intrinsics.areEqual(value, DivTransitionTrigger.VISIBILITY_CHANGE.value)) {
                return DivTransitionTrigger.VISIBILITY_CHANGE;
            }
            return null;
        }
    }
}
