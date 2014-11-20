package fr.treeptik.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

public class LogAspect {

	
	public void executeBefore(JoinPoint joinPoint){
		System.out.println("*********** BEFORE *****************");
		System.out.println("signature: " + joinPoint.getSignature().getDeclaringTypeName());
		System.out.println("kind: " + joinPoint.getKind());
		
	}
	public void executeAfter(StaticPart staticPart, Object result){
		System.out.println("*********** After *****************");
		System.out.println("signature: " + staticPart.getSignature().getDeclaringTypeName());
		System.out.println("kind: " + staticPart.getKind());
	}
}
