$('#frmsearch:search').keyup(function() {
    if ($('#frmsearch:search').val() != '') {
        $('#frmsearch:btnsearch').removeAttr('disabled');
    } else {
        $('#frmsearch:btnsearch').attr('disabled', 'disabled');
    }
});