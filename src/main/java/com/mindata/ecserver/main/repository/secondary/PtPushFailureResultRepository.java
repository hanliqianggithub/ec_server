package com.mindata.ecserver.main.repository.secondary;

import com.mindata.ecserver.main.model.secondary.PtPushFailureResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
public interface PtPushFailureResultRepository extends JpaRepository<PtPushFailureResult, Long> {
    /**
     * 查询某段时间数量
     *
     * @param begin
     *         开始时间
     * @param end
     *         结束时间
     * @return 数量
     */
    int countByCreateTimeBetween(Date begin, Date end);

    /**
     * 理论上不能有多个，但是有测试数据需要删除掉
     *
     * @param contactId
     *         EcContactEntity表的id
     * @return 结果集
     */
    List<PtPushFailureResult> findByContactId(Long contactId);

    /**
     * 查询所有推送失败的记录
     * @param var1
     * 复杂查询
     * @param var2
     * 分页
     * @return
     * 分页集合
     */
    Page<PtPushFailureResult> findAll(Specification<PtPushFailureResult> var1, Pageable var2);
}
