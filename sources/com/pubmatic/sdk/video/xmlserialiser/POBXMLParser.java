package com.pubmatic.sdk.video.xmlserialiser;

import com.pubmatic.sdk.common.log.POBLog;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/* JADX INFO: loaded from: classes11.dex */
public class POBXMLParser {
    protected static Node createNode(String str) throws Exception {
        Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str))).getDocumentElement();
        documentElement.normalize();
        return documentElement;
    }

    public static <T extends POBXMLNodeListener> T parse(String str, Class<T> cls) {
        try {
            Node nodeCreateNode = createNode(str);
            T tNewInstance = cls.newInstance();
            tNewInstance.build(new POBNodeBuilder(nodeCreateNode));
            return tNewInstance;
        } catch (Exception e) {
            POBLog.error("POBXMLParser", e.getMessage(), new Object[0]);
            return null;
        }
    }
}
