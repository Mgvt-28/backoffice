$(document).ready(function () {
    $('a[href=catalogue]').on('click', function (event) {
        event.preventDefault();

        if ($('body').children().length<20) {
            $.ajax({
                url: "rest/catalogue/liste",
                success: function (result) {
                    var catalog='';
                    result.forEach(function(nextWork){
                        catalog=catalog.concat(nextWork.title+" ("+nextWork.release+")<BR/>");
                    });

                    $("a[href=catalogue]").after('<br>'+catalog);
                }
            });
        }
    });
});