package com.mindata.ecserver.main.service;

import com.mindata.ecserver.global.bean.SimplePage;
import com.mindata.ecserver.global.shiro.ShiroKit;
import com.mindata.ecserver.main.manager.PtPhoneHistoryCompanyManager;
import com.mindata.ecserver.main.model.secondary.PtPhoneHistoryCompany;
import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author wuweifeng wrote on 2017/11/5.
 */
@Service
public class PhoneHistoryCompanyService {
    @Resource
    private PtPhoneHistoryCompanyManager ptPhoneHistoryCompanyManager;

    public SimplePage findHistoryByDate(Integer companyId, String begin, String end, Pageable pageable) throws
            IOException {
        //不传companyId，则默认是当前用户
        if (companyId == null) {
            companyId = ShiroKit.getCurrentUser().getCompanyId();
        }
        Date beginDate = DateUtil.beginOfDay(DateUtil.parseDate(begin));
        Date endDate = DateUtil.endOfDay(DateUtil.parseDate(end));

        Page<PtPhoneHistoryCompany> page = ptPhoneHistoryCompanyManager.findHistoryByDate(companyId, beginDate,
                endDate, pageable);

        List<PtPhoneHistoryCompany> companies = page.getContent();


        return null;
    }
}
