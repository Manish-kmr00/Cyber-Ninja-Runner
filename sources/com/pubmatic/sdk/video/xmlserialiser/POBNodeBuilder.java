package com.pubmatic.sdk.video.xmlserialiser;

import com.pubmatic.sdk.common.log.POBLog;
import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes11.dex */
public class POBNodeBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Node f7880a;

    public POBNodeBuilder(Node node) {
        this.f7880a = node;
    }

    private NodeList a(String str) {
        try {
            return (NodeList) XPathFactory.newInstance().newXPath().compile(str).evaluate(this.f7880a, XPathConstants.NODESET);
        } catch (Exception e) {
            POBLog.error("POBNodeBuilder", e.getMessage(), new Object[0]);
            return null;
        }
    }

    public String getAttributeValue(String str) {
        Node node = getNode("@" + str);
        if (node != null) {
            return node.getTextContent().trim();
        }
        return null;
    }

    public Node getNode(String str) {
        try {
            return (Node) XPathFactory.newInstance().newXPath().compile(str).evaluate(this.f7880a, XPathConstants.NODE);
        } catch (Exception e) {
            POBLog.error("POBNodeBuilder", e.getMessage(), new Object[0]);
            return null;
        }
    }

    public String getNodeName() {
        Node node = this.f7880a;
        if (node != null) {
            return node.getNodeName();
        }
        return null;
    }

    public <T extends POBXMLNodeListener> T getNodeObject(String str, Class<T> cls) {
        Node node = getNode(str);
        if (node != null) {
            try {
                T tNewInstance = cls.newInstance();
                tNewInstance.build(new POBNodeBuilder(node));
                return tNewInstance;
            } catch (Exception e) {
                POBLog.error("POBNodeBuilder", e.getMessage(), new Object[0]);
            }
        }
        return null;
    }

    public String getNodeValue() {
        Node node = this.f7880a;
        if (node == null || node.getTextContent().isEmpty()) {
            return null;
        }
        return this.f7880a.getTextContent().trim();
    }

    public <T extends POBXMLNodeListener> List<T> getObjectList(String str, Class<T> cls) {
        NodeList nodeListA = a(str);
        if (nodeListA == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < nodeListA.getLength(); i++) {
            Node nodeItem = nodeListA.item(i);
            if (nodeItem != null) {
                try {
                    T tNewInstance = cls.newInstance();
                    tNewInstance.build(new POBNodeBuilder(nodeItem));
                    arrayList.add(tNewInstance);
                } catch (Exception e) {
                    POBLog.error("POBNodeBuilder", e.getMessage(), new Object[0]);
                    return null;
                }
            }
        }
        return arrayList;
    }

    public List<String> getStringList(String str) {
        NodeList nodeListA = a(str);
        if (nodeListA == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < nodeListA.getLength(); i++) {
            Node nodeItem = nodeListA.item(i);
            if (nodeItem != null) {
                arrayList.add(nodeItem.getTextContent().trim());
            }
        }
        return arrayList;
    }

    public String getNodeValue(String str) {
        Node node = getNode(str);
        if (node != null) {
            return node.getTextContent().trim();
        }
        return null;
    }
}
