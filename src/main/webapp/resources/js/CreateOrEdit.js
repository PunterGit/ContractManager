function treatAsUTC(date) { // Функция получения текущей даты
    let result = new Date(date);
    result.setMinutes(result.getMinutes() - result.getTimezoneOffset());
    return result;

}

function daysBetween(startDate, endDate) { // Функция расчёта дней между промежутком двух дат
    let millisecondsPerDay = 24 * 60 * 60 * 1000;
    return (treatAsUTC(endDate) - treatAsUTC(startDate)) / millisecondsPerDay;
}

function insertClientHTML(client) {
    $('[name="clientId"]').val(client.id);
    $('[name="name"]').val(client.name);
    $('[name="surname"]').val(client.surname);
    $('[name="middlename"]').val(client.middlename);
    $('[name="birthDate"]').val(client.birthDate.slice(6) + '-' + client.birthDate.slice(3, 5)+ '-'+ client.birthDate.slice(0, 2));
    $('[name="passportId"]').val(+client.passportIdSeries);
    $('[name="passportId2"]').val(+client.passportIdNumber);
}

function pickClient(elem){
    let selectedClient = dataClients.find(function (element) {
        return element.id === $(elem).attr("id");
    });
    dataClients = selectedClient;
    insertClientHTML(selectedClient);
    $('.clientPicker').dialog( 'close' );
}

function dataClientsUpdate(){
    $.ajax({
        url: '/client/list',
        type: 'GET',
        dataType: 'text',
        success: function (resp) {
            dataClients = eval(resp).find(function (element) {
                return element.id === $('[name="clientId"]').val();
            });
            insertClientHTML(dataClients);
        }
    });
}

let dataClients ={};

$(document).ready(function () {
    dataClientsUpdate();
});

$(document).on("click",'[name="calculate"]',function () { // Функция нажатия на кнопку расчета премии. Достаёт значения из инпутов,
    let property = 0.0;                                // производит соответсвующие операции и втсавляет результат в соответствующие поля
    let constructionYear = 0.0;
    let area = 0.0;
    ($('[name="property"]').val() === "Комната")? property = 1.3:($('[name="property"]').val() === "Дом")? property = 1.5: ($('[name="property"]').val() === "Квартира")? property = 1.7: alert("Выбран неверный тип недвижиости");
    ($('[name="constructionYear"]').val() < 2000)? constructionYear = 1.3:($('[name="constructionYear"]').val() < 2015)? constructionYear = 1.6: constructionYear = 2;
    ($('[name="area"]').val() < 50)? area = 1.2:($('[name="area"]').val() < 100)? area = 1.5: area = 2;
    $('[name="computationDate"]').val(curDate);
    $('[name="insurancePremium"]').val((($('[name="insuranceSum"]').val()/daysBetween($('[name="insuranceStartDate"]').val(),$('[name="insuranceEndDate"]').val()))*property*constructionYear*area).toFixed(2));
});

$(document).on("click",'[name="pickClient"]',function () {
    let htmlDialog = '<div class="container clientPicker"><div class="row">' +
        '<div class="col-5 modal-col">'+
        '<span>ФИО</span>'+
        '</div>'+
        '<div class="col-2 modal-col">'+
        '<span>Дата рождения</span>'+
        '</div>'+
        '<div class="col-3 modal-col">'+
        '<span>Паспортные данные</span>'+
        '</div>'+
        '<div class="col-2 modal-col">'+
        '<span>Действия</span>'+
        '</div>'+
        '</div>';
    let prevDataClient = dataClients;
    $.ajax({
        url: '/client/list',
        type: 'GET',
        dataType: 'text',
        success: function (resp) {
            dataClients = eval(resp);
            dataClients.forEach(function (item, i, dataClients) {
                htmlDialog += '<div class="row">' +
                    '<div class="col-5 modal-col">'+
                        '<span>'+item.surname + ' ' + item.name + ' ' + item.middlename +'</span>'+
                    '</div>'+
                    '<div class="col-2 modal-col">'+
                        '<span>' + item.birthDate + '</span>'+
                    '</div>'+
                    '<div class="col-3 modal-col">'+
                        '<span>'+ item.passportIdSeries + " "+ item.passportIdNumber +'</span>'+
                    '</div>'+
                    '<div class="col-2 modal-col">'+
                        '<button type="button" class="btn btn-dark" onclick="pickClient(this)" id="'+item.id+'">Выбрать</button>'+
                        '<button type="button" class="btn btn-dark">Изменить</button>'+
                    '</div>'+
                '</div>';
            });
            $(htmlDialog+'</div>').dialog({
                title: 'Выбор клиента',
                resizable: false,
                modal: true,
                show: 'slide',
                draggable: false,
                maxWidth: 1800,
                maxHeight: 900,
                minWidth: 700,
                minHeight: 180,
                buttons: {
                    'Отмена': function()  {
                        dataClients = prevDataClient;
                        $(this).dialog( 'close' );
                    }
                }
            });
        }
    });
});

