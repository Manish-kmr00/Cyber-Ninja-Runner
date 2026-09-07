package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import com.json.cc;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.appmetrica.analytics.impl.J2;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivFocus.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0002\u001b\u001cBU\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004¢\u0006\u0002\u0010\rJT\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004J \u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yandex/div2/DivFocus;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", J2.g, "", "Lcom/yandex/div2/DivBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "nextFocusIds", "Lcom/yandex/div2/DivFocus$NextFocusIds;", "onBlur", "Lcom/yandex/div2/DivAction;", "onFocus", "(Ljava/util/List;Lcom/yandex/div2/DivBorder;Lcom/yandex/div2/DivFocus$NextFocusIds;Ljava/util/List;Ljava/util/List;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "NextFocusIds", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivFocus implements JSONSerializable, Hashable {
    private Integer _hash;
    public final List<DivBackground> background;
    public final DivBorder border;
    public final NextFocusIds nextFocusIds;
    public final List<DivAction> onBlur;
    public final List<DivAction> onFocus;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivFocus> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivFocus>() { // from class: com.yandex.div2.DivFocus$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivFocus invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivFocus.INSTANCE.fromJson(env, it);
        }
    };

    public DivFocus() {
        this(null, null, null, null, null, 31, null);
    }

    @JvmStatic
    public static final DivFocus fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DivFocus(List<? extends DivBackground> list, DivBorder divBorder, NextFocusIds nextFocusIds, List<DivAction> list2, List<DivAction> list3) {
        this.background = list;
        this.border = divBorder;
        this.nextFocusIds = nextFocusIds;
        this.onBlur = list2;
        this.onFocus = list3;
    }

    public /* synthetic */ DivFocus(List list, DivBorder divBorder, NextFocusIds nextFocusIds, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : divBorder, (i & 4) != 0 ? null : nextFocusIds, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : list3);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        int iHash;
        int iHash2;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        List<DivBackground> list = this.background;
        int iHash3 = 0;
        if (list != null) {
            Iterator<T> it = list.iterator();
            iHash = 0;
            while (it.hasNext()) {
                iHash += ((DivBackground) it.next()).hash();
            }
        } else {
            iHash = 0;
        }
        int i = iHashCode + iHash;
        DivBorder divBorder = this.border;
        int iHash4 = i + (divBorder != null ? divBorder.hash() : 0);
        NextFocusIds nextFocusIds = this.nextFocusIds;
        int iHash5 = iHash4 + (nextFocusIds != null ? nextFocusIds.hash() : 0);
        List<DivAction> list2 = this.onBlur;
        if (list2 != null) {
            Iterator<T> it2 = list2.iterator();
            iHash2 = 0;
            while (it2.hasNext()) {
                iHash2 += ((DivAction) it2.next()).hash();
            }
        } else {
            iHash2 = 0;
        }
        int i2 = iHash5 + iHash2;
        List<DivAction> list3 = this.onFocus;
        if (list3 != null) {
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                iHash3 += ((DivAction) it3.next()).hash();
            }
        }
        int i3 = i2 + iHash3;
        this._hash = Integer.valueOf(i3);
        return i3;
    }

    public final boolean equals(DivFocus other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        List<DivBackground> list = this.background;
        if (list != null) {
            List<DivBackground> list2 = other.background;
            if (list2 == null || list.size() != list2.size()) {
                return false;
            }
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((DivBackground) obj).equals(list2.get(i), resolver, otherResolver)) {
                    return false;
                }
                i = i2;
            }
        } else if (other.background != null) {
            return false;
        }
        DivBorder divBorder = this.border;
        if (!(divBorder != null ? divBorder.equals(other.border, resolver, otherResolver) : other.border == null)) {
            return false;
        }
        NextFocusIds nextFocusIds = this.nextFocusIds;
        if (!(nextFocusIds != null ? nextFocusIds.equals(other.nextFocusIds, resolver, otherResolver) : other.nextFocusIds == null)) {
            return false;
        }
        List<DivAction> list3 = this.onBlur;
        if (list3 != null) {
            List<DivAction> list4 = other.onBlur;
            if (list4 == null) {
                return false;
            }
            if (list3.size() == list4.size()) {
                Iterator<T> it = list3.iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next).equals(list4.get(i3), resolver, otherResolver)) {
                            i3 = i4;
                        }
                    }
                }
            }
        } else {
            z = other.onBlur == null;
        }
        if (!z) {
            return false;
        }
        List<DivAction> list5 = this.onFocus;
        List<DivAction> list6 = other.onFocus;
        if (list5 == null) {
            z2 = list6 == null;
        } else {
            if (list6 == null) {
                return false;
            }
            if (list5.size() == list6.size()) {
                Iterator<T> it2 = list5.iterator();
                int i5 = 0;
                while (true) {
                    if (it2.hasNext()) {
                        Object next2 = it2.next();
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (((DivAction) next2).equals(list6.get(i5), resolver, otherResolver)) {
                            i5 = i6;
                        }
                    }
                }
            }
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivFocus copy$default(DivFocus divFocus, List list, DivBorder divBorder, NextFocusIds nextFocusIds, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = divFocus.background;
        }
        if ((i & 2) != 0) {
            divBorder = divFocus.border;
        }
        DivBorder divBorder2 = divBorder;
        if ((i & 4) != 0) {
            nextFocusIds = divFocus.nextFocusIds;
        }
        NextFocusIds nextFocusIds2 = nextFocusIds;
        if ((i & 8) != 0) {
            list2 = divFocus.onBlur;
        }
        List list4 = list2;
        if ((i & 16) != 0) {
            list3 = divFocus.onFocus;
        }
        return divFocus.copy(list, divBorder2, nextFocusIds2, list4, list3);
    }

    public final DivFocus copy(List<? extends DivBackground> background, DivBorder border, NextFocusIds nextFocusIds, List<DivAction> onBlur, List<DivAction> onFocus) {
        return new DivFocus(background, border, nextFocusIds, onBlur, onFocus);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivFocusJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivFocus.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivFocus$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFocus;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivFocus fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivFocusJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivFocus> getCREATOR() {
            return DivFocus.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivFocus.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018Ba\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\nJ`\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J \u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div2/DivFocus$NextFocusIds;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "down", "Lcom/yandex/div/json/expressions/Expression;", "", ToolBar.FORWARD, "left", "right", "up", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NextFocusIds implements JSONSerializable, Hashable {
        private Integer _hash;
        public final Expression<String> down;
        public final Expression<String> forward;
        public final Expression<String> left;
        public final Expression<String> right;
        public final Expression<String> up;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, NextFocusIds> CREATOR = new Function2<ParsingEnvironment, JSONObject, NextFocusIds>() { // from class: com.yandex.div2.DivFocus$NextFocusIds$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivFocus.NextFocusIds invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivFocus.NextFocusIds.INSTANCE.fromJson(env, it);
            }
        };

        public NextFocusIds() {
            this(null, null, null, null, null, 31, null);
        }

        @JvmStatic
        public static final NextFocusIds fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public NextFocusIds(Expression<String> expression, Expression<String> expression2, Expression<String> expression3, Expression<String> expression4, Expression<String> expression5) {
            this.down = expression;
            this.forward = expression2;
            this.left = expression3;
            this.right = expression4;
            this.up = expression5;
        }

        public /* synthetic */ NextFocusIds(Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : expression, (i & 2) != 0 ? null : expression2, (i & 4) != 0 ? null : expression3, (i & 8) != 0 ? null : expression4, (i & 16) != 0 ? null : expression5);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
            Expression<String> expression = this.down;
            int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
            Expression<String> expression2 = this.forward;
            int iHashCode3 = iHashCode2 + (expression2 != null ? expression2.hashCode() : 0);
            Expression<String> expression3 = this.left;
            int iHashCode4 = iHashCode3 + (expression3 != null ? expression3.hashCode() : 0);
            Expression<String> expression4 = this.right;
            int iHashCode5 = iHashCode4 + (expression4 != null ? expression4.hashCode() : 0);
            Expression<String> expression5 = this.up;
            int iHashCode6 = iHashCode5 + (expression5 != null ? expression5.hashCode() : 0);
            this._hash = Integer.valueOf(iHashCode6);
            return iHashCode6;
        }

        public final boolean equals(NextFocusIds other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            if (other == null) {
                return false;
            }
            Expression<String> expression = this.down;
            String strEvaluate = expression != null ? expression.evaluate(resolver) : null;
            Expression<String> expression2 = other.down;
            if (!Intrinsics.areEqual(strEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<String> expression3 = this.forward;
            String strEvaluate2 = expression3 != null ? expression3.evaluate(resolver) : null;
            Expression<String> expression4 = other.forward;
            if (!Intrinsics.areEqual(strEvaluate2, expression4 != null ? expression4.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<String> expression5 = this.left;
            String strEvaluate3 = expression5 != null ? expression5.evaluate(resolver) : null;
            Expression<String> expression6 = other.left;
            if (!Intrinsics.areEqual(strEvaluate3, expression6 != null ? expression6.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<String> expression7 = this.right;
            String strEvaluate4 = expression7 != null ? expression7.evaluate(resolver) : null;
            Expression<String> expression8 = other.right;
            if (!Intrinsics.areEqual(strEvaluate4, expression8 != null ? expression8.evaluate(otherResolver) : null)) {
                return false;
            }
            Expression<String> expression9 = this.up;
            String strEvaluate5 = expression9 != null ? expression9.evaluate(resolver) : null;
            Expression<String> expression10 = other.up;
            return Intrinsics.areEqual(strEvaluate5, expression10 != null ? expression10.evaluate(otherResolver) : null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NextFocusIds copy$default(NextFocusIds nextFocusIds, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, int i, Object obj) {
            if ((i & 1) != 0) {
                expression = nextFocusIds.down;
            }
            if ((i & 2) != 0) {
                expression2 = nextFocusIds.forward;
            }
            Expression expression6 = expression2;
            if ((i & 4) != 0) {
                expression3 = nextFocusIds.left;
            }
            Expression expression7 = expression3;
            if ((i & 8) != 0) {
                expression4 = nextFocusIds.right;
            }
            Expression expression8 = expression4;
            if ((i & 16) != 0) {
                expression5 = nextFocusIds.up;
            }
            return nextFocusIds.copy(expression, expression6, expression7, expression8, expression5);
        }

        public final NextFocusIds copy(Expression<String> down, Expression<String> forward, Expression<String> left, Expression<String> right, Expression<String> up) {
            return new NextFocusIds(down, forward, left, right, up);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivFocusNextFocusIdsJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivFocus.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivFocus$NextFocusIds$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFocus$NextFocusIds;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final NextFocusIds fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivFocusNextFocusIdsJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, NextFocusIds> getCREATOR() {
                return NextFocusIds.CREATOR;
            }
        }
    }
}
