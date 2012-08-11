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

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jp.systemdirector.projectzero.zab01.ap.logicbean.ISZAB0111SelectLogicBean;

/**
 * 画面 com.jp.systemdirector.projectzero.zab01.pr.SZAB0111Action に対するアクションクラス。
 * 画面からのイベントアクションに対する処理を実装するためのクラスです。
 */
public class SZAB0111Action extends EventDispatchAction {

    static Logger log = Logger.getLogger(SZAB0111Action.class.getName());

    @Resource(name = "SZAB0111Select")
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

    public ActionForward login(org.apache.struts.action.ActionMapping map,
            org.apache.struts.action.ActionForm form,
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response) throws Exception {
        log.info("login start");

        ActionForward forward = null;
        ActionMessages errors = new ActionMessages();

        ContextData context = new ContextData();

        SZAB0111Form prevForm = (SZAB0111Form) form;

        context.setUpload(prevForm.getUpload());
        context.setUsername(prevForm.getUsername());
        context.setPassword(prevForm.getPassword());

        log.debug("checkUser:\n" + "username: " + prevForm.getUsername() + "\n"
                + "password: " + prevForm.getPassword());

        if (!bean_select.checkUserInfo(context, null)) {
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "MWKL002E"));
        }

        org.apache.struts.upload.FormFile imgFile = context.getUpload();
        String outputFileName = "c:\\" + imgFile.getFileName();

        if (new File(outputFileName).exists()) {
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "MWKL001E", imgFile.getFileName()));
        } else {
            InputStream is = imgFile.getInputStream();
            FileOutputStream fos = new FileOutputStream(outputFileName);

            byte tempByte[] = new byte[1024];
            while (is.read(tempByte) != -1) {
                fos.write(tempByte);
            }

            fos.close();
        }

        if (errors.size() > 0) {
            request.setAttribute(Globals.ERROR_KEY, errors);
            forward = map.findForward("error");
        } else {
            forward = map.findForward("right");
        }

        log.info("login end");

        return forward;
    }

    protected Date dateFormate(String date) {

        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddhhmiss");
        sDateFormat.setLenient(false);
        if (DateValidator.getInstance().isValid(date, "yyyyMMddhhmiss", true) == false) {
            return null;
        } else {
            try {
                return sDateFormat.parse(date);
            } catch (ParseException ex) {

                log.error(ex);
                return null;
            }
        }
    }

    private String toDate(String str) {
        String dateString;
        dateString = str.substring(0, 4) + "/";
        dateString = dateString + str.substring(4, 6) + "/";
        dateString = dateString + str.substring(6, 8);
        return dateString;
    }
}