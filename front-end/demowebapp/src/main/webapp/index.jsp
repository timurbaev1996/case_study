<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html ng-app="DBApp">
  <head>
    <!-- CSS file -->
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="src/css/styles.css">
  </head>
  <body>
    <!-- Import scripts -->
    <script type="text/javascript" src="bower_components/angular/angular.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <script src="bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <script src="scripts/src/button.js"></script>
    <script src="scripts/src/card.js"></script>

    <!-- App controller -->
    <script src="src/js/controller/todo.js"></script>
    <script src="src/js/route/route.js"></script>

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
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="about.html">Data</a></li>
                        <li><a href="about.html">Team</a></li>

                    </ul>

                </div>
            </div>
        </nav>

      <div class="text-center" style="padding:50px 0">
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
                  <input type="text" class="form-control" id="lg_username" name="lg_username" placeholder="username">
                </div>
                <div class="form-group">
                  <label for="lg_password" class="sr-only">Password</label>
                  <input type="password" class="form-control" id="lg_password" name="lg_password" placeholder="password">
                </div>
              </div>

                <div class="container">
                    <button type="button" id="loading-example-btn" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
                        Submit
                    </button>
                 </div>
            </div>
          </form>
        </div>

      </div>
    </div>

  </body>

</html>
