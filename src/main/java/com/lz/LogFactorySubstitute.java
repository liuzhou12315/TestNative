package com.lz;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.nologging.NoLoggingImpl;
import org.springframework.nativex.substitutions.OnlyIfPresent;

@TargetClass(
        className = "org.apache.ibatis.logging.LogFactory",
        onlyWith = {OnlyIfPresent.class}
)
public final class LogFactorySubstitute {

    @Substitute
    public static Log getLog(String logger) {
        return new NoLoggingImpl(LogFactory.class.getName());
    }
}
