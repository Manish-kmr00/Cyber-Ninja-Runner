package com.yandex.div.core.view2.reuse.util;

import android.net.Uri;
import com.yandex.div.core.view2.reuse.ExistingToken;
import com.yandex.div.core.view2.reuse.NewToken;
import com.yandex.div.core.view2.reuse.RebindTask;
import com.yandex.div.core.view2.reuse.ReusableTokenList;
import com.yandex.div.internal.Log;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div2.Div;
import com.yandex.div2.DivState;
import com.yandex.div2.DivTabs;
import com.yandex.div2.DivVideoSource;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RebindLogUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bH\u0000\u001a8\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, d2 = {"logRebindDiff", "", "reusableList", "Lcom/yandex/div/core/view2/reuse/ReusableTokenList;", "bindingPoints", "", "Lcom/yandex/div/core/view2/reuse/ExistingToken;", "aloneExisting", "", "aloneNew", "Lcom/yandex/div/core/view2/reuse/NewToken;", "printSelf", "Lcom/yandex/div2/Div;", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "step", "", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class RebindLogUtilsKt {
    public static final void logRebindDiff(ReusableTokenList reusableList, Set<ExistingToken> bindingPoints, List<ExistingToken> aloneExisting, List<NewToken> aloneNew) {
        Intrinsics.checkNotNullParameter(reusableList, "reusableList");
        Intrinsics.checkNotNullParameter(bindingPoints, "bindingPoints");
        Intrinsics.checkNotNullParameter(aloneExisting, "aloneExisting");
        Intrinsics.checkNotNullParameter(aloneNew, "aloneNew");
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = sb.append(StringsKt.trimIndent("\n        -----------\n        Calculated:\n        \n        bindingPoints [" + bindingPoints.size() + "]: \n        "));
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend.append('\n'), "append(...)");
        Iterator<T> it = bindingPoints.iterator();
        while (it.hasNext()) {
            printSelf$default(((ExistingToken) it.next()).getItem().getDiv(), reusableList, bindingPoints, sb, 0, 8, null);
        }
        StringBuilder sbAppend2 = sb.append("\nreuse [" + reusableList.count() + "]: ");
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend2.append('\n'), "append(...)");
        Iterator<T> it2 = reusableList.asList().iterator();
        while (it2.hasNext()) {
            printSelf$default(((ExistingToken) it2.next()).getItem().getDiv(), reusableList, bindingPoints, sb, 0, 8, null);
        }
        StringBuilder sbAppend3 = sb.append("\nremoved [" + aloneExisting.size() + "]: ");
        Intrinsics.checkNotNullExpressionValue(sbAppend3, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend3.append('\n'), "append(...)");
        Iterator<T> it3 = aloneExisting.iterator();
        while (it3.hasNext()) {
            printSelf$default(((ExistingToken) it3.next()).getItem().getDiv(), reusableList, bindingPoints, sb, 0, 8, null);
        }
        StringBuilder sbAppend4 = sb.append("\nnew [" + aloneNew.size() + "]: ");
        Intrinsics.checkNotNullExpressionValue(sbAppend4, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend4.append('\n'), "append(...)");
        Iterator<T> it4 = aloneNew.iterator();
        while (it4.hasNext()) {
            printSelf$default(((NewToken) it4.next()).getItem().getDiv(), reusableList, bindingPoints, sb, 0, 8, null);
        }
        StringBuilder sbAppend5 = sb.append("-----------");
        Intrinsics.checkNotNullExpressionValue(sbAppend5, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend5.append('\n'), "append(...)");
        Log.d(RebindTask.TAG, sb.toString());
    }

    static /* synthetic */ void printSelf$default(Div div, ReusableTokenList reusableTokenList, Set set, StringBuilder sb, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 1;
        }
        printSelf(div, reusableTokenList, set, sb, i);
    }

    private static final void printSelf(Div div, ReusableTokenList reusableTokenList, Set<ExistingToken> set, StringBuilder sb, int i) {
        Object rawValue;
        Object next;
        String string;
        Expression<Uri> expression;
        String str = StringsKt.repeat("|  ", i - 1) + "|--" + Reflection.getOrCreateKotlinClass(div.value().getClass());
        if (reusableTokenList.contains(div)) {
            str = str + " (reusable)";
        }
        Iterator<T> it = set.iterator();
        do {
            rawValue = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((ExistingToken) next).getDivHash() != div.propertiesHash());
        if (((ExistingToken) next) != null) {
            str = str + " (binding)";
        }
        StringBuilder sbAppend = new StringBuilder().append(str);
        if (div instanceof Div.Text) {
            string = ": " + StringsKt.replace$default(((Div.Text) div).getValue().text.getRawValue().toString(), "\n", " \\n ", false, 4, (Object) null);
        } else if (div instanceof Div.Image) {
            string = ": " + ((Div.Image) div).getValue().imageUrl.getRawValue();
        } else if (div instanceof Div.GifImage) {
            string = ": " + ((Div.GifImage) div).getValue().gifUrl.getRawValue();
        } else if (div instanceof Div.Video) {
            StringBuilder sb2 = new StringBuilder(": ");
            DivVideoSource divVideoSource = (DivVideoSource) CollectionsKt.firstOrNull((List) ((Div.Video) div).getValue().videoSources);
            if (divVideoSource != null && (expression = divVideoSource.url) != null) {
                rawValue = expression.getRawValue();
            }
            string = sb2.append(rawValue).toString();
        } else {
            string = "";
        }
        StringBuilder sbAppend2 = sb.append(sbAppend.append(string).toString());
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append(...)");
        Intrinsics.checkNotNullExpressionValue(sbAppend2.append('\n'), "append(...)");
        if (div instanceof Div.Container) {
            List<Div> list = ((Div.Container) div).getValue().items;
            if (list != null) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    printSelf((Div) it2.next(), reusableTokenList, set, sb, i + 1);
                }
                return;
            }
            return;
        }
        if (div instanceof Div.Grid) {
            List<Div> list2 = ((Div.Grid) div).getValue().items;
            if (list2 != null) {
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    printSelf((Div) it3.next(), reusableTokenList, set, sb, i + 1);
                }
                return;
            }
            return;
        }
        if (div instanceof Div.Gallery) {
            List<Div> list3 = ((Div.Gallery) div).getValue().items;
            if (list3 != null) {
                Iterator<T> it4 = list3.iterator();
                while (it4.hasNext()) {
                    printSelf((Div) it4.next(), reusableTokenList, set, sb, i + 1);
                }
                return;
            }
            return;
        }
        if (div instanceof Div.Pager) {
            List<Div> list4 = ((Div.Pager) div).getValue().items;
            if (list4 != null) {
                Iterator<T> it5 = list4.iterator();
                while (it5.hasNext()) {
                    printSelf((Div) it5.next(), reusableTokenList, set, sb, i + 1);
                }
                return;
            }
            return;
        }
        if (!(div instanceof Div.Tabs)) {
            if (div instanceof Div.State) {
                Iterator<T> it6 = ((Div.State) div).getValue().states.iterator();
                while (it6.hasNext()) {
                    Div div2 = ((DivState.State) it6.next()).div;
                    if (div2 != null) {
                        printSelf(div2, reusableTokenList, set, sb, i + 1);
                    }
                }
                return;
            }
            return;
        }
        Iterator<T> it7 = ((Div.Tabs) div).getValue().items.iterator();
        while (it7.hasNext()) {
            printSelf(((DivTabs.Item) it7.next()).div, reusableTokenList, set, sb, i + 1);
        }
    }
}
