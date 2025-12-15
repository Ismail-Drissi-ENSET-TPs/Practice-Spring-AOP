# Spring AOP Project

This project demonstrates Aspect-Oriented Programming (AOP) using Spring AOP.

## Aspects

- **LogAspect**: This aspect provides logging functionality. It uses the @Around advice to log before and after method execution for methods annotated with @Log.

- **AuthzAspect**: This aspect handles authorization. It uses the @Around advice to check if the user has the required roles before proceeding with the method execution for methods annotated with @SecuredByAspect.

## Annotations

- **@Log**: This annotation is used to mark methods that should be logged by the LogAspect.

- **@SecuredByAspect**: This annotation is used to specify the roles required for a method. The AuthzAspect checks these roles against the current user's roles.