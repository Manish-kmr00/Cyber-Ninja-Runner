package com.yandex.div2;

import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivActionTyped.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0015\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'(B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0001\u0014)*+,-./0123456789:;<¨\u0006="}, d2 = {"Lcom/yandex/div2/DivActionTyped;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "()V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "value", "", "writeToJSON", "Lorg/json/JSONObject;", "AnimatorStart", "AnimatorStop", "ArrayInsertValue", "ArrayRemoveValue", "ArraySetValue", "ClearFocus", "Companion", "CopyToClipboard", "DictSetValue", "Download", "FocusElement", "HideTooltip", "ScrollBy", "ScrollTo", "SetState", "SetStoredValue", "SetVariable", "ShowTooltip", "Submit", "Timer", VastTagName.VIDEO, "Lcom/yandex/div2/DivActionTyped$AnimatorStart;", "Lcom/yandex/div2/DivActionTyped$AnimatorStop;", "Lcom/yandex/div2/DivActionTyped$ArrayInsertValue;", "Lcom/yandex/div2/DivActionTyped$ArrayRemoveValue;", "Lcom/yandex/div2/DivActionTyped$ArraySetValue;", "Lcom/yandex/div2/DivActionTyped$ClearFocus;", "Lcom/yandex/div2/DivActionTyped$CopyToClipboard;", "Lcom/yandex/div2/DivActionTyped$DictSetValue;", "Lcom/yandex/div2/DivActionTyped$Download;", "Lcom/yandex/div2/DivActionTyped$FocusElement;", "Lcom/yandex/div2/DivActionTyped$HideTooltip;", "Lcom/yandex/div2/DivActionTyped$ScrollBy;", "Lcom/yandex/div2/DivActionTyped$ScrollTo;", "Lcom/yandex/div2/DivActionTyped$SetState;", "Lcom/yandex/div2/DivActionTyped$SetStoredValue;", "Lcom/yandex/div2/DivActionTyped$SetVariable;", "Lcom/yandex/div2/DivActionTyped$ShowTooltip;", "Lcom/yandex/div2/DivActionTyped$Submit;", "Lcom/yandex/div2/DivActionTyped$Timer;", "Lcom/yandex/div2/DivActionTyped$Video;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivActionTyped implements JSONSerializable, Hashable {
    private Integer _hash;
    private Integer _propertiesHash;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivActionTyped> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivActionTyped>() { // from class: com.yandex.div2.DivActionTyped$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivActionTyped invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivActionTyped.INSTANCE.fromJson(env, it);
        }
    };

    public /* synthetic */ DivActionTyped(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final DivActionTyped fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) throws ParsingException {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$AnimatorStart;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionAnimatorStart;", "(Lcom/yandex/div2/DivActionAnimatorStart;)V", "getValue", "()Lcom/yandex/div2/DivActionAnimatorStart;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AnimatorStart extends DivActionTyped {
        private final DivActionAnimatorStart value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatorStart(DivActionAnimatorStart value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionAnimatorStart getValue() {
            return this.value;
        }
    }

    private DivActionTyped() {
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$AnimatorStop;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionAnimatorStop;", "(Lcom/yandex/div2/DivActionAnimatorStop;)V", "getValue", "()Lcom/yandex/div2/DivActionAnimatorStop;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AnimatorStop extends DivActionTyped {
        private final DivActionAnimatorStop value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatorStop(DivActionAnimatorStop value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionAnimatorStop getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$ArrayInsertValue;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionArrayInsertValue;", "(Lcom/yandex/div2/DivActionArrayInsertValue;)V", "getValue", "()Lcom/yandex/div2/DivActionArrayInsertValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ArrayInsertValue extends DivActionTyped {
        private final DivActionArrayInsertValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayInsertValue(DivActionArrayInsertValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionArrayInsertValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$ArrayRemoveValue;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionArrayRemoveValue;", "(Lcom/yandex/div2/DivActionArrayRemoveValue;)V", "getValue", "()Lcom/yandex/div2/DivActionArrayRemoveValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ArrayRemoveValue extends DivActionTyped {
        private final DivActionArrayRemoveValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayRemoveValue(DivActionArrayRemoveValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionArrayRemoveValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$ArraySetValue;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionArraySetValue;", "(Lcom/yandex/div2/DivActionArraySetValue;)V", "getValue", "()Lcom/yandex/div2/DivActionArraySetValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ArraySetValue extends DivActionTyped {
        private final DivActionArraySetValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArraySetValue(DivActionArraySetValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionArraySetValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$ClearFocus;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionClearFocus;", "(Lcom/yandex/div2/DivActionClearFocus;)V", "getValue", "()Lcom/yandex/div2/DivActionClearFocus;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ClearFocus extends DivActionTyped {
        private final DivActionClearFocus value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClearFocus(DivActionClearFocus value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionClearFocus getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$CopyToClipboard;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionCopyToClipboard;", "(Lcom/yandex/div2/DivActionCopyToClipboard;)V", "getValue", "()Lcom/yandex/div2/DivActionCopyToClipboard;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CopyToClipboard extends DivActionTyped {
        private final DivActionCopyToClipboard value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CopyToClipboard(DivActionCopyToClipboard value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionCopyToClipboard getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$DictSetValue;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionDictSetValue;", "(Lcom/yandex/div2/DivActionDictSetValue;)V", "getValue", "()Lcom/yandex/div2/DivActionDictSetValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DictSetValue extends DivActionTyped {
        private final DivActionDictSetValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DictSetValue(DivActionDictSetValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionDictSetValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$Download;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionDownload;", "(Lcom/yandex/div2/DivActionDownload;)V", "getValue", "()Lcom/yandex/div2/DivActionDownload;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Download extends DivActionTyped {
        private final DivActionDownload value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Download(DivActionDownload value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionDownload getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$FocusElement;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionFocusElement;", "(Lcom/yandex/div2/DivActionFocusElement;)V", "getValue", "()Lcom/yandex/div2/DivActionFocusElement;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class FocusElement extends DivActionTyped {
        private final DivActionFocusElement value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FocusElement(DivActionFocusElement value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionFocusElement getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$HideTooltip;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionHideTooltip;", "(Lcom/yandex/div2/DivActionHideTooltip;)V", "getValue", "()Lcom/yandex/div2/DivActionHideTooltip;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class HideTooltip extends DivActionTyped {
        private final DivActionHideTooltip value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HideTooltip(DivActionHideTooltip value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionHideTooltip getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$ScrollBy;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionScrollBy;", "(Lcom/yandex/div2/DivActionScrollBy;)V", "getValue", "()Lcom/yandex/div2/DivActionScrollBy;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ScrollBy extends DivActionTyped {
        private final DivActionScrollBy value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScrollBy(DivActionScrollBy value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionScrollBy getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$ScrollTo;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionScrollTo;", "(Lcom/yandex/div2/DivActionScrollTo;)V", "getValue", "()Lcom/yandex/div2/DivActionScrollTo;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ScrollTo extends DivActionTyped {
        private final DivActionScrollTo value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScrollTo(DivActionScrollTo value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionScrollTo getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$SetState;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionSetState;", "(Lcom/yandex/div2/DivActionSetState;)V", "getValue", "()Lcom/yandex/div2/DivActionSetState;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SetState extends DivActionTyped {
        private final DivActionSetState value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetState(DivActionSetState value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionSetState getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$SetStoredValue;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionSetStoredValue;", "(Lcom/yandex/div2/DivActionSetStoredValue;)V", "getValue", "()Lcom/yandex/div2/DivActionSetStoredValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SetStoredValue extends DivActionTyped {
        private final DivActionSetStoredValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetStoredValue(DivActionSetStoredValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionSetStoredValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$SetVariable;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionSetVariable;", "(Lcom/yandex/div2/DivActionSetVariable;)V", "getValue", "()Lcom/yandex/div2/DivActionSetVariable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SetVariable extends DivActionTyped {
        private final DivActionSetVariable value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetVariable(DivActionSetVariable value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionSetVariable getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$ShowTooltip;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionShowTooltip;", "(Lcom/yandex/div2/DivActionShowTooltip;)V", "getValue", "()Lcom/yandex/div2/DivActionShowTooltip;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ShowTooltip extends DivActionTyped {
        private final DivActionShowTooltip value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowTooltip(DivActionShowTooltip value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionShowTooltip getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$Submit;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionSubmit;", "(Lcom/yandex/div2/DivActionSubmit;)V", "getValue", "()Lcom/yandex/div2/DivActionSubmit;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Submit extends DivActionTyped {
        private final DivActionSubmit value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Submit(DivActionSubmit value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionSubmit getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$Timer;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionTimer;", "(Lcom/yandex/div2/DivActionTimer;)V", "getValue", "()Lcom/yandex/div2/DivActionTimer;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Timer extends DivActionTyped {
        private final DivActionTimer value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Timer(DivActionTimer value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionTimer getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTyped$Video;", "Lcom/yandex/div2/DivActionTyped;", "value", "Lcom/yandex/div2/DivActionVideo;", "(Lcom/yandex/div2/DivActionVideo;)V", "getValue", "()Lcom/yandex/div2/DivActionVideo;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Video extends DivActionTyped {
        private final DivActionVideo value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Video(DivActionVideo value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionVideo getValue() {
            return this.value;
        }
    }

    @Override // com.yandex.div.data.Hashable
    public int propertiesHash() {
        int iPropertiesHash;
        Integer num = this._propertiesHash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        if (this instanceof AnimatorStart) {
            iPropertiesHash = ((AnimatorStart) this).getValue().propertiesHash();
        } else if (this instanceof AnimatorStop) {
            iPropertiesHash = ((AnimatorStop) this).getValue().propertiesHash();
        } else if (this instanceof ArrayInsertValue) {
            iPropertiesHash = ((ArrayInsertValue) this).getValue().propertiesHash();
        } else if (this instanceof ArrayRemoveValue) {
            iPropertiesHash = ((ArrayRemoveValue) this).getValue().propertiesHash();
        } else if (this instanceof ArraySetValue) {
            iPropertiesHash = ((ArraySetValue) this).getValue().propertiesHash();
        } else if (this instanceof ClearFocus) {
            iPropertiesHash = ((ClearFocus) this).getValue().propertiesHash();
        } else if (this instanceof CopyToClipboard) {
            iPropertiesHash = ((CopyToClipboard) this).getValue().propertiesHash();
        } else if (this instanceof DictSetValue) {
            iPropertiesHash = ((DictSetValue) this).getValue().propertiesHash();
        } else if (this instanceof Download) {
            iPropertiesHash = ((Download) this).getValue().propertiesHash();
        } else if (this instanceof FocusElement) {
            iPropertiesHash = ((FocusElement) this).getValue().propertiesHash();
        } else if (this instanceof HideTooltip) {
            iPropertiesHash = ((HideTooltip) this).getValue().propertiesHash();
        } else if (this instanceof ScrollBy) {
            iPropertiesHash = ((ScrollBy) this).getValue().propertiesHash();
        } else if (this instanceof ScrollTo) {
            iPropertiesHash = ((ScrollTo) this).getValue().propertiesHash();
        } else if (this instanceof SetState) {
            iPropertiesHash = ((SetState) this).getValue().propertiesHash();
        } else if (this instanceof SetStoredValue) {
            iPropertiesHash = ((SetStoredValue) this).getValue().propertiesHash();
        } else if (this instanceof SetVariable) {
            iPropertiesHash = ((SetVariable) this).getValue().propertiesHash();
        } else if (this instanceof ShowTooltip) {
            iPropertiesHash = ((ShowTooltip) this).getValue().propertiesHash();
        } else if (this instanceof Submit) {
            iPropertiesHash = ((Submit) this).getValue().propertiesHash();
        } else if (this instanceof Timer) {
            iPropertiesHash = ((Timer) this).getValue().propertiesHash();
        } else {
            if (!(this instanceof Video)) {
                throw new NoWhenBranchMatchedException();
            }
            iPropertiesHash = ((Video) this).getValue().propertiesHash();
        }
        int i = iHashCode + iPropertiesHash;
        this._propertiesHash = Integer.valueOf(i);
        return i;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        int iHash;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        if (this instanceof AnimatorStart) {
            iHash = ((AnimatorStart) this).getValue().hash();
        } else if (this instanceof AnimatorStop) {
            iHash = ((AnimatorStop) this).getValue().hash();
        } else if (this instanceof ArrayInsertValue) {
            iHash = ((ArrayInsertValue) this).getValue().hash();
        } else if (this instanceof ArrayRemoveValue) {
            iHash = ((ArrayRemoveValue) this).getValue().hash();
        } else if (this instanceof ArraySetValue) {
            iHash = ((ArraySetValue) this).getValue().hash();
        } else if (this instanceof ClearFocus) {
            iHash = ((ClearFocus) this).getValue().hash();
        } else if (this instanceof CopyToClipboard) {
            iHash = ((CopyToClipboard) this).getValue().hash();
        } else if (this instanceof DictSetValue) {
            iHash = ((DictSetValue) this).getValue().hash();
        } else if (this instanceof Download) {
            iHash = ((Download) this).getValue().hash();
        } else if (this instanceof FocusElement) {
            iHash = ((FocusElement) this).getValue().hash();
        } else if (this instanceof HideTooltip) {
            iHash = ((HideTooltip) this).getValue().hash();
        } else if (this instanceof ScrollBy) {
            iHash = ((ScrollBy) this).getValue().hash();
        } else if (this instanceof ScrollTo) {
            iHash = ((ScrollTo) this).getValue().hash();
        } else if (this instanceof SetState) {
            iHash = ((SetState) this).getValue().hash();
        } else if (this instanceof SetStoredValue) {
            iHash = ((SetStoredValue) this).getValue().hash();
        } else if (this instanceof SetVariable) {
            iHash = ((SetVariable) this).getValue().hash();
        } else if (this instanceof ShowTooltip) {
            iHash = ((ShowTooltip) this).getValue().hash();
        } else if (this instanceof Submit) {
            iHash = ((Submit) this).getValue().hash();
        } else if (this instanceof Timer) {
            iHash = ((Timer) this).getValue().hash();
        } else {
            if (!(this instanceof Video)) {
                throw new NoWhenBranchMatchedException();
            }
            iHash = ((Video) this).getValue().hash();
        }
        int i = iHashCode + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivActionTyped other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        if (this instanceof AnimatorStart) {
            DivActionAnimatorStart value = ((AnimatorStart) this).getValue();
            Object objValue = other.value();
            return value.equals(objValue instanceof DivActionAnimatorStart ? (DivActionAnimatorStart) objValue : null, resolver, otherResolver);
        }
        if (this instanceof AnimatorStop) {
            DivActionAnimatorStop value2 = ((AnimatorStop) this).getValue();
            Object objValue2 = other.value();
            return value2.equals(objValue2 instanceof DivActionAnimatorStop ? (DivActionAnimatorStop) objValue2 : null, resolver, otherResolver);
        }
        if (this instanceof ArrayInsertValue) {
            DivActionArrayInsertValue value3 = ((ArrayInsertValue) this).getValue();
            Object objValue3 = other.value();
            return value3.equals(objValue3 instanceof DivActionArrayInsertValue ? (DivActionArrayInsertValue) objValue3 : null, resolver, otherResolver);
        }
        if (this instanceof ArrayRemoveValue) {
            DivActionArrayRemoveValue value4 = ((ArrayRemoveValue) this).getValue();
            Object objValue4 = other.value();
            return value4.equals(objValue4 instanceof DivActionArrayRemoveValue ? (DivActionArrayRemoveValue) objValue4 : null, resolver, otherResolver);
        }
        if (this instanceof ArraySetValue) {
            DivActionArraySetValue value5 = ((ArraySetValue) this).getValue();
            Object objValue5 = other.value();
            return value5.equals(objValue5 instanceof DivActionArraySetValue ? (DivActionArraySetValue) objValue5 : null, resolver, otherResolver);
        }
        if (this instanceof ClearFocus) {
            DivActionClearFocus value6 = ((ClearFocus) this).getValue();
            Object objValue6 = other.value();
            return value6.equals(objValue6 instanceof DivActionClearFocus ? (DivActionClearFocus) objValue6 : null, resolver, otherResolver);
        }
        if (this instanceof CopyToClipboard) {
            DivActionCopyToClipboard value7 = ((CopyToClipboard) this).getValue();
            Object objValue7 = other.value();
            return value7.equals(objValue7 instanceof DivActionCopyToClipboard ? (DivActionCopyToClipboard) objValue7 : null, resolver, otherResolver);
        }
        if (this instanceof DictSetValue) {
            DivActionDictSetValue value8 = ((DictSetValue) this).getValue();
            Object objValue8 = other.value();
            return value8.equals(objValue8 instanceof DivActionDictSetValue ? (DivActionDictSetValue) objValue8 : null, resolver, otherResolver);
        }
        if (this instanceof Download) {
            DivActionDownload value9 = ((Download) this).getValue();
            Object objValue9 = other.value();
            return value9.equals(objValue9 instanceof DivActionDownload ? (DivActionDownload) objValue9 : null, resolver, otherResolver);
        }
        if (this instanceof FocusElement) {
            DivActionFocusElement value10 = ((FocusElement) this).getValue();
            Object objValue10 = other.value();
            return value10.equals(objValue10 instanceof DivActionFocusElement ? (DivActionFocusElement) objValue10 : null, resolver, otherResolver);
        }
        if (this instanceof HideTooltip) {
            DivActionHideTooltip value11 = ((HideTooltip) this).getValue();
            Object objValue11 = other.value();
            return value11.equals(objValue11 instanceof DivActionHideTooltip ? (DivActionHideTooltip) objValue11 : null, resolver, otherResolver);
        }
        if (this instanceof ScrollBy) {
            DivActionScrollBy value12 = ((ScrollBy) this).getValue();
            Object objValue12 = other.value();
            return value12.equals(objValue12 instanceof DivActionScrollBy ? (DivActionScrollBy) objValue12 : null, resolver, otherResolver);
        }
        if (this instanceof ScrollTo) {
            DivActionScrollTo value13 = ((ScrollTo) this).getValue();
            Object objValue13 = other.value();
            return value13.equals(objValue13 instanceof DivActionScrollTo ? (DivActionScrollTo) objValue13 : null, resolver, otherResolver);
        }
        if (this instanceof SetState) {
            DivActionSetState value14 = ((SetState) this).getValue();
            Object objValue14 = other.value();
            return value14.equals(objValue14 instanceof DivActionSetState ? (DivActionSetState) objValue14 : null, resolver, otherResolver);
        }
        if (this instanceof SetStoredValue) {
            DivActionSetStoredValue value15 = ((SetStoredValue) this).getValue();
            Object objValue15 = other.value();
            return value15.equals(objValue15 instanceof DivActionSetStoredValue ? (DivActionSetStoredValue) objValue15 : null, resolver, otherResolver);
        }
        if (this instanceof SetVariable) {
            DivActionSetVariable value16 = ((SetVariable) this).getValue();
            Object objValue16 = other.value();
            return value16.equals(objValue16 instanceof DivActionSetVariable ? (DivActionSetVariable) objValue16 : null, resolver, otherResolver);
        }
        if (this instanceof ShowTooltip) {
            DivActionShowTooltip value17 = ((ShowTooltip) this).getValue();
            Object objValue17 = other.value();
            return value17.equals(objValue17 instanceof DivActionShowTooltip ? (DivActionShowTooltip) objValue17 : null, resolver, otherResolver);
        }
        if (this instanceof Submit) {
            DivActionSubmit value18 = ((Submit) this).getValue();
            Object objValue18 = other.value();
            return value18.equals(objValue18 instanceof DivActionSubmit ? (DivActionSubmit) objValue18 : null, resolver, otherResolver);
        }
        if (this instanceof Timer) {
            DivActionTimer value19 = ((Timer) this).getValue();
            Object objValue19 = other.value();
            return value19.equals(objValue19 instanceof DivActionTimer ? (DivActionTimer) objValue19 : null, resolver, otherResolver);
        }
        if (!(this instanceof Video)) {
            throw new NoWhenBranchMatchedException();
        }
        DivActionVideo value20 = ((Video) this).getValue();
        Object objValue20 = other.value();
        return value20.equals(objValue20 instanceof DivActionVideo ? (DivActionVideo) objValue20 : null, resolver, otherResolver);
    }

    public final Object value() {
        if (this instanceof AnimatorStart) {
            return ((AnimatorStart) this).getValue();
        }
        if (this instanceof AnimatorStop) {
            return ((AnimatorStop) this).getValue();
        }
        if (this instanceof ArrayInsertValue) {
            return ((ArrayInsertValue) this).getValue();
        }
        if (this instanceof ArrayRemoveValue) {
            return ((ArrayRemoveValue) this).getValue();
        }
        if (this instanceof ArraySetValue) {
            return ((ArraySetValue) this).getValue();
        }
        if (this instanceof ClearFocus) {
            return ((ClearFocus) this).getValue();
        }
        if (this instanceof CopyToClipboard) {
            return ((CopyToClipboard) this).getValue();
        }
        if (this instanceof DictSetValue) {
            return ((DictSetValue) this).getValue();
        }
        if (this instanceof Download) {
            return ((Download) this).getValue();
        }
        if (this instanceof FocusElement) {
            return ((FocusElement) this).getValue();
        }
        if (this instanceof HideTooltip) {
            return ((HideTooltip) this).getValue();
        }
        if (this instanceof ScrollBy) {
            return ((ScrollBy) this).getValue();
        }
        if (this instanceof ScrollTo) {
            return ((ScrollTo) this).getValue();
        }
        if (this instanceof SetState) {
            return ((SetState) this).getValue();
        }
        if (this instanceof SetStoredValue) {
            return ((SetStoredValue) this).getValue();
        }
        if (this instanceof SetVariable) {
            return ((SetVariable) this).getValue();
        }
        if (this instanceof ShowTooltip) {
            return ((ShowTooltip) this).getValue();
        }
        if (this instanceof Submit) {
            return ((Submit) this).getValue();
        }
        if (this instanceof Timer) {
            return ((Timer) this).getValue();
        }
        if (this instanceof Video) {
            return ((Video) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionTypedJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivActionTyped.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivActionTyped$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionTyped;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivActionTyped fromJson(ParsingEnvironment env, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionTypedJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivActionTyped> getCREATOR() {
            return DivActionTyped.CREATOR;
        }
    }
}
