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

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.EventDispatchAction;

import com.jp.systemdirector.projectzero.zab01.ap.data.ContextData;
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CSelectResultData;
import com.jp.systemdirector.projectzero.zab01.ap.logicbean.ISZAB011CInsertLogicBean;
import com.jp.systemdirector.projectzero.zab01.ap.logicbean.ISZAB011CSelectLogicBean;
import com.jp.systemdirector.projectzero.zab01.ap.logicbean.ISZAB011CUpdateLogicBean;
import com.jp.systemdirector.projectzero.zab01.db.dao.ConnectionUtil;
import com.jp.systemdirector.projectzero.zab01.db.dao.ConnectionUtilFactory;
import com.jp.systemdirector.projectzero.zab01.pr.SZAB011CForm;
import com.jp.systemdirector.projectzero.zab01.pr.SZAB011CStockInfoRegConfirmBean;
import com.jp.systemdirector.projectzero.zab01.pr.SZAB011DForm;
import com.jp.systemdirector.projectzero.zab01.pr.SZAB011DStockInfoRegResultBean;

/**
 * 画面 com.jp.systemdirector.projectzero.zab01.pr.SZAB011CAction に対するアクションクラス。
 * 画面からのイベントアクションに対する処理を実装するためのクラスです。
 */
public class SZAB011CAction extends EventDispatchAction {
	
	/** エラータイプ */   
    private static final String SUC = "0";
    private static final String QUANTITY_ERR = "2";
    private static final String EXIST_ERR = "3";
    private static final String SYS_ERR = "4";
    
    /** 一覧の背景のスタイル */
    private static final String ROW_ODD = "row-odd";
    private static final String ROW_EVEN = "row-even";
    private static final String ROW_ERR = "error";
    
    /** 結果 */
    private static final String RST_SUC = "　○　　";
    private static final String RST_QUANTITY_ERR = "　× *1";
    private static final String RST_EXIST_ERR = "　× *2";
    private static final String RST_SYS_ERR = "　× *3";
    
    static Logger log = Logger.getLogger(SZAB011CAction.class.getName());

    @Resource(name = "SZAB011CInsert")
	private ISZAB011CInsertLogicBean bean_insert;

    @Resource(name = "SZAB011CSelect")
	private ISZAB011CSelectLogicBean bean_select;

    @Resource(name = "SZAB011CUpdate")
	private ISZAB011CUpdateLogicBean bean_update;

	public ISZAB011CInsertLogicBean getBean_insert() {
		return bean_insert;
	}

	public void setBean_insert(ISZAB011CInsertLogicBean beanInsert) {
		bean_insert = beanInsert;
	}

	public ISZAB011CSelectLogicBean getBean_select() {
		return bean_select;
	}

	public void setBean_select(ISZAB011CSelectLogicBean beanSelect) {
		bean_select = beanSelect;
	}

	public ISZAB011CUpdateLogicBean getBean_update() {
		return bean_update;
	}

