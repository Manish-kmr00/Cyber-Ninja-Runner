package com.yandex.div.internal.template;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Field.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0005\b\t\n\u000b\fB\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/internal/template/Field;", "T", "", "type", "", "overridable", "", "(IZ)V", "Companion", "Null", "Placeholder", "Reference", "Value", "Lcom/yandex/div/internal/template/Field$Null;", "Lcom/yandex/div/internal/template/Field$Placeholder;", "Lcom/yandex/div/internal/template/Field$Reference;", "Lcom/yandex/div/internal/template/Field$Value;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class Field<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int TYPE_NULL = 0;
    public static final int TYPE_PLACEHOLDER = 1;
    public static final int TYPE_REFERENCE = 3;
    public static final int TYPE_VALUE = 2;
    public final boolean overridable;
    public final int type;

    public /* synthetic */ Field(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z);
    }

    private Field(int i, boolean z) {
        this.type = i;
        this.overridable = z;
    }

    /* JADX INFO: compiled from: Field.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/yandex/div/internal/template/Field$Null;", "Lcom/yandex/div/internal/template/Field;", "", "()V", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Null extends Field<Object> {
        public static final Null INSTANCE = new Null();

        private Null() {
            super(0, 0 == true ? 1 : 0, null);
        }
    }

    /* JADX INFO: compiled from: Field.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/yandex/div/internal/template/Field$Placeholder;", "Lcom/yandex/div/internal/template/Field;", "", "()V", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Placeholder extends Field<Object> {
        public static final Placeholder INSTANCE = new Placeholder();

        private Placeholder() {
            super(1, true ? 1 : 0, null);
        }
    }

    /* JADX INFO: compiled from: Field.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0005\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/yandex/div/internal/template/Field$Value;", "T", "Lcom/yandex/div/internal/template/Field;", "overridable", "", "value", "(ZLjava/lang/Object;)V", "Ljava/lang/Object;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Value<T> extends Field<T> {
        public final T value;

        public Value(boolean z, T t) {
            super(2, z, null);
            this.value = t;
        }
    }

    /* JADX INFO: compiled from: Field.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div/internal/template/Field$Reference;", "T", "Lcom/yandex/div/internal/template/Field;", "overridable", "", "reference", "", "(ZLjava/lang/String;)V", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Reference<T> extends Field<T> {
        public final String reference;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Reference(boolean z, String reference) {
            super(3, z, null);
            Intrinsics.checkNotNullParameter(reference, "reference");
            this.reference = reference;
        }
    }

    /* JADX INFO: compiled from: Field.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div/internal/template/Field$Companion;", "", "()V", "TYPE_NULL", "", "TYPE_PLACEHOLDER", "TYPE_REFERENCE", "TYPE_VALUE", "nullField", "Lcom/yandex/div/internal/template/Field;", "T", "overridable", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Field<T> nullField(boolean overridable) {
            Field<T> field = overridable ? Placeholder.INSTANCE : Null.INSTANCE;
            Intrinsics.checkNotNull(field, "null cannot be cast to non-null type com.yandex.div.internal.template.Field<T of com.yandex.div.internal.template.Field.Companion.nullField>");
            return field;
        }
    }
}
