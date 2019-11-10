$('.fio').each(function (index, value) {
    let curClient = clients.find(function (element) {
        return element.id === $(value).attr('id');
    });
    $(value).text(curClient.surname+ " " + curClient.name + " "+curClient.middlename);
});
