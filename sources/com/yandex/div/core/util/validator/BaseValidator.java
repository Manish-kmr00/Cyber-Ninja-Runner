package com.yandex.div.core.util.validator;

import kotlin.Metadata;

/* JADX INFO: compiled from: BaseValidator.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yandex/div/core/util/validator/BaseValidator;", "", "allowEmpty", "", "(Z)V", "getAllowEmpty", "()Z", "validate", "input", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class BaseValidator {
    private final boolean allowEmpty;

    public abstract boolean validate(String input);

    public BaseValidator(boolean z) {
        this.allowEmpty = z;
    }

    public final boolean getAllowEmpty() {
        return this.allowEmpty;
    }
}
