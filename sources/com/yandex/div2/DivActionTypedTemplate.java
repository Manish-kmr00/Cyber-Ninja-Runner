package com.yandex.div2;

import com.json.cc;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingException;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivActionTypedTemplate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0015\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0014&'()*+,-./0123456789¨\u0006:"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivActionTyped;", "()V", "type", "", "getType", "()Ljava/lang/String;", "resolve", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "data", "Lorg/json/JSONObject;", "value", "", "writeToJSON", "AnimatorStart", "AnimatorStop", "ArrayInsertValue", "ArrayRemoveValue", "ArraySetValue", "ClearFocus", "Companion", "CopyToClipboard", "DictSetValue", "Download", "FocusElement", "HideTooltip", "ScrollBy", "ScrollTo", "SetState", "SetStoredValue", "SetVariable", "ShowTooltip", "Submit", "Timer", VastTagName.VIDEO, "Lcom/yandex/div2/DivActionTypedTemplate$AnimatorStart;", "Lcom/yandex/div2/DivActionTypedTemplate$AnimatorStop;", "Lcom/yandex/div2/DivActionTypedTemplate$ArrayInsertValue;", "Lcom/yandex/div2/DivActionTypedTemplate$ArrayRemoveValue;", "Lcom/yandex/div2/DivActionTypedTemplate$ArraySetValue;", "Lcom/yandex/div2/DivActionTypedTemplate$ClearFocus;", "Lcom/yandex/div2/DivActionTypedTemplate$CopyToClipboard;", "Lcom/yandex/div2/DivActionTypedTemplate$DictSetValue;", "Lcom/yandex/div2/DivActionTypedTemplate$Download;", "Lcom/yandex/div2/DivActionTypedTemplate$FocusElement;", "Lcom/yandex/div2/DivActionTypedTemplate$HideTooltip;", "Lcom/yandex/div2/DivActionTypedTemplate$ScrollBy;", "Lcom/yandex/div2/DivActionTypedTemplate$ScrollTo;", "Lcom/yandex/div2/DivActionTypedTemplate$SetState;", "Lcom/yandex/div2/DivActionTypedTemplate$SetStoredValue;", "Lcom/yandex/div2/DivActionTypedTemplate$SetVariable;", "Lcom/yandex/div2/DivActionTypedTemplate$ShowTooltip;", "Lcom/yandex/div2/DivActionTypedTemplate$Submit;", "Lcom/yandex/div2/DivActionTypedTemplate$Timer;", "Lcom/yandex/div2/DivActionTypedTemplate$Video;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivActionTypedTemplate implements JSONSerializable, JsonTemplate<DivActionTyped> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivActionTypedTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivActionTypedTemplate>() { // from class: com.yandex.div2.DivActionTypedTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivActionTypedTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivActionTypedTemplate.Companion.invoke$default(DivActionTypedTemplate.INSTANCE, env, false, it, 2, null);
        }
    };

    public /* synthetic */ DivActionTypedTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$AnimatorStart;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionAnimatorStartTemplate;", "(Lcom/yandex/div2/DivActionAnimatorStartTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionAnimatorStartTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AnimatorStart extends DivActionTypedTemplate {
        private final DivActionAnimatorStartTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatorStart(DivActionAnimatorStartTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionAnimatorStartTemplate getValue() {
            return this.value;
        }
    }

    private DivActionTypedTemplate() {
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$AnimatorStop;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionAnimatorStopTemplate;", "(Lcom/yandex/div2/DivActionAnimatorStopTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionAnimatorStopTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AnimatorStop extends DivActionTypedTemplate {
        private final DivActionAnimatorStopTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatorStop(DivActionAnimatorStopTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionAnimatorStopTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$ArrayInsertValue;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionArrayInsertValueTemplate;", "(Lcom/yandex/div2/DivActionArrayInsertValueTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionArrayInsertValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ArrayInsertValue extends DivActionTypedTemplate {
        private final DivActionArrayInsertValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayInsertValue(DivActionArrayInsertValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionArrayInsertValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$ArrayRemoveValue;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionArrayRemoveValueTemplate;", "(Lcom/yandex/div2/DivActionArrayRemoveValueTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionArrayRemoveValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ArrayRemoveValue extends DivActionTypedTemplate {
        private final DivActionArrayRemoveValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayRemoveValue(DivActionArrayRemoveValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionArrayRemoveValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$ArraySetValue;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionArraySetValueTemplate;", "(Lcom/yandex/div2/DivActionArraySetValueTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionArraySetValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ArraySetValue extends DivActionTypedTemplate {
        private final DivActionArraySetValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArraySetValue(DivActionArraySetValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionArraySetValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$ClearFocus;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionClearFocusTemplate;", "(Lcom/yandex/div2/DivActionClearFocusTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionClearFocusTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ClearFocus extends DivActionTypedTemplate {
        private final DivActionClearFocusTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClearFocus(DivActionClearFocusTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionClearFocusTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$CopyToClipboard;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionCopyToClipboardTemplate;", "(Lcom/yandex/div2/DivActionCopyToClipboardTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionCopyToClipboardTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CopyToClipboard extends DivActionTypedTemplate {
        private final DivActionCopyToClipboardTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CopyToClipboard(DivActionCopyToClipboardTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionCopyToClipboardTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$DictSetValue;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionDictSetValueTemplate;", "(Lcom/yandex/div2/DivActionDictSetValueTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionDictSetValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DictSetValue extends DivActionTypedTemplate {
        private final DivActionDictSetValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DictSetValue(DivActionDictSetValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionDictSetValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$Download;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionDownloadTemplate;", "(Lcom/yandex/div2/DivActionDownloadTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionDownloadTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Download extends DivActionTypedTemplate {
        private final DivActionDownloadTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Download(DivActionDownloadTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionDownloadTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$FocusElement;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionFocusElementTemplate;", "(Lcom/yandex/div2/DivActionFocusElementTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionFocusElementTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class FocusElement extends DivActionTypedTemplate {
        private final DivActionFocusElementTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FocusElement(DivActionFocusElementTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionFocusElementTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$HideTooltip;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionHideTooltipTemplate;", "(Lcom/yandex/div2/DivActionHideTooltipTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionHideTooltipTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class HideTooltip extends DivActionTypedTemplate {
        private final DivActionHideTooltipTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HideTooltip(DivActionHideTooltipTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionHideTooltipTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$ScrollBy;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionScrollByTemplate;", "(Lcom/yandex/div2/DivActionScrollByTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionScrollByTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ScrollBy extends DivActionTypedTemplate {
        private final DivActionScrollByTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScrollBy(DivActionScrollByTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionScrollByTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$ScrollTo;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionScrollToTemplate;", "(Lcom/yandex/div2/DivActionScrollToTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionScrollToTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ScrollTo extends DivActionTypedTemplate {
        private final DivActionScrollToTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScrollTo(DivActionScrollToTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionScrollToTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$SetState;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionSetStateTemplate;", "(Lcom/yandex/div2/DivActionSetStateTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionSetStateTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SetState extends DivActionTypedTemplate {
        private final DivActionSetStateTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetState(DivActionSetStateTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionSetStateTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$SetStoredValue;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionSetStoredValueTemplate;", "(Lcom/yandex/div2/DivActionSetStoredValueTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionSetStoredValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SetStoredValue extends DivActionTypedTemplate {
        private final DivActionSetStoredValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetStoredValue(DivActionSetStoredValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionSetStoredValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$SetVariable;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionSetVariableTemplate;", "(Lcom/yandex/div2/DivActionSetVariableTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionSetVariableTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SetVariable extends DivActionTypedTemplate {
        private final DivActionSetVariableTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetVariable(DivActionSetVariableTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionSetVariableTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$ShowTooltip;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionShowTooltipTemplate;", "(Lcom/yandex/div2/DivActionShowTooltipTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionShowTooltipTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ShowTooltip extends DivActionTypedTemplate {
        private final DivActionShowTooltipTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowTooltip(DivActionShowTooltipTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionShowTooltipTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$Submit;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionSubmitTemplate;", "(Lcom/yandex/div2/DivActionSubmitTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionSubmitTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Submit extends DivActionTypedTemplate {
        private final DivActionSubmitTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Submit(DivActionSubmitTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionSubmitTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$Timer;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionTimerTemplate;", "(Lcom/yandex/div2/DivActionTimerTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionTimerTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Timer extends DivActionTypedTemplate {
        private final DivActionTimerTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Timer(DivActionTimerTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionTimerTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$Video;", "Lcom/yandex/div2/DivActionTypedTemplate;", "value", "Lcom/yandex/div2/DivActionVideoTemplate;", "(Lcom/yandex/div2/DivActionVideoTemplate;)V", "getValue", "()Lcom/yandex/div2/DivActionVideoTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Video extends DivActionTypedTemplate {
        private final DivActionVideoTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Video(DivActionVideoTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivActionVideoTemplate getValue() {
            return this.value;
        }
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
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionTypedJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivActionTyped resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionTypedJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    public final String getType() {
        if (this instanceof AnimatorStart) {
            return "animator_start";
        }
        if (this instanceof AnimatorStop) {
            return "animator_stop";
        }
        if (this instanceof ArrayInsertValue) {
            return "array_insert_value";
        }
        if (this instanceof ArrayRemoveValue) {
            return "array_remove_value";
        }
        if (this instanceof ArraySetValue) {
            return "array_set_value";
        }
        if (this instanceof ClearFocus) {
            return "clear_focus";
        }
        if (this instanceof CopyToClipboard) {
            return "copy_to_clipboard";
        }
        if (this instanceof DictSetValue) {
            return "dict_set_value";
        }
        if (this instanceof Download) {
            return "download";
        }
        if (this instanceof FocusElement) {
            return "focus_element";
        }
        if (this instanceof HideTooltip) {
            return "hide_tooltip";
        }
        if (this instanceof ScrollBy) {
            return "scroll_by";
        }
        if (this instanceof ScrollTo) {
            return "scroll_to";
        }
        if (this instanceof SetState) {
            return "set_state";
        }
        if (this instanceof SetStoredValue) {
            return "set_stored_value";
        }
        if (this instanceof SetVariable) {
            return "set_variable";
        }
        if (this instanceof ShowTooltip) {
            return "show_tooltip";
        }
        if (this instanceof Submit) {
            return "submit";
        }
        if (this instanceof Timer) {
            return "timer";
        }
        if (this instanceof Video) {
            return "video";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: DivActionTypedTemplate.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivActionTypedTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionTypedTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "topLevel", "", "json", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DivActionTypedTemplate invoke$default(Companion companion, ParsingEnvironment parsingEnvironment, boolean z, JSONObject jSONObject, int i, Object obj) throws ParsingException {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.invoke(parsingEnvironment, z, jSONObject);
        }

        public final DivActionTypedTemplate invoke(ParsingEnvironment env, boolean topLevel, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionTypedJsonTemplateParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivActionTypedTemplate> getCREATOR() {
            return DivActionTypedTemplate.CREATOR;
        }
    }
}
