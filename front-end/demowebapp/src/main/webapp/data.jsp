<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html ng-app="DBApp">
  <head>
    <!-- CSS file -->
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
  </head>

  <body>
    <!-- Import scripts -->
    <script type="text/javascript" src="bower_components/angular/angular.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <script src="bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <script src="scripts/button.js"></script>
    <script src="scripts/card.js"></script>

    <!-- App controller -->
    <script src="js/route/route.js"></script>

    <!-- some navigation -->
    <ul class="nav nav-pills">
    <li role="presentation"><a ui-sref="home">Home</a></li>
    <li role="presentation"><a ui-sref="changepage">Another Page</a></li>
  </ul>

    <div>

        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">App C1.1</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="data.jsp">Team</a></li>

                    </ul>
                </div>
            </div>
        </nav>

      <div class="text-center" style="padding:50px 0">

        <h1> Tim, Mike, Hannah, Dan, Andreas, Florian</h1>



      </div>
    </div>

  </body>

</html>
