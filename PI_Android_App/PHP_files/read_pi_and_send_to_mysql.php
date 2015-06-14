<?php
//phpinfo();

//File to read
$file = '/sys/bus/w1/devices/28-00000595ecf1/';

//Read the file line by line
$lines = file($file);

//Get the temp from second line
$temp = explode('=', $lines[1]);

//Setup some nice formatting (i.e. 21,3)
$temp = number_format($temp[1] / 1000, 1, ',', '');

//And echo that temp
echo $temp . " °C";


?>

