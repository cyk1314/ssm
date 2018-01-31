package cn.itcast.username.pojo;

import java.util.List;

/**
 * Created by cyk on 2018/1/28.
 */
public class EasyUIResult {

        private Long total;
        private List<?> rows;
        public Long getTotal() {
            return total;
        }
        public void setTotal(Long total) {
            this.total = total;
        }
        public List<?> getRows() {
            return rows;
        }
        public void setRows(List<?> rows) {
            this.rows = rows;
        }

    }
