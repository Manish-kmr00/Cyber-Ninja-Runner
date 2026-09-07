package com.yandex.div.evaluable.function;

import com.yandex.div.evaluable.types.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ColorFunctions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/evaluable/function/ColorRedComponentSetter;", "Lcom/yandex/div/evaluable/function/ColorComponentSetter;", "()V", "name", "", "getName", "()Ljava/lang/String;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ColorRedComponentSetter extends ColorComponentSetter {
    public static final ColorRedComponentSetter INSTANCE = new ColorRedComponentSetter();
    private static final String name = "setColorRed";

    private ColorRedComponentSetter() {
        super(new Function2<Color, Double, Color>() { // from class: com.yandex.div.evaluable.function.ColorRedComponentSetter.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Color invoke(Color color, Double d) {
                return Color.m6217boximpl(m6182invokeGnj5c28(color.m6225unboximpl(), d.doubleValue()));
            }

            /* JADX INFO: renamed from: invoke-Gnj5c28, reason: not valid java name */
            public final int m6182invokeGnj5c28(int i, double d) {
                return Color.INSTANCE.m6226argbH0kstlE(Color.m6215alphaimpl(i), ColorFunctionsKt.toColorIntComponentValue(d), Color.m6221greenimpl(i), Color.m6216blueimpl(i));
            }
        });
    }

    @Override // com.yandex.div.evaluable.Function
    public String getName() {
        return name;
    }
}
