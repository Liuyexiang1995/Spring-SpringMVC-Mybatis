package webapp.common.exception;

import webapp.common.constants.ITSExceptionConstants;

/**
 * 招商管理服务平台核心运行时异常
 *
 * @author ConDey
 * @version $$package: com.eazytec.investsmart.common.exception, v 0.1 2017/9/23 下午10:35 ConDey Exp $$
 */
public class ITSRuntimeException extends RuntimeException {

    public ITSRuntimeException() {
        this(ITSExceptionConstants.ERROR_SYSTEM);
    }

    public ITSRuntimeException(String message) {
        super(message);
    }
}
