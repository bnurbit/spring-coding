Interceptors
-> Spring MVC, any incoming web request is sent to the dispatcher servlet which then looks at the handler mappings
    configured to find the right method to handle the incoming request
-> intercept client requests to handler mappings and process them before they are handled by controller methods
-> uses:
    - make sure all the input parameters are in the right format
    - add additional parameters
    - perform action in the background
-> needs to be explicitly registered

Api proxies for services
-> Control access to APIs for security (extra layer), monetization (how many times api was accessed by user), access tracking
-> Rather than users interacting the API directly, they send the request to the API proxy

Zull
-> dynamic routing, monitoring, resiliency and security for APIs
-> JVM-based router and server-side load balancer
-> developed by Netflix

Security
-> spring-boot-starter-security automatically adds basic authentication
    - default: username: user, password: generated - check logs
    - /login path mapping is added automatically





