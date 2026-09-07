package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.collections.Lists;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.fi.Predicate;
import com.smaato.sdk.video.fi.CheckedFunction;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes12.dex */
public class RegistryXmlParser {
    private static final CheckedFunction booleanAttributeConvertion = new CheckedFunction() { // from class: com.smaato.sdk.video.vast.parser.RegistryXmlParser$$ExternalSyntheticLambda6
        @Override // com.smaato.sdk.video.fi.CheckedFunction
        public final Object apply(Object obj) {
            return RegistryXmlParser.lambda$static$0((String) obj);
        }
    };
    private final Map parsers;
    private final XmlPullParser xmlPullParser;

    static /* synthetic */ String lambda$parseStringAttribute$1(String str) {
        return str;
    }

    static /* synthetic */ Boolean lambda$static$0(String str) throws ParsingCoverterException {
        if (str.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        throw new ParsingCoverterException("Cannot convert: \"" + str + "\" to boolean");
    }

    public RegistryXmlParser(XmlPullParser xmlPullParser, Map<String, XmlClassParser> map) {
        this.xmlPullParser = (XmlPullParser) Objects.requireNonNull(xmlPullParser);
        this.parsers = (Map) Objects.requireNonNull(map);
    }

    private static boolean containsIn(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str)) {
            List listAsList = Arrays.asList(strArr);
            java.util.Objects.requireNonNull(str);
            if (Lists.any(listAsList, new Predicate() { // from class: com.smaato.sdk.video.vast.parser.RegistryXmlParser$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Predicate
                public final boolean test(Object obj) {
                    return str.equalsIgnoreCase((String) obj);
                }
            })) {
                return true;
            }
        }
        return false;
    }

    public <T> void registerParser(String str, XmlClassParser<T> xmlClassParser) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(xmlClassParser);
        this.parsers.put(str, xmlClassParser);
    }

    public RegistryXmlParser prepare(InputStream inputStream, String str) throws XmlPullParserException, IOException {
        Objects.requireNonNull(inputStream);
        if (TextUtils.isEmpty(str) || !XmlEncodingUtils.isSupported(str)) {
            str = null;
        }
        this.xmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        this.xmlPullParser.setInput(inputStream, str);
        this.xmlPullParser.nextTag();
        return this;
    }

    public <Result> RegistryXmlParser parseClass(String str, NonNullConsumer<ParseResult<Result>> nonNullConsumer) {
        Objects.requireNonNull(str);
        XmlClassParser xmlClassParser = (XmlClassParser) this.parsers.get(str);
        try {
            if (xmlClassParser == null) {
                nonNullConsumer.accept(ParseResult.error(str, new NullPointerException("XmlClassParser for " + str + " is not found")));
                skip();
            } else {
                acceptOrSkip(nonNullConsumer, xmlClassParser.parse(this));
            }
        } catch (Exception e) {
            nonNullConsumer.accept(ParseResult.error(str, new Exception("Exception while parsing " + str, e)));
        }
        return this;
    }

    public RegistryXmlParser parseString(Consumer<String> consumer, Consumer<Exception> consumer2) {
        try {
            String strTrim = null;
            if (this.xmlPullParser.next() == 4) {
                String text = this.xmlPullParser.getText();
                if (text != null) {
                    strTrim = text.trim();
                }
                this.xmlPullParser.nextTag();
            }
            consumer.accept(strTrim);
        } catch (IOException | XmlPullParserException e) {
            consumer2.accept(e);
        }
        return this;
    }

    public RegistryXmlParser parseTags(String[] strArr, Consumer<String> consumer, Consumer<Exception> consumer2) {
        while (this.xmlPullParser.next() != 3) {
            try {
                if (this.xmlPullParser.getEventType() == 1) {
                    throw new XmlPullParserException("XML END tag is missing");
                }
                if (this.xmlPullParser.getEventType() == 2) {
                    String name = this.xmlPullParser.getName();
                    if (containsIn(name, strArr)) {
                        consumer.accept(name);
                    } else {
                        skip();
                    }
                }
            } catch (IOException | XmlPullParserException e) {
                consumer2.accept(e);
            }
        }
        return this;
    }

    public RegistryXmlParser parseStringAttribute(String str, Consumer<String> consumer, Consumer<ParseError> consumer2) {
        return parseTypedAttribute(str, new CheckedFunction() { // from class: com.smaato.sdk.video.vast.parser.RegistryXmlParser$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.video.fi.CheckedFunction
            public final Object apply(Object obj) {
                return RegistryXmlParser.lambda$parseStringAttribute$1((String) obj);
            }
        }, consumer, consumer2);
    }

    public RegistryXmlParser parseIntegerAttribute(String str, Consumer<Integer> consumer, Consumer<ParseError> consumer2) {
        return parseTypedAttribute(str, new CheckedFunction() { // from class: com.smaato.sdk.video.vast.parser.RegistryXmlParser$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.video.fi.CheckedFunction
            public final Object apply(Object obj) {
                return Integer.valueOf(Integer.parseInt((String) obj));
            }
        }, consumer, consumer2);
    }

    public RegistryXmlParser parseFloatAttribute(String str, Consumer<Float> consumer, Consumer<ParseError> consumer2) {
        return parseTypedAttribute(str, new CheckedFunction() { // from class: com.smaato.sdk.video.vast.parser.RegistryXmlParser$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.video.fi.CheckedFunction
            public final Object apply(Object obj) {
                return Float.valueOf(Float.parseFloat((String) obj));
            }
        }, consumer, consumer2);
    }

    public RegistryXmlParser parseBooleanAttribute(String str, Consumer<Boolean> consumer, Consumer<ParseError> consumer2) {
        return parseTypedAttribute(str, booleanAttributeConvertion, consumer, consumer2);
    }

    public <Result> RegistryXmlParser parseTypedAttribute(final String str, CheckedFunction<String, Result> checkedFunction, Consumer<Result> consumer, Consumer<ParseError> consumer2) {
        int attributeCount = this.xmlPullParser.getAttributeCount();
        String attributeValue = null;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = this.xmlPullParser.getAttributeName(i);
            if (str.equalsIgnoreCase(attributeName)) {
                attributeValue = this.xmlPullParser.getAttributeValue(null, attributeName);
            }
        }
        if (attributeValue != null) {
            try {
                consumer.accept(checkedFunction.apply(attributeValue));
            } catch (Exception e) {
                Objects.onNotNull(consumer2, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.RegistryXmlParser$$ExternalSyntheticLambda1
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        ((Consumer) obj).accept(ParseError.buildFrom(str, e));
                    }
                });
            }
        } else {
            final String str2 = "No attribute found for name: " + str;
            Objects.onNotNull(consumer2, new Consumer() { // from class: com.smaato.sdk.video.vast.parser.RegistryXmlParser$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(ParseError.buildFrom(str, new VastElementMissingException(str2)));
                }
            });
        }
        return this;
    }

    public void skip() throws XmlPullParserException, IOException {
        if (this.xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        skipToEndTag();
    }

    public void skipToEndTag() throws XmlPullParserException, IOException {
        int i = 1;
        while (i != 0) {
            int next = this.xmlPullParser.next();
            if (next != 1) {
                if (next == 2) {
                    i++;
                } else if (next == 3) {
                    i--;
                }
            } else if (i > 0) {
                throw new XmlPullParserException("XML END tag is missing");
            }
        }
    }

    private void acceptOrSkip(NonNullConsumer nonNullConsumer, Object obj) throws Exception {
        try {
            nonNullConsumer.accept(obj);
        } catch (Exception e) {
            skipToEndTag();
            throw e;
        }
    }
}
