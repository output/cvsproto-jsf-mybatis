package li.kang.wang.badan.intr.pintr001.ap.data;

import java.util.List;

/** 保存数据库查询结果 */
public class SelectResultData {
    
    /** 查询结果List */
    private List<ListContextData> list;

    /**
     * @return the list
     */
    public List<ListContextData> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<ListContextData> list) {
        this.list = list;
    }
}
