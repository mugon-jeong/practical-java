package module;

import module.service.InsightService;

import java.util.ServiceLoader;

public class Consumer {
    public static void main(String[] args) {
        ServiceLoader<InsightService> loader = ServiceLoader.load(InsightService.class);
        for (InsightService insightService : loader) {
            System.out.println(insightService);
        }
    }
}
