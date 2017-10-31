package com.mindata.ecserver.main.repository;

import com.mindata.ecserver.main.model.PtUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
public interface PtUserRoleRepository extends JpaRepository<PtUserRole, Integer> {
    List<PtUserRole> findByUserId(Integer userId);

    PtUserRole findByUserIdAndRoleId(Integer userId, Integer roleId);
}
