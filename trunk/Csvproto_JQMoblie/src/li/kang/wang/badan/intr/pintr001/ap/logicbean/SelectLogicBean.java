package li.kang.wang.badan.intr.pintr001.ap.logicbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import li.kang.wang.badan.common.SqlConfig;
import li.kang.wang.badan.intr.pintr001.ap.data.ContextData;
import li.kang.wang.badan.intr.pintr001.ap.data.ListContextData;
import li.kang.wang.badan.intr.pintr001.ap.data.SelectResultData;
import li.kang.wang.badan.intr.pintr001.db.dto.UserInfo;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;

/** SelectLogicBean实现类 */
public class SelectLogicBean implements ISelectLogicBean {

    private static Logger log = Logger.getLogger(SelectLogicBean.class
            .getName());

    @Override
    /**
     * 查询用户信息 
     */
    public SelectResultData getUserList() {
        
        SelectResultData resultData = new SelectResultData();
        
        /** 取得sqlMap实例 */
        SqlMapClient sqlMap = SqlConfig.getSqlMapInstance();
        
        try {
            // 事务开始
            sqlMap.startTransaction();
            
            List<UserInfo> userList = (List<UserInfo>) sqlMap.queryForList("PINTR001.getAllUserInfo");
            
            if (userList != null) {
                List<ListContextData> list = new ArrayList<ListContextData>();
                
                resultData.setList(list);
                
                for (UserInfo user : userList) {
                    ListContextData result = new ListContextData();
                    
                    result.setUsername(user.getUsername());

                    list.add(result);
                }
                
                resultData.setList(list);
            }
                        
            sqlMap.commitTransaction();
            
        } catch (Exception e) {
            log.error(e.getMessage());
        }finally{
            try {
                sqlMap.endTransaction();
            } catch (Exception e) {
                
            }
        }
        return resultData;
    }

    @Override
    /**
     * 验证用户信息
     */
    public boolean checkUserInfo(ContextData contextData) {
        
        /** 取得sqlMap实例 */
        SqlMapClient sqlMap = SqlConfig.getSqlMapInstance();
        
        try {
            // 事务开始
            sqlMap.startTransaction();
            
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(contextData.getUsername());
            userInfo.setPassword(contextData.getPassword());
            
            Object queryResult = sqlMap.queryForObject("PINTR001.getUserInfo", userInfo);
            
            sqlMap.commitTransaction();
            
            if (queryResult != null){
                return true;
            }
            
        } catch (Exception e) {
            log.error(e.getMessage());
        }finally{
            try {
                sqlMap.endTransaction();
            } catch (Exception e) {
                
            }
        }
        return false;
    }
}
