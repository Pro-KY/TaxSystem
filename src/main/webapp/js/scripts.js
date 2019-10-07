const form = 'Form';

$(function(){
    $('#inputGroupSelect01').change(function() {
        // console.log(event.targetElement);
        // console.log(event.targetElement);
        let selectedText = $(this).find("option:selected").text(); // val
        console.log(selectedText);

        if (selectedText === form) {
            changeSendReportTagsVisibility(true);
        } else {
            changeSendReportTagsVisibility(false);
        }
    })
});

$(function(){
    $('#usertype').change(function() {
        let selectedValue = $('#usertype').val();
        if(selectedValue === '2') {
            $('#fistLastNamesWrapper').hide();
            $('#organizationWrapper').show();
        } else {
            $('#fistLastNamesWrapper').show();
            $('#organizationWrapper').hide();
        }

        console.log(selectedValue);
    })
});

function changeSendReportTagsVisibility(formChosenValue) {
    let formWrapper = document.getElementById("formWrapper");
    let inputFileWrapper = document.getElementById("inputFileWrapper");

    if (formChosenValue) {
        formWrapper.style.display = "block";
        inputFileWrapper.style.display = "none";
    } else {
        formWrapper.style.display = "none";
        inputFileWrapper.style.display = "block";
    }
}

function openFile(evt) {
    var fileReader = new FileReader();
    var input = evt.target;
    let chosenFile = input.files[0];

    fileReader.onload = function() {
        var text = fileReader.result;
        // console.log(text.substring(0, 200));
        var inputFileLabel = $("#inputFileLabel");
        inputFileLabel.text(chosenFile.name);
        $("#fileContentInput").val(text);
    };

    fileReader.readAsText(chosenFile, "UTF-8");
    console.log("changed");
}

$(document).ready(function($) {
    $(".table-row").click(function() {
        window.document.location = $(this).data("href");
    });
});

$(function(){
    $('.list-group a').click(function(e) {
        console.log("ready");
        // e.preventDefault();

        $that = $(this);

        $that.parent().find('a').removeClass('active');
        $that.addClass('active');
    });
});

