<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="AddTechTalk" method="post">
		<div class="form-group">
						Date: <input type="text" name="date" placeholder="yyyy-mm-dd"/>
				</div>		
				<div class="form-group">
						TechTalk: <input type="text" name="tt" placeholder="techTalk"/>
				</div>
				<div class="form-group">
						Presentator: <input type="text" name="presentator" placeholder="presentator"/>
				</div>
				 <div class="align-center">
						<input type="submit" value="addTechTalk"/>
			     </div>


   </form>
</body>
</html>