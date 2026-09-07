package com.yandex.div.core.util.mask;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FixedLengthInputMask.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u00020\b2\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/util/mask/FixedLengthInputMask;", "Lcom/yandex/div/core/util/mask/BaseInputMask;", "initialMaskData", "Lcom/yandex/div/core/util/mask/BaseInputMask$MaskData;", "onError", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "(Lcom/yandex/div/core/util/mask/BaseInputMask$MaskData;Lkotlin/jvm/functions/Function1;)V", "onException", "exception", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class FixedLengthInputMask extends BaseInputMask {
    private final Function1<Exception, Unit> onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FixedLengthInputMask(BaseInputMask.MaskData initialMaskData, Function1<? super Exception, Unit> onError) {
        super(initialMaskData);
        Intrinsics.checkNotNullParameter(initialMaskData, "initialMaskData");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.onError = onError;
    }

    @Override // com.yandex.div.core.util.mask.BaseInputMask
    public void onException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.onError.invoke(exception);
    }
}
