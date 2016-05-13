<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welkom bij Oxyplast</title>
    <c:url value="/resources/css/bootstrap.min.css" var="bootstrapcss" />
    <c:url value="/resources/css/bootstrap-theme.min.css" var="bootstraptheme" />
    <c:url value="/resources/js/bootstrap.min.js" var="bootstrapjs" />
    <c:url value="/resources/js/jquery-2.2.2.min.js" var="jq" />
	 <script src="${jq}"></script>
	
     <link href="${bootstrapcss}" rel="stylesheet">
     <link href="${bootstraptheme}" rel="stylesheet">
  	<link href="/resources/Calendar/fullcalendar.min.css" rel='stylesheet' type='text/css'>
   
  
   <!--  <link rel='stylesheet' href='/resources/Calendar/lib/cupertino/jquery-ui.min.css' /> -->
  
 <script type="text/javascript" src="/resources/jquery-ui/jquery-ui.min.js"></script>
     <script type="text/javascript" src="/resources/Calendar/moment.min.js"></script> 
    <script type="text/javascript" src="/resources/Calendar/fullcalendar.min.js"></script>
    <link href="/resources/Calendar/jquery.mobile.flatui.min.css" rel='stylesheet' type='text/css'>
    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/resources/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    

    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>

    <script src="${bootstrapjs}"></script>
    
</head>

<body style="font-family:Lato;">
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    </button>
                <a class="navbar-brand" href="#">Oxplast</a>
            </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="<c:url value="/" />">Home</a></li>
           <li>
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Projecten <span class="caret"></span></a>
           <ul class="dropdown-menu">
            <li><a href="<c:url value="/" />">Overzicht Projecten</a></li>
            <li><a href="<c:url value="/aanvraagOverzicht" />">Overzicht Aanvragen</a></li>
            <li><a href="<c:url value="/prototypeOverzicht" />">Overzicht Prototypes</a></li>
            <li><a href="<c:url value="/leverancierOverzicht" />">Overzicht Leveranciers</a></li>
            <li><a href="<c:url value="/teamoverzicht" />">Overzicht Teams</a></li>
          </ul>    
           </li>
            <li><a href="<c:url value="/profiel" />">Profiel</a></li>
            <li><a href="#">Help</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container">
        <div class="col-sm-12 col-md-12 col-lg-12">
                  <div class="row">
                <div class="col-lg-3 col-md-8">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"> <c:out value="${aantalProjecten}" /></div>
                                    <div>Actieve projecten</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                  <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><c:out value="${aantalPrototypes}" /></div>
                                    <div>Prototypes</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-shopping-cart fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><c:out value="${aantalAanvragen}" /></div>
                                    <div>Aanvragen</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                  <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><c:out value="${aantalBestellingen}" /></div>
                                    <div>Bestellingen</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
				<div id="error" class="alert alert-danger">
  
	</div>
               <div id='calendar'></div> 
        </div>
    </div>
 
    
    <script>
    $(document).ready(function() {
	
	var id = [];
	var title = [];
	var start = [];
	var end = [];
        $('#calendar').fullCalendar({
        	header: {
    			left: 'prev,next today',
    			center: 'title',
    			right: 'month,agendaWeek,agendaDay'
    		},
    		  eventSources: [
    		    {
    		      url: 'localhost:8080/rest/projecten',
    		      type: 'GET',
    	          dataType: "json",
    	          succes: function(data){
    	        	for(var i=0;i<data.length;i++ ){
    	        	delete data[i].teamid;
    	        	delete data[i].status;
    	        	data[i].start = new date(data[i].start);
    	        	data[i].end = new date(data[i].end);
    	        	}  
    	          },
    		      error: function() {
    		        $('#error').html('Geen lopende projecten, er moet iets mis zijn');
    		      }}
    		      ]
    		  
          
        })

    });
    </script>
    


</body>

</html>