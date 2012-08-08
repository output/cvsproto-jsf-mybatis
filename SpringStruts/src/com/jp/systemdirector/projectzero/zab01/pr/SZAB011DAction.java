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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.EventDispatchAction;

/**
 * 画面 com.jp.systemdirector.projectzero.zab01.pr.SZAB011DAction に対するアクションクラス。
 * 画面からのイベントアクションに対する処理を実装するためのクラスです。
 */
public class SZAB011DAction extends EventDispatchAction {
	
	static Logger log = Logger.getLogger(SZAB011DAction.class.getName());

	@Override
	protected ActionForward unspecified(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		log.info("unspecified start");
		
		ActionForward forward = null;

		 SZAB011DForm prevForm = (SZAB011DForm) form;

		 prevForm.setMessage("処理結果を確認し、次へ進んでください。");
		forward = map.findForward("unspecified");
		log.info("unspecified end");
		return forward;
	}

	/**
	 * 「入庫情報一括登録画面」(SZAB0111)へ遷移する。
	 * @param map マッピングオブジェクト。
	 * @param form フォームオブジェクト。
	 * @param request リクエストオブジェクト。
	 * @param response レスポンスオブジェクト。
	 * @return 実行結果
	 * @throws Exception エラーが発生した場合。
	 */
	public ActionForward updCompOk(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		log.info("updCompOk start");
		
		ActionForward forward = null;
		
		forward = map.findForward("UpdCompOk");
		log.info("updCompOk end");
		return forward;
	}

}