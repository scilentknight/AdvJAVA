<html>
<body>
<h2>A simple Web Form</h2>
<div>
   <form name="myForm" method="post" action="PostParameterServlet">
       <table>
           <tr>
               <td><B>Employee</B></td>
               <td>
                   <input type="text" name="employee" size="25" value="" />
               </td>
           </tr>

           <tr>
               <td><B>Phone</B></td>
               <td>
                   <input type="text" name="phone" size="25" value="" />
               </td>
           </tr>
       </table>

       <input type="submit" value="Submit" />
   </form>
</div>
</body>
</html>
