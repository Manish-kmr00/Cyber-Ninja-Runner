package com.yandex.div.core.util.validator;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpressionValidator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/util/validator/ExpressionValidator;", "Lcom/yandex/div/core/util/validator/BaseValidator;", "allowEmpty", "", "calculateExpression", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)V", "getCalculateExpression", "()Lkotlin/jvm/functions/Function0;", "validate", "input", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExpressionValidator extends BaseValidator {
    private final Function0<Boolean> calculateExpression;

    public final Function0<Boolean> getCalculateExpression() {
        return this.calculateExpression;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressionValidator(boolean z, Function0<Boolean> calculateExpression) {
        super(z);
        Intrinsics.checkNotNullParameter(calculateExpression, "calculateExpression");
        this.calculateExpression = calculateExpression;
    }

    @Override // com.yandex.div.core.util.validator.BaseValidator
    public boolean validate(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return (getAllowEmpty() && input.length() == 0) || this.calculateExpression.invoke().booleanValue();
    }
}
