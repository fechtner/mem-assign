$( document ).ready(function() {
    jQuery.get( "/projects/data", function( data ) {
      var targetDiv = $("#projects-body");
      $.each( data, function( key, value ) {
        targetDiv.append("<tr><td>" + value["name"] + "</td>"
                            +"<td>" + value["status"] + "</td>"
                            +"<td>" + value["source"] + "</td>"
                            +"<td>" + value["targets"] + "</td></tr>");
      });
      $("#projects-loading").html("");
    }).fail(function(data) {
        if (data.status == 401) {
            $("#projects-div").html("Authentication failed.");
        } else {
            $("#projects-div").html("Error during api communications.");
        }
        $("#projects-loading").html("");
    });

});