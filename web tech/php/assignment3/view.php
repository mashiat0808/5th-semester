<html>
    <head>
    <style>
       .col-md-6{
            float:left;
            width:50%;     
        }
        img {
            height: 300px;
        }
        </style>
</head>

<body>

<?php
        // Check if the form was submitted
        if (isset($_POST['submit'])) {
            // Get the form data
            $firstName = $_POST['firstName'];
            $lastName = $_POST['lastName'];
            $email = $_POST['email'];
            $address = $_POST['address'];
            $photo = $_FILES['photo']['name'];

            // Validate the form data
            if (empty($firstName) || empty($lastName) || empty($email) || empty($address) || empty($photo)) {
                echo '<div class="alert alert-danger mt-3" role="alert">Please fill in all fields.</div>';
            } else {
                echo '
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                        <p><strong>First Name:</strong> '.$firstName.'</p>
                            <p><strong>Last Name:</strong> '.$lastName.'</p>
                            <p><strong>Email:</strong> '.$email.'</p>
                            <p><strong>Address:</strong> '.$address.'</p>
                            
                        </div>
                        <div class="col-md-6">
                        <img src="'.$photo.'" alt="Photo" >
                        </div>
                    </div>
                </div>';
            }
        }
    ?>





</body>
</html>