module insightbook.newjava.first {
    uses module.service.InsightService;
    requires java.base;
    requires java.sql;
    exports module.dao;

    exports module.service;
    provides module.service.InsightService with
            module.provider.InsightServiceProviderA;
}