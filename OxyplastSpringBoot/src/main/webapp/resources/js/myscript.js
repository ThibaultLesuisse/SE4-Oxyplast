$(document).ready(function () {

  var colors= ['BlueViolet','Brown','Chocolate','Coral','CornflowerBlue','Crimson','DarkOrange','DarkRed','DeepSkyBlue','DodgerBlue','Orange','OrangeRed','Tomato'];

  $.ajax({
    type: "GET",
    url: "http://localhost:8080/rest/projecten",
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function (data, status, jqXHR) {
      var events = [];
      for (var i = 0; i < data.length; i++) {
        events.push({
          events: [{
            title: data[i].title,
            start: data[i].start,
            end: data[i].end,
            allDay: true
          }],
          color: colors[i % colors.length]
        });
      }
      initCalendar(events);
    },
    error: function (jqXHR, status) {
      initCalendar([{
        events: [{
          title: "Data Error",
          start: '2000-01-01',
          end: '2100-01-01',
          allDay: true
        }]
      }]);
    }
  });

  var initCalendar = function (eventData) {
    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
      },
      eventSources: eventData
    });
  }

});