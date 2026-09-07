package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Sets;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class VastResult<Result> {
    public final Set<Integer> errors;
    public final Result value;

    /* JADX WARN: Multi-variable type inference failed */
    private VastResult(Set set, Object obj) {
        this.errors = (Set) Objects.requireNonNull(set);
        this.value = obj;
    }

    public static <Result> VastResult<Result> error(int i) {
        return new VastResult<>(Collections.singleton(Integer.valueOf(i)), null);
    }

    public static <Result> VastResult<Result> error(Set<Integer> set) {
        return new VastResult<>(set, null);
    }

    public static class Builder<Result> {
        private Set errors;
        private Object value;

        public Builder<Result> setResult(Result result) {
            this.value = result;
            return this;
        }

        public Builder<Result> setErrors(Set<Integer> set) {
            this.errors = set;
            return this;
        }

        public VastResult<Result> build() {
            if (this.value == null && this.errors == null) {
                throw new IllegalStateException("VastResult should contain value or list of errors at least");
            }
            return new VastResult<>(Sets.toImmutableSet(this.errors), this.value);
        }
    }
}
