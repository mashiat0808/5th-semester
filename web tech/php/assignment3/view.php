<html>
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

                    // Output the form data
                    echo "First Name: $firstName<br>";
                    echo "Last Name: $lastName<br>";
                    echo "Email: $email<br>";
                    echo "Address: $address<br>";
                    echo "<img src= $photo>";
            }
        }
    ?>





</body>
</html>