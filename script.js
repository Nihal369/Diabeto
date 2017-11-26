
$(document).ready(function(){
    $("#search").keyup(function(){
        
        $.ajax({
            type: "POST",
            url: "http://localhost:3000/dis",
            data: $(this).val(),
            success: success,
            dataType: dataType
          });
    });
})
