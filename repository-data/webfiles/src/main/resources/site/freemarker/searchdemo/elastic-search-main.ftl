<#include "../include/imports.ftl">

<#-- @ftlvariable name="query" type="java.lang.String" -->
<#-- @ftlvariable name="items" type="java.lang.Iterable<org.onehippo.cms7.crisp.api.resource.Resource>" -->
<#if items?has_content>
    <div>
    <#list items as item>
        <article class="has-edit-button">
        <h3><a href="${item.getValue('_links/site/href')}">${item.getValue('title')}</a></h3>
        </article>
    </#list>
    </div>
<#else>
    <h3>No results</h3>
</#if>