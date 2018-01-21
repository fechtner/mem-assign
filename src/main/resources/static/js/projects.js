$( document ).ready(function() {
    jQuery.get( "/projects/data", function( data ) {
      var targetDiv = $("#projects-body");
      $.each( data, function( key, value ) {
        targetDiv.append("<tr><td>" + value["name"] + "</td>"
                            +"<td>" + value["status"] + "</td>"
                            +"<td>" + value["source"] + "</td>"
                            +"<td>" + value["targets"] + "</td></tr>");
      });
    });
});