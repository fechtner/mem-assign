<#import "layout.ftl" as macro>

<@macro.mainLayout title="Projects" active=3 script="projects.js">

    <div class="custom-main">
        <h1>Projects page</h1>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Status</th>
                    <th>Source language</th>
                    <th>Target languages</th>
                </tr>
            </thead>
            <tbody id="projects-body">
            </tbody>
        </table>
    </div>
</@macro.mainLayout>