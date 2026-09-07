package com.yandex.div.evaluable.function;

import com.facebook.AuthenticationTokenClaims;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.yandex.div.evaluable.EvaluableException;
import com.yandex.div.evaluable.EvaluableType;
import com.yandex.div.evaluable.Function;
import com.yandex.div.evaluable.FunctionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GeneratedBuiltinFunctionProvider.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/yandex/div/evaluable/function/GeneratedBuiltinFunctionProvider;", "Lcom/yandex/div/evaluable/FunctionProvider;", "()V", "get", "Lcom/yandex/div/evaluable/Function;", "name", "", "args", "", "Lcom/yandex/div/evaluable/EvaluableType;", "getMethod", "warmUp", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GeneratedBuiltinFunctionProvider implements FunctionProvider {
    public static final GeneratedBuiltinFunctionProvider INSTANCE = new GeneratedBuiltinFunctionProvider();

    private GeneratedBuiltinFunctionProvider() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yandex.div.evaluable.FunctionProvider
    public Function get(String name, List<? extends EvaluableType> args) throws Exception {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        switch (name.hashCode()) {
            case -2129095909:
                if (name.equals("getArrayInteger")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayInteger.INSTANCE, args);
                }
                break;
            case -2096254100:
                if (name.equals("getArrayFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayFromArray.INSTANCE, args);
                }
                break;
            case -2015731347:
                if (name.equals("formatDateAsUTCWithLocale")) {
                    return FunctionValidatorKt.withArgumentsValidation(FormatDateAsUTCWithLocale.INSTANCE, args);
                }
                break;
            case -1930505522:
                if (name.equals("getOptIntegerFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptIntegerFromArray.INSTANCE, args);
                }
                break;
            case -1919300188:
                if (name.equals("toNumber")) {
                    if (Intrinsics.areEqual(IntegerToNumber.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerToNumber.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringToNumber.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringToNumber.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerToNumber.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerToNumber.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringToNumber.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringToNumber.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case -1857218874:
                if (name.equals("getIntervalTotalHours")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntervalTotalHours.INSTANCE, args);
                }
                break;
            case -1843679562:
                if (name.equals("getIntervalTotalWeeks")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntervalTotalWeeks.INSTANCE, args);
                }
                break;
            case -1776922004:
                if (name.equals("toString")) {
                    if (Intrinsics.areEqual(ArrayToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(BooleanToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return BooleanToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DictToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DictToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(NumberToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return NumberToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(UrlToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return UrlToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(BooleanToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return BooleanToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DictToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DictToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(NumberToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return NumberToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(UrlToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return UrlToString.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case -1730341801:
                if (name.equals("getDictOptInteger")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictOptInteger.INSTANCE, args);
                }
                break;
            case -1603949422:
                if (name.equals("getBooleanFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetBooleanFromDict.INSTANCE, args);
                }
                break;
            case -1601021533:
                if (name.equals("getDictUrl")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictUrl.INSTANCE, args);
                }
                break;
            case -1598503635:
                if (name.equals("toBoolean")) {
                    if (Intrinsics.areEqual(IntegerToBoolean.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerToBoolean.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringToBoolean.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringToBoolean.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerToBoolean.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerToBoolean.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringToBoolean.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringToBoolean.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case -1586214751:
                if (name.equals("getOptIntegerFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptIntegerFromDict.INSTANCE, args);
                }
                break;
            case -1544450268:
                if (name.equals("getOptBooleanFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptBooleanFromArray.INSTANCE, args);
                }
                break;
            case -1536224128:
                if (name.equals("getArrayColor")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayColor.INSTANCE, args);
                }
                break;
            case -1506310026:
                if (name.equals("getIntervalTotalSeconds")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntervalTotalSeconds.INSTANCE, args);
                }
                break;
            case -1436100668:
                if (name.equals("getIntervalSeconds")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntervalSeconds.INSTANCE, args);
                }
                break;
            case -1288010167:
                if (name.equals("getSeconds")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetSeconds.INSTANCE, args);
                }
                break;
            case -1249364890:
                if (name.equals("getDay")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDay.INSTANCE, args);
                }
                break;
            case -1233067443:
                if (name.equals("replaceAll")) {
                    return FunctionValidatorKt.withArgumentsValidation(StringReplaceAll.INSTANCE, args);
                }
                break;
            case -1223509624:
                if (name.equals("getStringFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetStringFromArray.INSTANCE, args);
                }
                break;
            case -1192573227:
                if (name.equals("testRegex")) {
                    return FunctionValidatorKt.withArgumentsValidation(TestRegex.INSTANCE, args);
                }
                break;
            case -1180629592:
                if (name.equals("toColor")) {
                    return FunctionValidatorKt.withArgumentsValidation(StringToColor.INSTANCE, args);
                }
                break;
            case -1168421440:
                if (name.equals("getIntervalTotalDays")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntervalTotalDays.INSTANCE, args);
                }
                break;
            case -1162978502:
                if (name.equals("maxInteger")) {
                    return FunctionValidatorKt.withArgumentsValidation(IntegerMaxValue.INSTANCE, args);
                }
                break;
            case -1148047119:
                if (name.equals("parseUnixTimeAsLocal")) {
                    return FunctionValidatorKt.withArgumentsValidation(ParseUnixTimeAsLocal.INSTANCE, args);
                }
                break;
            case -1137582698:
                if (name.equals("toLowerCase")) {
                    return FunctionValidatorKt.withArgumentsValidation(ToLowerCase.INSTANCE, args);
                }
                break;
            case -1133026611:
                if (name.equals("formatDateAsUTC")) {
                    return FunctionValidatorKt.withArgumentsValidation(FormatDateAsUTC.INSTANCE, args);
                }
                break;
            case -1131397482:
                if (name.equals("getUrlFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetUrlFromArray.INSTANCE, args);
                }
                break;
            case -1077888264:
                if (name.equals("getArrayOptBoolean")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayOptBoolean.INSTANCE, args);
                }
                break;
            case -1072121784:
                if (name.equals("parseUnixTime")) {
                    return FunctionValidatorKt.withArgumentsValidation(ParseUnixTime.INSTANCE, args);
                }
                break;
            case -1071222151:
                if (name.equals("getArrayOptNumber")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayOptNumber.INSTANCE, args);
                }
                break;
            case -1013579358:
                if (name.equals("getColorFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetColorFromArray.INSTANCE, args);
                }
                break;
            case -1000110441:
                if (name.equals("getDictColor")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictColor.INSTANCE, args);
                }
                break;
            case -995871928:
                if (name.equals("padEnd")) {
                    if (Intrinsics.areEqual(PadEndInteger.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return PadEndInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(PadEndString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return PadEndString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(PadEndInteger.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return PadEndInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(PadEndString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return PadEndString.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case -962804868:
                if (name.equals("getOptArrayFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptArrayFromDict.INSTANCE, args);
                }
                break;
            case -928843967:
                if (name.equals("getArrayOptString")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayOptString.INSTANCE, args);
                }
                break;
            case -905815078:
                if (name.equals("setDay")) {
                    return FunctionValidatorKt.withArgumentsValidation(SetDay.INSTANCE, args);
                }
                break;
            case -902467307:
                if (name.equals("signum")) {
                    if (Intrinsics.areEqual(DoubleSignum.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleSignum.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerSignum.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerSignum.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DoubleSignum.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleSignum.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerSignum.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerSignum.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case -863899827:
                if (name.equals("getColorFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetColorFromDict.INSTANCE, args);
                }
                break;
            case -823914681:
                if (name.equals("getStoredColorValue")) {
                    if (Intrinsics.areEqual(GetStoredColorValue.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetStoredColorValue.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetStoredColorValueString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetStoredColorValueString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetStoredColorValue.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetStoredColorValue.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetStoredColorValueString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetStoredColorValueString.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case -792903165:
                if (name.equals("getDictFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictFromArray.INSTANCE, args);
                }
                break;
            case -775185381:
                if (name.equals("setColorBlue")) {
                    if (Intrinsics.areEqual(ColorBlueComponentSetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorBlueComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringBlueComponentSetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringBlueComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorBlueComponentSetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorBlueComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringBlueComponentSetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringBlueComponentSetter.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case -757068958:
                if (name.equals("getStoredBooleanValue")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetStoredBooleanValue.INSTANCE, args);
                }
                break;
            case -740156815:
                if (name.equals("getDayOfWeek")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDayOfWeek.INSTANCE, args);
                }
                break;
            case -719400499:
                if (name.equals("maxNumber")) {
                    return FunctionValidatorKt.withArgumentsValidation(DoubleMaxValue.INSTANCE, args);
                }
                break;
            case -718233908:
                if (name.equals("getDictFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictFromDict.INSTANCE, args);
                }
                break;
            case -711609332:
                if (name.equals("getStoredIntegerValue")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetStoredIntegerValue.INSTANCE, args);
                }
                break;
            case -694406281:
                if (name.equals("toRadians")) {
                    return FunctionValidatorKt.withArgumentsValidation(DegreesToRadians.INSTANCE, args);
                }
                break;
            case -637295986:
                if (name.equals("getOptStringFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptStringFromDict.INSTANCE, args);
                }
                break;
            case -625627966:
                if (name.equals("getStoredDictValue")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetStoredDictValue.INSTANCE, args);
                }
                break;
            case -618173803:
                if (name.equals("getDictNumber")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictNumber.INSTANCE, args);
                }
                break;
            case -593965816:
                if (name.equals("getDictOptUrl")) {
                    if (Intrinsics.areEqual(GetDictOptUrlWithStringFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetDictOptUrlWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetDictOptUrlWithUrlFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetDictOptUrlWithUrlFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetDictOptUrlWithStringFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetDictOptUrlWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetDictOptUrlWithUrlFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetDictOptUrlWithUrlFallback.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case -567445985:
                if (name.equals("contains")) {
                    return FunctionValidatorKt.withArgumentsValidation(StringContains.INSTANCE, args);
                }
                break;
            case -505987374:
                if (name.equals("copySign")) {
                    if (Intrinsics.areEqual(DoubleCopySign.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleCopySign.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerCopySign.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerCopySign.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DoubleCopySign.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleCopySign.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerCopySign.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerCopySign.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case -496262374:
                if (name.equals("trimRight")) {
                    return FunctionValidatorKt.withArgumentsValidation(TrimRight.INSTANCE, args);
                }
                break;
            case -475795619:
                if (name.equals("getDictString")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictString.INSTANCE, args);
                }
                break;
            case -399551817:
                if (name.equals("toUpperCase")) {
                    return FunctionValidatorKt.withArgumentsValidation(ToUpperCase.INSTANCE, args);
                }
                break;
            case -342730167:
                if (name.equals("getOptNumberFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptNumberFromArray.INSTANCE, args);
                }
                break;
            case -288070202:
                if (name.equals("getOptNumberFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptNumberFromDict.INSTANCE, args);
                }
                break;
            case -256399843:
                if (name.equals("setMinutes")) {
                    return FunctionValidatorKt.withArgumentsValidation(SetMinutes.INSTANCE, args);
                }
                break;
            case -230929496:
                if (name.equals("getIntegerFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntegerFromDict.INSTANCE, args);
                }
                break;
            case -181255609:
                if (name.equals("addMillis")) {
                    return FunctionValidatorKt.withArgumentsValidation(AddMillis.INSTANCE, args);
                }
                break;
            case -174963751:
                if (name.equals("getUrlFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetUrlFromDict.INSTANCE, args);
                }
                break;
            case -116997076:
                if (name.equals("toDegrees")) {
                    return FunctionValidatorKt.withArgumentsValidation(RadiansToDegrees.INSTANCE, args);
                }
                break;
            case -92937393:
                if (name.equals("getStoredNumberValue")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetStoredNumberValue.INSTANCE, args);
                }
                break;
            case -74977101:
                if (name.equals("getYear")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetYear.INSTANCE, args);
                }
                break;
            case -57828916:
                if (name.equals("getArrayNumber")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayNumber.INSTANCE, args);
                }
                break;
            case -33620929:
                if (name.equals("getArrayOptUrl")) {
                    if (Intrinsics.areEqual(GetArrayOptUrlWithStringFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArrayOptUrlWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetArrayOptUrlWithUrlFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArrayOptUrlWithUrlFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetArrayOptUrlWithStringFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArrayOptUrlWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetArrayOptUrlWithUrlFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArrayOptUrlWithUrlFallback.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 3577:
                if (name.equals("pi")) {
                    return FunctionValidatorKt.withArgumentsValidation(Pi.INSTANCE, args);
                }
                break;
            case 96370:
                if (name.equals("abs")) {
                    if (Intrinsics.areEqual(DoubleAbs.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleAbs.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerAbs.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerAbs.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DoubleAbs.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleAbs.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerAbs.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerAbs.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 99473:
                if (name.equals("div")) {
                    if (Intrinsics.areEqual(DoubleDiv.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleDiv.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerDiv.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerDiv.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DoubleDiv.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleDiv.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerDiv.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerDiv.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 107029:
                if (name.equals(POBNativeConstants.NATIVE_LENGTH)) {
                    if (Intrinsics.areEqual(GetArrayLength.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArrayLength.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringLength.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringLength.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetArrayLength.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArrayLength.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringLength.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringLength.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 107876:
                if (name.equals("max")) {
                    if (Intrinsics.areEqual(DoubleMax.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleMax.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerMax.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerMax.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DoubleMax.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleMax.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerMax.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerMax.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 108114:
                if (name.equals("min")) {
                    if (Intrinsics.areEqual(DoubleMin.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleMin.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerMin.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerMin.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DoubleMin.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleMin.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerMin.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerMin.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 108290:
                if (name.equals("mod")) {
                    if (Intrinsics.areEqual(DoubleMod.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleMod.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerMod.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerMod.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DoubleMod.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleMod.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerMod.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerMod.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 108484:
                if (name.equals("mul")) {
                    if (Intrinsics.areEqual(DoubleMul.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleMul.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerMul.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerMul.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DoubleMul.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleMul.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerMul.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerMul.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 112845:
                if (name.equals("rgb")) {
                    return FunctionValidatorKt.withArgumentsValidation(ColorRgb.INSTANCE, args);
                }
                break;
            case 113880:
                if (name.equals("sin")) {
                    return FunctionValidatorKt.withArgumentsValidation(Sine.INSTANCE, args);
                }
                break;
            case 114240:
                if (name.equals(AuthenticationTokenClaims.JSON_KEY_SUB)) {
                    if (Intrinsics.areEqual(DoubleSub.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleSub.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerSub.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerSub.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DoubleSub.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleSub.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerSub.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerSub.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 114251:
                if (name.equals("sum")) {
                    if (Intrinsics.areEqual(DoubleSum.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleSum.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerSum.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerSum.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DoubleSum.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DoubleSum.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerSum.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerSum.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 3002572:
                if (name.equals("argb")) {
                    return FunctionValidatorKt.withArgumentsValidation(ColorArgb.INSTANCE, args);
                }
                break;
            case 3049733:
                if (name.equals("ceil")) {
                    return FunctionValidatorKt.withArgumentsValidation(DoubleCeil.INSTANCE, args);
                }
                break;
            case 3568674:
                if (name.equals("trim")) {
                    return FunctionValidatorKt.withArgumentsValidation(Trim.INSTANCE, args);
                }
                break;
            case 53078075:
                if (name.equals("minNumber")) {
                    return FunctionValidatorKt.withArgumentsValidation(DoubleMinValue.INSTANCE, args);
                }
                break;
            case 81708636:
                if (name.equals("getDictBoolean")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictBoolean.INSTANCE, args);
                }
                break;
            case 84549268:
                if (name.equals("getArrayString")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayString.INSTANCE, args);
                }
                break;
            case 88715890:
                if (name.equals("getNumberValue")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetNumberValue.INSTANCE, args);
                }
                break;
            case 97526796:
                if (name.equals("floor")) {
                    return FunctionValidatorKt.withArgumentsValidation(DoubleFloor.INSTANCE, args);
                }
                break;
            case 100346066:
                if (name.equals("index")) {
                    return FunctionValidatorKt.withArgumentsValidation(StringIndex.INSTANCE, args);
                }
                break;
            case 108704142:
                if (name.equals("round")) {
                    return FunctionValidatorKt.withArgumentsValidation(DoubleRound.INSTANCE, args);
                }
                break;
            case 110520564:
                if (name.equals("toUrl")) {
                    return FunctionValidatorKt.withArgumentsValidation(StringToUrl.INSTANCE, args);
                }
                break;
            case 181165108:
                if (name.equals("formatDateAsLocalWithLocale")) {
                    return FunctionValidatorKt.withArgumentsValidation(FormatDateAsLocalWithLocale.INSTANCE, args);
                }
                break;
            case 215331667:
                if (name.equals("getOptArrayFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptArrayFromArray.INSTANCE, args);
                }
                break;
            case 232128784:
                if (name.equals("getDictOptNumber")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictOptNumber.INSTANCE, args);
                }
                break;
            case 272530949:
                if (name.equals("getArrayBoolean")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayBoolean.INSTANCE, args);
                }
                break;
            case 294836803:
                if (name.equals("toInteger")) {
                    if (Intrinsics.areEqual(BooleanToInteger.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return BooleanToInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(NumberToInteger.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return NumberToInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringToInteger.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringToInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(BooleanToInteger.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return BooleanToInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(NumberToInteger.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return NumberToInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringToInteger.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringToInteger.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 374506968:
                if (name.equals("getDictOptString")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictOptString.INSTANCE, args);
                }
                break;
            case 407302472:
                if (name.equals("setMillis")) {
                    return FunctionValidatorKt.withArgumentsValidation(SetMillis.INSTANCE, args);
                }
                break;
            case 412791996:
                if (name.equals("getDictOptColor")) {
                    if (Intrinsics.areEqual(GetDictOptColorWithColorFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetDictOptColorWithColorFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetDictOptColorWithStringFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetDictOptColorWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetDictOptColorWithColorFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetDictOptColorWithColorFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetDictOptColorWithStringFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetDictOptColorWithStringFallback.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 515198110:
                if (name.equals("decodeUri")) {
                    return FunctionValidatorKt.withArgumentsValidation(StringDecodeUri.INSTANCE, args);
                }
                break;
            case 530542161:
                if (name.equals("substring")) {
                    return FunctionValidatorKt.withArgumentsValidation(StringSubstring.INSTANCE, args);
                }
                break;
            case 579215519:
                if (name.equals("getBooleanValue")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetBooleanValue.INSTANCE, args);
                }
                break;
            case 609553469:
                if (name.equals("getOptUrlFromArray")) {
                    if (Intrinsics.areEqual(GetOptUrlFromArrayWithStringFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptUrlFromArrayWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptUrlFromArrayWithUrlFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptUrlFromArrayWithUrlFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptUrlFromArrayWithStringFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptUrlFromArrayWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptUrlFromArrayWithUrlFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptUrlFromArrayWithUrlFallback.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 621919548:
                if (name.equals("getMillis")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetMillis.INSTANCE, args);
                }
                break;
            case 624675145:
                if (name.equals("getIntegerValue")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntegerValue.INSTANCE, args);
                }
                break;
            case 648795069:
                if (name.equals("setSeconds")) {
                    return FunctionValidatorKt.withArgumentsValidation(SetSeconds.INSTANCE, args);
                }
                break;
            case 671285057:
                if (name.equals("getDictOptBoolean")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictOptBoolean.INSTANCE, args);
                }
                break;
            case 757893007:
                if (name.equals("padStart")) {
                    if (Intrinsics.areEqual(PadStartInteger.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return PadStartInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(PadStartString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return PadStartString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(PadStartInteger.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return PadStartInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(PadStartString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return PadStartString.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 785010124:
                if (name.equals("getArrayUrl")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayUrl.INSTANCE, args);
                }
                break;
            case 815452174:
                if (name.equals("getArrayOptInteger")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayOptInteger.INSTANCE, args);
                }
                break;
            case 833284859:
                if (name.equals("getStoredUrlValue")) {
                    if (Intrinsics.areEqual(GetStoredUrlValueWithStringFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetStoredUrlValueWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetStoredUrlValueWithUrlFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetStoredUrlValueWithUrlFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetStoredUrlValueWithStringFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetStoredUrlValueWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetStoredUrlValueWithUrlFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetStoredUrlValueWithUrlFallback.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 851027282:
                if (name.equals("getOptUrlFromDict")) {
                    if (Intrinsics.areEqual(GetOptUrlFromDictWithStringFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptUrlFromDictWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptUrlFromDictWithUrlFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptUrlFromDictWithUrlFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptUrlFromDictWithStringFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptUrlFromDictWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptUrlFromDictWithUrlFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptUrlFromDictWithUrlFallback.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 902290499:
                if (name.equals("getArrayFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetArrayFromDict.INSTANCE, args);
                }
                break;
            case 963997617:
                if (name.equals("getColorAlpha")) {
                    if (Intrinsics.areEqual(ColorAlphaComponentGetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorAlphaComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringAlphaComponentGetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringAlphaComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorAlphaComponentGetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorAlphaComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringAlphaComponentGetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringAlphaComponentGetter.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 968898065:
                if (name.equals("getStoredArrayValue")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetStoredArrayValue.INSTANCE, args);
                }
                break;
            case 969706838:
                if (name.equals("getColorGreen")) {
                    if (Intrinsics.areEqual(ColorGreenComponentGetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorGreenComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringGreenComponentGetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringGreenComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorGreenComponentGetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorGreenComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringGreenComponentGetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringGreenComponentGetter.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 983060420:
                if (name.equals("getColorValue")) {
                    if (Intrinsics.areEqual(GetColorValue.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetColorValue.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetColorValueString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetColorValueString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetColorValue.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetColorValue.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetColorValueString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetColorValueString.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 1012555088:
                if (name.equals("getNumberFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetNumberFromArray.INSTANCE, args);
                }
                break;
            case 1022717043:
                if (name.equals("getOptDictFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptDictFromDict.INSTANCE, args);
                }
                break;
            case 1098852024:
                if (name.equals("getUrlValue")) {
                    if (Intrinsics.areEqual(GetUrlValueWithStringFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetUrlValueWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetUrlValueWithUrlFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetUrlValueWithUrlFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetUrlValueWithStringFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetUrlValueWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetUrlValueWithUrlFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetUrlValueWithUrlFallback.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 1298006409:
                if (name.equals("getOptColorFromArray")) {
                    if (Intrinsics.areEqual(GetOptColorFromArrayWithColorFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptColorFromArrayWithColorFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptColorFromArrayWithStringFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptColorFromArrayWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptColorFromArrayWithColorFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptColorFromArrayWithColorFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptColorFromArrayWithStringFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptColorFromArrayWithStringFallback.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 1309020812:
                if (name.equals("minInteger")) {
                    return FunctionValidatorKt.withArgumentsValidation(IntegerMinValue.INSTANCE, args);
                }
                break;
            case 1335732619:
                if (name.equals("getOptBooleanFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptBooleanFromDict.INSTANCE, args);
                }
                break;
            case 1346085543:
                if (name.equals("getStringFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetStringFromDict.INSTANCE, args);
                }
                break;
            case 1360482480:
                if (name.equals("setColorRed")) {
                    if (Intrinsics.areEqual(ColorRedComponentSetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorRedComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringRedComponentSetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringRedComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorRedComponentSetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorRedComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringRedComponentSetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringRedComponentSetter.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 1394182093:
                if (name.equals("setHours")) {
                    return FunctionValidatorKt.withArgumentsValidation(SetHours.INSTANCE, args);
                }
                break;
            case 1398793022:
                if (name.equals("setMonth")) {
                    return FunctionValidatorKt.withArgumentsValidation(SetMonth.INSTANCE, args);
                }
                break;
            case 1428631719:
                if (name.equals("getIntegerFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntegerFromArray.INSTANCE, args);
                }
                break;
            case 1449062308:
                if (name.equals("getColorRed")) {
                    if (Intrinsics.areEqual(ColorRedComponentGetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorRedComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringRedComponentGetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringRedComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorRedComponentGetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorRedComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringRedComponentGetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringRedComponentGetter.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 1507829577:
                if (name.equals("trimLeft")) {
                    return FunctionValidatorKt.withArgumentsValidation(TrimLeft.INSTANCE, args);
                }
                break;
            case 1508134774:
                if (name.equals("encodeUri")) {
                    return FunctionValidatorKt.withArgumentsValidation(StringEncodeUri.INSTANCE, args);
                }
                break;
            case 1565972102:
                if (name.equals("getOptColorFromDict")) {
                    if (Intrinsics.areEqual(GetOptColorFromDictWithColorFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptColorFromDictWithColorFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptColorFromDictWithStringFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptColorFromDictWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptColorFromDictWithColorFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptColorFromDictWithColorFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetOptColorFromDictWithStringFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetOptColorFromDictWithStringFallback.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 1636968764:
                if (name.equals("getOptDictFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptDictFromArray.INSTANCE, args);
                }
                break;
            case 1644730933:
                if (name.equals("nowLocal")) {
                    return FunctionValidatorKt.withArgumentsValidation(NowLocal.INSTANCE, args);
                }
                break;
            case 1695311327:
                if (name.equals("getNumberFromDict")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetNumberFromDict.INSTANCE, args);
                }
                break;
            case 1716172417:
                if (name.equals("getOptStringFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetOptStringFromArray.INSTANCE, args);
                }
                break;
            case 1738128829:
                if (name.equals("setColorAlpha")) {
                    if (Intrinsics.areEqual(ColorAlphaComponentSetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorAlphaComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringAlphaComponentSetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringAlphaComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorAlphaComponentSetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorAlphaComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringAlphaComponentSetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringAlphaComponentSetter.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 1743838050:
                if (name.equals("setColorGreen")) {
                    if (Intrinsics.areEqual(ColorGreenComponentSetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorGreenComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringGreenComponentSetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringGreenComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorGreenComponentSetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorGreenComponentSetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringGreenComponentSetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringGreenComponentSetter.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 1745084820:
                if (name.equals("getIntervalHours")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntervalHours.INSTANCE, args);
                }
                break;
            case 1814686973:
                if (name.equals("getBooleanFromArray")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetBooleanFromArray.INSTANCE, args);
                }
                break;
            case 1883462358:
                if (name.equals("getIntervalTotalMinutes")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntervalTotalMinutes.INSTANCE, args);
                }
                break;
            case 1910382545:
                if (name.equals("encodeRegex")) {
                    return FunctionValidatorKt.withArgumentsValidation(EncodeRegex.INSTANCE, args);
                }
                break;
            case 1953671716:
                if (name.equals("getIntervalMinutes")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetIntervalMinutes.INSTANCE, args);
                }
                break;
            case 1953831815:
                if (name.equals("getStoredStringValue")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetStoredStringValue.INSTANCE, args);
                }
                break;
            case 1955294553:
                if (name.equals("getHours")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetHours.INSTANCE, args);
                }
                break;
            case 1959905482:
                if (name.equals("getMonth")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetMonth.INSTANCE, args);
                }
                break;
            case 1970789287:
                if (name.equals("getColorBlue")) {
                    if (Intrinsics.areEqual(ColorBlueComponentGetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorBlueComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringBlueComponentGetter.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringBlueComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorBlueComponentGetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorBlueComponentGetter.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorStringBlueComponentGetter.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorStringBlueComponentGetter.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 1975049074:
                if (name.equals("getDictInteger")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetDictInteger.INSTANCE, args);
                }
                break;
            case 1985132479:
                if (name.equals("setYear")) {
                    return FunctionValidatorKt.withArgumentsValidation(SetYear.INSTANCE, args);
                }
                break;
            case 1992807388:
                if (name.equals("lastIndex")) {
                    return FunctionValidatorKt.withArgumentsValidation(StringLastIndex.INSTANCE, args);
                }
                break;
            case 2033316403:
                if (name.equals("getArrayOptColor")) {
                    if (Intrinsics.areEqual(GetArrayOptColorWithColorFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArrayOptColorWithColorFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetArrayOptColorWithStringFallback.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArrayOptColorWithStringFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetArrayOptColorWithColorFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArrayOptColorWithColorFallback.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetArrayOptColorWithStringFallback.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArrayOptColorWithStringFallback.INSTANCE;
                    }
                    throw FunctionValidatorKt.getFunctionArgumentsException$default(name, args, false, 4, null);
                }
                break;
            case 2075646548:
                if (name.equals("formatDateAsLocal")) {
                    return FunctionValidatorKt.withArgumentsValidation(FormatDateAsLocal.INSTANCE, args);
                }
                break;
            case 2101762217:
                if (name.equals("getMinutes")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetMinutes.INSTANCE, args);
                }
                break;
            case 2135485098:
                if (name.equals("getStringValue")) {
                    return FunctionValidatorKt.withArgumentsValidation(GetStringValue.INSTANCE, args);
                }
                break;
        }
        throw new EvaluableException("Unknown function name: " + name + '.', null, 2, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yandex.div.evaluable.FunctionProvider
    public Function getMethod(String name, List<? extends EvaluableType> args) throws Exception {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        switch (name.hashCode()) {
            case -1776922004:
                if (name.equals("toString")) {
                    if (Intrinsics.areEqual(ArrayToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(BooleanToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return BooleanToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DictToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DictToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(NumberToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return NumberToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(UrlToString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return UrlToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(BooleanToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return BooleanToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ColorToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ColorToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DictToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DictToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(IntegerToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return IntegerToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(NumberToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return NumberToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(StringToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return StringToString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(UrlToString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return UrlToString.INSTANCE;
                    }
                    throw FunctionValidatorKt.getMethodArgumentsException(name, args);
                }
                break;
            case -1300054776:
                if (name.equals("getInteger")) {
                    if (Intrinsics.areEqual(ArrayGetInteger.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetInteger.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayGetInteger.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetInteger.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetInteger.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetInteger.INSTANCE;
                    }
                    throw FunctionValidatorKt.getMethodArgumentsException(name, args);
                }
                break;
            case -1249348039:
                if (name.equals("getUrl")) {
                    if (Intrinsics.areEqual(ArrayGetUrl.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetUrl.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetUrl.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetUrl.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayGetUrl.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetUrl.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetUrl.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetUrl.INSTANCE;
                    }
                    throw FunctionValidatorKt.getMethodArgumentsException(name, args);
                }
                break;
            case -75598804:
                if (name.equals("getDict")) {
                    if (Intrinsics.areEqual(ArrayGetDict.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetDict.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetDict.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetDict.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayGetDict.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetDict.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetDict.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetDict.INSTANCE;
                    }
                    throw FunctionValidatorKt.getMethodArgumentsException(name, args);
                }
                break;
            case 208013248:
                if (name.equals("containsKey")) {
                    return FunctionValidatorKt.withArgumentsValidation(DictContainsKey.INSTANCE, args);
                }
                break;
            case 661651007:
                if (name.equals("getNumber")) {
                    if (Intrinsics.areEqual(ArrayGetNumber.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetNumber.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetNumber.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetNumber.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayGetNumber.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetNumber.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetNumber.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetNumber.INSTANCE;
                    }
                    throw FunctionValidatorKt.getMethodArgumentsException(name, args);
                }
                break;
            case 804029191:
                if (name.equals("getString")) {
                    if (Intrinsics.areEqual(ArrayGetString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetString.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayGetString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetString.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetString.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetString.INSTANCE;
                    }
                    throw FunctionValidatorKt.getMethodArgumentsException(name, args);
                }
                break;
            case 1101572082:
                if (name.equals("getBoolean")) {
                    if (Intrinsics.areEqual(ArrayGetBoolean.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetBoolean.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetBoolean.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetBoolean.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayGetBoolean.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetBoolean.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetBoolean.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetBoolean.INSTANCE;
                    }
                    throw FunctionValidatorKt.getMethodArgumentsException(name, args);
                }
                break;
            case 1948915875:
                if (name.equals("getArray")) {
                    if (Intrinsics.areEqual(ArrayGetArray.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetArray.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetArray.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArray.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayGetArray.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetArray.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetArray.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetArray.INSTANCE;
                    }
                    throw FunctionValidatorKt.getMethodArgumentsException(name, args);
                }
                break;
            case 1950668205:
                if (name.equals("getColor")) {
                    if (Intrinsics.areEqual(ArrayGetColor.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetColor.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetColor.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetColor.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayGetColor.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayGetColor.INSTANCE;
                    }
                    if (Intrinsics.areEqual(GetColor.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return GetColor.INSTANCE;
                    }
                    throw FunctionValidatorKt.getMethodArgumentsException(name, args);
                }
                break;
            case 2058039875:
                if (name.equals("isEmpty")) {
                    if (Intrinsics.areEqual(ArrayIsEmpty.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayIsEmpty.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DictIsEmpty.INSTANCE.matchesArguments$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DictIsEmpty.INSTANCE;
                    }
                    if (Intrinsics.areEqual(ArrayIsEmpty.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return ArrayIsEmpty.INSTANCE;
                    }
                    if (Intrinsics.areEqual(DictIsEmpty.INSTANCE.matchesArgumentsWithCast$div_evaluable(args), Function.MatchResult.Ok.INSTANCE)) {
                        return DictIsEmpty.INSTANCE;
                    }
                    throw FunctionValidatorKt.getMethodArgumentsException(name, args);
                }
                break;
        }
        throw new EvaluableException("Unknown method name: " + name + '.', null, 2, null);
    }

    public final void warmUp() {
        AddMillis addMillis = AddMillis.INSTANCE;
        ArrayToString arrayToString = ArrayToString.INSTANCE;
        BooleanToInteger booleanToInteger = BooleanToInteger.INSTANCE;
        BooleanToString booleanToString = BooleanToString.INSTANCE;
        ColorAlphaComponentGetter colorAlphaComponentGetter = ColorAlphaComponentGetter.INSTANCE;
        ColorAlphaComponentSetter colorAlphaComponentSetter = ColorAlphaComponentSetter.INSTANCE;
        ColorArgb colorArgb = ColorArgb.INSTANCE;
        ColorBlueComponentGetter colorBlueComponentGetter = ColorBlueComponentGetter.INSTANCE;
        ColorBlueComponentSetter colorBlueComponentSetter = ColorBlueComponentSetter.INSTANCE;
        ColorGreenComponentGetter colorGreenComponentGetter = ColorGreenComponentGetter.INSTANCE;
        ColorGreenComponentSetter colorGreenComponentSetter = ColorGreenComponentSetter.INSTANCE;
        ColorRedComponentGetter colorRedComponentGetter = ColorRedComponentGetter.INSTANCE;
        ColorRedComponentSetter colorRedComponentSetter = ColorRedComponentSetter.INSTANCE;
        ColorRgb colorRgb = ColorRgb.INSTANCE;
        ColorStringAlphaComponentGetter colorStringAlphaComponentGetter = ColorStringAlphaComponentGetter.INSTANCE;
        ColorStringAlphaComponentSetter colorStringAlphaComponentSetter = ColorStringAlphaComponentSetter.INSTANCE;
        ColorStringBlueComponentGetter colorStringBlueComponentGetter = ColorStringBlueComponentGetter.INSTANCE;
        ColorStringBlueComponentSetter colorStringBlueComponentSetter = ColorStringBlueComponentSetter.INSTANCE;
        ColorStringGreenComponentGetter colorStringGreenComponentGetter = ColorStringGreenComponentGetter.INSTANCE;
        ColorStringGreenComponentSetter colorStringGreenComponentSetter = ColorStringGreenComponentSetter.INSTANCE;
        ColorStringRedComponentGetter colorStringRedComponentGetter = ColorStringRedComponentGetter.INSTANCE;
        ColorStringRedComponentSetter colorStringRedComponentSetter = ColorStringRedComponentSetter.INSTANCE;
        ColorToString colorToString = ColorToString.INSTANCE;
        DegreesToRadians degreesToRadians = DegreesToRadians.INSTANCE;
        DictToString dictToString = DictToString.INSTANCE;
        DoubleAbs doubleAbs = DoubleAbs.INSTANCE;
        DoubleCeil doubleCeil = DoubleCeil.INSTANCE;
        DoubleCopySign doubleCopySign = DoubleCopySign.INSTANCE;
        DoubleDiv doubleDiv = DoubleDiv.INSTANCE;
        DoubleFloor doubleFloor = DoubleFloor.INSTANCE;
        DoubleMax doubleMax = DoubleMax.INSTANCE;
        DoubleMaxValue doubleMaxValue = DoubleMaxValue.INSTANCE;
        DoubleMin doubleMin = DoubleMin.INSTANCE;
        DoubleMinValue doubleMinValue = DoubleMinValue.INSTANCE;
        DoubleMod doubleMod = DoubleMod.INSTANCE;
        DoubleMul doubleMul = DoubleMul.INSTANCE;
        DoubleRound doubleRound = DoubleRound.INSTANCE;
        DoubleSignum doubleSignum = DoubleSignum.INSTANCE;
        DoubleSub doubleSub = DoubleSub.INSTANCE;
        DoubleSum doubleSum = DoubleSum.INSTANCE;
        EncodeRegex encodeRegex = EncodeRegex.INSTANCE;
        FormatDateAsLocal formatDateAsLocal = FormatDateAsLocal.INSTANCE;
        FormatDateAsLocalWithLocale formatDateAsLocalWithLocale = FormatDateAsLocalWithLocale.INSTANCE;
        FormatDateAsUTC formatDateAsUTC = FormatDateAsUTC.INSTANCE;
        FormatDateAsUTCWithLocale formatDateAsUTCWithLocale = FormatDateAsUTCWithLocale.INSTANCE;
        GetArrayBoolean getArrayBoolean = GetArrayBoolean.INSTANCE;
        GetArrayColor getArrayColor = GetArrayColor.INSTANCE;
        GetArrayFromArray getArrayFromArray = GetArrayFromArray.INSTANCE;
        GetArrayFromDict getArrayFromDict = GetArrayFromDict.INSTANCE;
        GetArrayInteger getArrayInteger = GetArrayInteger.INSTANCE;
        GetArrayLength getArrayLength = GetArrayLength.INSTANCE;
        GetArrayNumber getArrayNumber = GetArrayNumber.INSTANCE;
        GetArrayOptBoolean getArrayOptBoolean = GetArrayOptBoolean.INSTANCE;
        GetArrayOptColorWithColorFallback getArrayOptColorWithColorFallback = GetArrayOptColorWithColorFallback.INSTANCE;
        GetArrayOptColorWithStringFallback getArrayOptColorWithStringFallback = GetArrayOptColorWithStringFallback.INSTANCE;
        GetArrayOptInteger getArrayOptInteger = GetArrayOptInteger.INSTANCE;
        GetArrayOptNumber getArrayOptNumber = GetArrayOptNumber.INSTANCE;
        GetArrayOptString getArrayOptString = GetArrayOptString.INSTANCE;
        GetArrayOptUrlWithStringFallback getArrayOptUrlWithStringFallback = GetArrayOptUrlWithStringFallback.INSTANCE;
        GetArrayOptUrlWithUrlFallback getArrayOptUrlWithUrlFallback = GetArrayOptUrlWithUrlFallback.INSTANCE;
        GetArrayString getArrayString = GetArrayString.INSTANCE;
        GetArrayUrl getArrayUrl = GetArrayUrl.INSTANCE;
        GetBooleanFromArray getBooleanFromArray = GetBooleanFromArray.INSTANCE;
        GetBooleanFromDict getBooleanFromDict = GetBooleanFromDict.INSTANCE;
        GetBooleanValue getBooleanValue = GetBooleanValue.INSTANCE;
        GetColorFromArray getColorFromArray = GetColorFromArray.INSTANCE;
        GetColorFromDict getColorFromDict = GetColorFromDict.INSTANCE;
        GetColorValue getColorValue = GetColorValue.INSTANCE;
        GetColorValueString getColorValueString = GetColorValueString.INSTANCE;
        GetDay getDay = GetDay.INSTANCE;
        GetDayOfWeek getDayOfWeek = GetDayOfWeek.INSTANCE;
        GetDictBoolean getDictBoolean = GetDictBoolean.INSTANCE;
        GetDictColor getDictColor = GetDictColor.INSTANCE;
        GetDictFromArray getDictFromArray = GetDictFromArray.INSTANCE;
        GetDictFromDict getDictFromDict = GetDictFromDict.INSTANCE;
        GetDictInteger getDictInteger = GetDictInteger.INSTANCE;
        GetDictNumber getDictNumber = GetDictNumber.INSTANCE;
        GetDictOptBoolean getDictOptBoolean = GetDictOptBoolean.INSTANCE;
        GetDictOptColorWithColorFallback getDictOptColorWithColorFallback = GetDictOptColorWithColorFallback.INSTANCE;
        GetDictOptColorWithStringFallback getDictOptColorWithStringFallback = GetDictOptColorWithStringFallback.INSTANCE;
        GetDictOptInteger getDictOptInteger = GetDictOptInteger.INSTANCE;
        GetDictOptNumber getDictOptNumber = GetDictOptNumber.INSTANCE;
        GetDictOptString getDictOptString = GetDictOptString.INSTANCE;
        GetDictOptUrlWithStringFallback getDictOptUrlWithStringFallback = GetDictOptUrlWithStringFallback.INSTANCE;
        GetDictOptUrlWithUrlFallback getDictOptUrlWithUrlFallback = GetDictOptUrlWithUrlFallback.INSTANCE;
        GetDictString getDictString = GetDictString.INSTANCE;
        GetDictUrl getDictUrl = GetDictUrl.INSTANCE;
        GetHours getHours = GetHours.INSTANCE;
        GetIntegerFromArray getIntegerFromArray = GetIntegerFromArray.INSTANCE;
        GetIntegerFromDict getIntegerFromDict = GetIntegerFromDict.INSTANCE;
        GetIntegerValue getIntegerValue = GetIntegerValue.INSTANCE;
        GetIntervalHours getIntervalHours = GetIntervalHours.INSTANCE;
        GetIntervalMinutes getIntervalMinutes = GetIntervalMinutes.INSTANCE;
        GetIntervalSeconds getIntervalSeconds = GetIntervalSeconds.INSTANCE;
        GetIntervalTotalDays getIntervalTotalDays = GetIntervalTotalDays.INSTANCE;
        GetIntervalTotalHours getIntervalTotalHours = GetIntervalTotalHours.INSTANCE;
        GetIntervalTotalMinutes getIntervalTotalMinutes = GetIntervalTotalMinutes.INSTANCE;
        GetIntervalTotalSeconds getIntervalTotalSeconds = GetIntervalTotalSeconds.INSTANCE;
        GetIntervalTotalWeeks getIntervalTotalWeeks = GetIntervalTotalWeeks.INSTANCE;
        GetMillis getMillis = GetMillis.INSTANCE;
        GetMinutes getMinutes = GetMinutes.INSTANCE;
        GetMonth getMonth = GetMonth.INSTANCE;
        GetNumberFromArray getNumberFromArray = GetNumberFromArray.INSTANCE;
        GetNumberFromDict getNumberFromDict = GetNumberFromDict.INSTANCE;
        GetNumberValue getNumberValue = GetNumberValue.INSTANCE;
        GetOptArrayFromArray getOptArrayFromArray = GetOptArrayFromArray.INSTANCE;
        GetOptArrayFromDict getOptArrayFromDict = GetOptArrayFromDict.INSTANCE;
        GetOptBooleanFromArray getOptBooleanFromArray = GetOptBooleanFromArray.INSTANCE;
        GetOptBooleanFromDict getOptBooleanFromDict = GetOptBooleanFromDict.INSTANCE;
        GetOptColorFromArrayWithColorFallback getOptColorFromArrayWithColorFallback = GetOptColorFromArrayWithColorFallback.INSTANCE;
        GetOptColorFromArrayWithStringFallback getOptColorFromArrayWithStringFallback = GetOptColorFromArrayWithStringFallback.INSTANCE;
        GetOptColorFromDictWithColorFallback getOptColorFromDictWithColorFallback = GetOptColorFromDictWithColorFallback.INSTANCE;
        GetOptColorFromDictWithStringFallback getOptColorFromDictWithStringFallback = GetOptColorFromDictWithStringFallback.INSTANCE;
        GetOptDictFromArray getOptDictFromArray = GetOptDictFromArray.INSTANCE;
        GetOptDictFromDict getOptDictFromDict = GetOptDictFromDict.INSTANCE;
        GetOptIntegerFromArray getOptIntegerFromArray = GetOptIntegerFromArray.INSTANCE;
        GetOptIntegerFromDict getOptIntegerFromDict = GetOptIntegerFromDict.INSTANCE;
        GetOptNumberFromArray getOptNumberFromArray = GetOptNumberFromArray.INSTANCE;
        GetOptNumberFromDict getOptNumberFromDict = GetOptNumberFromDict.INSTANCE;
        GetOptStringFromArray getOptStringFromArray = GetOptStringFromArray.INSTANCE;
        GetOptStringFromDict getOptStringFromDict = GetOptStringFromDict.INSTANCE;
        GetOptUrlFromArrayWithStringFallback getOptUrlFromArrayWithStringFallback = GetOptUrlFromArrayWithStringFallback.INSTANCE;
        GetOptUrlFromArrayWithUrlFallback getOptUrlFromArrayWithUrlFallback = GetOptUrlFromArrayWithUrlFallback.INSTANCE;
        GetOptUrlFromDictWithStringFallback getOptUrlFromDictWithStringFallback = GetOptUrlFromDictWithStringFallback.INSTANCE;
        GetOptUrlFromDictWithUrlFallback getOptUrlFromDictWithUrlFallback = GetOptUrlFromDictWithUrlFallback.INSTANCE;
        GetSeconds getSeconds = GetSeconds.INSTANCE;
        GetStoredArrayValue getStoredArrayValue = GetStoredArrayValue.INSTANCE;
        GetStoredBooleanValue getStoredBooleanValue = GetStoredBooleanValue.INSTANCE;
        GetStoredColorValue getStoredColorValue = GetStoredColorValue.INSTANCE;
        GetStoredColorValueString getStoredColorValueString = GetStoredColorValueString.INSTANCE;
        GetStoredDictValue getStoredDictValue = GetStoredDictValue.INSTANCE;
        GetStoredIntegerValue getStoredIntegerValue = GetStoredIntegerValue.INSTANCE;
        GetStoredNumberValue getStoredNumberValue = GetStoredNumberValue.INSTANCE;
        GetStoredStringValue getStoredStringValue = GetStoredStringValue.INSTANCE;
        GetStoredUrlValueWithStringFallback getStoredUrlValueWithStringFallback = GetStoredUrlValueWithStringFallback.INSTANCE;
        GetStoredUrlValueWithUrlFallback getStoredUrlValueWithUrlFallback = GetStoredUrlValueWithUrlFallback.INSTANCE;
        GetStringFromArray getStringFromArray = GetStringFromArray.INSTANCE;
        GetStringFromDict getStringFromDict = GetStringFromDict.INSTANCE;
        GetStringValue getStringValue = GetStringValue.INSTANCE;
        GetUrlFromArray getUrlFromArray = GetUrlFromArray.INSTANCE;
        GetUrlFromDict getUrlFromDict = GetUrlFromDict.INSTANCE;
        GetUrlValueWithStringFallback getUrlValueWithStringFallback = GetUrlValueWithStringFallback.INSTANCE;
        GetUrlValueWithUrlFallback getUrlValueWithUrlFallback = GetUrlValueWithUrlFallback.INSTANCE;
        GetYear getYear = GetYear.INSTANCE;
        IntegerAbs integerAbs = IntegerAbs.INSTANCE;
        IntegerCopySign integerCopySign = IntegerCopySign.INSTANCE;
        IntegerDiv integerDiv = IntegerDiv.INSTANCE;
        IntegerMax integerMax = IntegerMax.INSTANCE;
        IntegerMaxValue integerMaxValue = IntegerMaxValue.INSTANCE;
        IntegerMin integerMin = IntegerMin.INSTANCE;
        IntegerMinValue integerMinValue = IntegerMinValue.INSTANCE;
        IntegerMod integerMod = IntegerMod.INSTANCE;
        IntegerMul integerMul = IntegerMul.INSTANCE;
        IntegerSignum integerSignum = IntegerSignum.INSTANCE;
        IntegerSub integerSub = IntegerSub.INSTANCE;
        IntegerSum integerSum = IntegerSum.INSTANCE;
        IntegerToBoolean integerToBoolean = IntegerToBoolean.INSTANCE;
        IntegerToNumber integerToNumber = IntegerToNumber.INSTANCE;
        IntegerToString integerToString = IntegerToString.INSTANCE;
        NowLocal nowLocal = NowLocal.INSTANCE;
        NumberToInteger numberToInteger = NumberToInteger.INSTANCE;
        NumberToString numberToString = NumberToString.INSTANCE;
        PadEndInteger padEndInteger = PadEndInteger.INSTANCE;
        PadEndString padEndString = PadEndString.INSTANCE;
        PadStartInteger padStartInteger = PadStartInteger.INSTANCE;
        PadStartString padStartString = PadStartString.INSTANCE;
        ParseUnixTime parseUnixTime = ParseUnixTime.INSTANCE;
        ParseUnixTimeAsLocal parseUnixTimeAsLocal = ParseUnixTimeAsLocal.INSTANCE;
        Pi pi = Pi.INSTANCE;
        RadiansToDegrees radiansToDegrees = RadiansToDegrees.INSTANCE;
        SetDay setDay = SetDay.INSTANCE;
        SetHours setHours = SetHours.INSTANCE;
        SetMillis setMillis = SetMillis.INSTANCE;
        SetMinutes setMinutes = SetMinutes.INSTANCE;
        SetMonth setMonth = SetMonth.INSTANCE;
        SetSeconds setSeconds = SetSeconds.INSTANCE;
        SetYear setYear = SetYear.INSTANCE;
        Sine sine = Sine.INSTANCE;
        StringContains stringContains = StringContains.INSTANCE;
        StringDecodeUri stringDecodeUri = StringDecodeUri.INSTANCE;
        StringEncodeUri stringEncodeUri = StringEncodeUri.INSTANCE;
        StringIndex stringIndex = StringIndex.INSTANCE;
        StringLastIndex stringLastIndex = StringLastIndex.INSTANCE;
        StringLength stringLength = StringLength.INSTANCE;
        StringReplaceAll stringReplaceAll = StringReplaceAll.INSTANCE;
        StringSubstring stringSubstring = StringSubstring.INSTANCE;
        StringToBoolean stringToBoolean = StringToBoolean.INSTANCE;
        StringToColor stringToColor = StringToColor.INSTANCE;
        StringToInteger stringToInteger = StringToInteger.INSTANCE;
        StringToNumber stringToNumber = StringToNumber.INSTANCE;
        StringToString stringToString = StringToString.INSTANCE;
        StringToUrl stringToUrl = StringToUrl.INSTANCE;
        TestRegex testRegex = TestRegex.INSTANCE;
        ToLowerCase toLowerCase = ToLowerCase.INSTANCE;
        ToUpperCase toUpperCase = ToUpperCase.INSTANCE;
        Trim trim = Trim.INSTANCE;
        TrimLeft trimLeft = TrimLeft.INSTANCE;
        TrimRight trimRight = TrimRight.INSTANCE;
        UrlToString urlToString = UrlToString.INSTANCE;
    }
}
