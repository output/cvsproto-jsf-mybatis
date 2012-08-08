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
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB0111SelectInputData;
import com.jp.systemdirector.projectzero.zab01.ap.data.SZAB0111SelectResultData;
import com.jp.systemdirector.projectzero.zab01.db.dao.ISZAB0111SelectDAO;
import com.jp.systemdirector.projectzero.zab01.db.dao.SZAB0111SelectDTO;
import com.jp.systemdirector.projectzero.zab01.ap.logicbean.ISZAB0111SelectLogicBean;

public class SZAB0111SelectLogicBean implements ISZAB0111SelectLogicBean{
	
	
	private ISZAB0111SelectDAO dao;

	public ISZAB0111SelectDAO getDao() {
		return dao;
	}

	public void setDao(ISZAB0111SelectDAO dao) {
		this.dao = dao;
	}

	@Transactional
	public SZAB0111SelectResultData getUserById(
			ContextData context,
			SZAB0111SelectInputData inputData) {

		// 検索結果を受け取るList
		List<SZAB0111SelectDTO> resultList = new ArrayList<SZAB0111SelectDTO>();

		if (context != null) {
			SZAB0111SelectDTO zDto = new SZAB0111SelectDTO();
			zDto.setUserid(context.getUserid());

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
		for (SZAB0111SelectDTO zSelectDTO : resultList) {
			if (zSelectDTO == null) {
				break;
			}

			ContextData contextData = new ContextData();

			try {				
				contextData.setUserid(zSelectDTO.getUserid());
				contextData.setUsername(zSelectDTO.getUsername());
				contextData.setPassword(zSelectDTO.getPassword());

				contextDataList.add(contextData);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		// 結果ListをMemberResultDataのmemberListに格納
		SZAB0111SelectResultData resultData = new SZAB0111SelectResultData();
		resultData.setResultList(contextDataList);

		return resultData;
	}

    @Override
    public boolean checkUserInfo(ContextData context,
            SZAB0111SelectInputData inputData) {
        
        if (context != null) {
            SZAB0111SelectDTO zDto = new SZAB0111SelectDTO();
            
            zDto.setUsername(context.getUsername());
            zDto.setPassword(context.getPassword());

            // 　主キー検索
            try {
                
                return dao.checkUserinfo(zDto);
                
            } catch (SQLException e) {

                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        
        return false;
    }
}

