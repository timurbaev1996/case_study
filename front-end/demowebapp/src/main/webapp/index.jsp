<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:useBean id="globalHelper" class="com.deutsche.dba.web" scope="application"/>--%>

<!doctype html>
<html ng-app="DBApp">
  <head>
    <!-- CSS file -->
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">

  </head>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
              crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="dbanalyzer/css/main.css" />

        </script>
        <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous">
        
    </head>
    
  <body>
    <!-- Import scripts -->
    <script type="text/javascript" src="bower_components/angular/angular.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <script src="bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>

    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <script src="scripts/button.js"></script>
    <script src="scripts/card.js"></script>
    <script src="scripts/main.js"></script>
    
    

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
                        <li class="active"><a href="index.jsp">Home</a></li>
                        <li><a href="data.jsp">Team</a></li>

                    </ul>
                </div>
            </div>
        </nav>
        <br><br>
        <div id="dataBaseTable"></div>;
    <div id="content">

      <div class="text-center" style="padding:50px 0">

       

              <div class="container">
                    <button type="button" onClick="testConnection()" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
                        <div id="connectiontext"> Test Connection </div>
                    </button>
              </div>
          
          
          <p><br>
          <div style="padding-bottom:50px; color:#CACACA; font-family: Verdana;" class="logo"><h4><b>Login</b></h4></div>
        <!-- Main Form -->
          <img id="profile-img" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Deutsche_Bank_logo_without_wordmark.svg/225px-Deutsche_Bank_logo_without_wordmark.svg.png" />

        <div class="login-form-1">
          <form id="login-form" class="text-left">
            <div class="login-form-main-message"></div>
            <div class="main-login-form">
              <div class="login-group">
                <div class="form-group">
                  <label for="lg_username" class="sr-only">Username</label>
                  <input type="text" class="form-control" id="db_username" name="lg_username" placeholder="username">
                </div>
                <div class="form-group">
                  <label for="lg_password" class="sr-only">Password</label>
                  <input type="password" class="form-control" id="db_password" name="lg_password" placeholder="password">
                </div>
              </div>

              <div class="container">
                    <button type="button" id="loading-example-btn" onClick="validat()" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
                        Submit
                    </button>
              </div>
            </div>
          </form>
        </div>
       </div>

      </div>
    </div>


  </body>  
  


</html>
