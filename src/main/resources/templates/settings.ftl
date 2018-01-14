<#import "layout.ftl" as macro>

<@macro.mainLayout title="Settings" active=2>

    <div class="custom-main">
        <h1>Settings page</h1>

        <form action="/settings" method="post">
            <div class="form-group row">
                <label for="user" class="col-sm-2 col-form-label">User name</label>
                <div class="col-sm-10">
                    <input class="form-control" name="user" id="user" placeholder="Enter user name" value="${settings.user}"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password" value="${settings.password}"/>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</@macro.mainLayout>