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

import org.springframework.transaction.annotation.Transactional;

import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CInsertResultData;
import com.jp.systemdirector.projectzero.zab01.db.dao.ISZAB011CInsertDAO;
import com.jp.systemdirector.projectzero.zab01.db.dao.SZAB011CInsertDTO;
import com.jp.systemdirector.projectzero.zab01.ap.logicbean.ISZAB011CInsertLogicBean;
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB011CInsertInputData;
import com.jp.systemdirector.projectzero.zab01.ap.data.ContextData;

public class SZAB011CInsertLogicBean implements ISZAB011CInsertLogicBean {

private ISZAB011CInsertDAO dao; 	
	
	public ISZAB011CInsertDAO getDao() {
		return dao;
	}

	public void setDao(ISZAB011CInsertDAO dao) {
		this.dao = dao;
	}

	@Transactional
	public SZAB011CInsertResultData execute(
		ContextData context,
		SZAB011CInsertInputData inputData){
		
		SZAB011CInsertResultData resultData = new SZAB011CInsertResultData();
		
		SZAB011CInsertDTO zInsertDTO = new SZAB011CInsertDTO();
		
        //DTOへinputDataを移送        
        zInsertDTO.setSTORING_ID(context.getStoringId());
        zInsertDTO.setPRODUCT_CD(context.getProductCd());
        zInsertDTO.setSTORINGQUANTITY(Integer.parseInt(context.getStoringQuantity()));
        zInsertDTO.setSTORING_DATE(context.getStoringDate());
        zInsertDTO.setSTORINGUSER_ID(context.getStoringUserCd());
        zInsertDTO.setREMARKS(context.getRemarks());
		
        try {
            int result = dao.insert(zInsertDTO);
            
            resultData.setAffectLines(result);
        } catch (SQLException e) {
            
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
        return resultData;		
	}
}

