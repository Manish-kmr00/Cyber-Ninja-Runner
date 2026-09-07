package com.yandex.div.internal.core;

import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivVisitor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH$¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0004¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\rJ\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\u000fJ\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\u0011J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\u0013J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\u0015J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\u0017J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\u0019J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\u001bJ\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\u001dJ\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\u001fJ\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010!J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010#J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010%J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010'J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010)J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020*2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010+J\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020,2\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0002\u0010-¨\u0006."}, d2 = {"Lcom/yandex/div/internal/core/DivVisitor;", "T", "", "()V", "defaultVisit", "data", "Lcom/yandex/div2/Div;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Lcom/yandex/div2/Div;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "visit", "div", "Lcom/yandex/div2/Div$Container;", "(Lcom/yandex/div2/Div$Container;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Custom;", "(Lcom/yandex/div2/Div$Custom;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Gallery;", "(Lcom/yandex/div2/Div$Gallery;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$GifImage;", "(Lcom/yandex/div2/Div$GifImage;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Grid;", "(Lcom/yandex/div2/Div$Grid;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Image;", "(Lcom/yandex/div2/Div$Image;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Indicator;", "(Lcom/yandex/div2/Div$Indicator;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Input;", "(Lcom/yandex/div2/Div$Input;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Pager;", "(Lcom/yandex/div2/Div$Pager;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Select;", "(Lcom/yandex/div2/Div$Select;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Separator;", "(Lcom/yandex/div2/Div$Separator;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Slider;", "(Lcom/yandex/div2/Div$Slider;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$State;", "(Lcom/yandex/div2/Div$State;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Switch;", "(Lcom/yandex/div2/Div$Switch;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Tabs;", "(Lcom/yandex/div2/Div$Tabs;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Text;", "(Lcom/yandex/div2/Div$Text;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "Lcom/yandex/div2/Div$Video;", "(Lcom/yandex/div2/Div$Video;Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivVisitor<T> {
    protected abstract T defaultVisit(Div data, ExpressionResolver resolver);

    protected final T visit(Div div, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (div instanceof Div.Text) {
            return visit((Div.Text) div, resolver);
        }
        if (div instanceof Div.Image) {
            return visit((Div.Image) div, resolver);
        }
        if (div instanceof Div.GifImage) {
            return visit((Div.GifImage) div, resolver);
        }
        if (div instanceof Div.Separator) {
            return visit((Div.Separator) div, resolver);
        }
        if (div instanceof Div.Container) {
            return visit((Div.Container) div, resolver);
        }
        if (div instanceof Div.Grid) {
            return visit((Div.Grid) div, resolver);
        }
        if (div instanceof Div.Gallery) {
            return visit((Div.Gallery) div, resolver);
        }
        if (div instanceof Div.Pager) {
            return visit((Div.Pager) div, resolver);
        }
        if (div instanceof Div.Tabs) {
            return visit((Div.Tabs) div, resolver);
        }
        if (div instanceof Div.State) {
            return visit((Div.State) div, resolver);
        }
        if (div instanceof Div.Custom) {
            return visit((Div.Custom) div, resolver);
        }
        if (div instanceof Div.Indicator) {
            return visit((Div.Indicator) div, resolver);
        }
        if (div instanceof Div.Slider) {
            return visit((Div.Slider) div, resolver);
        }
        if (div instanceof Div.Input) {
            return visit((Div.Input) div, resolver);
        }
        if (div instanceof Div.Select) {
            return visit((Div.Select) div, resolver);
        }
        if (div instanceof Div.Video) {
            return visit((Div.Video) div, resolver);
        }
        if (div instanceof Div.Switch) {
            return visit((Div.Switch) div, resolver);
        }
        throw new NoWhenBranchMatchedException();
    }

    protected T visit(Div.Text data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Image data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.GifImage data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Separator data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Container data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Grid data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Gallery data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Pager data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Tabs data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.State data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Custom data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Indicator data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Slider data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Input data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Select data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Video data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }

    protected T visit(Div.Switch data, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return defaultVisit(data, resolver);
    }
}
