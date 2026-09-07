package com.yandex.div2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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

/* JADX INFO: compiled from: DivTemplate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0012\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0011#$%&'()*+,-./0123¨\u00064"}, d2 = {"Lcom/yandex/div2/DivTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/Div;", "()V", "type", "", "getType", "()Ljava/lang/String;", "resolve", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "data", "Lorg/json/JSONObject;", "value", "", "writeToJSON", "Companion", "Container", TypedValues.Custom.NAME, "Gallery", "GifImage", "Grid", "Image", "Indicator", "Input", "Pager", "Select", "Separator", "Slider", "State", "Switch", "Tabs", "Text", VastTagName.VIDEO, "Lcom/yandex/div2/DivTemplate$Container;", "Lcom/yandex/div2/DivTemplate$Custom;", "Lcom/yandex/div2/DivTemplate$Gallery;", "Lcom/yandex/div2/DivTemplate$GifImage;", "Lcom/yandex/div2/DivTemplate$Grid;", "Lcom/yandex/div2/DivTemplate$Image;", "Lcom/yandex/div2/DivTemplate$Indicator;", "Lcom/yandex/div2/DivTemplate$Input;", "Lcom/yandex/div2/DivTemplate$Pager;", "Lcom/yandex/div2/DivTemplate$Select;", "Lcom/yandex/div2/DivTemplate$Separator;", "Lcom/yandex/div2/DivTemplate$Slider;", "Lcom/yandex/div2/DivTemplate$State;", "Lcom/yandex/div2/DivTemplate$Switch;", "Lcom/yandex/div2/DivTemplate$Tabs;", "Lcom/yandex/div2/DivTemplate$Text;", "Lcom/yandex/div2/DivTemplate$Video;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivTemplate implements JSONSerializable, JsonTemplate<Div> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivTemplate>() { // from class: com.yandex.div2.DivTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivTemplate.Companion.invoke$default(DivTemplate.INSTANCE, env, false, it, 2, null);
        }
    };

    public /* synthetic */ DivTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Image;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivImageTemplate;", "(Lcom/yandex/div2/DivImageTemplate;)V", "getValue", "()Lcom/yandex/div2/DivImageTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Image extends DivTemplate {
        private final DivImageTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Image(DivImageTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivImageTemplate getValue() {
            return this.value;
        }
    }

    private DivTemplate() {
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$GifImage;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivGifImageTemplate;", "(Lcom/yandex/div2/DivGifImageTemplate;)V", "getValue", "()Lcom/yandex/div2/DivGifImageTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GifImage extends DivTemplate {
        private final DivGifImageTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GifImage(DivGifImageTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivGifImageTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Text;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivTextTemplate;", "(Lcom/yandex/div2/DivTextTemplate;)V", "getValue", "()Lcom/yandex/div2/DivTextTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Text extends DivTemplate {
        private final DivTextTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(DivTextTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivTextTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Separator;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivSeparatorTemplate;", "(Lcom/yandex/div2/DivSeparatorTemplate;)V", "getValue", "()Lcom/yandex/div2/DivSeparatorTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Separator extends DivTemplate {
        private final DivSeparatorTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Separator(DivSeparatorTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSeparatorTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Container;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivContainerTemplate;", "(Lcom/yandex/div2/DivContainerTemplate;)V", "getValue", "()Lcom/yandex/div2/DivContainerTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Container extends DivTemplate {
        private final DivContainerTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Container(DivContainerTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivContainerTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Grid;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivGridTemplate;", "(Lcom/yandex/div2/DivGridTemplate;)V", "getValue", "()Lcom/yandex/div2/DivGridTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Grid extends DivTemplate {
        private final DivGridTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Grid(DivGridTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivGridTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Gallery;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivGalleryTemplate;", "(Lcom/yandex/div2/DivGalleryTemplate;)V", "getValue", "()Lcom/yandex/div2/DivGalleryTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Gallery extends DivTemplate {
        private final DivGalleryTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Gallery(DivGalleryTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivGalleryTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Pager;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivPagerTemplate;", "(Lcom/yandex/div2/DivPagerTemplate;)V", "getValue", "()Lcom/yandex/div2/DivPagerTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Pager extends DivTemplate {
        private final DivPagerTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pager(DivPagerTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivPagerTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Tabs;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivTabsTemplate;", "(Lcom/yandex/div2/DivTabsTemplate;)V", "getValue", "()Lcom/yandex/div2/DivTabsTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Tabs extends DivTemplate {
        private final DivTabsTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tabs(DivTabsTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivTabsTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$State;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivStateTemplate;", "(Lcom/yandex/div2/DivStateTemplate;)V", "getValue", "()Lcom/yandex/div2/DivStateTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class State extends DivTemplate {
        private final DivStateTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public State(DivStateTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivStateTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Custom;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivCustomTemplate;", "(Lcom/yandex/div2/DivCustomTemplate;)V", "getValue", "()Lcom/yandex/div2/DivCustomTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Custom extends DivTemplate {
        private final DivCustomTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(DivCustomTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivCustomTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Indicator;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivIndicatorTemplate;", "(Lcom/yandex/div2/DivIndicatorTemplate;)V", "getValue", "()Lcom/yandex/div2/DivIndicatorTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Indicator extends DivTemplate {
        private final DivIndicatorTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Indicator(DivIndicatorTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivIndicatorTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Slider;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivSliderTemplate;", "(Lcom/yandex/div2/DivSliderTemplate;)V", "getValue", "()Lcom/yandex/div2/DivSliderTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Slider extends DivTemplate {
        private final DivSliderTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Slider(DivSliderTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSliderTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Switch;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivSwitchTemplate;", "(Lcom/yandex/div2/DivSwitchTemplate;)V", "getValue", "()Lcom/yandex/div2/DivSwitchTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Switch extends DivTemplate {
        private final DivSwitchTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Switch(DivSwitchTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSwitchTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Input;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivInputTemplate;", "(Lcom/yandex/div2/DivInputTemplate;)V", "getValue", "()Lcom/yandex/div2/DivInputTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Input extends DivTemplate {
        private final DivInputTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Input(DivInputTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivInputTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Select;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivSelectTemplate;", "(Lcom/yandex/div2/DivSelectTemplate;)V", "getValue", "()Lcom/yandex/div2/DivSelectTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Select extends DivTemplate {
        private final DivSelectTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Select(DivSelectTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSelectTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTemplate$Video;", "Lcom/yandex/div2/DivTemplate;", "value", "Lcom/yandex/div2/DivVideoTemplate;", "(Lcom/yandex/div2/DivVideoTemplate;)V", "getValue", "()Lcom/yandex/div2/DivVideoTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Video extends DivTemplate {
        private final DivVideoTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Video(DivVideoTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivVideoTemplate getValue() {
            return this.value;
        }
    }

    public final Object value() {
        if (this instanceof Image) {
            return ((Image) this).getValue();
        }
        if (this instanceof GifImage) {
            return ((GifImage) this).getValue();
        }
        if (this instanceof Text) {
            return ((Text) this).getValue();
        }
        if (this instanceof Separator) {
            return ((Separator) this).getValue();
        }
        if (this instanceof Container) {
            return ((Container) this).getValue();
        }
        if (this instanceof Grid) {
            return ((Grid) this).getValue();
        }
        if (this instanceof Gallery) {
            return ((Gallery) this).getValue();
        }
        if (this instanceof Pager) {
            return ((Pager) this).getValue();
        }
        if (this instanceof Tabs) {
            return ((Tabs) this).getValue();
        }
        if (this instanceof State) {
            return ((State) this).getValue();
        }
        if (this instanceof Custom) {
            return ((Custom) this).getValue();
        }
        if (this instanceof Indicator) {
            return ((Indicator) this).getValue();
        }
        if (this instanceof Slider) {
            return ((Slider) this).getValue();
        }
        if (this instanceof Switch) {
            return ((Switch) this).getValue();
        }
        if (this instanceof Input) {
            return ((Input) this).getValue();
        }
        if (this instanceof Select) {
            return ((Select) this).getValue();
        }
        if (this instanceof Video) {
            return ((Video) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    @Override // com.yandex.div.json.JsonTemplate
    public Div resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    public final String getType() {
        if (this instanceof Image) {
            return "image";
        }
        if (this instanceof GifImage) {
            return "gif";
        }
        if (this instanceof Text) {
            return "text";
        }
        if (this instanceof Separator) {
            return "separator";
        }
        if (this instanceof Container) {
            return "container";
        }
        if (this instanceof Grid) {
            return "grid";
        }
        if (this instanceof Gallery) {
            return "gallery";
        }
        if (this instanceof Pager) {
            return "pager";
        }
        if (this instanceof Tabs) {
            return "tabs";
        }
        if (this instanceof State) {
            return "state";
        }
        if (this instanceof Custom) {
            return "custom";
        }
        if (this instanceof Indicator) {
            return "indicator";
        }
        if (this instanceof Slider) {
            return "slider";
        }
        if (this instanceof Switch) {
            return "switch";
        }
        if (this instanceof Input) {
            return "input";
        }
        if (this instanceof Select) {
            return "select";
        }
        if (this instanceof Video) {
            return "video";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: DivTemplate.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "topLevel", "", "json", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DivTemplate invoke$default(Companion companion, ParsingEnvironment parsingEnvironment, boolean z, JSONObject jSONObject, int i, Object obj) throws ParsingException {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.invoke(parsingEnvironment, z, jSONObject);
        }

        public final DivTemplate invoke(ParsingEnvironment env, boolean topLevel, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivJsonTemplateParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivTemplate> getCREATOR() {
            return DivTemplate.CREATOR;
        }
    }
}
