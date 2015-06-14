<?php
require 'connect.to.db.php';

$query = "SELECT temp FROM pi_temp ORDER BY id DESC LIMIT 1";

$x = mysql_query($query);

 //just so i can print the value rather then the array->17
 /*
$y =  mysql_fetch_row($x); 
$string = implode('|',$y);
echo $string;
*/
//same another way to just print the value 
echo mysql_result($x,null);
?>
