package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.fi.NonNullConsumer;
import com.smaato.sdk.video.vast.model.VastTree;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes12.dex */
public class VastResponseParser {
    private final RegistryXmlParser xmlPullParser;

    public VastResponseParser(RegistryXmlParser registryXmlParser) {
        this.xmlPullParser = (RegistryXmlParser) Objects.requireNonNull(registryXmlParser, "Parameter xmlPullParser cannot be null for VastResponseParser::new");
    }

    public void parseVastResponse(Logger logger, InputStream inputStream, String str, NonNullConsumer<ParseResult<VastTree>> nonNullConsumer) {
        Objects.requireNonNull(logger);
        Objects.requireNonNull(inputStream);
        Objects.requireNonNull(nonNullConsumer);
        try {
            this.xmlPullParser.prepare(inputStream, str).parseClass("VAST", nonNullConsumer);
        } catch (IOException e) {
            e = e;
            nonNullConsumer.accept(ParseResult.error("VAST", e));
        } catch (ArrayIndexOutOfBoundsException e2) {
            e = e2;
            nonNullConsumer.accept(ParseResult.error("VAST", e));
        } catch (AssertionError unused) {
            nonNullConsumer.accept(ParseResult.error("VAST", new Exception("AssertionError")));
        } catch (XmlPullParserException e3) {
            e = e3;
            nonNullConsumer.accept(ParseResult.error("VAST", e));
        } catch (Exception unused2) {
            nonNullConsumer.accept(ParseResult.error("VAST", new Exception("Exception while parsing the xml")));
        }
    }
}