	public void setBean_update(ISZAB011CUpdateLogicBean beanUpdate) {
		bean_update = beanUpdate;
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
	 * 「入庫情報一括登録画面」(SZAB0111)へ遷移する。
	 * @param map マッピングオブジェクト。
	 * @param form フォームオブジェクト。
	 * @param request リクエストオブジェクト。
	 * @param response レスポンスオブジェクト。
	 * @return 実行結果
	 * @throws Exception エラーが発生した場合。
	 */
	public ActionForward updInpBack(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("updInpBack start");
		
		ActionForward forward = null;

		forward = map.findForward("UpdInpBack");
		log.info("updInpBack end");
		return forward;
	}

	/**
	 * 入庫後の在庫数をチェックし、入庫情報をDBへ登録を行い、「入庫情報一括登録完了画面」（SZAB011D）へと遷移する。
	 * @param map マッピングオブジェクト。
	 * @param form フォームオブジェクト。
	 * @param request リクエストオブジェクト。
	 * @param response レスポンスオブジェクト。
	 * @return 実行結果
	 * @throws Exception エラーが発生した場合。
	 */
	public ActionForward updInpOk(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("updInpOk start");
		
		ActionForward forward = null;
		ActionMessages errors = new ActionMessages();

		// ①アップロードされた在庫商品情報リストを取得する。

		SZAB011CForm prevForm = (SZAB011CForm) form;
		SZAB011DForm nextForm = new SZAB011DForm();

		List<SZAB011DStockInfoRegResultBean> storingList = new ArrayList<SZAB011DStockInfoRegResultBean>();
		
		try {
			
			// ②「在庫数」の更新、入庫履歴の登録を行う。

			if (prevForm == null || prevForm.getStockInfoRegConfirm() == null) {
				
				forward = map.findForward("UpdInpBack");
				log.info("updInpOk end");
				return forward;
			}

			int line = 0;
			int errline = 0;
			String rtn = "";
			String cssClass = "";
			
			List<SZAB011DStockInfoRegResultBean> sRegConfirmBeanList = inventoryControl(prevForm.getStockInfoRegConfirm());
			
			for (SZAB011DStockInfoRegResultBean regConfirmBean : sRegConfirmBeanList) {

				if(regConfirmBean.getRnt().equals(SUC)){
					
					rtn = RST_SUC;
					if(line%2==0){
						cssClass =ROW_ODD;
					}else {
						cssClass = ROW_EVEN;
					}
				}else if (regConfirmBean.getRnt().equals(QUANTITY_ERR)) {
					
					errline++;
					rtn = RST_QUANTITY_ERR;
					cssClass = ROW_ERR;
				}else if (regConfirmBean.getRnt().equals(EXIST_ERR)) {
					
					errline++;
					rtn = RST_EXIST_ERR;
					cssClass = ROW_ERR;
				}else if (regConfirmBean.getRnt().equals(SYS_ERR)) {
					
					errline++;
					rtn = RST_SYS_ERR;
					cssClass = ROW_ERR;
				}
				
				// h.返却結果を作成し、入庫情報リストにセットする。
				regConfirmBean.setRnt(rtn);
				regConfirmBean.setCssClass(cssClass);

				storingList.add(regConfirmBean);
				
				line++;
			}
			
			// ③登録処理の結果を表示

			// 登録処理の結果を「入庫情報一括登録結果画面」(SZAB011D)の一覧にセットする。
			// エラーメッセージ初期化
			if(errline > 0){
				
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("MZAB013E",errline));
		        request.setAttribute(Globals.ERROR_KEY, errors);
			}		
			
			nextForm.setStockInfoRegResult(storingList);

			request.setAttribute(SZAB011DForm.FORM_ID, nextForm);

			// ④「入庫情報一括登録結果画面」(SZAB011D)へ遷移する。
			forward = map.findForward("UpdInpOk");
			log.info("updInpOk end");
			return forward;
			
		} catch (Exception ex) {	
			log.error(ex);
			
			ex.printStackTrace(); 
			throw ex;
		}
	}