$(document).on("click",'[name="editClient"]',function () {
    let htmlDialog = '<form class="editClient">'+
        '<div class="row">' +
            '<input type="text" name="clientChangingId" value="'+dataClients.id+'" hidden/>'+
            '<div class="col-4 modal-col">'+
                '<label>Фамилия</label><input type="text" name="clientSurname" value="'+dataClients.surname +'"/>'+
            '</div>' +
            '<div class="col-4 modal-col">'+
                '<label>Имя</label><input type="text" name="clientName" value="'+ dataClients.name +'"/>'+
            '</div>' +
            '<div class="col-4 modal-col">'+
                '<label>Отчество</label><input type="text" name="clientMiddlename" value="'+ dataClients.middlename +'"/>'+
            '</div>'+
        '</div>' +
        '<div class="row">' +
        '<div class="col-4 passport"></div>' +
            '<div class="col-8" style="text-align: center; font-weight: bolder;">Паспорт</div>' +
        '</div>'+
        '<div class="row">' +
            '<div class="col-4 modal-col">'+
                '<label>Дата рождения</label><input type="date" name="clientBirthDate" value="'+dataClients.birthDate.slice(6) + '-' + dataClients.birthDate.slice(3, 5)+ '-'+ dataClients.birthDate.slice(0, 2)+'"/>' +
            '</div>'+
            '<div class="col-4 modal-col">'+
                '<label>Серия</label><input type="number" maxlength="4" name="clientPassportId" value="'+dataClients.passportIdSeries+'"/>'+
            '</div>'+
            '<div class="col-4 modal-col">'+
                '<label>Номер</label><input type="number" maxlength="6" name="clientPassportId2" value="'+dataClients.passportIdNumber+'"/>'+
            '</div>'+
        '</div></form>';
    $(htmlDialog).dialog({
        title: 'Изменение данных клиента',
        resizable: false,
        modal: true,
        show: 'slide',
        draggable: false,
        maxWidth: 1800,
        maxHeight: 900,
        minWidth: 700,
        minHeight: 180,
        buttons: {
            'Сохранить': function()  {
                $.ajax({
                    type: 'POST',
                    url: 'client/add',
                    data: $('.editClient').serialize(),
                    success: function(data) {
                        console.log(data);
                        dataClientsUpdate();
                    },
                });

                $(this).dialog( 'close' );
            },
            'Отмена': function()  {
                $(this).dialog( 'close' );
            }
        }
    });
});
$(document).on("click",'[name="addClient"]',function () {
    let htmlDialog = '<form class="addClient">'+
        '<div class="row">' +
            '<div class="col-4 modal-col">'+
                '<label>Фамилия</label><input type="text" name="clientSurname" value=""/>'+
            '</div>' +
            '<div class="col-4 modal-col">'+
                '<label>Имя</label><input type="text" name="clientName" value=""/>'+
            '</div>' +
            '<div class="col-4 modal-col">'+
                '<label>Отчество</label><input type="text" name="clientMiddlename" value=""/>'+
            '</div>'+
        '</div>' +
        '<div class="row">' +
        '<div class="col-4 passport"></div>' +
            '<div class="col-8" style="text-align: center; font-weight: bolder;">Паспорт</div>' +
        '</div>'+
        '<div class="row">' +
            '<div class="col-4 modal-col">'+
                '<label>Дата рождения</label><input type="date" name="clientBirthDate" value=""/>' +
            '</div>'+
            '<div class="col-4 modal-col">'+
                '<label>Серия</label><input type="number" maxlength="4" name="clientPassportId" value=""/>'+
            '</div>'+
            '<div class="col-4 modal-col">'+
                '<label>Номер</label><input type="number" maxlength="6" name="clientPassportId2" value=""/>'+
            '</div>'+
        '</div></form>';
    $(htmlDialog).dialog({
        title: 'Добавление клиента',
        resizable: false,
        modal: true,
        show: 'slide',
        draggable: false,
        maxWidth: 1800,
        maxHeight: 900,
        minWidth: 700,
        minHeight: 180,
        buttons: {
            'Добавить': function()  {
                $.ajax({
                    type: 'POST',
                    url: 'client/add',
                    data: $('.addClient').serialize(),
                    dataType: 'text',
                    success: function(data) {
                        $('[name="clientId"]').val(data);
                        dataClientsUpdate();
                    },
                });

                $(this).dialog( 'close' );
            },
            'Отмена': function()  {
                $(this).dialog( 'close' );
            }
        }
    });
});
