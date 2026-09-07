package com.yandex.div.core.util.validator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: RegexValidator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/yandex/div/core/util/validator/RegexValidator;", "Lcom/yandex/div/core/util/validator/BaseValidator;", "regex", "Lkotlin/text/Regex;", "allowEmpty", "", "(Lkotlin/text/Regex;Z)V", "validate", "input", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RegexValidator extends BaseValidator {
    private final Regex regex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegexValidator(Regex regex, boolean z) {
        super(z);
        Intrinsics.checkNotNullParameter(regex, "regex");
        this.regex = regex;
    }

    @Override // com.yandex.div.core.util.validator.BaseValidator
    public boolean validate(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return (getAllowEmpty() && input.length() == 0) || this.regex.matches(input);
    }
}
