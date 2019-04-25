package org.example;

import java.util.HashMap;
import java.util.Map;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.onehippo.cms7.crisp.api.broker.ResourceServiceBroker;
import org.onehippo.cms7.crisp.api.resource.Resource;
import org.onehippo.cms7.crisp.hst.module.CrispHstServices;
import org.onehippo.cms7.essentials.components.CommonComponent;

import static java.util.stream.Collectors.toList;

public class SimpleElasticSearchComponent extends CommonComponent {

    @Override
    public void doBeforeRender(final HstRequest request, final HstResponse response) {
        super.doBeforeRender(request, response);

        final Map<String, Object> pathVars = new HashMap<>();
        String query = getPublicRequestParameter(request, "query");
        pathVars.put("query", query);

        ResourceServiceBroker broker = CrispHstServices.getDefaultResourceServiceBroker();
        Resource content = broker.resolve("elasticsearch", "/content/document/_search?q={query}",pathVars);

        Resource records = (Resource)content.getValue("hits/hits");

        request.setAttribute("items", records.getChildren().getCollection().stream().map(resource -> resource.getValue("_source")).collect(toList()));
        request.setAttribute("query", query);
    }
}
