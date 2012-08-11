/*
 * THIS PROGRAM IS GENERATED UNDER LICENSE FROM NEC CORPORATION.
 * 
 * 
 * $Date: 2011/12/19$
 * $Revision: 1.1$
 * $Author: hnnc$
 *
 */

package com.jp.systemdirector.projectzero.zab01.pr;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.DateValidator;
import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.EventDispatchAction;

import com.jp.systemdirector.projectzero.zab01.ap.data.ContextData;
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB0111SelectResultData;
import com.jp.systemdirector.projectzero.zab01.ap.logicbean.ISZAB0111SelectLogicBean;
import com.nec.jp.sdeparts.util.csv.CSVReader;

/**
 * 画面 com.jp.systemdirector.projectzero.zab01.pr.SZAB0111Action に対するアクションクラス。
 * 画面からのイベントアクションに対する処理を実装するためのクラスです。
 */
public class SZAB0111Action extends EventDispatchAction {

    /** CSV ファイルの「入庫数量」の最大値 */
    private static final int MAX_STORING_QUANTITY = 99999;

    /** レコード件数が上限 */
    private static final int MAX_ROW = 1000;

    /** 半角文字以外の正規表現 */
    private static final String MATCH_FULLSIZE = "^[ ]*[^ -~｡-ﾟ]*[ ]*$";

    /** アルファベット＋数字 */
    private static final String MATCH_ALPNUM = "^[a-zA-Z0-9]*$";

    /** 数字 */
    private static final String MATCH_NUM = "^[0-9]*$";

    /** 商品コード */
    private static final String MATCH_PRODUCT_CD = "^[0-9]{3}[-][0-9]{6}$";

    static Logger log = Logger.getLogger(SZAB0111Action.class.getName());

    // @Resource(name = "SZAB0111Select")
    private ISZAB0111SelectLogicBean bean_select;

    public ISZAB0111SelectLogicBean getBean_select() {
        return bean_select;
    }

    public void setBean_select(ISZAB0111SelectLogicBean beanSelect) {
        bean_select = beanSelect;
    }

    @Override
    protected ActionForward unspecified(ActionMapping map, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        log.info("unspecified start");

        ActionForward forward = null;

        forward = map.findForward("unspecified");
        log.info("unspecified end");
        return forward;
    }

    /**
     * 選択されている画面上のCSVファイル名をクリアする。
     * 
     * @param map
     *            マッピングオブジェクト。
     * @param form
     *            フォームオブジェクト。
     * @param request
     *            リクエストオブジェクト。
     * @param response
     *            レスポンスオブジェクト。
     * @return 実行結果
     * @throws Exception
     *             エラーが発生した場合。
     */
    public ActionForward clear(ActionMapping map, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        log.info("clear start");

        ActionForward forward = null;

        forward = map.findForward("Clear");
        log.info("clear end");
        return forward;
    }

