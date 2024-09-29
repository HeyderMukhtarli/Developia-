package az.developia.springjava16.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger fileLogger = LoggerFactory.getLogger("FILE_LOGGER");

    // Pointcut for methods related to add, update, and delete in your service layer
    @Pointcut("execution(* az.developia.springjava16.service.*.add*(..)) || " +
            "execution(* az.developia.springjava16.service.*.update*(..)) || " +
            "execution(* az.developia.springjava16.service.*.delete*(..))")
    public void logAddUpdateDeleteMethods() {
    }

    @Before("logAddUpdateDeleteMethods()")
    public void logMethodDetails(JoinPoint joinPoint) {
        // Get method name, class name, and arguments
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName(); // Get class name
        Object[] args = joinPoint.getArgs();

        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Get username from SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (authentication != null) ? authentication.getName() : "Anonymous";

        // Write the log to a file including the class name
        writeLogToFile(className, methodName, formattedDate, username, args);
    }

    private void writeLogToFile(String className, String methodName, String date, String username, Object[] args) {
        // Use logger instead of manually writing to the file
        fileLogger.info("Class: {} | Method: {} | Date: {} | User: {} | Args: {}", className, methodName, date, username, args);
    }
}
