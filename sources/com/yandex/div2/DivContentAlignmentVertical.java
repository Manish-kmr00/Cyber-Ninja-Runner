package com.yandex.div2;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivContentAlignmentVertical.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivContentAlignmentVertical;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "TOP", "CENTER", "BOTTOM", "BASELINE", "SPACE_BETWEEN", "SPACE_AROUND", "SPACE_EVENLY", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum DivContentAlignmentVertical {
    TOP(ViewHierarchyConstants.DIMENSION_TOP_KEY),
    CENTER("center"),
    BOTTOM("bottom"),
    BASELINE("baseline"),
    SPACE_BETWEEN("space-between"),
    SPACE_AROUND("space-around"),
    SPACE_EVENLY("space-evenly");

    private final String value;

    /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Function1<DivContentAlignmentVertical, String> TO_STRING = new Function1<DivContentAlignmentVertical, String>() { // from class: com.yandex.div2.DivContentAlignmentVertical$Converter$TO_STRING$1
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(DivContentAlignmentVertical value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return DivContentAlignmentVertical.INSTANCE.toString(value);
        }
    };
    public static final Function1<String, DivContentAlignmentVertical> FROM_STRING = new Function1<String, DivContentAlignmentVertical>() { // from class: com.yandex.div2.DivContentAlignmentVertical$Converter$FROM_STRING$1
        @Override // kotlin.jvm.functions.Function1
        public final DivContentAlignmentVertical invoke(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return DivContentAlignmentVertical.INSTANCE.fromString(value);
        }
    };

    DivContentAlignmentVertical(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: com.yandex.div2.DivContentAlignmentVertical$Converter, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DivContentAlignmentVertical.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivContentAlignmentVertical$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivContentAlignmentVertical;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toString(DivContentAlignmentVertical obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return obj.value;
        }

        public final DivContentAlignmentVertical fromString(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, DivContentAlignmentVertical.TOP.value)) {
                return DivContentAlignmentVertical.TOP;
            }
            if (Intrinsics.areEqual(value, DivContentAlignmentVertical.CENTER.value)) {
                return DivContentAlignmentVertical.CENTER;
            }
            if (Intrinsics.areEqual(value, DivContentAlignmentVertical.BOTTOM.value)) {
                return DivContentAlignmentVertical.BOTTOM;
            }
            if (Intrinsics.areEqual(value, DivContentAlignmentVertical.BASELINE.value)) {
                return DivContentAlignmentVertical.BASELINE;
            }
            if (Intrinsics.areEqual(value, DivContentAlignmentVertical.SPACE_BETWEEN.value)) {
                return DivContentAlignmentVertical.SPACE_BETWEEN;
            }
            if (Intrinsics.areEqual(value, DivContentAlignmentVertical.SPACE_AROUND.value)) {
                return DivContentAlignmentVertical.SPACE_AROUND;
            }
            if (Intrinsics.areEqual(value, DivContentAlignmentVertical.SPACE_EVENLY.value)) {
                return DivContentAlignmentVertical.SPACE_EVENLY;
            }
            return null;
        }
    }
}
