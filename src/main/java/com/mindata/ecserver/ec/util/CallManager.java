package com.mindata.ecserver.ec.util;


import com.mindata.ecserver.ec.exception.EcException;
import com.mindata.ecserver.ec.model.base.BaseEcData;
import org.springframework.stereotype.Component;
import retrofit2.Call;

import java.io.IOException;

/**
 * @author wuweifeng wrote on 2017/10/23.
 */
@Component
public class CallManager {
    private final static int SUCCESS = 200;
    /**
     * 没有token
     */
    private final static int NO_AUTH = 2002;

    public <T extends BaseEcData> BaseEcData execute(Call<T> call) throws IOException {
        return doExecute(call);
    }

    private <T extends BaseEcData> BaseEcData doExecute(Call<T> call) throws IOException {
        retrofit2.Response response = call.execute();
        //返回值
        int code = response.code();

        //网络请求失败直接抛异常
        if (SUCCESS != code) {
            throw new EcException(response.message());
        }

        BaseEcData baseEcData = (BaseEcData) response.body();
        int errCode = baseEcData.getErrCode();
        if (SUCCESS == errCode) {
            return (T) response.body();
        }

        throw new EcException("EC异常信息：" + baseEcData.getErrMsg());
    }
}
