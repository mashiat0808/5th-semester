<html>
<body>


<?php
if( $_SERVER["REQUEST_METHOD"]== "POST"){
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "cw1";

    // Create connection
    $conn = mysqli_connect($servername, $username, $password, $dbname);
    // Check connection
    if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
    }
    $name =  $_POST['name'];
    $price= $_POST['price'];
    $sql = "INSERT INTO item (name, price)
    VALUES ( '$name',  $price)";

    if (mysqli_query($conn, $sql)) {
    echo "info added successfully";
    } else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
    }

    mysqli_close($conn);
}
?>
</body>
</html>