	private List<SZAB011DStockInfoRegResultBean> inventoryControl(
			List<SZAB011CStockInfoRegConfirmBean> regConfirmList)
			throws Exception {

		List<SZAB011DStockInfoRegResultBean> storingList = new ArrayList<SZAB011DStockInfoRegResultBean>();
		ContextData context = new ContextData();

		BigDecimal modifyCount = new BigDecimal(0);	// 更新回数
		String updatedDate = ""; 					// 更新日

		PreparedStatement stmtIns = null; // Insert用
		PreparedStatement stmtUpd = null; // Update用
		ConnectionUtil util = null;
		Connection conn = null;
		ResultSet rs = null;
		boolean autocommit = true;
		boolean hasNotDbError = true;

		String SQL_INSERT = "INSERT INTO "
				+ "  TZAA004T(STORING_ID, PRODUCT_CD, STORINGQUANTITY, STORING_DATE, STORINGUSER_ID, REMARKS, CREATED_DATE, CREATED_BY, CREATED_PRG_NM, UPDATED_DATE, UPDATED_BY, UPDATED_PRG_NM, MODIFY_COUNT ) "
				+ "VALUES "
				+ "  (?, ?, ?, ?, ?, ?, sysdate, 'hnnc', 'SZAB011C', sysdate, 'hnnc', 'SZAB011C', 0)";

		String SQL_UPDATE = "UPDATE " + "  TZAA001M " + "SET "
				+ "  TZAA001M.\"QUANTITY\" = ? ,"
				+ "  TZAA001M.\"UPDATED_DATE\"    = sysdate,"
				+ "  TZAA001M.\"UPDATED_BY\"      = 'hnnc',"
				+ "  TZAA001M.\"UPDATED_PRG_NM\"  = 'SZAB011C',"
				+ "  TZAA001M.\"MODIFY_COUNT\"    = TZAA001M.MODIFY_COUNT + 1"
				+ "WHERE " + "  TZAA001M.\"PRODUCT_CD\" = ?";

		try {

			String storingId = ""; // 入庫履歴番号

			ConnectionUtilFactory factory = ConnectionUtilFactory.getInstance();
			util = factory.create(this.getClass());
			if (util == null) {
				return null;
			} else {
				conn = util.getConnection();
				if (conn == null) {
					return null;
				}
			}

			autocommit = conn.getAutoCommit();
			conn.setAutoCommit(false);

			for (SZAB011CStockInfoRegConfirmBean regConfirmBean : regConfirmList) {

				BigDecimal newQuantity = new BigDecimal(0); // 入庫後数量

				context.setStoringDate(regConfirmBean.getStoringDate());
				context.setProductCd(regConfirmBean.getProductCd());
				context.setStoringQuantity(regConfirmBean.getStoringQuantity().toString());
				context.setStoringUserCd(regConfirmBean.getStoringUserCd());
				context.setRemarks(regConfirmBean.getRemarks());
				context.setNewQuantity(newQuantity.toString());
				modifyCount = regConfirmBean.getModifyCount();
				updatedDate = regConfirmBean.getUpdatedDate();

				SZAB011DStockInfoRegResultBean sResultBean = new SZAB011DStockInfoRegResultBean();

				sResultBean.setRnt(SUC);
				storingList.add(sResultBean);

				// a.商品在庫マスタから在庫数、更新日、更新回数を取得。
				try {

					SZAB011CSelectResultData selectResultData = bean_select
							.execute(context, null);

					if (selectResultData == null
							|| (selectResultData != null && selectResultData
									.getResultList().size() <= 0)) {

						// エラー：「商品コードは商品在庫マスタに存在しない」をセットし、次のデータの処理へ。
						sResultBean.setRnt(EXIST_ERR);
						setResultBean(sResultBean, context);
						hasNotDbError = false;

						continue;
					} else {

						ContextData sResultDataElement = selectResultData
								.getResultList().get(0);
						
						//　排他チェツク
						if(modifyCount.intValue() != sResultDataElement.getModifyCount().intValue()
								|| (!updatedDate.equals(sResultDataElement.getUpdatedDate()))){
							
							sResultBean.setRnt(SYS_ERR);
							setResultBean(sResultBean, context);
							hasNotDbError = false;

							continue;
						}

						// b.商品在庫マスタから取得した「在庫数」と入庫数量を足す。結果を入庫後数量にセットする。
						newQuantity = new BigDecimal(sResultDataElement.getQuantity())
													.add(regConfirmBean.getStoringQuantity());

						context.setNewQuantity(newQuantity.toString());

						// c.入庫後数量の範囲チェック。
						if (newQuantity.compareTo(new BigDecimal(99999)) == 1) {

							// エラー：「入庫後数量が99999を超える」をセットし、次のデータの処理へ。
							sResultBean.setRnt(QUANTITY_ERR);
							setResultBean(sResultBean, context);
							hasNotDbError = false;

							continue;
						} else if (newQuantity.compareTo(new BigDecimal(0)) == -1) {

							// エラー：「入庫後数量がマイナス」をセットし、次のデータの処理へ。
							sResultBean.setRnt(QUANTITY_ERR);
							setResultBean(sResultBean, context);
							hasNotDbError = false;

							continue;
						} else {

							// d.商品在庫マスタの在庫数を更新。
							stmtUpd = conn.prepareStatement(SQL_UPDATE);

							stmtUpd.setBigDecimal(1, newQuantity);
							stmtUpd.setString(2, regConfirmBean.getProductCd());

							if(stmtUpd.executeUpdate() <= 0){
								sResultBean.setRnt(SYS_ERR);
								setResultBean(sResultBean, context);
								hasNotDbError = false;
							}
						}
					}
				} catch (Exception ex) {
					log.error(ex);

					sResultBean.setRnt(SYS_ERR);
					setResultBean(sResultBean, context);
					hasNotDbError = false;
				}

				// e.入庫履歴番号を取得。
				try{
					SZAB011CSelectResultData storingIdResultData = bean_select
							.getStoringId(context, null);
		
					if (storingIdResultData != null
							&& storingIdResultData.getResultList().size() > 0) {
		
						for (ContextData contextData : storingIdResultData
								.getResultList()) {
		
							storingId = contextData.getStoringId();
		
							if (storingId != null) {
		
								// f.入庫担当者IDが指定されていない場合、LOGINユーザIDを入庫担当者IDに設定する。
								if (context.getStoringUserCd() == null
										|| "".equals(context.getStoringUserCd())) {
		
									context.setStoringUserCd("hnnc");
								}
		
							} else {
								log.error("入庫履歴番号の取得に失敗しました。");
								
								// logに「入庫履歴番号の取得に失敗しました。」を出力して、システムエラー画面に遷移する。（以後のデータの処理は行わない）
								throw new Exception("入庫履歴番号の取得に失敗しました。");
							}
						}
					}
				}catch (Exception ex) {
					log.error(ex);
					
					// logに「入庫履歴番号の取得に失敗しました。」を出力して、システムエラー画面に遷移する。（以後のデータの処理は行わない）
					throw new Exception("入庫履歴番号の取得に失敗しました。");
				}

				// g.入庫履歴テーブルに対して、「入庫履歴番号」、「商品コード」、「入庫数量」、「入庫日」、「入庫担当者ID」、「備考」を登録。
				context.setStoringId(storingId);

				String originalDate = "";
				if (regConfirmBean.getStoringDate() != null
						&& regConfirmBean.getStoringDate() != "") {

					originalDate = regConfirmBean.getStoringDate();

					String strDate = regConfirmBean.getStoringDate();
					String dateSplit[] = strDate.split("/");
					String storingDate = "";

					for (int i = 0; i < dateSplit.length; i++) {
						storingDate = storingDate + dateSplit[i];
					}

					context.setStoringDate(storingDate);
				} else {

					context.setStoringDate(regConfirmBean.getStoringDate());
				}

				try {

					stmtIns = conn.prepareStatement(SQL_INSERT);

					stmtIns.setString(1, context.getStoringId());
					stmtIns.setString(2, context.getProductCd());
					stmtIns.setInt(3, Integer.parseInt(context.getStoringQuantity().trim()));
					stmtIns.setString(4, context.getStoringDate());
					stmtIns.setString(5, context.getStoringUserCd());
					stmtIns.setString(6, context.getRemarks());

					if (stmtIns.executeUpdate() <= 0) {
						sResultBean.setRnt(SYS_ERR);
						setResultBean(sResultBean, context);
						hasNotDbError = false;
					} else {
						sResultBean.setQuantity(new BigDecimal(context
								.getNewQuantity()));
					}

				} catch (SQLException ex) {
					log.error(ex);

					sResultBean.setRnt(SYS_ERR);
					setResultBean(sResultBean, context);
					hasNotDbError = false;
				}

				context.setStoringDate(originalDate);
				setResultBean(sResultBean, context);
			}

			if (hasNotDbError == true) {
				conn.commit();
			} else {
				conn.rollback();
			}

			return storingList;

		} catch (Exception ex) {

			if (conn != null) {
				try {
					conn.rollback();

				} catch (Exception ex1) {
					ex1.printStackTrace();
					log.error(ex1);
				}
			}
			ex.printStackTrace();
			log.error(ex);
			throw ex;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					log.error(ex);
				}
			}

			if (stmtIns != null) {
				try {
					stmtIns.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					log.error(ex);
				}
			}

			if (conn != null) {
				conn.setAutoCommit(autocommit);
			}

			if (util != null) {
				try {
					util.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					log.error(ex);
				}
			}
		}
	}

	private void setResultBean(SZAB011DStockInfoRegResultBean resultBean,
			ContextData context) {
		resultBean.setProductCd(context.getProductCd());
		resultBean.setRemarks(context.getRemarks());
		resultBean.setStoringDate(context.getStoringDate());
		resultBean.setStoringQuantity(new BigDecimal(context.getStoringQuantity()));
		resultBean.setStoringUserCd(context.getStoringUserCd());
		resultBean.setQuantity(new BigDecimal(context.getNewQuantity()));
	}
}