    /**
     * 入力チェックを行い、「入庫情報一括登録確認画面」(SZAB011C)へ遷移する。
     * 
     * @param map
     *            マッピングオブジェクト。
     * @param form
     *            フォームオブジェクト。
     * @param request
     *            リクエストオブジェクト。
     * @param response
     *            レスポンスオブジェクト。
     * @return 実行結果
     * @throws Exception
     *             エラーが発生した場合。
     */
    public ActionForward toUpdate(org.apache.struts.action.ActionMapping map,
            org.apache.struts.action.ActionForm form,
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response) throws Exception {
        log.info("toUpdate start");

        ActionForward forward = null;
        ActionMessages errors = new ActionMessages();

        SZAB0111Form prevForm = (SZAB0111Form) form;
        SZAB011CForm nextForm = new SZAB011CForm();

        BigDecimal quantity = new BigDecimal(0); // 商品在庫マスタの在庫数
        String storingQuantity = ""; // 入庫数量
        BigDecimal newQuantity = new BigDecimal(0); // 入庫後数量
        String storingDate = ""; // 入庫日
        String productCd = ""; // 商品コード
        String storingUserCd = ""; // 入庫担当者ID
        String remarks = ""; // 備考
        BigDecimal modifyCount = new BigDecimal(0); // 更新回数
        String updatedDate = ""; // 更新日

        ContextData context = new ContextData();
        List<SZAB011CStockInfoRegConfirmBean> sConfirmBeansList = new ArrayList<SZAB011CStockInfoRegConfirmBean>();
        SZAB011CStockInfoRegConfirmBean sConfirmBean;

        try {

            // DTOへデータを移送
            org.apache.commons.beanutils.PropertyUtils.copyProperties(context,
                    prevForm);

            // ①指定したファイルが不正かどうかをチェックする。

            org.apache.struts.upload.FormFile csvFile = context.getUpload();

            String fileName = csvFile.getFileName().substring(
                    csvFile.getFileName().lastIndexOf("\\") + 1);

            if (csvFile == null || fileName.contains("<")
                    || fileName.contains(">") || fileName.contains(":")
                    || fileName.contains("*") || fileName.contains("!")
                    || fileName.contains("\\") || fileName.contains("/")
                    || fileName.contains("|") || fileName.contains("\"")) {
                // 不正な文字が含まれていますをチェックする。

                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "errors.character", fileName));
                request.setAttribute(Globals.ERROR_KEY, errors);

                forward = map.findForward("Clear");
                log.info("toUpdate end");
                return forward;
            } else if (csvFile.getFileData().length <= 0) {
                // 指定したファイルが０バイトだった場合/指定したファイルが存在しなかった場合

                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "MZZZ110E"));
                request.setAttribute(Globals.ERROR_KEY, errors);

                forward = map.findForward("Clear");
                log.info("toUpdate end");
                return forward;
            } else if (!csvFile.getFileName().toLowerCase().endsWith(".csv")) {
                // 指定したファイルの拡張子がcsvでは場合（拡張子は、大文字小文字ともに有効）

                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "MZZZ110E"));
                request.setAttribute(Globals.ERROR_KEY, errors);

                forward = map.findForward("Clear");
                log.info("toUpdate end");
                return forward;
            }

            // ②レコード件数の上限チェックする。

            // CSV部品を利用、CSVデータをLISTにセット
            InputStream iStream = csvFile.getInputStream();
            InputStreamReader isReader = new InputStreamReader(iStream);
            String[][] dataArray;
            CSVReader csvReader = new CSVReader();
            csvReader.setFile(isReader);
            dataArray = csvReader.readAsArray();

            if (dataArray.length > MAX_ROW) {

                // Ⅰ．エラーメッセージ｢MZZZ109E：アップロード対象データ件数が多すぎます。データの件数を分割してアップロードしてください。」を設定する。
                // Ⅱ．「入庫情報一括登録画面」(SZAB0111)へ遷移する。
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "MZZZ109E"));
                request.setAttribute(Globals.ERROR_KEY, errors);
                forward = map.findForward("Clear");

                log.info("toUpdate end");
                return forward;
            }

            // アップロードする対象データの存在をチェックする。
            int emptyLine = 0;
            StringBuffer sBuffer;

            for (int i = 0; i < dataArray.length; i++) {

                sBuffer = new StringBuffer();

                for (int j = 0; j < dataArray[i].length; j++) {

                    sBuffer.append(dataArray[i][j]);
                }

                if (sBuffer.toString().trim().equals("")) {
                    emptyLine++;
                }
            }

            if (emptyLine == dataArray.length) {

                // エラーメッセージ MZAB014E：指定されたファイルが不正です。」を設定する。
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "MZAB014E"));
                request.setAttribute(Globals.ERROR_KEY, errors);

                forward = map.findForward("Clear");
                log.info("toUpdate end");
                return forward;
            }

            // ③データの整合性をチェック。

            int lineNo = 0;
            boolean hasError = false;
            List<String> productCdList = new ArrayList<String>();

            for (int i = 0; i < dataArray.length; i++) {

                if (dataArray[i].length != 0) {

                    lineNo++;
                    String[] contents = dataArray[i];

                    if (contents.length == 5) {

                        storingDate = contents[0].trim();
                        productCd = contents[1].trim();
                        storingQuantity = contents[2].trim();
                        storingUserCd = contents[3].trim();
                        remarks = contents[4].trim();

                        // a.CSVの各項目データのフォーマットをチェックする。

                        // 入庫日が空の場合
                        if (storingDate.equals("")) {

                            hasError = true;
                            errors.add(ActionMessages.GLOBAL_MESSAGE,
                                    new ActionMessage("MZAB007E", lineNo));
                            continue;
                        } else {

                            // 入庫日のフォーマットのチェック
                            if (isDateFormateRight(storingDate) == false) {
                                hasError = true;
                                errors.add(ActionMessages.GLOBAL_MESSAGE,
                                        new ActionMessage("MZAB007E", lineNo));
                                continue;
                            }
                        }

                        // 商品コードが空の場合
                        if (productCd.equals("")) {

                            hasError = true;
                            errors.add(ActionMessages.GLOBAL_MESSAGE,
                                    new ActionMessage("MZAB008E", lineNo));
                            continue;
                        } else {

                            // 商品コードの文字数が10を超えていた場合
                            if (productCd.length() > 10) {
                                hasError = true;
                                errors.add(ActionMessages.GLOBAL_MESSAGE,
                                        new ActionMessage("MZAB008E", lineNo));
                                continue;
                            } else {

                                // 商品コードに英数字と記号“－”以外の文字があった場合
                                if (productCd.matches(MATCH_PRODUCT_CD) == false) {
                                    hasError = true;
                                    errors.add(ActionMessages.GLOBAL_MESSAGE,
                                            new ActionMessage("MZAB008E",
                                                    lineNo));
                                    continue;
                                }
                            }
                        }

                        // 入庫数量が空の場合
                        BigDecimal storingQuantityN = new BigDecimal(0);
                        if (storingQuantity.equals("")) {

                            hasError = true;
                            errors.add(ActionMessages.GLOBAL_MESSAGE,
                                    new ActionMessage("MZAB006E", lineNo));
                            continue;
                        } else {

                            // 入庫数量に数字以外の文字があった場合
                            if (storingQuantity.matches(MATCH_NUM) == true) {
                                storingQuantityN = new BigDecimal(
                                        storingQuantity);
                            } else {
                                hasError = true;
                                errors.add(ActionMessages.GLOBAL_MESSAGE,
                                        new ActionMessage("MZAB006E", lineNo));
                                continue;
                            }
                        }

                        // 入庫担当者IDが空の場合
                        if (storingUserCd.equals("")) {
                            hasError = true;
                            errors.add(ActionMessages.GLOBAL_MESSAGE,
                                    new ActionMessage("MZAB009E", lineNo));
                            continue;
                        } else {

                            // 入庫担当者IDの文字数が20を超えていた場合
                            if (storingUserCd.length() > 20) {
                                hasError = true;
                                errors.add(ActionMessages.GLOBAL_MESSAGE,
                                        new ActionMessage("MZAB009E", lineNo));
                                continue;
                            } else {

                                // 入庫担当者IDに半角英数以外の文字があった場合
                                if (storingUserCd.matches(MATCH_ALPNUM) == false) {
                                    hasError = true;
                                    errors.add(ActionMessages.GLOBAL_MESSAGE,
                                            new ActionMessage("MZAB009E",
                                                    lineNo));
                                    continue;
                                }
                            }
                        }

                        // 備考の文字数が30を超えた場合
                        if (remarks.length() > 30) {
                            hasError = true;
                            errors.add(ActionMessages.GLOBAL_MESSAGE,
                                    new ActionMessage("MZAB010E", lineNo));
                            continue;
                        } else if (remarks.matches(MATCH_FULLSIZE) == false) {
                            // 備考に全角以外の文字があった場合

                            hasError = true;
                            errors.add(ActionMessages.GLOBAL_MESSAGE,
                                    new ActionMessage("MZAB010E", lineNo));
                            continue;
                        }

                        // b.商品コードが商品在庫マスタに存在するかをチェック。
                        SZAB0111SelectResultData rSelectResultData = new SZAB0111SelectResultData();
                        context.setProductCd(productCd);

                        rSelectResultData = bean_select.getUserById(context,
                                null);

                        if (rSelectResultData != null) {

                            if (rSelectResultData.getResultList().size() <= 0) {

                                // エラーメッセージ｢MZAB002E：{0}行目の商品コード '{1}'
                                // はマスタ上に存在しません。」を設定する。
                                hasError = true;
                                errors.add(ActionMessages.GLOBAL_MESSAGE,
                                        new ActionMessage("MZAB002E", lineNo,
                                                productCd));
                                continue;
                            } else {
                                modifyCount = rSelectResultData.getResultList()
                                        .get(0).getModifyCount();

                                updatedDate = rSelectResultData.getResultList()
                                        .get(0).getUpdatedDate();

                                quantity = new BigDecimal(rSelectResultData
                                        .getResultList().get(0).getQuantity());

                                newQuantity = quantity.add(storingQuantityN);

                                // 入庫後数量の範囲チェック
                                if (newQuantity.intValue() > MAX_STORING_QUANTITY) {

                                    // エラーメッセージ｢MZAB005E：ＣＳＶデータ{0}行目の入庫数が登録できる範囲外の値です。
                                    // 入庫後数量が0～99999になるようにしてください。現在の在庫数は{1}です。」を設定する。
                                    hasError = true;
                                    errors.add(ActionMessages.GLOBAL_MESSAGE,
                                            new ActionMessage("MZAB005E",
                                                    lineNo, quantity));
                                    continue;
                                }
                            }
                        }

                        // ⑤アップロードする対象データの存在をチェックする。
                        if (productCdList.contains(productCd)) {
                            hasError = true;
                            errors.add(ActionMessages.GLOBAL_MESSAGE,
                                    new ActionMessage("MZAB011E", lineNo));
                            continue;
                        } else {
                            productCdList.add(productCd);
                        }

                        // a.在庫数、入庫数量、入庫日を画面表示用のフォーマットに変換する。
                        sConfirmBean = new SZAB011CStockInfoRegConfirmBean();

                        sConfirmBean.setStoringDate(toDate(storingDate));
                        sConfirmBean.setProductCd(productCd);
                        sConfirmBean.setQuantity(newQuantity);
                        sConfirmBean.setStoringQuantity(storingQuantityN);
                        sConfirmBean.setStoringUserCd(storingUserCd);
                        sConfirmBean.setRemarks(remarks);
                        sConfirmBean.setModifyCount(modifyCount);
                        sConfirmBean.setUpdatedDate(updatedDate);

                        sConfirmBeansList.add(sConfirmBean);
                    } else if (contents.length == 1
                            && contents[0].trim().equals("")) {

                        // 空行は読み飛ばす。
                        continue;
                    } else {
                        hasError = true;
                        errors.add(ActionMessages.GLOBAL_MESSAGE,
                                new ActionMessage("MZAB012E", lineNo));
                        continue;
                    }
                }
            }

            nextForm.setStockInfoRegConfirm(sConfirmBeansList);

            // 読み込んだデータのリストをセッションにセット
            request.setAttribute(
                    com.jp.systemdirector.projectzero.zab01.pr.SZAB011CForm.FORM_ID,
                    nextForm);

            // 読み込んだデータのリストをセッションにセット
            HttpSession session = request.getSession();

            session.setAttribute(SZAB011CForm.FORM_ID, nextForm);

            // ⑥遷移先を設定
            if (hasError == false) {

                // エラーが存在しなかった場合
                request.setAttribute(Globals.ERROR_KEY, errors);
                forward = map.findForward("ToUpdate");
            } else {

                // エラーが存在した場合
                request.setAttribute(Globals.ERROR_KEY, errors);
                forward = map.findForward("Clear");
            }

            log.info("toUpdate end");
            return forward;

        } catch (IOException ex) {
            log.error(ex);

            // Ⅰ．エラーメッセージ｢MZAB014E：指定されたファイルが不正です。」を設定する。
            // Ⅱ．「入庫情報一括登録画面」(SZAB0111)へ遷移する。
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "MZAB014E"));
            request.setAttribute(Globals.ERROR_KEY, errors);

            forward = map.findForward("Clear");

            log.info("toUpdate end");
            return forward;

        } catch (Exception ex) {

            log.error(ex);
            ex.printStackTrace();
            throw ex;
        }
    }

    public ActionForward login(org.apache.struts.action.ActionMapping map,
            org.apache.struts.action.ActionForm form,
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response) throws Exception {
        log.info("login start");

        ActionForward forward = null;
        ActionMessages errors = new ActionMessages();

        ContextData context = new ContextData();

        SZAB0111Form prevForm = (SZAB0111Form) form;

        context.setUsername(prevForm.getUsername());
        context.setPassword(prevForm.getPassword());

        log.debug("checkUser:\n" + "username: " + prevForm.getUsername() + "\n"
                + "password: " + prevForm.getPassword());

        log.debug("checkUser:\n" + "username: "
                + new String(prevForm.getUsername().getBytes(), "UTF-8") + "\n"
                + "password: " + prevForm.getPassword());

        // if (prevForm.getUsername().equals("wkl") &&
        // prevForm.getPassword().equals("wkl")) {
        // forward = map.findForward("right");
        // }else {
        // forward = map.findForward("error");
        // }

        if (bean_select.checkUserInfo(context, null)) {
            forward = map.findForward("right");
        } else {
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "MZAB009E", 11));
            request.setAttribute(Globals.ERROR_KEY, errors);
            forward = map.findForward("error");
        }

        log.info("login end");

        return forward;
    }

    protected boolean isDateFormateRight(String date) {

        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd");
        sDateFormat.setLenient(false);
        if (DateValidator.getInstance().isValid(date, "yyyymmdd", true) == false) {
            return false;
        } else {
            try {
                sDateFormat.parse(date);
            } catch (ParseException ex) {

                log.error(ex);
                return false;
            }
        }

        return true;
    }

    private String toDate(String str) {
        String dateString;
        dateString = str.substring(0, 4) + "/";
        dateString = dateString + str.substring(4, 6) + "/";
        dateString = dateString + str.substring(6, 8);
        return dateString;
    }
}