package com.mindata.ecserver.main.repository.secondary;

import com.mindata.ecserver.main.model.secondary.PtCustomerState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wuweifeng wrote on 2017/10/25.
 */
public interface PtCustomerStateRepository extends JpaRepository<PtCustomerState, Long>,
        JpaSpecificationExecutor<PtCustomerState> {
}
