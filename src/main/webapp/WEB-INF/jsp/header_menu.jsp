
     
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
  
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    
                    <li>
                        <a href="/demo/mvclistpersons">Show persons</a>
                    </li>
                       
                    <li><a href="/welcome">About this application</a></li>

           
                   <sec:authorize access="isAuthenticated()">
                       <li><a href="/logout">Logout</a></li>
                   </sec:authorize>
                   <sec:authorize access="!isAuthenticated()">
                       <li><a href="/login">Login</a></li>
                    </sec:authorize>
               
                   
                </ul>
            </div>
        </div>
    </nav>
  
  <br><br><br>

  
 <div class="container">
      
    <sec:authorize access="isAuthenticated()">
            &nbsp;&nbsp;&nbsp;<b>Welcome Back, <sec:authentication property="name"/></b>
     </sec:authorize>
      
</div>
  
  