<#import "layout.ftl" as macro>

<@macro.mainLayout title="Error">

    <div class="custom-main">
        <h1>Error</h1>
        <#if error??>
            ${error}
        </#if>
    </div>
</@macro.mainLayout>