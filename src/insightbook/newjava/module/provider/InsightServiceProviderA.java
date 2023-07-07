package module.provider;

import module.service.InsightService;

public class InsightServiceProviderA implements InsightService {
    @Override
    public String echo(String message) {
        return "Hello A : " + message;
    }
}