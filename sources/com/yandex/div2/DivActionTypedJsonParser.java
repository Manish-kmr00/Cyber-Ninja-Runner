package com.yandex.div2;

import com.yandex.div.data.EntityTemplate;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.serialization.Parser;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.TemplateResolver;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivActionTypedJsonParser.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivActionTypedJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedJsonParser {
    private final JsonParserComponent component;

    public DivActionTypedJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivActionTypedJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionTypedJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionTyped;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivActionTyped> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivActionTyped deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            switch (string.hashCode()) {
                case -1623648839:
                    if (string.equals("set_variable")) {
                        return new DivActionTyped.SetVariable(this.component.getDivActionSetVariableJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -1623635702:
                    if (string.equals("animator_start")) {
                        return new DivActionTyped.AnimatorStart(this.component.getDivActionAnimatorStartJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -1254965146:
                    if (string.equals("clear_focus")) {
                        return new DivActionTyped.ClearFocus(this.component.getDivActionClearFocusJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -1160753574:
                    if (string.equals("animator_stop")) {
                        return new DivActionTyped.AnimatorStop(this.component.getDivActionAnimatorStopJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -891535336:
                    if (string.equals("submit")) {
                        return new DivActionTyped.Submit(this.component.getDivActionSubmitJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -796594542:
                    if (string.equals("set_stored_value")) {
                        return new DivActionTyped.SetStoredValue(this.component.getDivActionSetStoredValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -404256420:
                    if (string.equals("copy_to_clipboard")) {
                        return new DivActionTyped.CopyToClipboard(this.component.getDivActionCopyToClipboardJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 10055918:
                    if (string.equals("array_set_value")) {
                        return new DivActionTyped.ArraySetValue(this.component.getDivActionArraySetValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 110364485:
                    if (string.equals("timer")) {
                        return new DivActionTyped.Timer(this.component.getDivActionTimerJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 112202875:
                    if (string.equals("video")) {
                        return new DivActionTyped.Video(this.component.getDivActionVideoJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 203934236:
                    if (string.equals("array_remove_value")) {
                        return new DivActionTyped.ArrayRemoveValue(this.component.getDivActionArrayRemoveValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 301532353:
                    if (string.equals("show_tooltip")) {
                        return new DivActionTyped.ShowTooltip(this.component.getDivActionShowTooltipJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 417790729:
                    if (string.equals("scroll_by")) {
                        return new DivActionTyped.ScrollBy(this.component.getDivActionScrollByJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 417791277:
                    if (string.equals("scroll_to")) {
                        return new DivActionTyped.ScrollTo(this.component.getDivActionScrollToJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 932090484:
                    if (string.equals("set_state")) {
                        return new DivActionTyped.SetState(this.component.getDivActionSetStateJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 1427818632:
                    if (string.equals("download")) {
                        return new DivActionTyped.Download(this.component.getDivActionDownloadJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 1550697109:
                    if (string.equals("focus_element")) {
                        return new DivActionTyped.FocusElement(this.component.getDivActionFocusElementJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 1587919371:
                    if (string.equals("dict_set_value")) {
                        return new DivActionTyped.DictSetValue(this.component.getDivActionDictSetValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 1715728902:
                    if (string.equals("hide_tooltip")) {
                        return new DivActionTyped.HideTooltip(this.component.getDivActionHideTooltipJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 1811437713:
                    if (string.equals("array_insert_value")) {
                        return new DivActionTyped.ArrayInsertValue(this.component.getDivActionArrayInsertValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
            }
            EntityTemplate orThrow = context.getTemplates().getOrThrow(string, data);
            DivActionTypedTemplate divActionTypedTemplate = orThrow instanceof DivActionTypedTemplate ? (DivActionTypedTemplate) orThrow : null;
            if (divActionTypedTemplate != null) {
                return this.component.getDivActionTypedJsonTemplateResolver().getValue().resolve(context, divActionTypedTemplate, data);
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivActionTyped value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivActionTyped.AnimatorStart) {
                return this.component.getDivActionAnimatorStartJsonEntityParser().getValue().serialize(context, ((DivActionTyped.AnimatorStart) value).getValue());
            }
            if (value instanceof DivActionTyped.AnimatorStop) {
                return this.component.getDivActionAnimatorStopJsonEntityParser().getValue().serialize(context, ((DivActionTyped.AnimatorStop) value).getValue());
            }
            if (value instanceof DivActionTyped.ArrayInsertValue) {
                return this.component.getDivActionArrayInsertValueJsonEntityParser().getValue().serialize(context, ((DivActionTyped.ArrayInsertValue) value).getValue());
            }
            if (value instanceof DivActionTyped.ArrayRemoveValue) {
                return this.component.getDivActionArrayRemoveValueJsonEntityParser().getValue().serialize(context, ((DivActionTyped.ArrayRemoveValue) value).getValue());
            }
            if (value instanceof DivActionTyped.ArraySetValue) {
                return this.component.getDivActionArraySetValueJsonEntityParser().getValue().serialize(context, ((DivActionTyped.ArraySetValue) value).getValue());
            }
            if (value instanceof DivActionTyped.ClearFocus) {
                return this.component.getDivActionClearFocusJsonEntityParser().getValue().serialize(context, ((DivActionTyped.ClearFocus) value).getValue());
            }
            if (value instanceof DivActionTyped.CopyToClipboard) {
                return this.component.getDivActionCopyToClipboardJsonEntityParser().getValue().serialize(context, ((DivActionTyped.CopyToClipboard) value).getValue());
            }
            if (value instanceof DivActionTyped.DictSetValue) {
                return this.component.getDivActionDictSetValueJsonEntityParser().getValue().serialize(context, ((DivActionTyped.DictSetValue) value).getValue());
            }
            if (value instanceof DivActionTyped.Download) {
                return this.component.getDivActionDownloadJsonEntityParser().getValue().serialize(context, ((DivActionTyped.Download) value).getValue());
            }
            if (value instanceof DivActionTyped.FocusElement) {
                return this.component.getDivActionFocusElementJsonEntityParser().getValue().serialize(context, ((DivActionTyped.FocusElement) value).getValue());
            }
            if (value instanceof DivActionTyped.HideTooltip) {
                return this.component.getDivActionHideTooltipJsonEntityParser().getValue().serialize(context, ((DivActionTyped.HideTooltip) value).getValue());
            }
            if (value instanceof DivActionTyped.ScrollBy) {
                return this.component.getDivActionScrollByJsonEntityParser().getValue().serialize(context, ((DivActionTyped.ScrollBy) value).getValue());
            }
            if (value instanceof DivActionTyped.ScrollTo) {
                return this.component.getDivActionScrollToJsonEntityParser().getValue().serialize(context, ((DivActionTyped.ScrollTo) value).getValue());
            }
            if (value instanceof DivActionTyped.SetState) {
                return this.component.getDivActionSetStateJsonEntityParser().getValue().serialize(context, ((DivActionTyped.SetState) value).getValue());
            }
            if (value instanceof DivActionTyped.SetStoredValue) {
                return this.component.getDivActionSetStoredValueJsonEntityParser().getValue().serialize(context, ((DivActionTyped.SetStoredValue) value).getValue());
            }
            if (value instanceof DivActionTyped.SetVariable) {
                return this.component.getDivActionSetVariableJsonEntityParser().getValue().serialize(context, ((DivActionTyped.SetVariable) value).getValue());
            }
            if (value instanceof DivActionTyped.ShowTooltip) {
                return this.component.getDivActionShowTooltipJsonEntityParser().getValue().serialize(context, ((DivActionTyped.ShowTooltip) value).getValue());
            }
            if (value instanceof DivActionTyped.Submit) {
                return this.component.getDivActionSubmitJsonEntityParser().getValue().serialize(context, ((DivActionTyped.Submit) value).getValue());
            }
            if (value instanceof DivActionTyped.Timer) {
                return this.component.getDivActionTimerJsonEntityParser().getValue().serialize(context, ((DivActionTyped.Timer) value).getValue());
            }
            if (value instanceof DivActionTyped.Video) {
                return this.component.getDivActionVideoJsonEntityParser().getValue().serialize(context, ((DivActionTyped.Video) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivActionTypedJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionTypedJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionTypedTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements Parser<JSONObject, DivActionTypedTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivActionTypedTemplate deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            String type;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            EntityTemplate entityTemplate = context.getTemplates().get(string);
            DivActionTypedTemplate divActionTypedTemplate = entityTemplate instanceof DivActionTypedTemplate ? (DivActionTypedTemplate) entityTemplate : null;
            if (divActionTypedTemplate != null && (type = divActionTypedTemplate.getType()) != null) {
                string = type;
            }
            switch (string.hashCode()) {
                case -1623648839:
                    if (string.equals("set_variable")) {
                        return new DivActionTypedTemplate.SetVariable(this.component.getDivActionSetVariableJsonTemplateParser().getValue().deserialize(context, (DivActionSetVariableTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case -1623635702:
                    if (string.equals("animator_start")) {
                        return new DivActionTypedTemplate.AnimatorStart(this.component.getDivActionAnimatorStartJsonTemplateParser().getValue().deserialize(context, (DivActionAnimatorStartTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case -1254965146:
                    if (string.equals("clear_focus")) {
                        return new DivActionTypedTemplate.ClearFocus(this.component.getDivActionClearFocusJsonTemplateParser().getValue().deserialize(context, (DivActionClearFocusTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case -1160753574:
                    if (string.equals("animator_stop")) {
                        return new DivActionTypedTemplate.AnimatorStop(this.component.getDivActionAnimatorStopJsonTemplateParser().getValue().deserialize(context, (DivActionAnimatorStopTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case -891535336:
                    if (string.equals("submit")) {
                        return new DivActionTypedTemplate.Submit(this.component.getDivActionSubmitJsonTemplateParser().getValue().deserialize(context, (DivActionSubmitTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case -796594542:
                    if (string.equals("set_stored_value")) {
                        return new DivActionTypedTemplate.SetStoredValue(this.component.getDivActionSetStoredValueJsonTemplateParser().getValue().deserialize(context, (DivActionSetStoredValueTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case -404256420:
                    if (string.equals("copy_to_clipboard")) {
                        return new DivActionTypedTemplate.CopyToClipboard(this.component.getDivActionCopyToClipboardJsonTemplateParser().getValue().deserialize(context, (DivActionCopyToClipboardTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 10055918:
                    if (string.equals("array_set_value")) {
                        return new DivActionTypedTemplate.ArraySetValue(this.component.getDivActionArraySetValueJsonTemplateParser().getValue().deserialize(context, (DivActionArraySetValueTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 110364485:
                    if (string.equals("timer")) {
                        return new DivActionTypedTemplate.Timer(this.component.getDivActionTimerJsonTemplateParser().getValue().deserialize(context, (DivActionTimerTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 112202875:
                    if (string.equals("video")) {
                        return new DivActionTypedTemplate.Video(this.component.getDivActionVideoJsonTemplateParser().getValue().deserialize(context, (DivActionVideoTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 203934236:
                    if (string.equals("array_remove_value")) {
                        return new DivActionTypedTemplate.ArrayRemoveValue(this.component.getDivActionArrayRemoveValueJsonTemplateParser().getValue().deserialize(context, (DivActionArrayRemoveValueTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 301532353:
                    if (string.equals("show_tooltip")) {
                        return new DivActionTypedTemplate.ShowTooltip(this.component.getDivActionShowTooltipJsonTemplateParser().getValue().deserialize(context, (DivActionShowTooltipTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 417790729:
                    if (string.equals("scroll_by")) {
                        return new DivActionTypedTemplate.ScrollBy(this.component.getDivActionScrollByJsonTemplateParser().getValue().deserialize(context, (DivActionScrollByTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 417791277:
                    if (string.equals("scroll_to")) {
                        return new DivActionTypedTemplate.ScrollTo(this.component.getDivActionScrollToJsonTemplateParser().getValue().deserialize(context, (DivActionScrollToTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 932090484:
                    if (string.equals("set_state")) {
                        return new DivActionTypedTemplate.SetState(this.component.getDivActionSetStateJsonTemplateParser().getValue().deserialize(context, (DivActionSetStateTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 1427818632:
                    if (string.equals("download")) {
                        return new DivActionTypedTemplate.Download(this.component.getDivActionDownloadJsonTemplateParser().getValue().deserialize(context, (DivActionDownloadTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 1550697109:
                    if (string.equals("focus_element")) {
                        return new DivActionTypedTemplate.FocusElement(this.component.getDivActionFocusElementJsonTemplateParser().getValue().deserialize(context, (DivActionFocusElementTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 1587919371:
                    if (string.equals("dict_set_value")) {
                        return new DivActionTypedTemplate.DictSetValue(this.component.getDivActionDictSetValueJsonTemplateParser().getValue().deserialize(context, (DivActionDictSetValueTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 1715728902:
                    if (string.equals("hide_tooltip")) {
                        return new DivActionTypedTemplate.HideTooltip(this.component.getDivActionHideTooltipJsonTemplateParser().getValue().deserialize(context, (DivActionHideTooltipTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
                case 1811437713:
                    if (string.equals("array_insert_value")) {
                        return new DivActionTypedTemplate.ArrayInsertValue(this.component.getDivActionArrayInsertValueJsonTemplateParser().getValue().deserialize(context, (DivActionArrayInsertValueTemplate) (divActionTypedTemplate != null ? divActionTypedTemplate.value() : null), data));
                    }
                    break;
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivActionTypedTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivActionTypedTemplate.AnimatorStart) {
                return this.component.getDivActionAnimatorStartJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.AnimatorStart) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.AnimatorStop) {
                return this.component.getDivActionAnimatorStopJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.AnimatorStop) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.ArrayInsertValue) {
                return this.component.getDivActionArrayInsertValueJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.ArrayInsertValue) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.ArrayRemoveValue) {
                return this.component.getDivActionArrayRemoveValueJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.ArrayRemoveValue) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.ArraySetValue) {
                return this.component.getDivActionArraySetValueJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.ArraySetValue) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.ClearFocus) {
                return this.component.getDivActionClearFocusJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.ClearFocus) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.CopyToClipboard) {
                return this.component.getDivActionCopyToClipboardJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.CopyToClipboard) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.DictSetValue) {
                return this.component.getDivActionDictSetValueJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.DictSetValue) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.Download) {
                return this.component.getDivActionDownloadJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.Download) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.FocusElement) {
                return this.component.getDivActionFocusElementJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.FocusElement) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.HideTooltip) {
                return this.component.getDivActionHideTooltipJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.HideTooltip) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.ScrollBy) {
                return this.component.getDivActionScrollByJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.ScrollBy) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.ScrollTo) {
                return this.component.getDivActionScrollToJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.ScrollTo) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.SetState) {
                return this.component.getDivActionSetStateJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.SetState) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.SetStoredValue) {
                return this.component.getDivActionSetStoredValueJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.SetStoredValue) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.SetVariable) {
                return this.component.getDivActionSetVariableJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.SetVariable) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.ShowTooltip) {
                return this.component.getDivActionShowTooltipJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.ShowTooltip) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.Submit) {
                return this.component.getDivActionSubmitJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.Submit) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.Timer) {
                return this.component.getDivActionTimerJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.Timer) value).getValue());
            }
            if (value instanceof DivActionTypedTemplate.Video) {
                return this.component.getDivActionVideoJsonTemplateParser().getValue().serialize(context, ((DivActionTypedTemplate.Video) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivActionTypedJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionTypedJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionTypedTemplate;", "Lcom/yandex/div2/DivActionTyped;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivActionTypedTemplate, DivActionTyped> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivActionTyped resolve(ParsingContext context, DivActionTypedTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            if (template instanceof DivActionTypedTemplate.AnimatorStart) {
                return new DivActionTyped.AnimatorStart(this.component.getDivActionAnimatorStartJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.AnimatorStart) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.AnimatorStop) {
                return new DivActionTyped.AnimatorStop(this.component.getDivActionAnimatorStopJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.AnimatorStop) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.ArrayInsertValue) {
                return new DivActionTyped.ArrayInsertValue(this.component.getDivActionArrayInsertValueJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.ArrayInsertValue) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.ArrayRemoveValue) {
                return new DivActionTyped.ArrayRemoveValue(this.component.getDivActionArrayRemoveValueJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.ArrayRemoveValue) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.ArraySetValue) {
                return new DivActionTyped.ArraySetValue(this.component.getDivActionArraySetValueJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.ArraySetValue) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.ClearFocus) {
                return new DivActionTyped.ClearFocus(this.component.getDivActionClearFocusJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.ClearFocus) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.CopyToClipboard) {
                return new DivActionTyped.CopyToClipboard(this.component.getDivActionCopyToClipboardJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.CopyToClipboard) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.DictSetValue) {
                return new DivActionTyped.DictSetValue(this.component.getDivActionDictSetValueJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.DictSetValue) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.Download) {
                return new DivActionTyped.Download(this.component.getDivActionDownloadJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.Download) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.FocusElement) {
                return new DivActionTyped.FocusElement(this.component.getDivActionFocusElementJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.FocusElement) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.HideTooltip) {
                return new DivActionTyped.HideTooltip(this.component.getDivActionHideTooltipJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.HideTooltip) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.ScrollBy) {
                return new DivActionTyped.ScrollBy(this.component.getDivActionScrollByJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.ScrollBy) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.ScrollTo) {
                return new DivActionTyped.ScrollTo(this.component.getDivActionScrollToJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.ScrollTo) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.SetState) {
                return new DivActionTyped.SetState(this.component.getDivActionSetStateJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.SetState) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.SetStoredValue) {
                return new DivActionTyped.SetStoredValue(this.component.getDivActionSetStoredValueJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.SetStoredValue) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.SetVariable) {
                return new DivActionTyped.SetVariable(this.component.getDivActionSetVariableJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.SetVariable) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.ShowTooltip) {
                return new DivActionTyped.ShowTooltip(this.component.getDivActionShowTooltipJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.ShowTooltip) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.Submit) {
                return new DivActionTyped.Submit(this.component.getDivActionSubmitJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.Submit) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.Timer) {
                return new DivActionTyped.Timer(this.component.getDivActionTimerJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.Timer) template).getValue(), data));
            }
            if (template instanceof DivActionTypedTemplate.Video) {
                return new DivActionTyped.Video(this.component.getDivActionVideoJsonTemplateResolver().getValue().resolve(context, ((DivActionTypedTemplate.Video) template).getValue(), data));
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
