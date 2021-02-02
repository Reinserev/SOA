$(document).ready(function () {
    var sock = new SockJS(document.getElementById("baseURL").innerHTML + '/greeting');

    sock.onmessage = function(e) {
        alert(e.data);
    };

    $("#removeArticleButton").click(function () {
        removeArticle()
    });
});

function removeArticle() {
    const arr = {}; // empty array
    $.ajax(
        {
            url: document.getElementById("var").innerHTML,
            type: "POST",
            data: JSON.stringify(arr),
            contentType: 'application/json',
            async: true,
            success: function (msg) {
                // alert("Success!");
                document.getElementById('homeLink').click();
            },
            error: function (data) {
                // alert("Could not send article.")
            }
        }
    );
}