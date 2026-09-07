package com.yandex.div.evaluable.function;

import com.yandex.div.evaluable.types.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ColorFunctions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/evaluable/function/ColorRedComponentGetter;", "Lcom/yandex/div/evaluable/function/ColorComponentGetter;", "()V", "name", "", "getName", "()Ljava/lang/String;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ColorRedComponentGetter extends ColorComponentGetter {
    public static final ColorRedComponentGetter INSTANCE = new ColorRedComponentGetter();
    private static final String name = "getColorRed";

    private ColorRedComponentGetter() {
        super(new Function1<Color, Integer>() { // from class: com.yandex.div.evaluable.function.ColorRedComponentGetter.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Color color) {
                return m6181invokecIhhviA(color.m6225unboximpl());
            }

            /* JADX INFO: renamed from: invoke-cIhhviA, reason: not valid java name */
            public final Integer m6181invokecIhhviA(int i) {
                return Integer.valueOf(Color.m6223redimpl(i));
            }
        });
    }

    @Override // com.yandex.div.evaluable.Function
    public String getName() {
        return name;
    }
}
