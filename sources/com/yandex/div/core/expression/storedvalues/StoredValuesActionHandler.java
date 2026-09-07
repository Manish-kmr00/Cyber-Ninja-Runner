package com.yandex.div.core.expression.storedvalues;

import android.net.Uri;
import com.smaato.sdk.video.vast.model.Category;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.data.StoredValue;
import com.yandex.div.evaluable.types.Color;
import com.yandex.div.evaluable.types.Url;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.parser.ParsingConvertersKt;
import com.yandex.div.internal.util.ConvertUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StoredValuesActionHandler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0006*\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\f\u0010\u001a\u001a\u00020\u0004*\u00020\u0006H\u0002J\u001c\u0010\u001b\u001a\u00020\u001c*\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\f\u0010\u001f\u001a\u00020 *\u00020\u0006H\u0002J\f\u0010!\u001a\u00020\"*\u00020\u0006H\u0002J\f\u0010#\u001a\u00020\u0010*\u00020\u0006H\u0002J\u001c\u0010$\u001a\u00020%*\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b&\u0010'\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/yandex/div/core/expression/storedvalues/StoredValuesActionHandler;", "", "()V", "canHandle", "", Category.AUTHORITY, "", "createStoredValue", "Lcom/yandex/div/data/StoredValue;", "type", "Lcom/yandex/div/data/StoredValue$Type;", "name", "value", "executeAction", "storedValue", "lifetime", "", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "handleAction", "uri", "Landroid/net/Uri;", "view", "Lcom/yandex/div/core/DivViewFacade;", "getParam", "forName", "parseAsBoolean", "parseAsColor", "Lcom/yandex/div/evaluable/types/Color;", "parseAsColor-C4zCDoM", "(Ljava/lang/String;)I", "parseAsDouble", "", "parseAsInt", "", "parseAsLong", "parseAsUrl", "Lcom/yandex/div/evaluable/types/Url;", "parseAsUrl-VcSV9u8", "(Ljava/lang/String;)Ljava/lang/String;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StoredValuesActionHandler {
    public static final StoredValuesActionHandler INSTANCE = new StoredValuesActionHandler();

    /* JADX INFO: compiled from: StoredValuesActionHandler.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StoredValue.Type.values().length];
            try {
                iArr[StoredValue.Type.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StoredValue.Type.INTEGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StoredValue.Type.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StoredValue.Type.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StoredValue.Type.COLOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[StoredValue.Type.URL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private StoredValuesActionHandler() {
    }

    @JvmStatic
    public static final boolean canHandle(String authority) {
        return Intrinsics.areEqual(authority, "set_stored_value");
    }

    @JvmStatic
    public static final boolean handleAction(Uri uri, DivViewFacade view) {
        String param;
        String param2;
        Long longOrNull;
        StoredValue.Type typeFromString;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(view, "view");
        Div2View div2View = view instanceof Div2View ? (Div2View) view : null;
        if (div2View == null) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Handler view is not instance of Div2View");
            }
            return false;
        }
        StoredValuesActionHandler storedValuesActionHandler = INSTANCE;
        String param3 = storedValuesActionHandler.getParam(uri, "name");
        if (param3 != null && (param = storedValuesActionHandler.getParam(uri, "value")) != null && (param2 = storedValuesActionHandler.getParam(uri, "lifetime")) != null && (longOrNull = StringsKt.toLongOrNull(param2)) != null) {
            long jLongValue = longOrNull.longValue();
            String param4 = storedValuesActionHandler.getParam(uri, "type");
            if (param4 != null && (typeFromString = StoredValue.Type.INSTANCE.fromString(param4)) != null) {
                try {
                    return storedValuesActionHandler.executeAction(storedValuesActionHandler.createStoredValue(typeFromString, param3, param), jLongValue, div2View);
                } catch (StoredValueDeclarationException e) {
                    KAssert kAssert2 = KAssert.INSTANCE;
                    if (Assert.isEnabled()) {
                        Assert.fail("Stored value '" + param3 + "' declaration failed: " + e.getMessage());
                    }
                }
            }
        }
        return false;
    }

    public final boolean executeAction(StoredValue storedValue, long lifetime, Div2View div2View) {
        Intrinsics.checkNotNullParameter(storedValue, "storedValue");
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        StoredValuesController storedValuesController = div2View.getDiv2Component().getStoredValuesController();
        Intrinsics.checkNotNullExpressionValue(storedValuesController, "div2View.div2Component.storedValuesController");
        return storedValuesController.setStoredValue(storedValue, lifetime, div2View.getViewComponent().getErrorCollectors().getOrCreate(div2View.getDivTag(), div2View.getDivData()));
    }

    private final String getParam(Uri uri, String str) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter != null) {
            return queryParameter;
        }
        KAssert kAssert = KAssert.INSTANCE;
        if (Assert.isEnabled()) {
            Assert.fail("The required parameter " + str + " is missing");
        }
        return null;
    }

    private final StoredValue createStoredValue(StoredValue.Type type, String name, String value) throws StoredValueDeclarationException {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return new StoredValue.StringStoredValue(name, value);
            case 2:
                return new StoredValue.IntegerStoredValue(name, parseAsLong(value));
            case 3:
                return new StoredValue.BooleanStoredValue(name, parseAsBoolean(value));
            case 4:
                return new StoredValue.DoubleStoredValue(name, parseAsDouble(value));
            case 5:
                return new StoredValue.ColorStoredValue(name, m6116parseAsColorC4zCDoM(value), null);
            case 6:
                return new StoredValue.UrlStoredValue(name, m6117parseAsUrlVcSV9u8(value), null);
            default:
                throw new StoredValueDeclarationException("Cannot create stored value of type = '" + type + "'.", null, 2, null);
        }
    }

    private final long parseAsLong(String str) throws StoredValueDeclarationException {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new StoredValueDeclarationException(null, e, 1, null);
        }
    }

    private final int parseAsInt(String str) throws StoredValueDeclarationException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new StoredValueDeclarationException(null, e, 1, null);
        }
    }

    private final boolean parseAsBoolean(String str) throws StoredValueDeclarationException {
        Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(str);
        if (booleanStrictOrNull == null && (booleanStrictOrNull = ConvertUtilsKt.toBoolean(parseAsInt(str))) == null) {
            throw new StoredValueDeclarationException("Unable to convert " + str + " to boolean", null, 2, null);
        }
        return booleanStrictOrNull.booleanValue();
    }

    private final double parseAsDouble(String str) throws StoredValueDeclarationException {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new StoredValueDeclarationException(null, e, 1, null);
        }
    }

    /* JADX INFO: renamed from: parseAsUrl-VcSV9u8, reason: not valid java name */
    private final String m6117parseAsUrlVcSV9u8(String str) throws StoredValueDeclarationException {
        try {
            return Url.INSTANCE.m6236fromVcSV9u8(str);
        } catch (IllegalArgumentException e) {
            throw new StoredValueDeclarationException(null, e, 1, null);
        }
    }

    /* JADX INFO: renamed from: parseAsColor-C4zCDoM, reason: not valid java name */
    private final int m6116parseAsColorC4zCDoM(String str) throws StoredValueDeclarationException {
        Integer numInvoke = ParsingConvertersKt.STRING_TO_COLOR_INT.invoke(str);
        if (numInvoke == null) {
            throw new StoredValueDeclarationException("Wrong value format for color stored value: '" + str + '\'', null, 2, null);
        }
        return Color.m6218constructorimpl(numInvoke.intValue());
    }
}
