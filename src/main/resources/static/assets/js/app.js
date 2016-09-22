
var app = new App();

function App() {
    //
}

App.prototype.init = function () {
    //
};

App.prototype.initDatepickers = function (dateFormat, firstDay, dayNamesMin, monthNames) {
    $('#from').datepicker({
        dateFormat: dateFormat,
        constrainInput: true,
        firstDay: firstDay,
        dayNamesMin: dayNamesMin,
        monthNames: monthNames
    });
    $('#to').datepicker({
        dateFormat: dateFormat,
        constrainInput: true,
        firstDay: firstDay,
        dayNamesMin: dayNamesMin,
        monthNames: monthNames
    });
};
