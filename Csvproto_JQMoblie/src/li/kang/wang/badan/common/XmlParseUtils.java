package li.kang.wang.badan.common;

import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Xml文件解析
 */
public class XmlParseUtils {

    /** Log */
    private static Logger log = Logger.getLogger(PropertyFileUtils.class
            .getName());

    /** 消息配置文件 */
    private static final String MSG_SETTING_FILE = "/resources/MsgSetting.xml";

    /**
     * 页面ID取得消息
     *
     * @param String
     *            pageId
     * @return HashMap 消息Map
     */
    public HashMap<String, String> getMsgByPageId(String pageId) {
        HashMap<String, String> msgMap = new HashMap<String, String>();

        try {

            //
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory
                    .newInstance();
            //
            DocumentBuilder builder = dbfactory.newDocumentBuilder();
            //
            Document doc = builder.parse(this.getClass().getResourceAsStream(
                    MSG_SETTING_FILE));
            //
            Element root = doc.getDocumentElement();
            //
            NodeList nodeListPage = root.getElementsByTagName("page");

            // 循环查找page标签
            for (int i = 0; i < nodeListPage.getLength(); i++) {
                Element elementPage = (Element) nodeListPage.item(i);
                String tmpPageId = elementPage.getAttribute("pageId");

                // 找到指定pageId的情况
                if (pageId.equals(tmpPageId)) {
                    NodeList nodeListMsg = elementPage
                            .getElementsByTagName("msg");

                    // 循环查找msg标签
                    for (int j = 0; j < nodeListMsg.getLength(); j++) {
                        Element elementMsg = (Element) nodeListMsg.item(j);
                        String id = elementMsg.getAttribute("id");
                        String value = elementMsg.getAttribute("value");

                        msgMap.put(id, value);
                    }
                }
            }

        } catch (Exception e) {
            log.error(e);
        }

        return msgMap;
    }
}