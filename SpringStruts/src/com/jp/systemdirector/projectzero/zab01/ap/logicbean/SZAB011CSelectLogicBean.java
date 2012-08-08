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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jp.systemdirector.projectzero.zab01.ap.data.ContextData;
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CSelectInputData;
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CSelectResultData;
import com.jp.systemdirector.projectzero.zab01.db.dao.ISZAB011CSelectDAO;
import com.jp.systemdirector.projectzero.zab01.db.dao.SZAB011CSelectDTO;
import com.jp.systemdirector.projectzero.zab01.ap.logicbean.ISZAB011CSelectLogicBean;

public class SZAB011CSelectLogicBean implements ISZAB011CSelectLogicBean {

	private ISZAB011CSelectDAO dao;
	
	public ISZAB011CSelectDAO getDao() {
		return dao;
	}

	public void setDao(ISZAB011CSelectDAO dao) {
		this.dao = dao;
	}

	@Transactional
	public SZAB011CSelectResultData execute(
		ContextData context,
		SZAB011CSelectInputData inputData){

		// 検索結果を受け取るList
		List<SZAB011CSelectDTO> resultList = new ArrayList<SZAB011CSelectDTO>();

		if (context != null) {
			SZAB011CSelectDTO zDto = new SZAB011CSelectDTO();
			zDto.setIN1(context.getProductCd());

			// 　主キー検索
			try {
				resultList = dao.findById(zDto);
			} catch (SQLException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		// DTOからContextDataへ結果を移送しPR層へ返却する
		List<ContextData> contextDataList = new ArrayList<ContextData>();
		for (SZAB011CSelectDTO zSelectDTO : resultList) {
			if (zSelectDTO == null) {
				break;
			}

			ContextData contextData = new ContextData();

			try {
				contextData.setProductCd(zSelectDTO.getIN1());
				contextData.setQuantity(zSelectDTO.getQUANTITY().toString());
				contextData.setModifyCount(zSelectDTO.getMODIFY_COUNT());
				contextData.setUpdatedDate(zSelectDTO.getUPDATED_DATE());

				contextDataList.add(contextData);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		// 結果ListをMemberResultDataのmemberListに格納
		SZAB011CSelectResultData resultData = new SZAB011CSelectResultData();
		resultData.setResultList(contextDataList);

		return resultData;
	}
	
	public SZAB011CSelectResultData getStoringId(
			ContextData context,
			SZAB011CSelectInputData inputData){

			// 検索結果を受け取るList
			List<SZAB011CSelectDTO> resultList = new ArrayList<SZAB011CSelectDTO>();

			if (context != null) {
				SZAB011CSelectDTO zDto = new SZAB011CSelectDTO();
				
				// 　主キー検索
				try {
					resultList = dao.selectStoringId(zDto);
				} catch (SQLException e) {

					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}

			// DTOからContextDataへ結果を移送しPR層へ返却する
			List<ContextData> contextDataList = new ArrayList<ContextData>();
			for (SZAB011CSelectDTO zSelectDTO : resultList) {
				if (zSelectDTO == null) {
					break;
				}

				ContextData contextData = new ContextData();

				try {
					contextData.setStoringId(zSelectDTO.getSTORING_ID());

					contextDataList.add(contextData);
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}

			// 結果ListをMemberResultDataのmemberListに格納
			SZAB011CSelectResultData resultData = new SZAB011CSelectResultData();
			resultData.setResultList(contextDataList);

			return resultData;
		}
}

