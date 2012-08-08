/*
 * THIS PROGRAM IS GENERATED UNDER LICENSE FROM NEC CORPORATION.
 * 
 * 
 * $Date: 2011/12/19$
 * $Revision: 1.1$
 * $Author: hnnc$
 *
 */

package com.jp.systemdirector.projectzero.zab01.ap.logicbean;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.transaction.annotation.Transactional;

import com.jp.systemdirector.projectzero.zab01.ap.data.ContextData;
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CUpdateInputData;
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CUpdateResultData;
import com.jp.systemdirector.projectzero.zab01.db.dao.ISZAB011CUpdateDAO;
import com.jp.systemdirector.projectzero.zab01.db.dao.SZAB011CUpdateDTO;
import com.jp.systemdirector.projectzero.zab01.ap.logicbean.ISZAB011CUpdateLogicBean;

public class SZAB011CUpdateLogicBean implements ISZAB011CUpdateLogicBean {

	private ISZAB011CUpdateDAO dao;

	public ISZAB011CUpdateDAO getDao() {
		return dao;
	}

	public void setDao(ISZAB011CUpdateDAO dao) {
		this.dao = dao;
	}

	@Transactional
	public SZAB011CUpdateResultData execute(ContextData context,
			SZAB011CUpdateInputData inputData) {

		SZAB011CUpdateResultData resultData = new SZAB011CUpdateResultData();

		SZAB011CUpdateDTO zUpdateDTO = new SZAB011CUpdateDTO();

		// DTOへinputDataを移送
		zUpdateDTO.setIN1(context.getProductCd());
		zUpdateDTO.setQUANTITY(new BigDecimal(context.getQuantity()));

		try {
			int result = dao.update(zUpdateDTO);

			resultData.setAffectLines(result);
		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return resultData;
	}
}

