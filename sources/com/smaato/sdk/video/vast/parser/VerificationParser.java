package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.model.InLine$Builder$$ExternalSyntheticLambda0;
import com.smaato.sdk.video.vast.model.JavaScriptResource;
import com.smaato.sdk.video.vast.model.Verification;
import com.smaato.sdk.video.vast.model.ViewableImpression;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class VerificationParser implements XmlClassParser<Verification> {
    private static final String[] VERIFICATION_TAGS = {"JavaScriptResource", "VerificationParameters", "ViewableImpression"};

    @Override // com.smaato.sdk.video.vast.parser.XmlClassParser
    public ParseResult<Verification> parse(final RegistryXmlParser registryXmlParser) {
        Verification verificationBuild;
        final Verification.Builder builder = new Verification.Builder();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        builder.setJavaScriptResources(arrayList);
        registryXmlParser.parseStringAttribute("vendor", new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VerificationParser$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                builder.setVendor((String) obj);
            }
        }, new AdParametersParser$$ExternalSyntheticLambda1(arrayList2)).parseTags(VERIFICATION_TAGS, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VerificationParser$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                VerificationParser.lambda$parse$5(registryXmlParser, arrayList, arrayList2, builder, (String) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VerificationParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                arrayList2.add(ParseError.buildFrom("Verification", new Exception("Unable to parse tags in Verification", (Exception) obj)));
            }
        });
        try {
            verificationBuild = builder.build();
        } catch (VastElementMissingException e) {
            arrayList2.add(ParseError.buildFrom("Verification", e));
            verificationBuild = null;
        }
        return new ParseResult.Builder().setResult(verificationBuild).setErrors(arrayList2).build();
    }

    static /* synthetic */ void lambda$parse$5(RegistryXmlParser registryXmlParser, final List list, final List list2, final Verification.Builder builder, String str) {
        if ("JavaScriptResource".equalsIgnoreCase(str)) {
            registryXmlParser.parseClass("JavaScriptResource", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.VerificationParser$$ExternalSyntheticLambda5
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    Objects.onNotNull((ParseResult) obj, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VerificationParser$$ExternalSyntheticLambda1
                        @Override // com.smaato.sdk.core.util.fi.Consumer
                        public final void accept(Object obj2) {
                            VerificationParser.lambda$parse$0(list, list, (ParseResult) obj2);
                        }
                    });
                }
            });
            return;
        }
        if ("VerificationParameters".equalsIgnoreCase(str)) {
            java.util.Objects.requireNonNull(builder);
            registryXmlParser.parseString(new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VerificationParser$$ExternalSyntheticLambda6
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    builder.setVerificationParameters((String) obj);
                }
            }, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VerificationParser$$ExternalSyntheticLambda7
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    list2.add(ParseError.buildFrom("VerificationParameters", new Exception("Unable to parse verification parameters", (Exception) obj)));
                }
            });
        } else if ("ViewableImpression".equalsIgnoreCase(str)) {
            registryXmlParser.parseClass("ViewableImpression", new NonNullConsumer() { // from class: com.smaato.sdk.video.vast.parser.VerificationParser$$ExternalSyntheticLambda8
                @Override // com.smaato.sdk.video.fi.NonNullConsumer
                public final void accept(Object obj) {
                    Objects.onNotNull((ParseResult) obj, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.VerificationParser$$ExternalSyntheticLambda0
                        @Override // com.smaato.sdk.core.util.fi.Consumer
                        public final void accept(Object obj2) {
                            VerificationParser.lambda$parse$3(builder, list, (ParseResult) obj2);
                        }
                    });
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$0(List list, List list2, ParseResult parseResult) {
        list.add((JavaScriptResource) parseResult.value);
        List<ParseError> list3 = parseResult.errors;
        java.util.Objects.requireNonNull(list2);
        Objects.onNotNull(list3, new InLine$Builder$$ExternalSyntheticLambda0(list2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$parse$3(Verification.Builder builder, List list, ParseResult parseResult) {
        builder.setViewableImpression((ViewableImpression) parseResult.value);
        List<ParseError> list2 = parseResult.errors;
        java.util.Objects.requireNonNull(list);
        Objects.onNotNull(list2, new InLine$Builder$$ExternalSyntheticLambda0(list));
    }
}
