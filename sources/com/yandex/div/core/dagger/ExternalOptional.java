package com.yandex.div.core.dagger;

import com.yandex.yatagan.Optional;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExternalOptional.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\bB\u0015\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/dagger/ExternalOptional;", "T", "", "optional", "Lcom/yandex/yatagan/Optional;", "(Lcom/yandex/yatagan/Optional;)V", "getOptional", "()Lcom/yandex/yatagan/Optional;", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExternalOptional<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Optional<T> optional;

    @JvmStatic
    public static final <T> ExternalOptional<T> empty() {
        return INSTANCE.empty();
    }

    @JvmStatic
    public static final <T> ExternalOptional<T> of(T t) {
        return INSTANCE.of(t);
    }

    @JvmStatic
    public static final <T> ExternalOptional<T> ofNullable(T t) {
        return INSTANCE.ofNullable(t);
    }

    @JvmStatic
    public static final <T> ExternalOptional<T> wrap(Optional<? extends T> optional) {
        return INSTANCE.wrap(optional);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public ExternalOptional(Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, "optional");
        this.optional = optional;
    }

    public final Optional<T> getOptional() {
        return this.optional;
    }

    /* JADX INFO: compiled from: ExternalOptional.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0001H\u0007J%\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012\u0006\u0010\u0007\u001a\u0002H\u0005H\u0007¢\u0006\u0002\u0010\bJ'\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0005H\u0007¢\u0006\u0002\u0010\bJ&\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00050\fH\u0007¨\u0006\r"}, d2 = {"Lcom/yandex/div/core/dagger/ExternalOptional$Companion;", "", "()V", "empty", "Lcom/yandex/div/core/dagger/ExternalOptional;", "T", "of", "value", "(Ljava/lang/Object;)Lcom/yandex/div/core/dagger/ExternalOptional;", "ofNullable", "wrap", "optional", "Lcom/yandex/yatagan/Optional;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> ExternalOptional<T> wrap(Optional<? extends T> optional) {
            Intrinsics.checkNotNullParameter(optional, "optional");
            return new ExternalOptional<>(optional);
        }

        @JvmStatic
        public final <T> ExternalOptional<T> empty() {
            return new ExternalOptional<>(Optional.INSTANCE.empty());
        }

        @JvmStatic
        public final <T> ExternalOptional<T> of(T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new ExternalOptional<>(Optional.INSTANCE.of(value));
        }

        @JvmStatic
        public final <T> ExternalOptional<T> ofNullable(T value) {
            return value != null ? of(value) : empty();
        }
    }
}
