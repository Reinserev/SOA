$(document).ready(function () {
    var sock = new SockJS(document.getElementById("baseURL").innerHTML + '/greeting');

    sock.onmessage = function(e) {
        alert(e.data);
    };

    $("#uploadButton").click(function () {
        // https://stackoverflow.com/questions/31746837/reading-uploaded-text-file-contents-in-html/44161989

        var label = document.getElementById("labels").value;
        var fileToLoad = document.getElementById("fileToLoad").files[0];
        var textFromFileLoaded;

        var fileReader = new FileReader();
        fileReader.onload = function (fileLoadedEvent) {
            textFromFileLoaded = fileLoadedEvent.target.result;

            uploadFile(textFromFileLoaded, fileToLoad.name, label,function () {

            })
        };

        fileReader.readAsText(fileToLoad, "UTF-8");
    });
});

function uploadFile(fileContent, fileName, label, callbackFunction) {
    const arr = {file: fileContent, fileName: fileName, label: label};
    $.ajax(
        {
            url: "#fileUploadURL",
            type: "POST",
            data: JSON.stringify(arr),
            contentType: 'application/json',
            async: true,
            success: function (msg) {
                // alert("Success!");
            },
            error: function (data) {
                // alert("Could not send article.")
            }
        }
    );
}