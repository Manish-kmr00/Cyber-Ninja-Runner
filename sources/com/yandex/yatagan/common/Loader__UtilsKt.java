package com.yandex.yatagan.common;

import com.yandex.yatagan.Component;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0000\u001a%\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"loadImplementationClass", "Ljava/lang/Class;", "componentClass", "splitComponentName", "Lkotlin/Pair;", "", "clazz", "splitComponentName$Loader__UtilsKt", "common"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "com/yandex/yatagan/common/Loader")
final /* synthetic */ class Loader__UtilsKt {
    public static final Class<?> loadImplementationClass(Class<?> componentClass) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(componentClass, "componentClass");
        Component component = (Component) componentClass.getAnnotation(Component.class);
        if (component == null || !component.isRoot()) {
            throw new IllegalArgumentException((componentClass + " is not a root Yatagan component").toString());
        }
        Pair<String, String> pairSplitComponentName$Loader__UtilsKt = splitComponentName$Loader__UtilsKt(componentClass);
        Class<?> clsLoadClass = componentClass.getClassLoader().loadClass(pairSplitComponentName$Loader__UtilsKt.component1() + ".Yatagan$" + pairSplitComponentName$Loader__UtilsKt.component2());
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "componentClass.classLoad…Class(implementationName)");
        return clsLoadClass;
    }

    private static final Pair<String, String> splitComponentName$Loader__UtilsKt(Class<?> cls) {
        String name = cls.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) name, '.', 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return TuplesKt.to("", name);
        }
        String strSubstring = name.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = name.substring(iLastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        return TuplesKt.to(strSubstring, strSubstring2);
    }
}
