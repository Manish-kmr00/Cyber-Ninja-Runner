package com.yandex.div2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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

/* JADX INFO: compiled from: Div.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0012\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0001\u0011&'()*+,-./0123456¨\u00067"}, d2 = {"Lcom/yandex/div2/Div;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "()V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "value", "Lcom/yandex/div2/DivBase;", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Container", TypedValues.Custom.NAME, "Gallery", "GifImage", "Grid", "Image", "Indicator", "Input", "Pager", "Select", "Separator", "Slider", "State", "Switch", "Tabs", "Text", VastTagName.VIDEO, "Lcom/yandex/div2/Div$Container;", "Lcom/yandex/div2/Div$Custom;", "Lcom/yandex/div2/Div$Gallery;", "Lcom/yandex/div2/Div$GifImage;", "Lcom/yandex/div2/Div$Grid;", "Lcom/yandex/div2/Div$Image;", "Lcom/yandex/div2/Div$Indicator;", "Lcom/yandex/div2/Div$Input;", "Lcom/yandex/div2/Div$Pager;", "Lcom/yandex/div2/Div$Select;", "Lcom/yandex/div2/Div$Separator;", "Lcom/yandex/div2/Div$Slider;", "Lcom/yandex/div2/Div$State;", "Lcom/yandex/div2/Div$Switch;", "Lcom/yandex/div2/Div$Tabs;", "Lcom/yandex/div2/Div$Text;", "Lcom/yandex/div2/Div$Video;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class Div implements JSONSerializable, Hashable {
    private Integer _hash;
    private Integer _propertiesHash;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, Div> CREATOR = new Function2<ParsingEnvironment, JSONObject, Div>() { // from class: com.yandex.div2.Div$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final Div invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return Div.INSTANCE.fromJson(env, it);
        }
    };

    public /* synthetic */ Div(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final Div fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) throws ParsingException {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Image;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivImage;", "(Lcom/yandex/div2/DivImage;)V", "getValue", "()Lcom/yandex/div2/DivImage;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Image extends Div {
        private final DivImage value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Image(DivImage value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivImage getValue() {
            return this.value;
        }
    }

    private Div() {
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$GifImage;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivGifImage;", "(Lcom/yandex/div2/DivGifImage;)V", "getValue", "()Lcom/yandex/div2/DivGifImage;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GifImage extends Div {
        private final DivGifImage value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GifImage(DivGifImage value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivGifImage getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Text;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivText;", "(Lcom/yandex/div2/DivText;)V", "getValue", "()Lcom/yandex/div2/DivText;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Text extends Div {
        private final DivText value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(DivText value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivText getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Separator;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivSeparator;", "(Lcom/yandex/div2/DivSeparator;)V", "getValue", "()Lcom/yandex/div2/DivSeparator;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Separator extends Div {
        private final DivSeparator value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Separator(DivSeparator value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSeparator getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Container;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivContainer;", "(Lcom/yandex/div2/DivContainer;)V", "getValue", "()Lcom/yandex/div2/DivContainer;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Container extends Div {
        private final DivContainer value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Container(DivContainer value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivContainer getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Grid;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivGrid;", "(Lcom/yandex/div2/DivGrid;)V", "getValue", "()Lcom/yandex/div2/DivGrid;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Grid extends Div {
        private final DivGrid value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Grid(DivGrid value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivGrid getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Gallery;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivGallery;", "(Lcom/yandex/div2/DivGallery;)V", "getValue", "()Lcom/yandex/div2/DivGallery;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Gallery extends Div {
        private final DivGallery value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Gallery(DivGallery value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivGallery getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Pager;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivPager;", "(Lcom/yandex/div2/DivPager;)V", "getValue", "()Lcom/yandex/div2/DivPager;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Pager extends Div {
        private final DivPager value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pager(DivPager value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivPager getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Tabs;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivTabs;", "(Lcom/yandex/div2/DivTabs;)V", "getValue", "()Lcom/yandex/div2/DivTabs;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Tabs extends Div {
        private final DivTabs value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tabs(DivTabs value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivTabs getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$State;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivState;", "(Lcom/yandex/div2/DivState;)V", "getValue", "()Lcom/yandex/div2/DivState;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class State extends Div {
        private final DivState value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public State(DivState value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivState getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Custom;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivCustom;", "(Lcom/yandex/div2/DivCustom;)V", "getValue", "()Lcom/yandex/div2/DivCustom;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Custom extends Div {
        private final DivCustom value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(DivCustom value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivCustom getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Indicator;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivIndicator;", "(Lcom/yandex/div2/DivIndicator;)V", "getValue", "()Lcom/yandex/div2/DivIndicator;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Indicator extends Div {
        private final DivIndicator value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Indicator(DivIndicator value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivIndicator getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Slider;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivSlider;", "(Lcom/yandex/div2/DivSlider;)V", "getValue", "()Lcom/yandex/div2/DivSlider;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Slider extends Div {
        private final DivSlider value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Slider(DivSlider value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSlider getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Switch;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivSwitch;", "(Lcom/yandex/div2/DivSwitch;)V", "getValue", "()Lcom/yandex/div2/DivSwitch;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Switch extends Div {
        private final DivSwitch value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Switch(DivSwitch value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSwitch getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Input;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivInput;", "(Lcom/yandex/div2/DivInput;)V", "getValue", "()Lcom/yandex/div2/DivInput;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Input extends Div {
        private final DivInput value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Input(DivInput value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivInput getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Select;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivSelect;", "(Lcom/yandex/div2/DivSelect;)V", "getValue", "()Lcom/yandex/div2/DivSelect;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Select extends Div {
        private final DivSelect value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Select(DivSelect value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivSelect getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/Div$Video;", "Lcom/yandex/div2/Div;", "value", "Lcom/yandex/div2/DivVideo;", "(Lcom/yandex/div2/DivVideo;)V", "getValue", "()Lcom/yandex/div2/DivVideo;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Video extends Div {
        private final DivVideo value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Video(DivVideo value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DivVideo getValue() {
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
        if (this instanceof Image) {
            iPropertiesHash = ((Image) this).getValue().propertiesHash();
        } else if (this instanceof GifImage) {
            iPropertiesHash = ((GifImage) this).getValue().propertiesHash();
        } else if (this instanceof Text) {
            iPropertiesHash = ((Text) this).getValue().propertiesHash();
        } else if (this instanceof Separator) {
            iPropertiesHash = ((Separator) this).getValue().propertiesHash();
        } else if (this instanceof Container) {
            iPropertiesHash = ((Container) this).getValue().propertiesHash();
        } else if (this instanceof Grid) {
            iPropertiesHash = ((Grid) this).getValue().propertiesHash();
        } else if (this instanceof Gallery) {
            iPropertiesHash = ((Gallery) this).getValue().propertiesHash();
        } else if (this instanceof Pager) {
            iPropertiesHash = ((Pager) this).getValue().propertiesHash();
        } else if (this instanceof Tabs) {
            iPropertiesHash = ((Tabs) this).getValue().propertiesHash();
        } else if (this instanceof State) {
            iPropertiesHash = ((State) this).getValue().propertiesHash();
        } else if (this instanceof Custom) {
            iPropertiesHash = ((Custom) this).getValue().propertiesHash();
        } else if (this instanceof Indicator) {
            iPropertiesHash = ((Indicator) this).getValue().propertiesHash();
        } else if (this instanceof Slider) {
            iPropertiesHash = ((Slider) this).getValue().propertiesHash();
        } else if (this instanceof Switch) {
            iPropertiesHash = ((Switch) this).getValue().propertiesHash();
        } else if (this instanceof Input) {
            iPropertiesHash = ((Input) this).getValue().propertiesHash();
        } else if (this instanceof Select) {
            iPropertiesHash = ((Select) this).getValue().propertiesHash();
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
        if (this instanceof Image) {
            iHash = ((Image) this).getValue().hash();
        } else if (this instanceof GifImage) {
            iHash = ((GifImage) this).getValue().hash();
        } else if (this instanceof Text) {
            iHash = ((Text) this).getValue().hash();
        } else if (this instanceof Separator) {
            iHash = ((Separator) this).getValue().hash();
        } else if (this instanceof Container) {
            iHash = ((Container) this).getValue().hash();
        } else if (this instanceof Grid) {
            iHash = ((Grid) this).getValue().hash();
        } else if (this instanceof Gallery) {
            iHash = ((Gallery) this).getValue().hash();
        } else if (this instanceof Pager) {
            iHash = ((Pager) this).getValue().hash();
        } else if (this instanceof Tabs) {
            iHash = ((Tabs) this).getValue().hash();
        } else if (this instanceof State) {
            iHash = ((State) this).getValue().hash();
        } else if (this instanceof Custom) {
            iHash = ((Custom) this).getValue().hash();
        } else if (this instanceof Indicator) {
            iHash = ((Indicator) this).getValue().hash();
        } else if (this instanceof Slider) {
            iHash = ((Slider) this).getValue().hash();
        } else if (this instanceof Switch) {
            iHash = ((Switch) this).getValue().hash();
        } else if (this instanceof Input) {
            iHash = ((Input) this).getValue().hash();
        } else if (this instanceof Select) {
            iHash = ((Select) this).getValue().hash();
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

    public final boolean equals(Div other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        if (this instanceof Image) {
            DivImage value = ((Image) this).getValue();
            DivBase divBaseValue = other.value();
            return value.equals(divBaseValue instanceof DivImage ? (DivImage) divBaseValue : null, resolver, otherResolver);
        }
        if (this instanceof GifImage) {
            DivGifImage value2 = ((GifImage) this).getValue();
            DivBase divBaseValue2 = other.value();
            return value2.equals(divBaseValue2 instanceof DivGifImage ? (DivGifImage) divBaseValue2 : null, resolver, otherResolver);
        }
        if (this instanceof Text) {
            DivText value3 = ((Text) this).getValue();
            DivBase divBaseValue3 = other.value();
            return value3.equals(divBaseValue3 instanceof DivText ? (DivText) divBaseValue3 : null, resolver, otherResolver);
        }
        if (this instanceof Separator) {
            DivSeparator value4 = ((Separator) this).getValue();
            DivBase divBaseValue4 = other.value();
            return value4.equals(divBaseValue4 instanceof DivSeparator ? (DivSeparator) divBaseValue4 : null, resolver, otherResolver);
        }
        if (this instanceof Container) {
            DivContainer value5 = ((Container) this).getValue();
            DivBase divBaseValue5 = other.value();
            return value5.equals(divBaseValue5 instanceof DivContainer ? (DivContainer) divBaseValue5 : null, resolver, otherResolver);
        }
        if (this instanceof Grid) {
            DivGrid value6 = ((Grid) this).getValue();
            DivBase divBaseValue6 = other.value();
            return value6.equals(divBaseValue6 instanceof DivGrid ? (DivGrid) divBaseValue6 : null, resolver, otherResolver);
        }
        if (this instanceof Gallery) {
            DivGallery value7 = ((Gallery) this).getValue();
            DivBase divBaseValue7 = other.value();
            return value7.equals(divBaseValue7 instanceof DivGallery ? (DivGallery) divBaseValue7 : null, resolver, otherResolver);
        }
        if (this instanceof Pager) {
            DivPager value8 = ((Pager) this).getValue();
            DivBase divBaseValue8 = other.value();
            return value8.equals(divBaseValue8 instanceof DivPager ? (DivPager) divBaseValue8 : null, resolver, otherResolver);
        }
        if (this instanceof Tabs) {
            DivTabs value9 = ((Tabs) this).getValue();
            DivBase divBaseValue9 = other.value();
            return value9.equals(divBaseValue9 instanceof DivTabs ? (DivTabs) divBaseValue9 : null, resolver, otherResolver);
        }
        if (this instanceof State) {
            DivState value10 = ((State) this).getValue();
            DivBase divBaseValue10 = other.value();
            return value10.equals(divBaseValue10 instanceof DivState ? (DivState) divBaseValue10 : null, resolver, otherResolver);
        }
        if (this instanceof Custom) {
            DivCustom value11 = ((Custom) this).getValue();
            DivBase divBaseValue11 = other.value();
            return value11.equals(divBaseValue11 instanceof DivCustom ? (DivCustom) divBaseValue11 : null, resolver, otherResolver);
        }
        if (this instanceof Indicator) {
            DivIndicator value12 = ((Indicator) this).getValue();
            DivBase divBaseValue12 = other.value();
            return value12.equals(divBaseValue12 instanceof DivIndicator ? (DivIndicator) divBaseValue12 : null, resolver, otherResolver);
        }
        if (this instanceof Slider) {
            DivSlider value13 = ((Slider) this).getValue();
            DivBase divBaseValue13 = other.value();
            return value13.equals(divBaseValue13 instanceof DivSlider ? (DivSlider) divBaseValue13 : null, resolver, otherResolver);
        }
        if (this instanceof Switch) {
            DivSwitch value14 = ((Switch) this).getValue();
            DivBase divBaseValue14 = other.value();
            return value14.equals(divBaseValue14 instanceof DivSwitch ? (DivSwitch) divBaseValue14 : null, resolver, otherResolver);
        }
        if (this instanceof Input) {
            DivInput value15 = ((Input) this).getValue();
            DivBase divBaseValue15 = other.value();
            return value15.equals(divBaseValue15 instanceof DivInput ? (DivInput) divBaseValue15 : null, resolver, otherResolver);
        }
        if (this instanceof Select) {
            DivSelect value16 = ((Select) this).getValue();
            DivBase divBaseValue16 = other.value();
            return value16.equals(divBaseValue16 instanceof DivSelect ? (DivSelect) divBaseValue16 : null, resolver, otherResolver);
        }
        if (!(this instanceof Video)) {
            throw new NoWhenBranchMatchedException();
        }
        DivVideo value17 = ((Video) this).getValue();
        DivBase divBaseValue17 = other.value();
        return value17.equals(divBaseValue17 instanceof DivVideo ? (DivVideo) divBaseValue17 : null, resolver, otherResolver);
    }

    public final DivBase value() {
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
        return BuiltInParserKt.getBuiltInParserComponent().getDivJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: Div.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/Div$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/Div;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Div fromJson(ParsingEnvironment env, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, Div> getCREATOR() {
            return Div.CREATOR;
        }
    }
}
